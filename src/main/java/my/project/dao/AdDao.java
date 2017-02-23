package my.project.dao;

import my.project.domain.Ad;
import my.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

/**
 * Created 22.02.17.
 *
 * @autor Max Goncharov
 */
public interface AdDao extends JpaRepository<Ad, Long> {
    @Query("select a from User a where a.name = :name")
    Set<Ad> findByName(@Param("name") String name);
}
