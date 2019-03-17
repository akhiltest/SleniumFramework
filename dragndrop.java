package b6;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	public class dragndrop {

		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver","D:\\Akhil\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.get("https://www.only-testing-blog.blogspot.in/2014/09/drag-and-drop.html");
			Actions act=new Actions(driver);
			WebElement iFrame=driver.findElement(By.xpath("//div[@id='post-body-5978252100611321093']"));
			driver.switchTo().frame(iFrame);
			WebElement source=driver.findElement(By.xpath("//div[@id='dragdiv']"));
			WebElement target=driver.findElement(By.xpath("//div[@id='dropdiv']"));
			act.dragAndDrop(source,target).build().perform();


		}

	}
