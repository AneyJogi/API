package zmiscellaneousTopics;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import PojoClassForPostOperation.CreateProjectPojo;
import genericLibrary.BaseAPIClass;
import genericLibrary.EndPointsLibrary;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;


public class CreateProjectAndVerifyInDataBase extends BaseAPIClass {
	
	@Test
	public void createProj() throws Throwable
	{
	
	CreateProjectPojo p= new CreateProjectPojo("Power"+jLib.getRandomNum(),"completed","Aneyjo", 5);
	
         Response res = given().spec(reqst).body(p)

	     .when().post(EndPointsLibrary.createProject);
	     res.then().spec(resp).log().all();
	 
	String proId =rLib.getJsonData(res, "projectId");
			//res.jsonPath().get("projectId");
    System.out.println(proId);
    
    String query = "select * from project";
    dLib.readDataFromDBAndValidate(query, 1, proId);
    
   
            WebDriver driver=null;
		    WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("http://rmgtestingserver:8084");
			
			driver.findElement(By.name("username")).sendKeys("rmgyantra");
			driver.findElement(By.name("password")).sendKeys("rmgy@9999");;
			driver.findElement(By.xpath("//button[.='Sign in']")).click();
			driver.findElement(By.xpath("//a[.='Projects']")).click();
			List<WebElement> allProjectIds = driver.findElements(By.xpath("//table//tr/td[1]"));
			
			boolean flag=false;
			for(WebElement pid:allProjectIds)
			{
				if(pid.getText().equals(proId))
				{
					flag=true;
					break;
				}
			}
			if(flag=true)
			{
				System.out.println("project is created and verified in gui");
			
			}
			else
			{
				System.out.println("project is not created");
			}
	
	
	
	}
}
