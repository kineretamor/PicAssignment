import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by kineret on 1/11/16.
 */
public class ImageAssignment {
    private static final int WIDTH_NEW_IMAGE = 200;
    private static final int HEIGHT_NEW_IMAGE = 200;
    private static final String DESTINATION = "/Desktop/corticaJavaImageAssignment";

    protected static Logger _logger = Logger.getRootLogger();

    /**
     * Main program , download images from URLs,
     * resize them, change them to gray-scale,
     * save the new images on disk
     * save record per image on db
     *
     * @throws IOException
     * @throws SQLException
     */
    public void main() throws IOException, SQLException {
        _logger.debug("Starting main program");
        BasicConfigurator.configure();

        DownloadFile downloadFile = new DownloadFile();
        EditImage editImage = new EditImage();
        DBManager dbManager = new DBManager();
        MD5 md5 = new MD5();


        //Get file from resources folder
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("files/URLList").getFile());

        //Read every time only one line - each line represent one URL
        try (Scanner scanner = new Scanner(file)) {
            int counter = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                //URL to download image
                URL url = new URL(line);

                //Get image format
                String imageFormat = url.toString().substring(url.toString().lastIndexOf(".") + 1);

                //Save the image on desktop, with name image(i)
                boolean success = (new File(System.getProperty("user.home") + DESTINATION)).mkdirs();
                if (!success) {
                    _logger.debug("Problem with create new folder on desktop");
                }

                String destination = System.getProperty("user.home") + DESTINATION + "/image" + counter + "." + imageFormat;

                //Download image
                BufferedImage orgImg = downloadFile.downloadImage(url);

                //Change image size
                BufferedImage editedImg = editImage.resizeImage(orgImg, WIDTH_NEW_IMAGE, HEIGHT_NEW_IMAGE);

                //Change colour to gray-scale
                editedImg = editImage.convertToGrayScaleImage(editedImg);

                //Save new image on disk
                downloadFile.saveImage(editedImg, imageFormat, destination);

                //Calculate MD5
                String md5Value = md5.getMD5(destination);

                //Save record on DB
                dbManager.createTable();
                dbManager.insertRecord(destination, url.toString(), md5Value);

                counter++;
            }

            //Finish read file
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        _logger.debug("Ending main program");

    }

}
