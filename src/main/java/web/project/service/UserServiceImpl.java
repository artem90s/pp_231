package web.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.project.dao.UserDao;
import web.project.dao.UserDaoImpl;
import web.project.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao (UserDao userDao){
        this.userDao=userDao;
    }

    @Transactional
    public User saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Transactional
    public User deleteUser(User user) {
        return userDao.deleteUser(user);
    }

    @Transactional
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Transactional
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public List<User> usersList() {
        return userDao.usersList();
    }
}
