package hu.app.service.impl;

import dao.UserDAO;
import exceptions.UserIDIsOccupiedException;
import exceptions.UsernameAlreadyExsistException;
import model.User;
import service.UserService;

import java.util.Collection;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = null;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void createUser(User user) throws UserIDIsOccupiedException, UsernameAlreadyExsistException {
        userDAO.createUser(user);
    }

    public User getUser(int id) throws UserIDIsOccupiedException {
        return userDAO.getUser(id);
    }

    @Override
    public Collection<User> getAllUser() {
        return userDAO.getAllUser();
    }

    public User getUser(String name) throws UserIDIsOccupiedException {
        return userDAO.getUser(name);
    }

    public boolean deleteUser(int id) throws UserIDIsOccupiedException {
        return userDAO.deleteUser(id);
    }

    public boolean deleteUser(User user) throws UserIDIsOccupiedException {
        return userDAO.deleteUser(user);
    }

    @Override
    public int getMaxId() {
        return userDAO.getMaxId();
    }

}
