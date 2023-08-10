package com.hybridFramework.AddMaker;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.AddPaymentTypeMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddPaymentTypeMakerTest extends TestBase {
	AddPaymentTypeMaker addpaymenttypemaker;

	private final Logger log = LoggerHelper.getLogger(AddPaymentTypeMakerTest.class);

	@Test(priority = 1)
	public void testLoginToAddPaymentTypeMaker() throws InterruptedException {
		log.info(AddPaymentTypeMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		addpaymenttypemaker = new AddPaymentTypeMaker(driver);
		addpaymenttypemaker.enterloginid("lastmile6");
		addpaymenttypemaker.enterpassword("password@1");
		addpaymenttypemaker.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAddPaymentTypeMakerPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		addpaymenttypemaker.toverifyhomepage();
		addpaymenttypemaker.clikonmasterdefinitionmakerMenu();
		addpaymenttypemaker.clickonAddPaymentTypeMakerSubMenu();
		addpaymenttypemaker.toswitchFieldsareinmandatory();
		addpaymenttypemaker.enterPaymentCode("CBA");
		addpaymenttypemaker.enterfilePaymentID("ABA");
		addpaymenttypemaker.enterpaymentDesc("EBAA");
		addpaymenttypemaker.selectisActivePayment();
		addpaymenttypemaker.clickonsubmitInMakerpage();
		addpaymenttypemaker.verifySuccesfullMessage();
	}

	@Test(priority = 3)
	// Checker Page..
	public void chekerlogin() throws Exception {
		addpaymenttypemaker.enterloginid("lastmile7");
		addpaymenttypemaker.enterpassword("password@2");
		addpaymenttypemaker.clickonlogin();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// addpaymenttypemaker.toverifyhomepage();
		Thread.sleep(4000);
		addpaymenttypemaker.clickonMasterDefinitionChecker();
		Thread.sleep(4000);
		addpaymenttypemaker.clickOnAuthoriserPaymentTypeSubMenu();
		addpaymenttypemaker.verifyPaymentTypeCheckerPages();

	}

	// in Checker page
	@Test(priority = 4)
	public void verifyAddcheckerListinPaymentTypeCheckerpage() throws Exception {
		addpaymenttypemaker.verifyAddcheckerListInPaymentTypeCheckerpage();
		addpaymenttypemaker.HandleTheDynamicVluesWithCheckbox();
	}

	// in Checker page
	@Test(priority = 5)
	// click on submit Button and verify Message.
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {
		addpaymenttypemaker.clickonsubmitbuttonInPaymentTYPECHECKERPage();
		addpaymenttypemaker.toverifysuccessfulMessageinPaymentTypeCheckerPage();
	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerCheckerApprovedCountrypage() throws Exception {
		// click on log out checker Button .
		addpaymenttypemaker.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
		// here we call the driver because the without can not Automate
		addpaymenttypemaker = new AddPaymentTypeMaker(driver);
		addpaymenttypemaker.enterloginid("lastmile6");
		addpaymenttypemaker.enterpassword("password@1");
		addpaymenttypemaker.clickonlogin();
		Thread.sleep(5000);
		addpaymenttypemaker.toverifyhomepage();
		Thread.sleep(5000);
		addpaymenttypemaker.clikonmasterdefinitionmakerMenu();
		addpaymenttypemaker.clickonAddPaymentTypeMakerSubMenu();
		addpaymenttypemaker.toswitchFieldsareinmandatory();
		addpaymenttypemaker.clickOnviewButtoninMakerPage();
		addpaymenttypemaker.switchToNewWindow(1);
		addpaymenttypemaker.verifyViewpageBySearchField();
		addpaymenttypemaker.multippleSelectVerifyTextInViewPage();
		// Thread.sleep(5000);
		addpaymenttypemaker.selectAllvaluesOneByOneFromDropDown();
		// currencypage.switchToWindowByUsingIterator();

	}

	// this one is not working
	@Test(priority = 7)
	public void switchToWindowByUsingIterator() throws Exception {
		// currencypage.switchToWindowByUsingIterator();
	}

	// switch To Main window Payment Modify Maker
	// Switch the Child window (PaymentTypeMaker view page ) To parent
	// window(Payment Type Maker Maker
	// page)
	@Test(priority = 8)
	public void switchToMainwindowFromViewPageToMakerPage() throws Exception {
		// switch view page to Maker page and click on Modify button.
		addpaymenttypemaker.switch2();
		// old code
		// addpaymenttypemaker.selectPaymentCodeInModifyPaymentTypeMakerPage();
		addpaymenttypemaker.selectPaymentCodeInModifyMakerPageByUsingSplitAsPerAddingValue();
		// click on first Submit button
		addpaymenttypemaker.clickOnsubmitbutton();
		// modify Submit Button
		Thread.sleep(5000);
		addpaymenttypemaker.clickmodifysubmitbutton();
		Thread.sleep(5000);
		addpaymenttypemaker.verificationMessageInModifyPaymentTypePage();

	}

	// login To payment type Checker if Modify the Same data
	// go to the CHecker Page.and verify the checker page.
	@Test(priority = 9)
	public void testloginToPaymentCheckerPage() throws Exception {
		addpaymenttypemaker.enterloginid("lastmile7");
		addpaymenttypemaker.enterpassword("password@2");
		addpaymenttypemaker.clickonlogin();
		addpaymenttypemaker.clickonMasterDefinitionChecker();
		addpaymenttypemaker.clickOnAuthoriserPaymentTypeSubMenu();
		addpaymenttypemaker.verifyPaymentTypeCheckerPages();

	}

	@Test(priority = 10)
	// calling
	// verify Payment Type checker Page List After Modification has Done By Maker
	public void verifyPaymentCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		// in Cheker page when Modification has done By Maker
		addpaymenttypemaker.verifyListOfPaymentTypeIncheckerWhenModificationhasDoneByMaker();
		addpaymenttypemaker.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		addpaymenttypemaker.clickonsubmitbuttonInPaymentTYPECHECKERPage();
		addpaymenttypemaker.toverifysuccessfulMessageinPaymentTypeCheckerPage();
	}

	@Test(priority = 11)
	// go To The Country Maker To Verify Checker Has Approved The Modify Data Same
	public void goToThePaymentMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		addpaymenttypemaker.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
		addpaymenttypemaker = new AddPaymentTypeMaker(driver);
		addpaymenttypemaker.enterloginid("lastmile6");
		addpaymenttypemaker.enterpassword("password@1");
		addpaymenttypemaker.clickonlogin();
		Thread.sleep(5000);
		addpaymenttypemaker.toverifyhomepage();
		Thread.sleep(5000);
		addpaymenttypemaker.clikonmasterdefinitionmakerMenu();
		addpaymenttypemaker.clickonAddPaymentTypeMakerSubMenu();
		addpaymenttypemaker.toswitchFieldsareinmandatory();
		addpaymenttypemaker.clickOnviewButtoninMakerPage();
		addpaymenttypemaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		addpaymenttypemaker.verifyViewpageBySearchFieldWhenModifyAndApprovedDoneByChecker();
		// By Verify the particular Text With Column Values
		Thread.sleep(5000);
		addpaymenttypemaker.toVerifyTextInViewMakerPagewhenModified();
		Thread.sleep(5000);
		addpaymenttypemaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To ADD Payment Type MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToPaymentTypePage() throws Exception {
		Thread.sleep(5000);
		addpaymenttypemaker.SwitchTheWindowFrom3ChildToParent();
		addpaymenttypemaker.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testloginToPaymentCheckerToVerifyCheckerViewPageWhenModifedThePaymentType() throws Throwable {
		addpaymenttypemaker.enterloginid("lastmile7");
		addpaymenttypemaker.enterpassword("password@2");
		addpaymenttypemaker.clickonlogin();
		addpaymenttypemaker.clickonMasterDefinitionChecker();
		addpaymenttypemaker.clickOnAuthoriserPaymentTypeSubMenu();
		addpaymenttypemaker.verifyPaymentTypeCheckerPages();
		addpaymenttypemaker.clickOnviewInChecker();
		driver.manage().window().maximize();
		addpaymenttypemaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		addpaymenttypemaker.verifyViewpageBySearchFieldWhenModifyAndApprovedDoneByChecker();
		addpaymenttypemaker.toVerifyTextInViewMakerPagewhenModified();
		// Thread.sleep(5000);
		addpaymenttypemaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		addpaymenttypemaker.SwitchTheWindowFrom4ChildToParent();
		addpaymenttypemaker.clickOnlogoutCheckerButton();
	}

//	@Test(priority = 14)
//	public void testloginToPaymentMakerToModifythePayment() throws Throwable {
//
//	}
}
