package parametersInREST;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterForGet {
	
	@Test
	public void getPathParam()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//pre-requisites
		given()
		.pathParam("pid", "7102")
		
		//actions
		.when()
		.get("/projects/{pid}")
		
		//validation
		.then()
		.log().all();
		
	}

}
