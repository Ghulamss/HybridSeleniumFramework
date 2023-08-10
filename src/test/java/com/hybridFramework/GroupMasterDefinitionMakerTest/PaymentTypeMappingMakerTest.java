package com.hybridFramework.GroupMasterDefinitionMakerTest;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.hybridFramework.GroupMasterDefinitionMaker.PaymentTypeMappingMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class PaymentTypeMappingMakerTest extends TestBase {
	PaymentTypeMappingMaker paymenttypemapping;

	private final Logger log = LoggerHelper.getLogger(PaymentTypeMappingMakerTest.class);

	@Test(priority = 1)
	public void testLoginToPaymentTypeMappingMaker() throws InterruptedException {
		log.info(PaymentTypeMappingMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		paymenttypemapping = new PaymentTypeMappingMaker(driver);
		// Test_maker1,password@1,Test_maker1==password@1
		paymenttypemapping.enterloginid("Test_maker1");
		paymenttypemapping.enterpassword("password@1");
		paymenttypemapping.clickonlogin();

	}

	@Test(priority = 2)
	public void testToPaymentTypeMappingMakerPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		paymenttypemapping.toverifyhomepage();
		paymenttypemapping.clickonGroupMasterDefinitionMakerMenu();
		paymenttypemapping.clickonPaymentTypeMappingMakerSubMenu();
		paymenttypemapping.toswitchFieldsareinmandatory();
		// Thread.sleep(5000);
		paymenttypemapping.selectGroupCountry();
		paymenttypemapping.selectPaymentCodeFromDropDownByUsingStringArray();
		paymenttypemapping.selectisActiveGroupCountryPaymentTypeMaker();
		paymenttypemapping.clickonsubmitInMakerpage();
		paymenttypemapping.verifySuccessfulMessageOnMakerPage();
	}

	@Test(priority = 3)
	public void loginToPaymentTypeMappingChecker() throws Exception {
		paymenttypemapping.enterloginid("lastmile7");
		paymenttypemapping.enterpassword("password@2");
		paymenttypemapping.clickonlogin();
		// paymenttypemapping.toverifyhomepage();
		paymenttypemapping.clickonGroupMasterDefinitionCheckerMenu();
		paymenttypemapping.clickOnAuthoriserPaymentTypeMappingSubMenu();
		paymenttypemapping.verifyGroupCountryPaymentTypeCheckerPage();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListinGroupCountryPaymentTypeCheckerpage() throws Exception {
		// below is working but for not Array list , previous master definition concept.
		// paymenttypemapping.verifyAddcheckerListByUsingArraysToStringandSubStringToString();
		// below is for array List
		paymenttypemapping.verifyListOfGetTextOnAddcheckerPage();
		paymenttypemapping.HandleTheDynamicVluesWithCheckbox();

	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {

		paymenttypemapping.clickonsubmitbuttonAndverifySuccesfullMessage();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerCheckerApprovedCountrypage() throws Exception {
		// means click on Log Out Button On checker Page.
		paymenttypemapping.gotoMakerCheckerHasApproved();
		// here we call the driver because the without can not Automate
		paymenttypemapping = new PaymentTypeMappingMaker(driver);
		paymenttypemapping.enterloginid("Test_maker1");
		paymenttypemapping.enterpassword("password@1");
		paymenttypemapping.clickonlogin();
		Thread.sleep(5000);
		paymenttypemapping.toverifyhomepage();
		Thread.sleep(5000);
		paymenttypemapping.clickonGroupMasterDefinitionMakerMenu();
		paymenttypemapping.clickonPaymentTypeMappingMakerSubMenu();
		paymenttypemapping.toswitchFieldsareinmandatory();
		paymenttypemapping.viewinMakerPage();
		paymenttypemapping.switchToNewWindow(1);
		// below is working but i have commented
		paymenttypemapping.verifyViewpageBySearchField();
		paymenttypemapping.VerifyViewPageByGetText();
		paymenttypemapping.selectAllvaluesOneByOne();

	}

	// switch To Main window Country Modify Maker
	@Test(priority = 8)
	public void switchToMainwindow() {
		paymenttypemapping.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		paymenttypemapping.verifyTheModifiedPage();
		paymenttypemapping.selectcountryCodeInModifyMakerPage();
		paymenttypemapping.selectPaymentTypeDropDownOnModifyPage();
		paymenttypemapping.clickOnsubmitbutton();
		paymenttypemapping.clickmodifysubmitbutton();
		paymenttypemapping.verificationMessageInModifyGroupCountryPaymentTypeMakerPage();

	}
// login To Country Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToGroupCountryPaymentTypeChecker() throws Exception {
		paymenttypemapping.enterloginid("lastmile7");
		paymenttypemapping.enterpassword("password@2");

		paymenttypemapping.clickonlogin();
		paymenttypemapping.clickonGroupMasterDefinitionCheckerMenu();
		paymenttypemapping.clickOnAuthoriserPaymentTypeMappingSubMenu();
		paymenttypemapping.verifyGroupCountryPaymentTypeCheckerPage();

	}

	@Test(priority = 10)
	// verify Group Country Payment Type checker Page List After Modification has Done By Maker
	public void verifyGroupCountryPaymentTypeCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		paymenttypemapping.verifyGroupCountryPaymentTypecheckerPageModificationhasDoneByMaker();
		paymenttypemapping.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		paymenttypemapping.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	}

	@Test(priority = 11)
	// go To The Group Country Payment Type Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheGroupCountryPaymentTypeMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		paymenttypemapping.gotoMakerCheckerHasApproved();
		paymenttypemapping = new PaymentTypeMappingMaker(driver);
		paymenttypemapping.enterloginid("Test_maker1");
		paymenttypemapping.enterpassword("password@1");
		paymenttypemapping.clickonlogin();
		Thread.sleep(5000);
		paymenttypemapping.toverifyhomepage();
		Thread.sleep(5000);
		paymenttypemapping.clickonGroupMasterDefinitionMakerMenu();
		paymenttypemapping.clickonPaymentTypeMappingMakerSubMenu();
		paymenttypemapping.toswitchFieldsareinmandatory();
		paymenttypemapping.viewinMakerPage();
		paymenttypemapping.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		paymenttypemapping.verifyViewpageBySearchFieldWhenModifyTheEntityTypeMapping();
		// By Verify the particular Text With Column Values
		paymenttypemapping.toVerifyGetTextInViewPageWhenModify();
		paymenttypemapping.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToPaymentTypeMappingMakerPage() throws Exception {
		Thread.sleep(5000);
		paymenttypemapping.SwitchTheWindowFrom3ChildToParent();
		paymenttypemapping.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testloginToGroupCountryPaymentTypeCheckerToVerifyCheckerViewPageWhenModifedPaymentTypeMapping() throws Throwable {
		paymenttypemapping.enterloginid("lastmile7");
		paymenttypemapping.enterpassword("password@2");
		paymenttypemapping.clickonlogin();
		paymenttypemapping.clickonGroupMasterDefinitionCheckerMenu();
		paymenttypemapping.clickOnAuthoriserPaymentTypeMappingSubMenu();
		paymenttypemapping.verifyGroupCountryPaymentTypeCheckerPage();
		paymenttypemapping.clickOnviewInChecker();
		driver.manage().window().maximize();
		paymenttypemapping.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		paymenttypemapping.verifyViewpageBySearchFieldWhenModifyTheEntityTypeMapping();
		paymenttypemapping.toVerifyGetTextInViewPageWhenModify();
		paymenttypemapping.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		paymenttypemapping.SwitchTheWindowFrom4ChildToParent();
		paymenttypemapping.clickOnlogoutCheckerButton();
	}

}
