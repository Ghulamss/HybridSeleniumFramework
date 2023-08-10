package com.hybridFramework.GroupMasterDefinitionMakerTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.GroupMasterDefinitionMaker.EntityTypeMappingMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class EntityTypeMappingMakerTest extends TestBase {
	EntityTypeMappingMaker entitytypemapping;
	
	private final Logger log = LoggerHelper.getLogger(EntityTypeMappingMakerTest.class);

	@Test(priority = 1)
	public void testLoginToEntityTypeMappingMaker() throws InterruptedException{
		log.info(EntityTypeMappingMakerTest.class.getName()+" started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		  entitytypemapping = new  EntityTypeMappingMaker(driver);
		  // Test_maker1,password@1,Test_maker1==password@1
		 entitytypemapping.enterloginid("Test_maker1");
		 entitytypemapping.enterpassword("password@1");
		 entitytypemapping.clickonlogin();
		 		
	}
	
	  @Test(priority =2)
	  public void testToEntityTypeMappingMakerPage() throws Exception{
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  //driver.switchTo().defaultContent(); 
	  entitytypemapping.toverifyhomepage();
	  entitytypemapping.clickonGroupMasterDefinitionMakerMenu();
	  entitytypemapping.clickonEntityTypeMappingMakerSubMenu();
	  entitytypemapping.toswitchFieldsareinmandatory();
	 // Thread.sleep(5000);
	   entitytypemapping.selectGroupCountry();
	  // this Split the values of Drop Down then its verifying For Demo Purpose
	  //entitytypemapping.selectthedropdown();
	  // to verify the Same values store in the String Array and verify the same values from drop down.
	
	  //Thread.sleep(5000);
	 entitytypemapping.verifyingCorporateTypeIDFromDropDownByUsingStringArray();
	  entitytypemapping.selectisActiveCountry();
	  entitytypemapping.clickonsubmitInMakerpage();
	  entitytypemapping.verifySuccessfulMessageOnMakerPageAndClickOnLogOut();
	  }
	 
	  
	  @Test(priority =3)
	  public void loginToEntityTypeMappingChecker() throws Exception {
		  //
	entitytypemapping.enterloginid("lastmile7");
	entitytypemapping.enterpassword("password@2");
	entitytypemapping.clickonlogin();
	//entitytypemapping.toverifyhomepage();
	entitytypemapping.clickonGroupMasterDefinitionCheckerMenu();
	entitytypemapping.clickOnAuthoriserEntityTypeMappingSubMenu();
	entitytypemapping.verifyGroupCountryEntityTypeCheckerPages();
	
		  
	  }
	  @Test(priority =4)
	  public void verifyAddcheckerListinGroupCountryEntityTypeCheckerpage() throws Exception {
		  // below is working but for not Array list , previous master definition concept. 
		  //entitytypemapping.verifyAddcheckerListByUsingArraysToStringandSubStringToString();
		  // below is for array List
		  entitytypemapping.verifyAddcheckerListByUsingArraysListAnd();
		  entitytypemapping.HandleTheDynamicVluesWithCheckbox();
		
	  }
	  // in Checker page
	  @Test(priority =5)
	 public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {
		  
		  entitytypemapping.clickonsubmitbuttonAndverifySuccesfullMessage();
		  
	  }
	   @Test(priority=6)
	   // go to maker Page
	   // login from checker to Maker Need to pass driver 
	   public void gotoMakerCheckerApprovedCountrypage() throws Exception {
		entitytypemapping.gotoMakerCheckerApprovedCountry();
		// here we call the driver because the without can not Automate
		entitytypemapping = new EntityTypeMappingMaker(driver);
		entitytypemapping.enterloginid("Test_maker1");
		entitytypemapping.enterpassword("password@1");
		entitytypemapping.clickonlogin();
		Thread.sleep(5000);
		entitytypemapping.toverifyhomepage();
		Thread.sleep(5000);
		entitytypemapping.clickonGroupMasterDefinitionMakerMenu();
		entitytypemapping.clickonEntityTypeMappingMakerSubMenu();
		entitytypemapping.toswitchFieldsareinmandatory();
		entitytypemapping.viewinMakerPage();
		entitytypemapping.switchToNewWindow(1);
		// below is working but i have commented
		entitytypemapping.verifyViewpageBySearchField();
		//entitytypemapping.searchTheElementsByUsingArrayList();
		entitytypemapping.VerifyViewPageByGetText();
		entitytypemapping.selectAllvaluesOneByOne();
		
		}
	 
	 // switch To Main window Entity Type Mapping Maker Modify Maker
	 @Test(priority=8)
	 public void switchToMainwindow() {
		 entitytypemapping.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		 entitytypemapping.verifyTheModifiedPage();
		 entitytypemapping.selectcountryCodeInModifyMakerPage();
		 entitytypemapping.selectCOrporateTypeDropDownOnModifyPage();
		 entitytypemapping.clickOnsubmitbutton();
		 entitytypemapping. clickmodifysubmitbutton();
		 entitytypemapping.verificationMessageInModifyGroupCountryEntityTypeMakerPage();
		 
		}
// login To Entity Type Mapping Checker if Modify the Same data 
	
	@Test(priority = 9)
	public void testloginToGroupCountryEntityTypeChecker() throws Exception {
		entitytypemapping.enterloginid("lastmile7");
		entitytypemapping.enterpassword("password@2");

		entitytypemapping.clickonlogin();
		entitytypemapping.clickonGroupMasterDefinitionCheckerMenu();
		entitytypemapping.clickOnAuthoriserEntityTypeMappingSubMenu();
		entitytypemapping.verifyGroupCountryEntityTypeCheckerPages();
	  
	  }
	 
	  @Test(priority=10)
	  // verify Group Country Entity Type checker Page List After Modification has Done By Maker
	  public void verifyGroupCountryEntityTypecheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		  entitytypemapping. verifyGroupCountryEntityTypecheckerPageModificationhasDoneByMaker();
		  entitytypemapping. selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		  entitytypemapping.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	  }
	
	
	 @Test(priority=11)
	 // go To The Country Entity Type Maker To Verify Checker Has Approved The Modify Data Same
	 public void goToTheGroupCountryEntityTypeMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		 // click on log out button in Checker
		 entitytypemapping.gotoMakerCheckerApprovedCountry();
		 entitytypemapping = new EntityTypeMappingMaker(driver);
			entitytypemapping.enterloginid("Test_maker1");
			entitytypemapping.enterpassword("password@1");
			entitytypemapping.clickonlogin();
			Thread.sleep(5000);
			entitytypemapping.toverifyhomepage();
			Thread.sleep(5000);
			entitytypemapping.clickonGroupMasterDefinitionMakerMenu();
			entitytypemapping.clickonEntityTypeMappingMakerSubMenu();
			entitytypemapping.toswitchFieldsareinmandatory();
			entitytypemapping.viewinMakerPage();
			entitytypemapping.switchToNewWindow(1);
			// Enter the values one By one in Search Box in view page 
		entitytypemapping.verifyViewpageBySearchFieldWhenModifyTheEntityTypeMapping();
			// By Verify the particular Text With Column Values
			entitytypemapping.toVerifyGetTextInViewPageWhenModify();
			entitytypemapping.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	 }
	
    @Test(priority=12)
    // switch To window Modify View Page To  MAKER Page
    // and LogOut
	public void   switchTowindowModifyViewPageToEntityTypeMappingMakerPage() throws Exception {
   Thread.sleep(5000);
   entitytypemapping.SwitchTheWindowFrom3ChildToParent();
   entitytypemapping.clickOnlogoutMakerButton();
	 
}
    // login to Checker And Go To View Page of Checker To  Verify the Approved Data is available or Not
    // view page of checker 
    @Test(priority = 13)
	public void testToVerifyCheckerViewPageWhenModifedTheEntityMapping() throws Throwable {
		entitytypemapping.enterloginid("lastmile7");
		entitytypemapping.enterpassword("password@2");
		entitytypemapping.clickonlogin();
		entitytypemapping.clickonGroupMasterDefinitionCheckerMenu();
		entitytypemapping.clickOnAuthoriserEntityTypeMappingSubMenu();
		entitytypemapping.verifyGroupCountryEntityTypeCheckerPages();
		entitytypemapping.clickOnviewInChecker();
		driver.manage().window().maximize();
		entitytypemapping.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page 
		entitytypemapping.verifyViewpageBySearchFieldWhenModifyTheEntityTypeMapping();
		entitytypemapping.toVerifyGetTextInViewPageWhenModify();
		entitytypemapping.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
		entitytypemapping.SwitchTheWindowFrom4ChildToParent();
		   entitytypemapping.clickOnlogoutCheckerButton();
    }
 

}
