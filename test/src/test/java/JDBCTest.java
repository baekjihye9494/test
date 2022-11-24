

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.fail;


public class JDBCTest {
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void connection() {
        try(Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "dt110701", "1234")) {
        
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}