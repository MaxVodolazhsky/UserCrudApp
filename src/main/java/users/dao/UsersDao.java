package users.dao;

public interface UsersDao {
    public String getLogin(int id);
    public String getPass(int id);
    public String getPassAndName(int id);
}
