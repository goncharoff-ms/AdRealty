package my.project.service.implementation;

import my.project.exception.ImageUploadException;
import my.project.service.interfaces.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created 05.03.17.
 *
 * @autor Max Goncharov
 */
@Service
public class FileSystemServiceImpl implements FileService {


    @Override
    public void saveImage(String image, MultipartFile multipartFile) throws ImageUploadException {
        File file = new File( "images/" + image + ".jpg");
        try {
            FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
        } catch (IOException e) {
            // TODO: 05.03.17 Написать логи
            throw new ImageUploadException("Не удалось сохранить изображение", e);
        }
    }
}
