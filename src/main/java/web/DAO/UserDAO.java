package web.DAO;

import web.models.User;

import java.util.List;

public interface UserDAO {
    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserID(int id);

    public List<User> listUsers();
}
