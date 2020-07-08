package users.service;

import org.springframework.stereotype.Component;

@Component
public interface UsersService {

    public String getLogin(int id);
    public String getPass(int id);
    public String getPassAndName(int id);
}
