package DatabaseConnection;

import java.sql.*;

public class testClass {
    public static void main(String[] args) {
        DBConn myDb = new DBConn();
        try {
            myDb.initDatabaseAndTables("testlib1");
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
