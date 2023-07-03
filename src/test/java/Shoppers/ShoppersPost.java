package Shoppers;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ShoppersPost {
	
	@Test
	public void RegisterShopper()
	{
		baseURI="https://www.shoppersstack.com/shopping/";
		
		JSONObject jObj = new JSONObject();
		jObj.put("city", "Bengaluru");
		jObj.put("country", "India");
		jObj.put("email", "aneyjogi23@gmail.com");
		jObj.put("firstName", "Anie");
		jObj.put("gender", "Female");
		jObj.put("lastName", "al");
		jObj.put("password", "Anie@321");
		jObj.put("phone", 949709304);
		jObj.put("state", "karnataka");	  
		jObj.put("zoneId", "ALPHA");	 
			 
		given().body(jObj).contentType(ContentType.JSON)
		.when().post("/shoppers")
		.then().log().all();
			}
		
	}
	


