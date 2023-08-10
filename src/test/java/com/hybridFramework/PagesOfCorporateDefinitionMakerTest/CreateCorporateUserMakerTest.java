package com.hybridFramework.PagesOfCorporateDefinitionMakerTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.hybridFramework.PagesOfCorporateDefinitionMaker.CreateCorporateUserMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class CreateCorporateUserMakerTest extends TestBase {
	CreateCorporateUserMaker corporateuser;

	private final Logger log = LoggerHelper.getLogger(CreateCorporateUserMakerTest.class);

	@Test(priority = 1)
	public void testLoginToCreateCorporateUserMaker() throws InterruptedException {
		log.info(CreateCorporateUserMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		corporateuser = new CreateCorporateUserMaker(driver);
		// lastmile8,password@1,lastmile8==password@1
		corporateuser.enterloginid("lastmile8");
		corporateuser.enterpassword("password@1");
		corporateuser.clickonlogin();

	}

	@Test(priority = 2)
	public void testToCreateCorporateUserMaker() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		// first=testmaker1,testmaker@gmail.com,7890909090
		corporateuser.toverifyhomepage();
		corporateuser.clickonCorporateDefinitionMakerMenu();
		corporateuser.clickonCreateCorporateUserMakerSubMenu();
		corporateuser.toswitchFieldsareinmandatory();
		corporateuser.CorporateIDFromDropDownByUsingStringArray();
		corporateuser.selectRoleDropDown();
		corporateuser.enterLoginId("testmaker3");
		corporateuser.enteremailId("testmaker3@gmail.com");
		corporateuser.enteralternateEmailId("testmaker3@gmail.com");
		corporateuser.enterfirstName("Ghh");
		corporateuser.entermiddleName("sarr");
		corporateuser.enterlastName("Sar");
		corporateuser.entermobileNumber("7890909092");
		corporateuser.selectuniqueIdentifierTypeDropDowns();
		corporateuser.enteruniqueIdentifierValue("~");
		//corporateuser.clickhereOnLink();
		corporateuser.enteruniqueIdfileName("_");
		//corporateuser.selectisActiveCorporateUser();
		corporateuser.clickonsubmitInMakerpage();
		corporateuser.verifySuccessfulMessageOnMakerPage();
		corporateuser.clickOnLogOutButton();
	}

	@Test(priority = 3)
	public void loginToCreateCorporateUserChecker() throws Exception {
		corporateuser.enterloginid("lastmile7");
		corporateuser.enterpassword("password@2");
		corporateuser.clickonlogin();
		// corporateuser.toverifyhomepage();
		corporateuser.clickonCorporateDefinitionCheckerMenu();
		corporateuser.clickOnAuthoriserCreateCorporateUserSubMenu();
		corporateuser.verifyAuthorizeCreateCorporateUserCheckerPage();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListOnAuthorizedCreateCCorporateUserCheckerpage() throws Exception {
		
		//corporateuser.toswitchFieldsareinmandatory();
		Thread.sleep(5000);
		corporateuser.selectCOrporateIDDropDownOnCheckerPage();
		corporateuser.selectfrmLoginIdOnCheckerPage();
		corporateuser.clickonsubmitInMakerpage();
		//corporateuser.verifyfrmLoginIdOnCheckerPage();
		//corporateuser.verifyemailIdOnCheckerPage();
		Thread.sleep(3000);
		corporateuser.clickOnRejectButton();
	

	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {

		//corporateuser.clickonsubmitbuttonAndverifySuccesfullMessage();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerCheckerApprovedCountrypage() throws Exception {
		corporateuser.gotoMakerWhenCheckerHasApproved();
		// here we call the driver because the without can not Automate
		corporateuser = new CreateCorporateUserMaker(driver);
		corporateuser.enterloginid("lastmile8");
		corporateuser.enterpassword("password@1");
		corporateuser.clickonlogin();
		//Thread.sleep(5000);
		//corporateuser.toverifyhomepage();
		Thread.sleep(5000);
		corporateuser.clickonCorporateDefinitionMakerMenu();
		corporateuser.clickonCreateCorporateUserMakerSubMenu();
		corporateuser.toswitchFieldsareinmandatory();
		corporateuser.ViewRejectedUsersinMakerPage();
		corporateuser.switchToNewWindow(1);
		// below is working but i have commented
		corporateuser.verifyViewpageBySearchField();
		corporateuser.VerifyViewPageByGetText();
		

	}

	// switch To Main window Country Modify Maker
	@Test(priority = 8)
	public void switchToMainwindow() {
		corporateuser.clickOnEditButtonWhenUniqueValueHasMapped();
		corporateuser.switchToNewWindow(1);
		corporateuser.clickOnSubmitButtonOnEditPage();
		
		corporateuser.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		corporateuser.clickOnLogOutWhenEdited();
		
		/*
		 * corporateuser.clickOnModifyButtonAndverifyTheModifiedPage();
		 * corporateuser.selectCOrporateIDDropDownOnModifyPage();
		 * corporateuser.selectcountryCodeInModifyMakerPage();
		 * corporateuser.clickOnsubmitbutton(); corporateuser.clickmodifysubmitbutton();
		 * corporateuser.verificationMessageInModifyMakerPage();
		 */
	}
// login To Country Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToCorporateUsersCheckerWhenViewRejectPageHasEdited() throws Exception {
		corporateuser.enterloginid("lastmile7");
		corporateuser.enterpassword("password@2");

		corporateuser.clickonlogin();
		corporateuser.clickonCorporateDefinitionCheckerMenu();
		corporateuser.clickOnAuthoriserCreateCorporateUserSubMenu();
		corporateuser.verifyAuthorizeCreateCorporateUserCheckerPage();

	}

	@Test(priority = 10)
	// verify Corporate Country checker Page List After Modification has
	// Done By Maker
	public void verifyCorporateUserCheckerPageListAfterEditedHasDoneByMakerANd() throws Exception {
		Thread.sleep(5000);
		corporateuser.selectCOrporateIDDropDownOnCheckerPage();
		corporateuser.selectfrmLoginIdOnCheckerPage();
		corporateuser.clickonsubmitInMakerpage();
		//corporateuser.verifyfrmLoginIdOnCheckerPage();
		//corporateuser.verifyemailIdOnCheckerPage();
		Thread.sleep(3000);
		corporateuser.clickOnAcceptButton();
		
		
//		corporateuser.verifyCheckerPageModificationhasDoneByMaker();
//		corporateuser.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
//		corporateuser.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	}

	@Test(priority = 11)
	public void goToTheMakerToVerifyCheckerHasApprovedTheEdited()throws Exception {
		// click on log out button in Checker
		corporateuser.gotoMakerWhenCheckerHasApproved();
		corporateuser = new CreateCorporateUserMaker(driver);
		corporateuser.enterloginid("lastmile8");
		corporateuser.enterpassword("password@1");
		corporateuser.clickonlogin();
		Thread.sleep(5000);
		corporateuser.toverifyhomepage();
		Thread.sleep(5000);
		corporateuser.clickonCorporateDefinitionMakerMenu();
		corporateuser.clickonCreateCorporateUserMakerSubMenu();
		corporateuser.toswitchFieldsareinmandatory();
		corporateuser.clickOnModifyButtoninMaker();
		
		//corporateuser.ViewRejectedUsersinMakerPage();
		//corporateuser.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		//corporateuser.verifyViewpageBySearchFieldWhenModify();
		// By Verify the particular Text With Column Values
		//corporateuser.toVerifyByGetTextInViewPageWhenModify();
		//corporateuser.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}
	@Test(priority = 13)
public void toModifyPageWhenAcceptAddedUser() {
		corporateuser.selectCOrporateIDDropDownOnCheckerPage();
		corporateuser.selectfrmLoginIdOnCheckerPage();
		corporateuser.clickonsubmitInMakerpage();
		corporateuser.clickmodifysubmitbutton();
}
	
	@Test(priority = 14)
	// switch To window Modify View Page To MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToCorpoeatePoolAccountDetailsMakerPage() throws Exception {
		Thread.sleep(5000);
		//corporateuser.SwitchTheWindowFrom3ChildToParent();
		corporateuser.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 15)
	public void testToVerifyCheckerViewPageWhenModifedTheCorporateUser() throws Throwable {
		Thread.sleep(3000);
		corporateuser.enterloginid("lastmile7");
		corporateuser.enterpassword("password@2");
		corporateuser.clickonlogin();
		corporateuser.clickonCorporateDefinitionCheckerMenu();
		corporateuser.clickOnAuthoriserCreateCorporateUserSubMenu();
		corporateuser.verifyAuthorizeCreateCorporateUserCheckerPage();
		//corporateuser.clickOnviewInChecker();
		driver.manage().window().maximize();
		corporateuser.selectCOrporateIDDropDownOnCheckerPage();
		corporateuser.selectfrmLoginIdOnCheckerPage();
		corporateuser.clickonsubmitInMakerpage();
		corporateuser.clickOnAcceptButton();
		corporateuser.gotoMakerWhenCheckerHasApproved();

		//td[contains(text(),'Record has been modified successfully.')]
		
		//corporateuser.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
//		corporateuser.verifyViewpageBySearchFieldWhenModify();
//		corporateuser.toVerifyByGetTextInViewPageWhenModify();
//		corporateuser.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
//		corporateuser.SwitchTheWindowFrom4ChildToParent();
//		corporateuser.clickOnlogoutCheckerButton();
	}

}
