package hu.weathernow.app.model;

import hu.weathernow.app.exceptions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class Weather {
    private int id;
    private User user;
    private Town town;
    private Collection<Category> category;
    private double temperature;
    private LocalDateTime time;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");

    public Weather(int id, User user, Town town, Collection<Category> category, double temperature) throws NoUserException, NoTownException, NoCategoryException, EmptyCategoryException{
        if (user == null)
                throw new NoUserException("User cannot be null");

        if (town == null)
            throw new NoTownException("Town cannot be null");

        if (category == null)
            throw new NoCategoryException("Category cannot be null");

        if (category.isEmpty())
            throw new EmptyCategoryException("Category cannot be empty");
        this.id = id;
        this.user = user;
        this.town = town;
        this.category = category;
        this.temperature = temperature;
        this.time = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Town getTown() {
        return town;
    }

    public Collection<Category> getCategory() {
        return category;
    }

    public double getTemperature() {
        return temperature;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public void setCategory(Collection<Category> category) {
        this.category = category;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather = (Weather) o;

        if (id != weather.id) return false;
        if (Double.compare(weather.temperature, temperature) != 0) return false;
        if (!user.equals(weather.user)) return false;
        if (!town.equals(weather.town)) return false;
        if (!category.equals(weather.category)) return false;
        if (!time.equals(weather.time)) return false;
        return dtf.equals(weather.dtf);
    }
}




