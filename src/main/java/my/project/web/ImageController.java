package my.project.web;

import my.project.domain.Image;
import my.project.service.interfaces.ImageService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;


public class ImageController {


    private final SessionFactory sessionFactory;

    private final ImageService imageService;

    private final TransactionTemplate transactionTemplate;

    @Autowired
    public ImageController(SessionFactory sessionFactory, ImageService imageService, TransactionTemplate transactionTemplate) {
        this.sessionFactory = sessionFactory;
        this.imageService = imageService;
        this.transactionTemplate = transactionTemplate;
    }


    @RequestMapping("/admin/all/images")
    public String listImages(Model model){
        model.addAttribute("image", new Image());
        model.addAttribute("imageList", imageService.listImage());
        return "manageallimages";
    }

/*

    @Transactional
    @RequestMapping(value="/image/add/", method = RequestMethod.POST)
    public String addImage(@RequestParam("file") MultipartFile file,  @RequestParam("adId") Long idAd) throws IOException {
        if (!file.isEmpty()) {
            Image image = new Image();
            Blob blob = null;

            image.setName(file.getOriginalFilename());
            image.setContentType(file.getContentType());
            image.setLength((int) file.getSize());

            try {
                LobCreator lobCreator = Hibernate.getLobCreator(sessionFactory.getCurrentSession());
                blob = lobCreator.createBlob(file.getInputStream(), file.getSize());
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.setAdId(idAd);
            image.setContent(blob);

            imageService.addImage(image);
        }
        return "redirect:/ad";
    }


*/

    @RequestMapping(value="/image/delete/{imageId}")
    public String deleteImage(@PathVariable("imageId") Integer id){
        imageService.removeImage(Long.valueOf(id));
        return "redirect:/manageAllImages";
    }

    @RequestMapping(method=RequestMethod.GET, value="/image/{id}")
    public void getImage(Model model, @PathVariable("id") Integer imageId, HttpServletResponse response) throws ServletException, IOException{
        if (imageId == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }
        // Lookup Image by ImageId in database.
        // Do your "SELECT * FROM Image WHERE ImageID" thing.
        Image image = imageService.findById(Long.valueOf(imageId));

        // Check if image is actually retrieved from database.
        if (image == null) {
            // Do your thing if the image does not exist in database.
            // Throw an exception, or send 404, or show default/warning image, or just ignore it.
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }

        // Init servlet response.
        response.reset();
        int DEFAULT_BUFFER_SIZE = 10240;
        response.setBufferSize(DEFAULT_BUFFER_SIZE);
        response.setContentType(image.getContentType());
        response.setHeader("Content-Length", String.valueOf(image.getLength()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + image.getName() + "\"");

        // Prepare streams.
        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            // Open streams.
            try {
                input = new BufferedInputStream(image.getContent().getBinaryStream(), DEFAULT_BUFFER_SIZE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);
            // Write file contents to response.
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } finally {
            // Gently close streams.
            close(output);
            close(input);
        }
    }

    // Helper (can be refactored to public utility class)
    private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                // Do your thing with the exception. Print it, log it or mail it.
                e.printStackTrace();
            }
        }
    }
}
