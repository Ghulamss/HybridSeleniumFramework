package com.hybridFramework.AddMaker;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.AddPurposeMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddPurposeMakerTest extends TestBase {
	AddPurposeMaker addpurposemaker;

	private final Logger log = LoggerHelper.getLogger(AddPurposeMakerTest.class);

	@Test(priority = 1)
	public void testLoginToApplicationAddPurposeMaker() throws InterruptedException {
		log.info(AddPurposeMaker.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		addpurposemaker = new AddPurposeMaker(driver);
		addpurposemaker.enterloginid("lastmile8");
		addpurposemaker.enterpassword("password@1");
		addpurposemaker.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAddPurposeMakerPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		addpurposemaker.toverifyhomepage();
		addpurposemaker.clikonmasterdefinitionmakerMenu();
		addpurposemaker.clickonAddPurposeMakerSubMenu();
		addpurposemaker.toswitchFieldsareinmandatory();
		addpurposemaker.selectcountryCodeOnAddPurposepage();
		addpurposemaker.enterpurposeCode("CDL");
		addpurposemaker.enterpurposeDesc("EFL");
		addpurposemaker.selectpurposeType();
		addpurposemaker.selectisActivePurpose();
		addpurposemaker.clickonsubmitInMakerpage();
		addpurposemaker.verifySuccesfullMessage();
	}

	@Test(priority = 3)
	// Checker Page..
	public void purposeChekerlogin() throws Exception {
		addpurposemaker.enterloginid("lastmile7");
		addpurposemaker.enterpassword("password@2");
		addpurposemaker.clickonlogin();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// addpurposemaker.toverifyhomepage();
		Thread.sleep(4000);
		addpurposemaker.clickonMasterDefinitionChecker();
		Thread.sleep(4000);
		addpurposemaker.clickOnAuthoriserPurposeSubMenu();
		addpurposemaker.verifyPurposeCheckerPages();
	}

	// in Checker page verify the list of Elements
	@Test(priority = 4)
	public void verifyAddcheckerListOnPurposeCheckerpage() throws Exception {
		addpurposemaker.verifyAddcheckerListInCheckerpage();
		addpurposemaker.HandleTheDynamicVluesWithCheckbox();

	}

	// in Checker page
	@Test(priority = 5)
	// click on submit Button and verify Message in Checker page.
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {
		addpurposemaker.clickonsubmitbuttonOnCheckerPage();
		addpurposemaker.toverifysuccessfulMessageinCheckerPage();
	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerPageWhenCheckerApprovedPurposepage() throws Exception {
		// click on log out checker Button .
		addpurposemaker.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
		// here we call the driver because the without can not Automate
		addpurposemaker = new AddPurposeMaker(driver);
		addpurposemaker.enterloginid("lastmile8");
		addpurposemaker.enterpassword("password@1");
		addpurposemaker.clickonlogin();
		Thread.sleep(5000);
		addpurposemaker.toverifyhomepage();
		Thread.sleep(5000);
		addpurposemaker.clikonmasterdefinitionmakerMenu();
		addpurposemaker.clickonAddPurposeMakerSubMenu();
		addpurposemaker.toswitchFieldsareinmandatory();
		addpurposemaker.clickOnviewButtoninMakerPage();
		addpurposemaker.switchToNewWindow(1);
		addpurposemaker.verifyViewpagesBySearchField();
		addpurposemaker.multippleSelectVerifyTextInViewPage();
		addpurposemaker.selectAllvaluesOneByOne();
		// currencypage.switchToWindowByUsingIterator();
	}

	// this one is not working
	@Test(priority = 7)
	public void switchToWindowByUsingIterator() throws Exception {
		// currencypage.switchToWindowByUsingIterator();

	}

	// switch To Main window Country Modify Maker
	// Switch the Child window (AddPurposeMaker view page ) To parent
	// window(AddPurposeMaker Maker page)
	@Test(priority = 8)
	public void switchToMainwindow() throws Exception {
		// switch view page to Maker page and click on Modify button.
		addpurposemaker.switch2();
		addpurposemaker.selectPurposeCodeInModifyMakerPageByUsingSplitAsPerAddingValue();
		// old code
		// addpurposemaker.selectPurposeCodeInModifyPurposeMakerPage();
		// click on first Submit button
		addpurposemaker.clickOnsubmitbutton();
		// modify Submit Button
		Thread.sleep(5000);
		addpurposemaker.clickmodifysubmitbutton();
		Thread.sleep(5000);
		addpurposemaker.verificationMessageInModifyPaymentTypePage();

	}

// login To payment type Checker if Modify the Same data 
	// go to the CHecker Page.and verify the checker page.
	@Test(priority = 9)
	public void testloginToCountryChecker() throws Exception {
		addpurposemaker.enterloginid("lastmile7");
		addpurposemaker.enterpassword("password@2");
		addpurposemaker.clickonlogin();
		addpurposemaker.clickonMasterDefinitionChecker();
		addpurposemaker.clickOnAuthoriserPurposeSubMenu();
		addpurposemaker.verifyPurposeCheckerPages();

	}

	@Test(priority = 10)
	// calling
	// verify Payment Type checker Page List After Modification has Done By Maker
	public void verifyCountrycheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		// in Cheker page when Modification has done By Maker
		addpurposemaker.verifyListonCheckerpageWhenModificationhasDoneByMaker();
		// After Modification Column Value has changed. This is Bug on it.
		addpurposemaker.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		addpurposemaker.clickonsubmitbuttonOnCheckerPage();
		addpurposemaker.toverifysuccessfulMessageinCheckerPage();
	}

	@Test(priority = 11)
	// go To The Purpose Maker To Verify Checker Has Approved The Modify Data Same
	public void goToThePurposeMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		addpurposemaker.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
		addpurposemaker = new AddPurposeMaker(driver);
		addpurposemaker.enterloginid("lastmile8");
		addpurposemaker.enterpassword("password@1");
		addpurposemaker.clickonlogin();
		Thread.sleep(5000);
		addpurposemaker.toverifyhomepage();
		Thread.sleep(5000);
		addpurposemaker.clikonmasterdefinitionmakerMenu();
		addpurposemaker.clickonAddPurposeMakerSubMenu();
		addpurposemaker.toswitchFieldsareinmandatory();
		addpurposemaker.clickOnviewButtoninMakerPage();
		addpurposemaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		addpurposemaker.verifyViewpagesBySearchFieldWhenModifyAndApprovedDoneByChecker();
		// By Verify the particular Text With Column Values
		Thread.sleep(5000);
		addpurposemaker.toVerifyByTextInViewMakerPagewhenModified();
		Thread.sleep(5000);
		addpurposemaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To ADD Payment Type MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToPaymentTypePage() throws Exception {
		Thread.sleep(5000);
		addpurposemaker.SwitchTheWindowFrom3ChildToParent();
		addpurposemaker.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testloginToPurposeCheckerToVerifyCheckerViewPageWhenModifedThePurpose() throws Throwable {
		addpurposemaker.enterloginid("lastmile7");
		addpurposemaker.enterpassword("password@2");
		addpurposemaker.clickonlogin();
		addpurposemaker.clickonMasterDefinitionChecker();
		addpurposemaker.clickOnAuthoriserPurposeSubMenu();
		addpurposemaker.verifyPurposeCheckerPages();
		addpurposemaker.clickOnviewInChecker();
		driver.manage().window().maximize();
		addpurposemaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
        addpurposemaker.verifyViewpagesBySearchFieldWhenModifyAndApprovedDoneByChecker();
		addpurposemaker.toVerifyByTextInViewMakerPagewhenModified();
        addpurposemaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
        addpurposemaker.SwitchTheWindowFrom4ChildToParent();
		addpurposemaker.clickOnlogoutCheckerButton();
	}

}
