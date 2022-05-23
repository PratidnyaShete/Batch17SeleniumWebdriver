package Session_5;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class _1_DragAndDrop {

	WebDriver driver;
	@Before
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/droppable");
	}
	@Test
	public void DropDown() throws InterruptedException {
		WebElement element1 = driver.findElement(By.id("draggable"));
		WebElement draggable = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		// To halt the execution for sometime (demonstration purpose)
		Thread.sleep(3000);
		act.dragAndDrop(element1, draggable).build().perform();
		WebElement droppedTextEle = driver.findElement(By.xpath("//div[@id='droppable']/p[text()='Dropped!']"));
		Assert.assertEquals("Dropped!",droppedTextEle.getText());
	}
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	
	
	
	
}
