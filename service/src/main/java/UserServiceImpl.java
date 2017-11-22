import dao.UserDAO;
import hu.weathernow.app.exceptions.UserDIsOccupiedException;
import hu.weathernow.app.model.User;

public class UserServiceImpl implements UserDAO {

    private UserDAO userDAO = null;
    public UserServiceImpl(UserDAO userDAO){this.userDAO = userDAO;}

    public void createUser(User user) throws UserDIsOccupiedException {

    }

    public User getUser(int id) throws UserDIsOccupiedException {
        return userDAO.getUser(id);
    }

    public User getUser(String name) throws UserDIsOccupiedException {
        return userDAO.getUser(name);
    }

    public boolean deleteUser(int id) {
        return userDAO.deleteUser(id);
    }

    public boolean deleteUser(User user){
        return userDAO.deleteUser(user);
    }
}
