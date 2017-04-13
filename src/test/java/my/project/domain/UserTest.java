package my.project.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by max on 13.04.17.
 *
 * @autor Max Goncharov
 */

public class UserTest {

    @Test
    public void testMain() {
        User user = new User();

        user.setId(5L);
        user.setLogin("test");
        user.setEmail("test@test.ru");
        user.setName("name");
        user.setPassword("123123");
        user.setPhone("123123");
        user.setRoleId(1L);

        assertEquals(new Long(5), user.getId());
        assertEquals("test", user.getLogin());
        assertEquals("test@test.ru", user.getEmail());
        assertEquals("name", user.getName());
        assertEquals("123123", user.getPassword());
        assertEquals("123123", user.getPhone());
        assertEquals(new Long(1L), user.getRoleId());
    }

}