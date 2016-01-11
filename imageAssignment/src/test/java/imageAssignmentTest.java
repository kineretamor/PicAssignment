import org.junit.Test;

import java.net.URL;

/**
 * Created by kineret on 1/10/16.
 */
public class imageAssignmentTest {


    @Test
    public void testEditPic() throws Exception {

        URL url = new URL("http://carbl.com/im/2013/07/Suzuki-Swift-5d-600x324.jpg");
        String destination = "/Users/kineret/Desktop/destination/new.png";

        ImageAssignment imageAssignment = new ImageAssignment();
        imageAssignment.main();

        //ToDo : add check if there is image exists in the same name of image, before and after the test

        //toDO: add tests for DB, check DB record

    }
}
