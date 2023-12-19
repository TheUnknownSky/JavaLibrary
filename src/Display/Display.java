package Display;

import javax.swing.JOptionPane;

public class Display {
    public static void sqlError (){
        JOptionPane.showMessageDialog(
            null, 
            "There is a problem connecting to the database.", 
            "SQL Connection Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
    public static void nameUpdateSuccessful(){
        JOptionPane.showMessageDialog(
            null, 
            "Your name has been successfully updated.", 
            "Update Successful",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void invalidCredentials(){
        JOptionPane.showMessageDialog(
            null, 
            "Invalid Credentials, please try again.", 
            "Invalid Action", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    public static void loginSuccess(){
        JOptionPane.showMessageDialog(
            null,
            "Welcome to Library Managemenet System",
            "Login Successful",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void passwordAndConfirmPasswordNotMatch(){
        JOptionPane.showMessageDialog(
            null, 
            "Password and Confirm Password does not match!", 
            "Invalid Action", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    public static void registrationSuccess(){
        JOptionPane.showMessageDialog(
            null,
            "You may now log in your account.",
            "Registration Success",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void accountAlreadyExists(){
        JOptionPane.showMessageDialog(
            null, 
            "Account has been already registered.", 
            "Registration failed", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    public static void passwordNotMatch(){
        JOptionPane.showMessageDialog(
            null, 
            "Password does not match!", 
            "Invalid Action", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    public static void insufficientDetails(){
        JOptionPane.showMessageDialog(
            null, 
            "Please fill out the required details.", 
            "Insufficient Details", 
            JOptionPane.ERROR_MESSAGE
        );
    }
}
