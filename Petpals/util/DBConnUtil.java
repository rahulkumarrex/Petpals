package util;

import exception.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnUtil {
    public static Connection getConnection() {
        try {
            String connectionString = DBPropertyUtil.getConnectionString();
            return DriverManager.getConnection(connectionString, DBPropertyUtil.getUsername(),DBPropertyUtil.getPassword());
        } catch (Exception e) {
            throw new DatabaseException("Error while establishing database connection", e);
        }
    }
}
