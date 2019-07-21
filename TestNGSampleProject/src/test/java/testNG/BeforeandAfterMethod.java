package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BeforeandAfterMethod {

String baseUrl = "http://demo.guru99.com/selenium/newtours/";
public WebDriver driver ; 
String expected,actual;

@BeforeMethod
public void verifyHomepageTitle()
{
	  System.out.println("@BeforeMethod"); 
	  String expectedTitle = "Welcome: Mercury Tours";
    String actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle, expectedTitle);
}
@BeforeTest
public void launchBrowser() {
	 
	//  System.out.println("launching firefox browser"); 
	  System.setProperty("webdriver.chrome.driver","C:\\Akhil\\Selenium\\ChromeDriver\\chromedriver.exe");
	     driver = new ChromeDriver();
	    driver.get(baseUrl);
	    System.out.println("Before Test"); 
}


  @Test(priority = 0)
  public void register() {
	  System.out.println("@Test1"); 
	  driver.findElement(By.linkText("REGISTER")).click();
       expected = "Register: Mercury Tours";
       actual = driver.getTitle();
      Assert.assertEquals(actual, expected);
  }
  @Test(priority = 1)
  public void support() {
	  System.out.println("@Test2"); 
        driver.findElement(By.linkText("SUPPORT")).click() ;
        expected = "Under Construction: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
  }
  


  @AfterMethod
  public void goBackToHomepage ( ) {
	  System.out.println("@AfterMethod"); 
      driver.findElement(By.linkText("Home")).click() ;
}
 
  
  @AfterTest
  public void terminateBrowser() {
		 System.out.println("After Test"); 
		  driver.close();
	  }
}
