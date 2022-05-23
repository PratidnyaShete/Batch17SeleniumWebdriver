package Session_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _3_InvokeMSEdge {
	public static void main(String args[]) {
		//Automation
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\eclipse-workspace\\Batch17SeleniumWebdriver\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.navigate().refresh();
		
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
		driver.navigate().to("https://www.amazon.in/");
		System.out.println("WebPage title is: "+ driver.getTitle());
		if(driver.getTitle().equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"))
		{
			System.out.println("Title matched");
		}
		else {
			System.out.println("Title doesn't match");
		}
		
		driver.navigate().back();
		System.out.println("WebPage title after navigating back is: "+ driver.getTitle());
		
		driver.navigate().forward();
		System.out.println("WebPage title after navigating forward is: "+ driver.getTitle());  
		
		
		
		driver.close();
		
		
		
		
		
		
		
		
	}
}
