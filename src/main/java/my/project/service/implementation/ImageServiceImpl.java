package my.project.service.implementation;

import my.project.dao.ImageDAO;
import my.project.domain.Image;
import my.project.service.interfaces.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    private final ImageDAO imageDAO;

    @Autowired
    public ImageServiceImpl(ImageDAO imageDAO) {
        this.imageDAO = imageDAO;
    }

    @Override
    @Transactional
    public void addImage(Image image) {
        imageDAO.save(image);
    }

    @Override
    @Transactional
    public void removeImage(Long id) {
        imageDAO.delete(id);
    }

    @Override
    @Transactional
    public List<Image> listImage() {
        return imageDAO.findAll();
    }

    @Override
    public Image updateImage(Image image) {
        return null;
    }

    @Override
    public Image findById(Long id) {
        return imageDAO.findOne(id);
    }
}
