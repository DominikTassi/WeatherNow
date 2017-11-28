package service;


import exceptions.UserIDIsOccupiedException;
import model.User;

import java.util.Collection;

public interface UserService {

    void createUser(User user) throws UserIDIsOccupiedException;

    User getUser(int id) throws UserIDIsOccupiedException;

    Collection<User> getAllUser();

    User getUser(String name) throws UserIDIsOccupiedException;

    boolean deleteUser(int id) throws UserIDIsOccupiedException;

    boolean deleteUser(User user) throws UserIDIsOccupiedException;


}
