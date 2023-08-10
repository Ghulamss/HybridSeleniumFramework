package com.hybridFramework.PagesOfCorporateDefinitionMakerTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.hybridFramework.PagesOfCorporateDefinitionMaker.CorporateCountryLicenseMaker;
import com.hybridFramework.PagesOfCorporateDefinitionMaker.CorporatePaymentLimitsMaker;
import com.hybridFramework.PagesOfCorporateDefinitionMaker.CorporatePaymentMappingMaker;
import com.hybridFramework.PagesOfCorporateDefinitionMaker.CorporatePoolAccountDetailsMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class CorporatePaymentLimitsMakerTest extends TestBase {
	CorporatePaymentLimitsMaker corporatepaymentlimits;

	private final Logger log = LoggerHelper.getLogger(CorporatePaymentLimitsMakerTest.class);

	@Test(priority = 1)
	public void testLoginToCorporatePaymentLimitsMaker() throws InterruptedException {
		log.info(CorporatePaymentLimitsMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		corporatepaymentlimits = new CorporatePaymentLimitsMaker(driver);
		// lastmile8,password@1,lastmile8==password@1
		corporatepaymentlimits.enterloginid("lastmile8");
		corporatepaymentlimits.enterpassword("password@1");
		corporatepaymentlimits.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAddCorporatePaymentLimitsMaker() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		corporatepaymentlimits.toverifyhomepage();
		corporatepaymentlimits.clickonCorporateDefinitionMakerMenu();
		corporatepaymentlimits.clickonCorporatPaymentLimitsMakerSubMenu();
		corporatepaymentlimits.toswitchFieldsareinmandatory();
		corporatepaymentlimits.CorporateIDFromDropDownByUsingStringArray();
		corporatepaymentlimits.selectGroupCountry();
		corporatepaymentlimits.selectPaymentCodeDropDown();
		corporatepaymentlimits.enterDailymaxTxnLimit("150000");
		corporatepaymentlimits.enterPerTransactionMinmAmountLimit("20000");
		corporatepaymentlimits.enterPerTransactionMaximumAmountLimit("50000");
		corporatepaymentlimits.selectisActiveDailyPaymentLimits();
		corporatepaymentlimits.clickonsubmitInMakerpage();
		corporatepaymentlimits.verifySuccessfulMessageOnMakerPage();
		corporatepaymentlimits.clickOnLogOutButton();
	}

	@Test(priority = 3)
	public void loginToCorporatePaymentLimitsChecker() throws Exception {
		//
		corporatepaymentlimits.enterloginid("lastmile7");
		corporatepaymentlimits.enterpassword("password@2");
		corporatepaymentlimits.clickonlogin();
		// corporatepaymentlimits.toverifyhomepage();
		corporatepaymentlimits.clickonCorporateDefinitionCheckerMenu();
		corporatepaymentlimits.clickOnAuthoriseCorporatePaymentLimitsSubMenu();
		corporatepaymentlimits.verifyCorporatePaymentLimitsCheckerPage();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListOnCorporatePaymentLimitsCheckerpage() throws Exception {
		// Comment due to We have Change the Value of Corporate Id.
		corporatepaymentlimits.verifyChekerPageByTextWhenAddedMaker();
		corporatepaymentlimits.HandleTheDynamicVluesWithCheckboxWhenAdded();

	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {

		corporatepaymentlimits.clickonsubmitbuttonAndverifySuccesfullMessage();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerApprovedCorporatePaymentLimits() throws Exception {
		corporatepaymentlimits.gotoMakerWhenCheckerHasApproved();
		// here we call the driver because the without can not Automate
		corporatepaymentlimits = new CorporatePaymentLimitsMaker(driver);
		corporatepaymentlimits.enterloginid("lastmile8");
		corporatepaymentlimits.enterpassword("password@1");
		corporatepaymentlimits.clickonlogin();
		// Thread.sleep(5000);
		// corporatepaymentlimits.toverifyhomepage();
		Thread.sleep(5000);
		corporatepaymentlimits.clickonCorporateDefinitionMakerMenu();
		corporatepaymentlimits.clickonCorporatPaymentLimitsMakerSubMenu();
		corporatepaymentlimits.toswitchFieldsareinmandatory();
		corporatepaymentlimits.viewinMakerPage();
		corporatepaymentlimits.switchToNewWindow(1);
		// below is working but i have commented
		corporatepaymentlimits.verifyViewpageBySearchField();
		corporatepaymentlimits.VerifyViewPageByGetText();
		corporatepaymentlimits.selectAllDropDownvaluesOneByOneOnViewPage();

	}

	// switch To Main window Corporate Payment Limits Maker Modify Maker
	@Test(priority = 8)
	public void switchToMainwindowAndModifyIt() throws Exception {
		corporatepaymentlimits.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		corporatepaymentlimits.clickOnModifyButtonAndverifyTheModifiedPage();
		corporatepaymentlimits.selectCOrporateIDDropDownOnModifyPage();
		corporatepaymentlimits.selectcountryCodeInModifyMakerPage();
		corporatepaymentlimits.clickOnsubmitbutton();
		Thread.sleep(5000);
		corporatepaymentlimits.clickOnLinkOnModifyPageWhenModify();
		corporatepaymentlimits.clickmodifysubmitbutton();
		corporatepaymentlimits.verificationMessageInModifyMakerPage();

	}
// login To Corporate Payment Limits Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToCorporatePaymentLimitsChecker() throws Exception {
		corporatepaymentlimits.enterloginid("lastmile7");
		corporatepaymentlimits.enterpassword("password@2");

		corporatepaymentlimits.clickonlogin();
		corporatepaymentlimits.clickonCorporateDefinitionCheckerMenu();
		corporatepaymentlimits.clickOnAuthoriseCorporatePaymentLimitsSubMenu();
		corporatepaymentlimits.verifyCorporatePaymentLimitsCheckerPage();

	}

	@Test(priority = 10)
	// verify Corporate Payment Limits checker Page List After Modification has
	// Done By Maker
	public void verifyCorporatePaymentLimitscheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		corporatepaymentlimits.verifyCheckerPageModificationhasDoneByMaker();
		corporatepaymentlimits.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		corporatepaymentlimits.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	}

	@Test(priority = 11)
	// go To The Corporate Payment Limits Maker To Verify Checker Has Approved The
	// Modify Data Same
	public void goToThCorporatePaymentLimitsMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		corporatepaymentlimits.gotoMakerWhenCheckerHasApproved();
		corporatepaymentlimits = new CorporatePaymentLimitsMaker(driver);
		corporatepaymentlimits.enterloginid("lastmile8");
		corporatepaymentlimits.enterpassword("password@1");
		corporatepaymentlimits.clickonlogin();
		Thread.sleep(5000);
		corporatepaymentlimits.toverifyhomepage();
		Thread.sleep(5000);
		corporatepaymentlimits.clickonCorporateDefinitionMakerMenu();
		corporatepaymentlimits.clickonCorporatPaymentLimitsMakerSubMenu();
		corporatepaymentlimits.toswitchFieldsareinmandatory();
		corporatepaymentlimits.viewinMakerPage();
		corporatepaymentlimits.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		corporatepaymentlimits.verifyViewpageBySearchFieldWhenModify();
		// By Verify the particular Text With Column Values
		corporatepaymentlimits.toVerifyByGetTextInViewPageWhenModify();
		corporatepaymentlimits.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToCorpoeatePaymentLimitsMakerPage() throws Exception {
		Thread.sleep(5000);
		corporatepaymentlimits.SwitchTheWindowFrom3ChildToParent();
		corporatepaymentlimits.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testToVerifyCheckerViewPageWhenModifedTheCorporatePaymentLimits() throws Throwable {
		Thread.sleep(3000);
		corporatepaymentlimits.enterloginid("lastmile7");
		corporatepaymentlimits.enterpassword("password@2");
		corporatepaymentlimits.clickonlogin();
		corporatepaymentlimits.clickonCorporateDefinitionCheckerMenu();
		corporatepaymentlimits.clickOnAuthoriseCorporatePaymentLimitsSubMenu();
		corporatepaymentlimits.verifyCorporatePaymentLimitsCheckerPage();
		corporatepaymentlimits.clickOnviewInChecker();
		driver.manage().window().maximize();
		corporatepaymentlimits.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		corporatepaymentlimits.verifyViewpageBySearchFieldWhenModify();
		corporatepaymentlimits.toVerifyByGetTextInViewPageWhenModify();
		corporatepaymentlimits.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		corporatepaymentlimits.SwitchTheWindowFrom4ChildToParent();
		corporatepaymentlimits.clickOnlogoutCheckerButton();
	}

}
