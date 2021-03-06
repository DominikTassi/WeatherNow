package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Town {
    private int id;
    private String name;

/*
    {
        "wid": 1,
            "uid": 2,
            "username": "Dominik_Tassi",
            "tid": 3,
            "town": "Miskolc",
            "category": "COLD",
            "temperature": -5.0
    }
*/

    @JsonCreator
    public Town(@JsonProperty(value = "id")int id, @JsonProperty(value = "name")String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Town town = (Town) o;

        if (id != town.id) return false;
        return name != null ? name.equals(town.name) : town.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
