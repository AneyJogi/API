package ResponseBodyValdation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DynamicResponseValidation {
		@Test
		public void dynamicRespVali() {
			String expData="TY_PROJ_5082";
			baseURI="http://rmgtestingserver";
			port=8084;
			
		
			//Actions
			Response resp = when()
			.get("/projects");
			
			//validation
			boolean flag= false;
			List<String> pIDs = resp.jsonPath().get("projectId");
			for(String projectId:pIDs)
			{
			if(projectId.equalsIgnoreCase(expData))	
			{
				flag=true;
			}
			}
			 Assert.assertTrue(flag);
			 
			 resp.then().log().all();
			 System.out.println("data verified");
			

}
}
