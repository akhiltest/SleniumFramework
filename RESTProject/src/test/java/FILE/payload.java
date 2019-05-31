package FILE;

public class payload {
	
	public static String getpostdata()
	{
		String postdata="{"+
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
		return postdata;
	}
}
