package SerializationAndDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClass.EmployeeDetailsWithObjectSpouse;

public class DeSerializationWithObjectArraySpouse {
	@Test
	public void employDeserial() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper omap = new ObjectMapper();
		EmployeeDetailsWithObjectSpouse data = omap.readValue(new File("./objArray.json"), EmployeeDetailsWithObjectSpouse.class);
		System.out.println(data.getName());
		System.out.println(data.getMobNo());
		System.out.println(data.getSpouse().getName());
		System.out.println(data.getSpouse().getMobNo()[1]);
	}

}
