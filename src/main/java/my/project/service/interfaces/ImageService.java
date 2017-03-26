package my.project.service.interfaces;

import my.project.domain.Ad;
import my.project.domain.Image;

import java.util.List;
import java.util.Set;


public interface ImageService {
    void addImage(Image image);
    void removeImage(Long id);
    List<Image> listImage();
    Image updateImage(Image image);
    Image findById(Long id);
 }
