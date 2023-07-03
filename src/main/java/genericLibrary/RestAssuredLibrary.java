package genericLibrary;

import io.restassured.response.Response;

/**
 * 
 * Consist of methods of RestAssured
 * @author alwin
 *
 */

public class RestAssuredLibrary {
	
	public String getJsonData(Response response,String path)
	{
		String jsonData = response.jsonPath().get(path);
		return jsonData;
	}

}
