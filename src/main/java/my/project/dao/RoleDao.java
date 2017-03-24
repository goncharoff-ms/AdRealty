package my.project.dao;

import my.project.domain.Role;
import my.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * Created 22.02.17.
 *
 * @autor Max Goncharov
 */

@org.springframework.stereotype.Repository
public interface RoleDao extends JpaRepository<Role, Long> {

}
