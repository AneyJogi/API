package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.EmployeeDetails;

public class EmployeeSerialization {
	@Test
	public void employSeri() throws JsonGenerationException, JsonMappingException, IOException
	{
		
		EmployeeDetails emp = new EmployeeDetails("Aney",104,"aney.j@gmail.com",94970930);
	
		ObjectMapper omap= new ObjectMapper();
		
		//
		 omap.writeValue(new File("./emp.json"), emp);
	}
	

}
