package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestNGxmlwithParameters {
	String baseUrl = "http://newtours.demoaut.com/";
	public WebDriver driver ;
  @Parameters({ "username", "password" })
  @Test
  public void login(String username, String password) throws InterruptedException {
	  driver.findElement(By.xpath(".//input[@name='userName']")).sendKeys(username);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(".//input[@name='password']")).sendKeys(password);
      Thread.sleep(5000);
      driver.findElement(By.xpath(".//input[@name='login']")).click(); 
  }
  @Parameters({ "browser" })
  @BeforeTest
  public void launchBrowser(String browser) throws InterruptedException {
	  System.out.println("Before Test"); 
	  System.out.println("launching firefox browser"); 
	  System.setProperty("webdriver.chrome.driver","C:\\Akhil\\Selenium\\ChromeDriver\\chromedriver.exe");
	     driver = new ChromeDriver();
	    driver.get(baseUrl);
	    System.out.println("browser passed as :- " + browser);
	    Thread.sleep(5000);
  }

  @AfterTest
  public void terminateBrowser() {
	 System.out.println("After Test"); 
	  driver.close();
  }

}
