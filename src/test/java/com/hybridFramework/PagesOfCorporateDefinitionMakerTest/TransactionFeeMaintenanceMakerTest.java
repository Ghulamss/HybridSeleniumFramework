package com.hybridFramework.PagesOfCorporateDefinitionMakerTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PagesOfCorporateDefinitionMaker.TransactionFeeMaintenanceMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;


public class TransactionFeeMaintenanceMakerTest extends TestBase {
	TransactionFeeMaintenanceMaker transactionfeemaintenance;

	private final Logger log = LoggerHelper.getLogger(TransactionFeeMaintenanceMakerTest.class);

	@Test(priority = 1)
	public void testLoginToTransactionFeeMaintenanceMaker() throws InterruptedException {
		log.info(TransactionFeeMaintenanceMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		transactionfeemaintenance = new TransactionFeeMaintenanceMaker(driver);
		// Test_maker1,password@1,Test_maker1==password@1
		transactionfeemaintenance.enterloginid("Test_maker1");
		transactionfeemaintenance.enterpassword("password@1");
		transactionfeemaintenance.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAddTransactionFeeMaintenanceMaker() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		transactionfeemaintenance.toverifyhomepage();
		transactionfeemaintenance.clickonCorporateDefinitionMakerMenu();
		transactionfeemaintenance.clickonTransactionFeeMaintenanceMakerSubMenu();
		transactionfeemaintenance.toswitchFieldsareinmandatory();
		transactionfeemaintenance.CorporateIDFromDropDownByUsingStringArray();
		transactionfeemaintenance.selectCountry();
		transactionfeemaintenance.selectbillPlanType();
		transactionfeemaintenance.selectMandateCodeDropDown();
		transactionfeemaintenance.selectEffectiveDate();
		transactionfeemaintenance.selectisGroupFeeApplicableDropDown();
		transactionfeemaintenance.entergroupTxnFee("5000");
		transactionfeemaintenance.selectisCorporateFeeAppliableDropDOwn();
		transactionfeemaintenance.entercorporateTxnFee("50");
		transactionfeemaintenance.selectreturnChargesFlagDropDOwn();
		transactionfeemaintenance.enterreturnCharges("10");
		transactionfeemaintenance.entervat("100");
		transactionfeemaintenance.entercommissionAccount("100");
		transactionfeemaintenance.selectisActivecorporateFeeMaintenance();
		
		
		transactionfeemaintenance.clickonsubmitInMakerpage();
		transactionfeemaintenance.verifySuccessfulMessageOnMakerPage();
		transactionfeemaintenance.clickOnLogOutButton();
	}

	@Test(priority = 3)
	public void loginToTransactionFeeMaintenanceChecker() throws Exception {
		//
		transactionfeemaintenance.enterloginid("lastmile7");
		transactionfeemaintenance.enterpassword("password@2");
		transactionfeemaintenance.clickonlogin();
		// transactionfeemaintenance.toverifyhomepage();
		transactionfeemaintenance.clickonCorporateDefinitionCheckerMenu();
		transactionfeemaintenance.clickOnAuthoriserTransactionFeeMaintenanceSubMenu();
		transactionfeemaintenance.verifyCorporateFeeMaintainanceCheckerPage();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListOnTransactionFeeMaintenanceCheckerpage() throws Exception {
		//  Comment due to We have Change the Value of Corporate Id.
		transactionfeemaintenance.verifyChekerPageByTextWhenAddedMaker();
		transactionfeemaintenance.HandleTheDynamicVluesWithCheckboxWhenAdded();

	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessageOnCheckerPage() {

		transactionfeemaintenance.clickonsubmitbuttonAndverifySuccesfullMessage();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerApprovedTransactionFeeMaintenanceMaker() throws Exception {
		transactionfeemaintenance.gotoMakerWhenCheckerHasApproved();
		// here we call the driver because the without can not Automate
		transactionfeemaintenance = new TransactionFeeMaintenanceMaker(driver);
		transactionfeemaintenance.enterloginid("Test_maker1");
		transactionfeemaintenance.enterpassword("password@1");
		transactionfeemaintenance.clickonlogin();
		//Thread.sleep(5000);
		//transactionfeemaintenance.toverifyhomepage();
		Thread.sleep(5000);
		transactionfeemaintenance.clickonCorporateDefinitionMakerMenu();
		transactionfeemaintenance.clickonTransactionFeeMaintenanceMakerSubMenu();
		transactionfeemaintenance.toswitchFieldsareinmandatory();
		transactionfeemaintenance.viewinMakerPage();
		transactionfeemaintenance.switchToNewWindow(1);
		// below is working but i have commented
		transactionfeemaintenance.verifyViewpageBySearchField();
		transactionfeemaintenance.VerifyViewPageByGetText();
		transactionfeemaintenance.selectAllDropDownvaluesOneByOneOnViewPage();

	}

	// switch To Main window Modify Transaction Fee Maintenance Maker
	@Test(priority = 8)
	public void switchToMainwindowAndModifyTransactionFeeMaintenanceMaker() {
		transactionfeemaintenance.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		transactionfeemaintenance.clicKOnModifyButtonAndverifyTheModifiedPage();
		transactionfeemaintenance.selectCOrporateIDDropDownOnModifyPage();
		transactionfeemaintenance.selectcountryCodeInModifyMakerPage();
		transactionfeemaintenance.selectMandateCodeDropDownInModifyPage();
		transactionfeemaintenance.clickOnsubmitbutton();
		transactionfeemaintenance.clickOnLinkOnModifyPageWhenModify();
		
		transactionfeemaintenance.clickmodifysubmitbutton();
		transactionfeemaintenance.verificationMessageInModifyMakerPage();

	}
// login To Transaction Fee Maintenance Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToTransactionFeeMaintenanceCheckerWhenModify() throws Exception {
		transactionfeemaintenance.enterloginid("lastmile7");
		transactionfeemaintenance.enterpassword("password@2");

		transactionfeemaintenance.clickonlogin();
		transactionfeemaintenance.clickonCorporateDefinitionCheckerMenu();
		transactionfeemaintenance.clickOnAuthoriserTransactionFeeMaintenanceSubMenu();
		transactionfeemaintenance.verifyCorporateFeeMaintainanceCheckerPage();

	}

	@Test(priority = 10)
	// verify Transaction Fee Maintenance checker Page List After Modification has
	// Done By Maker
	public void verifyTransactionFeeMaintenanceCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		transactionfeemaintenance.verifyCheckerPageModificationhasDoneByMaker();
		transactionfeemaintenance.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		transactionfeemaintenance.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	}

	@Test(priority = 11)
	// go To The Transaction Fee Maintenance Maker To Verify Checker Has Approved The
	// Modify Data Same
	public void goToThTransactionFeeMaintenanceMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		transactionfeemaintenance.gotoMakerWhenCheckerHasApproved();
		transactionfeemaintenance = new TransactionFeeMaintenanceMaker(driver);
		transactionfeemaintenance.enterloginid("Test_maker1");
		transactionfeemaintenance.enterpassword("password@1");
		transactionfeemaintenance.clickonlogin();
		Thread.sleep(5000);
		transactionfeemaintenance.toverifyhomepage();
		Thread.sleep(5000);
		transactionfeemaintenance.clickonCorporateDefinitionMakerMenu();
		transactionfeemaintenance.clickonTransactionFeeMaintenanceMakerSubMenu();
		transactionfeemaintenance.toswitchFieldsareinmandatory();
		transactionfeemaintenance.viewinMakerPage();
		transactionfeemaintenance.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		transactionfeemaintenance.verifyViewpageBySearchFieldWhenModify();
		// By Verify the particular Text With Column Values
		transactionfeemaintenance.toVerifyByGetTextInViewPageWhenModify();
		transactionfeemaintenance.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToTransactionFeeMaintenanceMakerPage() throws Exception {
		Thread.sleep(5000);
		transactionfeemaintenance.SwitchTheWindowFrom3ChildToParent();
		transactionfeemaintenance.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testToVerifyCheckerViewPageWhenModifedTheTransactionFeeMaintenanceMaker() throws Throwable {
		Thread.sleep(3000);
		transactionfeemaintenance.enterloginid("lastmile7");
		transactionfeemaintenance.enterpassword("password@2");
		transactionfeemaintenance.clickonlogin();
		transactionfeemaintenance.clickonCorporateDefinitionCheckerMenu();
		transactionfeemaintenance.clickOnAuthoriserTransactionFeeMaintenanceSubMenu();
		transactionfeemaintenance.verifyCorporateFeeMaintainanceCheckerPage();
		transactionfeemaintenance.clickOnviewInChecker();
		driver.manage().window().maximize();
		transactionfeemaintenance.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		transactionfeemaintenance.verifyViewpageBySearchFieldWhenModify();
		transactionfeemaintenance.toVerifyByGetTextInViewPageWhenModify();
		transactionfeemaintenance.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		transactionfeemaintenance.SwitchTheWindowFrom4ChildToParent();
		transactionfeemaintenance.clickOnlogoutCheckerButton();
	}

}
