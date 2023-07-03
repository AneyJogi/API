package newAPI;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojo.EmpMarshelling;
import pojoClass.EmployeeDetails;

public class MarshellingNUnmarshelling {

	
		@Test
		public void employMarshel() throws JsonGenerationException, JsonMappingException, IOException
		{
			
			EmpMarshelling emp = new EmpMarshelling ("Aney",104,"aney.j@gmail.com",94970930);
			EmpMarshelling emp1 = new EmpMarshelling ("alwin",104,"alwin.j@gmail.com",82811738);
			ObjectMapper omap= new ObjectMapper();
	
			 omap.writeValue(new File("./empM.json"), emp1);
		}
		@Test
		
		public void employUnMarshelling() throws Throwable, JsonMappingException, IOException
		{
			
			ObjectMapper omap = new ObjectMapper();
			 EmpMarshelling data = omap.readValue(new File("./empM.json"), EmpMarshelling.class);
			
			System.out.println(data.getName());
			System.out.println(data.getId());
			System.out.println(data.getMailId());
			System.out.println(data.getMob());
		}
	}


