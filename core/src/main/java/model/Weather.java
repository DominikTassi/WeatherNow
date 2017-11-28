package model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import exceptions.EmptyCategoryException;
import exceptions.NoCategoryException;
import exceptions.NoTownException;
import exceptions.NoUserException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;

public class Weather {
    private int id;
    private User user;
    private Town town;
    private Category category;
    private double temperature;


    Date in = new Date();
    private LocalDateTime time = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());

    @JsonCreator
    public Weather(@JsonProperty("id")int id, @JsonProperty("user")User user, @JsonProperty("town")Town town, @JsonProperty("category")Category category, @JsonProperty("temperature")double temperature) throws NoUserException, NoTownException, NoCategoryException, EmptyCategoryException {
        if (user == null)
                throw new NoUserException("User cannot be null");

        if (town == null)
            throw new NoTownException("Town cannot be null");

        if (category == null)
            throw new NoCategoryException("Category cannot be null");

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

    public Category getCategory() {
        return category;
    }

    public double getTemperature() {
        return temperature;
    }

    public Date getTime() {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public void setCategory(Category category) {
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
        if (user != null ? !user.equals(weather.user) : weather.user != null) return false;
        if (town != null ? !town.equals(weather.town) : weather.town != null) return false;
        if (category != null ? !category.equals(weather.category) : weather.category != null) return false;
        return time != null ? time.equals(weather.time) : weather.time == null;
    }

}




