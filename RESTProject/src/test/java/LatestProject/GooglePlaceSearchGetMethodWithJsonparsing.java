  package LatestProject;

import org.testng.annotations.Test;

import FILE.UtilityMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class GooglePlaceSearchGetMethodWithJsonparsing {

	@Test
public void getPlaceAPI()
{
		// TODO Auto-generated method stub

		//BaseURL or Host
		RestAssured.baseURI="https://maps.googleapis.com";
		Response res=
		given().
			   log().all().
		       param("location","-33.8670522,151.1957362").
		       param("radius","500").
		       param("key","AIzaSyCRYIppWumtfsY1qesmkXtRD5HjQA94i2U").
		when().
		       get("/maps/api/place/nearbysearch/json").
		then().
			   log().all().
		       assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		       body("results[0].name",equalTo("Sydney")).and().
		       body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
		       header("Server","scaffolding on HTTPServer2").extract().response();
				JsonPath js=UtilityMethods.rawtojson(res);
				int re=js.get("results.size()");
		       
		       for(int i=0;i<20;i++)
		       {
		    	   String responsestring=js.get("results["+i+"].name");
		    	   System.out.println(responsestring); 
		       }
		       /*header("dfd","fsdfds").
		       cookie("dsfs","csder").
		       body()*/
		//Status code of the response
		//Content type 
		//Body
		//Header responses
	
}

}
