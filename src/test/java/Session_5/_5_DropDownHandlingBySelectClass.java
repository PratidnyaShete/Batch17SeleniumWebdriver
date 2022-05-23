package Session_5;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _5_DropDownHandlingBySelectClass {

	WebDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	@Test
	public void dropDown() throws InterruptedException {
		WebElement createNewAccBtn = driver.findElement(By.xpath("//a[@id='u_0_2_2P' and text()='Create New Account']"));
		createNewAccBtn.click();
		WebElement birthday = driver.findElement(By.id("day"));
		WebElement birthMonth = driver.findElement(By.id("month"));
		WebElement birthYear = driver.findElement(By.id("year"));
		
		Select daySelect = new Select(birthday);
		daySelect.selectByVisibleText("16");
		//daySelect.selectByValue("16");
		Thread.sleep(3000);
		
		Select monthSelect = new Select(birthMonth);
		monthSelect.selectByVisibleText("Feb");
		
		Select yearSelect = new Select(birthYear);
		yearSelect.selectByVisibleText("1996");
		//yearSelect.selectByValue("1996");
	}

	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
