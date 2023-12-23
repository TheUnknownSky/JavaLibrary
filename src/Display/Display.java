package Display;

import javax.swing.JOptionPane;

public class Display {
    public static void sqlError (String message){
        boolean debugMode = true;
        if (debugMode){
            JOptionPane.showMessageDialog(
                null, 
                "There is a problem connecting to the database.\n" + message, 
                "SQL Connection Error",
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                null, 
                "There is a problem connecting to the database.", 
                "SQL Connection Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    public static void updateSuccessfulOf(String word){
        JOptionPane.showMessageDialog(
            null, 
            "Your " + word + " has been successfully updated.", 
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
    public static void accountRegistrationSuccess(){
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
    public static void studentRegistrationSuccess(){
        JOptionPane.showMessageDialog(
            null,
            "Student has been registered.",
            "Registration Success",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void addGenreSuccessful(String genre_name){
        JOptionPane.showMessageDialog(
            null, 
            "The genre '" + genre_name + "' has been added.", 
            "Update Successful", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void addGenreNotSuccessfu(String genre_name){
        JOptionPane.showMessageDialog(
            null, 
            "The genre '" + genre_name + "' already exists.", 
            "Update Unsuccessful", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    public static void deleteGenreSuccessful(String genre_name){
        JOptionPane.showMessageDialog(
            null, 
            "The genre '" + genre_name + "' has been deleted.", 
            "Update Successful", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void deleteGenreNotSuccessful(String genre_name){
        JOptionPane.showMessageDialog(
            null, 
            "The genre '" + genre_name + "' doesn't exist.", 
            "Update Unsuccessful", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    public static void deleteStudentSuccessful(String id, String name){
        JOptionPane.showMessageDialog(
            null, 
            "Student '" + id + "' (" + name + ") has been deleted.", 
            "Update Successful", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void studentDoesNotExist(String id){
        JOptionPane.showMessageDialog(
            null, 
            "Student '" + id + "' does not exist.", 
            "Student Not Found", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    public static void bookAddedSuccessfully(String book){
        JOptionPane.showMessageDialog(
            null, 
            "Book '" + book + "' successfully added.", 
            "Update Successful", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void bookAlreadyExists(String book){
        JOptionPane.showMessageDialog(
            null, 
            "The book '" + book + "' already exists.", 
            "Registration failed", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    public static void deleteBookSuccessful(String book_title){
        JOptionPane.showMessageDialog(
            null, 
            "The book '" + book_title + "' has been deleted.", 
            "Update Successful", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void bookUpdatedSuccessfully(String book){
        JOptionPane.showMessageDialog(
            null, 
            "Book '" + book + "' successfully updated.", 
            "Update Successful", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void bookBorrowedSuccessfully(String book){
        JOptionPane.showMessageDialog(
            null, 
            "Book '" + book + "' successfully borrowed.", 
            "Update Successful", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    public static void apptAlreadyExists(){
        JOptionPane.showMessageDialog(
            null, 
            "Student already borrowed this book.", 
            "Appointment failed", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    public static void noSelectedAppt(){
        JOptionPane.showMessageDialog(
            null, 
            "You did not selected an appointment to delete.", 
            "Invalid Action", 
            JOptionPane.ERROR_MESSAGE
        );
    }
    public static void apptDeleteSuccess(){
        JOptionPane.showMessageDialog(
            null, 
            "Appointment successfully deleted.", 
            "Update Successful", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
