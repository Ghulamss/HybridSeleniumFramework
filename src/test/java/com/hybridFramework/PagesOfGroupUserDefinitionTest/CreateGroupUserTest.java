package com.hybridFramework.PagesOfGroupUserDefinitionTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.hybridFramework.PagesOfGroupUserDefinition.CreateGroupUser;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class CreateGroupUserTest extends TestBase {
	CreateGroupUser groupuser;

	private final Logger log = LoggerHelper.getLogger(CreateGroupUserTest.class);

	@Test(priority = 1)
	public void testLoginToCreateCorporateUserMaker() throws InterruptedException {
		log.info(CreateGroupUserTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		groupuser = new CreateGroupUser(driver);
		// lastmile8,password@1,lastmile8==password@1
		groupuser.enterloginid("lastmile8");
		groupuser.enterpassword("password@1");
		groupuser.clickonlogin();

	}

	@Test(priority = 2)
	public void testToCreateCorporateUserMaker() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		// first=testmaker1,testmaker@gmail.com,7890909090
		groupuser.toverifyhomepage();
		groupuser.clickOnGroupUserDefinitionMenu();
		groupuser.clickonCreateGroupUserSubMenu();
		groupuser.toswitchFieldsareinmandatory();
		// groupuser.CorporateIDFromDropDownByUsingStringArray();
		groupuser.selectRoleTypeDropDown();
		groupuser.selectCompanyDropDown();
		// groupuser.selectRoleDropDown();
		Thread.sleep(5000);
		groupuser.selectRoleDropDownByoptioon();
		Thread.sleep(5000);
		groupuser.enterbankBranch("Mumbai");
		Thread.sleep(5000);
		// groupuser.selectCorporateIdDropDownByoptioon();
		groupuser.enterLoginId("testmaker3");
		groupuser.enteremailId("testmaker3@gmail.com");
		groupuser.enteralternateEmailId("testmaker3@gmail.com");
		groupuser.enterfirstName("Ghh");
		groupuser.entermiddleName("sarr");
		groupuser.enterlastName("Sar");
		groupuser.entermobileNumber("7890909092");
		groupuser.enteremployeeId("01");
		groupuser.selectuniqueIdentifierTypeDropDowns();
		groupuser.enteruniqueIdentifierValue("~");
		// Not mandatory
		// groupuser.clickhereOnLink();
		groupuser.enteruniqueIdfileName("_");
		// groupuser.selectisActiveCorporateUser();
		//groupuser.clickonsubmitInMakerpage();
		groupuser.verifySuccessfulMessageOnMakerPage();
		groupuser.clickOnLogOutButton();
	}

	@Test(priority = 3)
	public void loginToCreateGroupUserCheckerPage() throws Exception {
		groupuser.enterloginid("lastmile7");
		groupuser.enterpassword("password@2");
		groupuser.clickonlogin();
		// groupuser.toverifyhomepage();
		groupuser.clickonGroupUserDefinitionCheckerMenu();
		groupuser.clickOnAuthorizeCreateUserSubMenu();
		groupuser.verifyAuthorizeCreateGroupUserCheckerPage();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListOnAuthorizedCreateGroupUserCheckerpage() throws Exception {
		groupuser.selectroleTypeOnCheckerPages();
		groupuser.selectroleOnCheckerPages();
		groupuser.selectfrmLoginIdOnCheckerPage();
		groupuser.clickonsubmitInMakerpage();
		// groupuser.verifyfrmLoginIdOnCheckerPage();
		// groupuser.verifyemailIdOnCheckerPage();
		Thread.sleep(3000);
		groupuser.clickOnAcceptButton();
		

	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {

		 groupuser.clickOnSubmitbuttononChecker();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerHasAcceptedAndModifyCreateGroupUser() throws Exception {
		groupuser.gotoMakerWhenCheckerHasApproved();
		// here we call the driver because the without can not Automate
		groupuser = new CreateGroupUser(driver);
		groupuser.enterloginid("lastmile8");
		groupuser.enterpassword("password@1");
		groupuser.clickonlogin();
		Thread.sleep(5000);
		groupuser.clickOnGroupUserDefinitionMenu();
		groupuser.clickonCreateGroupUserSubMenu();
		groupuser.toswitchFieldsareinmandatory();
		groupuser.clickOnModifyButtoninMaker();
		groupuser.switchToNewWindow(1);
		groupuser.verifyTheModifiedGroupUserPage();
		groupuser.selectGroupIdInModifyMakerPage();
		groupuser.enterlogingIdInModifyPage("49863");
		groupuser.clickOnsubmitbutton();
		groupuser.clickOn2submitButtonOnModifyPage();
		
	}

	// switch To Main window Country Modify Maker
	@Test(priority = 8)
	public void switchToMainwindow() {
		groupuser.clickOnEditButtonWhenUniqueValueHasMapped();
		groupuser.switchToNewWindow(1);
		groupuser.clickOnSubmitButtonOnEditPage();

		groupuser.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		groupuser.clickOnLogOutWhenEdited();

		/*
		 * groupuser.clickOnModifyButtonAndverifyTheModifiedPage();
		 * groupuser.selectCOrporateIDDropDownOnModifyPage();
		 * groupuser.selectcountryCodeInModifyMakerPage();
		 * groupuser.clickOnsubmitbutton(); groupuser.clickmodifysubmitbutton();
		 * groupuser.verificationMessageInModifyMakerPage();
		 */
	}
// login To Country Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToCorporateUsersCheckerWhenViewRejectPageHasEdited() throws Exception {
		groupuser.enterloginid("lastmile7");
		groupuser.enterpassword("password@2");

		groupuser.clickonlogin();
		groupuser.clickonGroupUserDefinitionCheckerMenu();
		groupuser.clickOnAuthorizeCreateUserSubMenu();
		groupuser.verifyAuthorizeCreateGroupUserCheckerPage();

	}

	@Test(priority = 10)
	// verify Corporate Country checker Page List After Modification has
	// Done By Maker
	public void verifyCorporateUserCheckerPageListAfterEditedHasDoneByMakerANd() throws Exception {
		Thread.sleep(5000);
		groupuser.selectroleTypeOnCheckerPages();
		groupuser.selectfrmLoginIdOnCheckerPage();
		groupuser.clickonsubmitInMakerpage();
		// groupuser.verifyfrmLoginIdOnCheckerPage();
		// groupuser.verifyemailIdOnCheckerPage();
		Thread.sleep(3000);
		groupuser.clickOnAcceptButton();

//		groupuser.verifyCheckerPageModificationhasDoneByMaker();
//		groupuser.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
//		groupuser.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	}

	@Test(priority = 11)
	public void goToTheMakerToVerifyCheckerHasApprovedTheEdited() throws Exception {
		// click on log out button in Checker
		groupuser.gotoMakerWhenCheckerHasApproved();
		groupuser = new CreateGroupUser(driver);
		groupuser.enterloginid("lastmile8");
		groupuser.enterpassword("password@1");
		groupuser.clickonlogin();
		Thread.sleep(5000);
		groupuser.toverifyhomepage();
		Thread.sleep(5000);
		groupuser.clickOnGroupUserDefinitionMenu();
		groupuser.clickonCreateGroupUserSubMenu();
		groupuser.toswitchFieldsareinmandatory();
		groupuser.clickOnModifyButtoninMaker();

		// groupuser.ViewRejectedUsersinMakerPage();
		// groupuser.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		// groupuser.verifyViewpageBySearchFieldWhenModify();
		// By Verify the particular Text With Column Values
		// groupuser.toVerifyByGetTextInViewPageWhenModify();
		// groupuser.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 13)
	public void toModifyPageWhenAcceptAddedUser() {
		groupuser.selectroleTypeOnCheckerPages();
		groupuser.selectfrmLoginIdOnCheckerPage();
		groupuser.clickonsubmitInMakerpage();
		groupuser.clickmodifysubmitbutton();
	}

	@Test(priority = 14)
	// switch To window Modify View Page To MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToCorpoeatePoolAccountDetailsMakerPage() throws Exception {
		Thread.sleep(5000);
		// groupuser.SwitchTheWindowFrom3ChildToParent();
		groupuser.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 15)
	public void testToVerifyCheckerViewPageWhenModifedTheCorporateUser() throws Throwable {
		Thread.sleep(3000);
		groupuser.enterloginid("lastmile7");
		groupuser.enterpassword("password@2");
		groupuser.clickonlogin();
		groupuser.clickonGroupUserDefinitionCheckerMenu();
		groupuser.clickOnAuthorizeCreateUserSubMenu();
		groupuser.verifyAuthorizeCreateGroupUserCheckerPage();
		// groupuser.clickOnviewInChecker();
		driver.manage().window().maximize();
		groupuser.selectroleTypeOnCheckerPages();
		groupuser.selectfrmLoginIdOnCheckerPage();
		groupuser.clickonsubmitInMakerpage();
		groupuser.clickOnAcceptButton();
		groupuser.gotoMakerWhenCheckerHasApproved();

		// td[contains(text(),'Record has been modified successfully.')]

		// groupuser.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
//		groupuser.verifyViewpageBySearchFieldWhenModify();
//		groupuser.toVerifyByGetTextInViewPageWhenModify();
//		groupuser.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
//		groupuser.SwitchTheWindowFrom4ChildToParent();
//		groupuser.clickOnlogoutCheckerButton();
	}

}
