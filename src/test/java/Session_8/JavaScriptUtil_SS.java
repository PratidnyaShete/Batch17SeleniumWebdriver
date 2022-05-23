package Session_8;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil_SS {

	WebDriver driver;
	
	public JavaScriptUtil_SS(WebDriver driver) {
		this.driver = driver;
	}
	
	// This method will scroll the page until the element is not visible on the page
	public void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	// This method will flash the specified webelement
	public void flash(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundcolor");
		for(int i=0; i<20; i++) {
			changeColor("rgb(0,200,0)",element); //1
			changeColor(bgcolor, element);
		}
	}
	
	// This method will change the existing  color of webElement to the specified colour in the argument string color
	public void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e){	
		}
	}
	
	// This method will draw a solid red color border to the WebElement
	public void drawBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	// This method will generate an alert on current web page with String value as parameter message
	public void generateAlert(String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}
	
	// This method will click on the WebElement specified in the argument
	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("argument[0].click();", element);
	}
	
	// This method will refresh the page
	public void refreshBrowserByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	
	// This method will return the current title of webPage as String
	public String getTitleByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	// This method will return the inner page text available for the current HTML page
	public String getPageInnerText() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText").toString();
		return pageText;
	}
	
	// This method will scroll the page to the bottom
	public void scrollPageDown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	// This method will return the browser information in the form of String
	public String getBrowserInfo() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String uAgent = js.executeScript("return navigator.userAgent;").toString();
		return uAgent;
	}
	
	// This method will send Text to the WebElement which is having html id attribute available 
	public void sendKeysUsingSwitchId(String id, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('"+ id +"').value'"+ value +"'");
	}
	
	// This method will send text to the WebElement which is having html name attribute is available
	public void sendKeysUsingSwitchName(String name, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementByName('"+ name +"').value'"+ value +"'");
	}
	
	public void checkPageIsReady() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		if(js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page is loaded.");
			return;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
