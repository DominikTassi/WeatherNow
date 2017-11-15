package mysql;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import dao.WeatherDAO;
import hu.weathernow.app.exceptions.*;
import hu.weathernow.app.model.Category;
import hu.weathernow.app.model.Town;
import hu.weathernow.app.model.User;
import hu.weathernow.app.model.Weather;

import java.sql.*;
import java.util.Collection;
import java.util.HashSet;

public class WeatherDAOmysql implements WeatherDAO {
    private Connection conn;
    public WeatherDAOmysql(Connection conn){this.conn = conn; }

    @Override
    public Weather createWeather(User user, Collection<Category> categories, Town town, double temperature) throws StorageException, StorageNotAvaibleException, NotFoundException, AlreadyExistingException {
        String insertSQL = "INSERT into weather VALUES (?, ?, ?, ?, ?)";
        int last_id = 0;
        Weather weather = null;

        try{
            PreparedStatement ps = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, String.valueOf(categories));
            ps.setString(3, town.getName());
            ps.setDouble(4, temperature);
            ps.setDate(5, (Date)weather.getTime());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
            {
                last_id = rs.getInt(1);
            }
            weather = new Weather(last_id, user, town, categories, temperature);
        }
        catch (CommunicationsException e)
        {
            throw new StorageNotAvaibleException();
        }
        catch(SQLIntegrityConstraintViolationException e){
            throw new AlreadyExistingException();
        }
        catch (SQLException e)
        {
            throw new StorageException();
        } catch (NoUserException e) {
            e.printStackTrace();
        } catch (NoTownException e) {
            e.printStackTrace();
        } catch (EmptyCategoryException e) {
            e.printStackTrace();
        } catch (NoCategoryException e) {
            e.printStackTrace();
        }
        return weather;
    }

    @Override
    public Collection<Weather> getByUser(User user) throws StorageNotAvaibleException, StorageException {
        int id;
        Collection<Weather> weather = new HashSet<Weather>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT user FROM weather WHERE user = ?");
            ps.setString(1, user.getName());
            ResultSet rs = ps.executeQuery();
            boolean isExist = rs.next();
            if (isExist) {
                id = rs.getInt("id");
            } else {
                throw new NotFoundException();
            }

        } catch (CommunicationsException e) {
            throw new StorageNotAvaibleException();
        } catch (SQLException e) {
            throw new StorageException();
        } catch (NotFoundException e1) {
            e1.printStackTrace();
        }
        return weather;
    }

        @Override
    public boolean updateWeather(Weather weather) throws StorageNotAvaibleException, AlreadyExistingException, StorageException {
        String updateSQl = "UPDATE weather SET user = ?, town = ?, categories = ?, temperature = ?, time = ? WHERE id = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(updateSQl);
            ps.setString(1, weather.getUser().getName());
            ps.setString(2, weather.getTown().getName());
            ps.setString(3, String.valueOf(weather.getCategory()));
            ps.setDouble(4, weather.getTemperature());
            ps.setDate(5, (Date)weather.getTime());
            ps.setInt(6, weather.getId());
            if(ps.executeUpdate() == 0)
            {
                throw new NotFoundException();
            }
        }
        catch (CommunicationsException e)
        {
            throw new StorageNotAvaibleException();
        }
        catch(SQLIntegrityConstraintViolationException e)
        {
            throw new AlreadyExistingException();
        }
        catch (SQLException e)
        {
            throw new StorageException();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deleteWeather(int id) throws StorageNotAvaibleException, StorageException {
        String deleteSQL = "DELETE FROM weather WHERE id = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(deleteSQL);
            ps.setInt(1, id);
            if(ps.executeUpdate() == 0)
            {
                throw new NotFoundException();
            }
        }
        catch (CommunicationsException e)
        {
            throw new StorageNotAvaibleException();
        }
        catch (SQLException e)
        {
            throw new StorageException();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deleteWeather(Weather weather) throws StorageNotAvaibleException, StorageException {
        String deleteSQL = "DELETE FROM weather WHERE user = ?";
        try
        {
            PreparedStatement ps = conn.prepareStatement(deleteSQL);
            ps.setString(1, String.valueOf(weather.getUser()));
            if(ps.executeUpdate() == 0)
            {
                throw new NotFoundException();
            }
        }
        catch (CommunicationsException e)
        {
            throw new StorageNotAvaibleException();
        }
        catch (SQLException e)
        {
            throw new StorageException();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
