package com.hybridFramework.PagesOfCorporateDefinitionMakerTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PagesOfCorporateDefinitionMaker.AddCorporateCertificateDetails;
import com.hybridFramework.PagesOfCorporateDefinitionMaker.CorporateCountryLicenseMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddCorporateCertificateDetailsTest extends TestBase {
	AddCorporateCertificateDetails corporatecertificatesdetails;

	private final Logger log = LoggerHelper.getLogger(AddCorporateCertificateDetailsTest.class);

	@Test(priority = 1)
	public void testLoginToAddCorporateCertificateDetails() throws InterruptedException {
		log.info(AddCorporateCertificateDetailsTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		corporatecertificatesdetails = new AddCorporateCertificateDetails(driver);
		// Test_maker1,password@1,Test_maker1==password@1
		corporatecertificatesdetails.enterloginid("Test_maker1");
		corporatecertificatesdetails.enterpassword("password@1");
		corporatecertificatesdetails.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAddCorporateCertificateDetails() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		corporatecertificatesdetails.toverifyhomepage();
		corporatecertificatesdetails.clickonCorporateDefinitionMakerMenu();
		corporatecertificatesdetails.clickonCorporateCertificateDetailsMakerSubMenu();
		corporatecertificatesdetails.toswitchFieldsareinmandatory();
		corporatecertificatesdetails.verifyingCorporateIDFromDropDownByUsingStringArray();
		corporatecertificatesdetails.entercertificatePassword("abc@");
		Thread.sleep(3000);
		corporatecertificatesdetails.clickOnattachFile();
		corporatecertificatesdetails.switchToNewWindow(1);
		corporatecertificatesdetails.choosefilePathTxtBox("E:\\Screenshort\\CCAvenues.png");
		Thread.sleep(5000);
		corporatecertificatesdetails.clickOnUploadButton();
		Thread.sleep(5000);
		corporatecertificatesdetails.SwitchTheWindowFrom2ChildToParent();
		Thread.sleep(5000);
		corporatecertificatesdetails.toswitchFieldsareinmandatory();
		corporatecertificatesdetails.enterfileName("prime.cr");
		corporatecertificatesdetails.entercertificateSubject("");
		corporatecertificatesdetails.entercertificateissuer("");
		corporatecertificatesdetails.entercertificateSerialNo("");
		corporatecertificatesdetails.entercertificateThumbPrint("");
		corporatecertificatesdetails.selectcertificateexpiryDate();
		corporatecertificatesdetails.enteremailId("abc2@gmail.com");
		corporatecertificatesdetails.selectgracePeriod();
		corporatecertificatesdetails.selectisActiveCerificateDetails();
		corporatecertificatesdetails.clickonsubmitInMakerpage();
		corporatecertificatesdetails.verifySuccessfulMessageOnMakerPage();
		corporatecertificatesdetails.clickOnLogOutButton();
	}

	@Test(priority = 3)
	public void chekerlogin() throws Exception {
		//
		corporatecertificatesdetails.enterloginid("lastmile7");
		corporatecertificatesdetails.enterpassword("password@2");
		corporatecertificatesdetails.clickonlogin();
		// corporatecertificatesdetails.toverifyhomepage();
		corporatecertificatesdetails.clickonCorporateDefinitionCheckerMenu();
		corporatecertificatesdetails.clickOnAuthoriserCountryLicenseSubMenu();
		corporatecertificatesdetails.verifyEntityLicenseCountryCheckerPage();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListOnEntityLicenseCountryCheckerpage() throws Exception {
		// below is for array List
		corporatecertificatesdetails.verifyChekerPageByTextWhenAddedMaker();
		corporatecertificatesdetails.HandleTheDynamicVluesWithCheckbox();

	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {

		corporatecertificatesdetails.clickonsubmitbuttonAndverifySuccesfullMessage();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerCheckerApprovedCountrypage() throws Exception {
		corporatecertificatesdetails.gotoMakerCheckerApprovedCountry();
		// here we call the driver because the without can not Automate
		corporatecertificatesdetails = new AddCorporateCertificateDetails(driver);
		corporatecertificatesdetails.enterloginid("Test_maker1");
		corporatecertificatesdetails.enterpassword("password@1");
		corporatecertificatesdetails.clickonlogin();
		Thread.sleep(5000);
		corporatecertificatesdetails.toverifyhomepage();
		Thread.sleep(5000);
		corporatecertificatesdetails.clickonCorporateDefinitionMakerMenu();
		corporatecertificatesdetails.clickonCorporateCertificateDetailsMakerSubMenu();
		corporatecertificatesdetails.toswitchFieldsareinmandatory();
		corporatecertificatesdetails.viewinMakerPage();
		corporatecertificatesdetails.switchToNewWindow(1);
		// below is working but i have commented
		corporatecertificatesdetails.verifyViewpageBySearchField();
		corporatecertificatesdetails.VerifyViewPageByGetText();
		corporatecertificatesdetails.selectAllvaluesOneByOne();

	}

	// switch To Main window Country Modify Maker
	@Test(priority = 8)
	public void switchToMainwindow() {
		corporatecertificatesdetails.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		corporatecertificatesdetails.verifyTheModifiedPage();
		corporatecertificatesdetails.selectCOrporateIDDropDownOnModifyPage();
		corporatecertificatesdetails.selectcountryCodeInModifyMakerPage();
		corporatecertificatesdetails.clickOnsubmitbutton();
		corporatecertificatesdetails.clickmodifysubmitbutton();
		corporatecertificatesdetails.verificationMessageInModifyMakerPage();

	}
// login To Country Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToGroupCountryEntityTypeChecker() throws Exception {
		corporatecertificatesdetails.enterloginid("lastmile7");
		corporatecertificatesdetails.enterpassword("password@2");

		corporatecertificatesdetails.clickonlogin();
		corporatecertificatesdetails.clickonCorporateDefinitionCheckerMenu();
		corporatecertificatesdetails.clickOnAuthoriserCountryLicenseSubMenu();
		corporatecertificatesdetails.verifyEntityLicenseCountryCheckerPage();

	}

	@Test(priority = 10)
	// verify Corporate Country checker Page List After Modification has
	// Done By Maker
	public void verifyCorporateCountrycheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		corporatecertificatesdetails.verifyEntityLicenseCountryCheckerPageModificationhasDoneByMaker();
		corporatecertificatesdetails.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		corporatecertificatesdetails.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	}

	@Test(priority = 11)
	// go To The Corporate Country License Maker To Verify Checker Has Approved The Modify Data Same
	public void goToThCorporateCountryLicenseMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		corporatecertificatesdetails.gotoMakerCheckerApprovedCountry();
		corporatecertificatesdetails = new AddCorporateCertificateDetails(driver);
		corporatecertificatesdetails.enterloginid("Test_maker1");
		corporatecertificatesdetails.enterpassword("password@1");
		corporatecertificatesdetails.clickonlogin();
		Thread.sleep(5000);
		corporatecertificatesdetails.toverifyhomepage();
		Thread.sleep(5000);
		corporatecertificatesdetails.clickonCorporateDefinitionMakerMenu();
		corporatecertificatesdetails.clickonCorporateCertificateDetailsMakerSubMenu();
		corporatecertificatesdetails.toswitchFieldsareinmandatory();
		corporatecertificatesdetails.viewinMakerPage();
		corporatecertificatesdetails.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		corporatecertificatesdetails.verifyViewpageBySearchFieldWhenModifyThecorporateCountryLicenses();
		// By Verify the particular Text With Column Values
		corporatecertificatesdetails.toVerifyGetTextInViewPageWhenModify();
		corporatecertificatesdetails.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToCorpoeateCountryLicenseMakerPage() throws Exception {
		Thread.sleep(5000);
		corporatecertificatesdetails.SwitchTheWindowFrom3ChildToParent();
		corporatecertificatesdetails.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testToVerifyCheckerViewPageWhenModifedTheCorporateCountryLicense() throws Throwable {
		corporatecertificatesdetails.enterloginid("lastmile7");
		corporatecertificatesdetails.enterpassword("password@2");
		corporatecertificatesdetails.clickonlogin();
		corporatecertificatesdetails.clickonCorporateDefinitionCheckerMenu();
		corporatecertificatesdetails.clickOnAuthoriserCountryLicenseSubMenu();
		corporatecertificatesdetails.verifyEntityLicenseCountryCheckerPage();
		corporatecertificatesdetails.clickOnviewInChecker();
		driver.manage().window().maximize();
		corporatecertificatesdetails.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		corporatecertificatesdetails.verifyViewpageBySearchFieldWhenModifyThecorporateCountryLicenses();
		corporatecertificatesdetails.toVerifyGetTextInViewPageWhenModify();
		corporatecertificatesdetails.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		corporatecertificatesdetails.SwitchTheWindowFrom4ChildToParent();
		corporatecertificatesdetails.clickOnlogoutCheckerButton();
	}

}
