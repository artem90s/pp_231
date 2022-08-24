package web.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import web.project.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> usersList() {
        List<User>allUsers=entityManager.createQuery("from User").getResultList();
        return allUsers;
    }

    @Override
    public User saveUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User deleteUser(User user) {
        if (entityManager.contains(user)) {
            entityManager.remove(user);
        } else {
            entityManager.remove(entityManager.merge(user));
        }
        return user;
    }

    @Override
    public User updateUser(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public User getUser(int id) {
        User response = (User) entityManager.find(User.class, id);
        return response;
    }
}
