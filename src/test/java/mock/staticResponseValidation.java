package mock;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class staticResponseValidation {
	@Test
	public void staticRespValid()
	{
		String expData="TY_PROJ_6247";
		baseURI="http://rmgtestingserver";
		port=8084;
		
		Response resp = when()
		.get("/projects");
		String actdata = resp.jsonPath().get("[2].projectId");
		System.out.println(actdata);
		Assert.assertEquals("expdata","");
		System.out.println("data verfied");
		
		resp.then().log().all();
		
	}

}
