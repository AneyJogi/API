package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.EmployeeDetailsWithObjectSpouse;
import pojoClass.Spouse;

public class SerializationWithObjectSpouse {
	
	@Test
	public void employSerial() throws JsonGenerationException, JsonMappingException, IOException
	{
		long[] mobNo= {94970930,82811738};
		Spouse sp = new Spouse("Alwin",mobNo);
		
		EmployeeDetailsWithObjectSpouse objArr = new EmployeeDetailsWithObjectSpouse("Aney",94970930,sp);
		ObjectMapper omap = new ObjectMapper();
		omap.writeValue(new File("./objArray.json"),objArr);
		
		
	}

}
