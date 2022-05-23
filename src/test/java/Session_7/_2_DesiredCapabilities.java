package Session_7;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class _2_DesiredCapabilities {

WebDriver driver;
	
	@Before
	public void setUp() {
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setAcceptInsecureCerts(true);
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		driver = new ChromeDriver(cap);
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://cacert.com");
	}
	@Test
	public void test() {
		System.out.println(driver.getTitle());
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000); //To halt the execution for sometime (demonstration purpose)
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
