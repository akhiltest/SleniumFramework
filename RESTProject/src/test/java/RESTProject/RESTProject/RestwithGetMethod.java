package RESTProject.RESTProject;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestwithGetMethod {
  @Test
  public void verifystatus() {
	  	  Response resp=RestAssured.get("http://restapi.demoqa.com/utilities/weather/city/chennai");
	  int code = resp.getStatusCode();
	  System.out.println("Status code is : "+ code);
	  String statusline=resp.getStatusLine();
	  System.out.println("Status Line is : "+ statusline);
	  String respbody =resp.getBody().asString();
	  System.out.println("Body of the response is : "+ respbody);
	  long resptime =resp.getTime();
	  System.out.println("Response time is : "+ resptime);
	 String connectionheader=resp.header("connection");
	 System.out.println("Connection value in  the response is : "+ connectionheader);
	  Assert.assertEquals(code, 200);
	  Assert.assertEquals(respbody.contains("Chennai"),true,"Response body contains Chennai");
	 JsonPath jsonPathEvaluator = resp.jsonPath();
	 String city = jsonPathEvaluator.get("City");
	 System.out.println("City Nameis : "+ city);
	// Assert.assertEquals(city, "Chennai","Correct city name received in the Response");
	  Assert.assertEquals(city, "Chennai", "Correct city name received in the Response");
	  
  }
}
