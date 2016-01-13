import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * Created by kineret on 1/11/16.
 */
public class ImageAssignment {
    private static final int WIDTH_NEW_IMAGE = 200;
    private static final int HEIGHT_NEW_IMAGE = 200;
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
        DBManager2 dbManager = new DBManager2();
        MD5 md5 = new MD5();


        //URL to download image
        URL url = new URL("http://carbl.com/im/2013/07/Suzuki-Swift-5d-600x324.jpg");
        String destination = "/Users/kineret/Desktop/destination/new.png";

        //Download image
        BufferedImage orgImg = downloadFile.downloadImage(url);

        //Change image size
        BufferedImage editedImg = editImage.resizeImage(orgImg, WIDTH_NEW_IMAGE, HEIGHT_NEW_IMAGE);

        //Change colour to gray-scale
        editedImg = editImage.convertToGrayScaleImage(editedImg);

        //Save new image on disk
        //Get image format
        String imageFormat = url.toString().substring(url.toString().lastIndexOf(".") + 1);
        downloadFile.saveImage(editedImg, imageFormat, destination);

        //Calculate MD5
        String md5Value = md5.getMD5(destination);

        //Save record on DB
        dbManager.createTable();
        dbManager.insertRecord(destination, url.toString(), md5Value);

        _logger.debug("Ending main program");

    }


}
