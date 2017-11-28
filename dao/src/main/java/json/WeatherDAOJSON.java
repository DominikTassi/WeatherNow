package json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.WeatherDAO;
import exceptions.WeatherIDIsOccupiedException;
import model.Weather;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

public class WeatherDAOJSON implements WeatherDAO {


    ObjectMapper mapper;
    File jsonfile;

    public WeatherDAOJSON(String filename) {
        /**
         * The configuration of the mapper for handling the LocalDate correctly.
         */
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        /**
         * The loading of the file, and if it is not exist, creation of the file.
         */
        jsonfile = new File(filename);
        if (!jsonfile.exists()) {
            try {
                jsonfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void createWeather(Weather weather) throws WeatherIDIsOccupiedException {
        Collection<Weather> weathers = getAllWeather();
        boolean uniqueId = true;
        for(Weather w : weathers){
            if(w.getId() == weather.getId()){
                uniqueId = false;
            }
        }
        if(!uniqueId){
            throw new WeatherIDIsOccupiedException(String.valueOf(weather.getId()));
        }
        weathers.add(weather);
        try {
            mapper.writeValue(jsonfile, weathers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Weather> getAllWeather() {
        Collection<Weather> weathers = new HashSet<Weather>();
        try {
            System.out.println(jsonfile.getAbsoluteFile());
            weathers = mapper.readValue(jsonfile, new TypeReference<HashSet<Weather>>(){});
        }catch (MismatchedInputException e){
            System.err.println("Empty file" + e);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return weathers;
    }

    @Override
    public boolean updateWeather(Weather weather)  {
        return false;
    }

    @Override
    public boolean deleteWeather(int i) {
        return false;
    }

    @Override
    public boolean deleteWeather(Weather weather) {
        return false;
    }
}
