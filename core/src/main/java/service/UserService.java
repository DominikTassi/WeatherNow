package service;


import exceptions.UserIDIsOccupiedException;
import model.User;

public interface UserService {

    void createUser(User user) throws UserIDIsOccupiedException;

    User getUser(int id) throws UserIDIsOccupiedException;

    User getUser(String name) throws UserIDIsOccupiedException;

    boolean deleteUser(int id);

    boolean deleteUser(User user);


}
