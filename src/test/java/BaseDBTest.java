import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseDBTest {

    @BeforeAll
    public static void connectionDB(){
        DBConnection.init(
                System.getenv("DB_URL"),
                System.getenv("DB_USER"),
                System.getenv("DB_PASSWORD"));
    }


    @AfterAll
    public static void closeConnectionDB(){
        DBConnection.close();

    }
}
