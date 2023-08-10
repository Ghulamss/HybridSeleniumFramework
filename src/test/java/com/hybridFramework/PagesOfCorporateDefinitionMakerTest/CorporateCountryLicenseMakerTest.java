package com.hybridFramework.PagesOfCorporateDefinitionMakerTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.hybridFramework.PagesOfCorporateDefinitionMaker.CorporateCountryLicenseMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class CorporateCountryLicenseMakerTest extends TestBase {
	CorporateCountryLicenseMaker countrylicensemaker;

	private final Logger log = LoggerHelper.getLogger(CorporateCountryLicenseMakerTest.class);

	@Test(priority = 1)
	public void testLoginToCorporateCountryLicenseMaker() throws InterruptedException {
		log.info(CorporateCountryLicenseMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		countrylicensemaker = new CorporateCountryLicenseMaker(driver);
		// Test_maker1,password@1,Test_maker1==password@1
		countrylicensemaker.enterloginid("Test_maker1");
		countrylicensemaker.enterpassword("password@1");
		countrylicensemaker.clickonlogin();

	}

	@Test(priority = 2)
	public void testToCorporateCountryLicenseMakerPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		countrylicensemaker.toverifyhomepage();
		countrylicensemaker.clickonCorporateDefinitionMakerMenu();
		countrylicensemaker.clickonCorporateCountryLicenseMakerSubMenu();
		countrylicensemaker.toswitchFieldsareinmandatory();
		countrylicensemaker.verifyingCorporateIDFromDropDownByUsingStringArray();
		// Thread.sleep(5000);
		countrylicensemaker.selectGroupCountry();
		// Thread.sleep(5000);
		countrylicensemaker.selectlicenseTypeDropDown();
		Thread.sleep(3000);
		countrylicensemaker.clickOnattachFile();
		countrylicensemaker.switchToNewWindow(1);
		countrylicensemaker.choosefilePathTxtBox("E:\\Screenshort\\CCAvenues.png");
		Thread.sleep(5000);
		countrylicensemaker.clickOnUploadButton();
		Thread.sleep(5000);
		countrylicensemaker.SwitchTheWindowFrom2ChildToParent();
		Thread.sleep(5000);
		countrylicensemaker.toswitchFieldsareinmandatory();
		countrylicensemaker.enteragreementLabel("agree");
		countrylicensemaker.selectDateOfIssue();
		countrylicensemaker.selectDateOfExpiry();
		countrylicensemaker.selectAlertDate();
		countrylicensemaker.selectAlertFrequency();
		countrylicensemaker.enteralertMail("ave@gmail.com");
		countrylicensemaker.entergracePeriodInDays("1");
		countrylicensemaker.selectisActiveEntityLicenseCountry();
		countrylicensemaker.clickonsubmitInMakerpage();
		countrylicensemaker.verifySuccessfulMessageOnMakerPage();
		countrylicensemaker.clickOnLogOutButton();
	}

	@Test(priority = 3)
	public void loginToCorporateCountryLicenseChecker() throws Exception {
		//
		countrylicensemaker.enterloginid("lastmile7");
		countrylicensemaker.enterpassword("password@2");
		countrylicensemaker.clickonlogin();
		// countrylicensemaker.toverifyhomepage();
		countrylicensemaker.clickonCorporateDefinitionCheckerMenu();
		countrylicensemaker.clickOnAuthoriserCountryLicenseSubMenu();
		countrylicensemaker.verifyEntityLicenseCountryCheckerPage();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListOnEntityLicenseCountryCheckerpage() throws Exception {
		// below is for array List
		countrylicensemaker.verifyChekerPageByTextWhenAddedMaker();
		countrylicensemaker.HandleTheDynamicVluesWithCheckbox();

	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {

		countrylicensemaker.clickonsubmitbuttonAndverifySuccesfullMessage();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerHasApprovedCorporateCountryLicenseMaker() throws Exception {
		countrylicensemaker.gotoMakerCheckerApprovedCountry();
		// here we call the driver because the without can not Automate
		countrylicensemaker = new CorporateCountryLicenseMaker(driver);
		countrylicensemaker.enterloginid("Test_maker1");
		countrylicensemaker.enterpassword("password@1");
		countrylicensemaker.clickonlogin();
		Thread.sleep(5000);
		countrylicensemaker.toverifyhomepage();
		Thread.sleep(5000);
		countrylicensemaker.clickonCorporateDefinitionMakerMenu();
		countrylicensemaker.clickonCorporateCountryLicenseMakerSubMenu();
		countrylicensemaker.toswitchFieldsareinmandatory();
		countrylicensemaker.viewinMakerPage();
		countrylicensemaker.switchToNewWindow(1);
		// below is working but i have commented
		countrylicensemaker.verifyViewpageBySearchField();
		countrylicensemaker.VerifyViewPageByGetText();
		countrylicensemaker.selectAllvaluesOneByOne();

	}

	// switch To Main window Country Modify Maker
	@Test(priority = 8)
	public void switchToMainwindow() {
		countrylicensemaker.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		countrylicensemaker.verifyTheModifiedPage();
		countrylicensemaker.selectCOrporateIDDropDownOnModifyPage();
		countrylicensemaker.selectcountryCodeInModifyMakerPage();
		countrylicensemaker.clickOnsubmitbutton();
		countrylicensemaker.clickmodifysubmitbutton();
		countrylicensemaker.verificationMessageInModifyMakerPage();

	}
// login To Country Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToCorporateCountryLicenseCheckerWhenModified() throws Exception {
		countrylicensemaker.enterloginid("lastmile7");
		countrylicensemaker.enterpassword("password@2");

		countrylicensemaker.clickonlogin();
		countrylicensemaker.clickonCorporateDefinitionCheckerMenu();
		countrylicensemaker.clickOnAuthoriserCountryLicenseSubMenu();
		countrylicensemaker.verifyEntityLicenseCountryCheckerPage();

	}

	@Test(priority = 10)
	// verify Corporate Country License checker Page List After Modification has
	// Done By Maker
	public void verifyCorporateCountryLicenseCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		countrylicensemaker.verifyEntityLicenseCountryCheckerPageModificationhasDoneByMaker();
		countrylicensemaker.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		countrylicensemaker.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	}

	@Test(priority = 11)
	// go To The Corporate Country License Maker To Verify Checker Has Approved The
	// Modify Data Same
	public void goToThCorporateCountryLicenseMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		countrylicensemaker.gotoMakerCheckerApprovedCountry();
		countrylicensemaker = new CorporateCountryLicenseMaker(driver);
		countrylicensemaker.enterloginid("Test_maker1");
		countrylicensemaker.enterpassword("password@1");
		countrylicensemaker.clickonlogin();
		Thread.sleep(5000);
		countrylicensemaker.toverifyhomepage();
		Thread.sleep(5000);
		countrylicensemaker.clickonCorporateDefinitionMakerMenu();
		countrylicensemaker.clickonCorporateCountryLicenseMakerSubMenu();
		countrylicensemaker.toswitchFieldsareinmandatory();
		countrylicensemaker.viewinMakerPage();
		countrylicensemaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		countrylicensemaker.verifyViewpageBySearchFieldWhenModifyThecorporateCountryLicenses();
		// By Verify the particular Text With Column Values
		countrylicensemaker.toVerifyGetTextInViewPageWhenModify();
		countrylicensemaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToCorpoeateCountryLicenseMakerPage() throws Exception {
		Thread.sleep(5000);
		countrylicensemaker.SwitchTheWindowFrom3ChildToParent();
		countrylicensemaker.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testToVerifyCheckerViewPageWhenModifedTheCorporateCountryLicense() throws Throwable {
		countrylicensemaker.enterloginid("lastmile7");
		countrylicensemaker.enterpassword("password@2");
		countrylicensemaker.clickonlogin();
		countrylicensemaker.clickonCorporateDefinitionCheckerMenu();
		countrylicensemaker.clickOnAuthoriserCountryLicenseSubMenu();
		countrylicensemaker.verifyEntityLicenseCountryCheckerPage();
		countrylicensemaker.clickOnviewInChecker();
		driver.manage().window().maximize();
		countrylicensemaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		countrylicensemaker.verifyViewpageBySearchFieldWhenModifyThecorporateCountryLicenses();
		countrylicensemaker.toVerifyGetTextInViewPageWhenModify();
		countrylicensemaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		countrylicensemaker.SwitchTheWindowFrom4ChildToParent();
		countrylicensemaker.clickOnlogoutCheckerButton();
	}

}
