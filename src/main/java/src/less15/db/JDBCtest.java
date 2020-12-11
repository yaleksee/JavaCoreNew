package src.less15.db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCtest {
    static Connection connection = null;
    public static void main(String[] args) {

        //URL к базе состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
        String url = "jdbc:postgresql://127.0.0.1:5432/your_db_name";
        //Имя пользователя БД
        String name = "postgres";
        //Пароль
        String password = "root";
        Statement statement = null;
        try {
            //Загружаем драйвер
            Class.forName("org.postgresql.Driver");

            //Создаём соединение
            connection = DriverManager.getConnection(url, name, password);

            //Для использования SQL запросов существуют 3 типа объектов:
            //1.Statement: используется для простых случаев без параметров
            statement = connection.createStatement();

            //Выполним запрос
            ResultSet result1 = statement.executeQuery(
                    "SELECT * FROM users where id >0 and id <2");

            //result это указатель на первую строку с выборки
            //чтобы вывести данные мы будем использовать
            //метод next() , с помощью которого переходим к следующему элементу

            System.out.println("Выводим statement");
            while (result1.next()) {
                System.out.println("Номер в выборке #" + result1.getRow()
                        + "\t Номер в базе #" + result1.getInt("id")
                        + "\t" + result1.getString("username"));
            }

            //Обновить запись
            statement.executeUpdate(
                    "UPDATE users SET username = 'admin69' where id = 1");



            //2.PreparedStatement: предварительно компилирует запросы,
            //которые могут содержать входные параметры
            PreparedStatement preparedStatement = null;

            // ? - место вставки нашего значеня
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users where id > ? and id < ?");

            //Устанавливаем в нужную позицию значения определённого типа
            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(2, 10);

            //выполняем запрос
            ResultSet result2 = preparedStatement.executeQuery();

            System.out.println("Выводим PreparedStatement");
            while (result2.next()) {
                System.out.println("Номер в выборке #" + result2.getRow()
                        + "\t Номер в базе #" + result2.getInt("id")
                        + "\t" + result2.getString("username"));
            }

            preparedStatement = connection.prepareStatement(
                    "INSERT INTO users(username) values(?)");
            preparedStatement.setString(1, "user_name");

        } catch (Exception ex) {
            //выводим наиболее значимые сообщения
            Logger.getLogger(JDBCtest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JDBCtest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
