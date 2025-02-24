package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    void saveUser(User user);

    void deleteUser(User user);

    User getById(Long id);
}
