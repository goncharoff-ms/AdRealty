package my.project.service.implementation;

import junit.framework.TestCase;
import my.project.dao.AdDao;
import my.project.domain.Ad;
import my.project.service.interfaces.AdService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


/**
 * Тест класса-сервиса объявлений
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
public class AdServiceImplTest {

    @Configuration
    static class AccountServiceTestContextConfiguration {
        @Bean
        public AdServiceImpl adServiceImplTEST() {
            return new AdServiceImpl(adDaoTEST());
        }
        @Bean
        public AdDao adDaoTEST() {
            return Mockito.mock(AdDao.class);
        }
    }

    @Autowired
    private AdServiceImpl adService;

    @Autowired
    private AdDao adDao;

    private Ad ad;


    @Before
    public void setUp() throws Exception {
        ad = new Ad();
        ad.setId(1L);
    }

    @Test
    public void testAdd() {
        adService.addAd(ad);
        verify(adDao).addAd(ad);
    }

    @Test
    public void testGet() {
        Mockito.when(adDao.getAd(ad.getId())).thenReturn(ad);
        Ad resp = adService.findById(ad.getId());
        Assert.assertEquals(ad, resp);
    }

    @Test
    public void testRemove() {
        adService.removeAd(5L);
        Mockito.verify(adDao).removeAd(5L);
    }

    @Test
    public void testList() {
        List list = new ArrayList();
        when(adDao.listAd()).thenReturn(list);
        List resp = adService.listAd();
        Assert.assertEquals(list, resp);
    }

    @Test
    public void testSortedById() {
        Ad ad1 = new Ad();
        ad1.setId(1L);
        Ad ad2 = new Ad();
        ad2.setId(2L);

        List<Ad> ads = new ArrayList<>();
        ads.add(ad2);
        ads.add(ad1);

        List<Ad> expected = new ArrayList<>();
        expected.add(ad2);
        expected.add(ad1);

        Mockito.when(adDao.listAd()).thenReturn(ads);

        List resp = adService.sortedByIdListAd();

        Assert.assertEquals(true, expected.equals(resp));


    }

    @Test
    public void testUpdate() {
        adService.updateAd(ad);
        Mockito.verify(adDao).updateAd(ad);
    }


    @Test
    public void testFindByPrice() {
        Assert.assertEquals(null, adService.findByName("TEST"));
    }



    @Test
    public void testFindByName() {
        Assert.assertEquals(null, adService.findByPrice(1000));
    }







    public void tearDown() throws Exception {

    }

}