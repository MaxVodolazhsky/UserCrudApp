package users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import users.model.User;

import javax.jws.soap.SOAPBinding;


@Component
public class UsersDaoImpl implements UsersDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public String getLogin(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user.getLogin();
    }

    public String getPass(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user.getPassword();
    }

    public String getPassAndName(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user.getLogin() + " " + user.getPassword();
    }
}
