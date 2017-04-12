package my.project.service.implementation;


import my.project.dao.UserDao;
import my.project.domain.User;
import my.project.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created 04.02.17.
 *
 * @author Max Goncharov
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public List listUsers() {
        return userDao.listUser();
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    @Override
    @Transactional
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }


    @Override
    @Transactional
    public User findById(Long user_id) {
        return userDao.getUser(user_id);
    }

}
