package parametersInREST;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter {
	@Test
	public void getQueryParam()
	{
		baseURI="http://reqres.in";
		
		
		//pre-requisites
		given()
		.queryParam("page", 2)
		
		//actions
		.when()
		.get("/api/users")
		
		//validation
		.then()
		.log().all();
	}

}
