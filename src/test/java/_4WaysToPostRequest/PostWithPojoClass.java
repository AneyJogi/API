package _4WaysToPostRequest;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import PojoClassForPostOperation.CreateProjectPojo;
import genericLibrary.JavaLibrary;
import io.restassured.http.ContentType;

  public class PostWithPojoClass {
  @Test
   public void createProj() {
	  
	  JavaLibrary jLib= new JavaLibrary();
	  baseURI="http://rmgtestingserver";
	  port=8084;
	  
	CreateProjectPojo p = new  CreateProjectPojo("SamsungBixB"+jLib.getRandomNum(),"completed","AneyJ",5); 
	
       given()
       .body(p) .contentType(ContentType.JSON).when().post("/addProject").then().assertThat() .statusCode(201).log().all();
  }}