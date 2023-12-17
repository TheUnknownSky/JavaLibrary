package DatabaseConnection;

import java.sql.*;

public class testClass {
    public static void main(String[] args) {
        DBConn myDb = new DBConn();
        try {
            // change the value of the parameter (currently "testlib1") with the database name you want
            myDb.initDatabaseAndTables("testlib1");
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
