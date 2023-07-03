 package zmiscellaneousTopics;
 import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;
	import PojoClassForPostOperation.CreateProjectPojo;
	import genericLibrary.BaseAPIClass;
	import genericLibrary.EndPointsLibrary;
	import genericLibrary.Iconstants;
    import static io.restassured.RestAssured.*;
	import java.util.concurrent.TimeUnit;
	import io.github.bonigarcia.wdm.WebDriverManager;
	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;
   
	public class CreateInRestgetDBDelINGUI extends BaseAPIClass{
	@Test
	public void createProjectinRest() throws Throwable {	
		
		
		CreateProjectPojo p= new CreateProjectPojo("Power"+jLib.getRandomNum(),"completed","Aneyjo", 5);

		Response res=given().spec(reqst).body(p).contentType(ContentType.JSON)
		.when().post(EndPointsLibrary.createProject);
		//.then().log().all();
		// validate using db
	    String eData = res.jsonPath().get("projectId");
	   	String query="select * from project";
		dLib.readDataFromDBAndValidate(query,1,eData);
		
	//delete project in gui
		
		    WebDriver driver=null;
		    WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(Iconstants.appUrl);
	        driver.findElement(By.name("username")).sendKeys(Iconstants.appUserName);
	        driver.findElement(By.name("password")).sendKeys(Iconstants.appPassword);
	        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	        driver.findElement(By.xpath("//ul/li/a[text()='Projects']")).click();
	        driver.findElement(By.xpath("//ul/li/a[text()='Projects']")).click();
	        driver.findElement(By.xpath("//td[text()='"+eData+"']/../descendant::td/a[@class=\"delete\"]")).click();
	        driver.findElement(By.xpath("//input[@value='Delete']")).click();
	        

	        
	   
	}

}
