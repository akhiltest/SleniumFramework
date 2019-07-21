package testNG;


	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
	public class WithdataProvider {
		private static WebDriver driver;

	  @DataProvider(name = "Authentication")

	  public static Object[][] credentials() {

	        return new Object[][] { { "akhil", "arjun" },{ "arjun", "arjun" } };

	  }

	  // Here we are calling the Data Provider object with its Name

	  @Test(dataProvider = "Authentication")

	  public void test(String sUserName, String sPassword) {

		  System.setProperty("webdriver.chrome.driver", "C:\\Akhil\\Selenium\\ChromeDriver\\chromedriver.exe");
			driver = new  ChromeDriver();

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      driver.get("http://newtours.demoaut.com/");

	      driver.findElement(By.name("userName")).sendKeys(sUserName);

	  	System.out.println(sUserName);

	      driver.findElement(By.name("password")).sendKeys(sPassword);

	  	System.out.println(sPassword);

	      driver.findElement(By.name("login")).click();
	     

	     
	  }
	  @AfterMethod
	  public void TitleVerification()
	  {
		  String actualTitle, ExpectedTitle;
		  
		    actualTitle="Find a Flight: Mercury Tours:";
		    ExpectedTitle=driver.getTitle();
		    System.out.println(ExpectedTitle);
		    SoftAssert softAssertion= new SoftAssert();
		    softAssertion.assertEquals(actualTitle, ExpectedTitle);
		    //assertEquals(actualTitle, ExpectedTitle,"Title is Matching");
		
		   
		    driver.close();

	  }


}
