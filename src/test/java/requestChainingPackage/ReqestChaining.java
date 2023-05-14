package requestChainingPackage;

import org.testng.annotations.Test;

import PojoClassForPostOperation.CreateProjectPojo;
import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ReqestChaining {
	@Test
	public void reqchaining()
	{
		JavaLibrary jLib= new JavaLibrary();
		
		//Step1: create a project using pojo class
		
		CreateProjectPojo p= new CreateProjectPojo("SamsungPowerUnit"+jLib.getRandomNum(), "Ongoing", "alw", 25);
		baseURI="http://rmgtestingserver";
		port=8084;
		
		Response resp = given()
		.body(p)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		String proId = resp.jsonPath().get("projectId");
		System.out.println(proId);
		resp.then().log().all();
		
		// step 2:  create a get request and pass proID as path parameter
		
		 given()
		.pathParam("pid", proId)
		.when()
		.get("/projects/{pid}")
		.then()
		.assertThat().statusCode(200).log().all();
		
		
	}

}
