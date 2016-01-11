import org.junit.Test;

import java.net.URL;

/**
 * Created by kineret on 1/10/16.
 */
public class editImageTest {

   /* @Test
    public void testDownloader() throws Exception {

        URL url = new URL("http://carbl.com/im/2013/07/Suzuki-Swift-5d-600x324.jpg");
        String destination = "/Users/kineret/Desktop/destination/t.png";
        downloadFile df = new downloadFile(url, destination);

    }*/


    @Test
    public void testEditPic() throws Exception {

        URL url = new URL("http://carbl.com/im/2013/07/Suzuki-Swift-5d-600x324.jpg");
        String destination = "/Users/kineret/Desktop/destination/new.png";

        editImage editP = new editImage(url, destination, 200, 200);

    }
}
