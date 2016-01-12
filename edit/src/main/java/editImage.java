import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by kineret on 1/10/16.
 */
public class EditImage {
    protected static Logger _logger = Logger.getRootLogger();



    public BufferedImage resizeImage(BufferedImage image, int scaledWidth, int scaledHeight) {
        int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
        BufferedImage resizedImage = new BufferedImage(scaledWidth, scaledHeight, type);

        // scales the input image to the output image
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
        return resizedImage;
    }

    public BufferedImage convertToGrayScaleImage(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color c = new Color(image.getRGB(j, i));
                int red = (int) (c.getRed() * 0.21);
                int green = (int) (c.getGreen() * 0.72);
                int blue = (int) (c.getBlue() * 0.07);
                int sum = red + green + blue;
                Color newColor = new Color(sum, sum, sum);
                image.setRGB(j, i, newColor.getRGB());
            }
        }
        return image;
    }


}
