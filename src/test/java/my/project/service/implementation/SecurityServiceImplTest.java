package my.project.service.implementation;

import my.project.dao.RoleDao;
import my.project.dao.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration
public class SecurityServiceImplTest {

        @Configuration
        static class UserDetailsServiceTestContextConfiguration {
            @Bean
            public SecurityServiceImpl securityServiceTEST() {
                return new SecurityServiceImpl(authenticationManagerTEST(), userDetailsServiceTEST());
            }
            @Bean
            public AuthenticationManager authenticationManagerTEST() {
                return Mockito.mock(AuthenticationManager.class);
            }
            @Bean
            public UserDetailsServiceImpl userDetailsServiceTEST() {
                return Mockito.mock(UserDetailsServiceImpl.class);
            }
        }

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private SecurityServiceImpl securityService;


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findLoggenedInLogin() throws Exception {

    }

    @Test
    public void autoLogin() throws Exception {
    }

}