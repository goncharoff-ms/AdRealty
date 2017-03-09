package my.project.validator.supporting;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created 05.03.17.
 *
 * @autor Max Goncharov
 */
@Component
public class ImageValidator {
    public boolean validate(MultipartFile photo) {
        if(photo.getContentType().equals("image/jpeg") || photo.getContentType().equals("image/png")) {
            return true;
        }
        return false;
    }
}
