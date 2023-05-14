package CRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {	
		@Test
		public void delProj()
		{
		
		        //Step 2: Perform the Action
				Response response = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_5077");
				

				//Step 3: Validate the response
				
				response.then().log().all();
			    int actStatus=response.getStatusCode();
		        Assert.assertEquals(actStatus, 204);

}
}
