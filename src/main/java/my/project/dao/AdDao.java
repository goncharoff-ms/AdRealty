package my.project.dao;


import my.project.domain.Ad;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class AdDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public AdDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addAd(Ad ad) {

        sessionFactory.getCurrentSession().save(ad);
    }

    public List listAd() {
        return sessionFactory.getCurrentSession().createQuery("from Ad").list();
    }

    public void removeAd(Long id) {
        Ad ad = getAd(id);
        if (null != ad) {
            sessionFactory.getCurrentSession().delete(ad);
        }
    }



    public Ad getAd(Long id) {
        return (Ad) sessionFactory.getCurrentSession().get(Ad.class, id);
    }

    public void updateAd(Ad ad) {
        sessionFactory.getCurrentSession().saveOrUpdate(ad);
    }


}
