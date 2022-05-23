package Session_7;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _1_ToolTipHandling {

	WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/tool-tips/");
	}
	
	@Test
	public void toolTip() throws InterruptedException {
		WebElement hoverButton = driver.findElement(By.xpath("//button[@id='toolTipButton']"));
		//To halt the execution for sometime (demonstration purpose)
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(hoverButton).build().perform();
		//To halt the execution for sometime (demonstration purpose)
		Thread.sleep(3000);
		WebElement suggestionTextEle = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
		String suggestionText1 = suggestionTextEle.getText();
		System.out.println("Suggestion box text is : " + suggestionText1);
		Assert.assertEquals("You hovered over the Button", suggestionText1);
	}
	@Test
	public void textBoxToolTip() throws InterruptedException {
		WebElement TextBoxHoverBtn = driver.findElement(By.id("toolTipTextField"));
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(TextBoxHoverBtn).build().perform();
		//To halt the execution for sometime (demonstration purpose)
		Thread.sleep(3000);
		WebElement SuggestionText2 = driver.findElement(By.xpath("//div[contains(text(),'You hovered over the text field')]"));
		System.out.println("Suggestion box text is : " + SuggestionText2.getText());
		Assert.assertEquals("You hovered over the text field", SuggestionText2.getText());
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000); //To halt the execution for sometime (demonstration purpose)
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
