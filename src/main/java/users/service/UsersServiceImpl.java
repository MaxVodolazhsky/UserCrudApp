package users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.dao.UsersDaoImpl;


@Service
public class UsersServiceImpl implements UsersService {
    private UsersDaoImpl usersDaoImpl;

    @Autowired
    public void setUsers(UsersDaoImpl usersDaoImpl) {
        this.usersDaoImpl = usersDaoImpl;
    }


    public String getLogin(int id) {
        return usersDaoImpl.getLogin(id);
    }

    public String getPass(int id) {
        return usersDaoImpl.getPass(id);
    }

    public String getPassAndName(int id) {
        return usersDaoImpl.getPassAndName(id);
    }
}
