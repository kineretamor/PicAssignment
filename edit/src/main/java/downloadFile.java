import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by kineret on 1/10/16.
 */
public class DownloadFile {
    protected static Logger _logger = Logger.getRootLogger();

    public BufferedImage downloadImage(URL imageToDownload) {
        _logger.debug("Starting downloadImage from URL: " + imageToDownload);

        //Download image
        BufferedImage image = null;
        try {
            //Read the file
            image = ImageIO.read(imageToDownload);
            _logger.debug("Image downloaded");

        } catch (IOException e) {
            _logger.error("Failed to read from URL: " + e.getMessage());
            e.printStackTrace();
        }
        _logger.debug("Ending downloadImage");
        return image;
    }

    public void saveImage(BufferedImage image, String imageFormat, String destination) {
        _logger.debug("Starting saveImage on disk: " + destination);

        //Save the file
        try {
            // retrieve image
            File outputFile = new File(destination);
            ImageIO.write(image, imageFormat, outputFile);
            _logger.debug("Image saved");

        } catch (IOException e) {
            _logger.error("Failed to save image : " + e.getMessage());
        }
    }

}

