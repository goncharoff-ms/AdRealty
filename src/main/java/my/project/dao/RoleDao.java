package my.project.dao;

import my.project.domain.Role;
import my.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * DAO интерфейс на JPA для {@link Role}
 * там реализованны нужные для {@link Role}
 * @author Max Goncharov
 */
public interface RoleDao extends JpaRepository<Role, Long> {
}
