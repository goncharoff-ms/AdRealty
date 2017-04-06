package my.project.domain;

import org.junit.Test;

import java.sql.Date;
import java.util.Calendar;


public class AdTest {

    @Test
    public void testAd() {
        Ad ad = new Ad();
        ad.setDate(new Date(System.currentTimeMillis()));
        System.out.println(ad.getDate());
    }
}
