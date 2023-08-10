package com.hybridFramework.AddMaker;

import java.util.Currency;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.AddCurrencyMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddCurrencyMakerTest extends TestBase {
	AddCurrencyMaker currencypage;

	private final Logger log = LoggerHelper.getLogger(Currency.class);

	@Test(priority = 1)
	public void testLoginToApplication() throws InterruptedException {
		log.info(Currency.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		currencypage = new AddCurrencyMaker(driver);
		currencypage.enterloginid("lastmile8");
		currencypage.enterpassword("password@1");
		currencypage.clickonlogin();

	}

	@Test(priority = 2)
	public void testLoginToApplicationEnterCurrencyDataOnMaker() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		//currencypage.toverifyhomepage();
		currencypage.clikonmasterdefinitionmakerMenu();
		currencypage.clickonAddCurrencyMakerSubMenu();
		currencypage.toswitchFieldsareinmandatory();
		currencypage.entercountryCode("INDIg");
		currencypage.enterbdCurrencyCode("Rn");
		currencypage.entercurrency("Rupef");
		currencypage.selectisActiveCurrency();
		currencypage.clickonsubmitInMakerpage();
		currencypage.verifySuccesfullMessage();
	}

	@Test(priority = 3)
	public void loginToAddCurrencyChecker() throws Exception {
		currencypage.enterloginid("lastmile7");
		currencypage.enterpassword("password@2");
		currencypage.clickonlogin();
		// currencypage.toverifyhomepage();
		currencypage.clickonMasterDefinitionChecker();
		currencypage.clickOnAddCurrencyCheckerSubMenu();
		currencypage.verifyCurrencyCheckerPagePages();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListOnCurrencyCheckerpage() throws Exception {
		currencypage.verifyAddcheckerListInCurrencyCheckerpage();
		currencypage.HandleTheDynamicVluesWithCheckbox();

	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() throws Exception {
		Thread.sleep(3000);

		currencypage.clickonsubmitbuttonAndverifySuccesfullMessage();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerHasApprovedCurrencyage() throws Exception {
		// click on log out checker Button .
		currencypage.gotoMakerCheckerApprovedCountry();
		// here we call the driver because the without can not Automate
		currencypage = new AddCurrencyMaker(driver);
		currencypage.enterloginid("lastmile8");
		currencypage.enterpassword("password@1");
		currencypage.clickonlogin();
		Thread.sleep(5000);
		//currencypage.toverifyhomepage();
		Thread.sleep(5000);
		currencypage.clikonmasterdefinitionmakerMenu();
		currencypage.clickonAddCurrencyMakerSubMenu();
		currencypage.toswitchFieldsareinmandatory();
		currencypage.viewinMakerPage();
		currencypage.switchToNewWindow(1);
		currencypage.verifyViewpagesBySrachField();
		currencypage.multippleSelectVerifyTextInViewPage();
		// Thread.sleep(5000);
		currencypage.verifyTheViewPageWithSelectGivenValueOnDropDown();
		// currencypage.switchToWindowByUsingIterator();

	}

	// this one is not working
	//
	@Test(priority = 7)
	public void switchToWindowByUsingIterator() throws Exception {
		// currencypage.switchToWindowByUsingIterator();

	}

	// switch To Main window Country Modify Maker
	// Switch the Child window (Currency view page ) To parent window(Currency Maker
	// page)
	@Test(priority = 8)
	public void switchToMainwindow() throws Exception {
		currencypage.switch2();

		// currencypage.selectcCurrencyCodeInModifyMakerPage();
		currencypage.selectcountryCodeInModifyMakerPageByUsingSplitAsPerAddingValue();
		currencypage.clickOnsubmitbutton();
		// modify Submit Button
		Thread.sleep(5000);
		currencypage.clickmodifysubmitbutton();
		Thread.sleep(5000);
		currencypage.verificationMessageInModifyCurrencyPage();

	}
// login To Currency Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToCurrencyChecker() throws Exception {
		currencypage.enterloginid("lastmile7");
		currencypage.enterpassword("password@2");

		currencypage.clickonlogin();
		currencypage.clickonMasterDefinitionChecker();
		currencypage.clickOnAddCurrencyCheckerSubMenu();
		currencypage.verifyCurrencyCheckerPagePages();

	}

	@Test(priority = 10)
	// verify Country checker Page List After Modification has Done By Maker
	public void verifyCurrencyCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		currencypage.verifyCurrencycheckerListModificationhasDoneByMaker();
		currencypage.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
       currencypage.clickonsubmitbuttonAndverifySuccesfullMessageIfModifytheCountry();
	}

	@Test(priority = 11)
	// go To The Currency Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheCurrencyMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		currencypage.gotoMakerCheckerApprovedCountry();
		currencypage = new AddCurrencyMaker(driver);
		currencypage.enterloginid("lastmile8");
		currencypage.enterpassword("password@1");
		currencypage.clickonlogin();
		Thread.sleep(5000);
		//currencypage.toverifyhomepage();
		Thread.sleep(5000);
		currencypage.clikonmasterdefinitionmakerMenu();
		currencypage.clickonAddCurrencyMakerSubMenu();
		currencypage.toswitchFieldsareinmandatory();
		currencypage.viewinMakerPage();
		currencypage.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		currencypage.verifyViewpagesWhenModifyTheCurrencyAndApprovedDoneByChecker();
		// By Verify the particular Text With Column Values
		currencypage.toVerifyTextInViewPageWithHeaderColumn();
		currencypage.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To ADD Currency MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToAddCurrencyMkaerPage() throws Exception {
		Thread.sleep(5000);
		currencypage.SwitchTheWindowFrom3ChildToParent();
		currencypage.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testloginToCurrencyCheckerToVerifyCheckerViewPageWhenModifedTheCurrency() throws Throwable {
		currencypage.enterloginid("lastmile7");
		currencypage.enterpassword("password@2");
		currencypage.clickonlogin();
		currencypage.clickonMasterDefinitionChecker();
		currencypage.clickOnAddCurrencyCheckerSubMenu();
		currencypage.verifyCurrencyCheckerPagePages();
		currencypage.clickOnviewInChecker();
		driver.manage().window().maximize();
		currencypage.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		currencypage.verifyViewpagesWhenModifyTheCurrencyAndApprovedDoneByChecker();
		currencypage.toVerifyTextInViewPageWithHeaderColumn();
		currencypage.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		currencypage.SwitchTheWindowFrom4ChildToParent();
		//currencypage.clickOnlogoutCheckerButton();
	}

}
