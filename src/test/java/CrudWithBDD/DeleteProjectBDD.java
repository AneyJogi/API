package CrudWithBDD;


	import static io.restassured.RestAssured.baseURI;
	import static io.restassured.RestAssured.port;
	import static io.restassured.RestAssured.when;

	import org.testng.annotations.Test;

	import io.restassured.http.ContentType;
import io.restassured.response.Response;

	public class DeleteProjectBDD {
			@Test
			
			public void getProj()
			{
				baseURI="http://rmgtestingserver";
				port= 8084;
				
				 when()
				.delete("/projects/TY_PROJ_5223")
				.then()
				.assertThat()
				.statusCode(204)
				.contentType(ContentType.JSON)
				.log().all();
				
			}


}
