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

  /*      private static final String DB_SCHEME_NAME = "db.scheme.name";

    private static final String DB_USER_PASSWORD = "db.user.password";

    private static final String DB_USER_NAME = "db.user.name";*/



    private static final String DB_SCHEME_NAME = "name";

    private static final String DB_USER_PASSWORD = "psw";

    private static final String DB_USER_NAME = "root";

    DBHandler dbHandler;


  //  private Logger log = Logger.getLogger( DBManager.class);

    private Connection connection = null;

    public DBManager2( ) {

        String DBAddress= "jdbc:hsqldb.hsql://localhost/";
        String userName = "SA";
        String password = null;
        String driver = "org.hsqldb.jdbc.JDBCDriver";
        //String driver = "com.mysql.jdbc.Driver";
        DBHandler dbHandler = new DBHandler(DBAddress, userName, password, driver);
    }


    public void createTable() throws SQLException {

       dbHandler.createTable();

    }




    public void insertRecord( final String downloadedPath, final String imageURL, final String md5) {


        try {
            dbHandler.insertIntoTable(downloadedPath, imageURL, md5);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}