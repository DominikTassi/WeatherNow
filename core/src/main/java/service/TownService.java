package service;


import exceptions.TownNotFoundException;
import model.Town;

import java.util.Collection;

public interface TownService {
    public Town getTown(int id) throws TownNotFoundException;
    public Town getTown(String name) throws TownNotFoundException;
    public Collection<Town> getAllTown();
}

