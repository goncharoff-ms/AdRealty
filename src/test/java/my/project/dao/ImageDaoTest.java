package my.project.dao;

import my.project.domain.Ad;
import my.project.domain.Image;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.stream.IIOByteBuffer;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by max on 11.04.17.
 *
 * @author Max Goncharov
 */

public class ImageDaoTest {

    private ImageDao imageDao;

    private SessionFactory sessionFactory = Mockito.mock(SessionFactory.class);

    private Session session = Mockito.mock(Session.class);


    private Image image;

    private Query query = Mockito.mock(Query.class);

    private List<Image> list;


    @Before
    public void setUp() throws Exception {
        imageDao = new ImageDao(sessionFactory);
        image = new Image();
        image.setId(5);
        list = new ArrayList<>();
        list.add(image);
        Mockito.when(sessionFactory.getCurrentSession()).thenReturn(session);
        Mockito.when(session.createQuery(Mockito.anyString())).thenReturn(query);
        Mockito.when(query.list()).thenReturn(list);

        Mockito.when(session.get(Image.class, 5L)).thenReturn(image);

     }


    @Test
    @Ignore
    public void addImage() throws Exception {
        imageDao.addImage( null, 5L);
        Mockito.verify(session).save(Mockito.any());
    }

    @Test
    public void listImage() throws Exception {
        List resp = imageDao.listImage();
        Assert.assertEquals(list, resp);
    }

    @Test
    public void removeImage() throws Exception {
        imageDao.removeImage(5L);
        Mockito.verify(session).delete(image);
    }

    @Test
    public void getImageByOwnerId() throws Exception {
        Image resp = imageDao.getImageByOwnerId(1L);
        Assert.assertEquals(image, resp);
    }

    @Test
    public void getImage() throws Exception {
        Image resp = imageDao.getImage(5L);
        Assert.assertEquals(image, resp);
    }

    @Test
    public void updateImage() throws Exception {
        imageDao.updateImage(image);
        Mockito.verify(session).saveOrUpdate(image);
    }

}