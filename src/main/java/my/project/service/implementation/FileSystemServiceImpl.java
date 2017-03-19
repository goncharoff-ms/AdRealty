package my.project.service.implementation;

import my.project.exception.ImageUploadException;
import my.project.service.interfaces.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.xml.ws.soap.Addressing;
import java.io.File;
import java.io.IOException;

/**
 * Created 05.03.17.
 *
 * @autor Max Goncharov
 */
@Service
public class FileSystemServiceImpl implements FileService {


    @Autowired
    private HttpSession servletContext;


    @Override
    public void saveImage(String nameImage, MultipartFile multipartFile) throws ImageUploadException {
        ApplicationParameters.create(servletContext.getServletContext());
        File file = new File( ApplicationParameters.getPathToImage() + "/" + nameImage + ".jpg");
        try {
            FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
        } catch (IOException e) {
            // TODO: 05.03.17 Написать логи
            throw new ImageUploadException("Не удалось сохранить изображение", e);
        }

    }

    @Override
    public String getPathImageById(String id) {
        ApplicationParameters.create(servletContext.getServletContext());
        File buff = new File(ApplicationParameters.getPathToImage() + "/" + id + ".jpg");
        if (buff.isFile()) {
            return buff.getPath();
        }
        return "";
    }
}
