import java.sql.*;

public class Database {
    private Connection connection;
    private final String databaseName, username, password;

    public Database(String databaseName, String username, String password) {
        this.databaseName = databaseName;
        this.username = username;
        this.password = password;
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
        connection = DriverManager.getConnection(url, username, password);
    }

    public void close() throws SQLException {
        connection.close();
    }

    public void query() throws SQLException {
        Statement statement;
        ResultSet resultSet;

        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM Cliente");

        for (int i = 0; resultSet.next(); i++)
            System.out.println(i + " " + resultSet.getString("email"));

        statement.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Database database = new Database("ddl_progetto", "root", args[0]);
        database.connect();
        database.query();
        database.close();
    }
}
