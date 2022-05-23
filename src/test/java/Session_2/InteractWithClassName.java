package Session_2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractWithClassName {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://zero.webappsecurity.com/");
		System.out.println("Landing page title is : " + driver.getTitle());

		// WebElement signInButton = driver.findElement(By.id("signin_button"));
		WebElement signInButton = driver.findElement(By.className("signin"));
		signInButton.click();

		String nextPageTitle = driver.getTitle();
		System.out.println("Next page title is : " + nextPageTitle);
		Thread.sleep(3000);

		WebElement usernameTextBox = driver.findElement(By.id("user_login"));
		WebElement PasswordTextBox = driver.findElement(By.name("user_password"));
		WebElement signInButton1 = driver.findElement(By.name("submit"));
		usernameTextBox.sendKeys("username");
		PasswordTextBox.sendKeys("password");
		signInButton1.click();

		Thread.sleep(3000);
		driver.quit();
	}
}
