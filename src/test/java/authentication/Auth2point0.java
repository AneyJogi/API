package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2point0 {
	@Test
	public void auth2_0()
	{
	 //Createa request to generate access token
		Response resp = given()
		.formParam("client_id", "Ani's Coop")
		.formParam("client_secret", "b859b267254730cbace2f32fcdf8625c")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://aniscoop.com")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		resp.then().log().all();
		
		//Capture the access token from the response of the above request
		
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		
		//Create another request and use the token to access the APIs
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 4524)
		
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then().log().all();
				
	}
	
}
