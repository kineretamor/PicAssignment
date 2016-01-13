import org.junit.Test;

import java.awt.image.BufferedImage;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kineret on 1/12/16.
 */
public class editImageTest {

    EditImage editImage = new EditImage();
    DownloadFile downloadFile = new DownloadFile();


    @Test
    public void testResizeImage() throws Exception {
        URL url = new URL("http://carbl.com/im/2013/07/Suzuki-Swift-5d-600x324.jpg");

        //Download image
        BufferedImage orgImg = downloadFile.downloadImage(url);

        //Change image size 200X200
        BufferedImage editedImg = editImage.resizeImage(orgImg, 200, 200);

        assertNotNull(editedImg);
        assertEquals(editedImg.getRaster().getWidth(), 200);
        assertEquals(editedImg.getRaster().getHeight(), 200);

        //Change image size 243X189
        editedImg = editImage.resizeImage(orgImg, 243, 189);

        assertNotNull(editedImg);
        assertEquals(editedImg.getRaster().getWidth(), 243);
        assertEquals(editedImg.getRaster().getHeight(), 189);

    }

    @Test
    public void testConvertToGrayScaleImage() throws Exception {
        URL url = new URL("http://carbl.com/im/2013/07/Suzuki-Swift-5d-600x324.jpg");

        //Download image
        BufferedImage orgImg = downloadFile.downloadImage(url);

        BufferedImage editedImage = editImage.convertToGrayScaleImage(orgImg);
        assertNotNull(editedImage);
    }
}
