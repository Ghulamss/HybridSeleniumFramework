package com.hybridFramework.AddMaker;

import java.util.Currency;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.AddEntityTypeMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddEntityTypeMakerTest extends TestBase {
	AddEntityTypeMaker entitytypemaker;

	private final Logger log = LoggerHelper.getLogger(Currency.class);

	@Test(priority = 1)
	public void testLoginToApplication() throws InterruptedException {
		log.info(Currency.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		entitytypemaker = new AddEntityTypeMaker(driver);
		entitytypemaker.enterloginid("lastmile6");
		entitytypemaker.enterpassword("password@1");
		entitytypemaker.clickonlogin();

	}

	@Test(priority = 2)
	public void testLoginToApplicationWhenAddEntityType() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		//entitytypemaker.toverifyhomepage();
		entitytypemaker.clikonmasterdefinitionmakerMenu();
		entitytypemaker.clickonAddEntityTypeMakerSubMenu();
		entitytypemaker.toswitchFieldsareinmandatory();
		entitytypemaker.enterentityTypeCode("CCMY");
		entitytypemaker.enterentityTypeDesc("DGDGGMY");
		entitytypemaker.selectisActiveEntity();
		entitytypemaker.clickonsubmitInMakerpage();
		entitytypemaker.verifySuccesfullMessage();
	}

	@Test(priority = 3)
	// Checker Page..
     public void chekerlogin() throws Exception {
		entitytypemaker.enterloginid("lastmile7");
		entitytypemaker.enterpassword("password@2");
		entitytypemaker.clickonlogin();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// entitytypemaker.toverifyhomepage();
		Thread.sleep(4000);
		entitytypemaker.clickonMasterDefinitionChecker();
		Thread.sleep(4000);
		entitytypemaker.clickOnAuthoriserEntityTypeCheckerSubMenu();
		entitytypemaker.verifyEntityTypeCheckerPage();

	}

	// in Checker page
	@Test(priority = 4)
	public void verifyAddcheckerListinEntityTypeCheckerpage() throws Exception {
		entitytypemaker.verifyAddcheckerListInEntityTypeCheckerpage();
		entitytypemaker.HandleTheDynamicVluesWithCheckbox();
		 
	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {

		entitytypemaker.clickonsubmitbuttonOnCheckerPage();
		entitytypemaker.toverifysuccessfulMessageOnCheckerPageWhenModify();
	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerHasApprovedEntityTypepage() throws Exception {
		// click on log out checker Button .
		entitytypemaker.gotoMakerPagewhenCheckerhasApprovedEntityTYpeMaker();
		// here we call the driver because the without can not Automate
		entitytypemaker = new AddEntityTypeMaker(driver);
		entitytypemaker.enterloginid("lastmile6");
		entitytypemaker.enterpassword("password@1");
		entitytypemaker.clickonlogin();
		Thread.sleep(5000);
		//entitytypemaker.toverifyhomepage();
		Thread.sleep(5000);
		entitytypemaker.clikonmasterdefinitionmakerMenu();
		entitytypemaker.clickonAddEntityTypeMakerSubMenu();
		entitytypemaker.toswitchFieldsareinmandatory();
		entitytypemaker.clickOnviewButtoninMakerPage();
		entitytypemaker.switchToNewWindow(1);
		entitytypemaker.verifyViewpagesBySrachField();
		entitytypemaker.multippleSelectVerifyTextInViewPage();
		// Thread.sleep(5000);
		entitytypemaker.selectAllvaluesOneByOneOnMakerViewPage();
		// currencypage.switchToWindowByUsingIterator();

	}

	// this one is not working
	//
	@Test(priority = 7)
	public void switchToWindowByUsingIterator() throws Exception {
		// currencypage.switchToWindowByUsingIterator();
	}

	// switch To Main window Country Modify Maker
	// Switch the Child window (Entity view page ) To parent window(Entity Maker
	// page)
	@Test(priority = 8)
	public void switchToMainwindow() throws Exception {
		// switch view page to Maker page and click on Modify button.
		entitytypemaker.switch2();
		// old code
		// entitytypemaker.selectcountryCodeInModifyMakerPage();
		entitytypemaker.selectEntityTypeDropDownInModifyMakerPageByUsingSplitAsPerAddingValue();
		// click on first Submit button
		entitytypemaker.clickOnsubmitbutton();
		// modify Submit Button
		Thread.sleep(5000);
		entitytypemaker.clickmodifysubmitbutton();
		Thread.sleep(5000);
		entitytypemaker.verificationMessageInModifyCountryPage();

	}
// login To Currency Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToCountryChecker() throws Exception {
		entitytypemaker.enterloginid("lastmile7");
		entitytypemaker.enterpassword("password@2");
		entitytypemaker.clickonlogin();
		entitytypemaker.clickonMasterDefinitionChecker();
		entitytypemaker.clickOnAuthoriserEntityTypeCheckerSubMenu();
		entitytypemaker.verifyEntityTypeCheckerPage();

	}

	@Test(priority = 10)
	// calling
	// verify Country checker Page List After Modification has Done By Maker
	public void verifyCountrycheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		// in Cheker page when Modification has done By Maker
		entitytypemaker.verifyEntityTypeIncheckerListWhenModificationhasDoneByMaker();
		entitytypemaker.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		// old code
		// currencypage.clickonsubmitbuttonAndverifySuccesfullMessageIfModifytheCountry();
		entitytypemaker.clickonsubmitbuttonOnCheckerPage();
		entitytypemaker.toverifysuccessfulMessageOnCheckerPageWhenModify();
	}

	@Test(priority = 11)
	// go To The Country Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheCountryMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		entitytypemaker.gotoMakerPagewhenCheckerhasApprovedEntityTYpeMaker();
		entitytypemaker = new AddEntityTypeMaker(driver);
		entitytypemaker.enterloginid("lastmile6");
		entitytypemaker.enterpassword("password@1");
		entitytypemaker.clickonlogin();
		Thread.sleep(5000);
		//entitytypemaker.toverifyhomepage();
		Thread.sleep(5000);
		entitytypemaker.clikonmasterdefinitionmakerMenu();
		entitytypemaker.clickonAddEntityTypeMakerSubMenu();
		entitytypemaker.toswitchFieldsareinmandatory();
		entitytypemaker.clickOnviewButtoninMakerPage();
		entitytypemaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		entitytypemaker.verifyViewpagesBySearchFieldWhenModifyAndApprovedDoneByChecker();
		Thread.sleep(5000);
		entitytypemaker.toVerifyTextInViewMakerPagewhenModified();
		Thread.sleep(5000);
		entitytypemaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To ADD COUNTRY MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToADDCOUNTRYMAKERPage() throws Exception {
		Thread.sleep(5000);
		entitytypemaker.SwitchTheWindowFrom3ChildToParent();
		entitytypemaker.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testloginToCountryCheckerToVerifyCheckerViewPageWhenModifedTheCountry() throws Throwable {
		entitytypemaker.enterloginid("lastmile7");
		entitytypemaker.enterpassword("password@2");
		entitytypemaker.clickonlogin();
		entitytypemaker.clickonMasterDefinitionChecker();
		entitytypemaker.clickOnAuthoriserEntityTypeCheckerSubMenu();
		entitytypemaker.verifyEntityTypeCheckerPage();
		entitytypemaker.clickOnviewInChecker();
		driver.manage().window().maximize();
		entitytypemaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		entitytypemaker.verifyViewpagesBySearchFieldWhenModifyAndApprovedDoneByChecker();
		entitytypemaker.toVerifyTextInViewMakerPagewhenModified();
		entitytypemaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		entitytypemaker.SwitchTheWindowFrom4ChildToParent();
		entitytypemaker.clickOnlogoutCheckerButton();
	}

}
