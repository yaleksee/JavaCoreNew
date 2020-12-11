package src.less15.db;

import java.sql.*;

public class TestH2 {
    public static void init() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test");
    }

    public static void main(String[] args) throws Exception {
        init();

        try (Connection connection = getConnection()) {
            statements(connection);
            resultSet(connection);

            prepare(connection);
            resultSet(connection);

            transaction(connection);
            resultSet(connection);
        }
    }

    private static void transaction(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            statement.execute("insert into user (name) values ('kesha')");
            connection.commit();
            connection.setAutoCommit(true);
        }
    }

    private static void prepare(Connection connection) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into user(id, name) values (?, ?)")) {
            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "Fedor");
            preparedStatement.executeUpdate();
            preparedStatement.setInt(1, 4);
            preparedStatement.setString(2, "Misha");
            preparedStatement.addBatch();
            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "YULIA");
            preparedStatement.addBatch();
            preparedStatement.setInt(1, 6);
            preparedStatement.setString(2, "Natasha");
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        }
    }

    private static void resultSet(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("select * from user");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " : " + rs.getString("name"));
            }
            System.out.println("----------------------");
        }
    }

    private static void statements(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute("create table user(" +
                    "id integer primary key auto_increment, " +
                    "name varchar(100));");
            statement.execute("insert into user(name ) values ('borya'), ('petya')");
        }
    }
}
