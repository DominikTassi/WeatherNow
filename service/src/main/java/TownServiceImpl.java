import dao.TownDAO;
import exceptions.TownNotFoundException;
import model.Town;


public class TownServiceImpl implements TownDAO {
    private TownDAO userDAO = null;

    public TownServiceImpl(TownDAO townDAO){this.userDAO = userDAO;}

    public Town getTown(int id) throws TownNotFoundException {
        return userDAO.getTown(id);
    }
}
