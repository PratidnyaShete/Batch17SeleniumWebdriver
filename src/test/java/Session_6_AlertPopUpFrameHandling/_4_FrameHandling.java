package Session_6_AlertPopUpFrameHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4_FrameHandling {
	
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
	public void singleFrameHandling() {
		WebElement singleFrameBtn = driver.findElement(By.xpath("//a[@href='#Single']"));
		singleFrameBtn.click();
		//Switching to frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='singleframe']")));
		WebElement textBoxInFrame = driver.findElement(By.xpath("//input[@type='text']"));
		textBoxInFrame.sendKeys("test test test");
		//Switching back to main window
		driver.switchTo().defaultContent();
		WebElement pageCentreText = driver.findElement(By.xpath("//h1[contains(text(),'Automation Demo Site ')]"));
		System.out.println(pageCentreText.getText());
	}
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
