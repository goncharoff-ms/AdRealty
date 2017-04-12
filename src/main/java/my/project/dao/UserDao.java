package my.project.dao;



import my.project.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DAO класс для {@link User}
 * @author Max Goncharov
 */
@Repository
@Transactional
public class UserDao {


    private final SessionFactory sessionFactory;

    /**
     * @param sessionFactory фабрика для {@link org.hibernate.Session}
     */
    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Добавление нового пользователя
     * @param user сам пользователь
     */
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    /**
     * @return спиок всех пользователей
     */
    public List listUser() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    /**
     * @param id удаляет выбранного пользователя
     */
    public void removeUser(Long id) {
        User user = sessionFactory.getCurrentSession().get(User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    /**
     * Найти пользователя по логину
     * @param login сам логин
     * @return нужный пользователей
     */
    public User findByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User where login = :flogin");
        query.setParameter("flogin", login);
        if (query.list().size() == 0) {
            return null;
        } else {
            return (User) query.list().get(0);
        }
    }

    /**
     * Получить пользователя по id
     * @param id cам id
     * @return пользователя
     */
    public User getUser(Long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    /**
     * Обновить пользвателя
     * @param user сам пользователь
     */
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
}
