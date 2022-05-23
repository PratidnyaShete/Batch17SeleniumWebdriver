package Session_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_InvokeChrome {
public static void main(String args[]) {
	//Automation
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\Batch17SeleniumWebdriver\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	driver.get("https://www.facebook.com/");
	
	String title = driver.getTitle();
	String titleExpected = "Facebook – log in or sign up";
	System.out.println("Web Page title is: " + title);
	
	//Validation
	if(title.equals(titleExpected)) {
		System.out.println("Title Matched");
	}
	else {
		System.out.println("Title Mismatched");
	}
	
	driver.close();
	//driver.quit();
	
	
	
	
	
	
	
}
}
