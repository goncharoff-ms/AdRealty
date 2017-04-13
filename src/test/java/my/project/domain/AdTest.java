package my.project.domain;

import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by max on 13.04.17.
 *
 * @autor Max Goncharov
 */

public class AdTest {

    private Ad ad = new Ad();

    @Test
    public void testMain() throws Exception {
        ad.setId(1L);
        assertEquals(new Long(1), ad.getId());

        ad.setDate(new Date(System.currentTimeMillis()));
        assertEquals(new Date(System.currentTimeMillis()), ad.getDate());

        ad.setName("test");
        assertEquals("test", ad.getName());

        ad.setPrice(123);
        assertEquals(new Integer(123), ad.getPrice());

        ad.setNumberShow(5);
        assertEquals(new Integer(5), ad.getNumberShow());

        ad.setHaveImage(1);
        assertEquals(new Integer(1), ad.getHaveImage());

        ad.setHouseNumber("5/2");
        assertEquals("5/2", ad.getHouseNumber());

        ad.setInfo("test test");
        assertEquals("test test", ad.getInfo());

        ad.setRealty("test");
        assertEquals("test", ad.getRealty());

        ad.setSity("test site");
        assertEquals("test site", ad.getSity());

        ad.setSqare(123);
        assertEquals(new Integer(123), ad.getSqare());

        ad.setTypeAd("test type");
        assertEquals("test type", ad.getTypeAd());

        ad.setUser_id(5L);
        assertEquals(new Long(5), ad.getUser_id());

        ad.setStreet("street");
        assertEquals("street", ad.getStreet());

    }

}