package service;


import exceptions.TownNotFoundException;
import model.Town;

public interface TownService {
    public Town getTown(int id) throws TownNotFoundException;
}
