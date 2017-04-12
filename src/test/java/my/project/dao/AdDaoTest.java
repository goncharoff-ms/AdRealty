package my.project.dao;


import my.project.domain.Ad;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;


public class AdDaoTest {


    private AdDao dao;

    private Session session = Mockito.mock(Session.class);

    private SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);

    private Ad ad;

    private Query query = Mockito.mock(Query.class);

    private List<Ad> list;


    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        dao = new AdDao(sessionFactory);
        ad = new Ad();
        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
        Mockito.when(session.createQuery("from Ad")).thenReturn(query);
        Mockito.when(query.list()).thenReturn(list);
    }

    @Test
    public void addAd() throws Exception {
        dao.addAd(ad);
        Mockito.verify(session).save(ad);
    }

    @Test
    public void listAd() throws Exception {
        List resp = dao.listAd();
        Assert.assertEquals(list, resp);
    }

    @Test
    public void removeAd() throws Exception {
        Mockito.when(session.get(Ad.class, 5L)).thenReturn(ad);
        dao.removeAd(5L);
        Mockito.verify(session).delete(ad);
    }

    @Test
    public void getAd() throws Exception {
        Mockito.when(session.get(Ad.class, 5L)).thenReturn(ad);
        Ad resp = dao.getAd(5L);
        Assert.assertEquals(ad, resp);
    }

    @Test
    public void updateAd() throws Exception {
        dao.updateAd(ad);
        Mockito.verify(session).saveOrUpdate(ad);
    }


}
