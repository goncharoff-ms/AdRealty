package my.project.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by max on 13.04.17.
 *
 * @autor Max Goncharov
 */

public class RoleTest {

    @Test
    public void mainTest() {
        Role role = new Role();

        role.setName("test");
        assertEquals("test", role.getName());

        role.setId(5L);
        assertEquals(new Long(5), role.getId());
    }
}