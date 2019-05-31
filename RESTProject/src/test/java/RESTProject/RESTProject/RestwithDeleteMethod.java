package RESTProject.RESTProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestwithDeleteMethod {
  @Test
  public void deletsucessfull() {
	  RequestSpecification request = RestAssured.given();
	  Response response = request.delete("http://localhost:3000/posts/1");
	  int statusCode = response.getStatusCode();
	  	Assert.assertEquals(statusCode,200);
  }
}
