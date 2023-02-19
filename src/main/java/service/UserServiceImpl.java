package service;

import dao.UserDAOImpl;
import model.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    private final UserDAOImpl userDao;

    public UserServiceImpl(UserDAOImpl userDAO) {
        this.userDao = userDAO;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void removeUserID(User user) {
        userDao.removeUserID(user);
    }

    @Override
    public void createTable() {
        userDao.createTable();
    }

    @Override
    public void dropTable() {userDao.dropTable(); }

    @Override
    public void cleanUserTable() {
        userDao.cleanUserTable();
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Override
    public User getUserByID(int id) {
        return userDao.getUserByID(id);
    }
}
