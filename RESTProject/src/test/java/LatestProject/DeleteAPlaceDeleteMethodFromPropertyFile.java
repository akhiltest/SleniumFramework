package LatestProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import FILE.UtilityMethods;
import FILE.payload;
import FILE.resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteAPlaceDeleteMethodFromPropertyFile {
	public Properties property;
	@BeforeTest
	public void getfromproperty() throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Akhil\\AkhilLab\\RESTProject\\src\\test\\java\\FILE\\env.properties");
		//Creating an object of the property class
		 property=new Properties();
		//First we are loading the required file
		property.load(file);
	}
  @Test
  public void deleteplace() {
	  //Adding the Location
	  
	  RestAssured.baseURI=property.getProperty("Host");
	  //Grab the Response
		Response res=given().
		
		queryParam("key",property.getProperty("Key")).
		body(payload.getpostdata()).
		when().
		post(resources.placepostdata()).
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK")).
		extract().response();
		JsonPath js=UtilityMethods.rawtojson(res);
		String placeid=js.get("place_id");
		System.out.println(placeid);
		//Place place_id in delete request
		 RestAssured.baseURI="http://216.10.245.166/";
		 given().
	    queryParam("key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
	    body("{"+
	    //to pass a variable we will be using the below method
	        "\"place_id\":\""+placeid+"\""+        
	   "}").
	    when().
	    post("/maps/api/place/delete/json").
	    then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK"));
  }
}
