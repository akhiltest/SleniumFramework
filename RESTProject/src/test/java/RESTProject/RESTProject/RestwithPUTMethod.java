package RESTProject.RESTProject;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestwithPUTMethod {

  @Test
  public void Putverification()
  {		
	 // Get the RequestSpecification of the request that you want to sent
		// to the server.
  	RequestSpecification request = RestAssured.given();
    request.header("Content-Type","application/json");
  	JSONObject json = new JSONObject();
  	json.put("id", "222"); // Cast
  	json.put("title", "Book");
  	json.put("author", "Akhil");
  	  	
  	request.body(json.toJSONString());
  	Response response = request.put("http://localhost:3000/posts/1");
 
  	int statusCode = response.getStatusCode();
  	Assert.assertEquals(statusCode,200);
  	
  }
}
