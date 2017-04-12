package my.project.dao;

import my.project.domain.Ad;
import my.project.domain.Image;
import my.project.domain.User;
import my.project.service.implementation.UserDetailsServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by max on 12.04.17.
 *
 * @author Max Goncharov
 */


public class UserDaoTest {

    private UserDao userDao;

    private SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);

    private Session session = Mockito.mock(Session.class);

    private Query query = Mockito.mock(Query.class);

    private List<User> list;

    private User user;


    @Before
    public void setUp() throws Exception {

        list = new ArrayList<>();
        userDao = new UserDao(sessionFactory);
        user = new User();
        list.add(user);
        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
        Mockito.when(session.createQuery(Mockito.anyString())).thenReturn(query);
        Mockito.when(query.list()).thenReturn(list);
        Mockito.when(session.get(User.class, 5L)).thenReturn(user);
    }

    @Test
    public void addUser() throws Exception {
        userDao.addUser(user);
        Mockito.verify(session).save(user);
    }

    @Test
    public void listUser() throws Exception {
        List resp = userDao.listUser();
        Assert.assertEquals(list, resp);
    }

    @Test
    public void removeUser() throws Exception {
        userDao.removeUser(5L);
        Mockito.verify(session).delete(user);
    }

    @Test
    public void findByLogin() throws Exception {
        User resp = userDao.findByLogin("login");
        Assert.assertEquals(user, resp);
    }

    @Test
    public void getUser() throws Exception {
        User resp = userDao.getUser(5L);
        Assert.assertEquals(user, resp);
    }

    @Test
    public void updateUser() throws Exception {
        userDao.updateUser(user);
        Mockito.verify(session).saveOrUpdate(user);
    }

}