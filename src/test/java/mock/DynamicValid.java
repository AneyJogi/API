package mock;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicValid {
	@Test
	public void dynamicVali()
	{
		String expdata="TY_PROJ_7102";
	
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
	   Response resp = when().get("/projects");
	
	  List<String> proid = resp.jsonPath().get("projectId");
	   boolean flag= true;
	  for(String pid : proid)
	  {
	   if(pid.equalsIgnoreCase(expdata))
	   {
		   System.out.println("data verified");
	   }

} }}
