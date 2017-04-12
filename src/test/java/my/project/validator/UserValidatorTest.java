package my.project.validator;

import my.project.domain.User;
import my.project.service.interfaces.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by max on 12.04.17.
 *
 * @author Max Goncharov
 */


public class UserValidatorTest {

    private UserService userService = Mockito.mock(UserService.class);

    private UserValidator userValidator;
    private User user, userFalse;

    @Before
    public void setUp() throws Exception {
        userValidator = new UserValidator(userService);
        user = new User();
        user.setLogin("login228_");
        user.setPassword("password");
        user.setEmail("email@mail.eu");
        Mockito.when(userService.findByLogin(user.getLogin())).thenReturn(null);


        userFalse = new User();
        userFalse.setLogin("as");
        userFalse.setPassword("123");
        userFalse.setEmail("23.asd.23");
        Mockito.when(userService.findByLogin(userFalse.getLogin())).thenReturn(userFalse);


    }

    @Test
    public void supports() throws Exception {
        boolean tresp = userValidator.supports(User.class);
        Assert.assertEquals(true, tresp);

        boolean fresp = userValidator.supports(Objects.class);
        Assert.assertEquals(false, fresp);
    }

    @Test
    public void validate() throws Exception {
        BindingResult bindingResult = Mockito.mock(BindingResult.class);
        userValidator.validate(user, bindingResult);
        Mockito.verify(bindingResult, Mockito.never()).rejectValue(Mockito.anyString(), Mockito.anyString());

        userValidator.validate(userFalse, bindingResult);
        Mockito.verify(bindingResult, Mockito.times(4)).rejectValue(Mockito.anyString(), Mockito.anyString());
    }

}