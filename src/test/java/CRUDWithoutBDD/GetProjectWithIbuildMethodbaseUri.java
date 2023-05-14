package CRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetProjectWithIbuildMethodbaseUri {
	@Test
	
	public void getProj() {
		//Step 2: Perform the Action
		
		        RestAssured.baseURI ="http://rmgtestingserver";
		        RestAssured.port=8084;
		       // RequestSpecification req =  RestAssured.given();
		        Response response = RestAssured.get("/projects/TY_PROJ_4888");
				
				//Step 3: Validate the response
	
		
				
				response.then().log().all();
				int actStatus=response.getStatusCode();
				Assert.assertEquals(200, actStatus);

	}

}
