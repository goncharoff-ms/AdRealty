package my.project.service.interfaces;


import my.project.domain.User;

import java.util.List;

/**
 * Created 04.02.17.
 *
 * @author Max Goncharov
 */


public interface UserService {
    void addUser(User user);
    List listUsers();
    void removeUser(Long id);
    User findByLogin(String login);
    User findById(Long user_id);
}
