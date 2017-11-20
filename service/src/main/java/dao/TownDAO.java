package dao;

import hu.weathernow.app.exceptions.TownNotFoundException;
import hu.weathernow.app.model.Town;

public interface TownDAO {
    public Town getTown(int id) throws StorageException, StorageNotAvaibleException, NotFoundException, TownNotFoundException;
}
