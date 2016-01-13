import org.apache.log4j.Logger;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by kineret on 1/11/16.
 */
public class dbTest {
    protected static Logger _logger = Logger.getRootLogger();

    @Test
    public void testEditPic() throws Exception {

        _logger.info("Starting query... ");

        ConfigDBUsageSample cus = new ConfigDBUsageSample("jdbc:hsqldb:hsql://localhost/xdb", "sa", ""
                , "org.hsqldb.jdbcDriver");

        cus.createTable();
        cus.testTable();

        cus.insertIntoTable();


    }
}
