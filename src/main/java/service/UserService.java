package service;

import model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void removeUserID(long id);
    void createTable();
    void dropTable();
    void cleanUserTable();
    List<User> getAllUsers();
    User getUserByID(long userID);
}
