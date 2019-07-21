package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class BeforeandAfterTest 
{
	
	

String baseUrl = "http://www.gotechmasters.com/";
public WebDriver driver ; 

  
  @BeforeTest
  public void launchBrowser() 
  {
	  System.out.println("Before Test"); 
	  System.out.println("launching firefox browser"); 
	  System.setProperty("webdriver.chrome.driver","C:\\Akhil\\Selenium\\ChromeDriver\\chromedriver.exe");
	     driver = new ChromeDriver();
	    driver.get(baseUrl);
  }
  
  @Test
  public void verifytitle() 
  {
	  System.out.println("@Test"); 
	  String expectedTitle = "HOME : Tech Masters";
	String  actualTitle = driver.getTitle();
	Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @AfterTest
  public void terminateBrowser() 
  {
	 System.out.println("After Test"); 
	  driver.close();
  }

}
