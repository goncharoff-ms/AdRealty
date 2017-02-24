package my.project.service.implementation;

import my.project.dao.AdDao;
import my.project.domain.Ad;
import my.project.service.interfaces.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created 24.02.17.
 * Класс-сервис объявлений.
 * @autor Max Goncharov
 */
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdDao adDao;


    @Override
    @Transactional
    public void addAd(Ad ad) {
        adDao.saveAndFlush(ad);
    }

    @Override
    @Transactional
    public void removeAd(Long id) {
        adDao.delete(id);
    }

    @Override
    @Transactional
    public List<Ad> listAd() {
        return adDao.findAll();
    }
    
    @Override
    @Transactional
    public Ad updateAd(Ad ad) {
        return adDao.saveAndFlush(ad);
    }

    @Override
    public Ad findById(Long id) {
        return adDao.findOne(id);
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
        return adDao.findByName(name);
    }
}
