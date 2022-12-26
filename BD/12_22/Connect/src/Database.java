import java.sql.*;

public class Database {
    private Connection connection;
    private String databaseName, url, username, password;

    public Database(String databaseName, String username, String password) {
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        url = "jdbc:mysql://localhost:3306/" + databaseName;
        connection = DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Database database = new Database("ddl_progetto", "root", args[0]);
        database.connect();
        System.out.println("Worked");
    }
}
