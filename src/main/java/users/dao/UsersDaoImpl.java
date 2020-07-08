package users.dao;

import org.springframework.stereotype.Component;
import users.model.User;


import java.util.HashMap;
import java.util.Map;

@Component
public class UsersDaoImpl implements UsersDao {

    Map<Integer, User> mapUsers = new HashMap<Integer, User>();

    {
        mapUsers.put(1, new User("Admin", "admin"));
        mapUsers.put(2, new User("Max", "max"));
        mapUsers.put(3, new User("Lox", "pidr"));
    }


    public String getLogin(int id) {
        User user = mapUsers.get(id);
        return user.getLogin();
    }

    public String getPass(int id) {
        User user = mapUsers.get(id);
        return user.getPassword();
    }

    public String getPassAndName(int id) {
        User user = mapUsers.get(id);
        return user.getLogin() + " " + user.getPassword();
    }


}
