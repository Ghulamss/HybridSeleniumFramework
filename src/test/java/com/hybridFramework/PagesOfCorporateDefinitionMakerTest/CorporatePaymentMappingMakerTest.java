package com.hybridFramework.PagesOfCorporateDefinitionMakerTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.hybridFramework.PagesOfCorporateDefinitionMaker.CorporateCountryLicenseMaker;
import com.hybridFramework.PagesOfCorporateDefinitionMaker.CorporatePaymentMappingMaker;
import com.hybridFramework.PagesOfCorporateDefinitionMaker.CorporatePoolAccountDetailsMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

@SuppressWarnings("unused")
public class CorporatePaymentMappingMakerTest extends TestBase {
	CorporatePaymentMappingMaker corporatepaymentmapping;

	private final Logger log = LoggerHelper.getLogger(CorporatePaymentMappingMakerTest.class);

	@Test(priority = 1)
	public void testLoginToCorporatePaymentMappingMaker() throws InterruptedException {
		log.info(CorporatePaymentMappingMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		corporatepaymentmapping = new CorporatePaymentMappingMaker(driver);
		// lastmile8,password@1,lastmile8==password@1
		corporatepaymentmapping.enterloginid("lastmile8");
		corporatepaymentmapping.enterpassword("password@1");
		corporatepaymentmapping.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAddCorporatePaymentMappingMaker() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		corporatepaymentmapping.toverifyhomepage();
		corporatepaymentmapping.clickonCorporateDefinitionMakerMenu();
		corporatepaymentmapping.clickonCorporatePaymentMappingMakerSubMenu();
		corporatepaymentmapping.toswitchFieldsareinmandatory();
		corporatepaymentmapping.CorporateIDFromDropDownByUsingStringArray();
		// Thread.sleep(5000);
		corporatepaymentmapping.selectGroupCountry();
		//Thread.sleep(5000);
		corporatepaymentmapping.selectPaymentCodeDropDown();
		//Thread.sleep(5000);
		corporatepaymentmapping.selectisActivePaymentMapping();
		corporatepaymentmapping.clickonsubmitInMakerpage();
		corporatepaymentmapping.verifySuccessfulMessageOnMakerPage();
		corporatepaymentmapping.clickOnLogOutButton();
	}

	@Test(priority = 3)
	public void loginToCorporatePaymentMappingChecker() throws Exception {
		//
		corporatepaymentmapping.enterloginid("lastmile7");
		corporatepaymentmapping.enterpassword("password@2");
		corporatepaymentmapping.clickonlogin();
		// corporatepaymentmapping.toverifyhomepage();
		corporatepaymentmapping.clickonCorporateDefinitionCheckerMenu();
		corporatepaymentmapping.clickOnAuthoriserCorporatePaymentMappingSubMenu();
		corporatepaymentmapping.verifyCorporatePaymentMappingCheckerPage();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListOnEntityLicenseCountryCheckerpage() throws Exception {
		//  Comment due to We have Change the Value of Corporate Id.
		corporatepaymentmapping.verifyChekerPageByTextWhenAddedMaker();
		corporatepaymentmapping.HandleTheDynamicVluesWithCheckboxWhenAdded();

	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {

		corporatepaymentmapping.clickonsubmitbuttonAndverifySuccesfullMessage();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerHasApprovedCorporatePaymentMappingMakerpage() throws Exception {
		corporatepaymentmapping.gotoMakerWhenCheckerHasApproved();
		// here we call the driver because the without can not Automate
		corporatepaymentmapping = new CorporatePaymentMappingMaker(driver);
		corporatepaymentmapping.enterloginid("lastmile8");
		corporatepaymentmapping.enterpassword("password@1");
		corporatepaymentmapping.clickonlogin();
		//Thread.sleep(5000);
		//corporatepaymentmapping.toverifyhomepage();
		Thread.sleep(5000);
		corporatepaymentmapping.clickonCorporateDefinitionMakerMenu();
		corporatepaymentmapping.clickonCorporatePaymentMappingMakerSubMenu();
		corporatepaymentmapping.toswitchFieldsareinmandatory();
		corporatepaymentmapping.viewinMakerPage();
		corporatepaymentmapping.switchToNewWindow(1);
		// below is working but i have commented
		corporatepaymentmapping.verifyViewpageBySearchField();
		corporatepaymentmapping.VerifyViewPageByGetText();
		corporatepaymentmapping.selectAllDropDownvaluesOneByOneOnViewPage();

	}

	// switch To Main window To Corporate Payment Mapping  Maker Modify
	@Test(priority = 8)
	public void switchToMainwindowToCorporatePaymentMappingMakerAndModifyIt() {
		corporatepaymentmapping.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		corporatepaymentmapping.verifyTheModifiedPage();
		corporatepaymentmapping.selectCOrporateIDDropDownOnModifyPage();
		corporatepaymentmapping.selectcountryCodeInModifyMakerPage();
		corporatepaymentmapping.selectPaymentCodeDropDownInModifyPage();
		corporatepaymentmapping.clickOnsubmitbutton();
		corporatepaymentmapping.clickmodifysubmitbutton();
		corporatepaymentmapping.verificationMessageInModifyMakerPage();

	}
// login To  Corporate Payment Mapping Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToCorporatePaymentMappingCheckerWhenModify() throws Exception {
		corporatepaymentmapping.enterloginid("lastmile7");
		corporatepaymentmapping.enterpassword("password@2");

		corporatepaymentmapping.clickonlogin();
		corporatepaymentmapping.clickonCorporateDefinitionCheckerMenu();
		corporatepaymentmapping.clickOnAuthoriserCorporatePaymentMappingSubMenu();
		corporatepaymentmapping.verifyCorporatePaymentMappingCheckerPage();

	}

	@Test(priority = 10)
	// verify Corporate Country checker Page List After Modification has
	// Done By Maker
	public void verifyCorporatePaymentMappingCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		corporatepaymentmapping.verifyCheckerPageModificationhasDoneByMaker();
		corporatepaymentmapping.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		corporatepaymentmapping.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	}

	@Test(priority = 11)
	// go To The Corporate Payment Mapping To Verify Checker Has Approved The
	// Modify Data Same
	public void goToTheCorporatePaymentMappingMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		corporatepaymentmapping.gotoMakerWhenCheckerHasApproved();
		corporatepaymentmapping = new CorporatePaymentMappingMaker(driver);
		corporatepaymentmapping.enterloginid("lastmile8");
		corporatepaymentmapping.enterpassword("password@1");
		corporatepaymentmapping.clickonlogin();
		Thread.sleep(5000);
		corporatepaymentmapping.toverifyhomepage();
		Thread.sleep(5000);
		corporatepaymentmapping.clickonCorporateDefinitionMakerMenu();
		corporatepaymentmapping.clickonCorporatePaymentMappingMakerSubMenu();
		corporatepaymentmapping.toswitchFieldsareinmandatory();
		corporatepaymentmapping.viewinMakerPage();
		corporatepaymentmapping.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		corporatepaymentmapping.verifyViewpageBySearchFieldWhenModify();
		// By Verify the particular Text With Column Values
		corporatepaymentmapping.toVerifyByGetTextInViewPageWhenModify();
		corporatepaymentmapping.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToCorporatePaymentMappingMakerPage() throws Exception {
		Thread.sleep(5000);
		corporatepaymentmapping.SwitchTheWindowFrom3ChildToParent();
		corporatepaymentmapping.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testToVerifyCheckerViewPageWhenModifedTheCorporatePaymentMappingMaker() throws Throwable {
		Thread.sleep(3000);
		corporatepaymentmapping.enterloginid("lastmile7");
		corporatepaymentmapping.enterpassword("password@2");
		corporatepaymentmapping.clickonlogin();
		corporatepaymentmapping.clickonCorporateDefinitionCheckerMenu();
		corporatepaymentmapping.clickOnAuthoriserCorporatePaymentMappingSubMenu();
		corporatepaymentmapping.verifyCorporatePaymentMappingCheckerPage();
		corporatepaymentmapping.clickOnviewInChecker();
		driver.manage().window().maximize();
		corporatepaymentmapping.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		corporatepaymentmapping.verifyViewpageBySearchFieldWhenModify();
		corporatepaymentmapping.toVerifyByGetTextInViewPageWhenModify();
		corporatepaymentmapping.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		corporatepaymentmapping.SwitchTheWindowFrom4ChildToParent();
		corporatepaymentmapping.clickOnlogoutCheckerButton();
	}

}
