 package Session_12_MiniatureFramework_UsingJunit.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Session_12_MiniatureFramework_UsingJunit.locators.LandingPageLocators;
import Session_12_MiniatureFramework_UsingJunit.utilities.ElementActions;
import Session_12_MiniatureFramework_UsingJunit.utilities.JavaScriptUtils;
import Session_12_MiniatureFramework_UsingJunit.utilities.Utils_session12;
import Session_12_MiniatureFramework_UsingJunit.variables.LandingPageVariables;

public class _1_Test {

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

	@After
	public void teardown()
	{
		driver.quit();
	}

}
