package _4WaysToPostRequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;

public class PostUsingHashMap {
	public void createProj()
	{
		baseURI="http://rmgtestingserver";
		port= 8084;
		
		JavaLibrary jLib = new JavaLibrary();
		
		HashMap<Object,Object> jObj= new HashMap<Object, Object>();
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
