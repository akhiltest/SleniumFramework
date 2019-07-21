package TestNGListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//Commented for Verifcation from testNG1.xml
//@Listeners(TestNGListener.ListnerTest.class)	
public class ListnerTestcase {
	 WebDriver driver;
	@BeforeClass
	public void Common() {
		System.setProperty("webdriver.chrome.driver", "C:\\Akhil\\Selenium\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		String baseURL ="http://newtours.demoaut.com/";
		driver.get(baseURL);
		
	}
		
	 @Test
	  public void loginPage() {
		 Assert.assertTrue(driver.getTitle().contains("Welcome"));
		System.out.println("Login Page Verified");
	 }
  
  @Test(dependsOnMethods={"loginPage"})
  public void HomePage() {
	 
		
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("arjun");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("arjun");
		driver.findElement(By.name("login")).click();
		Assert.assertTrue(driver.getTitle().contains("Find"));
		System.out.println("Home Page Verified");
		
  }
  @AfterClass
  public void terminateBrowser() 
  {
	// System.out.println("After Test"); 
	  driver.close();
  }
  
}
