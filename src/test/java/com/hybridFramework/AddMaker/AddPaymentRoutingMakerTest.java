package com.hybridFramework.AddMaker;

import java.util.Currency;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.AddEntityTypeMaker;
import com.hybridFramework.PageObject.AddPaymentRoutingMaker;
import com.hybridFramework.PageObject.AddPaymentTypeMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddPaymentRoutingMakerTest extends TestBase {
	AddPaymentRoutingMaker addpaymentroutingmaker;

	private final Logger log = LoggerHelper.getLogger(AddPaymentRoutingMakerTest.class);

	@Test(priority = 1)
	public void testLoginToAddPaymentRoutingMaker() throws Exception {
		log.info(Currency.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		addpaymentroutingmaker = new AddPaymentRoutingMaker(driver);
		addpaymentroutingmaker.enterloginid("lastmile1");
		addpaymentroutingmaker.enterpassword("password@2");
		addpaymentroutingmaker.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAddPaymentRoutingMakerPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		addpaymentroutingmaker.toverifyhomepage();
		addpaymentroutingmaker.clikonmasterdefinitionmakerMenu();
		addpaymentroutingmaker.clickonAddPaymentRoutingMakerSubMenu();
		addpaymentroutingmaker.toswitchFieldsareinmandatory();
		addpaymentroutingmaker.selectMandateCOdetoBeRouted();
		addpaymentroutingmaker.enteramountFromTextfield("56780");
		addpaymentroutingmaker.enteramountToTextfield("88990");
		addpaymentroutingmaker.selectisisActiveStatus();
		addpaymentroutingmaker.clickonsubmitInMakerpage();
		addpaymentroutingmaker.verifySuccesfullMessage();
	}

	@Test(priority = 3)
	// Checker Page..
	public void toLoginAddPaymentRoutingchekerPage() throws Exception {
		addpaymentroutingmaker.enterloginid("lastmile3");
		addpaymentroutingmaker.enterpassword("password@1");
		addpaymentroutingmaker.clickonlogin();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// addpaymentroutingmaker.toverifyhomepage();
		Thread.sleep(4000);
		addpaymentroutingmaker.clickonMasterDefinitionChecker();
		Thread.sleep(4000);
		addpaymentroutingmaker.clickOnPaymentRoutingCheckerSubMenu();
		addpaymentroutingmaker.verifyPaymentRoutingCheckerPages();

	}

	// in Checker page
	@Test(priority = 4)
	public void verifyAddcheckerListinPaymentRoutingCheckerpage() throws Exception {
		addpaymentroutingmaker.verifyAddcheckerListInPaymentRoutingCheckerpage();
		addpaymentroutingmaker.HandleTheDynamicVluesWithCheckbox();
		// old code
		// addpaymentroutingmaker.multiplecheckbox();
		// currencypage.selectHeadercheckbox();
	}

	// in Checker page
	@Test(priority = 5)
	// click on submit Button and verify Message.
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {
		addpaymentroutingmaker.clickonsubmitbuttonInPaymentTYPECHECKERPage();
		addpaymentroutingmaker.toverifysuccessfulMessageinPaymentRoutingCheckerPage();
	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerHasApprovedAddPaymentRoutingMaker() throws Exception {
		// click on log out checker Button .
		addpaymentroutingmaker.gotoMakerPagewhenCheckerhasApprovedPaymenRoutingeMaker();
		// here we call the driver because the without can not Automate
		addpaymentroutingmaker = new AddPaymentRoutingMaker(driver);
		addpaymentroutingmaker.enterloginid("lastmile1");
		addpaymentroutingmaker.enterpassword("password@2");
		addpaymentroutingmaker.clickonlogin();
		Thread.sleep(5000);
		addpaymentroutingmaker.toverifyhomepage();
		Thread.sleep(5000);
		addpaymentroutingmaker.clikonmasterdefinitionmakerMenu();
		addpaymentroutingmaker.clickonAddPaymentRoutingMakerSubMenu();
		addpaymentroutingmaker.toswitchFieldsareinmandatory();
		addpaymentroutingmaker.clickOnviewButtoninMakerPage();
		addpaymentroutingmaker.switchToNewWindow(1);
		addpaymentroutingmaker.verifyViewpageBySerachField();
		addpaymentroutingmaker.verifytheViewpageWithTextInViewPage();
		// Thread.sleep(5000);
		addpaymentroutingmaker.verifyBytheDropDownlistValuesOneByOneOnViewPage();

	}

	// switch To Main window Payment Routing Modify Maker
	// Switch the Child window (Payment routing view page ) To parent window(Payment
	// Routing Maker page)
	@Test(priority = 7)
	public void switchToMainwindow() throws Exception {
		// switch view page to Maker page and click on Modify button.
		addpaymentroutingmaker.switch2();
		addpaymentroutingmaker.selectMandateCodeInModifyPaymentRoutingMakerPage();
		// click on first Submit button
		addpaymentroutingmaker.clickOnsubmitbutton();
		// modify Submit Button
		Thread.sleep(5000);
		addpaymentroutingmaker.clickmodifysubmitbutton();
		Thread.sleep(5000);
		addpaymentroutingmaker.verificationMessageInModifyPaymentRoutingTypePage();
	}

// login To payment Routing Checker if Modify the Same data 
	// go to the CHecker Page.and verify the checker page.
	@Test(priority = 8)
	public void testloginToAddPaymentRoutingChecker() throws Exception {
		addpaymentroutingmaker.enterloginid("lastmile3");
		addpaymentroutingmaker.enterpassword("password@1");
		addpaymentroutingmaker.clickonlogin();
		addpaymentroutingmaker.clickonMasterDefinitionChecker();
		addpaymentroutingmaker.clickOnPaymentRoutingCheckerSubMenu();
		addpaymentroutingmaker.verifyPaymentRoutingCheckerPages();

	}

	@Test(priority = 9)
	// calling
	// verify Payment Routing checker Page List After Modification has Done By Maker
	public void verifyAddPaymentRoutingCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		// in Cheker page when Modification has done By Maker
		addpaymentroutingmaker.verifyListOfPaymentRoutingIncheckerWhenModificationhasDoneByMaker();
		addpaymentroutingmaker.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		addpaymentroutingmaker.clickonsubmitbuttonInPaymentTYPECHECKERPage();
		addpaymentroutingmaker.toverifysuccessfulMessageinPaymentRoutingCheckerPage();
	}

	@Test(priority = 10)
	// go To The Country Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheAddPaymentRoutingMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		addpaymentroutingmaker.gotoMakerPagewhenCheckerhasApprovedPaymenRoutingeMaker();
		addpaymentroutingmaker = new AddPaymentRoutingMaker(driver);
		addpaymentroutingmaker.enterloginid("lastmile1");
		addpaymentroutingmaker.enterpassword("password@2");
		addpaymentroutingmaker.clickonlogin();
		Thread.sleep(5000);
		addpaymentroutingmaker.toverifyhomepage();
		Thread.sleep(5000);
		addpaymentroutingmaker.clikonmasterdefinitionmakerMenu();
		addpaymentroutingmaker.clickonAddPaymentRoutingMakerSubMenu();
		addpaymentroutingmaker.toswitchFieldsareinmandatory();
		addpaymentroutingmaker.clickOnviewButtoninMakerPage();
		addpaymentroutingmaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		addpaymentroutingmaker.verifyViewpageBySearchFieldWhenModifyThePaymentRoutingAndApprovedDoneByChecker();
		// By Verify the particular Text With Column Values
		Thread.sleep(5000);
		addpaymentroutingmaker.toVerifyTextInViewMakerPagewhenModified();
       Thread.sleep(5000);
		addpaymentroutingmaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 11)
	// switch To window Modify View Page To ADD Payment Routing Maker Page
	// and LogOut
	public void switchTowindowModifyViewPageToAddPaymentRoutingPage() throws Exception {
		Thread.sleep(5000);
		addpaymentroutingmaker.SwitchTheWindowFrom3ChildToParent();
		addpaymentroutingmaker.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 12)
	public void testloginToPaymentRoutingCheckerToVerifyCheckerViewPageWhenModifedThePaymentRouting() throws Throwable {
		addpaymentroutingmaker.enterloginid("lastmile3");
		addpaymentroutingmaker.enterpassword("password@1");
		addpaymentroutingmaker.clickonlogin();
		addpaymentroutingmaker.clickonMasterDefinitionChecker();
		addpaymentroutingmaker.clickOnPaymentRoutingCheckerSubMenu();
		addpaymentroutingmaker.verifyPaymentRoutingCheckerPages();
		addpaymentroutingmaker.clickOnviewInChecker();
		driver.manage().window().maximize();
		addpaymentroutingmaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page

		addpaymentroutingmaker.verifyViewpageBySearchFieldWhenModifyThePaymentRoutingAndApprovedDoneByChecker();
		addpaymentroutingmaker.toVerifyTextInViewMakerPagewhenModified();

		addpaymentroutingmaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();

		addpaymentroutingmaker.SwitchTheWindowFrom4ChildToParent();
		addpaymentroutingmaker.clickOnlogoutCheckerButton();
	}

}
