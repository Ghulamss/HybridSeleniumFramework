package com.hybridFramework.AddMaker;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.UpperLimitMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class UpperLimitMakerTest extends TestBase {
	UpperLimitMaker upperlimitmaker;

	private final Logger log = LoggerHelper.getLogger(UpperLimitMakerTest.class);

	@Test(priority = 1)
	public void testLoginToUpperLimitMaker() throws Exception {
		log.info(UpperLimitMaker.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		upperlimitmaker = new UpperLimitMaker(driver);
		upperlimitmaker.enterloginid("lastmile8");
		upperlimitmaker.enterpassword("password@1");
		upperlimitmaker.clickonlogin();

	}

	@Test(priority = 2)
	public void testToUpperLimitMakerPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		upperlimitmaker.toverifyhomepage();
		upperlimitmaker.clikonmasterdefinitionmakerMenu();
		upperlimitmaker.clickonUpperLimitMakerSubMenu();
		upperlimitmaker.toswitchFieldsareinmandatory();
		upperlimitmaker.clickOnModifyButton();
		upperlimitmaker.enterBDTamount("14000");
		upperlimitmaker.clickonsubmitInMakerpage();
		upperlimitmaker.verifySuccesfullMessage();
	}

	@Test(priority = 3)
	// Checker Page.
	public void toLoginTotUpperLimitCheckerPage() throws Exception {
		upperlimitmaker.enterloginid("lastmile3");
		upperlimitmaker.enterpassword("password@1");
		upperlimitmaker.clickonlogin();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// upperlimitmaker.toverifyhomepage();
		Thread.sleep(4000);
		upperlimitmaker.clickonMasterDefinitionChecker();
		Thread.sleep(4000);
		upperlimitmaker.clickOnUpperLimitCheckerSubMenu();
		upperlimitmaker.verifyUpperLimitCheckerPage();

	}

	// in Upper Limit page
	@Test(priority = 4)
	public void verifyAddcheckerListOnUpperLimitCheckerpage() throws Exception {
		upperlimitmaker.verifyAddcheckerListOnUpperLimitCheckerpage();
		upperlimitmaker.HandleTheDynamicVluesWithCheckbox();

	}

	// in Checker page
	@Test(priority = 5)
	// click on submit Button and verify Message.
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {
		upperlimitmaker.clickonsubmitbuttOnChackerPage();
		upperlimitmaker.toverifysuccessfulMessageOnCheckerPage();
	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerApprovedUpperLimitMakerpage() throws Exception {
		// click on log out checker Button .
		upperlimitmaker.gotoMakerPagewhenCheckerhasApproved();
		// here we call the driver because the without can not Automate
		upperlimitmaker = new UpperLimitMaker(driver);
		upperlimitmaker.enterloginid("lastmile1");
		upperlimitmaker.enterpassword("password@2");
		upperlimitmaker.clickonlogin();
		Thread.sleep(5000);
		upperlimitmaker.toverifyhomepage();
		Thread.sleep(5000);
		upperlimitmaker.clikonmasterdefinitionmakerMenu();
		upperlimitmaker.clickonUpperLimitMakerSubMenu();
		upperlimitmaker.toswitchFieldsareinmandatory();
		upperlimitmaker.clickOnviewButtoninMakerPage();
		upperlimitmaker.switchToNewWindow(1);
		upperlimitmaker.verifyViewpageBySearchField();
		upperlimitmaker.multippleSelectVerifyTextInViewPage();
		upperlimitmaker.selectThevaluesFromDropDownOneByOne();

	}

	// switch To Main window Upper Limit Modify Maker
	// Switch the Child window (Upper Limit view page ) To parent window(Upper Limit
	// Maker
	// page)
	@Test(priority = 7)
	public void switchToMainwindow() throws Exception {
		// switch view page to Maker page and click on Modify button.
		upperlimitmaker.switchViewPageToMakerPageAndClickOnModifyButtonAndVerifyModifyMakerPage();
		upperlimitmaker.enterBDTAmoutInModifyUpperLimiMakerMakerPage();
		// click on first Submit button
		upperlimitmaker.clickOnsubmitbutton();
		// modify Submit Button
		// Thread.sleep(5000);
		// upperlimitmaker.clickmodifysubmitbutton();
		Thread.sleep(5000);
		upperlimitmaker.verificationMessageInModifyUpperLimitPageAndClcickOnLogOut();
	}

// login To Upper Limit Checker if Modify the Same data 
	// go to the CHecker Page.and verify the checker page.
	@Test(priority = 8)
	public void testloginToUpperLimitChecker() throws Exception {
		upperlimitmaker.enterloginid("lastmile3");
		upperlimitmaker.enterpassword("password@1");
		upperlimitmaker.clickonlogin();
		upperlimitmaker.clickonMasterDefinitionChecker();
		upperlimitmaker.clickOnUpperLimitCheckerSubMenu();
		upperlimitmaker.verifyUpperLimitCheckerPage();

	}

	@Test(priority = 9)
	// calling
	// verify Upper Limit checker Page List After Modification has Done By Maker
	public void verifyUpperLimitcheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		// in Cheker page when Modification has done By Maker
		upperlimitmaker.verifyListOfUpperLimitIncheckerWhenModificationhasDoneByMaker();
		upperlimitmaker.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		upperlimitmaker.clickonsubmitbuttOnChackerPage();
		upperlimitmaker.toverifysuccessfulMessageOnCheckerPage();
	}

	@Test(priority = 10)
	// go To The Country Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheUpperLimitMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		upperlimitmaker.gotoMakerPagewhenCheckerhasApproved();
		upperlimitmaker = new UpperLimitMaker(driver);
		upperlimitmaker.enterloginid("lastmile1");
		upperlimitmaker.enterpassword("password@2");
		upperlimitmaker.clickonlogin();
		Thread.sleep(5000);
		upperlimitmaker.toverifyhomepage();
		Thread.sleep(5000);
		upperlimitmaker.clikonmasterdefinitionmakerMenu();
		upperlimitmaker.clickonUpperLimitMakerSubMenu();
		upperlimitmaker.toswitchFieldsareinmandatory();
		upperlimitmaker.clickOnviewButtoninMakerPage();
		upperlimitmaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		upperlimitmaker.verifyViewpageBySearchFieldWhenModifyAndApprovedDoneByChecker();
		// By Verify the particular Text With Column Values
		Thread.sleep(5000);
		upperlimitmaker.toVerifyTextInViewMakerPagewhenModified();

		Thread.sleep(5000);
		upperlimitmaker.verifySelectDropDonOnViewMakerPageWhenModifiedData();
	}

	@Test(priority = 11)
	// switch To window Modify View Page To ADD Payment Type MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToUpperLimitMakerPage() throws Exception {
		Thread.sleep(5000);
		upperlimitmaker.SwitchTheWindowFrom3ChildToParent();
		upperlimitmaker.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testloginToUpperLimitCheckerToVerifyCheckerViewPageWhenModifedTheUpperLimit() throws Throwable {
		upperlimitmaker.enterloginid("lastmile3");
		upperlimitmaker.enterpassword("password@1");
		upperlimitmaker.clickonlogin();
		upperlimitmaker.clickonMasterDefinitionChecker();
		upperlimitmaker.clickOnUpperLimitCheckerSubMenu();
		upperlimitmaker.verifyUpperLimitCheckerPage();
		upperlimitmaker.clickOnviewInChecker();
		driver.manage().window().maximize();
		upperlimitmaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		upperlimitmaker.verifyViewpageBySearchFieldWhenModifyAndApprovedDoneByChecker();
		upperlimitmaker.toVerifyTextInViewMakerPagewhenModified();

		upperlimitmaker.verifySelectDropDonOnViewMakerPageWhenModifiedData();
		// Thread.sleep(5000);
		upperlimitmaker.SwitchTheWindowFrom4ChildToParent();
		upperlimitmaker.clickOnlogoutCheckerButton();
	}

}
