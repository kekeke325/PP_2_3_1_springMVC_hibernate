package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }
}
