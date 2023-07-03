package ResponseBodyValdation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;

import java.util.List;

public class dynamic {
	@Test
	public void dynamicvali()
	{
		String expdata = "TY_PROJ_7102";
		{
		baseURI="http://rmgtestingserver";
		port=8084;
		
		Response resp = when().get("/projects");
		boolean flag= false;
		
		List<String> pid = resp.jsonPath().get("projectId");
		for(String proId:pid)
		{
			if(proId.equalsIgnoreCase(expdata))
			{
				flag=true;
			}
		}
		
	Assert.assertTrue(flag);
	}

}
}