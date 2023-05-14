package CrudWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetSingProjectBDD {
		@Test
		
		public void getProj()
		{
			baseURI="http://rmgtestingserver";
			port= 8084;
			
			when()
			.get("/projects/TY_PROJ_5206")
			.then()
			.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.log().all();
			
		}

}
