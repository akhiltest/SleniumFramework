package assertions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassertions {
	public WebDriver driver;
	@Test
	public void loginTestPass() throws IOException
	{  
		System.setProperty("webdriver.chrome.driver", "C:\\Akhil\\Selenium\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.gotechmasters.com/index.php");
		 //logger=extent.createTest("TileMatching");
		System.out.println("title is "+driver.getTitle());
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(driver.getTitle().contains("AKTech"));
		driver.close();
		sa.assertAll();
		
	}
	@Test
	public void loginTestFail() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Akhil\\Selenium\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.gotechmasters.com/index.php");
		 //logger=extent.createTest("TileMissMatching");
		System.out.println("title is "+driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Tech"));
		driver.close();
	}
}
