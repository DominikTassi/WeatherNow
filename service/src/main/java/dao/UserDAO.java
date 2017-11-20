package dao;

import hu.weathernow.app.exceptions.*;
import hu.weathernow.app.model.User;

public interface UserDAO {

    void createUser(User user)throws UserDIsOccupiedException;

    User getUser( int id )throws UserDIsOccupiedException;

    User getUser( String name )throws UserDIsOccupiedException;

    boolean deleteUser (int id );

    boolean deleteUser( User user );
}
