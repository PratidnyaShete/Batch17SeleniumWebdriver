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

public class _2_DragAndDrop {

	WebDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@Test
	public void dragDrop_1() throws InterruptedException {
		driver.get("https://demoqa.com/droppable");
		WebElement element1 = driver.findElement(By.id("draggable"));
		WebElement draggable = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		// To halt the execution for sometime (demonstration purpose)
		Thread.sleep(3000);
		act.dragAndDrop(element1, draggable).build().perform();
		WebElement droppedTextEle = driver.findElement(By.xpath("//div[@id='droppable']/p[text()='Dropped!']"));
		Assert.assertEquals("Text doesn't match", "Dropped!", droppedTextEle.getText());
	}
	@Test
	public void dragDrop_2() throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/");
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frameEle);
		//Alternate way
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement element1 = driver.findElement(By.id("draggable"));
		WebElement dropArea = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		Thread.sleep(3000);      // To halt the execution for sometime (demonstration purpose)
		act.dragAndDrop(element1, dropArea).build().perform();
		//act.clickAndHold(element1).moveToElement(dropArea).build().perform();
	}
	@After
	public void tearDown() throws InterruptedException {
		// To halt the execution for sometime (demonstration purpose)
		Thread.sleep(3000);
		driver.quit();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
