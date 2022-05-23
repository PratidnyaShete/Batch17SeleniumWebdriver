package Exercise;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Ex_1 {

	WebDriver driver;
	String url = "http://demo.automationtesting.in/Register.html";
	String FirstName = "Pratidnya";
	String LastName = "Shete";
	String Address = "102, Baker's Street, Yayati colony, PCMC";
	String EmailAdd = "shetePratidnya5@gmail.com";
	String PhoneNo = "0123456789";
	String PassWord = "a1b2c3";

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Test
	public void validation() {
		String ExpTitle = "Register";
		String ActTitle = driver.getTitle();
	    Assert.assertEquals("Title Mismatch", ExpTitle, ActTitle);
	}
    @Test
	public void test() {
		WebElement FirstNameBox = driver.findElement(By.xpath("//input[@placeholder = 'First Name']"));
		FirstNameBox.sendKeys(FirstName);
		WebElement LastNameBox = driver.findElement(By.xpath("//input[@placeholder = 'Last Name']"));
		LastNameBox.sendKeys(LastName);
		WebElement AddressBox = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
		AddressBox.sendKeys(Address);
		WebElement EmailBox = driver.findElement(By.xpath("//input[@ng-model='EmailAdress']"));
		EmailBox.sendKeys(EmailAdd);
		WebElement PhoneNoBox = driver.findElement(By.xpath("//input[@type='tel']"));
		PhoneNoBox.sendKeys(PhoneNo);

		WebElement FemaleRadioBtn = driver.findElement(By.xpath("//input[@value='FeMale']"));
		FemaleRadioBtn.click();
		WebElement HockeyCheckBox = driver.findElement(By.id("checkbox3"));
		HockeyCheckBox.click();

		WebElement EnterPass = driver.findElement(By.id("firstpassword"));
		EnterPass.sendKeys(PassWord);
		WebElement ConfirmPass = driver.findElement(By.id("secondpassword"));
		ConfirmPass.sendKeys(PassWord);
		WebElement SubmitBtn = driver.findElement(By.id("submitbtn"));
		SubmitBtn.click();
	}

	@After
	public void tear() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();

	}

}
