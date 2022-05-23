package Session_4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParameterizedXpath {

	WebDriver driver;
	String textToBeClicked = "Pepe Jeans Sweatshirts";
	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
	}
	
	@Test
	public void searchBoxText() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
		searchBox.sendKeys("pepe");
		//To halt the execution for sometime (Demonstration purposes)
		Thread.sleep(3000);
		
		WebElement searchItem = driver.findElement(By.xpath("//ul[@class='desktop-group']//li[@class='desktop-suggestion null' and text()='"+textToBeClicked+"']"));
		searchItem.click();
			
		
		
		
		//To halt the execution for sometime (Demonstration purposes)	
	Thread.sleep(5000);	
		
	}
	
	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
