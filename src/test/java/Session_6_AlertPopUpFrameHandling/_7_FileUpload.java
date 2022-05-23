package Session_6_AlertPopUpFrameHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _7_FileUpload {

	WebDriver driver;
	@Before
	public void setUp() {
		driver =new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
	}
	@Test
	public void fileUpload() throws InterruptedException {
	//Note type = file or class=Upfile	should be available for this in the dom
		WebElement chooseFileBtn = driver.findElement(By.xpath("//input[@type='file']"));
		chooseFileBtn.sendKeys("C:\\TestingSites.txt");
		Thread.sleep(3000);
		WebElement pressBtn = driver.findElement(By.xpath("//input[@value='Press']"));
		pressBtn.click();
		
	}
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
