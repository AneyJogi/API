package CRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getSingleProject {
	@Test
	public void getProj() {
		        //Step 2: Perform the Action
		        
		       // RequestSpecification req = new RestAssured().given();
				Response response = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_4604");
				
				
				
				//Step 3: Validate the response
				
				System.out.println(response.getContentType());
				System.out.println(response.asString());
	            System.out.println(response.prettyPrint());
				System.out.println(response.prettyPeek());
				System.out.println(response.statusCode());
				
//				response.then().log().all();
//			    int actStatus=response.getStatusCode();
//		        Assert.assertEquals(actStatus,200);

	}

}
