//gets a connection to the database

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {

	private Connection conn;
	private String dbURL;
	
	//constructor
	public ConnectDB(String dbURL) throws SQLException{
		
		this.dbURL =dbURL;
		conn = DriverManager.getConnection(this.dbURL);
		if (conn == null) 
		{
			throw new UnableToConnectException();
		}

	}
	
	public Connection getConnection()
	{
		return conn;
	}
	
}	
	
	

