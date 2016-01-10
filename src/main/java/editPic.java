import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;

/**
 * Created by kineret on 1/10/16.
 */
public class editPic {

    private static final String imageFormat = "png";

    public editPic(final URL imageToDownload, final String destination, int width, int height) throws IOException {

        //Download and save image
        BufferedImage image = downloadImage(imageToDownload);


        //Resize image
        BufferedImage newSizeImage = resizeImage(image, width, height);

        //Convert into gray-scale image
        BufferedImage grayScaleImage = convertToGrayScaleImage(newSizeImage);

        saveImage(grayScaleImage, destination);

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
           // BufferedImage bi = image;
            File outputFile = new File(destination);
            ImageIO.write(image, imageFormat, outputFile);
           // LOGGER.debug("Image saved");

        } catch (IOException e) {

        }
    }

   private BufferedImage resizeImage(BufferedImage image, int scaledWidth, int scaledHeight) {
       int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
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
            for(int i=0; i<height; i++){
                for(int j=0; j<width; j++){
                    Color c = new Color(image.getRGB(j, i));
                    int red = (int)(c.getRed() * 0.21);
                    int green = (int)(c.getGreen() * 0.72);
                    int blue = (int)(c.getBlue() *0.07);
                    int sum = red + green + blue;
                    Color newColor = new Color(sum,sum,sum);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
        return  image;
    }




}
