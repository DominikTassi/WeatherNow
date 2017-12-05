package json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.TownDAO;
import exceptions.TownNotFoundException;
import model.Town;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;


public class TownDAOJSON implements TownDAO {

    ObjectMapper mapper;
    File jsonfile;


    public TownDAOJSON(String filename) {
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


    public Town getTown(int id) throws TownNotFoundException {
        Collection<Town> towns = new HashSet<Town>();
        try{
            towns = mapper.readValue(jsonfile, new TypeReference<HashSet<Town>>(){});
            for(Town t: towns){
                if (t.getId() == id){
                    return t;
                }
            }
        }catch (MismatchedInputException e){
            System.err.println("Empty file " + e);
        }
        catch (IOException e) {
            e.printStackTrace();
        }throw new TownNotFoundException(String.valueOf(id));
    }


    public Collection<Town> getAllTown(){
        Collection<Town> users = new HashSet<Town>();
        try {
            System.out.println(jsonfile.getAbsoluteFile());
            users = mapper.readValue(jsonfile, new TypeReference<HashSet<Town>>(){});
        }catch (MismatchedInputException e){
            System.err.println("Empty file " +e);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
