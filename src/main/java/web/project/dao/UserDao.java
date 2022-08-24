package web.project.dao;

import org.springframework.stereotype.Component;
import web.project.entity.User;

import java.util.List;

@Component
public interface UserDao {
    public User saveUser(User user);
    public User deleteUser(User user);
    public User updateUser(User user);
    public User getUser(int id);

    List<User> usersList();
}
