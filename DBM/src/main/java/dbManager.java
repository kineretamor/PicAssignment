import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * Created by kineret on 1/11/16.
 */
public class dbManager {

    private static final String DB_SCHEME_NAME = "db.scheme.name";

    private static final String DB_USER_PASSWORD = "db.user.password";

    private static final String DB_USER_NAME = "db.user.name";

    //private Logger log = Logger.getLogger(dbManager.class);

    private Connection connection = null;

    public dbManager() {
        Properties properties = new Properties();

        try {
            properties.load(dbManager.class.getClassLoader().getResourceAsStream("cortica.properties"));
            String userName = properties.getProperty(DB_USER_NAME);
            String userPwd = properties.getProperty(DB_USER_PASSWORD);
            String dbName = properties.getProperty(DB_SCHEME_NAME);
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connection = DriverManager.getConnection(MessageFormat.format("jdbc:mysql://localhost/{0}?user={1}&password={2}", dbName, userName, userPwd));
        } catch (Exception e) {
            //log.error(e);
        }
    }

    public void insertRecord(final String downloadedPath, final String imageURL) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO log( path_on_disk, url, url_hash, datum) VALUES( ?, ?, ?, ?)");
         PreparedStatement stmt = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(imageURL.getBytes(), 0, imageURL.length());
            stmt = connection.prepareStatement(sql.toString());
            stmt.setString(1, downloadedPath);
            stmt.setString(2, imageURL);
            stmt.setString(3, new BigInteger(1, digest.digest()).toString(16));
            stmt.setDate(4, new Date(System.currentTimeMillis()));
            stmt.execute();
        } catch (Exception e) {
         //   log.error(e);
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                //log.error(e);
            }
        }
    }
}
