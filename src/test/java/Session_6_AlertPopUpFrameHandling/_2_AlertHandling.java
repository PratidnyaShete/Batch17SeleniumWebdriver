package Session_6_AlertPopUpFrameHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_AlertHandling {
	WebDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Alerts.html");
	}
	
	@Test
	public void HandleAlertwithOkOrCancel() throws InterruptedException {
		WebElement alertTypeSelectionBtn = driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel ')]"));
		alertTypeSelectionBtn.click();
		WebElement AlertBtn = driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box ')]"));
		AlertBtn.click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000); //To halt the execution for sometime (demonstration purpose)
		System.out.println("Alert text is : " + alert.getText());
		
		alert.dismiss();
		
		WebElement alertConfirmMsg = driver.findElement(By.id("demo"));
		Assert.assertEquals("Alert text is not matching to expected text","You Pressed Cancel", alertConfirmMsg.getText());

	}
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
