package Account;

import DatabaseConnection.DBConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Display.Display;

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
                Display.accountAlreadyExists();
                return false;
            }

        } catch (SQLException e){
            Display.sqlError();
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
                Display.registrationSuccess();
                return access;
            }
            return access;
        } else {
            Display.passwordAndConfirmPasswordNotMatch();
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
            Display.sqlError();
            return false;
        }
    }
    
    public boolean login(String credential, String password){
        if (checkForAcctFromDB(credential, password)){
            Display.loginSuccess();
            return true;
        } else {
            Display.invalidCredentials();
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
            Display.sqlError();
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
            Display.sqlError();
        }
        return acct_name;
    }
    public String getEmail (int id){
        String acct_email = "";
        try {
            PreparedStatement getEmail = conn().prepareStatement("SELECT libacct_email FROM lib_accounts WHERE libacct_id=?");
            getEmail.setInt(1, id);
            ResultSet resultSet = getEmail.executeQuery();
            resultSet.next();
            acct_email = resultSet.getString("libacct_email");
        } catch (SQLException e){
            Display.sqlError();
        }
        return acct_email;
    }
    public void editName(int id, String firstName, String lastName){
        try {
            PreparedStatement editName = conn().prepareStatement("UPDATE lib_accounts SET libacct_fname=?, libacct_lname=? WHERE libacct_id=?");
            editName.setString(1, firstName);
            editName.setString(2, lastName);
            editName.setInt(3, id);
            editName.executeUpdate();
            Display.updateSuccessfulOf("name");
        } catch (SQLException e){
            Display.sqlError();
        }
    }
    public void editEmail(int id, String email){
        try {
            PreparedStatement editEmail = conn().prepareStatement("UPDATE lib_accounts SET libacct_email=? WHERE libacct_id=?");
            editEmail.setString(1, email);
            editEmail.setInt(2, id);
            editEmail.executeUpdate();
            Display.updateSuccessfulOf("email");
        } catch (SQLException e){
            Display.sqlError();
        }
    }
    public boolean checkPassword(int id, String password){
        try {
            PreparedStatement checkPassword = conn().prepareStatement("SELECT libacct_pword FROM lib_accounts WHERE libacct_id=?");
            checkPassword.setInt(1, id);
            ResultSet resultSet = checkPassword.executeQuery();
            resultSet.next();
            return resultSet.getString("libacct_pword").equals(password);
        } catch (SQLException e){
            Display.sqlError();
            return false;
        }
    }
}
