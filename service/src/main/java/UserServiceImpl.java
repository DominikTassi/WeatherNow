import dao.UserDAO;
import hu.weathernow.app.exceptions.AlreadyExistingException;
import hu.weathernow.app.exceptions.NotFoundException;
import hu.weathernow.app.exceptions.StorageException;
import hu.weathernow.app.exceptions.StorageNotAvaibleException;
import hu.weathernow.app.model.User;

public class UserServiceImpl implements UserDAO {

    private UserDAO userDAO = null;
    public UserServiceImpl(UserDAO userDAO){this.userDAO = userDAO;}

    public User createUser(String name) throws StorageNotAvaibleException, AlreadyExistingException, StorageException {
        return userDAO.createUser(name);
    }

    public User getUser(int id) throws StorageNotAvaibleException, StorageException, NotFoundException {
        return userDAO.getUser(id);
    }

    public User getUser(String name) throws StorageNotAvaibleException, NotFoundException, StorageException {
        return userDAO.getUser(name);
    }

    public boolean deleteUser(int id) throws StorageNotAvaibleException, StorageException, NotFoundException, AlreadyExistingException {
        return userDAO.deleteUser(id);
    }

    public boolean deleteUser(User user) throws StorageNotAvaibleException, NotFoundException, StorageException, AlreadyExistingException {
        return userDAO.deleteUser(user);
    }
}
