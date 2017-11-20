import dao.TownDAO;
import hu.weathernow.app.exceptions.TownNotFoundException;
import hu.weathernow.app.model.Town;

public class TownServiceImpl implements TownDAO {
    private TownDAO userDAO = null;

    public TownServiceImpl(TownDAO townDAO){this.userDAO = userDAO;}

    public Town getTown(int id) throws TownNotFoundException {
        return userDAO.getTown(id);
    }
}
