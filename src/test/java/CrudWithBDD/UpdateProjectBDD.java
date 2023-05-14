package CrudWithBDD;

	import org.json.simple.JSONObject;
	import org.testng.annotations.Test;

	import genericLibrary.JavaLibrary;
	import io.restassured.http.ContentType;

	import static io.restassured.RestAssured.*;

	public class UpdateProjectBDD {
		@Test
		public void updateProj()
		{
			baseURI="http://rmgtestingserver";
			port= 8084;
			
			
			
			JSONObject jObj = new JSONObject();
			jObj.put("createdBy", "Aneyk");
			jObj.put("projectName", "BixB");
			jObj.put("status", "completed");
			jObj.put("teamSize", 20);
			
			//Step 1: pre-condition
			given()
			.body(jObj)
			.contentType(ContentType.JSON)
			
			.when()
			.put("/projects/TY_PROJ_5223")
			.then()
			.assertThat()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();	
			
		}

}
