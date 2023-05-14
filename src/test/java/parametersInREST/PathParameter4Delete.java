package parametersInREST;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter4Delete {
	@Test
	public void pathParamDel()
	{
	baseURI="http://rmgtestingserver";
	port=8084;
	
	//pre-requisites
	given()
	.pathParam("pid", "TY_PROJ_5564")
	
	//actions
	.when()
	.delete("/projects/{pid}")
	
	//validation
	.then()
	.log().all();

}}
