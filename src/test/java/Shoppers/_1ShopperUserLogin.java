package Shoppers;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class _1ShopperUserLogin {
	@Test
	public void RegisterShopper()
	{
		
	
		baseURI="https://www.shoppersstack.com/shopping";
		
		JSONObject jObj = new JSONObject();
//		 jObj.put("city", "maha");
//	        jObj.put("country", "India");
//	        jObj.put("createdDateTime", "04:21pm");
//	        jObj.put("dob", "23/1/1999");
//	        jObj.put("email", "tester@gmail.com");
//	        jObj.put("firstName", "ani");
//	        jObj.put("gender", "female");
//	        jObj.put("imageId", "001");
//	        jObj.put("jwtToken", "string");
//	        jObj.put("lastName", "Jogi");
//	        jObj.put("password", "admin");
//	        jObj.put("phone", 123456789);
//	        jObj.put("role", "ADMIN");
//	        jObj.put("state", "karnataka");
//	        jObj.put("status", "ACTIVE");
//	        jObj.put("token", "string");
//	        jObj.put("zoneId", "001");
		
		    jObj.put("email", "aney.jogi94@gmail.com");
	        jObj.put("password", "Anie@123");
	        jObj.put("zoneId", "ALPHA");
	        
		given().body(jObj).contentType(ContentType.JSON)
		.when().post("/users/login")
		.then().log().all();

}
}