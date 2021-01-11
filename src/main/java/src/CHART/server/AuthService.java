package src.CHART.server;

import java.sql.*;

public interface AuthService {

    String getNick(String login, String pass);

    void connect();

    void disconnect();

    String changeNick(String oldNick, String newNick);
}

class AuthServiceImpl implements AuthService {

    private static Connection connection;
    private static Statement statement;


    @Override
    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:src/Lesson2/db");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getNick(String login, String pass) {
        login = login.trim();
        pass = pass.trim();
        String query = String.format("select nick from users\n"
                + "where login = '%s'\n"
                + "  and password = '%s'\n", login, pass);
        try {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String changeNick(String oldNick, String newNick) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT nick FROM main.users WHERE nick = '" + oldNick + "'");
            if (resultSet.next()) {
                stmt.executeUpdate("UPDATE main.users SET nick = '" + newNick + "' WHERE nick = '" + oldNick + "'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

