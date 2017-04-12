package my.project.service.implementation;

import my.project.dao.ImageDao;
import my.project.dao.UserDao;
import my.project.domain.Image;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Verifier;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ImageServiceTest {

    @Configuration
    static class ImageServiceTestContextConfiguration {
        @Bean
        public ImageService imageServiceTEST() {
            return new ImageService(imageDaoTEST());
        }
        @Bean
        public ImageDao imageDaoTEST() {
            return Mockito.mock(ImageDao.class);
        }
    }

    private Image image;

    @Qualifier("imageServiceTEST")
    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageDao imageDao;



    @Before
    public void setUp() throws Exception {
        image = new Image();
    }

    @Test
    public void addImage() throws Exception {
        imageService.addImage(null, 2L);
        Mockito.verify(imageDao).addImage(null,2L);
    }

    @Test
    public void listImage() throws Exception {
        ArrayList asd = new ArrayList();
        Mockito.when(imageDao.listImage()).thenReturn(asd);
        List resp = imageService.listImage();
        Mockito.verify(imageDao).listImage();
        Assert.assertEquals(asd, resp);
    }

    @Test
    public void removeImage() throws Exception {
        imageService.removeImage(1L);
        Mockito.verify(imageDao).removeImage(1L);
    }

    @Test
    public void getImageByOwnerId() throws Exception {
        Mockito.when(imageDao.getImageByOwnerId(1L)).thenReturn(image);
        Image resp = imageService.getImageByOwnerId(1L);
        assertEquals(image, resp);
    }

    @Test
    public void getImage() throws Exception {
        Mockito.when(imageDao.getImage(1L)).thenReturn(image);
        Image resp = imageService.getImage(1L);
        assertEquals(image,resp);
    }

    @Test
    public void updateImage() throws Exception {
        imageService.updateImage(image);
        Mockito.verify(imageDao).updateImage(image);
    }

}