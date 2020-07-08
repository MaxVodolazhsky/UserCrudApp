package users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import users.dao.UsersDaoImpl;


@Service
public class UsersServiceImpl implements UsersService {
    private UsersDaoImpl usersDaoImpl;

    @Autowired
    public void setUsers(UsersDaoImpl usersDaoImpl) {
        this.usersDaoImpl = usersDaoImpl;
    }

    @Transactional
    public String getLogin(int id) {
        return usersDaoImpl.getLogin(id);
    }
    @Transactional
    public String getPass(int id) {
        return usersDaoImpl.getPass(id);
    }
    @Transactional
    public String getPassAndName(int id) {
        return usersDaoImpl.getPassAndName(id);
    }
}
