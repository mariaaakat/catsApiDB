import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeTest extends BaseDBTest {
    @Test
    void connectDBTest(){
        try (Connection conn = DBConnection.getConnection()){
           assertTrue(conn.isValid(2));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
