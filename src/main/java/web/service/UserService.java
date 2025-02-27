package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User getById(Long id);
}
