package hu.weathernow.app.model;

public class Town {
    private int id;
    private String name;

    public Town(int id, String name) {
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
        return name.equals(town.name);
    }

}
