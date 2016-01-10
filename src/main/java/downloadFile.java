import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

import java.awt.*;

/**
 * Created by kineret on 1/10/16.
 */
public class downloadFile {

    private static final Logger LOGGER = LoggerFactory.getLogger(downloadFile.class);


    private static final String DESTINATION_FILE = "downloaders.image.downloaded.folder";
    private URL imageUrl;
    private String downloadedFolder;
    private String newFile;//Should be with surfix
    private String fileName;


    public downloadFile(final URL imageToDownload, final String destination) throws IOException {

        BufferedImage image = downloadImage(imageToDownload);
        saveImage(image, destination);

    }



    private BufferedImage downloadImage(URL imageToDownload) {
        //Download image
        BufferedImage image = null;
        try {
            //Read the file
            //URL url = new URL(imageUrl.toString());
            image = ImageIO.read(imageToDownload);
            LOGGER.debug("Image downloaded");

        } catch (IOException e) {
        }
        return image;
    }

    private void saveImage(BufferedImage image, String destination) {

        //Save the file
        try {
            // retrieve image
            BufferedImage bi = image;
            File outputFile = new File(destination);
            ImageIO.write(bi, "png", outputFile);
            LOGGER.debug("Image saved");

        } catch (IOException e) {

        }
    }

}

