package parametersInREST;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class FormParameter {
	@Test
	public void formPAram()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
	
	
	//pre-requisites
	given()
	.formParam("createdBy","al-an")
	.formParam("projectName", "PowerTeam")
	.formParam("status", "Ongoing")
	.formParam("teamSize", 3)
	
	//actions
	.when()
	.post("/addProject")
	
	//validation
	.then().assertThat().statusCode(201).contentType(ContentType.JSON)
	.log().all();
	}

}
