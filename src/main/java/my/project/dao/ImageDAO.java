package my.project.dao;

import my.project.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDAO extends JpaRepository<Image, Long> {
}
