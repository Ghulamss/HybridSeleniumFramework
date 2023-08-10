package com.hybridFramework.PagesOfCorporateDefinitionMakerTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.hybridFramework.PagesOfCorporateDefinitionMaker.CorporateCountryLicenseMaker;
import com.hybridFramework.PagesOfCorporateDefinitionMaker.CorporatePoolAccountDetailsMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class CorporatePoolAccountDetailsMakerTest extends TestBase {
	CorporatePoolAccountDetailsMaker poolaccountdetails;

	private final Logger log = LoggerHelper.getLogger(CorporatePoolAccountDetailsMakerTest.class);

	@Test(priority = 1)
	public void testLoginToCorporatePoolAccountDetailsMaker() throws InterruptedException {
		log.info(CorporatePoolAccountDetailsMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		poolaccountdetails = new CorporatePoolAccountDetailsMaker(driver);
		// Test_maker1,password@1,Test_maker1==password@1
		poolaccountdetails.enterloginid("Test_maker1");
		poolaccountdetails.enterpassword("password@1");
		poolaccountdetails.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAddCorporatePoolAccountDetailsMaker() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		poolaccountdetails.toverifyhomepage();
		poolaccountdetails.clickonCorporateDefinitionMakerMenu();
		poolaccountdetails.clickonCorporatePoolAccountDetailsMakerSubMenu();
		poolaccountdetails.toswitchFieldsareinmandatory();
		poolaccountdetails.CorporateIDFromDropDownByUsingStringArray();
		// Thread.sleep(5000);
		poolaccountdetails.selectGroupCountry();
		Thread.sleep(5000);
		poolaccountdetails.enterpoolAccHolderName("GhulaSs");
		poolaccountdetails.enterdebitaccountnumber("98989810011");
		poolaccountdetails.selectCurrencyDropDown();
		poolaccountdetails.selectdebitAccountTypeDropDown();
		poolaccountdetails.enterdebitcorresspondentbankroutingno("AOTAKAABC");
		poolaccountdetails.enterdebitcorresspondentbankBranch("Mumbai1");
		poolaccountdetails.entercommissionAccNumber("12345981010");
		poolaccountdetails.selectisActiveEntityLicenseCountry();
		poolaccountdetails.clickonsubmitInMakerpage();
		poolaccountdetails.verifySuccessfulMessageOnMakerPage();
		poolaccountdetails.clickOnLogOutButton();
	}

	@Test(priority = 3)
	public void loginToCorporatePoolAccountDetailsChecker() throws Exception {
		//
		poolaccountdetails.enterloginid("lastmile7");
		poolaccountdetails.enterpassword("password@2");
		poolaccountdetails.clickonlogin();
		// poolaccountdetails.toverifyhomepage();
		poolaccountdetails.clickonCorporateDefinitionCheckerMenu();
		poolaccountdetails.clickOnAuthoriserCorporatePoolAccountDetailsSubMenu();
		poolaccountdetails.verifyCorporateAccountDetailsCheckerPage();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListOnCorporatePoolAccountDetailsPage() throws Exception {
		// below is for array List
		poolaccountdetails.verifyChekerPageByTextWhenAddedMaker();
		poolaccountdetails.HandleTheDynamicVluesWithCheckboxWhenAdded();

	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {

		poolaccountdetails.clickonsubmitbuttonAndverifySuccesfullMessage();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerHasApprovedCorporatePoolAccountDetailsMaker() throws Exception {
		poolaccountdetails.gotoMakerWhenCheckerHasApproved();
		// here we call the driver because the without can not Automate
		poolaccountdetails = new CorporatePoolAccountDetailsMaker(driver);
		poolaccountdetails.enterloginid("Test_maker1");
		poolaccountdetails.enterpassword("password@1");
		poolaccountdetails.clickonlogin();
		Thread.sleep(5000);
		poolaccountdetails.toverifyhomepage();
		Thread.sleep(5000);
		poolaccountdetails.clickonCorporateDefinitionMakerMenu();
		poolaccountdetails.clickonCorporatePoolAccountDetailsMakerSubMenu();
		poolaccountdetails.toswitchFieldsareinmandatory();
		poolaccountdetails.viewinMakerPage();
		poolaccountdetails.switchToNewWindow(1);
		// below is working but i have commented
		poolaccountdetails.verifyViewpageBySearchField();
		poolaccountdetails.VerifyViewPageByGetText();
		poolaccountdetails.selectAllDropDownvaluesOneByOneOnViewPage();

	}

	// switch To Main window Country Modify Maker
	@Test(priority = 8)
	public void switchToMainwindowAndModifyTheData() {
		poolaccountdetails.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		poolaccountdetails.verifyTheModifiedPage();
		poolaccountdetails.selectCOrporateIDDropDownOnModifyPage();
		poolaccountdetails.selectcountryCodeInModifyMakerPage();
		poolaccountdetails.selectcurrencyDropDownInModifyPage();
		poolaccountdetails.clickOnsubmitbutton();
		poolaccountdetails.clickmodifysubmitbutton();
		poolaccountdetails.verificationMessageInModifyMakerPage();

	}
// login To Corporate Pool Account Details Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToCorporatePoolAccountDetailsChecker() throws Exception {
		poolaccountdetails.enterloginid("lastmile7");
		poolaccountdetails.enterpassword("password@2");

		poolaccountdetails.clickonlogin();
		poolaccountdetails.clickonCorporateDefinitionCheckerMenu();
		poolaccountdetails.clickOnAuthoriserCorporatePoolAccountDetailsSubMenu();
		poolaccountdetails.verifyCorporateAccountDetailsCheckerPage();

	}

	@Test(priority = 10)
	// verify Corporate Country checker Page List After Modification has
	// Done By Maker
	public void verifyCorporatePoolAccountcheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		poolaccountdetails.verifyCheckerPageModificationhasDoneByMaker();
		poolaccountdetails.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		poolaccountdetails.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	}

	@Test(priority = 11)
	// go To The Corporate Country License Maker To Verify Checker Has Approved The
	// Modify Data Same
	public void goToThCorporatePoolAccountDetailsMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		poolaccountdetails.gotoMakerWhenCheckerHasApproved();
		poolaccountdetails = new CorporatePoolAccountDetailsMaker(driver);
		poolaccountdetails.enterloginid("Test_maker1");
		poolaccountdetails.enterpassword("password@1");
		poolaccountdetails.clickonlogin();
		Thread.sleep(5000);
		poolaccountdetails.toverifyhomepage();
		Thread.sleep(5000);
		poolaccountdetails.clickonCorporateDefinitionMakerMenu();
		poolaccountdetails.clickonCorporatePoolAccountDetailsMakerSubMenu();
		poolaccountdetails.toswitchFieldsareinmandatory();
		poolaccountdetails.viewinMakerPage();
		poolaccountdetails.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		poolaccountdetails.verifyViewpageBySearchFieldWhenModifyThecorporatePoolAccountDetails();
		// By Verify the particular Text With Column Values
		poolaccountdetails.toVerifyByGetTextInViewPageWhenModify();
		poolaccountdetails.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToCorpoeatePoolAccountDetailsMakerPage() throws Exception {
		Thread.sleep(5000);
		poolaccountdetails.SwitchTheWindowFrom3ChildToParent();
		poolaccountdetails.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testToVerifyCheckerViewPageWhenModifedTheCorporatePoolAccountDetails() throws Throwable {
		poolaccountdetails.enterloginid("lastmile7");
		poolaccountdetails.enterpassword("password@2");
		poolaccountdetails.clickonlogin();
		poolaccountdetails.clickonCorporateDefinitionCheckerMenu();
		poolaccountdetails.clickOnAuthoriserCorporatePoolAccountDetailsSubMenu();
		poolaccountdetails.verifyCorporateAccountDetailsCheckerPage();
		poolaccountdetails.clickOnviewInChecker();
		driver.manage().window().maximize();
		poolaccountdetails.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		poolaccountdetails.verifyViewpageBySearchFieldWhenModifyThecorporatePoolAccountDetails();
		poolaccountdetails.toVerifyByGetTextInViewPageWhenModify();
		poolaccountdetails.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		poolaccountdetails.SwitchTheWindowFrom4ChildToParent();
		poolaccountdetails.clickOnlogoutCheckerButton();
	}

}
