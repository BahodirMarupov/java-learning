package exceptions.checkedexceptions;

import java.sql.*;

public class SqlExceptionExample {
    static final String DB_URL = "jdbc:postgresql://localhost/sample_db";
    static final String USER = "postgres";
    static final String PASS = "1";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            System.out.println("Inserting record into the table...");
            String sql = "INSERT INTO countries VALUES (1,'Uzbekistan','Uzbekistan')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted record into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
