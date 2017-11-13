package hu.weathernow.app.service;

import hu.weathernow.app.exceptions.AlreadyExistingException;
import hu.weathernow.app.exceptions.NotFoundException;
import hu.weathernow.app.exceptions.StorageException;
import hu.weathernow.app.exceptions.StorageNotAvaibleException;
import hu.weathernow.app.model.User;

public interface UserService {

    User createUser(String name ) throws StorageNotAvaibleException, AlreadyExistingException, StorageException;

    User getUser( int id ) throws StorageNotAvaibleException, StorageException, NotFoundException;

    User getUser( String name ) throws StorageNotAvaibleException, NotFoundException, StorageException;

    boolean deleteUser (int id ) throws StorageNotAvaibleException, StorageException, NotFoundException;

    boolean deleteUser( User user ) throws StorageNotAvaibleException, NotFoundException, StorageException;


}
