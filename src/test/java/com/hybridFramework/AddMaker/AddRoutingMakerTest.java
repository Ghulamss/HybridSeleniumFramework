package com.hybridFramework.AddMaker;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.AddRoutingMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddRoutingMakerTest extends TestBase {
	AddRoutingMaker addroutingmaker;

	private final Logger log = LoggerHelper.getLogger(AddRoutingMakerTest.class);

	@Test(priority = 1)
	public void testToLoginAddRoutingMaker() throws InterruptedException {
		log.info(AddRoutingMaker.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		addroutingmaker = new AddRoutingMaker(driver);
		addroutingmaker.enterloginid("lastmile8");
		addroutingmaker.enterpassword("password@1");
		addroutingmaker.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAddRoutingMakerPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();

		addroutingmaker.toverifyhomepage();
		addroutingmaker.clikonmasterdefinitionmakerMenu();
		addroutingmaker.clickonAddRoutingMakerSubMenu();
		addroutingmaker.toswitchFieldsareinmandatory();
		// Calling
		// addroutingmaker.clickonsubmitInMakerpage();
		// For verify Error message
		// addroutingmaker.verifyErrorMessage();
		addroutingmaker.selectBankIDOnAddRoutingMakerpage();
		addroutingmaker.enterroutingNo("01033041");
		addroutingmaker.enterBankName("AAAB");
		addroutingmaker.enterBankBranch("AwadhA");
		addroutingmaker.enterBankdistrict("GayaA");
		addroutingmaker.enterBankdivision("GayaA");
		addroutingmaker.enterBankDist_code("00101");
		addroutingmaker.enterBank_code("B002");
		addroutingmaker.enterBranch_code("BR002");
		addroutingmaker.enterBranch_address("Gaya Bihar 824231");
		addroutingmaker.selectisActiveRouting();
		addroutingmaker.SelectisSameBankORDifferent();
		addroutingmaker.clickonsubmitInMakerpage();
		addroutingmaker.verifyErrorMessage();
		Thread.sleep(3000);
		//
		addroutingmaker.verifySuccesfullMessage();

	}

	@Test(priority = 3)
	// Checker Page..

	public void testToAddRoutingChekerlogin() throws Exception {
		addroutingmaker.enterloginid("lastmile7");
		addroutingmaker.enterpassword("password@2");
		addroutingmaker.clickonlogin();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// addroutingmaker.toverifyhomepage();
		Thread.sleep(4000);
		addroutingmaker.clickonMasterDefinitionChecker();
		Thread.sleep(4000);
		addroutingmaker.clickOnAddRoutingCheckerSubMenu();
		addroutingmaker.verifyRoutingCheckerPages();

	}

	// in Checker page verify the list of Elements
	// Doing Comment on
	@Test(priority = 4)
	public void verifyAddcheckerListinAddRoutingCheckerpage() throws InterruptedException {
		addroutingmaker.verifyAddcheckerListInCheckerpage();
		addroutingmaker.selectThecheckboxOnCheckerPageWhenAddMakerDaata();
		
	}

	// in Checker page
	// Doing Comment On
	@Test(priority = 5)
	// click on submit Button and verify Message in Checker page.
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {
		addroutingmaker.clickonsubmitbuttonOnCheckerPage();
		addroutingmaker.toverifysuccessfulMessageinCheckerPage();
	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerCheckerApprovedRoutingCheckerpage() throws Exception {
		// click on log out checker Button .
		addroutingmaker.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
		// here we call the driver because the without can not Automate
		addroutingmaker = new AddRoutingMaker(driver);
		addroutingmaker.enterloginid("lastmile8");
		addroutingmaker.enterpassword("password@1");
		addroutingmaker.clickonlogin();
		Thread.sleep(5000);
		addroutingmaker.toverifyhomepage();
		Thread.sleep(5000);
		addroutingmaker.clikonmasterdefinitionmakerMenu();
		addroutingmaker.clickonAddRoutingMakerSubMenu();
		addroutingmaker.toswitchFieldsareinmandatory();
		addroutingmaker.clickOnviewButtoninMakerPage();
		addroutingmaker.switchToNewWindow(1);
		addroutingmaker.verifyViewpageBySearchField();
		//addroutingmaker.multippleSelectVerifyTextInViewPage();
		// Thread.sleep(5000);
		//addroutingmaker.selectDropDownOnViewPagevaluesOneByOneDropDown();
		// old code
		// currencypage.switchToWindowByUsingIterator();

	}

	// switch To Main window Routing Modify Maker
	// Switch the Child window (Routing view page ) To parent window(Routing Maker
	// page)
	@Test(priority = 7)
	public void switchToMainwindow() throws Exception {
		// switch view page to Maker page and click on Modify button.
		addroutingmaker.switch2();
		addroutingmaker.enterroutingNoOnModifyMakerPage();
		// click on first Submit button
		addroutingmaker.clickOnsubmitbutton();
		// modify Submit Button
		Thread.sleep(5000);
		addroutingmaker.clickmodifysubmitbutton();
		Thread.sleep(5000);
		addroutingmaker.successfullverificationMessageInModifyMakerPage();

	}

// login To payment type Checker if Modify the Same data 
	// go to the CHecker Page.and verify the checker page.
	@Test(priority = 8)
	public void testloginToAddRoutingChecker() throws Exception {
		addroutingmaker.enterloginid("lastmile7");
		addroutingmaker.enterpassword("password@2");
		addroutingmaker.clickonlogin();
		addroutingmaker.clickonMasterDefinitionChecker();
		addroutingmaker.clickOnAddRoutingCheckerSubMenu();
		addroutingmaker.verifyRoutingCheckerPages();

	}

	@Test(priority = 9)
	// calling
	// putting on Comment
	// verify Add Routing checker Page List After Modification has Done By Maker
	public void verifyAddRoutingCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		// in Cheker page when Modification has done By Maker

		addroutingmaker.verifyListonCheckerpageWhenModificationhasDoneByMaker();
		addroutingmaker.selectThecheckboxOnCheckerPageWhenModifyTheMakerData();
	
		// .clickonsubmitbuttonOnCheckerPage();
		// addroutingmaker.toverifysuccessfulMessageinCheckerPage();

	}

	@Test(priority = 10)
	// go To The Country Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheRoutingMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		addroutingmaker.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
		addroutingmaker = new AddRoutingMaker(driver);
		addroutingmaker.enterloginid("lastmile8");
		addroutingmaker.enterpassword("password@1");
		addroutingmaker.clickonlogin();
		Thread.sleep(5000);
		addroutingmaker.toverifyhomepage();
		Thread.sleep(5000);
		addroutingmaker.clikonmasterdefinitionmakerMenu();
		addroutingmaker.clickonAddRoutingMakerSubMenu();
		addroutingmaker.toswitchFieldsareinmandatory();
		addroutingmaker.clickOnviewButtoninMakerPage();
		addroutingmaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		
		addroutingmaker.verifyViewpagesBySearchFieldWhenModifyAndApprovedDoneByChecker();
		// By Verify the particular Text With Column Values
		Thread.sleep(5000);
		//addroutingmaker.toVerifyByTextInViewMakerPagewhenModified();
		
		Thread.sleep(5000);
		//addroutingmaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 11)
	// switch To window Modify View Page To ADD Payment Type MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToAddRoutingMakerPage() throws Exception {
		Thread.sleep(5000);
		addroutingmaker.SwitchTheWindowFrom3ChildToParent();
		addroutingmaker.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	// this priority is not working because data is not available on the Checker
	// View page.
	@Test(priority = 12)
	public void testloginToAddRoutingCheckerToVerifyCheckerViewPageWhenModifedTheAddRoutingMaker() throws Throwable {
		addroutingmaker.enterloginid("lastmile7");
		addroutingmaker.enterpassword("password@2");
		addroutingmaker.clickonlogin();
		addroutingmaker.clickonMasterDefinitionChecker();
		addroutingmaker.clickOnAddRoutingCheckerSubMenu();
		addroutingmaker.verifyRoutingCheckerPages();
		addroutingmaker.clickOnviewInChecker();
		driver.manage().window().maximize();
		addroutingmaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		
		addroutingmaker.verifyViewpagesBySearchFieldWhenModifyAndApprovedDoneByChecker();
		addroutingmaker.toVerifyByTextInViewMakerPagewhenModified();
		
	   // addroutingmaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		// Thread.sleep(5000);
		//addroutingmaker.SwitchTheWindowFrom4ChildToParent();
		//addroutingmaker.clickOnlogoutCheckerButton();
	}

}
