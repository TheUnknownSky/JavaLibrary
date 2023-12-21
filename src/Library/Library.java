package Library;

import DatabaseConnection.DBConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Display.Display;
import java.util.Arrays;

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
    public void deleteGenre(int genre_id, String genre_name){
        try {
            PreparedStatement deleteGenre = conn().prepareStatement("DELETE FROM book_genre WHERE bg_id=?");
            deleteGenre.setInt(1, genre_id);
            deleteGenre.executeUpdate();
            PreparedStatement replaceGenre = conn().prepareStatement("UPDATE books SET book_genre=0 WHERE book_genre=?");
            replaceGenre.setInt(1, genre_id);
            replaceGenre.executeUpdate();
            Display.deleteGenreSuccessful(genre_name);    
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
    public boolean deleteStudent(String studentNumber){
        try {
            PreparedStatement checkStudent = conn().prepareStatement("SELECT * FROM students WHERE student_id=?");
            checkStudent.setString(1, studentNumber);
            ResultSet resultSet = checkStudent.executeQuery();
            if (resultSet.next()){
                PreparedStatement deleteStudent = conn().prepareStatement("DELETE FROM students WHERE student_id=?");
                deleteStudent.setString(1, resultSet.getString("student_id"));
                deleteStudent.executeUpdate();
                Display.deleteStudentSuccessful(studentNumber, resultSet.getString("student_name"));
                return true;
            } else {
                Display.studentDoesNotExist(studentNumber);
                return false;
            }
        } catch (SQLException e){
            Display.sqlError();;
            return false;
        }
    }
    public String[][] getBookGenres(){
        String[][] genres = new String[2][];
        String[] genre_names = {};
        String[] genre_ids = {};
        try {
            PreparedStatement getGenres = conn().prepareStatement("SELECT * FROM book_genre");
            ResultSet resultSet = getGenres.executeQuery();
            int i = 1;
            while (resultSet.next()){
                genre_ids = Arrays.copyOf(genre_ids, i);
                genre_names = Arrays.copyOf(genre_names, i);
                genre_ids[genre_ids.length - 1] = Integer.toString(resultSet.getInt("bg_id"));
                String genre_name = resultSet.getString("bg_name");
                genre_names[genre_names.length - 1] = genre_name.substring(0, 1).toUpperCase() + genre_name.substring(1);
                i++;
            }
            System.out.println(Arrays.toString(genre_ids));
            System.out.println(Arrays.toString(genre_names));
            genres[0] = genre_ids;
            genres[1] = genre_names;
        } catch (SQLException e){
            Display.sqlError();
        }
        return genres;
    }
    public boolean addBook(String title, String author, int genre, int count){
        try {
            PreparedStatement checkBook = conn().prepareStatement("SELECT book_id FROM books WHERE book_title=? AND book_author=?");
            checkBook.setString(1, title);
            checkBook.setString(2, author);
            ResultSet resultSet = checkBook.executeQuery();
            if (!resultSet.next()){
                PreparedStatement addBook = conn().prepareStatement("INSERT INTO books (book_title, book_author, book_genre, book_count) VALUES (?, ?, ?, ?)");
                addBook.setString(1, title);
                addBook.setString(2, author);
                addBook.setInt(3, genre);
                addBook.setInt(4, count);
                addBook.executeUpdate();
                Display.bookAddedSuccessfully(title);
                return true;
            } else {
                Display.bookAlreadyExists(title);
                return false;
            }
        } catch (SQLException e){
            Display.sqlError();
            return false;
        }
    }
}
