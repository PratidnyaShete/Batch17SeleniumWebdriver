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

public class _1_AlertHandling {

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
	public void handleAlert() throws InterruptedException {
		WebElement AlertBtn = driver.findElement(By.xpath("//div[@id='OKTab']/button[@class='btn btn-danger']"));
		AlertBtn.click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000); //To halt the operation for some time(demonstration purpose)
		//fetching the text of alert
		System.out.println("Text of alert is: " + alert.getText());
		Assert.assertEquals("Alert text is not matching","I am an alert box!", alert.getText());
		alert.accept();
	}
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
