package users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import users.dao.UsersDao;
import users.model.User;

import java.util.List;


@Service
public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao;

    @Autowired
    public void setUsers(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Transactional
    public String getLogin(int id) {
        return usersDao.getLogin(id);
    }

    @Transactional
    public String getPass(int id) {
        return usersDao.getPass(id);
    }

    @Transactional
    public String getPassAndLog(int id) {
        return usersDao.getPassAndLog(id);
    }

    @Transactional
    public User getById(int id) {
        return usersDao.getById(id);
    }

    @Transactional
    public void setLogin(User user) {
        usersDao.setLogin(user);
    }

    @Transactional
    public void setPass(User user) {
        usersDao.setPass(user);
    }

    @Transactional
    public void remove(User user) {
        usersDao.remove(user);
    }

    @Transactional
    public void add(User user) {
        usersDao.add(user);
    }

    @Transactional
    public List<User> allUsers() {
        return usersDao.allUsers();
    }
}
