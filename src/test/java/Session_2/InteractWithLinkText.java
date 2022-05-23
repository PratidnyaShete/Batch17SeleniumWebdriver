package Session_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractWithLinkText {
public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	driver.get("https://dzone.com/articles/find-elements-with-link-text-amp-partial-link-text");
	System.out.println("Landing page title is : " + driver.getTitle());

	WebElement linktextElement = driver.findElement(By.linkText("ID locator in Selenium"));
	linktextElement.click();
	
	
	Thread.sleep(3000);
	driver.quit();
	
	
	
	
	
	
	
	
}
}
