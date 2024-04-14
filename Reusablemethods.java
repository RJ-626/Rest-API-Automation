package files;

import io.restassured.path.json.JsonPath;

public class Reusablemethods {
	
	public static JsonPath rawToJson(String response)   //Parsing the Json
	
	{
	JsonPath js1=new JsonPath(response);
	return js1;
	
	}
	

}
