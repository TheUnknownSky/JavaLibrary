package Account;

import javax.swing.JOptionPane;
import DatabaseConnection.DBConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account extends DBConn{
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    private boolean registerAcctToDB(){
        try {
            PreparedStatement checkEmailIfExisting = conn().prepareStatement("SELECT libacct_email FROM lib_accounts WHERE libacct_email=?");
            checkEmailIfExisting.setString(1, this.email);
            ResultSet resultSet = checkEmailIfExisting.executeQuery();
            if(!resultSet.next()){
                PreparedStatement insertDetails = conn().prepareStatement(
                    "INSERT INTO lib_accounts (libacct_fname, libacct_lname, libacct_email, libacct_pword) VALUES (?,?,?,?)"
                );
                insertDetails.setString(1, this.firstname);
                insertDetails.setString(2, this.lastname);
                insertDetails.setString(3,this.email);
                insertDetails.setString(4, this.password);
                insertDetails.executeUpdate();
                return true;
            } else {
                JOptionPane.showMessageDialog(
                    null, 
                    "Account has been already registered.", 
                    "Registration failed", 
                    JOptionPane.ERROR_MESSAGE
                );
                return false;
            }

        } catch (SQLException e){
            JOptionPane.showMessageDialog(
                    null, 
                    e, 
                    "SQL Connection Error", 
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }
            
    public boolean setAccount(String firstname, String lastname, String email, String password, String confirmPassword){
        if (password.equals(confirmPassword)){
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.password = password;
            boolean access = registerAcctToDB();
            if(access){
                JOptionPane.showMessageDialog(
                    null,
                    "You may now log in your account.",
                    "Registration Success",
                    JOptionPane.INFORMATION_MESSAGE
                );
                return access;
            }
            return access;
        } else {
            JOptionPane.showMessageDialog(
                    null, 
                    "Password and Confirm Password does not match!", 
                    "Invalid Action", 
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }
    
    private boolean checkForAcctFromDB(String email, String password){
        try { 
            PreparedStatement checkAcct = conn().prepareStatement("SELECT libacct_email, libacct_pword FROM lib_accounts WHERE libacct_email=? AND libacct_pword=?");
            checkAcct.setString(1, email);
            checkAcct.setString(2, password);
            ResultSet resultSet = checkAcct.executeQuery();
            return resultSet.next();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(
                    null, 
                    "There is a problem connecting to the database.", 
                    "SQL Connection Error", 
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }
    
    public boolean login(String credential, String password){
        if (checkForAcctFromDB(credential, password)){
            JOptionPane.showMessageDialog(
                    null,
                    "Welcome to Library Managemenet System",
                    "Login Successful",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return true;
        } else {
            JOptionPane.showMessageDialog(
                    null, 
                    "Invalid Credentials, please try again.", 
                    "Invalid Action", 
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }
    
    public int returnLibacctIdOf (String email){
        try {
            PreparedStatement getAcctId = conn().prepareStatement("SELECT libacct_id FROM lib_accounts WHERE libacct_email=?");
            getAcctId.setString(1, email);
            ResultSet resultSet = getAcctId.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt("libacct_id");
            }    
        } catch (SQLException e){
            JOptionPane.showMessageDialog(
                    null, 
                    "There is a problem connecting to the database.", 
                    "SQL Connection Error", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
        // return lib acct id of the email
        return 69;
    }
    
    public String[] getAccountName (int id){
        String[] acct_name = {};
        try {
            PreparedStatement getAcctName = conn().prepareStatement("SELECT libacct_fname, libacct_lname FROM lib_accounts WHERE libacct_id = ?");
            getAcctName.setInt(1, id);
            ResultSet resultSet = getAcctName.executeQuery();
            if(resultSet.next()){
                acct_name = new String[]{resultSet.getString("libacct_fname"), resultSet.getString("libacct_lname")};
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(
                    null, 
                    "There is a problem connecting to the database.", 
                    "SQL Connection Error", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return acct_name;
    }
}
