package my.project.dao;


import my.project.domain.Ad;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * DAO класс для {@link Ad}
 * @author Max Goncharov
 */
@Repository
@Transactional
public class AdDao {

    private final SessionFactory sessionFactory;

    /**
     * @param sessionFactory фабрика для {@link org.hibernate.Session}
     */
    @Autowired
    public AdDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * добавление объявления
     * @param ad объявление
     */
    public void addAd(Ad ad) {
        sessionFactory.getCurrentSession().save(ad);
    }

    /**
     * @return список всех объявлений
     */
    public List listAd() {
        return sessionFactory.getCurrentSession().createQuery("from Ad").list();
    }

    /**
     * удаляет выбранное объявление
     * @param id номер объявления для удаления
     */
    public void removeAd(Long id) {
        Ad ad = sessionFactory.getCurrentSession().get(Ad.class, id);
        if (null != ad) {
            sessionFactory.getCurrentSession().delete(ad);
        }
    }


    /**
     * Получить объявление по id
     * @param id - id объявления
     * @return нужное объявление по id
     */
    public Ad getAd(Long id) {
        return (Ad) sessionFactory.getCurrentSession().get(Ad.class, id);
    }

    /**
     * Обновить уже сохраненное объявление
     * @param ad объявление
     */
    public void updateAd(Ad ad) {
        sessionFactory.getCurrentSession().saveOrUpdate(ad);
    }


}
