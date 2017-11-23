package service;


import exceptions.UserIDIsOccupiedException;
import model.User;

public interface UserService {

    void createUser(User user) throws UserIDIsOccupiedException;

    User getUser(int id);

    User getUser(String name);

    boolean deleteUser(int id);

    boolean deleteUser(User user);


}
