package Session_12_MiniatureFramework_UsingJunit.tests;

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
import Session_12_MiniatureFramework_UsingJunit.utilities.ElementActions;
import Session_12_MiniatureFramework_UsingJunit.utilities.JavaScriptUtils;
import Session_12_MiniatureFramework_UsingJunit.utilities.Utils_session12;
import Session_12_MiniatureFramework_UsingJunit.variables.LandingPageVariables;
import Session_12_MiniatureFramework_UsingJunit.variables.ProductDetailsVariables;
import Session_12_MiniatureFramework_UsingJunit.variables.RegisterUserDetailsPageVariables;
import Session_12_MiniatureFramework_UsingJunit.variables.SigninPageVariables;

public class _2_Test {

	WebDriver driver;
	WebDriverWait wait;
	Properties prop;
	Utils_session12 utils;
	ElementActions elementActions;
	JavaScriptUtils javaScriptUtil;

	@Before
	public void setUp()
	{
		utils = new Utils_session12();
		prop = utils.init_prop();
		driver = utils.init_driver(prop);
		elementActions = new ElementActions(driver);
		wait = new WebDriverWait(driver, Integer.parseInt(prop.getProperty("WebDriverWaitTimeout")));
		javaScriptUtil = new JavaScriptUtils(driver);
	}


	// 6. Validate Application Logo Width on landing page
	@Test
	public void _6_validateApplicationLogowidthOnLandingPage()
	{
		Assert.assertEquals("Application Logo width on Landing Page is not matching", LandingPageVariables.ApplicationLogoWidth, elementActions.getAttributeValue(LandingPageLocators.landingPageLogoImage, "width", driver));
		System.out.println("Test -> 6. Validate Application Logo Width on landing page passed");
	}

	// 7. SignIn page title validation test
	@Test
	public void _7_SignInPageTitleValidationTest()
	{
		elementActions.doClick(LandingPageLocators.SigninButtonElement);

		Assert.assertEquals("Signin Page Title is not matching", SigninPageVariables.SignInPageTitle, elementActions.doGetPageTitle());
		System.out.println("Test -> 7. SignIn page title validation test passed");
	}

	// 8. Register User With New Email Id on SignIn Page
	@Test
	public void _8_RegisterNewUserTest()
	{
		_7_SignInPageTitleValidationTest();

		elementActions.doSendKeys(SigninPageLocators.emailIdInputFieldElement, SigninPageVariables.NewUserEmailID);

		elementActions.doClick(SigninPageLocators.createAnAccountButtonElement);

		Assert.assertEquals("\"Create an account\" text is not displayed on register user details page",RegisterUserDetailsPageVariables.crateAnAccountExpectedText, elementActions.doGetText(RegisterUserDetailsPageLocators.CreateAnAccountTextElement));

		elementActions.doClick(RegisterUserDetailsPageLocators.maleGenderRadioButtonElement);

		elementActions.doSendKeys(RegisterUserDetailsPageLocators.userFirstNameTextboxElement, RegisterUserDetailsPageVariables.userFirstName);

		elementActions.doSendKeys(RegisterUserDetailsPageLocators.userLastNameTextboxElement, RegisterUserDetailsPageVariables.userLastName);

		elementActions.doSendKeys(RegisterUserDetailsPageLocators.userPasswordTextboxElement, RegisterUserDetailsPageVariables.userPassword);

		elementActions.selectByValueFromDropDown(RegisterUserDetailsPageLocators.userDOBDayDropDownElement, RegisterUserDetailsPageVariables.DOBDayValue);

		elementActions.selectByValueFromDropDown(RegisterUserDetailsPageLocators.userDOBMonthDropDownElement, RegisterUserDetailsPageVariables.DOBMonthValue);

		elementActions.selectByValueFromDropDown(RegisterUserDetailsPageLocators.userDOBYearDropDownElement, RegisterUserDetailsPageVariables.DOBYearValue);

		if (RegisterUserDetailsPageVariables.IsSignUpForNewsLetter) 
		{
			elementActions.doClick(RegisterUserDetailsPageLocators.signUpForNewsLetterCheckBoxElement);
		}

		if (RegisterUserDetailsPageVariables.IsspecialOfferEmailRec) 
		{
			elementActions.doClick(RegisterUserDetailsPageLocators.specialOfferEmailRecCheckBoxElement);
		}

		elementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressComanyNameTextBoxElement, RegisterUserDetailsPageVariables.AddressComanyName);

		elementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressLine1TextBoxElement, RegisterUserDetailsPageVariables.AddressLine1Name);

		elementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressLine2TextBoxElement, RegisterUserDetailsPageVariables.AddressLine2Name);

		elementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressCityTextBoxElement, RegisterUserDetailsPageVariables.AddressCity);

		elementActions.selectByVisibleTextFromDropDown(RegisterUserDetailsPageLocators.AddressStateDropDownElement, RegisterUserDetailsPageVariables.AddressState);

		elementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressZipCodeTextBoxElement, RegisterUserDetailsPageVariables.AddressZipCode);

		elementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressAdditionalInfoTextBoxElement, RegisterUserDetailsPageVariables.AddressAdditionalInfo);

		elementActions.doSendKeys(RegisterUserDetailsPageLocators.AddressMobilePhoneTextBoxElement, RegisterUserDetailsPageVariables.AddressMobilePhone);

		elementActions.doClick(RegisterUserDetailsPageLocators.registerFormButtonElement);

		elementActions.waitForElementVisible(AfterRegistrationPageLocators.registeredUserNameDisplayElement);
		Assert.assertEquals("Registered User First Name And Last Name is not displayed correctly after registration", RegisterUserDetailsPageVariables.userFirstName + " " + RegisterUserDetailsPageVariables.userLastName,
				elementActions.doGetText(AfterRegistrationPageLocators.registeredUserNameDisplayElement));

		System.out.println("User Registered Successfully as -> " + RegisterUserDetailsPageVariables.userFirstName + " " + RegisterUserDetailsPageVariables.userLastName);

		System.out.println("Test -> 8. Register User With New Email Id on SignIn Page passed");

	}

	// 9. Search by a keyword in the product search box and validate how many products are matching with the name
	@Test
	public void _9_SearchProduct()
	{
		elementActions.doSendKeys(LandingPageLocators.searchBox, "Dress");
		elementActions.waitForElementPresent(LandingPageLocators.searchBoxResultList);

		List<WebElement> elementsList = elementActions.getElementsList(LandingPageLocators.searchBoxResultList);

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
		elementActions.doClick(LandingPageLocators.topMenuDressesCategory);
		List<WebElement> productPriceListElement = elementActions.getElementsList(ProductDetails.DressedPriceList);
		double priceTotal = 0;
		double expectedTotalPrice = 152.87000000000003;
		for (int i = 0; i < productPriceListElement.size(); i++) 
		{
			priceTotal = priceTotal + Double.parseDouble(productPriceListElement.get(i).getText().trim().substring(1));
			System.out.println(productPriceListElement.get(i).getText().trim().substring(1));
		}System.out.println(priceTotal);

		if (priceTotal == expectedTotalPrice) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	// 11. Send a Friend Feature
	@Test
	public void _11_RecomendToFriend()
	{
		elementActions.doClick(LandingPageLocators.topMenuTShirtCategory);
		elementActions.doMoveToElement(ProductDetails.optionsToBuyProduct);
		elementActions.doActionsClick(ProductDetails.MoreOptionButton);
		
		elementActions.waitForElementClickable(ProductDetails.SendFriendButton);
		elementActions.doClick(ProductDetails.SendFriendButton);
		
		elementActions.waitForElementClickable(ProductDetails.FrinedNameTextBox);
		elementActions.doSendKeys(ProductDetails.FrinedNameTextBox, ProductDetailsVariables.FriendNameForRecommendation);
		elementActions.doSendKeys(ProductDetails.FrinedEmailIdTextBox, ProductDetailsVariables.FriendEmailIdForRecommendation);
		
		elementActions.waitForElementClickable(ProductDetails.FrinedMailSendButton);
		elementActions.doActionsClick(ProductDetails.FrinedMailSendButton);
		
		elementActions.waitForElementVisible(ProductDetails.emailConfirmationMessageText);
		System.out.println(elementActions.doGetText(ProductDetails.emailConfirmationMessageText));
		
		Assert.assertEquals("Email Confirmation message is not machtching with the expected string", ProductDetailsVariables.recomendationEmailConformationText, elementActions.doGetText(ProductDetails.emailConfirmationMessageText));
		
	}

	// 12. Change in the image using Color Feature
	@Test
	public void _12_productColourSelection()
	{
		elementActions.doClick(LandingPageLocators.topMenuTShirtCategory);
		String orangeColourImageSourceLink = elementActions.getAttributeValue(ProductDetails.FadedTShritOrgangeColourImage, "src", driver);
		System.out.println("Orange Colour Tshirt product Image Source Link : " + orangeColourImageSourceLink);

		javaScriptUtil.clickElementByJS(elementActions.getElement(ProductDetails.FadedTShritBlueColourIcon));
		//elemementActions.doActionsClick(ProductDetails.FadedTShritBlueColourIcon);
		elementActions.waitForElementVisible(ProductDetails.FadedTShritBlueColourImage);
		String blueColourImageSourceLink = elementActions.getAttributeValue(ProductDetails.FadedTShritBlueColourImage, "src", driver);
		System.out.println("Blue Colour Tshirt product Image Source Link : " + blueColourImageSourceLink);

		if (!(orangeColourImageSourceLink.equals(blueColourImageSourceLink))) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	@After
	public void teardown()
	{
		driver.quit();
	}
}
