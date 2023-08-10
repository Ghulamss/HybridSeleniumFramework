package com.hybridFramework.GroupMasterDefinitionMakerTest;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.GroupMasterDefinitionMaker.EntityPurposeMakerMapping;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class EntityPurposeMakerMappingTest extends TestBase {
	EntityPurposeMakerMapping entitypurposemakermapping;

	private final Logger log = LoggerHelper.getLogger(EntityPurposeMakerMappingTest.class);

	@Test(priority = 1)
	public void testLoginToEntityPurposeMakerMapping() throws InterruptedException {
		log.info(EntityPurposeMakerMappingTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		entitypurposemakermapping = new EntityPurposeMakerMapping(driver);
		// lastmile8,password@1,lastmile8==password@1
		entitypurposemakermapping.enterloginid("lastmile8");
		entitypurposemakermapping.enterpassword("password@1");
		entitypurposemakermapping.clickonlogin();

	}

	@Test(priority = 2)
	public void testToEntityPurposeMakerMappingPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		entitypurposemakermapping.toverifyhomepage();
		entitypurposemakermapping.clickonGroupMasterDefinitionMakerMenu();
		entitypurposemakermapping.clickonEntityPurposeMappingMakerSubMenu();
		entitypurposemakermapping.toswitchFieldsareinmandatory();
		// Thread.sleep(5000);
		entitypurposemakermapping.selectGroupCountryDropDown();
		entitypurposemakermapping.selectEntityTypeIdFromDropDownByUsingStringArray();
		// to verify the Same values store in the String Array and verify the same
		// values from drop down.

		entitypurposemakermapping.selectPurposeCodeFromDropDownByUsingStringArray();
		entitypurposemakermapping.selectisActiveGroupCountryEntityTypePurposeMaker();
		entitypurposemakermapping.clickonsubmitInMakerpage();
		entitypurposemakermapping.verifySuccessfulMessageOnMakerPage();
	}

	@Test(priority = 3)
	public void loginToEntityPurposeMakerMappingChecker() throws Exception {
		entitypurposemakermapping.enterloginid("lastmile7");
		entitypurposemakermapping.enterpassword("password@2");
		entitypurposemakermapping.clickonlogin();
		// entitypurposemakermapping.toverifyhomepage();
		entitypurposemakermapping.clickonGroupMasterDefinitionCheckerMenu();
		entitypurposemakermapping.clickOnAuthoriserEntityPurposeMappingSubMenu();
		entitypurposemakermapping.verifyGroupCountryEntityTypePurposeCheckerPage();

	}

	@Test(priority = 4)
	public void verifyAddcheckerListinGroupCountryEntityTypePurposeCheckerpage() throws Exception {
		// below is working but for not Array list , previous master definition concept.
		// entitypurposemakermapping.verifyAddcheckerListByUsingArraysToStringandSubStringToString();
		// below is for array List
		entitypurposemakermapping.verifyListOfGetTextOnAddcheckerPage();
		entitypurposemakermapping.HandleTheDynamicVluesWithCheckbox();

	}

	// in Checker page
	@Test(priority = 5)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {

		entitypurposemakermapping.clickonsubmitbuttonAndverifySuccesfullMessage();

	}

	@Test(priority = 6)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerWhenCheckerApprovedTheGroupCountryEntityTypePurposeMakerpage() throws Exception {
		// means click on Log Out Button On checker Page.
		entitypurposemakermapping.gotoMakerCheckerHasApproved();
		// here we call the driver because the without can not Automate
		entitypurposemakermapping = new EntityPurposeMakerMapping(driver);
		entitypurposemakermapping.enterloginid("lastmile8");
		entitypurposemakermapping.enterpassword("password@1");
		entitypurposemakermapping.clickonlogin();
		Thread.sleep(5000);
		entitypurposemakermapping.toverifyhomepage();
		Thread.sleep(5000);
		entitypurposemakermapping.clickonGroupMasterDefinitionMakerMenu();
		entitypurposemakermapping.clickonEntityPurposeMappingMakerSubMenu();
		entitypurposemakermapping.toswitchFieldsareinmandatory();
		entitypurposemakermapping.viewinMakerPage();
		entitypurposemakermapping.switchToNewWindow(1);
		// below is working but i have commented
		entitypurposemakermapping.verifyViewpageBySearchField();
		// entitypurposemakermapping.searchTheElementsByUsingArrayList();
		entitypurposemakermapping.VerifyViewPageByGetText();
		entitypurposemakermapping.selectDropDownAllvaluesOneByOne();

	}

	// switch To Main window Entity Purpose Maker Mapping Modify Maker
	@Test(priority = 8)
	public void switchToMainwindow() throws Exception {
		entitypurposemakermapping.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		entitypurposemakermapping.verifyTheModifiedPage();
		entitypurposemakermapping.selectcountryCodeInModifyMakerPage();
		entitypurposemakermapping.selectPEntityTypeTypeDropDownOnModifyPage();
		Thread.sleep(3000);
		entitypurposemakermapping.selectPurposeCodeDropDownOnModifyPage();
		entitypurposemakermapping.clickOnsubmitbutton();
		entitypurposemakermapping.clickmodifysubmitbutton();
		entitypurposemakermapping.verificationMessageInModifyGroupCountryPaymentTypeMakerPage();

	}
// login To Entity Purpose Maker Mapping Checker if Modify the Same data 

	@Test(priority = 9)
	public void testloginToGroupCountryEntityTypePurposeChecker() throws Exception {
		entitypurposemakermapping.enterloginid("lastmile7");
		entitypurposemakermapping.enterpassword("password@2");

		entitypurposemakermapping.clickonlogin();
		entitypurposemakermapping.clickonGroupMasterDefinitionCheckerMenu();
		entitypurposemakermapping.clickOnAuthoriserEntityPurposeMappingSubMenu();
		entitypurposemakermapping.verifyGroupCountryEntityTypePurposeCheckerPage();

	}

	@Test(priority = 10)
	// verify Group Country Payment Type checker Page List After Modification has Done By Maker
	public void verifyGroupCountryEntityTypePurposeCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		entitypurposemakermapping.verifyGroupCountryEntityTypePurposeCheckerPageModificationhasDoneByMaker();
		entitypurposemakermapping.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		entitypurposemakermapping.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	}

	@Test(priority = 11)
	// go To The Group Country Entity Type purpose Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheGroupCountryEntityTypePurposeMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		entitypurposemakermapping.gotoMakerCheckerHasApproved();
		entitypurposemakermapping = new EntityPurposeMakerMapping(driver);
		entitypurposemakermapping.enterloginid("lastmile8");
		entitypurposemakermapping.enterpassword("password@1");
		entitypurposemakermapping.clickonlogin();
		Thread.sleep(5000);
		entitypurposemakermapping.toverifyhomepage();
		Thread.sleep(5000);
		entitypurposemakermapping.clickonGroupMasterDefinitionMakerMenu();
		entitypurposemakermapping.clickonEntityPurposeMappingMakerSubMenu();
		entitypurposemakermapping.toswitchFieldsareinmandatory();
		entitypurposemakermapping.viewinMakerPage();
		entitypurposemakermapping.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		entitypurposemakermapping.verifyViewpageBySearchFieldWhenModifyTheEntityTypeMapping();
		// By Verify the particular Text With Column Values
		entitypurposemakermapping.toVerifyGetTextInViewPageWhenModify();
		entitypurposemakermapping.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 12)
	// switch To window Modify View Page To MAKER Page
	// and LogOut
	public void switchTowindowModifyViewPageToEntityPurposeMappingMakerPage() throws Exception {
		Thread.sleep(5000);
		entitypurposemakermapping.SwitchTheWindowFrom3ChildToParent();
		entitypurposemakermapping.clickOnlogoutMakerButton();

	}

	// login to Checker And Go To View Page of Checker To Verify the Approved Data
	// is available or Not
	// view page of checker
	@Test(priority = 13)
	public void testloginToGroupCountryEntityTypePurposeCheckerToVerifyCheckerViewPageWhenModifedPaymentTypeMapping() throws Throwable {
		entitypurposemakermapping.enterloginid("lastmile7");
		entitypurposemakermapping.enterpassword("password@2");
		entitypurposemakermapping.clickonlogin();
		entitypurposemakermapping.clickonGroupMasterDefinitionCheckerMenu();
		entitypurposemakermapping.clickOnAuthoriserEntityPurposeMappingSubMenu();
		entitypurposemakermapping.verifyGroupCountryEntityTypePurposeCheckerPage();
		entitypurposemakermapping.clickOnviewInChecker();
		driver.manage().window().maximize();
		entitypurposemakermapping.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		entitypurposemakermapping.verifyViewpageBySearchFieldWhenModifyTheEntityTypeMapping();
		entitypurposemakermapping.toVerifyGetTextInViewPageWhenModify();
		entitypurposemakermapping.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		entitypurposemakermapping.SwitchTheWindowFrom4ChildToParent();
		entitypurposemakermapping.clickOnlogoutCheckerButton();
	}

}
