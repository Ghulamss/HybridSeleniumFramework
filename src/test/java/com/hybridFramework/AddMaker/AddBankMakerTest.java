package com.hybridFramework.AddMaker;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.AddBankMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddBankMakerTest extends TestBase {
	AddBankMaker bankmaker;

	private final Logger log = LoggerHelper.getLogger(AddBankMakerTest.class);

	@Test(priority = 1)
	public void testLoginToAddBankMaker() throws InterruptedException {
		log.info(AddBankMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		bankmaker = new AddBankMaker(driver);
		bankmaker.enterloginid("lastmile6");
		bankmaker.enterpassword("password@1");
		bankmaker.clickonlogin();
		
		//bankmaker.launchBrowser();

	}

	@Test(priority = 2)
	public void testToAddBankMakerPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		//bankmaker.toverifyhomepage();
		bankmaker.clikonmasterdefinitionmakerMenu();
		bankmaker.clickonAddBankMakerSubMenu();
		bankmaker.toswitchFieldsareinmandatory();
		bankmaker.enterBankId("BIdCN");
		bankmaker.enterBankName("PndADM");
		bankmaker.enterEmail("ghu1231C@gmail.com");
		bankmaker.selectisActiveBank();
		bankmaker.clickonsubmitInMakerpage();
		bankmaker.verifySuccesfullMessage();
	}

	@Test(priority = 3)
	public void testToBankchekerlogin() throws Exception {
		bankmaker.enterloginid("lastmile7");
		bankmaker.enterpassword("password@2");
		bankmaker.clickonlogin();
		// bankmaker.toverifyhomepage();
		bankmaker.clickonMasterDefinitionChecker();
		bankmaker.clickOnAddBankCheckerSubMenu();
		bankmaker.verifyBankCheckerPage();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListinBankCheckerpage() throws Exception {
		bankmaker.verifyAddcheckerListOnBankCheckerpage();
		bankmaker.HandleTheDynamicVluesWithCheckbox();
		 
	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() throws Exception {
		Thread.sleep(3000);
     bankmaker.clickonsubmitbuttonAndverifySuccesfullMessage();
}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerApprovedBankMakerpage() throws Exception {
		// click on log out checker Button .
		bankmaker.gotoMakerPageWhenCheckerApproved();
		// here we call the driver because the without can not Automate
		bankmaker = new AddBankMaker(driver);
		bankmaker.enterloginid("lastmile6");
		bankmaker.enterpassword("password@1");
		bankmaker.clickonlogin();
		Thread.sleep(5000);
		//bankmaker.toverifyhomepage();
		Thread.sleep(5000);
		bankmaker.clikonmasterdefinitionmakerMenu();
		bankmaker.clickonAddBankMakerSubMenu();
		bankmaker.toswitchFieldsareinmandatory();
		bankmaker.viewinMakerPage();
		bankmaker.switchToNewWindow(1);
		bankmaker.verifyViewpagesBySrachField();
		bankmaker.VerifyViewPageByTextField();
		// Thread.sleep(5000);
		bankmaker.verifyTheViewPageWithSelectGivenValueOnDropDown();
		// bankmaker.switchToWindowByUsingIterator();
	}

	
	// switch To Main window Bank Maker Modify Maker
	// Switch the Child window (Bank Maker view page ) To parent window(Bank Maker
	// page)
	@Test(priority = 7)
	public void switchToMainwindow() throws Exception {
		bankmaker.switch2();

		// bankmaker.selectcCurrencyCodeInModifyMakerPage();
		bankmaker.selectBankIdInModifyMakerPageByUsingSplitAsPerAddingValue();
		bankmaker.clickOnsubmitbutton();
		// modify Submit Button
		Thread.sleep(5000);
		bankmaker.clickmodifysubmitbutton();
		Thread.sleep(5000);
		bankmaker.verificationMessageInModifyCurrencyPage();

	}
// login To Bank Checker if Modify the Same data 

	@Test(priority = 8)
	public void testloginToBankCheckerPage() throws Exception {
		bankmaker.enterloginid("lastmile7");
		bankmaker.enterpassword("password@2");

		bankmaker.clickonlogin();
		bankmaker.clickonMasterDefinitionChecker();
		bankmaker.clickOnAddBankCheckerSubMenu();
		bankmaker.verifyBankCheckerPage();

	}

	@Test(priority = 9)
	// verify Bank checker Page List After Modification has Done By Maker
	public void verifyBankCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		bankmaker.verifyCurrencycheckerListModificationhasDoneByMaker();
		bankmaker.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		 
		bankmaker.clickonsubmitbuttonAndverifySuccesfullMessageIfModifyBankMaker();
	}

	@Test(priority = 10)
	// go To The Bank Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheBankMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		bankmaker.gotoMakerPageWhenCheckerApproved();
		bankmaker = new AddBankMaker(driver);
		bankmaker.enterloginid("lastmile6");
		bankmaker.enterpassword("password@1");
		bankmaker.clickonlogin();
		Thread.sleep(5000);
		//bankmaker.toverifyhomepage();
		Thread.sleep(5000);
		bankmaker.clikonmasterdefinitionmakerMenu();
		bankmaker.clickonAddBankMakerSubMenu();
		bankmaker.toswitchFieldsareinmandatory();
		bankmaker.viewinMakerPage();
		bankmaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		bankmaker.verifyViewpagesBySearchFieldWhenModifyAndApprovedDoneByChecker();
		// By Verify the particular Text With Column Values
		bankmaker.toVerifyTextInViewPageWithHeaderColumn();
		bankmaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 11)
	// switch To window Modify View Page To ADD Currency MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToAddBankMakerPage() throws Exception {
		Thread.sleep(5000);
		bankmaker.SwitchTheWindowFrom3ChildToParent();
		bankmaker.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 12)
	public void testloginToBankCheckerToVerifyCheckerViewPageWhenModifedTheBankMaker() throws Throwable {
		bankmaker.enterloginid("lastmile7");
		bankmaker.enterpassword("password@2");
		bankmaker.clickonlogin();
		bankmaker.clickonMasterDefinitionChecker();
		bankmaker.clickOnAddBankCheckerSubMenu();
		bankmaker.verifyBankCheckerPage();
		bankmaker.clickOnviewInChecker();
		driver.manage().window().maximize();
		bankmaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		bankmaker.verifyViewpagesBySearchFieldWhenModifyAndApprovedDoneByChecker();
		bankmaker.toVerifyTextInViewPageWithHeaderColumn();
		bankmaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		bankmaker.SwitchTheWindowFrom4ChildToParent();
		bankmaker.clickOnlogoutCheckerButton();
	}

}
