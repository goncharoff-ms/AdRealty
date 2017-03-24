package my.project.dao;



import my.project.domain.Image;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.LobCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

@Repository
public class ImageDAOHibernate {

    private final SessionFactory sessionFactory;

    @Autowired
    public ImageDAOHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addImage(MultipartFile file, Long idAd) {
        Image image = new Image();
        Blob blob = null;

        image.setName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setLength((int) file.getSize());

        try {
            LobCreator lobCreator = Hibernate.getLobCreator(sessionFactory.getCurrentSession());
            blob = lobCreator.createBlob(file.getInputStream(),file.getSize());
        } catch (IOException e) {
            e.printStackTrace();
        }
        image.setAdId(idAd);
        image.setContent(blob);

        sessionFactory.getCurrentSession().save(image);
    }

    public List listImage() {
        return sessionFactory.getCurrentSession().createQuery("from Image").list();
    }

    public void removeImage(Integer id) {
        Image image = this.getImage(id);
        if (null != image) {
            sessionFactory.getCurrentSession().delete(image);
        }
    }

    public Image getImage(Integer id) {
        return (Image) sessionFactory.getCurrentSession().get(Image.class, id);
    }

    public void updateImage(Image image) {
        sessionFactory.getCurrentSession().saveOrUpdate(image);
    }

}
