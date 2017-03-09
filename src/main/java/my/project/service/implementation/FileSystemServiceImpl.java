package my.project.service.implementation;

import ch.qos.logback.core.util.FileUtil;
import com.sun.xml.internal.bind.v2.TODO;
import my.project.service.interfaces.FileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.context.support.ServletContextParameterFactoryBean;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HttpServletBean;

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
        File file = new File("/resources/" + image);
        try {
            FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
        } catch (IOException e) {
            // TODO: 05.03.17 Написать логи
            throw new ImageUploadException("Не удалось сохранить изображение", e);
        }
    }
}
