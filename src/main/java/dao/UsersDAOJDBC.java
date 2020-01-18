package dao;

import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOJDBC implements UsersDAO {
    private Connection connection;

    public UsersDAOJDBC() {
        this.connection = DBHelper.getInstance().getConnection();
    }

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            statement.execute("select * from users");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                usersList.add(new User(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8)));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public User getUser(long id) {
        User user = new User();
        try (Statement statement = connection.createStatement()) {
            statement.execute("select * from users where id='" + id + "'");
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            user.setId(id);
            user.setRole(resultSet.getString("role"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setLogin(resultSet.getString("login"));
            user.setEmail(resultSet.getString("email"));
            user.setCountry(resultSet.getString("country"));
            user.setMobile(resultSet.getString("mobile"));
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByLogin(String login) throws SQLException {
        User user = new User();
        try (Statement statement = connection.createStatement()) {
            statement.execute("select * from users where login='" + login + "'");
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            user.setLogin(login);
            user.setId(resultSet.getLong("id"));
            user.setRole(resultSet.getString("role"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setCountry(resultSet.getString("country"));
            user.setMobile(resultSet.getString("mobile"));
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addUser(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into users(name, role, password," +
                "login, email, country, mobile) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getRole());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getCountry());
            preparedStatement.setString(7, user.getMobile());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from users where id= ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User user) throws SQLException {
        try (Statement statement = connection.createStatement()) {
        statement.executeUpdate("update users set name = '" + user.getName() + "', role = '" + user.getRole() + "', password = '" + user.getPassword() +
                    "', login = '" + user.getLogin() + "', email = '" + user.getEmail() + "', country = '" + user.getCountry() + "', mobile = '" +
                    user.getMobile() + "' where id = '" + user.getId() + "'");
        }
    }

    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table if not exists users (id bigint auto_increment, role varchar(256)," +
                " name varchar(256), password varchar(256), login varchar(256), email varchar(256), country varchar(256)," +
                " mobile varchar(256), primary key (id))");
        stmt.close();
    }
}
