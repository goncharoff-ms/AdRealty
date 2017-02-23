package my.project.domain;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.hibernate.Hibernate;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class UserTest {

    private User user;

    @Test
    public void testPOJO() {
        user = new User();
        user.setEmail("a@b.eo");
        Assert.assertEquals("a@b.eo", user.getEmail());
        user.setId(1L);
        Assert.assertEquals(new Long(1), user.getId());
        user.setLogin("login");
        Assert.assertEquals("login", user.getLogin());
        user.setPassword("123123");
        Assert.assertEquals("123123", user.getPassword());
        user.setPhone("+11111111");
        Assert.assertEquals("+11111111", user.getPhone());
    }


}