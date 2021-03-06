package json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.UserDAO;
import dao.WeatherDAO;
import exceptions.TownNotExistException;
import exceptions.UserNotExistException;
import exceptions.WeatherIDIsOccupiedException;
import model.Town;
import model.User;
import model.Weather;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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


    public void createWeather(Weather weather) throws WeatherIDIsOccupiedException, TownNotExistException, UserNotExistException {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. LLLL dd. HH:mm");
        String formattedString = localDateTime.format(formatter);
        weather.setTime(formattedString);
        Collection<Weather> weathers = getAllWeather();
        UserDAOJSON userDAOJSON = new UserDAOJSON(System.getProperty("users_json_file"));
        TownDAOJSON townDAOJSON = new TownDAOJSON(System.getProperty("towns_json_file"));
        Collection<User> users = userDAOJSON.getAllUser();
        Collection<Town> towns = townDAOJSON.getAllTown();
        boolean uniqueId = true;
        boolean notExistingUser = true;
        boolean notExistingTown = true;
        for(Weather w : weathers){
            if(w.getId() == weather.getId()){
                uniqueId = false;
            }
        }
        for(User u: users){
            if(u.equals(weather.getUser()))
            {
                notExistingUser = false;
            }
        }
        for (Town t: towns){
            if(t.equals(weather.getTown())){
                notExistingTown = false;
            }
        }
        if(!uniqueId){
            throw new WeatherIDIsOccupiedException(String.valueOf(weather.getId()));
        }
        if(notExistingUser){
            throw new UserNotExistException(weather.getUser().getName());
        }
        if(notExistingTown){
            throw new TownNotExistException(weather.getTown().getName());
        }
        weathers.add(weather);
        try {
            mapper.writeValue(jsonfile, weathers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Weather> getAllWeather() {
        List<Weather> weathers = new ArrayList<>();
        try {
            System.out.println(jsonfile.getAbsoluteFile());
            weathers = mapper.readValue(jsonfile, new TypeReference<List<Weather>>(){});
        }catch (MismatchedInputException e){
            System.err.println("Empty file" + e);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(weathers);
        return weathers;
    }

    @Override
    public boolean updateWeather(Weather weather) throws WeatherIDIsOccupiedException {
        Collection<Weather> weathers = getAllWeather();
        try{
            weathers = mapper.readValue(jsonfile, new TypeReference<HashSet<Weather>>(){});
            for(Weather w: weathers){
                if (w.equals(weather)){
                    weathers.remove(w);
                    weathers.add(weather);
                    return true;
                }
            }
        }catch (MismatchedInputException e){
            System.err.println("Empty file");
        }
        catch (IOException e) {
            e.printStackTrace();
        }throw new WeatherIDIsOccupiedException(String.valueOf(weather.getId()));
    }

    @Override
    public boolean deleteWeather(int i) throws WeatherIDIsOccupiedException {
        Collection<Weather> weathers = getAllWeather();
        try{
            weathers = mapper.readValue(jsonfile, new TypeReference<HashSet<Weather>>(){});
            for(Weather w: weathers){
                if (w.getId() == i){
                    weathers.remove(w);
                    return true;
                }
            }
        }catch (MismatchedInputException e){
            System.err.println("Empty file");
        }
        catch (IOException e) {
            e.printStackTrace();
        }throw new WeatherIDIsOccupiedException(String.valueOf(i));
    }

    @Override
    public boolean deleteWeather(Weather weather) throws WeatherIDIsOccupiedException {
        Collection<Weather> weathers = getAllWeather();
        try{
            weathers = mapper.readValue(jsonfile, new TypeReference<HashSet<Weather>>(){});
            for(Weather w: weathers){
                if (w.equals(weather)){
                    weathers.remove(w);
                    return true;
                }
            }
        }catch (MismatchedInputException e){
            System.err.println("Empty file");
        }
        catch (IOException e) {
            e.printStackTrace();
        }throw new WeatherIDIsOccupiedException(String.valueOf(weather.getId()));
    }

    @Override
    public int getMaxWeatherId() {
        Collection<Weather> weathers = getAllWeather();
        int maxId = 0;
        try{
            weathers = mapper.readValue(jsonfile, new TypeReference<HashSet<Weather>>(){});
            for(Weather w: weathers){
                if (w.getId() > maxId){
                        maxId = w.getId();
                    }
                }
            } catch (JsonParseException e1) {
            e1.printStackTrace();
        } catch (JsonMappingException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return maxId;
    }
}
