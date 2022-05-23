package Session_12_MiniatureFramework_UsingJunit.tests;

import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Session_12_MiniatureFramework_UsingJunit.locators.LandingPageLocators;
import Session_12_MiniatureFramework_UsingJunit.locators.SocialMediaPageLocators;
import Session_12_MiniatureFramework_UsingJunit.utilities.ElementActions;
import Session_12_MiniatureFramework_UsingJunit.utilities.JavaScriptUtils;
import Session_12_MiniatureFramework_UsingJunit.utilities.Utils_session12;
import Session_12_MiniatureFramework_UsingJunit.variables.LandingPageVariables;
import Session_12_MiniatureFramework_UsingJunit.variables.SigninPageVariables;
import Session_12_MiniatureFramework_UsingJunit.variables.SocialMediaPageVariables;

public class _3_Test {

	WebDriver driver;
	WebDriverWait wait;
	Properties prop;
	Utils_session12 utils;
	ElementActions elemementActions;
	JavaScriptUtils javaScriptUtil;

	@Before
	public void setUp()
	{
		utils = new Utils_session12();
		prop = utils.init_prop();
		driver = utils.init_driver(prop);
		elemementActions = new ElementActions(driver);
		wait = new WebDriverWait(driver, Integer.parseInt(prop.getProperty("WebDriverWaitTimeout")));
		javaScriptUtil = new JavaScriptUtils(driver);
	}
	
	
	// Validate Social Media Handles
	// 13. Facebook Social Media Page Redirection & Validation
	@Test
	public void _13_FaceBookMediaHandlesValidation()
	{
		elemementActions.doClick(LandingPageLocators.faceBookLink);
		elemementActions.switchToWindowId(driver, 1);
		elemementActions.waitForElementVisible(SocialMediaPageLocators.youtubeChannelNameElement);
		String facebookChannelName = elemementActions.doGetText(SocialMediaPageLocators.youtubeChannelNameElement);
		Assert.assertEquals("Facebook channel name is not matching", SocialMediaPageVariables.facebookChannelNameText, facebookChannelName);
	}
	
	// 14. Twitter Social Media Page Redirection & Validation
	@Test
	public void _14_TwitterMediaHandlesValidation()
	{
		elemementActions.doClick(LandingPageLocators.twitterLink);
		elemementActions.switchToWindowId(driver, 1);
		elemementActions.waitForElementVisible(SocialMediaPageLocators.twitterChannelNameElement);
		String twitterChannelName = elemementActions.doGetText(SocialMediaPageLocators.twitterChannelNameElement);
		Assert.assertEquals("Facebook channel name is not matching", SocialMediaPageVariables.twitterChannelNameText, twitterChannelName);
	}
	
	// 15. Youtube Social Media Page Redirection & Validation
	@Test
	public void _15_YoutubeMediaHandlesValidation()
	{
		elemementActions.doClick(LandingPageLocators.youTubeLink);
		elemementActions.switchToWindowId(driver, 1);
		elemementActions.waitForElementVisible(SocialMediaPageLocators.youtubeChannelNameElement);
		String youtubeChannelName = elemementActions.doGetText(SocialMediaPageLocators.youtubeChannelNameElement);
		Assert.assertEquals("Facebook channel name is not matching", SocialMediaPageVariables.youtubeChanneNameText, youtubeChannelName);
	}
	
	
	// 16. Newsletter subscription
	@Test
	public void _16_NewsletterSubscription()
	{
		elemementActions.doSendKeys(LandingPageLocators.newsLetterEmailTextBoxElement, SigninPageVariables.NewUserEmailID);
		elemementActions.doClick(LandingPageLocators.newsLetterEmailSendButtonElement);
		elemementActions.waitForElementVisible(LandingPageLocators.newsLetterSubscriptionSuccessAlertElement);
		Assert.assertEquals("News Letter Subscription Message is not matching with expected value", LandingPageVariables.newsLetterSubscriptionSuccessAlertText, 
		elemementActions.doGetText(LandingPageLocators.newsLetterSubscriptionSuccessAlertElement));	
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
}
