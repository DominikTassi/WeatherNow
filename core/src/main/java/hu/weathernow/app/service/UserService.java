package hu.weathernow.app.service;

import hu.weathernow.app.exceptions.*;
import hu.weathernow.app.model.User;

public interface UserService {

    void createUser(User user) throws UserDIsOccupiedException;

    User getUser( int id );

    User getUser( String name );

    boolean deleteUser (int id );

    boolean deleteUser( User user );


}
