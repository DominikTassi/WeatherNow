package hu.weathernow.app.service;

import hu.weathernow.app.exceptions.TownNotFoundException;
import hu.weathernow.app.model.Town;

public interface TownService {
    public Town getTown(int id) throws TownNotFoundException;
}
