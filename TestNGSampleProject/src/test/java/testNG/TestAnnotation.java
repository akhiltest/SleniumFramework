package testNG;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestAnnotation {
  @Test
  public void alert() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Akhil\\Selenium\\ChromeDriver\\chromedriver.exe");
      WebDriver driver = new ChromeDriver();
	
      
      // Alert Message handling
                  		
      driver.get("http://demo.guru99.com/selenium/delete_customer.php");			
                          		
   	      	
      driver.findElement(By.name("cusid")).sendKeys("53920");					
      driver.findElement(By.name("submit")).submit();			
      		
      // Switching to Alert        
      Alert alert = driver.switchTo().alert();		
      		
      // Capturing alert message.    
      String alertMessage= alert.getText();		
      
      	
      		 
      // Displaying alert message		
      System.out.println(alertMessage);	
      Thread.sleep(5000);
      		
      // Accepting alert		
      alert.accept();	
      driver.close();
  }
}
