import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by kineret on 1/12/16.
 */
public class MD5 {

    protected static Logger _logger = Logger.getRootLogger();


    public String getMD5(String destination) throws IOException {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(destination);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(String.valueOf(fis));
        fis.close();

        return  md5;
    }

}
