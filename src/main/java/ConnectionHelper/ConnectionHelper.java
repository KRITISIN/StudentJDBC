package ConnectionHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    public static Connection createConnection(){
        Connection conn;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jha-jfrcjd-m3","root","sql123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;

    }
}
