package mysql;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import dao.TownDAO;
import hu.weathernow.app.exceptions.NotFoundException;
import hu.weathernow.app.exceptions.StorageException;
import hu.weathernow.app.exceptions.StorageNotAvaibleException;
import hu.weathernow.app.model.Town;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TownDAOmysql implements TownDAO{

    private Connection conn;
    public TownDAOmysql(Connection conn){ this.conn = conn; }

    @Override
    public Town getTown(int id) throws StorageException, StorageNotAvaibleException, NotFoundException {
        String name = null;
        Town town = null;
        PreparedStatement ps = null;
        try
        {
            ps = conn.prepareStatement("SELECT city FROM town WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            boolean isExist = rs.next();
            if (isExist)
            {
                name = rs.getString("city");
            }
            else {
                throw new NotFoundException();
            }
            town = new Town(id, name);
        }
        catch (CommunicationsException e)
        {
            throw new StorageNotAvaibleException();
        }
        catch (SQLException e) {
            throw new StorageException();
        }
        return town;
    }
}
