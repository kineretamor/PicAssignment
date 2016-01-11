import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by kineret on 1/11/16.
 */
public class EditImage1 {

    private BufferedImage resizeImage(BufferedImage image, int scaledWidth, int scaledHeight) {
        int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
        BufferedImage resizedImage = new BufferedImage(scaledWidth, scaledHeight, type);

        // scales the input image to the output image
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
        return resizedImage;
    }

    private BufferedImage convertToGrayScaleImage(BufferedImage image) {
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
