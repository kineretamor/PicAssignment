import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kineret on 1/11/16.
 */
public class ImageAssignment {

  public void main() throws MalformedURLException {

    DownloadFile downloadFile = new DownloadFile();
    EditImage editImage = new EditImage();


    //URL to download image
    URL url = new URL("http://carbl.com/im/2013/07/Suzuki-Swift-5d-600x324.jpg");
    String destination = "/Users/kineret/Desktop/destination/new.png";

    //Download image
    BufferedImage orgImg = downloadFile.downloadImage(url);

    //Change size to 200X200 pixels
    //ToDo: change pixels to global
    BufferedImage editedImg = editImage.resizeImage(orgImg, 200, 200);

    //Change colour to gray-scale
    editedImg = editImage.convertToGrayScaleImage(editedImg);

    //Save new image on disk
    //Get image format
    String imageFormat = url.toString().substring(url.toString().lastIndexOf(".") + 1);
    downloadFile.saveImage(editedImg, imageFormat, destination);

    //Save record on DB


  }


}
