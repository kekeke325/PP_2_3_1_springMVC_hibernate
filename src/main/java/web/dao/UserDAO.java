package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    void addUser(User user);

    void updateUser(User user);

    User getById(Long id);

    void deleteUser(Long id);
}
