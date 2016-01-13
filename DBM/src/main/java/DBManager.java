import java.sql.*;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBManager {

    DBHandler dbHandler;

    protected static Logger _logger = Logger.getRootLogger();

    public DBManager() {

        Properties prop = new Properties();
        try {
            prop.load(DBManager.class.getClassLoader().getResourceAsStream("dbmSettings.properties"));
            String DBAddress = prop.getProperty("db.address");
            String userName = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");
            String driver = prop.getProperty("db.driver");

            dbHandler = new DBHandler(DBAddress, userName, password, driver);
        } catch (Exception e) {
            _logger.error(e.getMessage());
        }
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