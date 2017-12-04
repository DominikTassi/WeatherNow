package hu.app.service.impl;

import dao.TownDAO;
import exceptions.TownNotFoundException;
import model.Town;
import service.TownService;


public class TownServiceImpl implements TownService {
    private TownDAO townDAO = null;

    public TownServiceImpl(TownDAO userDAO) {
        this.townDAO = userDAO;
    }

    public Town getTown(int id) throws TownNotFoundException {
        return townDAO.getTown(id);
    }

}
