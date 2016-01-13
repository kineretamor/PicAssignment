import org.apache.cassandra.io.util.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by kineret on 1/10/16.
 */
public class imageAssignmentTest {


    @Test
    public void testImageAssignment() throws Exception {

        //Delete the folder that should create on Desktop
        File newFolder = new File(System.getProperty("user.home") + "/Desktop/corticaJavaImageAssignment");
        if (newFolder.exists() && newFolder.isDirectory()) {
            FileUtils.deleteRecursive(newFolder);
        }
        ImageAssignment imageAssignment = new ImageAssignment();
        imageAssignment.main();

        //Check that the new file created
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("files/URLList").getFile());

        //Check the program created the images
        try (Scanner scanner = new Scanner(file)) {
            int counter = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                //URL to download image
                URL url = new URL(line);

                //Get image format
                String imageFormat = url.toString().substring(url.toString().lastIndexOf(".") + 1);
                String destination = System.getProperty("user.home") + "/Desktop/corticaJavaImageAssignment/";

                boolean check = new File(destination, "image" + counter + "." + imageFormat).exists();
                assertTrue(check);
                counter++;
            }
            //Finish read file
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        //toDO: add tests for DB, check DB record

    }

    public static void deleteFile(File element) {
        if (element.isDirectory()) {
            for (File sub : element.listFiles()) {
                deleteFile(sub);
            }
        }
        element.delete();
    }
}
