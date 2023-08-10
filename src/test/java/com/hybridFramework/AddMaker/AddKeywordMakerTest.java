package com.hybridFramework.AddMaker;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.AddKeywordMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddKeywordMakerTest extends TestBase {
	AddKeywordMaker addKeyword;

	private final Logger log = LoggerHelper.getLogger(AddKeywordMakerTest.class);

	@Test(priority = 1)
	public void testLoginToApplicationKeyWordMaker() throws InterruptedException {
		log.info(AddKeywordMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		addKeyword = new AddKeywordMaker(driver);
		addKeyword.enterloginid("lastmile8");
		addKeyword.enterpassword("password@1");
		addKeyword.clickonlogin();
	}

	@Test(priority = 2)
	public void testLoginToKeyWordMakerApplicationAndVerifySuceesfullyMessage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		//addKeyword.toverifyhomepage();
		addKeyword.clikonmasterdefinitionmakerMenu();
		addKeyword.clickonAddKeywordMakerSubMenu();
		addKeyword.toswitchFieldsareinmandatory();
		addKeyword.enterkeyWordField("MDown");
		addKeyword.enterkeyWordDesc("keyDown");
		addKeyword.selectisActiveKeyword();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// addKeyword.sendselectFile("E:\\LoginTest.xlsx");
		addKeyword.clickonsubmitInMakerpage();
		addKeyword.verifySuccesfullMessage();
	}

	@Test(priority = 3)
	// Checker Page..
	public void tochekerlogin() throws Exception {
		addKeyword.enterloginid("lastmile7");
		addKeyword.enterpassword("password@2");
		addKeyword.clickonlogin();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// entitytypemaker.toverifyhomepage();
		Thread.sleep(4000);
		addKeyword.clickonMasterDefinitionChecker();
		Thread.sleep(4000);
		addKeyword.clickOnAddKeywordCheckerSubMenu();
		addKeyword.verifyKeyWordCheckerCheckerPage();
	}

	// in Checker page verify list of Web elements
	@Test(priority = 4)
	public void verifyAddcheckerListinCheckerpage() throws Exception {
		addKeyword.verifyAddcheckerListInKEYWORDCHECKERCheckerpage();
		addKeyword.HandleTheDynamicVluesWithCheckbox();
		
	}

	// in Checker page
	@Test(priority = 5)
	// click on submit Button and verifying successfully Message.
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {
		addKeyword.clickonsubmitbuttonInKeywordCHECKERPage();
		addKeyword.toverifysuccessfulMessageinKeywordChekerPage();
	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerCheckerApprovedCountrypage() throws Exception {
		// click on log out checker Button .
		addKeyword.gotoMakerPagewhenCheckerhasApprovedEntityTYpeMaker();
		// here we call the driver because the without can not Automate
		addKeyword = new AddKeywordMaker(driver);
		addKeyword.enterloginid("lastmile8");
		addKeyword.enterpassword("password@1");
		addKeyword.clickonlogin();
		Thread.sleep(5000);
		//addKeyword.toverifyhomepage();
		Thread.sleep(5000);
		addKeyword.clikonmasterdefinitionmakerMenu();
		addKeyword.clickonAddKeywordMakerSubMenu();
		addKeyword.toswitchFieldsareinmandatory();
		addKeyword.clickOnviewButtoninMakerPage();
		addKeyword.switchToNewWindow(1);
		addKeyword.verifyViewpageBySearchField();
		addKeyword.multippleSelectVerifyTextInViewPage();
		addKeyword.selectAllvaluesOneByOneFromDropDownInViewPage();
		// currencypage.switchToWindowByUsingIterator();
	}

	// this one is not working
	@Test(priority = 7)
	public void switchToWindowByUsingIterator() throws Exception {
		// currencypage.switchToWindowByUsingIterator();

	}

	// switch To Main window Country Modify Maker
	// Switch the Child window (KeyWord view page ) To parent window(KeyWord Maker
	// page)
	@Test(priority = 8)
	public void switchToMainwindow() throws Exception {
		// switch view page to Maker page and click on Modify button.
		addKeyword.switch2();
		Thread.sleep(5000);
		// old code
		// addKeyword.selectcountryCodeInModifyMakerPage();
		addKeyword.selectKeywordInModifyMakerPageByUsingSplitAsPerAddingValue();

		// click on first Submit button
		addKeyword.clickOnsubmitbutton();
		// modify Submit Button
		Thread.sleep(5000);
		addKeyword.clickmodifysubmitbutton();
		Thread.sleep(5000);
		addKeyword.verificationMessageInModifyKeywordPage();

	}

// login To KeyWord Checker if Modify the Same data 
	@Test(priority = 9)
	public void testloginToKeywordChecker() throws Exception {
		addKeyword.enterloginid("lastmile7");
		addKeyword.enterpassword("password@2");
		addKeyword.clickonlogin();
		addKeyword.clickonMasterDefinitionChecker();
		addKeyword.clickOnAddKeywordCheckerSubMenu();
		addKeyword.verifyKeyWordCheckerCheckerPage();

	}

	@Test(priority = 10)
	// calling
	// verify Country checker Page List After Modification has Done By Maker
	public void verifyKeywordheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		// in Cheker page when Modification has done By Maker
		addKeyword.verifyKeywordIncheckerListWhenModificationhasDoneByMaker();
		addKeyword.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		// old code
		// currencypage.clickonsubmitbuttonAndverifySuccesfullMessageIfModifytheCountry();
		addKeyword.clickonsubmitbuttonInKeywordCHECKERPage();
		addKeyword.toverifysuccessfulMessageinKeywordChekerPage();
	}

	@Test(priority = 11)
	// go To The Country Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheKeywordMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		addKeyword.gotoMakerPagewhenCheckerhasApprovedEntityTYpeMaker();
		addKeyword = new AddKeywordMaker(driver);
		addKeyword.enterloginid("lastmile8");
		addKeyword.enterpassword("password@1");
		addKeyword.clickonlogin();
		Thread.sleep(5000);
		//addKeyword.toverifyhomepage();
		Thread.sleep(5000);
		addKeyword.clikonmasterdefinitionmakerMenu();
		addKeyword.clickonAddKeywordMakerSubMenu();
		addKeyword.toswitchFieldsareinmandatory();
		addKeyword.clickOnviewButtoninMakerPage();
		addKeyword.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		addKeyword.verifyViewpagesWhenModifyTheCounterAndApprovedDoneByChecker();
		// By Verify the particular Text With Column Values
		Thread.sleep(5000);
		addKeyword.toVerifyTextInViewMakerPagewhenModified();
		Thread.sleep(5000);
		addKeyword.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To Add Keyword Maker Page
	// and LogOut
	public void switchTowindowModifyViewPageToAddKeyWordMakerPage() throws Exception {
		Thread.sleep(5000);
		addKeyword.SwitchTheWindowFrom3ChildToParent();
		addKeyword.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testloginToKeywordCheckerToVerifyCheckerViewPageWhenModifed() throws Throwable {
		addKeyword.enterloginid("lastmile7");
		addKeyword.enterpassword("password@2");
		addKeyword.clickonlogin();
		addKeyword.clickonMasterDefinitionChecker();
		addKeyword.clickOnAddKeywordCheckerSubMenu();
		addKeyword.verifyKeyWordCheckerCheckerPage();
		addKeyword.clickOnviewInChecker();
		driver.manage().window().maximize();
		addKeyword.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		addKeyword.verifyViewpagesWhenModifyTheCounterAndApprovedDoneByChecker();
		addKeyword.toVerifyTextInViewMakerPagewhenModified();
		addKeyword.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		addKeyword.SwitchTheWindowFrom4ChildToParent();
		addKeyword.clickOnlogoutCheckerButton();
	}

}
