package CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	

	@Test
	public void updateProj()
	{
		
		//Step1: Create the pre requisites -request body
		 JSONObject jObj = new JSONObject();
		 jObj.put("createdBy", "Aney");
		 jObj.put("projectName","OnlineShpApp");
		 jObj.put("status", "OnGoing");
		 jObj.put("teamSize", 15);
		
		 
		 RequestSpecification req = RestAssured.given();
		 req.body(jObj);
		 req.contentType(ContentType.JSON);
		 
		 //Step 2: Perform the Action
		 
		Response response = req.put("http://rmgtestingserver:8084/projects/TY_PROJ_5081");
		
		//Step 3: Validate the response
		
		
 		response.then().log().all();
	    int actStatus=response.getStatusCode();
        Assert.assertEquals(200, actStatus);

}
}