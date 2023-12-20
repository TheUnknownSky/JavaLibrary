package Library;

import DatabaseConnection.DBConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Display.Display;

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
                Display.addGenreSuccessful(genre_name);
            } else {
                Display.addGenreNotSuccessfu(genre_name);
            } 
        } catch (SQLException e){
            Display.sqlError();
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
                Display.deleteGenreSuccessful(genre_name);
            } else {
                Display.deleteGenreNotSuccessful(genre_name);
            }
        } catch (SQLException e){
            Display.sqlError();
        }
    }
    public void registerStudent (String studentNumber, String name){
        try {
            PreparedStatement regStudent = conn().prepareStatement("INSERT INTO students VALUES (?, ?)");
            regStudent.setString(1, studentNumber);
            regStudent.setString(2, name);
            regStudent.executeUpdate();
            Display.studentRegistrationSuccess();
        } catch (SQLException e){
            Display.sqlError();
        }
    }
}
