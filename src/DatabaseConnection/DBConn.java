package DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConn {
    private String database_name = "testlib1";
    
    public void initDatabaseAndTables(String db_name) throws SQLException{
        this.database_name = db_name;
        Connection initConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", ""); 
        Statement makeDB = initConn.createStatement();
        makeDB.executeUpdate("CREATE DATABASE " + db_name);
        initConn.close();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.database_name, "root", "");
        String accountTable = "CREATE TABLE lib_accounts (`libacct_id` INT NOT NULL AUTO_INCREMENT , `libacct_fname` VARCHAR(100) NOT NULL , `libacct_lname` VARCHAR(100) NOT NULL , `libacct_email` VARCHAR(100) NOT NULL , `libacct_pword` VARCHAR(100) NOT NULL , PRIMARY KEY (`libacct_id`), UNIQUE (`libacct_email`)) ENGINE = InnoDB;";
        String booksTable = "CREATE TABLE books (`book_id` INT NOT NULL AUTO_INCREMENT , `book_title` VARCHAR(255) NOT NULL , `book_author` VARCHAR(255) NOT NULL , `book_genre` VARCHAR(255) NOT NULL , `book_count` INT NOT NULL , PRIMARY KEY (`book_id`), UNIQUE (`book_title`)) ENGINE = InnoDB;";        
        String bookGenreTable = "CREATE TABLE book_genre (`bg_id` INT NOT NULL AUTO_INCREMENT , `bg_name` VARCHAR(100) NOT NULL , PRIMARY KEY (`bg_id`), UNIQUE (`bg_name`)) ENGINE = InnoDB;";
        String studentTable = "CREATE TABLE students (`student_id` VARCHAR(11) NOT NULL , `student_name` VARCHAR(255) NOT NULL , PRIMARY KEY (`student_id`)) ENGINE = InnoDB;";
        String appointmentTable = "CREATE TABLE appointments (`appt_id` INT PRIMARY KEY, `book_id` INT, `student_id` VARCHAR(11), `libacct_id` INT, `appt_date` DATETIME DEFAULT CURRENT_TIMESTAMP, FOREIGN KEY (`book_id`) REFERENCES books(`book_id`), FOREIGN KEY (`student_id`) REFERENCES students(`student_id`), FOREIGN KEY (`libacct_id`) REFERENCES lib_accounts(`libacct_id`));";
        Statement makeTable = conn.createStatement();
        makeTable.executeUpdate(accountTable);
        makeTable.executeUpdate(booksTable);
        makeTable.executeUpdate(bookGenreTable);
        makeTable.executeUpdate(studentTable);
        makeTable.executeUpdate(appointmentTable);
        
        
        
        conn.close();
    }
    
    public Connection conn() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.database_name, "root", "");  
    }
}
