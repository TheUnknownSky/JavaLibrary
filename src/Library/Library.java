package Library;

import DatabaseConnection.DBConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import Display.Popups;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import Models.Book;
import Models.Student;

public class Library extends DBConn {
    public void addGenre(Book book){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement checkGenreIfExisting = conn.prepareStatement("SELECT bg_id, enabled FROM book_genre WHERE bg_name=?");
            checkGenreIfExisting.setString(1, book.getGenre_name().toLowerCase());
            ResultSet resultSet = checkGenreIfExisting.executeQuery();
            if (!resultSet.next()){
                PreparedStatement addGenre = conn.prepareStatement("INSERT INTO book_genre (bg_name, enabled) VALUES (?, DEFAULT);");
                addGenre.setString(1, book.getGenre_name().toLowerCase());
                addGenre.executeUpdate();
                Popups.addGenreSuccessful(book.getGenre_name());
                conn.close();
            } else if (resultSet.getInt("enabled") == 0){
                PreparedStatement enable = conn.prepareStatement("UPDATE book_genre SET enabled=1 WHERE bg_id=?");
                enable.setInt(1, resultSet.getInt("bg_id"));
                enable.executeUpdate();
                Popups.addGenreSuccessful(book.getGenre_name());
                conn.close();
            } else {
                conn.close();
                Popups.addGenreNotSuccessfu(book.getGenre_name());
            } 
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
    }
    public void deleteGenre(Book book){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement deleteGenre = conn.prepareStatement("UPDATE book_genre SET enabled=0 WHERE bg_id=?");
            deleteGenre.setInt(1, book.getGenre_id());
            deleteGenre.executeUpdate();
            Popups.deleteGenreSuccessful(book.getGenre_name()); 
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
    }
    public void registerStudent (Student stu){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement checkStudent = conn.prepareStatement("SELECT * FROM students WHERE student_id=?");
            checkStudent.setString(1, stu.getStudentId());
            ResultSet resultSet = checkStudent.executeQuery();
            if (!resultSet.next()){
                PreparedStatement regStudent = conn.prepareStatement("INSERT INTO students VALUES (?, ?, DEFAULT)");
                regStudent.setString(1, stu.getStudentId());
                regStudent.setString(2, stu.getStudentName());
                regStudent.executeUpdate();
                Popups.studentRegistrationSuccess();
                conn.close();
            } else if (resultSet.getInt("enabled") == 0){
                PreparedStatement regStudent = conn.prepareStatement("UPDATE students SET student_name=?, enabled=1 WHERE student_id=?");
                regStudent.setString(1, stu.getStudentName());
                regStudent.setString(2, stu.getStudentId());
                regStudent.executeUpdate();
                Popups.studentRegistrationSuccess();
                conn.close();
            }
            else {
                Popups.studentAlreadyExists(stu.getStudentId());
                conn.close();
            }
            // checkStudentIfExisting
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
    }
    public boolean checkStudentIfExisting(String studentNumber){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement checkStudent = conn.prepareStatement("SELECT * FROM students WHERE student_id=?");
            checkStudent.setString(1, studentNumber);
            ResultSet resultSet = checkStudent.executeQuery();
            if(resultSet.next()){
                conn.close();
                return true;
            } else {
                conn.close();
                Popups.studentDoesNotExist(studentNumber);
                return false;
            }
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
            return false;
        }
    }
    public boolean deleteStudent(Student stu){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement checkStudent = conn.prepareStatement("SELECT * FROM students WHERE student_id=? AND enabled=1");
            checkStudent.setString(1, stu.getStudentId());
            ResultSet resultSet = checkStudent.executeQuery();
            if (resultSet.next()){
                PreparedStatement deleteStudent = conn.prepareStatement("UPDATE students SET enabled=0 WHERE student_id=?");
                deleteStudent.setString(1, resultSet.getString("student_id"));
                deleteStudent.executeUpdate();
                Popups.deleteStudentSuccessful(stu.getStudentId(), resultSet.getString("student_name"));
                return true;
            } else {
                Popups.studentDoesNotExist(stu.getStudentId());
                conn.close();
                return false;
            }
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
            return false;
        }
    }
    public String getStudentName(String student_id){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement getStuName = conn.prepareStatement("SELECT student_name FROM students WHERE student_id=?");
            getStuName.setString(1, student_id);
            ResultSet resultSet = getStuName.executeQuery();
            resultSet.next();
            String student_name = resultSet.getString("student_name");
            conn.close();
            return student_name;
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
            return "";
        }
    }
    public String[][] getBookGenres(){
        String[][] genres = new String[2][];
        String[] genre_names = {};
        String[] genre_ids = {};
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement getGenres = conn.prepareStatement("SELECT * FROM book_genre WHERE enabled=1 ORDER BY bg_name");
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
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
        return genres;
    }
    public boolean addBook(String title, String author, int genre, int count){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement checkBook = conn.prepareStatement("SELECT book_id, enabled FROM books WHERE book_title=? AND book_author=?");
            checkBook.setString(1, title);
            checkBook.setString(2, author);
            ResultSet resultSet = checkBook.executeQuery();
            if (!resultSet.next()){
                PreparedStatement addBook = conn.prepareStatement("INSERT INTO books (book_title, book_author, book_genre, book_count, enabled) VALUES (?, ?, ?, ?, DEFAULT)");
                addBook.setString(1, title);
                addBook.setString(2, author);
                addBook.setInt(3, genre);
                addBook.setInt(4, count);
                addBook.executeUpdate();
                Popups.bookAddedSuccessfully(title);
                conn.close();
                return true;
            } else if (resultSet.getInt("enabled") == 0) {
                PreparedStatement enable = conn.prepareStatement("UPDATE books SET book_genre=?, book_count=?, enabled=1 WHERE book_id=?");
                enable.setInt(1, genre);
                enable.setInt(2, count);
                enable.setInt(3, resultSet.getInt("book_id"));
                enable.executeUpdate();
                Popups.bookAddedSuccessfully(title);
                conn.close();
                return true;
            } else {
                Popups.bookAlreadyExists(title);
                conn.close();
                return false;
            }
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
            return false;
        }
    }
    public void editBook(int id, String book_title, String book_author, int book_genre, int book_count){
        try {
            
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password);
            PreparedStatement editBook = conn.prepareStatement("UPDATE books SET book_title=?, book_author=?, book_genre=?, book_count=? WHERE book_id=?");
            editBook.setString(1, book_title);
            editBook.setString(2, book_author);
            editBook.setInt(3, book_genre);
            editBook.setInt(4, book_count);
            editBook.setInt(5, id);
            editBook.executeUpdate();
            Popups.bookUpdatedSuccessfully(book_title);
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
    }
    public String getBookName (int bookId){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement getBookName = conn.prepareStatement("SELECT book_title FROM books WHERE book_id=?");
            getBookName.setInt(1, bookId);
            ResultSet resultSet = getBookName.executeQuery();
            resultSet.next();
            String bookName = resultSet.getString("book_title");
            conn.close();
            return bookName;
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
            return "";
        }
    }
    public String[][] getBookListForTable(String toSearch){
        String[][] booklist = {};
        try {
            String query;
            if (!toSearch.isEmpty()){
                query = "SELECT * FROM books WHERE enabled=1 AND book_title LIKE '%" + toSearch + "%' OR book_author LIKE '%" + toSearch + "%' ORDER BY book_title ASC";
            } else {
                query = "SELECT * FROM books WHERE enabled=1 ORDER BY book_title ASC";
            }
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement returnBookList = conn.prepareStatement(query);
            ResultSet resultSet = returnBookList.executeQuery();
            for(int i = 1; resultSet.next(); i++){
                String[] bookDetails = new String[6]; // title, author, genre, count, availability, id
                bookDetails[0] = resultSet.getString("book_title");
                bookDetails[1] = resultSet.getString("book_author");
                PreparedStatement returnGenreName = conn.prepareStatement("SELECT bg_name FROM book_genre WHERE bg_id=?");
                returnGenreName.setInt(1, resultSet.getInt("book_genre"));
                ResultSet genre_name = returnGenreName.executeQuery();
                genre_name.next();
                String genre = genre_name.getString("bg_name");
                bookDetails[2] = genre.substring(0, 1).toUpperCase() + genre.substring(1);
                bookDetails[3] = Integer.toString(resultSet.getInt("book_count"));
                if(resultSet.getInt("book_count") > 0){
                    bookDetails[4] = "Available";
                } else {
                    bookDetails[4] = "Unavailable";;
                }
                bookDetails[5] = Integer.toString(resultSet.getInt("book_id"));
                booklist = Arrays.copyOf(booklist, i);
                booklist[booklist.length - 1] = bookDetails;
            }
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
        return booklist;
    }
    public String[] getBookDetails(int bookId){
        String[] bookDetails = new String[4];
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement getDetails = conn.prepareStatement("SELECT book_title, book_author, book_genre, book_count FROM books WHERE book_id=? ORDER BY book_title");
            getDetails.setInt(1, bookId);
            ResultSet resultSet = getDetails.executeQuery();
            resultSet.next();
            bookDetails[0] = resultSet.getString("book_title");
            bookDetails[1] = resultSet.getString("book_author");
            bookDetails[2] = Integer.toString(resultSet.getInt("book_genre"));
            bookDetails[3] = Integer.toString(resultSet.getInt("book_count"));
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
        return bookDetails;
    }
    public void deleteBook(int book_id, String book_name){
        try {
            // you cant delete book if it has existing appointment
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement checkBookInAppt = conn.prepareStatement("SELECT book_id FROM appointments WHERE book_id=?");
            checkBookInAppt.setInt(1, book_id);
            ResultSet result = checkBookInAppt.executeQuery();
            if(!result.next()){
                PreparedStatement deleteBook = conn.prepareStatement("UPDATE books SET enabled=0 WHERE book_id=?");
                deleteBook.setInt(1, book_id);
                deleteBook.executeUpdate();
                Popups.deleteBookSuccessful(book_name);
            } else {
                Popups.bookExistsInAppt();
            }
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
    }
    public boolean checkIfApptExisting(int bookId, String studentId){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement checkAppt = conn.prepareStatement("SELECT appt_id FROM appointments WHERE book_id=? AND student_id=?");
            checkAppt.setInt(1, bookId);
            checkAppt.setString(2, studentId);
            ResultSet resultSet = checkAppt.executeQuery();
            if (resultSet.next()){
                conn.close();
                return true;
            } else {
                conn.close();
                return false;
            }
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
            return false;
        }
    }
    public void reduceBookCount(int bookId){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement getBookCount = conn.prepareStatement("SELECT book_count FROM books WHERE book_id=?");
            getBookCount.setInt(1, bookId);
            ResultSet resultSet = getBookCount.executeQuery();
            resultSet.next();
            int newBookCount = resultSet.getInt("book_count") - 1;
            PreparedStatement replaceBookCount = conn.prepareStatement("UPDATE books SET book_count=? WHERE book_id=?");
            replaceBookCount.setInt(1, newBookCount);
            replaceBookCount.setInt(2, bookId);
            replaceBookCount.executeUpdate();
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
    }
    public void addBookCount(int bookId){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement getBookCount = conn.prepareStatement("SELECT book_count FROM books WHERE book_id=?");
            getBookCount.setInt(1, bookId);
            ResultSet resultSet = getBookCount.executeQuery();
            resultSet.next();
            int newBookCount = resultSet.getInt("book_count") + 1;
            PreparedStatement replaceBookCount = conn.prepareStatement("UPDATE books SET book_count=? WHERE book_id=?");
            replaceBookCount.setInt(1, newBookCount);
            replaceBookCount.setInt(2, bookId);
            replaceBookCount.executeUpdate();
            conn.close();
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
        }
    }
    public boolean borrowBook(int bookId, String studentId){
        try {
            if (checkStudentIfExisting(studentId)){
                if(!checkIfApptExisting(bookId, studentId)){
                    Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
                    PreparedStatement borrowBook = conn.prepareStatement("INSERT INTO appointments (book_id, student_id, appt_date_borrow) VALUES (?, ?, DEFAULT)");
                    borrowBook.setInt(1, bookId);
                    borrowBook.setString(2, studentId);
                    borrowBook.executeUpdate();
                    reduceBookCount(bookId);
                    conn.close();
                    return true;
                } else {
                    Popups.apptAlreadyExists();
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
            return false;
        }
    }
    public String[][] getAppointmentsDetails(String orderBy){
        String[][] appointments = {};
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement getAppt = conn.prepareStatement("SELECT * FROM appointments ORDER BY " + orderBy);
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
            conn.close();
        } catch(SQLException e){
            Popups.sqlError(e.getMessage());
        }
        return appointments;
    }
    public String[][] getAppointmentsById(String orderBy){
        String[][] appointments = {};
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password);  
            PreparedStatement getAppt = conn.prepareStatement("SELECT * FROM appointments ORDER BY " + orderBy);
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
            conn.close();
        } catch(SQLException e){
            Popups.sqlError(e.getMessage());
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
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password); 
            PreparedStatement getAppt = conn.prepareStatement("SELECT * FROM appointments WHERE appt_id=?");
            getAppt.setInt(1, appt_id);
            ResultSet resultSet = getAppt.executeQuery();
            resultSet.next();
            System.out.println("1");
            PreparedStatement setFinAppt = conn.prepareStatement("INSERT INTO finished_appointments (book_id, student_id, appt_date_borrow, appt_date_return, enabled) VALUES (?, ?, ?, DEFAULT, 0)");
            setFinAppt.setInt(1, resultSet.getInt("book_id"));
            setFinAppt.setString(2, resultSet.getString("student_id"));
            setFinAppt.setTimestamp(3, resultSet.getTimestamp("appt_date_borrow"));
            setFinAppt.executeUpdate();
            System.out.println("2");
            PreparedStatement getBookId = conn.prepareStatement("SELECT book_id FROM appointments WHERE appt_id=?");
            getBookId.setInt(1, appt_id);
            ResultSet result = getBookId.executeQuery();
            result.next();
            System.out.println("3");
            addBookCount(result.getInt("book_id"));
            PreparedStatement deleteAppt = conn.prepareStatement("DELETE FROM appointments WHERE appt_id=?");
            deleteAppt.setInt(1, appt_id);
            deleteAppt.executeUpdate();
            
            Popups.apptDeleteSuccess();
            conn.close();
            return true;
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
            return false;
        }
    }
    public boolean finishAppointment(int appt_id){
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password);  
            PreparedStatement getAppt = conn.prepareStatement("SELECT * FROM appointments WHERE appt_id=?");
            getAppt.setInt(1, appt_id);
            ResultSet resultSet = getAppt.executeQuery();
            resultSet.next();
            PreparedStatement setFinAppt = conn.prepareStatement("INSERT INTO finished_appointments (book_id, student_id, appt_date_borrow, appt_date_return, enabled) VALUES (?, ?, ?, DEFAULT, DEFAULT)");
            setFinAppt.setInt(1, resultSet.getInt("book_id"));
            setFinAppt.setString(2, resultSet.getString("student_id"));
            setFinAppt.setTimestamp(3, resultSet.getTimestamp("appt_date_borrow"));
            setFinAppt.executeUpdate();
            deleteAppointment(appt_id);
            conn.close();
            return true;
        } catch (SQLException e){
            Popups.sqlError(e.getMessage());
            return false;
        }
    }
    public String[][] getFinAppointmentsDetails(String orderBy){
        String[][] appointments = {};
        try {
            Connection conn = DriverManager.getConnection(DBConn.url, DBConn.user, DBConn.password);  
            PreparedStatement getAppt = conn.prepareStatement("SELECT * FROM finished_appointments WHERE enabled=1 ORDER BY " + orderBy);
            ResultSet resultSet = getAppt.executeQuery();
            for (int i = 1; resultSet.next(); i++){
                String[] appt = new String[5];
                appt[0] = getBookName(resultSet.getInt("book_id"));
                appt[1] = getStudentName(resultSet.getString("student_id"));
                appt[2] = formatTimestampAsString(resultSet.getTimestamp("appt_date_borrow"));
                appt[3] = formatTimestampAsString(resultSet.getTimestamp("appt_date_return"));
                appt[4] = Integer.toString(resultSet.getInt("finappt_id"));
                appointments = Arrays.copyOf(appointments, i);
                appointments[appointments.length - 1] = appt;
            }
            conn.close();
        } catch(SQLException e){
            Popups.sqlError(e.getMessage());
        }
        return appointments;
    }
}
