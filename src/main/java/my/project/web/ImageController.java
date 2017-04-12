package my.project.web;

import my.project.domain.Image;

import my.project.service.implementation.ImageService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;

@Controller
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(@Qualifier("imageService") ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping("/manageAllImages")
    public String listImages(Model model){
        model.addAttribute("image", new Image());
        model.addAttribute("imageList", imageService.listImage());
        return "manageallimages";
    }

    @RequestMapping(value="/new/image", method=RequestMethod.POST)
    public String addImage(@RequestParam("file") MultipartFile file){
        if(!file.isEmpty())imageService.addImage(file, 1L);
        return "redirect:/ad";
    }

    @RequestMapping(value="/deleteImage/{imageId}")
    public String deleteImage(@PathVariable("imageId") Long id){
        imageService.removeImage(id);
        return "redirect:/manageAllImages";
    }

    // Display the image...
    @RequestMapping(method=RequestMethod.GET, value="/image/{id}")
    public void getImage(Model model, @PathVariable("id") Long imageId, HttpServletResponse response) throws ServletException, IOException{
      /*
       * Big thanks to BalusC for this part
       * cf. his post on http://balusc.blogspot.ch/2007/04/imageservlet.html
       */

        // Check if ID is supplied to the request.
        if (imageId == null) {
            // Do your thing if the ID is not supplied to the request.
            // Throw an exception, or send 404, or show default/warning image, or just ignore it.
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }

        // Lookup Image by ImageId in database.
        // Do your "SELECT * FROM Image WHERE ImageID" thing.
        Image image = imageService.getImageByOwnerId(imageId);

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

