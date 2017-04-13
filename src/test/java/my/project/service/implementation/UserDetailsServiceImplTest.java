package my.project.service.implementation;

import my.project.dao.AdDao;
import my.project.dao.RoleDao;
import my.project.dao.UserDao;
import my.project.domain.Role;
import my.project.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserDetailsServiceImplTest {

    @Configuration
    static class UserDetailsServiceTestContextConfiguration {
        @Bean
        public UserDetailsServiceImpl userDetailsService() {
            return new UserDetailsServiceImpl(userDao(), roleDao());
        }
        @Bean
        public UserDao userDao() {
            return Mockito.mock(UserDao.class);
        }
        @Bean
        public RoleDao roleDao() {
            return Mockito.mock(RoleDao.class);
        }
    }

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId(1L);
        user.setLogin("login");
        user.setPassword("123123");
        user.setRoleId(1L);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testException() throws UsernameNotFoundException {
        Mockito.when(userDao.findByLogin("qwe")).thenThrow(new UsernameNotFoundException("qwe"));
        userDetailsService.loadUserByUsername("qwe");
    }


    @Test
    public void loadUserByUsername() throws Exception {
        Mockito.when(userDao.findByLogin("login")).thenReturn(user);
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_USER");
        Mockito.when(roleDao.findOne(1L)).thenReturn(role);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        org.springframework.security.core.userdetails.User expected =
                new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), grantedAuthorities);


        org.springframework.security.core.userdetails.User resp =
                (org.springframework.security.core.userdetails.User) userDetailsService.loadUserByUsername("login");

        Assert.assertEquals(expected, resp);
    }


}