import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Random;


/**
 * Created by kamochu on 7/5/2017.
 */
public class ProductThread implements Runnable {

    @Override
    public void run() {
        String query = "INSERT INTO ucm.test(created_on) VALUES(NOW())";

        try(Connection connection = getConnection(); Statement statement = connection.createStatement()){
            statement.execute(query);
            System.out.println( Thread.currentThread().getName()+"|"+ LocalDateTime.now()+"|Recorded inserted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://35.161.39.75:3306/", "ucm", "4rfvBHU*");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
