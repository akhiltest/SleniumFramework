package LatestProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteAPlaceDeleteMethod {
  @Test
  public void deleteplace() {
	  //Adding the Location
	  String b="{"+
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
			"}";
	  RestAssured.baseURI="http://216.10.245.166/";
	  //Grab the Response
		Response res=given().
		
		queryParam("key","qaclick123").
		body(b).
		when().
		post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK")).
		extract().response();
		String responsestring=res.asString();
		System.out.println(responsestring);
		//Grab PLace ID from the response
		JsonPath js=new JsonPath(responsestring);
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
