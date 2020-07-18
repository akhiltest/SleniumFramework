 package baseclass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilityPackage.ExtentUtils;


public class driverinstance {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void initiateDriverinstance() throws Exception
	{/* fetching data from property file converting object to string
	(since fetchpropertyvalue() method will be returning only object) and then comparing*/
		if(utilityPackage.utilityFetchproperty.fetchpropertyvalue("browserName").toString().equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-popup-blocking");
			driver = new ChromeDriver(options);
		
		}
		
		else if(utilityPackage.utilityFetchproperty.fetchpropertyvalue("browserName").toString().equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}
		else if(utilityPackage.utilityFetchproperty.fetchpropertyvalue("browserName").toString().equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		//if incorrect or nothing is mentioned it will create Chrome driver object
		else
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-popup-blocking");
			driver = new ChromeDriver(options);
		
		}
		driver.get(utilityPackage.utilityFetchproperty.fetchpropertyvalue("URL").toString());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@AfterMethod
	public void closeDriverInstance(ITestResult result) throws IOException
	{ String className = this.getClass().getSimpleName();  
		ExtentUtils.finalreport(result,driver,className);
		driver.close();
	}
}
	 
