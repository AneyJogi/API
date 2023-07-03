package mock;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoClassForPostOperation.CreateProjectPojo;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class dataDriven {
	@Test(dataProvider="getData")
	public void ddt(String projectName,String status,String createdBy,int teamSize)
	{
		baseURI="http://rmgtestingserver";
		port=8084;
	 	CreateProjectPojo p= new CreateProjectPojo(projectName,status,createdBy,teamSize);
	 			given().body(p).contentType(ContentType.JSON)
	 			.when().post("/addProject")
	 			.then().log().all();
	}

	@DataProvider(name = "getData")
	public Object[][] data()
	{
		Object[][] obj= new Object[2][4];
		
		obj[0][0]="samsung1";
		obj[0][1]="completed";
		obj[0][2]="aney";
		obj[0][3]=10;
		
		obj[1][0]="samsung2";
		obj[1][1]="completed";
		obj[1][2]="aney";
		obj[1][3]=10;
		return obj;
		
	}
}
