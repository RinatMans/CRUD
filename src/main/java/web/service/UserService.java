package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    public void updateUser(int id, User user);

    public void removeUser(int id);

    public User getUserID(int id);

    public List<User> index();

}
