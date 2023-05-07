package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.EmployeeDetailsInArray;

public class SerializationWithArray {
	
	@Test
	public void employSerial() throws JsonGenerationException, JsonMappingException, IOException
	{
		long[] mobNo= {94970930,82811738,85799142};
		EmployeeDetailsInArray empArr = new EmployeeDetailsInArray("Alwin",501,"Alwin@gmal.com",mobNo);
		ObjectMapper omap = new ObjectMapper();
		omap.writeValue(new File("./empArray.json"),empArr);
		
		
	}

}
