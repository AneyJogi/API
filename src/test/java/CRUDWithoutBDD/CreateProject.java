  package CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test
	public void createProj()
	{
		JavaLibrary jLib=new JavaLibrary();
		
		//Step1: Create the pre requisites -request body
		 JSONObject jObj = new JSONObject();
		 jObj.put("createdBy", "Aney");
		 jObj.put("projectName","OnlineShpApp"+jLib.getRandomNum());
		 jObj.put("status", "OnGoing");
		 jObj.put("teamSize", 10);
		
		 
		 RequestSpecification req = RestAssured.given();
		 req.body(jObj);
		 req.contentType(ContentType.JSON);
		 
		 //Step 2: Perform the Action
		 
		Response response = req.post("http://rmgtestingserver:8084/addProject");
		
		//Step 3: Validate the response
		
//		System.out.println(response.getContentType());
//		System.out.println(response.asString());
	    System.out.println(response.prettyPrint());
		//System.out.println(response.prettyPeek());
		System.out.println(response.statusCode());
		
		 
	}

}
