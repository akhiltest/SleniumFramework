package LatestProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;



public class AddLoactionPOSTMethod {

	
	@Test
	public void createPlaceAPI()
	{   
		RestAssured.baseURI="http://216.10.245.166/";
		given().
		queryParam("key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
		body("{"+
  "\"location\": {"+
    "\"lat\": -38.383487,"+
    "\"lng\": 30.427369"+
  "},"+
  "\"accuracy\": 50,"+
  "\"name\": \"Google Shoes!\","+
  "\"phone_number\": \"(02) 9374 4000\","+
  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
  "\"types\": [\"shoe_store\"],"+
  "\"website\": \"http://www.google.com.au/\","+
  "\"language\": \"en-AU\""+
"}").
		when().
		post("/maps/api/place/add/json").
		then().
		assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK"));
		
	}
}   