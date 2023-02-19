package dao;

import model.User;

import java.util.List;

public interface UserDAO {
    void saveUser(User user);

    void removeUserID(long id);

    void createTable();

    void dropTable();

    void cleanUserTable();

    List<User> getAllUsers();

    User getUserByID(long id);
}
