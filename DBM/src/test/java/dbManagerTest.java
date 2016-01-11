import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 * Created by kineret on 1/11/16.
 */
public class dbManagerTest {
    protected static Logger _logger = Logger.getRootLogger();

   /* @Test
    public void testInsertIntoTable() throws Exception {

        _logger.info("Starting testInsertIntoTable");

        dbManager dbm = new dbManager();
        dbm.insertIntoTable();

        _logger.info("Ending testInsertIntoTable");



    }*/


    @Test
    public void ConfigDBUsageSample() throws Exception {

        _logger.info("Starting testInsertIntoTable");



        _logger.info("Starting query... ");
        String query = "SELECT * FROM images; ";
       // Statement st = ConfigDB.createStatement();
        ResultSet result = null;
        try {
         //   result = st.executeQuery(query);
            while (result.next()) { // process results one row at a time
                String url = result.getString("url");
                _logger.info("Found url " + url);
            }
            _logger.info("Finished query");

        }
        catch (Exception e) {
            _logger.error(e.getLocalizedMessage());
            throw e;
        }
        finally {
         //   ConfigDB.closeStatement(st, result);
        }


//        ConfigDBUsageSample configDBUsageSample = new ConfigDBUsageSample(new Date(), "c://image.jpg", "http://abcd.com/image.jpg", "some_md5");
        //configDBUsageSample.insertIntoTable();

        _logger.info("Ending testInsertIntoTable");



    }


}
