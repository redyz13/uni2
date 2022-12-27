import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;
import java.util.Calendar;
import java.sql.Date;

public class Debug {
    public static void main(String[] args) throws SQLException {
        int year = Year.now().getValue();
        System.out.println(year);

        Database database = new Database("ddl_progetto", "root", "Giggino@G1");
        Query queryTest = new Query(database);
        int StrutturaRicettiva;

        Statement statement;
        ResultSet resultSet;

        statement = database.getConnection().createStatement();
        resultSet = statement.executeQuery("SELECT MAX(codiceStruttura) FROM StrutturaRicettiva");
        StrutturaRicettiva = resultSet.getInt("codiceStruttura") + 1;
        statement.close();
        System.out.println(StrutturaRicettiva);
    }
}
