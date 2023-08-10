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
import com.hybridFramework.PageObject.AddPaymentTypeMaker;
import com.hybridFramework.PageObject.AddPurposeMaker;
import com.hybridFramework.PageObject.FileFormatListCheck;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class FileFormatListCheckTest extends TestBase {
	FileFormatListCheck fileformatlistcheck;

	private final Logger log = LoggerHelper.getLogger(FileFormatListCheckTest.class);

	@Test(priority = 1)
	public void testLoginToFileFormatListCheck() throws InterruptedException {
		log.info(Currency.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		fileformatlistcheck = new FileFormatListCheck(driver);
		fileformatlistcheck.enterloginid("lastmile1");
		fileformatlistcheck.enterpassword("password@2");
		fileformatlistcheck.clickonlogin();

	}

	@Test(priority = 2)
	public void testToFileFormatListCheckPage() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		fileformatlistcheck.toverifyhomepage();
		fileformatlistcheck.clikonmasterdefinitionmakerMenu();
		fileformatlistcheck.clickOnFileFormatListCheckSubMenu();
		fileformatlistcheck.toswitchFieldsareinmandatory();
		fileformatlistcheck.selectCorporateIdOnAddFileFormatListCheckpage();
		fileformatlistcheck.enterUniqueID("02");
		fileformatlistcheck.enterCorporateRemittanceReferenceNumber("EFG");
		fileformatlistcheck.enterDateOnRequiredPosition("12-02-2020");
		fileformatlistcheck.enterRemitterNameOnRequiredPosition("GH");
		fileformatlistcheck.enterRemitterIDTypeOnRequiredPosition("GH01");
		fileformatlistcheck.enterRemitterIDNoOnRequiredPosition("GH00");
		fileformatlistcheck.enterRemittercustomerAddress1OnRequiredPosition("Mumbai");
		fileformatlistcheck.enterRemittercustomerPINZIPCode("022222");
		fileformatlistcheck.enterRemittersEmailID("sarawr@avenues.in");
		fileformatlistcheck.enterRemittersContactno("8296880039");
		fileformatlistcheck.enterRemittersCountry("India");
		fileformatlistcheck.enterRemittersstate("Maharashtra");
		fileformatlistcheck.enterMandateType("Entity");
		fileformatlistcheck.enterTransferAmount("10000");
		fileformatlistcheck.enterBeneficiaryName("Raza");
		fileformatlistcheck.enterBeneficiaryCountry("India");
		fileformatlistcheck.enterBeneficiaryState("Bihar");
		fileformatlistcheck.enterBeneficiarycustomerAddress1("Adye,Bihar,824232");
		fileformatlistcheck.enterBeneficiarycustomerPINOrZIPCode("824232");
		fileformatlistcheck.enterBeneficiarycustomerEmailID("raza@gmail.com");
		fileformatlistcheck.enterBeneficiarycustomermobileno("789290909090");
		fileformatlistcheck.enterRemittancePurposeCode("RP01");
		fileformatlistcheck.enterRemittanceTypeOrPurpose("26");
		fileformatlistcheck.enterRelationshipwithbeneficiary("Brother");
		fileformatlistcheck.enterBankName("punjab National Bank");
		fileformatlistcheck.enterBankBranch("Patna");
		fileformatlistcheck.enterBranchCode("PBR01");
		fileformatlistcheck.enterRoutingNumber("9090");
		fileformatlistcheck.enterBankAccountnumber("1088080");
		fileformatlistcheck.enterBeneBankAddress("patna, Bihar,8080");
		fileformatlistcheck.enterCashAgentName("Saif");
		fileformatlistcheck.enterCashAgentBranch("Patana");
		fileformatlistcheck.enterBeneficiaryIDType("Adhar");
		fileformatlistcheck.enterBeneficiaryIDNo("1632");
		fileformatlistcheck.enterCashPayoutPin("1000");
		fileformatlistcheck.enterWalletName("PayTm");
		fileformatlistcheck.enterWalletNo("9090");
		fileformatlistcheck.enterDELIMITER("12");
		fileformatlistcheck.enterRemitterDob("20-01-1996");
		fileformatlistcheck.enterBeneDob("19-05-20001");
		fileformatlistcheck.enterCurrency("Rs");
		fileformatlistcheck.enterRemitterPassportNumber("012345");
		fileformatlistcheck.enterPassportExpirydate("2021");
		fileformatlistcheck.enterRemitterOtherID("Voter Id");
		fileformatlistcheck.enterRemitterOtheridExpirydate("2021");
		fileformatlistcheck.enterRemitterOccupation("Self Employee");
		fileformatlistcheck.enterpercentConsent("10 %");

		// driver.quit();
		// fileformatlistcheck.clickOnviewButtoninMakerPage();
		fileformatlistcheck.clickonsubmitInMakerpage();
		fileformatlistcheck.handleThePopup();
		// fileformatlistcheck.verifySuccesfullMessage();
	}

	@Test(priority = 3)
	public void clickOnViewButtonOnMakerAndVerifyViewPagewithSerachFieldTextandDropDown() throws Exception {
		Thread.sleep(5000);
		fileformatlistcheck.clickOnviewButtoninMakerPage();
		fileformatlistcheck.switchToNewWindow(1);
		fileformatlistcheck.verifyViewpageBySearchField();
		fileformatlistcheck.multippleSelectVerifyTextInViewPage();
		fileformatlistcheck.selectAllvaluesOneByOne();

	}

	// Switch the Child window (File Format List view page ) To parent window(File
	// Format List page)
	@Test(priority = 4)
	public void switchToMainwindow() throws Exception {
		// switch view page to Maker page and click on Modify button.
		fileformatlistcheck.switch2();
		Thread.sleep(5000);
		fileformatlistcheck.selectCorporateIdInModifyFileFormatListCheckPage();
		// click on first Submit button
		fileformatlistcheck.clickOnsubmitbutton();
		// modify Submit Button
		Thread.sleep(5000);
		fileformatlistcheck.clickmodifysubmitbutton();
		Thread.sleep(5000);
		fileformatlistcheck.verificationMessageInModifyPaymentTypePage();

	}

	@Test(priority = 5)
	// go To The Country Maker To Verify Checker Has Approved The Modify Data Same
	public void goToTheFileFormatListCheckerToVerifyWhenTheModifyData() throws Exception {
		// click on log out button in Checker
		fileformatlistcheck.gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker();
		Thread.sleep(5000);
		// driver.quit();

		// fileformatlistcheck = new FileFormatListCheck(driver);
		fileformatlistcheck.enterloginid("lastmile1");
		fileformatlistcheck.enterpassword("password@2");
		fileformatlistcheck.clickonlogin();

		Thread.sleep(5000);
		fileformatlistcheck.toverifyhomepage();
		Thread.sleep(5000);
		fileformatlistcheck.clikonmasterdefinitionmakerMenu();
		fileformatlistcheck.clickOnFileFormatListCheckSubMenu();
		fileformatlistcheck.toswitchFieldsareinmandatory();
		fileformatlistcheck.clickOnviewButtoninMakerPage();
		fileformatlistcheck.switchToNewWindow(1);
		// Enter the values one By one in Search Box in view page
		// currencypage.verifyViewpages("ABC123","FX","COUR");
		fileformatlistcheck.verifyViewpageBySerachFieldWhenModifyTheAddFileFormatListCheck();
		// By Verify the particular Text With Column Values
		// currencypage.multippleSelectVerifyTextInViewPage();

		Thread.sleep(5000);
		fileformatlistcheck.toVerifyByTextInViewMakerPagewhenModified();
		// Thread.sleep(5000);
		// currencypage.selectAllvaluesOneByOne();
		Thread.sleep(5000);
		fileformatlistcheck.toVerifytheModifyDataInMakerViewPagByUsingDropDown();
	}

	@Test(priority = 6)
	// switch To window Modify View Page To File Format List Check Page
	// and LogOut
	public void switchTowindowModifyViewPageToFileFormatListCheckPage() throws Exception {
		Thread.sleep(5000);
		fileformatlistcheck.SwitchTheWindowFrom3ChildToParent();
		fileformatlistcheck.clickOnlogoutMakerButton();

	}
	
}
