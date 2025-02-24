package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    void saveUser(User user);

    User getById(Long id);

    void deleteUser(User user);
}
