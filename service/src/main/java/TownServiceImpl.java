import dao.TownDAO;
import hu.weathernow.app.exceptions.NotFoundException;
import hu.weathernow.app.exceptions.StorageException;
import hu.weathernow.app.exceptions.StorageNotAvaibleException;
import hu.weathernow.app.model.Town;

public class TownServiceImpl implements TownDAO {
    private TownDAO userDAO = null;

    public TownServiceImpl(TownDAO townDAO){this.userDAO = userDAO;}

    public Town getTown(int id) throws StorageException, StorageNotAvaibleException, NotFoundException {
        return userDAO.getTown(id);
    }
}
