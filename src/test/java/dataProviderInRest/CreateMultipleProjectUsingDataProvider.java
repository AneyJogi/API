package dataProviderInRest;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoClassForPostOperation.CreateProjectPojo;
import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateMultipleProjectUsingDataProvider {
	
	@Test(dataProvider="getData")
	public void createProject(String createdBy, String projectName, String status, int teamSize)
	{
		baseURI="http://rmgtestingserver";
		port= 8084;
		
		JavaLibrary jLib = new JavaLibrary();
		CreateProjectPojo p= new CreateProjectPojo(projectName, status, createdBy, teamSize);
		
		//Step 1: pre-condition
		given()
		.body(p)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		.then()
		.assertThat()
	 	.statusCode(201)
		.contentType(ContentType.JSON)
	    .time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		.log().all();
	   
	}
	
	@DataProvider(name = "getData")
	public Object[][] data()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0] = "a1";
		data[0][1] = "samsungPhone";
		data[0][2] = "Completed";
		data[0][3] = 5;
		
		data[1][0] = "a2";
		data[1][1] = "samsungTab";
		data[1][2] = "Created";
		data[1][3] = 6;
		
		data[2][0] = "a3";
		data[2][1] = "SamsungTV";
		data[2][2] = "On Going";
		data[2][3] = 6;
		
		
		return data;
	}
		
	}


