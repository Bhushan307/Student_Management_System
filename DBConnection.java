import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            // Replace with your DB credentials
            String url = "jdbc:mysql://localhost:3306/student_db";
            String user = "root";
            String pass = "B*c3072004";

            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
        return con;
    }
}

