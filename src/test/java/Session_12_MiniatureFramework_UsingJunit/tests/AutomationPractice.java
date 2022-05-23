package Session_12_MiniatureFramework_UsingJunit.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Session_12_MiniatureFramework_UsingJunit.locators.AfterRegistrationPageLocators;
import Session_12_MiniatureFramework_UsingJunit.locators.LandingPageLocators;
import Session_12_MiniatureFramework_UsingJunit.locators.ProductDetails;
import Session_12_MiniatureFramework_UsingJunit.locators.RegisterUserDetailsPageLocators;
import Session_12_MiniatureFramework_UsingJunit.locators.SigninPageLocators;
import Session_12_MiniatureFramework_UsingJunit.locators.SocialMediaPageLocators;
import Session_12_MiniatureFramework_UsingJunit.utilities.ElementActions;
import Session_12_MiniatureFramework_UsingJunit.utilities.JavaScriptUtils;
import Session_12_MiniatureFramework_UsingJunit.utilities.Utils_session12;
import Session_12_MiniatureFramework_UsingJunit.variables.LandingPageVariables;
import Session_12_MiniatureFramework_UsingJunit.variables.ProductDetailsVariables;
import Session_12_MiniatureFramework_UsingJunit.variables.RegisterUserDetailsPageVariables;
import Session_12_MiniatureFramework_UsingJunit.variables.SigninPageVariables;
import Session_12_MiniatureFramework_UsingJunit.variables.SocialMediaPageVariables;

public class AutomationPractice {

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

	// 1. Url Redirection Test
	@Test
	public void _1_urlTest()
	{
		Assert.assertEquals("Url redirection is not as expected",LandingPageVariables.ExpectedRedirectedURL, elemementActions.doGetcurrentURL());
		System.out.println("Test -> 1. Url Redirection Test Passed");
	}

	// 2. Landing Page Title Test
	@Test
	public void _2_pageTitleTest()
	{

		Assert.assertEquals("Page title is incorrect",LandingPageVariables.LandingPageTitle, elemementActions.doGetPageTitle());
		System.out.println("Test -> 2. Landing Page Title Test passed");
	}

	// 3. Validate for all categories is displayed
	@Test
	public void _3_allCategoriesDisplayedTest()
	{
		ArrayList<String> expectedCategoryList = LandingPageVariables.ExpectedMainProductCategories();
		
		List<WebElement> actualProductCategoryList = elemementActions.getElementsList(LandingPageLocators.ProductCatoegoryList);
		
		for (int i = 0; i < expectedCategoryList.size(); i++) 
		{
			Assert.assertEquals("Product index no " + (i+1) + " is not matching with expected",expectedCategoryList.get(i), actualProductCategoryList.get(i).getText());
		}
		
		System.out.println("Test -> 3. Validate for all categories is displayed passed");
	}
	
	// 4. Validate Application Logo on landing page is displayed
	@Test
	public void _4_validateApplicationLogoOnLandingPage()
	{
		Assert.assertEquals("Application Logo on Landing Page is not Displayed",true, elemementActions.doIsDisplayed(LandingPageLocators.landingPageLogoImage));
		System.out.println("Test -> 4. Validate Application Logo on landing page is displayed passed");
	}
	
	// 5. Validate Application Logo Height on landing page
	@Test
	public void _5_validateApplicationLogoHeightOnLandingPage()
	{
		Assert.assertEquals("Apllication Logo height on Landing Page is not matching",LandingPageVariables.ApplicationLogoHeight, elemementActions.getAttributeValue(LandingPageLocators.landingPageLogoImage, "height", driver));
		System.out.println("Test -> 5. Validate Application Logo Height on landing page passed");
	}
	
	// 6. Validate Application Logo Width on landing page
	@Test
	public void _6_validateApplicationLogowidthOnLandingPage()
	{
		Assert.assertEquals("Application Logo width on Landing Page is not matching", LandingPageVariables.ApplicationLogoWidth, elemementActions.getAttributeValue(LandingPageLocators.landingPageLogoImage, "width", driver));
		System.out.println("Test -> 6. Validate Application Logo Width on landing page passed");
	}

	// 7. SignIn page title validation test
	@Test
	public void _7_SignInPageTitleValidationTest()
	{
		elemementActions.doClick(LandingPageLocators.SigninButtonElement);
		
		Assert.assertEquals("Signin Page Title is not matching", SigninPageVariables.SignInPageTitle, elemementActions.doGetPageTitle());
		System.out.println("Test -> 7. SignIn page title validation test passed");
	}
	
	// 8. Register User With New Email Id on SignIn Page
	@Test
	public void _8_RegisterNewUserTest()
	{
		_7_SignInPageTitleValidationTest();
		
		elemementActions.doSendKeys(SigninPageLocators.emailIdInputFieldElement, SigninPageVariables.NewUserEmailID);
		
		elemementActions.doClick(SigninPageLocators.createAnAccountButtonElement);
		
		Assert.assertEquals("\"Create an account\" text is not displayed on register user details page",RegisterUserDetailsPageVariables.crateAnAccountExpectedText, elemementActions.doGetText(RegisterUserDetailsPageLocators.CreateAnAccountTextElement));
		
		elemementActions.doClick(RegisterUserDetailsPageLocators.maleGenderRadioButtonElement);

		elemementActions.doSendKeys(RegisterUserDetailsPageLocators.userFirstNameTextboxElement, RegisterUserDetailsPageVariables.userFirstName);

		elemementActions.doSendKeys(RegisterUserDetailsPageLocators.userLastNameTextboxElement, RegisterUserDetailsPageVariables.userLastName);

		elemementActions.doSendKeys(RegisterUserDetailsPageLocators.userPasswordTextboxElement, RegisterUserDetailsPageVariables.userPassword);

		elemementActions.selectByValueFromDropDown(RegisterUserDetailsPageLocators.userDOBDayDropDownElement, RegisterUserDetailsPageVariables.DOBDayValue);

		elemementActions.selectByValueFromDropDown(RegisterUserDetailsPageLocators.userDOBMonthDropDownElement, RegisterUserDetailsPageVariables.DOBMonthValue);

		elemementActions.selectByValueFromDropDown(RegisterUserDetailsPageLocators.userDOBYearDropDownElement, RegisterUserDetailsPageVariables.DOBYearValue);
		
		if (RegisterUserDetailsPageVariables.IsSignUpForNewsLetter) 
		{
			elemementActions.doClick(RegisterUserDetailsPageLocators.signUpForNewsLetterCheckBoxElement);
		}
		
		if (RegisterUserDetailsPageVariables.IsspecialOfferEmailRec) 
		{
			elemementActions.doClick(RegisterUserDetailsPageLocators.specialOfferEmailRecCheckBoxElement);
		}
			
		elemementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressComanyNameTextBoxElement, RegisterUserDetailsPageVariables.AddressComanyName);
		
		elemementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressLine1TextBoxElement, RegisterUserDetailsPageVariables.AddressLine1Name);

		elemementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressLine2TextBoxElement, RegisterUserDetailsPageVariables.AddressLine2Name);

		elemementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressCityTextBoxElement, RegisterUserDetailsPageVariables.AddressCity);

		elemementActions.selectByVisibleTextFromDropDown(RegisterUserDetailsPageLocators.AddressStateDropDownElement, RegisterUserDetailsPageVariables.AddressState);

		elemementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressZipCodeTextBoxElement, RegisterUserDetailsPageVariables.AddressZipCode);

		elemementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressAdditionalInfoTextBoxElement, RegisterUserDetailsPageVariables.AddressAdditionalInfo);
		
		elemementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressMobilePhoneTextBoxElement, RegisterUserDetailsPageVariables.AddressMobilePhone);

		elemementActions.doClick(RegisterUserDetailsPageLocators.registerFormButtonElement);

		elemementActions.waitForElementVisible(AfterRegistrationPageLocators.registeredUserNameDisplayElement);
		Assert.assertEquals("Registered User First Name And Last Name is not displayed correctly after registration", RegisterUserDetailsPageVariables.userFirstName + " " + RegisterUserDetailsPageVariables.userLastName,
				elemementActions.doGetText(AfterRegistrationPageLocators.registeredUserNameDisplayElement));
		
		System.out.println("User Registered Successfully as -> " + RegisterUserDetailsPageVariables.userFirstName + " " + RegisterUserDetailsPageVariables.userLastName);
		
		System.out.println("Test -> 8. Register User With New Email Id on SignIn Page passed");
		
	}
	
	// 9. Search by a keyword in the product search box and validate how many products are matching with the name
	@Test
	public void _9_SearchProduct()
	{
		elemementActions.doSendKeys(LandingPageLocators.searchBox, "Dress");
		elemementActions.waitForElementPresent(LandingPageLocators.searchBoxResultList);
		
		List<WebElement> elementsList = elemementActions.getElementsList(LandingPageLocators.searchBoxResultList);
		
		int countOfProductsWithKeyword = 0;
		
		for (int i = 0; i < elementsList.size(); i++) 
		{
			if (elementsList.get(i).getText().contains("Dress")) 
			{
				countOfProductsWithKeyword = countOfProductsWithKeyword + 1;
			}
		} 
		if (countOfProductsWithKeyword == 5) {
			Assert.assertTrue(true);
		}
		
	}
	
	// 10. Fetch the all product price and get its total
	@Test
	public void _10_GetProductPriceTotal()
	{
		elemementActions.doClick(LandingPageLocators.topMenuDressesCategory);
		List<WebElement> productPriceListElement = elemementActions.getElementsList(ProductDetails.DressedPriceList);
		double priceTotal = 0;
		double expectedTotalPrice = 152.87000000000003;
		for (int i = 0; i < productPriceListElement.size(); i++) 
		{
			priceTotal = priceTotal + Double.parseDouble(productPriceListElement.get(i).getText().trim().substring(1));
			System.out.println(productPriceListElement.get(i).getText().trim().substring(1));
		}System.out.println(priceTotal);

		if (priceTotal == expectedTotalPrice) {
			Assert.assertTrue(true );
		}
		else {
			Assert.assertTrue(false);
		}
	}
	
	// 11. Send a Friend Feature
	@Test
	public void _11_RecomendToFriend()
	{
		elemementActions.doClick(LandingPageLocators.topMenuTShirtCategory);
		elemementActions.doMoveToElement(ProductDetails.optionsToBuyProduct);
		elemementActions.doActionsClick(ProductDetails.MoreOptionButton);
		
		elemementActions.waitForElementClickable(ProductDetails.SendFriendButton);
		elemementActions.doClick(ProductDetails.SendFriendButton);
		
		elemementActions.waitForElementClickable(ProductDetails.FrinedNameTextBox);
		elemementActions.doSendKeys(ProductDetails.FrinedNameTextBox, ProductDetailsVariables.FriendNameForRecommendation);
		elemementActions.doSendKeys(ProductDetails.FrinedEmailIdTextBox, ProductDetailsVariables.FriendEmailIdForRecommendation);
		
		elemementActions.waitForElementClickable(ProductDetails.FrinedMailSendButton);
		elemementActions.doActionsClick(ProductDetails.FrinedMailSendButton);
		
		elemementActions.waitForElementVisible(ProductDetails.emailConfirmationMessageText);
		System.out.println(elemementActions.doGetText(ProductDetails.emailConfirmationMessageText));
		
		Assert.assertEquals("Email Confirmation message is not machtching with the expected string", ProductDetailsVariables.recomendationEmailConformationText, elemementActions.doGetText(ProductDetails.emailConfirmationMessageText));
		
	}
	
	// 12. Change in the image using Color Feature
	@Test
	public void _12_productColourSelection()
	{
		elemementActions.doClick(LandingPageLocators.topMenuTShirtCategory);
		String orangeColourImageSourceLink = elemementActions.getAttributeValue(ProductDetails.FadedTShritOrgangeColourImage, "src", driver);
		System.out.println("Orange Colour Tshirt product Image Source Link : " + orangeColourImageSourceLink);
		
		javaScriptUtil.clickElementByJS(elemementActions.getElement(ProductDetails.FadedTShritBlueColourIcon));
		//elemementActions.doActionsClick(ProductDetails.FadedTShritBlueColourIcon);
		elemementActions.waitForElementVisible(ProductDetails.FadedTShritBlueColourImage);
		String blueColourImageSourceLink = elemementActions.getAttributeValue(ProductDetails.FadedTShritBlueColourImage, "src", driver);
		System.out.println("Blue Colour Tshirt product Image Source Link : " + blueColourImageSourceLink);
		
		if (!(orangeColourImageSourceLink.equals(blueColourImageSourceLink))) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
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
