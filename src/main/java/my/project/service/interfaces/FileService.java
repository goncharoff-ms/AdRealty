package my.project.service.interfaces;

import my.project.exception.ImageUploadException;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created 05.03.17.
 *
 * @autor Max Goncharov
 */
public interface FileService {
    void saveImage(String image, MultipartFile multipartFile) throws ImageUploadException;
}
