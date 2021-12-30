package web.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private static int count;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        //user.setId(++count);
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User user) {
        User userNew = entityManager.getReference(User.class, id);
        userNew.setName(user.getName());
        userNew.setEmail(user.getEmail());
        userNew.setSalary(user.getSalary());
    }

    @Override
    public void removeUser(int id) {
        entityManager.remove(getUserID(id));
    }

    @Override
    public User getUserID(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> index() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

}
