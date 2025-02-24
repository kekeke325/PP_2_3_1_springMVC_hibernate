package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class UserDAOImpl implements UserDAO {

    public UserDAOImpl() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        User managed = entityManager.merge(user);
        entityManager.persist(managed);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        User managed = entityManager.merge(user);
        entityManager.remove(managed);
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }
}
