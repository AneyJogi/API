package mock;

import org.testng.annotations.Test;

import PojoClassForPostOperation.CreateProjectPojo;
import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class requestChainingEX {
@Test
public void reqChaining()
{
	baseURI="http://rmgtestingserver";
	port=8084;
	CreateProjectPojo p = new CreateProjectPojo("OSA"+new JavaLibrary().getRandomNum(), "aney", "OnGoing", 10);
	Response resp = 	given()
			.body(p)
			.contentType(ContentType.JSON)
			
			.when()
			.post("/addProject");
			
			String proID = resp.jsonPath().get("projectId");
			//resp.then().log().all();
			
			given()
			.pathParam("pid",proID)
			.when().get("/projects/{pid}")
			.then().log().all();
			
			
}
}
