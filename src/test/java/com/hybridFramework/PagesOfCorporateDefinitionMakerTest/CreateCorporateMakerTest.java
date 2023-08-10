package com.hybridFramework.PagesOfCorporateDefinitionMakerTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PagesOfCorporateDefinitionMaker.CreateCorporateMaker;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class CreateCorporateMakerTest extends TestBase {
	CreateCorporateMaker createcorporate;

	private final Logger log = LoggerHelper.getLogger(CreateCorporateMakerTest.class);

	@Test(priority = 1)
	public void testLoginToCreateCorporateMaker() throws InterruptedException {
		log.info(CreateCorporateMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		createcorporate = new CreateCorporateMaker(driver);
		// Test_maker1,password@1,Test_maker1==password@1
		createcorporate.enterloginid("Test_maker1");
		createcorporate.enterpassword("password@1");
		createcorporate.clickonlogin();

	}

	@Test(priority = 2)
	public void testToCreateCorporateMakerPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		createcorporate.toverifyhomepage();
		createcorporate.clickoncorporatedefinitionmakerMenu();
		createcorporate.clickoncreatecorporatemakerSubMenu();
		//createcorporate.verifyPageTitle();
		createcorporate.toswitchFieldsareinmandatory();
		createcorporate.selectCountrydropdown();
		// to verify the Same values store in the String Array and verify the same
	    createcorporate.verifyingCorporateTypeIDFromDropDownByUsingStringArray();
		
		createcorporate.entercorporateCRN("Automate");
		createcorporate.entercorporateName("Naveen");
		createcorporate.entercorporateDesc("automation La");
		createcorporate.enterwebsite("www.navvenautomation1.com");
		createcorporate.selectcmsCustomerDropDown();
		createcorporate.entercorpCode("002");
		createcorporate.enterclientCode("003");
		createcorporate.enterindustry("IIT");
		createcorporate.enterexh_houseORBankName("ex1-house");
		createcorporate.enterbangladeshbankapprovalreference("yy");
		Thread.sleep(3000);
		createcorporate.selectApprovalDate();
		createcorporate.entersecuritydepositunder("1000");
		createcorporate.enterbankguaranteerefrencewithexpiry("02-09-2020");
		createcorporate.enterminBalanceNRT("500");
		createcorporate.entercompanyaddresszipcode("805128");
		createcorporate.selectgroupDropDown();
		createcorporate.enterlineOfBusiness("lob");
		createcorporate.enterofficialEmail("naveen1@gmail.com");
		createcorporate.enteraddress1("Mumbai1");
		createcorporate.enteraddress2("Mumbai2");
		createcorporate.enteraddress3("Mumbai3");
		createcorporate.entercity("Mumbai");
		createcorporate.enterstate("Maharashtara");
		createcorporate.enterzipcode("400051");
		createcorporate.selectcountryCodeDropDown();
		createcorporate.enterdebitNarration("dnn");
		
		
	}
	@Test(priority = 3)
		public void toTabContactDetailsPage() {
		createcorporate.clickcontactDetailsNew();
		createcorporate.entercontactPersons("Navee");
		createcorporate.enterdesignation("QA senior");
		createcorporate.entertelNo("445789286");
		createcorporate.entermobNo("7892857991");
		createcorporate.enteremailId("abc1@gmail.com");
		//createcorporate.selectisActiveCountry();
		//createcorporate.clickonsubmitInMakerpage();
		//createcorporate.verifySuccessfulMessageOnMakerPage();
		}
	@Test(priority = 4)
	public void tabProcessingDetailsNewPage() throws Exception {
		Thread.sleep(3000);
		createcorporate.clickOnprocessingDetailsNewtab();
		Thread.sleep(3000);
		createcorporate.selectuploadTypeDropDown();
		createcorporate.selectownPurposeCode();
		createcorporate.selectIPAddressCheck();
		createcorporate.selectSTP();
		createcorporate.selectauthoriserType();
		createcorporate.selectisRipple();
		createcorporate.entercountCorporate("6");
		createcorporate.selectfirstLineHeader();
		createcorporate.enterrowCountCorporate("7");
		createcorporate.selectsingleColExcel();
		createcorporate.enterseperateSingleColExcel("2");
		createcorporate.selectfileTypes();
		createcorporate.enterseperateTxtFormat("~");
		createcorporate.enterfooterStartColumn("2");
		createcorporate.enterfooterIdentificationText("%");
		createcorporate.enterremarks("Not Mandatory");
		Thread.sleep(5000);
		createcorporate.clickOnprocessingDetailssubmitInMakerpage();
		createcorporate.verifySuccessfulMessageOnMakerPage();
	}
	@Test(priority = 5)
	public void tabDocumentsUploadPage() throws Exception {
		Thread.sleep(3000);
		//createcorporate.clickOnuploadDocumentsNewTab();
		//Thread.sleep(3000);
		
		/*
		 * createcorporate.enteragreementFileName("yii");
		 * createcorporate.enterguaranteeFileName("hg");
		 * createcorporate.enterlicenseFileName("jio");
		 */
		//createcorporate.clickonuploadDocumentssubmiButtontInMakerpage();
	    //createcorporate.verifySuccessfulMessageOnMakerPage();
	}
	

	@Test(priority = 6)
	public void loginToCreateCorporateChecker() throws Exception {
		//
		createcorporate.enterloginid("lastmile7");
		createcorporate.enterpassword("password@2");
		createcorporate.clickonlogin();
		// createcorporate.toverifyhomepage();
		createcorporate.clickonCorporateDefinitionCheckerMenu();
		createcorporate.clickOnAuthoriserCreateCorporateSubMenu();

	}

	@Test(priority = 7)
	public void verifyAddcheckerListinAuthorizeCreateCorporateCheckerpage() throws Exception {
		createcorporate.toswitchFieldsareinmandatory();
         Thread.sleep(3000);
		// below is for array List
		createcorporate.verifyChekerPageByText();
		createcorporate.HandleTheDynamicVluesWithCheckbox();

	}

	// in Checker page
	@Test(priority = 8)
	public void clickonsubmitbuttonAndverifySuccesfullMessagePage() {

		createcorporate.clickonsubmitbuttonAndverifySuccesfullMessage();

	}

	@Test(priority = 9)
	// go to maker Page
	// login from checker to Maker Need to pass driver
	public void gotoMakerPageWhenCheckerApprovedCreateCorporatepage() throws Exception {
		createcorporate.gotoMakerWhenCheckerApproved();
		// here we call the driver because the without can not Automate
		createcorporate = new CreateCorporateMaker(driver);
		createcorporate.enterloginid("Test_maker1");
		createcorporate.enterpassword("password@1");
		createcorporate.clickonlogin();
		Thread.sleep(5000);
		createcorporate.toverifyhomepage();
		Thread.sleep(5000);
		createcorporate.clickoncorporatedefinitionmakerMenu();
		createcorporate.clickoncreatecorporatemakerSubMenu();
		Thread.sleep(3000);
		createcorporate.toswitchFieldsareinmandatory();
		createcorporate.viewinMakerPage();
		createcorporate.switchToNewWindow(1);
		// below is working but i have commented
		createcorporate.verifyViewpageBySearchField();
		Thread.sleep(3000);
		//createcorporate.VerifyViewPageByGetText();
		

	}

	// switch To Main window Corporate Modify Maker
	@Test(priority = 10)
	public void switchToMainwindow() throws Exception {
		createcorporate.clickOnEditButtonWhenUniqueValueHasMapped();
		  Thread.sleep(5000);
		 createcorporate.switchToNewWindow(1);
        createcorporate.clickOnsubmitbutton();
		createcorporate.verificationMessageInEditCreateCorporateMakerPage();
		createcorporate.switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired();
		createcorporate.clickOnLogOutBuutonOnMakerPage();
		}
	
// login To Corporate Checker if Modify the Same data 
@Test(priority = 11)
	public void testloginToCreateCorporateCheckerPageWhenModify() throws Exception {
		createcorporate.enterloginid("lastmile7");
		createcorporate.enterpassword("password@2");

		createcorporate.clickonlogin();
		createcorporate.clickonCorporateDefinitionCheckerMenu();
		createcorporate.clickOnAuthoriserCreateCorporateSubMenu();

	}

	@Test(priority = 12)
	// verify Create Corporate checker Page List After Modification has
	public void verifyCreateCorporateCheckerPageListAfterModificationhasDoneByMaker() throws Exception {
		Thread.sleep(3000);
		createcorporate.toswitchFieldsareinmandatory();
		createcorporate.verifyCreateCorporateCheckerPageModificationhasDoneByMaker();
		createcorporate.selectThecheckboxOnCheckerPageWhenModifyMakerDaata();
		createcorporate.clickonsubmitbuttonAndverifySuccesfullMessageIfModify();
	}

	@Test(priority = 13)
	// go To The Create Corporate Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheCreateCorporateMakerToVerifyCheckerHasApprovedTheModifyData() throws Exception {
		// click on log out button in Checker
		createcorporate.gotoMakerWhenCheckerApproved();
		createcorporate = new CreateCorporateMaker(driver);
		createcorporate.enterloginid("Test_maker1");
		createcorporate.enterpassword("password@1");
		createcorporate.clickonlogin();
		Thread.sleep(5000);
		createcorporate.toverifyhomepage();
		Thread.sleep(5000);
		createcorporate.clickoncorporatedefinitionmakerMenu();
		createcorporate.clickoncreatecorporatemakerSubMenu();
		Thread.sleep(3000);
        createcorporate.toswitchFieldsareinmandatory();
		createcorporate.viewinMakerPage();
		createcorporate.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		createcorporate.verifyViewpageBySearchField();
		Thread.sleep(3000);
		//createcorporate.VerifyViewPageByGetText();

	}

	@Test(priority = 14)
	// switch To window Modify View Page To Create Corporate Maker Page
	// and LogOut
	public void switchTowindowModifyViewPageToCreateCorporateMakerPage() throws Exception {
		Thread.sleep(5000);
		createcorporate.SwitchTheWindowFrom3ChildToParent();
		createcorporate.clickOnlogoutMakerButton();

	}

	
}
