package my.project.service.implementation;

import junit.framework.TestCase;
import org.hibernate.result.Output;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author max
 */
public class FileSystemServiceImplTest {

    @Test
    public void testerS() throws IOException {
        File file = new File("RERUN");
        System.out.println(file.getAbsolutePath());
        OutputStream outputStream = Files.newOutputStream(Paths.get(file.getPath()));
        outputStream.write('1');
        outputStream.flush();

    }

}