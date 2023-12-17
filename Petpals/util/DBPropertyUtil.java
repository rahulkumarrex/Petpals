package util;

import java.util.Properties;

public class DBPropertyUtil {
    private static final Properties properties = new Properties();

    static {
        // Set the database connection properties
        properties.setProperty("jdbc.url", "jdbc:mysql://localhost:3306/Pet");
        properties.setProperty("jdbc.username", "root");
        properties.setProperty("jdbc.password", "12345");
    }

    public static String getConnectionString() {
        return properties.getProperty("jdbc.url");
    }

    public static String getUsername() {
        return properties.getProperty("jdbc.username");
    }

    public static String getPassword() {
        return properties.getProperty("jdbc.password");
    }
}
