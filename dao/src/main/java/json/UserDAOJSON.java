package json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.UserDAO;
import exceptions.UserIDIsOccupiedException;
import model.User;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

public class UserDAOJSON implements UserDAO {

    ObjectMapper mapper;
    File jsonfile;

    public UserDAOJSON(String filename) {
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




    public void createUser(User user) throws UserIDIsOccupiedException {
        Collection<User> users = new HashSet<User>();
        boolean uniqueId = true;
        for(User u : users){
            if(u.getId() == user.getId()){
                uniqueId = false;
            }
        }
        if(!uniqueId){
            throw new UserIDIsOccupiedException(String.valueOf(user.getId()));
        }
        users.add(user);
        try {
            mapper.writeValue(jsonfile, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(int id) throws UserIDIsOccupiedException {
        Collection<User> users = new HashSet<User>();
        try{
            users = mapper.readValue(jsonfile, new TypeReference<HashSet<User>>(){});
            for(User u: users){
                if (u.getId() == id){
                    return u;
                }
            }
        }catch (MismatchedInputException e){
            System.err.println("Empty file");
        }
        catch (IOException e) {
            e.printStackTrace();
        }throw new UserIDIsOccupiedException(String.valueOf(id));
    }


    @Override
    public User getUser(String name) throws UserIDIsOccupiedException {
        Collection<User> users = new HashSet<User>();
        try{
            users = mapper.readValue(jsonfile, new TypeReference<HashSet<User>>(){});
            for(User u: users){
                if (u.getName().equalsIgnoreCase(name)){
                    return u;
                }
            }
        }catch (MismatchedInputException e){
            System.err.println("Empty file");
        }
        catch (IOException e) {
            e.printStackTrace();
        }throw new UserIDIsOccupiedException(name);
    }

    @Override
    public boolean deleteUser(int id){
        return false;
    }

    @Override
    public boolean deleteUser(User user){
        return false;
    }
}
