package web.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private static int USER_COUNT;
    private List<User> users;
    {
        users = new ArrayList<>();
        users.add(new User(++USER_COUNT, "Rinat","@123Э",153451));
        users.add(new User(++USER_COUNT, "Love","@123Э", 50445));
        users.add(new User(++USER_COUNT, "Adelina","@123Э", 1451));
        users.add(new User(++USER_COUNT, "Liliana","@123Э", 945));
        users.add(new User(++USER_COUNT, "Archi","@123Э", 64));

    }

    @Override
    public List<User> index() {
        return users;
    }

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);

    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if (user != null) {
            session.delete(user);
        }
    }

    @Override
    public User getUserID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from users").list();

        return userList;
    }
}
