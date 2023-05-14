package parametersInREST;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameterUpdate {
	@Test
	public void updateProj()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		

		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "krishna");
		jObj.put("projectName", "PowerUnit");
		jObj.put("status", "completed");
		jObj.put("teamSize", 5);
		
		//pre-requisites
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		.pathParam("pid", "TY_PROJ_3650")
		
		//actions
		.when()
		.put("/projects/{pid}")
		
		//validation
		.then()
		.log().all();
	}

}
