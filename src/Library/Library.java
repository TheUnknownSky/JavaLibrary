package Library;

import DatabaseConnection.DBConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import Display.Display;
import java.text.SimpleDateFormat;
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
            Display.sqlError(e.getMessage());
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
            Display.sqlError(e.getMessage());
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
            Display.sqlError(e.getMessage());
        }
    }
    public boolean checkStudentIfExisting(String studentNumber){
        try {
            PreparedStatement checkStudent = conn().prepareStatement("SELECT * FROM students WHERE student_id=?");
            checkStudent.setString(1, studentNumber);
            ResultSet resultSet = checkStudent.executeQuery();
            if(resultSet.next()){
                return true;
            } else {
                Display.studentDoesNotExist(studentNumber);
                return false;
            }
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
            return false;
        }
    }
    public boolean deleteStudent(String studentNumber){
        try {
            PreparedStatement checkStudent = conn().prepareStatement("SELECT * FROM students WHERE student_id=?");
            checkStudent.setString(1, studentNumber);
            ResultSet resultSet = checkStudent.executeQuery();
            if (checkStudentIfExisting(studentNumber)){
                PreparedStatement deleteStudent = conn().prepareStatement("DELETE FROM students WHERE student_id=?");
                deleteStudent.setString(1, resultSet.getString("student_id"));
                deleteStudent.executeUpdate();
                Display.deleteStudentSuccessful(studentNumber, resultSet.getString("student_name"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
            return false;
        }
    }
    public String getStudentName(String student_id){
        try {
            PreparedStatement getStuName = conn().prepareStatement("SELECT student_name FROM students WHERE student_id=?");
            getStuName.setString(1, student_id);
            ResultSet resultSet = getStuName.executeQuery();
            resultSet.next();
            return resultSet.getString("student_name");
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
            return "";
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
            genres[0] = genre_ids;
            genres[1] = genre_names;
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
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
            Display.sqlError(e.getMessage());
            return false;
        }
    }
    public void editBook(int id, String book_title, String book_author, int book_genre, int book_count){
        try {
            PreparedStatement editBook = conn().prepareStatement("UPDATE books SET book_title=?, book_author=?, book_genre=?, book_count=? WHERE book_id=?");
            editBook.setString(1, book_title);
            editBook.setString(2, book_author);
            editBook.setInt(3, book_genre);
            editBook.setInt(4, book_count);
            editBook.setInt(5, id);
            editBook.executeUpdate();
            System.out.println(id + " " + book_title + " " + book_author + " " + book_genre + " " + book_count);
            Display.bookUpdatedSuccessfully(book_title);
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
        }
    }
    public String getBookName (int bookId){
        try {
            PreparedStatement getBookName = conn().prepareStatement("SELECT book_title FROM books WHERE book_id=?");
            getBookName.setInt(1, bookId);
            ResultSet resultSet = getBookName.executeQuery();
            resultSet.next();
            System.out.println(resultSet.getString("book_title"));
            return resultSet.getString("book_title");
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
            return "";
        }
    }
    public String[][] getBookList(boolean to_borrow){
        String[][] books = new String[2][];
        String[] book_titles = {};
        String[] book_ids = {};
        try {
            String query;
            if(to_borrow){
                query = "SELECT book_id, book_title, book_author FROM books WHERE book_count > 0 ORDER BY book_title";
            } else {
                query = "SELECT book_id, book_title, book_author FROM books ORDER by book_title";
            }
            PreparedStatement getBooks = conn().prepareStatement(query);
            ResultSet resultSet = getBooks.executeQuery();
            for(int i = 1; resultSet.next(); i++){
                book_ids = Arrays.copyOf(book_ids, i);
                book_titles = Arrays.copyOf(book_titles, i);
                book_ids[book_ids.length - 1] = Integer.toString(resultSet.getInt("book_id"));
                String book_title = resultSet.getString("book_title") + " (" + resultSet.getString("book_author") + ")";
                book_titles[book_titles.length - 1] = book_title;
            }
            books[0] = book_ids;
            books[1] = book_titles;
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
        }
        return books;
    }
    public String[] searchBookList(String toSearch){
        String[] book_titles = {};
        try {
            PreparedStatement searchBooks = conn().prepareStatement("SELECT book_title, book_author, book_count FROM books WHERE book_title LIKE '%" + toSearch + "%' OR book_author LIKE '%" + toSearch + "%' ORDER BY book_title");
            ResultSet resultSet = searchBooks.executeQuery();
            for(int i = 1; resultSet.next(); i++){
                book_titles = Arrays.copyOf(book_titles, i);
                String book_title = resultSet.getString("book_title") + " (" + resultSet.getString("book_author") + ")";
                if (resultSet.getInt("book_count") == 0){
                    book_title = book_title + " - Unavailable";
                }
                book_titles[book_titles.length - 1] = book_title;
            }
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
        }
        return book_titles;
    }
    public String[] getBookDetails(int bookId){
        String[] bookDetails = new String[4];
        try {
            PreparedStatement getDetails = conn().prepareStatement("SELECT book_title, book_author, book_genre, book_count FROM books WHERE book_id=? ORDER BY book_title");
            getDetails.setInt(1, bookId);
            ResultSet resultSet = getDetails.executeQuery();
            resultSet.next();
            bookDetails[0] = resultSet.getString("book_title");
            bookDetails[1] = resultSet.getString("book_author");
            bookDetails[2] = Integer.toString(resultSet.getInt("book_genre"));
            bookDetails[3] = Integer.toString(resultSet.getInt("book_count"));
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
        }
        return bookDetails;
    }
    public void deleteBook(int book_id, String book_name){
        try {
            // you cant delete book if it has existing appointment
            PreparedStatement deleteBook = conn().prepareStatement("DELETE FROM books WHERE book_id=?");
            deleteBook.setInt(1, book_id);
            deleteBook.executeUpdate();
            Display.deleteBookSuccessful(book_name);
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
        }
    }
    public boolean checkIfApptExisting(int bookId, String studentId){
        try {
            PreparedStatement checkAppt = conn().prepareStatement("SELECT appt_id FROM appointments WHERE book_id=? AND student_id=?");
            checkAppt.setInt(1, bookId);
            checkAppt.setString(2, studentId);
            ResultSet resultSet = checkAppt.executeQuery();
            if (resultSet.next()){
                return true;
            } else {
                return false;
            }
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
            return false;
        }
    }
    public void reduceBookCount(int bookId){
        try {
            PreparedStatement getBookCount = conn().prepareStatement("SELECT book_count FROM books WHERE book_id=?");
            getBookCount.setInt(1, bookId);
            ResultSet resultSet = getBookCount.executeQuery();
            resultSet.next();
            int newBookCount = resultSet.getInt("book_count") - 1;
            PreparedStatement replaceBookCount = conn().prepareStatement("UPDATE books SET book_count=? WHERE book_id=?");
            replaceBookCount.setInt(1, newBookCount);
            replaceBookCount.setInt(2, bookId);
            replaceBookCount.executeUpdate();
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    public boolean borrowBook(int bookId, String studentId){
        try {
            if (checkStudentIfExisting(studentId)){
                if(!checkIfApptExisting(bookId, studentId)){
                    PreparedStatement borrowBook = conn().prepareStatement("INSERT INTO appointments (book_id, student_id, appt_date_borrow) VALUES (?, ?, DEFAULT)");
                    borrowBook.setInt(1, bookId);
                    borrowBook.setString(2, studentId);
                    borrowBook.executeUpdate();
                    reduceBookCount(bookId);
                    return true;
                } else {
                    Display.apptAlreadyExists();
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
            return false;
        }
    }
    public String[][] getAppointmentsDetails(String orderBy){
        String[][] appointments = {};
        try {
            PreparedStatement getAppt = conn().prepareStatement("SELECT * FROM appointments ORDER BY " + orderBy);
            ResultSet resultSet = getAppt.executeQuery();
            for (int i = 1; resultSet.next(); i++){
                String[] appt = new String[4];
                appt[0] = getBookName(resultSet.getInt("book_id"));
                appt[1] = getStudentName(resultSet.getString("student_id"));
                appt[2] = formatTimestampAsString(resultSet.getTimestamp("appt_date_borrow"));
                appt[3] = Integer.toString(resultSet.getInt("appt_id"));
                appointments = Arrays.copyOf(appointments, i);
                appointments[appointments.length - 1] = appt;
            }
            for (int j=0; j < appointments.length; j++){
                System.out.println(Arrays.toString(appointments[j]));
            }
        } catch(SQLException e){
            Display.sqlError(e.getMessage());
        }
        return appointments;
    }
    public String[][] getAppointmentsById(String orderBy){
        String[][] appointments = {};
        try {
            PreparedStatement getAppt = conn().prepareStatement("SELECT * FROM appointments ORDER BY " + orderBy);
            ResultSet resultSet = getAppt.executeQuery();
            for (int i = 1; resultSet.next(); i++){
                String[] appt = new String[4];
                appt[0] = getBookName(resultSet.getInt("book_id"));
                appt[1] = getStudentName(resultSet.getString("student_id"));
                appt[2] = formatTimestampAsString(resultSet.getTimestamp("appt_date_borrow"));
                appt[3] = Integer.toString(resultSet.getInt("appt_id"));
                appointments = Arrays.copyOf(appointments, i);
                appointments[appointments.length - 1] = appt;
            }
            for (int j=0; j < appointments.length; j++){
                System.out.println(Arrays.toString(appointments[j]));
            }
        } catch(SQLException e){
            Display.sqlError(e.getMessage());
        }
        return appointments;
    }
    private static String formatTimestampAsString(Timestamp timestamp) {
        // Use SimpleDateFormat to format the timestamp as a String
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(timestamp);
    }
    public boolean deleteAppointment(int appt_id){
        try {
            PreparedStatement deleteAppt = conn().prepareStatement("DELETE FROM appointments WHERE appt_id=?");
            deleteAppt.setInt(1, appt_id);
            deleteAppt.executeUpdate();
            Display.apptDeleteSuccess();
            return true;
        } catch (SQLException e){
            Display.sqlError(e.getMessage());
            return false;
        }
    }
}
