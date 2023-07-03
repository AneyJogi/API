package genericLibrary;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseAPIClass {
	public DataBaseLibrary dLib= new DataBaseLibrary();
	public JavaLibrary jLib= new JavaLibrary();
	public RestAssuredLibrary rLib= new RestAssuredLibrary();
	public RequestSpecification reqst;
	public ResponseSpecification resp;
	
	
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		dLib.connectToDB();
		reqst= new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084")
	          .setContentType(ContentType.JSON).build();
		resp=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		
System.out.println("connection established");
	}
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
	}

}
