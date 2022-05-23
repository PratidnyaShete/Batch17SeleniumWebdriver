package Session_6_AlertPopUpFrameHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _5_FrameWithinFrameHandling {

	WebDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Frames.html");
	}
	@Test
	public void multiFrameHandling() {
		WebElement multiFrameBtn = driver.findElement(By.xpath("//a[@href='#Multiple']"));
		multiFrameBtn.click();
		//Switching to frame
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(frame1);
		//Switching to frame inside a frame
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='row']/iframe[@src='SingleFrame.html']")));
		
		WebElement textBoxInFrame = driver.findElement(By.xpath("//input[@type='text']"));
		textBoxInFrame.sendKeys("test test test");
		
		//Switching to the main window
		//either
		driver.switchTo().defaultContent();
		//Or
		//driver.switchTo().parentFrame();  //Switches to frame1
		//driver.switchTo().parentFrame();  //Switches to main window
		WebElement pageCentreText = driver.findElement(By.xpath("//h1[contains(text(),'Automation Demo Site ')]"));
		System.out.println(pageCentreText.getText());	
	}
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
}
