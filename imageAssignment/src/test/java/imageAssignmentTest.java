import org.junit.Test;

import java.io.File;
import java.net.URL;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by kineret on 1/10/16.
 */
public class imageAssignmentTest {


    @Test
    public void testEditPic() throws Exception {
       // boolean check = new File("/Users/kineret/Desktop/destination/", "new.png").exists();
       // assertFalse(check);
        URL url = new URL("http://carbl.com/im/2013/07/Suzuki-Swift-5d-600x324.jpg");
        String destination = "/Users/kineret/Desktop/destination/new.png";

        ImageAssignment imageAssignment = new ImageAssignment();
        imageAssignment.main();

        //Check that the new file created
       // check = new File("/Users/kineret/Desktop/destination/", "new.png").exists();
       // assertTrue(check);

        //toDO: add tests for DB, check DB record

    }
}
