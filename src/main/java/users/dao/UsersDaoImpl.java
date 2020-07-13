package users.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import users.model.User;

import java.util.List;


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

    public String getPassAndLog(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user.getLogin() + " " + user.getPassword();
    }


    public void setLogin(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }

    public void setPass(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void remove(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from users").list();
    }
}
