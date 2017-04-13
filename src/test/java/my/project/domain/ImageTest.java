package my.project.domain;

import com.mysql.jdbc.Blob;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by max on 13.04.17.
 *
 * @autor Max Goncharov
 */

public class ImageTest {

    private Image image;

    @Before
    public void setUp() throws Exception {
        image = new Image();
    }

    @Test
    public void testMain() {
        image.setId(5);
        assertEquals(new Integer(5), image.getId());

        image.setAdId(5L);
        assertEquals(new Long(5), image.getAdId());

        image.setContent(null);
        assertEquals(null, image.getContent());

        image.setContentType("qwe");
        assertEquals("qwe", image.getContentType());

        image.setLength(23);
        assertEquals(new Integer(23), image.getLength());

        image.setName("test");
        assertEquals("test", image.getName());

    }

}