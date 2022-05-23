package Session_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractWithXpath {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://demo.automationtesting.in/Register.html");
		System.out.println("Landing page title is : " + driver.getTitle());		
		
		WebElement UserFirstName = driver.findElement(By.xpath("//input[@placeholder ='First Name']"));
		UserFirstName.sendKeys("Pratidnya");
		WebElement UserLastName = driver.findElement(By.xpath("//input[@placeholder ='Last Name']"));
	    UserLastName.sendKeys("Shete");
	    WebElement UserAddress = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
	    UserAddress.sendKeys("pimpri chinchwad");
	    WebElement MaleRadio = driver.findElement(By.xpath("//input[@value='Male']"));
	    MaleRadio.click();
	    WebElement MovieCheckbox = driver.findElement(By.id("checkbox2"));
	    MovieCheckbox.click();
	    WebElement HockeyCheckbox = driver.findElement(By.id("checkbox3"));
	    HockeyCheckbox.click();
	    WebElement Password = driver.findElement(By.id("firstpassword"));
	    Password.sendKeys("abcdefg");
	    WebElement ConPassword = driver.findElement(By.id("secondpassword"));
	    ConPassword.sendKeys("abcdefg");
	    WebElement SubmitBtn = driver.findElement(By.id("submitbtn"));
	    SubmitBtn.click();
	    
	    
	    
	    
	    
	    
	    
		Thread.sleep(3000);
		driver.quit();
	}
}
