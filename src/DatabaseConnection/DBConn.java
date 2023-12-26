package DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class DBConn {
    // change the value of database_name to the desired name of your database
    private String database_name = "testlibdb1";
    // change the value of urlComp(complete url), user, and password if needed (the values below are xampp mysql default credentials)
    public static String url = "jdbc:mysql://localhost:3306/testlibdb1";
    public static String user = "root";
    public static String password = "";
    public void initDatabaseAndTables(String db_name) throws SQLException{
        Connection initConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", this.user, this.password); 
        Statement makeDB = initConn.createStatement();
        makeDB.executeUpdate("CREATE DATABASE " + db_name);
        initConn.close();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.database_name, "root", "");
        String accountTable = "CREATE TABLE lib_accounts (`libacct_id` INT NOT NULL AUTO_INCREMENT , `libacct_fname` VARCHAR(100) NOT NULL , `libacct_lname` VARCHAR(100) NOT NULL , `libacct_email` VARCHAR(100) NOT NULL , `libacct_pword` VARCHAR(100) NOT NULL , PRIMARY KEY (`libacct_id`), UNIQUE (`libacct_email`)) ENGINE = InnoDB;";
        String booksTable = "CREATE TABLE books (`book_id` INT NOT NULL AUTO_INCREMENT , `book_title` VARCHAR(255) NOT NULL , `book_author` VARCHAR(255) NOT NULL , `book_genre` VARCHAR(255) NOT NULL , `book_count` INT NOT NULL , PRIMARY KEY (`book_id`)) ENGINE = InnoDB;";        
        String bookGenreTable = "CREATE TABLE book_genre (`bg_id` INT NOT NULL AUTO_INCREMENT , `bg_name` VARCHAR(100) NOT NULL , PRIMARY KEY (`bg_id`), UNIQUE (`bg_name`)) ENGINE = InnoDB;";
        String studentTable = "CREATE TABLE students (`student_id` VARCHAR(11) NOT NULL , `student_name` VARCHAR(255) NOT NULL , PRIMARY KEY (`student_id`)) ENGINE = InnoDB;";
        String appointmentTable = "CREATE TABLE appointments (`appt_id` INT NOT NULL AUTO_INCREMENT , `book_id` INT NULL , `student_id` VARCHAR(11) NULL , `appt_date_borrow` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP , PRIMARY KEY (`appt_id`), FOREIGN KEY (`book_id`) REFERENCES books(`book_id`), FOREIGN KEY (`student_id`) REFERENCES students(`student_id`)) ENGINE = InnoDB;";
        String finishedAppointmentTable = "CREATE TABLE finished_appointments (`finappt_id` INT NOT NULL AUTO_INCREMENT , `book_id` INT NULL , `student_id` VARCHAR(11) NULL , `appt_date_borrow` DATETIME NOT NULL, `appt_date_return` DATETIME DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (`finappt_id`), FOREIGN KEY (`book_id`) REFERENCES books(`book_id`), FOREIGN KEY (`student_id`) REFERENCES students(`student_id`)) ENGINE = InnoDB;";
        Statement makeTable = conn.createStatement();
        makeTable.executeUpdate(accountTable);
        makeTable.executeUpdate(booksTable);
        makeTable.executeUpdate(bookGenreTable);
        makeTable.executeUpdate(studentTable);
        makeTable.executeUpdate(appointmentTable);
        makeTable.executeUpdate(finishedAppointmentTable);
        conn.close();
    }
    public Connection conn() throws SQLException{
        return DriverManager.getConnection(this.url, this.user, this.password);  
    }
    public ResultSet makeQuery (String query) throws SQLException {
        PreparedStatement statement = conn().prepareStatement(query);
        ResultSet result = statement.executeQuery();
        return result;
    }
    public void UpdateSQL(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(this.url, this.user, this.password);  
        PreparedStatement statement = conn().prepareStatement(query);
        statement.executeUpdate();
        conn.close();
    }
    // run this file to initiate the database before running the RegistrationGUI.java
    public static void main(String[] args) {
        DBConn myDb = new DBConn();
        try {
            myDb.initDatabaseAndTables(myDb.database_name);
        } catch (SQLException e){
            System.out.println(e);
        } 
    }
}
