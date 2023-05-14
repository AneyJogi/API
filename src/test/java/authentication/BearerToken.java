package authentication;

import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
	@Test
	public void bearerToken()
	{
		baseURI="https://api.github.com";
		JSONObject jObj = new JSONObject();
		jObj.put("name", "RestRepo");
		jObj.put("description", "Repository for restAPI ");
		
		given()
		.auth()
		.oauth2("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")
		.body(jObj)
		.contentType(ContentType.JSON)
		

		.when()
		.post("/user/repos")
		
		.then()
		.assertThat().statusCode(201).log().all();
		
		
	}

}
