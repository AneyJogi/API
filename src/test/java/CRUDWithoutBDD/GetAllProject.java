package CRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllProject {
	
@Test
public void getProj() {
	
	
	         //Step 1: Perform the Action
	        
			Response response = RestAssured.get("http://rmgtestingserver:8084/projects");
			
			response.then().log().all();
			int actStatus=response.getStatusCode();
			Assert.assertEquals(200, actStatus);

}
}
