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

    /**
     * @param destination the location of the image
     * @return MD5 string that generated
     * @throws IOException
     */
    public String getMD5(String destination) throws IOException {
        _logger.debug("Starting getMD5, create MD5 to file in : " + destination);

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(destination);
        } catch (FileNotFoundException e) {
            _logger.error("Failed to create MD5: " + e.getMessage());
            e.printStackTrace();
        }
        String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(String.valueOf(fis));
        fis.close();
        _logger.debug("Ending getMD5");

        return md5;
    }

}
