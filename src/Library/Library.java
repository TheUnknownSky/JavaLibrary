package Library;

import javax.swing.JOptionPane;
import DatabaseConnection.DBConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Library extends DBConn {
    
    public void addGenre(String genre_name){
        try {
            PreparedStatement checkGenreIfExisting = conn().prepareStatement("SELECT bg_id FROM book_genre WHERE bg_name=?");
            checkGenreIfExisting.setString(1, genre_name.toLowerCase());
            ResultSet resultSet = checkGenreIfExisting.executeQuery();
            if (!resultSet.next()){
                PreparedStatement addGenre = conn().prepareStatement("INSERT INTO book_genre (bg_name) VALUES (?);");
                addGenre.setString(1, genre_name.toLowerCase());
                addGenre.executeUpdate();
                JOptionPane.showMessageDialog(
                    null, 
                    "The genre '" + genre_name + "' has been added.", 
                    "Update Successful", 
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                    null, 
                    "The genre '" + genre_name + "' already exists.", 
                    "Update Unsuccessful", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(
                    null, 
                    "There is a problem connecting to the database.", 
                    "SQL Connection Error", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void deleteGenre(String genre_name){
        try {
            PreparedStatement checkGenreIfExisting = conn().prepareStatement("SELECT bg_id FROM book_genre WHERE bg_name=?");
            checkGenreIfExisting.setString(1, genre_name.toLowerCase());
            ResultSet resultSet = checkGenreIfExisting.executeQuery();
            if(resultSet.next()){
                PreparedStatement deleteGenre = conn().prepareStatement("DELETE FROM book_genre WHERE bg_name=?");
                deleteGenre.setString(1, genre_name.toLowerCase());
                deleteGenre.executeUpdate();
                JOptionPane.showMessageDialog(
                    null, 
                    "The genre '" + genre_name + "' has been deleted.", 
                    "Update Successful", 
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                    null, 
                    "The genre '" + genre_name + "' doesn't exist.", 
                    "Update Unsuccessful", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(
                    null, 
                    "There is a problem connecting to the database.", 
                    "SQL Connection Error", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
}
