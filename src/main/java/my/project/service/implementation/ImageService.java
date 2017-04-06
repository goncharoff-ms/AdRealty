package my.project.service.implementation;

import my.project.dao.ImageDao;
import my.project.domain.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ImageService {


    private final ImageDao imageDAO;

    @Autowired
    public ImageService(ImageDao imageDAO) {
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
    public void removeImage(Long id) {
        imageDAO.removeImage(id);
    }



    @Transactional
    public List<Image> getImageByOwnerId(Long id) {
        return imageDAO.getImageByOwnerId(id);
    }

    @Transactional
    public Image getImage(Long id) {
        return imageDAO.getImage(id);
    }

    @Transactional
    public void updateImage(Image account) {
        imageDAO.updateImage(account);
    }
}
