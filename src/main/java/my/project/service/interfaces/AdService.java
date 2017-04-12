package my.project.service.interfaces;

import my.project.domain.Ad;

import java.util.List;
import java.util.Set;

/**
 * Created 22.02.17.
 *
 * @author Max Goncharov
 */
public interface AdService {
    void addAd(Ad ad);
    void removeAd(Long id);
    List listAd();
    List sortedByIdListAd();
    void updateAd(Ad ad);
    Ad findById(Long id);
    Set<Ad> findByPrice(Integer minPrice);
    Set<Ad> findByName(String name);
}
