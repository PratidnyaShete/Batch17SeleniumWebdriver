package Session_6_AlertPopUpFrameHandling;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _6_WindowTabHandling {

	WebDriver driver;
	
	@Before
	public void setUp() {
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://demoqa.com/browser-windows");
	}
	@Test
	public void tabHandling_1() {
		System.out.println("tabHandling_1 by using set");
		WebElement newTabBtn = driver.findElement(By.id("tabButton"));
		newTabBtn.click();
		System.out.println("Current window title is :"+ driver.getTitle());
		
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> it = handle.iterator();
		
		String parentWindowId = it.next();
		String childWindowId1 = it.next();
		
		System.out.println("Parent window Id is: " + parentWindowId);
		driver.switchTo().window(childWindowId1);
		
		System.out.println("Child1 window title is :" + driver.getTitle());
		WebElement textInNewTab = driver.findElement(By.id("sampleHeading"));
		System.out.println("After opening the tab text available in the tab is: "+ textInNewTab.getText());
		driver.close();
		driver.switchTo().window(parentWindowId);
		
		System.out.println("Parent window title is :" + driver.getTitle());
		System.out.println("Parent window id is :" + parentWindowId);	
	}
	
	@Test
	public void tabHandling_2() {
		System.out.println("tabHandling_2 by using set");
		WebElement newTabBtn = driver.findElement(By.id("tabButton"));
		newTabBtn.click();
		System.out.println("Current window title is :"+ driver.getTitle());
		ArrayList<String> handles = new ArrayList<String> (driver.getWindowHandles());
		String parentWindowId = handles.get(0);
		String childWindowId1 = handles.get(1);
		
		System.out.println("Parent window Id is : " + parentWindowId);
		driver.switchTo().window(childWindowId1);
		System.out.println("child1 window title is : " + driver.getTitle());
		System.out.println("child1 window id is : " + childWindowId1);
		
		WebElement textInNewTab = driver.findElement(By.id("sampleHeading"));
		System.out.println("After opening the tab text available in the tab is: "+ textInNewTab.getText());
		System.out.println("After opening the tab link available in the new tab is: "+ driver.getCurrentUrl()); ///////
		driver.close();
		driver.switchTo().window(parentWindowId);
		
		System.out.println("Parent window title is :" + driver.getTitle());
		System.out.println("Parent window id is :" + parentWindowId);
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
