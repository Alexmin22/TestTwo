package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    void saveUser(User user);

    void removeUserID(User user);

    void createTable();

    void dropTable();

    void cleanUserTable();

    List<User> getAllUsers();

    User getUserByID(int id);
}
