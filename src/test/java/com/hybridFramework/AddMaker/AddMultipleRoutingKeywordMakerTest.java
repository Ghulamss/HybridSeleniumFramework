package com.hybridFramework.AddMaker;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.AddMultipleRoutingKeywordMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddMultipleRoutingKeywordMakerTest extends TestBase {
	AddMultipleRoutingKeywordMaker addmultipleroutingkeyword;

	private final Logger log = LoggerHelper.getLogger(AddMultipleRoutingKeywordMakerTest.class);

	@Test(priority = 1)
	public void testLoginToAddMultipleRoutingKeywordMaker() throws InterruptedException {
		log.info(AddMultipleRoutingKeywordMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		addmultipleroutingkeyword = new AddMultipleRoutingKeywordMaker(driver);
		addmultipleroutingkeyword.enterloginid("Test_maker1");
		addmultipleroutingkeyword.enterpassword("password@1");
		addmultipleroutingkeyword.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAddMultipleRoutingKeywordMakerPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		//addmultipleroutingkeyword.toverifyhomepage();
		addmultipleroutingkeyword.clikonmasterdefinitionmakerMenu();
		addmultipleroutingkeyword.clickonAddMultipleRoutingKeywordMakerSubMenu();

		addmultipleroutingkeyword.toswitchFieldsareinmandatory();
		// 010330436
		addmultipleroutingkeyword.enterroutingNo("16316");
		addmultipleroutingkeyword.enterBankKeyword("L");
		addmultipleroutingkeyword.enterBranchKeyword("BBg");
		addmultipleroutingkeyword.enterDistrict("Mumbaf");
		addmultipleroutingkeyword.selectisPrimeBankOnAddRoutingPage();
		addmultipleroutingkeyword.selectisActiveRouting();
        Thread.sleep(3000);
		addmultipleroutingkeyword.clickonsubmitInMakerpage();
		// addmultipleroutingkeyword.verifyErrorMessage();
		Thread.sleep(3000);
		addmultipleroutingkeyword.verifySuccesfullMessage();

	}

	@Test(priority = 3)
	// Checker Page..
	public void chekerlogin() throws Exception {
		addmultipleroutingkeyword.enterloginid("lastmile3");
		addmultipleroutingkeyword.enterpassword("password@1");
		addmultipleroutingkeyword.clickonlogin();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// addmultipleroutingkeyword.toverifyhomepage();
		Thread.sleep(4000);
		addmultipleroutingkeyword.clickonMasterDefinitionChecker();
		Thread.sleep(4000);
		addmultipleroutingkeyword.clickOnAddRoutingKeywordCheckerSubMenu();
		addmultipleroutingkeyword.verifyRoutingKeywordCheckerPages();

	}

	// in Checker page verify the list of Elements
	// Doing Comment on
	@Test(priority = 4)
	public void verifyAddcheckerListinMultipleRoutingKeywordCheckerpage() throws Exception {
		addmultipleroutingkeyword.verifyAddcheckerListInCheckerpage();
		addmultipleroutingkeyword.HandleTheDynamicVluesWithCheckbox();
		// addmultipleroutingkeyword.multiplecheckbox();
		// Not Used
		// currencypage.selectHeadercheckbox();
	}

	// in Checker page
	// Doing Comment On
	@Test(priority = 5)
	// click on submit Button and verify Message in Checker page.
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {
		addmultipleroutingkeyword.clickonsubmitbuttonOnCheckerPage();
		addmultipleroutingkeyword.toverifysuccessfulMessageinCheckerPage();
	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerApprovedAddMultipleRoutingKeywordMaker() throws Exception {
		// click on log out checker Button .
		addmultipleroutingkeyword.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
		// here we call the driver because the without can not Automate
		addmultipleroutingkeyword = new AddMultipleRoutingKeywordMaker(driver);
		addmultipleroutingkeyword.enterloginid("Test_maker1");
		addmultipleroutingkeyword.enterpassword("password@1");
		addmultipleroutingkeyword.clickonlogin();
		Thread.sleep(5000);
		//addmultipleroutingkeyword.toverifyhomepage();
		Thread.sleep(5000);
		addmultipleroutingkeyword.clikonmasterdefinitionmakerMenu();
		addmultipleroutingkeyword.clickonAddMultipleRoutingKeywordMakerSubMenu();
		addmultipleroutingkeyword.toswitchFieldsareinmandatory();

		/*
		 * view page is not available on keyword routing page
		 * addmultipleroutingkeyword.clickOnviewButtoninMakerPage();
		 * addmultipleroutingkeyword.switchToNewWindow(1);
		 * addmultipleroutingkeyword.verifyViewpages("BD","testpu","purpose3");
		 * addmultipleroutingkeyword.multippleSelectVerifyTextInViewPage();
		 * //Thread.sleep(5000); addmultipleroutingkeyword.selectAllvaluesOneByOne();
		 */

	}

	

	// switch To Main window Add Multiple Routing Keyword Modify Maker
	// Switch the Child window (Multiple Routing view page ) To parent window(Multiple Routing Maker
	// page)
	@Test(priority = 7)
	public void switchToMainwindow() throws Exception {
		// switch view page to Maker page and click on Modify button.
		//addmultipleroutingkeyword.switch2();
		addmultipleroutingkeyword.clickOnModifyButton();
		addmultipleroutingkeyword.enterroutingNoOnModifyMakerPage("010330436");
		// click on first Submit button
		addmultipleroutingkeyword.clickOnsubmitbutton();
		// modify Submit Button
		Thread.sleep(5000);
		addmultipleroutingkeyword.clickmodifysubmitbutton();
		Thread.sleep(5000);
		addmultipleroutingkeyword.successfullverificationMessageInModifyMakerPage();

	}

    // login To AddMultiple Routing Keyword Checker if Modify the Same data 
	// go to the CHecker Page.and verify the checker page.
	@Test(priority = 8)
	public void testloginToAddMultipleRoutingKeywordChecker() throws Exception {
		addmultipleroutingkeyword.enterloginid("lastmile3");
		addmultipleroutingkeyword.enterpassword("password@1");
		addmultipleroutingkeyword.clickonlogin();
		addmultipleroutingkeyword.clickonMasterDefinitionChecker();
		addmultipleroutingkeyword.clickOnAddRoutingKeywordCheckerSubMenu();
		addmultipleroutingkeyword.verifyRoutingKeywordCheckerPages();

	}

	@Test(priority = 9)
	// calling
	// putting on Comment
	// verify Payment Type checker Page List After Modification has Done By Maker
	public void verifyAddMultipleRoutingKeywordCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		// in Cheker page when Modification has done By Maker
		/*
		 * addmultipleroutingkeyword.
		 * verifyListonCheckerpageWhenModificationhasDoneByMaker();
		 * addmultipleroutingkeyword.multiplecheckboxwhenModifytheCountry();
		 * addmultipleroutingkeyword.clickonsubmitbuttonOnCheckerPage();
		 * addmultipleroutingkeyword.toverifysuccessfulMessageinCheckerPage();
		 */
	}

	@Test(priority = 10)
	// go To The Country Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheAddMultipleRoutingKeywordMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		addmultipleroutingkeyword.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
		addmultipleroutingkeyword = new AddMultipleRoutingKeywordMaker(driver);
		addmultipleroutingkeyword.enterloginid("Test_maker1");
		addmultipleroutingkeyword.enterpassword("password@1");
		addmultipleroutingkeyword.clickonlogin();
		Thread.sleep(5000);
		//addmultipleroutingkeyword.toverifyhomepage();
		Thread.sleep(5000);
		addmultipleroutingkeyword.clikonmasterdefinitionmakerMenu();
		addmultipleroutingkeyword.clickonAddMultipleRoutingKeywordMakerSubMenu();
		addmultipleroutingkeyword.toswitchFieldsareinmandatory();
		addmultipleroutingkeyword.clickOnviewButtoninMakerPage();
		addmultipleroutingkeyword.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		// currencypage.verifyViewpages("ABC123","FX","COUR");
		addmultipleroutingkeyword.verifyViewpagesWhenModifyTheCounterAndApprovedDoneByChecker("AGRANI BANK LTD.",
				"MOUNA BAZAR", "010331127");
		// By Verify the particular Text With Column Values
		// currencypage.multippleSelectVerifyTextInViewPage();

		Thread.sleep(5000);
		addmultipleroutingkeyword.toVerifyByTextInViewMakerPagewhenModified();
		// Thread.sleep(5000);
		// currencypage.selectAllvaluesOneByOne();
		Thread.sleep(5000);
		addmultipleroutingkeyword.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 11)
	// switch To window Modify View Page To ADD Payment Type MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToPaymentTypePage() throws Exception {
		Thread.sleep(5000);
		addmultipleroutingkeyword.SwitchTheWindowFrom3ChildToParent();
		addmultipleroutingkeyword.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	// this priority is not working because data is not available on the Checker
	// View page.
	@Test(priority = 12)
	public void testloginToAddMultipleRoutingKeywordCheckerToVerifyCheckerViewPageWhenModifedTheIt() throws Throwable {
		addmultipleroutingkeyword.enterloginid("lastmile3");
		addmultipleroutingkeyword.enterpassword("password@1");
		addmultipleroutingkeyword.clickonlogin();
		addmultipleroutingkeyword.clickonMasterDefinitionChecker();
		addmultipleroutingkeyword.clickOnAddRoutingKeywordCheckerSubMenu();
		addmultipleroutingkeyword.verifyRoutingKeywordCheckerPages();
		addmultipleroutingkeyword.clickOnviewInChecker();
		driver.manage().window().maximize();
		addmultipleroutingkeyword.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		// currencypage.verifyViewpages("ABC123","FX","COUR");
		addmultipleroutingkeyword.verifyViewpagesWhenModifyTheCounterAndApprovedDoneByChecker("AGRANI BANK LTD.",
				"MOUNA BAZAR", "010331127");
		addmultipleroutingkeyword.toVerifyByTextInViewMakerPagewhenModified();
		// Thread.sleep(5000);
		// currencypage.selectAllvaluesOneByOne();
		addmultipleroutingkeyword.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		// Thread.sleep(5000);
		addmultipleroutingkeyword.SwitchTheWindowFrom4ChildToParent();
		addmultipleroutingkeyword.clickOnlogoutCheckerButton();
	}

}
