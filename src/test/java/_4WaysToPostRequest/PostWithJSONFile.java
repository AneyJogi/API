package _4WaysToPostRequest;

import org.testng.annotations.Test;

import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class PostWithJSONFile {
	@Test
	public void createProj() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		File f = new File("./postJsonFile.json");
		given()
		.body(f)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.log().all();
		
		
		
		
	}

}
