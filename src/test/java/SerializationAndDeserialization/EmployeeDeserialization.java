package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.EmployeeDetails;

public class EmployeeDeserialization {
	@Test
	
	public void employDeserial() throws Throwable, JsonMappingException, IOException
	{
		
		ObjectMapper omap = new ObjectMapper();
		EmployeeDetails data = omap.readValue(new File("./emp.json"), EmployeeDetails.class);
		
		System.out.println(data.getName());
		System.out.println(data.getEmpid());
		System.out.println(data.getMailid());
		System.out.println(data.getPhonenumber());
	}
}
