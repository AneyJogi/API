package zmiscellaneousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genericLibrary.BaseAPIClass;
import genericLibrary.EndPointsLibrary;
import genericLibrary.Iconstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateProjectInGUIvaliInDBandAPI extends BaseAPIClass {
	
	@Test
	public void createProjectInGUI() throws Throwable
	{
		 WebDriver driver=null;
		    WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("http://rmgtestingserver:8084");
			
			driver.findElement(By.name("username")).sendKeys(Iconstants.appUserName);
			driver.findElement(By.name("password")).sendKeys(Iconstants.appPassword);;
			driver.findElement(By.xpath("//button[.='Sign in']")).click();
			driver.findElement(By.xpath("//a[.='Projects']")).click();
			driver.findElement(By.xpath("//span[.='Create Project']")).click();
			String projname = "PowerManagemnt"+jLib.getRandomNum();
			driver.findElement(By.name("projectName")).sendKeys(projname);
			driver.findElement(By.name("createdBy")).sendKeys("aney");
			
			WebElement dropdown = driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select[@name='status']"));
			Select sel = new Select(dropdown);
			Thread.sleep(200);
			sel.selectByVisibleText("Completed");
			Thread.sleep(200);
			driver.findElement(By.xpath("//input[@value='Add Project']")).click();
			 String proId = driver.findElement(By.xpath("//td[.='"+projname+"']/../td[1]")).getText();
			System.out.println(proId);
			
			String query = "select * from project";
		    dLib.readDataFromDBAndValidate(query, 1, proId);
		    
		  Response res =given().spec(reqst). when().get(EndPointsLibrary.getSingleProject+proId);
		  
//		  String dbproId =rLib.getJsonData(res, proId);
//		 System.out.println(dbproId);
		  
		  res.then().log().all();
	
			
			
			
			
	}

}
