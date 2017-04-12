package my.project.service.implementation;

import my.project.dao.AdDao;
import my.project.dao.UserDao;
import my.project.domain.User;
import my.project.service.interfaces.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.misc.resources.Messages_pt_BR;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserServiceImplTest {


    @Configuration
    static class AccountServiceTestContextConfiguration {
        @Bean
        public UserServiceImpl userServiceTEST() {
            return new UserServiceImpl(userDaoTEST());
        }
        @Bean
        public UserDao userDaoTEST() {
            return Mockito.mock(UserDao.class);
        }
    }

    private User user;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserServiceImpl userService;


    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId(1L);
        user.setLogin("login");
        user.setPassword("123123");
    }

    @Test
    public void addUser() throws Exception {
        userService.addUser(user);
        Mockito.verify(userDao).addUser(user);
    }

    @Test
    public void listUsers() throws Exception {
        List<User> list = new ArrayList<>();
        Mockito.when(userDao.listUser()).thenReturn(list);
        List resp = userService.listUsers();
        assertEquals(list, resp);
    }

    @Test
    public void removeUser() throws Exception {
        userService.removeUser(1L);
        Mockito.verify(userDao).removeUser(1L);
    }

    @Test
    public void findByLogin() throws Exception {
        Mockito.when(userDao.findByLogin(user.getLogin())).thenReturn(user);
        User resp = userService.findByLogin(user.getLogin());
        assertEquals(user, resp);
    }

    @Test
    public void findById() throws Exception {
        Mockito.when(userDao.getUser(user.getId())).thenReturn(user);
        User resp =userService.findById(1L);
        assertEquals(user, resp);
    }

}