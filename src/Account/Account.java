package Account;

import DatabaseConnection.DBConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Display.Popups;
import java.sql.Connection;
import java.sql.DriverManager;
import Models.User;

public class Account extends DBConn{
    private boolean registerAcctToDB(User user){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement checkEmailIfExisting = conn.prepareStatement("SELECT libacct_email FROM lib_accounts WHERE libacct_email=?");
            checkEmailIfExisting.setString(1, user.getEmail());
            ResultSet resultSet = checkEmailIfExisting.executeQuery();
            if(!resultSet.next()){
                PreparedStatement insertDetails = conn.prepareStatement(
                    "INSERT INTO lib_accounts (libacct_fname, libacct_lname, libacct_email, libacct_pword) VALUES (?,?,?,?)"
                );
                insertDetails.setString(1, user.getFirstname());
                insertDetails.setString(2, user.getLastname());
                insertDetails.setString(3, user.getEmail());
                insertDetails.setString(4, user.getPassword());
                insertDetails.executeUpdate();
                conn.close();
                return true;
            } else {
                Popups.accountAlreadyExists();
                return false;
            }
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
            return false;
        }
    }
            
    public boolean setAccount(User user){
        if (user.getPassword().equals(user.getConfirmPassword())){
            boolean access = registerAcctToDB(user);
            if(access){
                Popups.accountRegistrationSuccess();
                return access;
            }
            return access;
        } else {
            Popups.passwordAndConfirmPasswordNotMatch();
            return false;
        }
    }
    
    private boolean checkForAcctFromDB(User user){
        try { 
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement checkAcct = conn.prepareStatement("SELECT libacct_email, libacct_pword FROM lib_accounts WHERE libacct_email=? AND libacct_pword=?");
            checkAcct.setString(1, user.getEmail());
            checkAcct.setString(2, user.getPassword());
            ResultSet resultSet = checkAcct.executeQuery();
            boolean result = resultSet.next();
            conn.close();
            return result;
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
            return false;
        }
    }
    
    public boolean login(User user){
        if (checkForAcctFromDB(user)){
            Popups.loginSuccess();
            return true;
        } else {
            Popups.invalidCredentials();
            return false;
        }
    }
    
    public int returnLibacctIdOf (User user){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement getAcctId = conn.prepareStatement("SELECT libacct_id FROM lib_accounts WHERE libacct_email=?");
            getAcctId.setString(1, user.getEmail());
            ResultSet resultSet = getAcctId.executeQuery();
            if(resultSet.next()){
                int id = resultSet.getInt("libacct_id");
                conn.close();
                return id;
            } 
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
        // return lib acct id of the email
        return 0;
    }
    
    public String[] getAccountName(User user){
        String[] acct_name = {};
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement getAcctName = conn.prepareStatement("SELECT libacct_fname, libacct_lname FROM lib_accounts WHERE libacct_id = ?");
            getAcctName.setInt(1, user.getUserId());
            ResultSet resultSet = getAcctName.executeQuery();
            if(resultSet.next()){
                acct_name = new String[]{resultSet.getString("libacct_fname"), resultSet.getString("libacct_lname")};
            }
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
        return acct_name;
    }
    public String getEmail (User user){
        String acct_email = "";
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement getEmail = conn.prepareStatement("SELECT libacct_email FROM lib_accounts WHERE libacct_id=?");
            getEmail.setInt(1, user.getUserId());
            ResultSet resultSet = getEmail.executeQuery();
            resultSet.next();
            acct_email = resultSet.getString("libacct_email");
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
        return acct_email;
    }
    public void editName(User user){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement editName = conn.prepareStatement("UPDATE lib_accounts SET libacct_fname=?, libacct_lname=? WHERE libacct_id=?");
            editName.setString(1, user.getFirstname());
            editName.setString(2, user.getLastname());
            editName.setInt(3, user.getUserId());
            editName.executeUpdate();
            Popups.updateSuccessfulOf("name");
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
    }
    public void editEmail(User user){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement editEmail = conn.prepareStatement("UPDATE lib_accounts SET libacct_email=? WHERE libacct_id=?");
            editEmail.setString(1, user.getEmail());
            editEmail.setInt(2, user.getUserId());
            editEmail.executeUpdate();
            Popups.updateSuccessfulOf("email");
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
    }
    public void editPassword(User user){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement editPassword = conn.prepareStatement("UPDATE lib_accounts SET libacct_pword=? WHERE libacct_id=?");
            editPassword.setString(1, user.getPassword());
            editPassword.setInt(2, user.getUserId());
            editPassword.executeUpdate();
            Popups.updateSuccessfulOf("password");
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
    }
    public boolean checkPassword(User user){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement checkPassword = conn.prepareStatement("SELECT libacct_pword FROM lib_accounts WHERE libacct_id=?");
            checkPassword.setInt(1, user.getUserId());
            ResultSet resultSet = checkPassword.executeQuery();
            resultSet.next();
            boolean check = resultSet.getString("libacct_pword").equals(user.getPassword());
            conn.close();
            return check;
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
            return false;
        }
    }
}
