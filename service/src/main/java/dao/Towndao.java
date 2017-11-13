package dao;

import hu.weathernow.app.model.Town;

public interface Towndao {
    public Town getTown(int id) throws StorageException, StorageNotAvaibleException, NotFoundException;
}
