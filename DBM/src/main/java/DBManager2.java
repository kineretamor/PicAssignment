import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class DBManager2 {

    private static final String DB_ADDRESS = "jdbc:hsqldb:hsql://localhost/xdb";
    private static final String USER_PASSWORD = "";
    private static final String USER_NAME = "sa";
    private static final String DRIVER = "org.hsqldb.jdbcDriver";


    DBHandler dbHandler;


    protected static Logger _logger = Logger.getRootLogger();

    private Connection connection = null;

    public DBManager2() {

        String DBAddress = DB_ADDRESS;
        String userName = USER_NAME;
        String password = USER_PASSWORD;
        String driver = DRIVER;
        dbHandler = new DBHandler(DBAddress, userName, password, driver);
    }


    public void createTable() throws SQLException {
        _logger.debug("Starting createTable, call db");

        dbHandler.createTable();

        _logger.debug("Ending createTable");
    }


    public void insertRecord(final String downloadedPath, final String imageURL, final String md5) {
        _logger.debug("Starting insertRecord, from URL :" + imageURL + "to: " + downloadedPath);

        try {
            dbHandler.insertIntoTable(downloadedPath, imageURL, md5);
            _logger.debug("record inserted");

        } catch (SQLException e) {
            _logger.error("Failed to insertRecord");
            e.printStackTrace();
        }

    }

}