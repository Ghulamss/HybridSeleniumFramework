package com.hybridFramework.AddMaker;

import java.util.Currency;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.AddCutOffMaker;
import com.hybridFramework.PageObject.AddEntityTypeMaker;
import com.hybridFramework.PageObject.AddMultipleRoutingKeywordMaker;
import com.hybridFramework.PageObject.AddPaymentTypeMaker;
import com.hybridFramework.PageObject.AddPurposeMaker;
import com.hybridFramework.PageObject.AddRoutingMaker;
import com.hybridFramework.PageObject.AddSubPurposeMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddCutOffMakerTest extends TestBase {
	AddCutOffMaker addcutoffmaker;

	private final Logger log = LoggerHelper.getLogger(AddCutOffMakerTest.class);

	@Test(priority = 1)
	public void testLoginToApplication() throws Exception {
		log.info(Currency.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		addcutoffmaker = new AddCutOffMaker(driver);
		addcutoffmaker.enterloginid("lastmile8");
		addcutoffmaker.enterpassword("password@1");
		addcutoffmaker.clickonlogin();
		Thread.sleep(10000);
		//addcutoffmaker.switchToTab()
	}

	@Test(priority = 2)
	public void testLoginToApplication2() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		addcutoffmaker.toverifyhomepage();
		addcutoffmaker.clikonmasterdefinitionmakerMenu();
		addcutoffmaker.clickonAddCutOffMakerSubMenu();
		addcutoffmaker.toswitchFieldsareinmandatory();
		/*
		 *  for the Testing of Calendar by using  general Method.
		 * addcutoffmaker.clickOneffectiveFromDate();
		 * addcutoffmaker.calenderHandeling();
		 */
		
		  addcutoffmaker.selectCalenderByJS();
		  addcutoffmaker.selectEffectiveTodateByJS();
		  addcutoffmaker.selectmandateTypeOnMakerPage();
		  addcutoffmaker.isActiveCutOffTimeOnMakerPage();
		  addcutoffmaker.selectcutoffTimeByJS();
		 Thread.sleep(3000);
		 addcutoffmaker.clickonsubmitInMakerpage();
		// addcutoffmaker.verifyErrorMessage();
		  Thread.sleep(3000);
		//
		 addcutoffmaker.verifySuccesfullMessage();

	}

	@Test(priority = 3)
	// Checker Page..
	public void chekerlogin() throws Exception {
		addcutoffmaker.enterloginid("lastmile3");
		addcutoffmaker.enterpassword("password@1");
		addcutoffmaker.clickonlogin();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// addcutoffmaker.toverifyhomepage();
		Thread.sleep(4000);
		addcutoffmaker.clickonMasterDefinitionChecker();
		Thread.sleep(4000);
		addcutoffmaker.clickOnAuthoriseCutOffCheckerSubMenu();
		addcutoffmaker.verifyCutOffTimeCheckerPages();

	}

	// in Checker page verify the list of Elements one by one 
	// Doing Comment on
	@Test(priority = 4)
	public void verifyAddcheckerListinPaymentTypeCheckerpage() throws InterruptedException {
		addcutoffmaker.verifyAddcheckerListInCheckerpage();
		//addcutoffmaker.multiplecheckbox();
		// Not Used
		// currencypage.selectHeadercheckbox();
	}

	// in Checker page
	// Doing Comment On
	@Test(priority = 5)
	// click on submit Button and verify Message in Checker page.
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {
		// addcutoffmaker.clickonsubmitbuttonOnCheckerPage();
		// addcutoffmaker.toverifysuccessfulMessageinCheckerPage();
	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerCheckerApprovedCountrypage() throws Exception {
		// click on log out checker Button .
		addcutoffmaker.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
		// here we call the driver because the without can not Automate
		addcutoffmaker = new AddCutOffMaker(driver);
		addcutoffmaker.enterloginid("lastmile8");
		addcutoffmaker.enterpassword("password@1");
		addcutoffmaker.clickonlogin();
		Thread.sleep(5000);
		addcutoffmaker.toverifyhomepage();
		Thread.sleep(5000);
		addcutoffmaker.clikonmasterdefinitionmakerMenu();
		addcutoffmaker.clickonAddCutOffMakerSubMenu();
		addcutoffmaker.toswitchFieldsareinmandatory();
        addcutoffmaker.clickOnviewButtoninMakerPage();
		  Thread.sleep(5000);
		  addcutoffmaker.switchToNewWindow(1);
		  Thread.sleep(5000);
		  addcutoffmaker.verifyModifyCutOffTimePages();
		  // Concept of Multiple Pages. Or Concept Of Paging
		  //addcutoffmaker.conceptofPaging();
		  
		
		  //addcutoffmaker.verifyViewpages("09-18-2019","NEFT","Cash");
		  Thread.sleep(5000);
		  
		  addcutoffmaker.multippleSelectVerifyTextInViewPage();
		  
		  //addcutoffmaker.selectAllvaluesOneByOne();
		 
		 

	}

	// this one is not working
	//
	@Test(priority = 7)
	public void switchToWindowByUsingIterator() throws Exception {
		// currencypage.switchToWindowByUsingIterator();

	}

	// switch To Main window Country Modify Maker
	//
	// Switch the Child window (Currency view page ) To parent window(Currency Maker
	// page)
	@Test(priority = 8)
	// This is not working for the Cut -Off maker because Modify option is not available 
	// so comment it.but all method are working fine 
	public void switchToMainwindow() throws Exception {
		// switch view page to Maker page and click on Modify button.
		// addcutoffmaker.switch2();
		//addcutoffmaker.enterroutingNoOnModifyMakerPage("010330436");
		// click on first Submit button
		//addcutoffmaker.clickOnsubmitbutton();
		// modify Submit Button
		Thread.sleep(5000);
		//addcutoffmaker.clickmodifysubmitbutton();
		Thread.sleep(5000);
		//addcutoffmaker.successfullverificationMessageInModifyMakerPage();

	}

// login To payment type Checker if Modify the Same data 
	// go to the CHecker Page.and verify the checker page.
	@Test(priority = 9)
	public void testloginToCountryChecker() throws Exception {
//		addcutoffmaker.clickOnlogoutMakerButton();
//		addcutoffmaker.enterloginid("lastmile3");
//		addcutoffmaker.enterpassword("password@1");
//		addcutoffmaker.clickonlogin();
//		addcutoffmaker.clickonMasterDefinitionChecker();
//		addcutoffmaker.clickOnAuthoriseCutOffCheckerSubMenu();
//		addcutoffmaker.verifyCutOffTimeCheckerPages();

	}

	@Test(priority = 10)
	// calling
	// putting on Comment
	// verify Payment Type checker Page List After Modification has Done By Maker
	public void verifyCountrycheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		// in Cheker page when Modification has done By Maker
		/*
		 * addcutoffmaker.verifyListonCheckerpageWhenModificationhasDoneByMaker();
		 * addcutoffmaker.multiplecheckboxwhenModifytheCountry();
		 * addcutoffmaker.clickonsubmitbuttonOnCheckerPage();
		 * addcutoffmaker.toverifysuccessfulMessageinCheckerPage();
		 */
	}

	/*// this is Maker View page when the Modification has done then it goes to Maker View page.
	 * @Test(priority = 11) // go To The Country Maker To Verify Checker Has
	 * Approved The Modify Data Same on View page public void
	 * goToTheCountryMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception
	 * { // click on log out button in Checker
	 * addcutoffmaker.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
	 * addcutoffmaker = new AddCutOffMaker(driver);
	 * addcutoffmaker.enterloginid("lastmile8");
	 * addcutoffmaker.enterpassword("password@2"); addcutoffmaker.clickonlogin();
	 * Thread.sleep(5000); addcutoffmaker.toverifyhomepage(); Thread.sleep(5000);
	 * addcutoffmaker.clikonmasterdefinitionmakerMenu();
	 * addcutoffmaker.clickonAddCutOffMakerSubMenu();
	 * addcutoffmaker.toswitchFieldsareinmandatory();
	 * addcutoffmaker.clickOnviewButtoninMakerPage();
	 * addcutoffmaker.switchToNewWindow(1); // Enter the values one By one in Search
	 * Box in view page addcutoffmaker.
	 * verifyViewpagesWhenModifyTheCounterAndApprovedDoneByChecker("AGRANI BANK LTD."
	 * , "MOUNA BAZAR", "010331127"); // By Verify the particular Text With Column
	 * Values Thread.sleep(5000);
	 * addcutoffmaker.toVerifyByTextInViewMakerPagewhenModified();
	 * 
	 * Thread.sleep(5000);
	 * addcutoffmaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown(); }
	 */
	
	
	
	/*
	 * // to verify Maker View Page When Checker Has Approved Modify Country
	 * 
	 * @Test(priority=12) public void
	 * toverifyMakerViewPageWhenCheckerHasApprovedModifyCountry() throws Exception {
	 * currencypage.switchToNewWindow(1); // Enter the values one By one in Search
	 * Box in view page
	 * currencypage.verifyViewpagesWhenModifyTheCounterAndApprovedDoneByChecker(
	 * "ABC123","FX","COUR"); // By Verify the particular Text With Column Values
	 * currencypage.toVerifyTextInViewPageWithHeaderColumn(); Thread.sleep(5000);
	 * currencypage.toVerifytheModifyDataInMakerViewPagByUsingDropDown(); }
	 */
	@Test(priority = 12)
	// switch To window Modify View Page To ADD Payment Type MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToPaymentTypePage() throws Exception {
		Thread.sleep(5000);
		//addcutoffmaker.SwitchTheWindowFrom3ChildToParent();
		addcutoffmaker.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	// this priority is not working because data is not available on the Checker
	// View page.
	@Test(priority = 13)
	public void testloginToCountryCheckerToVerifyCheckerViewPageWhenModifedTheCountry() throws Throwable {
		addcutoffmaker.enterloginid("lastmile3");
		addcutoffmaker.enterpassword("password@1");
		addcutoffmaker.clickonlogin();
		addcutoffmaker.clickonMasterDefinitionChecker();
		addcutoffmaker.clickOnAuthoriseCutOffCheckerSubMenu();
		addcutoffmaker.verifyCutOffTimeCheckerPages();
		addcutoffmaker.clickOnviewInChecker();
		driver.manage().window().maximize();
		addcutoffmaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		
		Thread.sleep(5000);
		addcutoffmaker.verifyViewpagesWhenModifyTheCounterAndApprovedDoneByChecker("01-31-0002", "02-28-2020","270");
		addcutoffmaker.toVerifyByTextInViewMakerPagewhenModified();
		Thread.sleep(5000);
		
		addcutoffmaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		//Thread.sleep(5000);
		addcutoffmaker.SwitchTheWindowFrom4ChildToParent();
		addcutoffmaker.verifyCutOffTimeCheckerPages();
		addcutoffmaker.clickOnlogoutCheckerButton();
	}

}
