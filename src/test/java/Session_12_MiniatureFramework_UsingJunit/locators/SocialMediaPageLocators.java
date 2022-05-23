package Session_12_MiniatureFramework_UsingJunit.locators;

import org.openqa.selenium.By;

public class SocialMediaPageLocators {

	// Locators - Social Media Page Locators
		public static By youtubeChannelNameElement = By.xpath("//div[@id='text-container']/child::yt-formatted-string[text()='Selenium Framework']");
		public static By twitterChannelNameElement = By.xpath("//div[@data-testid='titleContainer']//span[text()='Selenium Framework']");
		public static By facebookChannelNameElement = By.xpath("(//span[text()='Selenium Framework'])[1]");
}
