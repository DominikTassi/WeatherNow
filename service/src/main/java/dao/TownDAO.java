package dao;


import exceptions.TownNotFoundException;
import model.Town;

public interface TownDAO {
    public Town getTown(int id) throws TownNotFoundException;
}
