package my.project.service.implementation;

import my.project.dao.ImageDAOHibernate;
import my.project.domain.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
public class ImageService {


    private final ImageDAOHibernate imageDAO;

    @Autowired
    public ImageService(ImageDAOHibernate imageDAO) {
        this.imageDAO = imageDAO;
    }

    @Transactional
    public void addImage(MultipartFile file, Long idAd) {
        imageDAO.addImage(file, idAd);
    }

    @Transactional
    public List listImage() {
        return imageDAO.listImage();
    }

    @Transactional
    public void removeImage(Integer id) {
        imageDAO.removeImage(id);
    }

    @Transactional
    public Image getImage(Integer id) {
        return imageDAO.getImage(id);
    }

    @Transactional
    public void updateImage(Image account) {
        imageDAO.updateImage(account);
    }
}
