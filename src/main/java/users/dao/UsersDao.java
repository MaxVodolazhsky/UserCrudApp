package users.dao;

import users.model.User;

import java.util.List;

public interface UsersDao {
    public String getLogin(int id);
    public String getPass(int id);
    public String getPassAndLog(int id);
    public void setLogin(User user);
    public void setPass(User user);
    public User getById(int id);
    public void remove(User user);
    public void add(User user);
    public List<User> allUsers();
}
