package service;

import model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void removeUserID(User user);
    void createTable();
    void dropTable();
    void cleanUserTable();
    List<User> getAllUsers();
    User getUserByID(int userID);
}
