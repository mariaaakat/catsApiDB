import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;

public class CatsDBTests extends BaseDBTest {
    @Test
    void getAllCatsTest() throws SQLException {
        String CREATE_TABLE = """
                CREATE TABLE IF NOT EXISTS cats (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(255) NOT NULL,
                color VARCHAR(50),
                age INT
                )
                """;
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(CREATE_TABLE);
        }
        String query = "select count(*) from cats";
        try (Connection connection = DBConnection.getConnection();

             Statement statement = connection.createStatement();

             ResultSet resultSet = statement.executeQuery(query)) {

            resultSet.next();

            int count = resultSet.getInt(1);

            assertThat(count).isGreaterThanOrEqualTo(0);
        }
    }
}

