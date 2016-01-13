import org.apache.log4j.Logger;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kineret on 1/12/16.
 */
public class downloadFileTest {
    protected static Logger _logger = Logger.getRootLogger();

    DownloadFile downloadFile = new DownloadFile();

    @Test
    public void testDownloadFile() throws Exception {
        URL url = new URL("http://carbl.com/im/2013/07/Suzuki-Swift-5d-600x324.jpg");

        //Download image
        BufferedImage orgImg = downloadFile.downloadImage(url);

        assertNotNull(orgImg);

    }

    @Test
    public void testSaveImage() throws Exception {
        URL url = new URL("http://carbl.com/im/2013/07/Suzuki-Swift-5d-600x324.jpg");
        //Create a folder if not exists, to save the file
        boolean success = (new File(System.getProperty("user.home") + "/Desktop/corticaJavaImageAssignment")).mkdirs();
        if (!success) {
            _logger.debug("Problem with create new folder on desktop");
        }
        String destination = System.getProperty("user.home") + "/Desktop/corticaJavaImageAssignment/org.jpg";

        String imageFormat = url.toString().substring(url.toString().lastIndexOf(".") + 1);
        String dstPath = url.toString().substring(0, url.toString().indexOf(imageFormat) -1);

        File file = new File(destination);
        file.delete();

        boolean check = new File(dstPath, imageFormat).exists();
        assertFalse(check);
        //Download image
        BufferedImage image = downloadFile.downloadImage(url);

        downloadFile.saveImage(image, imageFormat, destination);

        //Check that the new file created
        check = new File(destination).exists();
        assertTrue(check);

    }
}
