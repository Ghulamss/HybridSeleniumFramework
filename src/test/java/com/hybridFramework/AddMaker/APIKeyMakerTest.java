package com.hybridFramework.AddMaker;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.APIKeyMaker;
import com.hybridFramework.PageObject.UpperLimitMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class APIKeyMakerTest extends TestBase {
	APIKeyMaker apimaker;

	private final Logger log = LoggerHelper.getLogger(APIKeyMakerTest.class);

	@Test(priority = 1)
	public void testLoginToAPIKeyMaker() throws Exception {
		log.info(APIKeyMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		apimaker = new APIKeyMaker(driver);
		apimaker.enterloginid("lastmile8");
		apimaker.enterpassword("password@1");
		apimaker.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAPIKeyMakerPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		apimaker.toverifyhomepage();
		apimaker.clikonmasterdefinitionmakerMenu();
		apimaker.clickonApiKeyMakerSubMenu();
		apimaker.toswitchFieldsareinmandatory();
		// 1234567890098760
		apimaker.enterApiKey("1234567890098772");
		apimaker.clickonsubmitInMakerpage();
		apimaker.verifySuccesfullMessageAndClickOnLogOut();
	}

	@Test(priority = 3)
	// Checker Page.
	public void toAPIKeyMakerTestchekerlogin() throws Exception {
		apimaker.enterloginid("lastmile3");
		apimaker.enterpassword("password@1");
		apimaker.clickonlogin();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// apimaker.toverifyhomepage();
		Thread.sleep(4000);
		apimaker.clickonMasterDefinitionChecker();
		Thread.sleep(4000);
		apimaker.clickOnApiKeyCheckerSubMenu();
		apimaker.verifyApiKeyCheckerPage();

	}

	// in API Key Checker page
	@Test(priority = 4)
	public void verifyAPIKeyCheckerpage() throws Exception {
		apimaker.verifyAddcheckerListOnAPiKeyCheckerpage();
		apimaker.HandleTheDynamicVluesWithCheckbox();

	}

	// in Checker page
	@Test(priority = 5)
	// click on submit Button and verify Message.
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {
		apimaker.clickonsubmitbuttOnChackerPage();
		apimaker.toverifysuccessfulMessageOnCheckerPage();
	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerPagewhenApprovedApiCheckerpage() throws Exception {
		// click on log out checker Button .
		apimaker.gotoMakerPagewhenCheckerhasApproved();
		// here we call the driver because the without can not Automate
		apimaker = new APIKeyMaker(driver);
		apimaker.enterloginid("lastmile1");
		apimaker.enterpassword("password@2");
		apimaker.clickonlogin();
		Thread.sleep(5000);
		apimaker.toverifyhomepage();
		Thread.sleep(5000);
		apimaker.clikonmasterdefinitionmakerMenu();
		apimaker.clickonApiKeyMakerSubMenu();
		apimaker.toswitchFieldsareinmandatory();
		apimaker.clickOnviewButtoninMakerPage();
		apimaker.switchToNewWindow(1);
		apimaker.verifyViewpageBySearchField();
		apimaker.VerifyViewPageByTextInViewPage();
		// select drop down is not available In Api Key Page
		// apimaker.selectThevaluesFromDropDownOneByOne();

	}

	// Switch the Child window (Api Key view page ) To parent window(Api Key Maker
	// page)
	// Modify option is not available on Api Key
	@Test(priority = 7)
	public void switchToMainwindow() throws Exception {
		// switch view page to Maker page and click on Modify button
		apimaker.switchViewPageToMakerPage();

	}

}
