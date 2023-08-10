package com.hybridFramework.AddMaker;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.AddCountryMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.loginPage.LoginTest;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddCountryMakerTest extends TestBase {
	AddCountryMaker loginPage;

	private final Logger log = LoggerHelper.getLogger(LoginTest.class);

	@Test(priority = 1)
	public void testLoginToApplication() throws InterruptedException {
		log.info(LoginTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		loginPage = new AddCountryMaker(driver);
		loginPage.enterloginid("lastmile8");
		loginPage.enterpassword("password@1");
        loginPage.clickonlogin();

		}

	@Test(priority = 2)
	public void testLoginToApplication2() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		//loginPage.toverifyhomepage();
		loginPage.clikonmasterdefinitionmakerMenu();
		loginPage.clickonaddcountrymakerSubMenu();
		loginPage.toswitchFieldsareinmandatory();
		loginPage.entercountry("myCo");
		loginPage.enterisoCountryCode("CD");
		loginPage.selectcountryflag();
		loginPage.selectisActiveCountry();
		loginPage.clickonsubmitInMakerpage();
		loginPage.verifySuccesfullMessageOnAddMakerPage();
		loginPage.ClickOnLogOutButtonOnAddMakerPage();
	}

	@Test(priority = 3)
	public void toLoginTheChekerPage() throws Exception {
		loginPage.enterloginid("test_checker3");
		loginPage.enterpassword("password@1");
		loginPage.clickonlogin();
		// loginPage.toverifyhomepage();
		loginPage.clickonMasterDefinitionChecker();
		loginPage.clickOnAddCountryCheckerSubMenu();
		loginPage.verifyCountryCheckerPages();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListinCountryCheckerpage() throws Exception {
		loginPage.verifyAddcheckerList();
		Thread.sleep(5000);
		loginPage.HandleTheDynamicVluesWithCheckbox();
		
	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() throws InterruptedException {
        Thread.sleep(5000);
		loginPage.clickonsubmitbuttonCheckerPage();
		loginPage.verifySuccesfullMessageOnCheckerPage();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerCheckerApprovedCountrypage() throws Exception {
		loginPage.gotoMakerCheckerApprovedCountry();
		// here we call the driver because the without can not Automate
		loginPage = new AddCountryMaker(driver);
		loginPage.enterloginid("lastmile6");
		loginPage.enterpassword("password@1");
		loginPage.clickonlogin();
		Thread.sleep(5000);
		//loginPage.toverifyhomepage();
		Thread.sleep(5000);
		loginPage.clikonmasterdefinitionmakerMenu();
		loginPage.clickonaddcountrymakerSubMenu();
		loginPage.toswitchFieldsareinmandatory();
		loginPage.viewinMakerPage();
		loginPage.switchToNewWindow(1);
		loginPage.verifyViewpageBySerachField();
		loginPage.multippleSelectVerifyTextInViewPage();
		Thread.sleep(5000);
		loginPage.selectAllvaluesOneByOne();

	}

	// this one is not working
	//
	@Test(priority = 7)
	public void switchToWindowByUsingIterator() throws Exception {
		// loginPage.switchToWindowByUsingIterator();
	}

	// switch To Main window Country Modify Maker
	@Test(priority = 8)
	public void switchToMainwindow() {
		loginPage.switch2();
		loginPage.selectcountryCodeInModifyMakerPageByUsingSplitAsPerAddingValue();
         // old code
		// loginPage.selectcountryCodeInModifyMakerPage();
		loginPage.clickOnsubmitbutton();
		 loginPage. clickmodifysubmitbutton();
		loginPage.verificationMessageInModifyCountryPage();
		loginPage.clickOnLogOutButtonOnModifyMakerPage();

	}
// login To Country Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToCountryChecker() throws Exception {
		loginPage.enterloginid("test_checker3");
		loginPage.enterpassword("password@1");

		loginPage.clickonlogin();
		loginPage.clickonMasterDefinitionChecker();
		loginPage.clickOnAddCountryCheckerSubMenu();
		loginPage.verifyCountryCheckerPages();

	}

	@Test(priority = 10)
	// verify Country checker Page List After Modification has Done By Maker
	public void verifyCountrycheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		loginPage.verifyCountrycheckerListModificationhasDoneByMaker();
		loginPage.selectThecheckboxOnCheckerPageWhenModify();
		loginPage.clickonsubmitbuttonAndverifySuccesfullMessageIfModifytheCountry();
	}

	@Test(priority = 11)
	// go To The Country Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheCountryMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		loginPage.gotoMakerCheckerApprovedCountry();
		loginPage = new AddCountryMaker(driver);
		loginPage.enterloginid("lastmile6");
		loginPage.enterpassword("password@1");
		loginPage.clickonlogin();
		Thread.sleep(5000);
		//loginPage.toverifyhomepage();
		Thread.sleep(5000);
		loginPage.clikonmasterdefinitionmakerMenu();
		loginPage.clickonaddcountrymakerSubMenu();
		loginPage.toswitchFieldsareinmandatory();
		loginPage.viewinMakerPage();
		loginPage.switchToNewWindow(1);
		
		loginPage.verifyViewpageBySerachField();
		loginPage.multippleSelectVerifyTextInViewPage();
		Thread.sleep(5000);
		loginPage.selectAllvaluesOneByOne();

	}

	
	@Test(priority = 12)
	// switch To window Modify View Page To ADD COUNTRY MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToADDCOUNTRYMAKERPage() throws Exception {
		Thread.sleep(5000);
		loginPage.SwitchTheWindowFrom3ChildToParent();
		loginPage.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testloginToCountryCheckerToVerifyCheckerViewPageWhenModifedTheCountry() throws Throwable {
		loginPage.enterloginid("test_checker3");
		loginPage.enterpassword("password@1");
		loginPage.clickonlogin();
		loginPage.clickonMasterDefinitionChecker();
		loginPage.clickOnAddCountryCheckerSubMenu();
		loginPage.verifyCountryCheckerPages();
		loginPage.clickOnviewInChecker();
		driver.manage().window().maximize();
		loginPage.switchToNewWindow(1);
		loginPage.verifyViewpageBySerachField();
		loginPage.multippleSelectVerifyTextInViewPage();
		// Thread.sleep(5000);
		loginPage.selectAllvaluesOneByOne();
		loginPage.SwitchTheWindowFrom4ChildToParent();
		//loginPage.clickOnlogoutCheckerButton();
	}

}
