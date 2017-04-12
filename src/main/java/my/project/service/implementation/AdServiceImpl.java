package my.project.service.implementation;

import my.project.dao.AdDao;
import my.project.domain.Ad;
import my.project.service.interfaces.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created 24.02.17.
 * Класс-сервис объявлений.
 * @author Max Goncharov
 */
@Service
public class AdServiceImpl implements AdService {

    private final AdDao adDao;

    @Autowired
    public AdServiceImpl(AdDao adDao) {
        this.adDao = adDao;
    }


    /**
     *
     * @param ad
     */
    @Override
    @Transactional
    public void addAd(Ad ad) {
        adDao.addAd(ad);
    }

    @Override
    @Transactional
    public void removeAd(Long id) {
        adDao.removeAd(id);
    }

    @Override
    @Transactional
    public List listAd() {
        return adDao.listAd();
    }

    @Override
    @Transactional
    public List sortedByIdListAd() {
        List req = adDao.listAd();
        req.sort(new Comparator<Ad>() {
            @Override
            public int compare(Ad ad1, Ad ad2) {
                return ad2.getId().compareTo(ad1.getId());
            }
        });
        return req;
    }

    @Override
    @Transactional
    public void updateAd(Ad ad) {
         adDao.updateAd(ad);
    }

    @Override
    public Ad findById(Long id) {
        return adDao.getAd(id);
    }

    @Override
    @Transactional
    public Set<Ad> findByPrice(Integer minPrice) {
        // TODO: 24.02.17  Дописать реализацию!
        return null;
    }

    @Override
    @Transactional
    public Set<Ad> findByName(String name) {
        // TODO: 08.04.17 Доделать для соритровки объявлений 
        return null;
    }
}
