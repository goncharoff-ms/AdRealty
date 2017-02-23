package my.project.service.interfaces;

import my.project.domain.Ad;

import java.util.List;
import java.util.Set;

/**
 * Created 22.02.17.
 *
 * @autor Max Goncharov
 */
public interface AdService {
    void addAd(Ad ad);
    void removeAd(Long id);
    List<Ad> listAd();
    Ad updateAd(Ad ad);
    Set<Ad> findByPrice(Integer minPrice);
    Set<Ad> findByName(String name);
}
