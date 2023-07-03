package genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;


public class DataBaseLibrary {
	Driver driverRef;
	Connection con;
	
	/**
	 * This method is used to connect with my sql db
	 * @author alwin
	 * @throws SQLException
	 */
	
	public void connectToDB() throws SQLException
	{
		driverRef= new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(Iconstants.dbURL,Iconstants.dbUserName, Iconstants.dbPassWord);
		
	}
	/**
	 * This method is to close connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}

	/**
	 * This method will execute the query and return the value only if the validation
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String readDataFromDBAndValidate(String query,int columnIndex,String expData) throws SQLException
	{
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
        while(result.next())
        {
        	if(result.getString(columnIndex).equalsIgnoreCase(expData))
        	{
        		flag=true;
        		break;
        	}
        }
        if(flag)
        {
        	System.out.println(" data verified");
        	return expData;
        	
        }
        else
        {
        	System.out.println("data not verified");
        	return "";
        }
	
	}

}
