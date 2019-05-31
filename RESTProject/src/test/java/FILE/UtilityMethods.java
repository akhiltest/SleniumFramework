package FILE;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UtilityMethods {
	
	public static JsonPath rawtojson(Response res)
	{
		String responsestring=res.asString();
		//System.out.println(responsestring);
		//Grab PLace ID from the response
		JsonPath js=new JsonPath(responsestring);
		return js;
	}
}
