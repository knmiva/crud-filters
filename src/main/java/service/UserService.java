package service;

import dao.UsersDAO;
import dao.UsersDAOFactory;
import model.User;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UsersDAO usersDAO = UsersDAOFactory.getUsersDAO();

    private static UserService userService;

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public List<User> getAllUsers() throws SQLException {
        return usersDAO.getAllUsers();
    }

    public User getUser(long id) {
        try {
            return usersDAO.getUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByLogin(String login) {
        try {
            return usersDAO.getUserByLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(User user) {
        try {
            usersDAO.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(long id) {
        try {
            usersDAO.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(User user) {
        try {
            usersDAO.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
