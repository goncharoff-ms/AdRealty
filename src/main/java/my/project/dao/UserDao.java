package my.project.dao;



import my.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface DAO for User
 * Created by alastor on 04.02.17.
 * @author Max Goncharov
 */
@Repository

public interface UserDao extends JpaRepository<User, Long> {
    @Query("select u from User u where u.login = :login")
    User findByLogin(@Param("login") String login);
}
