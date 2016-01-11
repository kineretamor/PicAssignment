import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kineret on 1/11/16.
 */
public class ImageAssignment {
  private static final int WIDTH_NEW_IMAGE = 200;
  private static final int HEIGHT_NEW_IMAGE = 200;

  public void main() throws MalformedURLException {

    DownloadFile downloadFile = new DownloadFile();
    EditImage editImage = new EditImage();
  //  DBManager2 dbManager = new DBManager2();


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

    //Save record on DB
   // dbManager.insertRecord(url.toString(), destination);


  }


}
