package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO {
    List<User> getAllUsers() throws SQLException;

    User getUser(long id) throws SQLException;

    User getUserByLogin(String login) throws SQLException;

    void addUser(User user) throws SQLException;

    void deleteUser(long id) throws SQLException;

    void update(User user) throws SQLException;
}
