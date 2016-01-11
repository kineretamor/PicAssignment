import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler extends ConfigDB
{

	public DBHandler(String DBAddress, String userName, String password, String driver)
	{
		super(DBAddress, userName, password, driver);
		
	}
	
	public void createTable() throws SQLException {
		String query = "CREATE TABLE IF NOT EXISTS images "
				+ "(downloadDate DATE, filepath VARCHAR(2000),"
				+ "url VARCHAR(2000), md5 VARCHAR(32))";
		try (Statement s = createStatement()) {
			s.executeUpdate(query);
		}
	}
	
	public void insertIntoTable(String locationOnDisk,String uri,String md5) throws SQLException {
		String query = "INSERT INTO images (downloadDate, filepath, url, md5) "
				+ " VALUES(now(),'"+locationOnDisk+"',"+"'"+uri+"',"+ "'"+ md5+"')";
		
		
		try (Statement s = createStatement()) {
			s.executeUpdate(query);
		}
	}
	
	
}
