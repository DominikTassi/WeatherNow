package hu.weathernow.app.service;

import hu.weathernow.app.exceptions.NotFoundException;
import hu.weathernow.app.exceptions.StorageException;
import hu.weathernow.app.exceptions.StorageNotAvaibleException;
import hu.weathernow.app.model.Town;

public interface TownService {
    public Town getTown(int id) throws StorageException, StorageNotAvaibleException, NotFoundException;

    public boolean updateTown(int id);
    public boolean updateTown(Town town);

    public boolean deleteTown(int id);
    public boolean deleteTown(Town town);
}
