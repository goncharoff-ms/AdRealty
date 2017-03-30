package my.project.dao;



import my.project.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Interface DAO for User
 * Created by alastor on 04.02.17.
 * @author Max Goncharov
 */
@Repository
@Transactional
public class UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public List listUser() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    public void removeUser(Long id) {
        User user = getUser(id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    public User findByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User where login = :flogin");
        query.setParameter("flogin", login);
        if (query.list().size() == 0) {
            return null;
        } else {
            return (User) query.list().get(0);
        }
    }

    public User getUser(Long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    public void updateUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
}
