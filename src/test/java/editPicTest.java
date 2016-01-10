import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.*;

/**
 * Created by kineret on 1/10/16.
 */
public class editPicTest {

   /* @Test
    public void testDownloader() throws Exception {

        URL url = new URL("http://carbl.com/im/2013/07/Suzuki-Swift-5d-600x324.jpg");
        String destination = "/Users/kineret/Desktop/destination/t.png";
        downloadFile df = new downloadFile(url, destination);

        int i = 5;
        int d = 4;
        assertEquals((i + d), 9);
        assertTrue(true);

    }*/


    @Test
    public void testEditPic() throws Exception {

        URL url = new URL("http://carbl.com/im/2013/07/Suzuki-Swift-5d-600x324.jpg");
        String destination = "/Users/kineret/Desktop/destination/new.png";

        editPic editP = new editPic(url, destination, 200, 200);
        int i = 5;
        int d = 4;
        assertEquals((i + d), 9);
        assertTrue(true);

    }
}
