package com.hybridFramework.PagesOfCorporateDefinitionMakerTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PagesOfCorporateDefinitionMaker.AddCorporatePurposeMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;


public class AddCorporatePurposeMakerTest extends TestBase {
	AddCorporatePurposeMaker corporatepurpose;

	private final Logger log = LoggerHelper.getLogger(AddCorporatePurposeMakerTest.class);

	@Test(priority = 1)
	public void testLoginToAddCorporatePurposeMaker() throws InterruptedException {
		log.info(AddCorporatePurposeMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		corporatepurpose = new AddCorporatePurposeMaker(driver);
		// Test_maker1,password@1,Test_maker1==password@1
		corporatepurpose.enterloginid("Test_maker1");
		corporatepurpose.enterpassword("password@1");
		corporatepurpose.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAddCorporatePurposeMaker() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		corporatepurpose.toverifyhomepage();
		corporatepurpose.clickonCorporateDefinitionMakerMenu();
		corporatepurpose.clickonAddCorporatePurposeMakerSubMenu();
		corporatepurpose.toswitchFieldsareinmandatory();
		corporatepurpose.CorporateIDFromDropDownByUsingStringArray();
		corporatepurpose.selectCountry();
		corporatepurpose.selectPurposeCodeDropDown();
		corporatepurpose.selectSTPandSTPFlg();
		corporatepurpose.selectisNameMatch();
		corporatepurpose.enterMaximumLimit("50000");
		corporatepurpose.selectisActivePaymentMapping();
		corporatepurpose.clickonsubmitInMakerpage();
		corporatepurpose.verifySuccessfulMessageOnMakerPage();
		corporatepurpose.clickOnLogOutButton();
	}

	@Test(priority = 3)
	public void loginToAddCorporatePurposeChecker() throws Exception {
		corporatepurpose.enterloginid("lastmile7");
		corporatepurpose.enterpassword("password@2");
		corporatepurpose.clickonlogin();
		// corporatepurpose.toverifyhomepage();
		corporatepurpose.clickonCorporateDefinitionCheckerMenu();
		corporatepurpose.clickOnAuthoriseCorporatePurposeMappingSubMenu();
		corporatepurpose.verifyCorporatePurposeCheckerPage();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListOnCorporatePurposeCheckerpage() throws Exception {
		//  Comment due to We have Change the Value of Corporate Id.
		corporatepurpose.verifyChekerPageByTextWhenAddedMaker();
		corporatepurpose.HandleTheDynamicVluesWithCheckboxWhenAdded();

	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePageOnCheckerPage() {
     corporatepurpose.clickonsubmitbuttonAndverifySuccesfullMessage();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerApprovedAddCorporatePurposeMaker() throws Exception {
		corporatepurpose.gotoMakerWhenCheckerHasApproved();
		// here we call the driver because the without can not Automate
		corporatepurpose = new AddCorporatePurposeMaker(driver);
		corporatepurpose.enterloginid("Test_maker1");
		corporatepurpose.enterpassword("password@1");
		corporatepurpose.clickonlogin();
		//Thread.sleep(5000);
		//corporatepurpose.toverifyhomepage();
		Thread.sleep(5000);
		corporatepurpose.clickonCorporateDefinitionMakerMenu();
		corporatepurpose.clickonAddCorporatePurposeMakerSubMenu();
		corporatepurpose.toswitchFieldsareinmandatory();
		corporatepurpose.viewinMakerPage();
		corporatepurpose.switchToNewWindow(1);
		// below is working but i have commented
		corporatepurpose.verifyViewpageBySearchField();
		corporatepurpose.VerifyViewPageByGetText();
		corporatepurpose.selectAllDropDownvaluesOneByOneOnViewPage();

	}

	// switch To Main window Add Corporate Purpose Modify Maker
	@Test(priority = 8)
	public void switchToMainwindowAndModifyTheData() {
		corporatepurpose.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		corporatepurpose.clicKOnModifyButtonAndverifyTheModifiedPage();
		corporatepurpose.selectCOrporateIDDropDownOnModifyPage();
		corporatepurpose.selectcountryCodeInModifyMakerPage();
		corporatepurpose.selectPurposeCodeDropDownInModifyPage();
		corporatepurpose.clickOnsubmitbutton();
		corporatepurpose.clickmodifysubmitbutton();
		corporatepurpose.verificationMessageInModifyMakerPage();

	}
// login To Corporate Purpose Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToCorporatePurposeChecker() throws Exception {
		corporatepurpose.enterloginid("lastmile7");
		corporatepurpose.enterpassword("password@2");

		corporatepurpose.clickonlogin();
		corporatepurpose.clickonCorporateDefinitionCheckerMenu();
		corporatepurpose.clickOnAuthoriseCorporatePurposeMappingSubMenu();
		corporatepurpose.verifyCorporatePurposeCheckerPage();

	}

	@Test(priority = 10)
	// verify Corporate Purpose checker Page List After Modification has
	// Done By Maker
	public void verifyCorporatePurposecheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		corporatepurpose.verifyCheckerPageModificationhasDoneByMaker();
		corporatepurpose.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		corporatepurpose.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	}

	@Test(priority = 11)
	// go To The Corporate Purpose Maker To Verify Checker Has Approved The
	// Modify Data Same
	public void goToThCorporatePurposeMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		corporatepurpose.gotoMakerWhenCheckerHasApproved();
		corporatepurpose = new AddCorporatePurposeMaker(driver);
		corporatepurpose.enterloginid("Test_maker1");
		corporatepurpose.enterpassword("password@1");
		corporatepurpose.clickonlogin();
		Thread.sleep(5000);
		corporatepurpose.toverifyhomepage();
		Thread.sleep(5000);
		corporatepurpose.clickonCorporateDefinitionMakerMenu();
		corporatepurpose.clickonAddCorporatePurposeMakerSubMenu();
		corporatepurpose.toswitchFieldsareinmandatory();
		corporatepurpose.viewinMakerPage();
		corporatepurpose.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		corporatepurpose.verifyViewpageBySearchFieldWhenModify();
		// By Verify the particular Text With Column Values
		corporatepurpose.toVerifyByGetTextInViewPageWhenModify();
		corporatepurpose.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToCorpoeatePurposreMakerPage() throws Exception {
		Thread.sleep(5000);
		corporatepurpose.SwitchTheWindowFrom3ChildToParent();
		corporatepurpose.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testToVerifyCheckerViewPageWhenModifedTheCorporatePurposeMaker() throws Throwable {
		Thread.sleep(3000);
		corporatepurpose.enterloginid("lastmile7");
		corporatepurpose.enterpassword("password@2");
		corporatepurpose.clickonlogin();
		corporatepurpose.clickonCorporateDefinitionCheckerMenu();
		corporatepurpose.clickOnAuthoriseCorporatePurposeMappingSubMenu();
		corporatepurpose.verifyCorporatePurposeCheckerPage();
		corporatepurpose.clickOnviewInChecker();
		driver.manage().window().maximize();
		corporatepurpose.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		corporatepurpose.verifyViewpageBySearchFieldWhenModify();
		corporatepurpose.toVerifyByGetTextInViewPageWhenModify();
		corporatepurpose.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		corporatepurpose.SwitchTheWindowFrom4ChildToParent();
		corporatepurpose.clickOnlogoutCheckerButton();
	}

}
