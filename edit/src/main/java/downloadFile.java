import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by kineret on 1/10/16.
 */
public class DownloadFile {

    public BufferedImage downloadImage(URL imageToDownload) {
        //Download image
        BufferedImage image = null;
        try {
            //Read the file
            image = ImageIO.read(imageToDownload);
            // LOGGER.debug("Image downloaded");

        } catch (IOException e) {
            e.printStackTrace(); //Useless

        }
        return image;
    }

    public void saveImage(BufferedImage image, String imageFormat, String destination) {

        //Save the file
        try {
            // retrieve image
            File outputFile = new File(destination);
            ImageIO.write(image, imageFormat, outputFile);
            // LOGGER.debug("Image saved");

        } catch (IOException e) {

        }
    }

}

