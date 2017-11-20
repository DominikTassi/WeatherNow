package dao;

import hu.weathernow.app.exceptions.*;
import hu.weathernow.app.model.User;

public interface UserDAO {

    void createUser(User user) throws StorageNotAvaibleException, AlreadyExistingException, StorageException, UserDIsOccupiedException;

    User getUser( int id ) throws StorageNotAvaibleException, StorageException, NotFoundException, UserDIsOccupiedException;

    User getUser( String name ) throws StorageNotAvaibleException, NotFoundException, StorageException, UserDIsOccupiedException;

    boolean deleteUser (int id ) throws StorageNotAvaibleException, StorageException, NotFoundException, AlreadyExistingException;

    boolean deleteUser( User user ) throws StorageNotAvaibleException, NotFoundException, StorageException, AlreadyExistingException;

}
