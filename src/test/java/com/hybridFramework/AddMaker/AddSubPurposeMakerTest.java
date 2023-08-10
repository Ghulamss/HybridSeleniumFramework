package com.hybridFramework.AddMaker;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.AddSubPurposeMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddSubPurposeMakerTest extends TestBase {
	AddSubPurposeMaker addsubpurposemaker;

	private final Logger log = LoggerHelper.getLogger(AddSubPurposeMakerTest.class);

	@Test(priority = 1)
	public void testLoginToAddSubPurposeMaker() throws InterruptedException {
		log.info(AddSubPurposeMaker.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		addsubpurposemaker = new AddSubPurposeMaker(driver);
		addsubpurposemaker.enterloginid("lastmile6");
		addsubpurposemaker.enterpassword("password@1");
		addsubpurposemaker.clickonlogin();
	}

	@Test(priority = 2)
	public void testToAddSubPurposeMakerPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		addsubpurposemaker.toverifyhomepage();
		addsubpurposemaker.clikonmasterdefinitionmakerMenu();
		addsubpurposemaker.clickonAddSubPurposeMakerSubMenu();
		addsubpurposemaker.toswitchFieldsareinmandatory();
		addsubpurposemaker.selectcountryCodeOnAddSubPurposepage();
		addsubpurposemaker.selectPurposeCodeOnAddSubPurposepage();
		addsubpurposemaker.enterSubpurposeCode("DFA");
		addsubpurposemaker.enterSubpurposeDesc("EFSA");
		addsubpurposemaker.selectisActiveSubPurpose();
		addsubpurposemaker.clickonsubmitInMakerpage();
		addsubpurposemaker.verifySuccesfullMessage();
	}

	@Test(priority = 3)
	// Checker Page
	public void toTestSubPurposeCheckerLoginPageAndVerifyIt() throws Exception {
		addsubpurposemaker.enterloginid("lastmile3");
		addsubpurposemaker.enterpassword("password@1");
		addsubpurposemaker.clickonlogin();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// addsubpurposemaker.toverifyhomepage();
		Thread.sleep(4000);
		addsubpurposemaker.clickonMasterDefinitionChecker();
		Thread.sleep(4000);
		addsubpurposemaker.clickOnSubAuthoriserPurposeSubMenu();
		addsubpurposemaker.verifySubPurposeCheckerPages();

	}

	// in Checker page verify the list of Elements
	@Test(priority = 4)
	public void verifyAddcheckerListinAddSubPurposeCheckerpage() throws Exception {
		addsubpurposemaker.verifyAddcheckerListInCheckerpage();
		addsubpurposemaker.HandleTheDynamicVluesWithCheckbox();
	}

	// in Checker page
	@Test(priority = 5)
	// click on submit Button and verify Message in Checker page.
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {
		addsubpurposemaker.clickonsubmitbuttonOnCheckerPage();
		addsubpurposemaker.toverifysuccessfulMessageinCheckerPage();
	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerApprovedAddSubPurposeMaker() throws Exception {
		// click on log out checker Button .
		addsubpurposemaker.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
		// here we call the driver because the without can not Automate
		addsubpurposemaker = new AddSubPurposeMaker(driver);
		addsubpurposemaker.enterloginid("lastmile6");
		addsubpurposemaker.enterpassword("password@1");
		addsubpurposemaker.clickonlogin();
		Thread.sleep(5000);
		addsubpurposemaker.toverifyhomepage();
		Thread.sleep(5000);
		addsubpurposemaker.clikonmasterdefinitionmakerMenu();
		addsubpurposemaker.clickonAddSubPurposeMakerSubMenu();
		addsubpurposemaker.toswitchFieldsareinmandatory();
		addsubpurposemaker.clickOnviewButtoninMakerPage();
		addsubpurposemaker.switchToNewWindow(1);
		addsubpurposemaker.verifyViewpageBySearchField();
		addsubpurposemaker.multippleSelectVerifyTextInViewPage();
		// Thread.sleep(5000);
		addsubpurposemaker.selectAllvaluesOneByOne();
		// currencypage.switchToWindowByUsingIterator();
	}

	// switch To Main window Add Sub Purpose Maker Modify Maker
	// Switch the Child window (AddSubPurposeMaker view page ) To parent window(AddSubPurposeMaker Maker
	// page)
	@Test(priority = 7)
	public void switchToMainwindow() throws Exception {
		// switch view page to Maker page and click on Modify button.
		addsubpurposemaker.switch2();
		addsubpurposemaker.selectSubPurposeCodeInModifyMakerPageByUsingSplitAsPerAddingValue();
		// old code to select Sub Purpose value.
		// addsubpurposemaker.selectSubPurposeCodeInModifyPurposeMakerPage();
		// click on first Submit button
		addsubpurposemaker.clickOnsubmitbutton();
		// modify Submit Button
		Thread.sleep(5000);
		addsubpurposemaker.clickmodifysubmitbutton();
		Thread.sleep(5000);
		addsubpurposemaker.verificationMessageInModifyPaymentTypePage();

	}

     // login To Add Sub Purpose Checker if Modify the Same data 
	// go to the CHecker Page.and verify the checker page.
	@Test(priority = 8)
	public void testloginToAddSubPurposeChecker() throws Exception {
		addsubpurposemaker.enterloginid("lastmile3");
		addsubpurposemaker.enterpassword("password@1");
		addsubpurposemaker.clickonlogin();
		addsubpurposemaker.clickonMasterDefinitionChecker();
		addsubpurposemaker.clickOnSubAuthoriserPurposeSubMenu();
		addsubpurposemaker.verifySubPurposeCheckerPages();

	}

	@Test(priority = 9)
	// calling
	// verify Add Sub Purpose checker Page List After Modification has Done By Maker
	public void verifyAddSubPurposeCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		// in Cheker page when Modification has done By Maker
		addsubpurposemaker.verifyListonCheckerpageWhenModificationhasDoneByMaker();
		addsubpurposemaker.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		addsubpurposemaker.clickonsubmitbuttonOnCheckerPage();
		addsubpurposemaker.toverifysuccessfulMessageinCheckerPage();
	}

	@Test(priority = 10)
	// go To The Add Sub Purpose Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheAddSubPurposeMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		addsubpurposemaker.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
		addsubpurposemaker = new AddSubPurposeMaker(driver);
		addsubpurposemaker.enterloginid("lastmile6");
		addsubpurposemaker.enterpassword("password@1");
		addsubpurposemaker.clickonlogin();
		Thread.sleep(5000);
		addsubpurposemaker.toverifyhomepage();
		Thread.sleep(5000);
		addsubpurposemaker.clikonmasterdefinitionmakerMenu();
		addsubpurposemaker.clickonAddSubPurposeMakerSubMenu();
		addsubpurposemaker.toswitchFieldsareinmandatory();
		addsubpurposemaker.clickOnviewButtoninMakerPage();
		addsubpurposemaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		addsubpurposemaker.verifyViewpagesBySearchFieldWhenModifyTAndApprovedDoneByChecker();
		// By Verify the particular Text With Column Values
		Thread.sleep(5000);
		addsubpurposemaker.toVerifyByTextInViewMakerPagewhenModified();
		Thread.sleep(5000);
		addsubpurposemaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 11)
	// switch To window Modify View Page To Add Sub Purpose Maker Page
	// and LogOut
	public void switchTowindowModifyViewPageToAddSubPurposeMakerPage() throws Exception {
		Thread.sleep(5000);
		addsubpurposemaker.SwitchTheWindowFrom3ChildToParent();
		addsubpurposemaker.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 12)
	public void testloginToSubPurposeCheckerToVerifyCheckerViewPageWhenModifedTheAddSubPurposeMaker() throws Throwable {
		addsubpurposemaker.enterloginid("lastmile3");
		addsubpurposemaker.enterpassword("password@1");
		addsubpurposemaker.clickonlogin();
		addsubpurposemaker.clickonMasterDefinitionChecker();
		addsubpurposemaker.clickOnSubAuthoriserPurposeSubMenu();
		addsubpurposemaker.verifySubPurposeCheckerPages();
		addsubpurposemaker.clickOnviewInChecker();
		driver.manage().window().maximize();
		addsubpurposemaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		addsubpurposemaker.verifyViewpagesBySearchFieldWhenModifyTAndApprovedDoneByChecker();
		addsubpurposemaker.toVerifyByTextInViewMakerPagewhenModified();
		addsubpurposemaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		addsubpurposemaker.SwitchTheWindowFrom4ChildToParent();
		addsubpurposemaker.clickOnlogoutCheckerButton();
	}

}
