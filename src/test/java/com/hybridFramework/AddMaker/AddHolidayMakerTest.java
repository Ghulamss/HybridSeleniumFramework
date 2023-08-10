package com.hybridFramework.AddMaker;

import java.util.Currency;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.AddEntityTypeMaker;
import com.hybridFramework.PageObject.AddHolidayMaker;
import com.hybridFramework.PageObject.AddPaymentTypeMaker;
import com.hybridFramework.PageObject.AddPurposeMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class AddHolidayMakerTest extends TestBase {
	AddHolidayMaker addholidaymaker;
	
	private final Logger log = LoggerHelper.getLogger(AddHolidayMakerTest.class);
	@Test(priority = 1)
	public void testLoginToApplication() throws InterruptedException{
		log.info(Currency.class.getName()+" started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		 addholidaymaker = new AddHolidayMaker(driver);
		 // lastmile8 ,password@1
		 addholidaymaker.enterloginid("lastmile8");
		 addholidaymaker.enterpassword("password@1");
		 addholidaymaker.clickonlogin();
		 		
	}
	
	  @Test(priority =2)
	  public void testLoginToApplication2() throws Exception{
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  //driver.switchTo().defaultContent(); 
	  //addholidaymaker.toverifyhomepage();
	  addholidaymaker.clikonmasterdefinitionmakerMenu();
	  addholidaymaker.clickonAddHolidayMakerSubMenu();
	 // addholidaymaker.verifyAddHolidayMakerPage();
	  addholidaymaker.toswitchFieldsareinmandatory();
	  addholidaymaker.selectbankNameOnAddHolidaypage();
	  Thread.sleep(5000);
	  addholidaymaker.selectbranchNameOnAddHolidaypage();
	  // By using the for and while loop
	  addholidaymaker.selectHolidayDate();
	  addholidaymaker.enterOccasion("NANANB");
	  addholidaymaker.selectisActiveHoliday();
	  addholidaymaker.clickonsubmitInMakerpage();
	  addholidaymaker.verifySuccesfullMessage();
	  }
	  
	  @Test(priority =3)
	  // Checker Page..
	  
	  public void chekerlogin() throws Exception {
	addholidaymaker.enterloginid("lastmile3");
	addholidaymaker.enterpassword("password@1");
	addholidaymaker.clickonlogin();
	 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  //addholidaymaker.toverifyhomepage();
	  Thread.sleep(4000);
	addholidaymaker.clickonMasterDefinitionChecker();
	Thread.sleep(4000);
	addholidaymaker.clickOnAddHolidayCheckerSubMenu();
	addholidaymaker.verifyHolidayCheckerPages();
	
		  
	  }
	  // in Checker page verify the list of Elements
	  @Test(priority =4)
	  public void verifyAddcheckerListinPaymentTypeCheckerpage() throws InterruptedException {
		 // addholidaymaker.verifyAddcheckerListInCheckerpage();
		 //addholidaymaker.multiplecheckbox();
		 // currencypage.selectHeadercheckbox();
	  }
	  // in Checker page
	  @Test(priority =5)
	  // click on submit Button and verify  Message in Checker page. 
	 public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {
		  //addholidaymaker.clickonsubmitbuttonOnCheckerPage();
		  //addholidaymaker.toverifysuccessfulMessageinCheckerPage();
	  }
	   @Test(priority=6)
	   // go to maker Page
	   // login from checker to Maker Need to pass driver 
	   public void gotoMakerCheckerApprovedCountrypage() throws Exception {
		   // click on log out checker Button .
		addholidaymaker.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
		// here we call the driver because the without can not Automate
		addholidaymaker = new AddHolidayMaker(driver);
		addholidaymaker.enterloginid("lastmile8");
		addholidaymaker.enterpassword("password@1");
		addholidaymaker.clickonlogin();
		Thread.sleep(5000);
		//addholidaymaker.toverifyhomepage();
		Thread.sleep(5000);
		addholidaymaker.clikonmasterdefinitionmakerMenu();
		addholidaymaker.clickonAddHolidayMakerSubMenu();
		addholidaymaker.toswitchFieldsareinmandatory();
		addholidaymaker.clickOnviewButtoninMakerPage();
		addholidaymaker.switchToNewWindow(1);
		addholidaymaker.verifyViewpages("CCC","DDD","Y");
		addholidaymaker.multippleSelectVerifyTextInViewPage();
		Thread.sleep(5000);
		addholidaymaker.selectAllvaluesOneByOne();
		//currencypage.switchToWindowByUsingIterator();
		
		   
	
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	/*
	 * // this one is not working //
	 * 
	 * @Test(priority=7) public void switchToWindowByUsingIterator() throws
	 * Exception { //currencypage.switchToWindowByUsingIterator();
	 * 
	 * 
	 * } // Switch the Child window (Currency view page ) To parent window(Currency
	 * Maker page)
	 * 
	 * @Test(priority=8) public void switchToMainwindow() throws Exception { //
	 * switch view page to Maker page and click on Modify button.
	 * addholidaymaker.switch2();
	 * addholidaymaker.selectPurposeCodeInModifyPurposeMakerPage(); // click on
	 * first Submit button addholidaymaker.clickOnsubmitbutton(); // modify Submit
	 * Button Thread.sleep(5000); addholidaymaker. clickmodifysubmitbutton();
	 * Thread.sleep(5000);
	 * addholidaymaker.verificationMessageInModifyPaymentTypePage();
	 * 
	 * } // login To payment type Checker if Modify the Same data // go to the
	 * CHecker Page.and verify the checker page.
	 * 
	 * @Test(priority = 9) public void testloginToCountryChecker() throws Exception
	 * { addholidaymaker.enterloginid("lastmile3");
	 * addholidaymaker.enterpassword("password@1"); addholidaymaker.clickonlogin();
	 * addholidaymaker.clickonMasterDefinitionChecker();
	 * addholidaymaker.clickOnAddHolidayCheckerSubMenu();
	 * addholidaymaker.verifyHolidayCheckerPages();
	 * 
	 * }
	 * 
	 * @Test(priority=10) // calling // verify Payment Type checker Page List After
	 * Modification has Done By Maker public void
	 * verifyCountrycheckerPageListAfterModificationhasDoneByMaker() throws
	 * Exception { // in Cheker page when Modification has done By Maker
	 * addholidaymaker. verifyListonCheckerpageWhenModificationhasDoneByMaker(); //
	 * currencypage. SelectAndDeSelectMutilpeCheckboxoneByOneInChecker();
	 * addholidaymaker.multiplecheckboxwhenModifytheCountry(); //currencypage.
	 * clickonsubmitbuttonAndverifySuccesfullMessageIfModifytheCountry();
	 * addholidaymaker.clickonsubmitbuttonOnCheckerPage();
	 * addholidaymaker.toverifysuccessfulMessageinCheckerPage(); }
	 * 
	 * 
	 * @Test(priority=11) // go To The Country Maker To Verify Checker Has Approved
	 * The Modify Data Same public void
	 * goToTheCountryMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception
	 * { // click on log out button in Checker
	 * addholidaymaker.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
	 * addholidaymaker = new AddHolidayMaker(driver);
	 * addholidaymaker.enterloginid("lastmile8");
	 * addholidaymaker.enterpassword("password@1"); addholidaymaker.clickonlogin();
	 * Thread.sleep(5000); addholidaymaker.toverifyhomepage(); Thread.sleep(5000);
	 * addholidaymaker.clikonmasterdefinitionmakerMenu();
	 * addholidaymaker.clickonAddHolidayMakerSubMenu();
	 * addholidaymaker.toswitchFieldsareinmandatory();
	 * addholidaymaker.clickOnviewButtoninMakerPage();
	 * addholidaymaker.switchToNewWindow(1); // Enter the values one By one in
	 * Search Box in view page //currencypage.verifyViewpages("ABC123","FX","COUR");
	 * addholidaymaker.verifyViewpagesWhenModifyTheCounterAndApprovedDoneByChecker(
	 * "BD","C","E"); // By Verify the particular Text With Column Values
	 * //currencypage.multippleSelectVerifyTextInViewPage();
	 * 
	 * Thread.sleep(5000);
	 * addholidaymaker.toVerifyByTextInViewMakerPagewhenModified();
	 * //Thread.sleep(5000); //currencypage.selectAllvaluesOneByOne();
	 * Thread.sleep(5000);
	 * addholidaymaker.toVerifytheModifyDataInMakerViewPagByUsingDropDown(); }
	 * 
	 */ 
    @Test(priority=12)
    // switch To window Modify View Page To ADD Payment Type MAKER Page
    // and LogOut
	public void   switchTowindowModifyViewPageToPaymentTypePage() throws Exception {
   Thread.sleep(5000);
   addholidaymaker.SwitchTheWindowFrom3ChildToParent();
   addholidaymaker.clickOnlogoutMakerButton();
	 
}
    // login to Checker And Go To View Page of Checker To  Verify the Approved Data is available or Not
    // view page of checker 
    @Test(priority = 13)
	public void testloginToCountryCheckerToVerifyCheckerViewPageWhenModifedTheCountry() throws Throwable {
		addholidaymaker.enterloginid("lastmile3");
		addholidaymaker.enterpassword("password@1");
		addholidaymaker.clickonlogin();
		addholidaymaker.clickonMasterDefinitionChecker();
		addholidaymaker.clickOnAddHolidayCheckerSubMenu();
		addholidaymaker.verifyHolidayCheckerPages();
		addholidaymaker.clickOnviewInChecker();
		driver.manage().window().maximize();
		addholidaymaker.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page 
	    addholidaymaker.verifyViewpagesOfCheckeerWhenApprovedDoneByHolidayChecker("777777905","BD","2020-02-25");
		addholidaymaker.toVerifyByTextInViewCheckerPagewhenAddedMaker();
		addholidaymaker.toVerifytheCheckerViewPagWhenAddedMakerHasApprovedByUsingDropDown();
		//Thread.sleep(5000);
		   addholidaymaker.SwitchTheWindowFrom4ChildToParent();
		   addholidaymaker.clickOnlogoutCheckerButton();
    }
 

}
