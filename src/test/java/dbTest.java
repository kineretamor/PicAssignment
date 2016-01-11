import org.junit.Test;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by kineret on 1/11/16.
 */
public class dbTest {


    @Test
    public void testEditPic() throws Exception {

        URL url = new URL("http://carbl.com/im/2013/07/Suzuki-Swift-5d-600x324.jpg");
        String destination = "/Users/kineret/Desktop/destination/new.png";

        editImage editP = new editImage(url, destination, 200, 200);


        Connection conn;
       //Class.forName("org.hsqldb.jdbc.JDBCDriver");
        conn = DriverManager.getConnection("jdbc:hsqldb:"
                        + "t",    // filenames
                "SA",                     // username
                "");

        Statement st = null;

        st = conn.createStatement();    // statements

    }
}
