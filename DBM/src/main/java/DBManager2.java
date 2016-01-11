import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBManager2 {

  /*      private static final String DB_SCHEME_NAME = "db.scheme.name";

    private static final String DB_USER_PASSWORD = "db.user.password";

    private static final String DB_USER_NAME = "db.user.name";*/



    private static final String DB_SCHEME_NAME = "name";

    private static final String DB_USER_PASSWORD = "psw";

    private static final String DB_USER_NAME = "root";



  //  private Logger log = Logger.getLogger( DBManager.class);

    private Connection connection = null;

    public DBManager2( ) {
        Properties properties = new Properties( );
        try {
           // properties.load( DBManager2.class.getClassLoader().getResourceAsStream( "dbmSettings.properties"));
         /*   Properties prop = new Properties();
            InputStream in = getClass().getResourceAsStream("dbmSettings.properties");
            prop.load(in);
            in.close();*/

           /* String userName = properties.getProperty( DB_USER_NAME);
            String userPwd = properties.getProperty( DB_USER_PASSWORD);
            String dbName  = properties.getProperty( DB_SCHEME_NAME);
            String userName =  DB_USER_NAME;
            String userPwd =  DB_USER_PASSWORD;
            String dbName  = DB_SCHEME_NAME;*/
            String DBAddress= "jdbc:hsqldb.hsql://localhost/";
            String userName = "SA";
            String password = null;
            String driver = "org.hsqldb.jdbc.JDBCDriver";
            Class.forName("org.hsqldb.jdbc.JDBCDriver").newInstance();;


            // Setup the connection with the DB
            connection = DriverManager.getConnection( MessageFormat.format( "jdbc:mysql://localhost/{0}?user={1}&password={2}", "testdb", userName, password));




        } catch (Exception e) {
         //   log.error( e);
        }
    }

    public void insertRecord( final String downloadedPath, final String imageURL) {
        StringBuilder sql = new StringBuilder( );
        sql.append( "INSERT INTO log( path_on_disk, url, url_hash, datum) VALUES( ?, ?, ?, ?)");
        PreparedStatement stmt  = null;
        try {
            MessageDigest digest = MessageDigest.getInstance( "MD5");
            digest.update( imageURL.getBytes( ), 0, imageURL.length( ));
            stmt = connection.prepareStatement(sql.toString( ));
            stmt.setString(1, downloadedPath);
            stmt.setString(2, imageURL);
            stmt.setString(3, new BigInteger(1, digest.digest( )).toString( 16));
            stmt.setDate( 4, new Date( System.currentTimeMillis( )));
            stmt.execute( );
        } catch ( Exception e) {
           // log.error( e);

        } finally {
            try {
                if ( stmt != null)
                    stmt.close( );
            } catch (SQLException e) {
             //   log.error( e);
            }
        }
    }

}