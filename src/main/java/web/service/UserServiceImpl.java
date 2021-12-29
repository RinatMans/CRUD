package web.service;

import org.springframework.stereotype.Service;
import web.DAO.UserDAO;
import web.models.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDAO userDao;

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserID(int id) {
        return this.userDao.getUserID(id);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }

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

}
