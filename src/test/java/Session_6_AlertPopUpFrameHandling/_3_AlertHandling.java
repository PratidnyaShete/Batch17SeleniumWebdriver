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

public class _3_AlertHandling {

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
	public void alertHandlingWithTextBox() throws InterruptedException {
		WebElement alertSelectionBtn = driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox ')]"));
		alertSelectionBtn.click();
		 WebElement AlertBtn = driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box ')]"));
		 AlertBtn.click();
		 Alert alert = driver.switchTo().alert();
		 Thread.sleep(3000);
		 alert.sendKeys("Tom peter");
		 Thread.sleep(3000);
		 alert.accept();
		 WebElement alertConfirmingMsg = driver.findElement(By.id("demo1"));
		 Assert.assertEquals("Alert confirmation message doesn't match expected messange",true, alertConfirmingMsg.getText().contains("Tom peter"));
		 }
	@Test
	public void test() {
		//http://the-internet.herokuapp.com/digest_auth
		String username = "admin";
		String password = "admin";
		String url = "http://" + username + ":" + password + "@" + "the-internet.herokuapp.com/digest_auth";
		driver.get(url);
		WebElement msg = driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]"));
		Assert.assertNotEquals("Congratulations!",msg );
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
	}
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
