package dao;


import exceptions.UserIDIsOccupiedException;
import exceptions.UsernameAlreadyExsistException;
import model.User;

import java.util.Collection;

public interface UserDAO {

    void createUser(User user)throws UserIDIsOccupiedException, UsernameAlreadyExsistException;

    User getUser(int id)throws UserIDIsOccupiedException;

    Collection<User> getAllUser();

    User getUser(String name)throws UserIDIsOccupiedException;

    boolean deleteUser(int id) throws UserIDIsOccupiedException;

    boolean deleteUser(User user) throws UserIDIsOccupiedException;

    int getMaxId();
}
