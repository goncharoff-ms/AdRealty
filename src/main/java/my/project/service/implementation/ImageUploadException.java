package my.project.service.implementation;

import java.io.IOException;

/**
 * Created 05.03.17.
 *
 * @autor Max Goncharov
 */
public class ImageUploadException extends Throwable {
    public ImageUploadException(String s, IOException e) {
        super(s,e);
    }
}
