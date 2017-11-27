package hu.app.service.impl;

import dao.UserDAO;
import exceptions.UserIDIsOccupiedException;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = null;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void createUser(User user) throws UserIDIsOccupiedException {
        userDAO.createUser(user);
    }

    public User getUser(int id) throws UserIDIsOccupiedException {
        return userDAO.getUser(id);
    }

    public User getUser(String name) throws UserIDIsOccupiedException {
        return userDAO.getUser(name);
    }

    public boolean deleteUser(int id) {
        return userDAO.deleteUser(id);
    }

    public boolean deleteUser(User user) {
        return userDAO.deleteUser(user);
    }
}
