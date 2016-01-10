import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by kineret on 1/10/16.
 */
public class editPic {

    private static final String imageFormat = "png";

    public editPic(final URL imageToDownload, final String destination, int width, int height) throws IOException {

        //Download and save image
        BufferedImage image = downloadImage(imageToDownload);

        //Resize image
        BufferedImage newSizeImage = resizeImage(image, 200, 200);
        saveImage(image, destination);

    }



    private BufferedImage downloadImage(URL imageToDownload) {
        //Download image
        BufferedImage image = null;
        try {
            //Read the file
            //URL url = new URL(imageUrl.toString());
            image = ImageIO.read(imageToDownload);
          //  LOGGER.debug("Image downloaded");

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
            ImageIO.write(bi, imageFormat, outputFile);
           // LOGGER.debug("Image saved");

        } catch (IOException e) {

        }
    }

    private BufferedImage resizeImage(BufferedImage image, int scaledWidth, int scaledHeight) {
        BufferedImage outputImage = image;

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
        return outputImage;
    }



}
