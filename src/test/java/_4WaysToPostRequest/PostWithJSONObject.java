package _4WaysToPostRequest;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class PostWithJSONObject {
	@Test
	public void createProj()
	{
		baseURI="http://rmgtestingserver";
		port= 8084;
		
		JavaLibrary jLib = new JavaLibrary();
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Aneyk");
		jObj.put("projectName", "BixB"+jLib.getRandomNum());
		jObj.put("status", "OnGoing");
		jObj.put("teamSize", 10);
		
		//Step 1: pre-condition
		 given()
		.body(jObj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
	    .time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		.log().all();
		
		
		
	}
}
