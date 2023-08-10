package com.hybridFramework.PagesOfCorporateDefinitionMakerTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.hybridFramework.PagesOfCorporateDefinitionMaker.CorporateDailyLimitMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class CorporateDailyLimitMakerTest extends TestBase {
	CorporateDailyLimitMaker corporatedailylimit;

	private final Logger log = LoggerHelper.getLogger(CorporateDailyLimitMakerTest.class);

	@Test(priority = 1)
	public void testLoginToCorporateDailyLimitMaker() throws InterruptedException {
		log.info(CorporateDailyLimitMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		corporatedailylimit = new CorporateDailyLimitMaker(driver);
		// lastmile8,password@1,lastmile8==password@1
		corporatedailylimit.enterloginid("lastmile8");
		corporatedailylimit.enterpassword("password@1");
		corporatedailylimit.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAddCorporateDailyLimitMaker() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		corporatedailylimit.toverifyhomepage();
		corporatedailylimit.clickonCorporateDefinitionMakerMenu();
		corporatedailylimit.clickonCorporateDailyLimitMakerSubMenu();
		corporatedailylimit.toswitchFieldsareinmandatory();
		corporatedailylimit.CorporateIDFromDropDownByUsingStringArray();
		// Thread.sleep(5000);
		corporatedailylimit.selectGroupCountry();
		corporatedailylimit.entermaximumTxnLimit("500000");
		corporatedailylimit.selectisActiveDailyLimitMaker();
		corporatedailylimit.clickonsubmitInMakerpage();
		corporatedailylimit.verifySuccessfulMessageOnMakerPage();
		corporatedailylimit.clickOnLogOutButton();
	}

	@Test(priority = 3)
	public void loginToCorporateDailyLimitChecker() throws Exception {
		//
		corporatedailylimit.enterloginid("lastmile7");
		corporatedailylimit.enterpassword("password@2");
		corporatedailylimit.clickonlogin();
		// corporatedailylimit.toverifyhomepage();
		corporatedailylimit.clickonCorporateDefinitionCheckerMenu();
		corporatedailylimit.clickOnAuthoriserCorporateDailyLimitSubMenu();
		corporatedailylimit.verifyCorporateDailyLimitCheckerPage();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListOnCorporateDailyLimitCheckerpage() throws Exception {
		//  Comment due to We have Change the Value of Corporate Id.
		corporatedailylimit.verifyChekerPageByTextWhenAddedMaker();
		corporatedailylimit.HandleTheDynamicVluesWithCheckboxWhenAdded();

	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {

		corporatedailylimit.clickonsubmitbuttonAndverifySuccesfullMessage();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerHasApprovedCorporateDailyLimitMaker() throws Exception {
		corporatedailylimit.gotoMakerWhenCheckerHasApproved();
		// here we call the driver because the without can not Automate
		corporatedailylimit = new CorporateDailyLimitMaker(driver);
		corporatedailylimit.enterloginid("lastmile8");
		corporatedailylimit.enterpassword("password@1");
		corporatedailylimit.clickonlogin();
		//Thread.sleep(5000);
		//corporatedailylimit.toverifyhomepage();
		Thread.sleep(5000);
		corporatedailylimit.clickonCorporateDefinitionMakerMenu();
		corporatedailylimit.clickonCorporateDailyLimitMakerSubMenu();
		corporatedailylimit.toswitchFieldsareinmandatory();
		corporatedailylimit.viewinMakerPage();
		corporatedailylimit.switchToNewWindow(1);
		// below is working but i have commented
		corporatedailylimit.verifyViewpageBySearchField();
		corporatedailylimit.VerifyViewPageByGetText();
		corporatedailylimit.selectAllDropDownvaluesOneByOneOnViewPage();

	}

	// switch To Main window Corporate Daily Limit Modify Maker
	@Test(priority = 8)
	public void switchToMainwindowAndModifyCorporateDailyLimitMaker() {
		corporatedailylimit.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		corporatedailylimit.clickOnModifyButtonAndverifyTheModifiedPage();
		corporatedailylimit.selectCOrporateIDDropDownOnModifyPage();
		corporatedailylimit.selectcountryCodeInModifyMakerPage();
		corporatedailylimit.clickOnsubmitbutton();
		corporatedailylimit.clickmodifysubmitbutton();
		corporatedailylimit.verificationMessageInModifyMakerPage();

	}
// login To Corporate Daily Limit Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToCorporateDailyLimitCheckerWhenModify() throws Exception {
		corporatedailylimit.enterloginid("lastmile7");
		corporatedailylimit.enterpassword("password@2");

		corporatedailylimit.clickonlogin();
		corporatedailylimit.clickonCorporateDefinitionCheckerMenu();
		corporatedailylimit.clickOnAuthoriserCorporateDailyLimitSubMenu();
		corporatedailylimit.verifyCorporateDailyLimitCheckerPage();

	}

	@Test(priority = 10)
	// verify Corporate Daily Limit checker Page List After Modification has
	// Done By Maker
	public void verifyCorporateDailyLimitCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		corporatedailylimit.verifyCheckerPageModificationhasDoneByMaker();
		corporatedailylimit.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		corporatedailylimit.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	}

	@Test(priority = 11)
	// go To The Corporate Daily Limit Maker To Verify Checker Has Approved The
	// Modify Data Same
	public void goToTheCorporateDailyLimitMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		corporatedailylimit.gotoMakerWhenCheckerHasApproved();
		corporatedailylimit = new CorporateDailyLimitMaker(driver);
		corporatedailylimit.enterloginid("lastmile8");
		corporatedailylimit.enterpassword("password@1");
		corporatedailylimit.clickonlogin();
		Thread.sleep(5000);
		corporatedailylimit.toverifyhomepage();
		Thread.sleep(5000);
		corporatedailylimit.clickonCorporateDefinitionMakerMenu();
		corporatedailylimit.clickonCorporateDailyLimitMakerSubMenu();
		corporatedailylimit.toswitchFieldsareinmandatory();
		corporatedailylimit.viewinMakerPage();
		corporatedailylimit.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		corporatedailylimit.verifyViewpageBySearchFieldWhenModify();
		// By Verify the particular Text With Column Values
		corporatedailylimit.toVerifyByGetTextInViewPageWhenModify();
		corporatedailylimit.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToCorporateDailyLimitMakerPage() throws Exception {
		Thread.sleep(5000);
		corporatedailylimit.SwitchTheWindowFrom3ChildToParent();
		corporatedailylimit.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testToVerifyCheckerViewPageWhenModifedTheCorporateDailyLimitMaker() throws Throwable {
		Thread.sleep(3000);
		corporatedailylimit.enterloginid("lastmile7");
		corporatedailylimit.enterpassword("password@2");
		corporatedailylimit.clickonlogin();
		corporatedailylimit.clickonCorporateDefinitionCheckerMenu();
		corporatedailylimit.clickOnAuthoriserCorporateDailyLimitSubMenu();
		corporatedailylimit.verifyCorporateDailyLimitCheckerPage();
		corporatedailylimit.clickOnviewInChecker();
		driver.manage().window().maximize();
		corporatedailylimit.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		corporatedailylimit.verifyViewpageBySearchFieldWhenModify();
		corporatedailylimit.toVerifyByGetTextInViewPageWhenModify();
		corporatedailylimit.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		corporatedailylimit.SwitchTheWindowFrom4ChildToParent();
		corporatedailylimit.clickOnlogoutCheckerButton();
	}

}
