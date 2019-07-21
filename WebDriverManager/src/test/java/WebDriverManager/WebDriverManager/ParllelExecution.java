package WebDriverManager.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParllelExecution {
	@Test
	 public void getFirefox(){
	                //System.setProperty("webdriver.gecko.driver", "geckodriver.exe path");
		WebDriverManager.firefoxdriver().setup();
		

	 WebDriver driver = new FirefoxDriver();
	 driver.get("http://www.SoftwareTestingMaterial.com");
	 driver.close();
	 }
	
	 @Test
	 public void getChorme(){
	                WebDriverManager.chromedriver().setup();
	                WebDriver driver=new ChromeDriver();

	 
	 driver.get("http://www.SoftwareTestingMaterial.com");
	 driver.close();
	 }
	 
}
