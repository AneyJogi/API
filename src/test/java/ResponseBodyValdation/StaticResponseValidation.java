package ResponseBodyValdation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
	@Test
	public void staticRespVali() {
		String expData="TY_PROJ_3638";
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//action
		Response resp = when()
				.get("/projects");
		
		//validation 
		String  actData= resp.jsonPath().get("[2].projectId");
		Assert.assertEquals(actData,expData);
		System.out.println("data verified");
		resp.then().log().all();
	}

}
