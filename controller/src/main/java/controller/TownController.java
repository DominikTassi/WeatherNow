package controller;

import hu.weathernow.app.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import hu.weathernow.app.service.WeatherService;
import hu.weathernow.app.exceptions.*;

@Controller
public class TownController {
    TownService townService;

    @RequestMapping(value = "/getTown/{id}")
    public ModelAndView getTown(@PathVariable(value = "id")
                                    int id)
            throws TownNotFoundException, StorageNotAvaibleException, StorageException, NotFoundException {
        ModelAndView mav = new ModelAndView("towndata");
        mav.addObject("town",townService.getTown(id));
        return mav;
    }

}
