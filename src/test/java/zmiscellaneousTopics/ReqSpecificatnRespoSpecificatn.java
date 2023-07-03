package zmiscellaneousTopics;

import org.testng.annotations.Test;

import PojoClassForPostOperation.CreateProjectPojo;
import genericLibrary.JavaLibrary;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder; 
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

public class ReqSpecificatnRespoSpecificatn {
	
	@Test
	public void createProj()
	{
		JavaLibrary jLib = new JavaLibrary();
		CreateProjectPojo p= new CreateProjectPojo("powerunit" +jLib.getRandomNum(), "completed", "al-an", 10);
		
		RequestSpecification reqst = new RequestSpecBuilder()
				.setBaseUri("http://rmgtestingserver:8084")
				.setContentType(ContentType.JSON).build();
		
		ResponseSpecification resp = new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.expectStatusCode(201).build();
		
		given().spec(reqst).body(p)
		.when().post("/addProject")
		
		.then().spec(resp).log().all();
	}

}
