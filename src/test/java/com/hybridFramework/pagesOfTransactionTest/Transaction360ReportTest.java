package com.hybridFramework.pagesOfTransactionTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.pagesOfTransaction.Transaction360Report;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class Transaction360ReportTest extends TestBase {
	Transaction360Report tr360report;
	public static String getfilePathTxtBox;
	String getuujj;
	private final Logger log = LoggerHelper.getLogger(Transaction360ReportTest.class);

	@Test(priority = 1)
	public void testLoginToApplication() throws InterruptedException {
		log.info(Transaction360ReportTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		tr360report = new Transaction360Report(driver);
		// lastmile8,password@1,lastmile8==password@1
		tr360report.enterloginid("lastmile8");
		tr360report.enterpassword("password@1");
		tr360report.clickonlogin();

	}

	@Test(priority = 2)
	public void testLoginToBulkUploadMaker() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		tr360report.toverifyhomepage();
		
		
//		tr360report.clickonTransactionMakerMenu();
//		tr360report.clickonTransactionBulkUploadMakerSubMenu();
//		tr360report.toswitchFieldsareinmandatory();
//		tr360report.selectCorporateID();
//		tr360report.selectGroupCountry();
//		tr360report.attachTheFile("F:\\AL AHLIA_File\\AL AHLIA_auto_04.xls");
//		tr360report.gerfileName();
//		Thread.sleep(5000);
//		tr360report.clickOnUploadfile();
//		tr360report.clickOnLogOutButton();
//		
		// tr360report. verifySuccessfulMessageOnMakerPage();
	}

	/*
	 * @Test(priority = 3) public void testtoBulkUploadchecker() throws Exception {
	 * // tr360report.enterloginid("lastmile7");
	 * tr360report.enterpassword("password@2");
	 * tr360report.clickonlogin(); //
	 * tr360report.toverifyhomepage();
	 * tr360report.clickonTransactionOnCheckerMenu();
	 * tr360report.clickOnTransactionBulkUploadCheckerSubMenu(); //
	 * tr360report.verifyTransactionFileUploadCheckerPage();
	 * 
	 * }
	 * 
	 * @Test(priority = 4) public void verifyBulkUploadCheckerpageWhenAdded() throws
	 * Exception { tr360report.toswitchFieldsareinmandatory();
	 * tr360report.corporateDropdownBySelectClass(); //
	 * tr360report.verifyCorporateIDOnCheckerPage();
	 * tr360report.selectCountryOnCheckerPage();
	 * tr360report.verifyAttachFileOnChecker();
	 * tr360report.clickOnUploadfile();
	 * tr360report.clickOnLogOutButton(); //
	 * tr360report.verifySuccesfullMessageOnCheckerPage(); //
	 * tr360report.clickOnCheckStatusOnCheckerPage(); }
	 * 
	 * // in Transaction Approval Maker page
	 * 
	 * @Test(priority = 5) public void CorporateTransactionApprovalMakerPage()
	 * throws Exception { tr360report.enterloginid("lastmile8");
	 * tr360report.enterpassword("password@1");
	 * tr360report.clickonlogin();
	 * tr360report.clickonTransactionMakerMenu();
	 * tr360report.clickonCorporateTransactionApprovalMakerSubMenu();
	 * tr360report.toswitchFieldsareinmandatoryOnTransaction();
	 * tr360report.selectGoupIDDropDown();
	 * tr360report.selectCorporateID();
	 * tr360report.selectGroupCountry();
	 * tr360report.selectSingleRadioButton(); Thread.sleep(3000);
	 * tr360report.selectFileNameOnMakerPage();
	 * tr360report.clickonsubmitInTransactionMakerpage();
	 * tr360report.clickOnsubmitButtonOnTransactionApprovalMakerpage();
	 * tr360report.clickOnLogOutButton(); }
	 * 
	 * @Test(priority = 6) // Login to Transaction Approval Checker Page public void
	 * transactionApprovalCheckaerPage() throws Exception {
	 * tr360report.enterloginid("lastmile7");
	 * tr360report.enterpassword("password@2");
	 * tr360report.clickonlogin(); //
	 * tr360report.toverifyhomepage();
	 * tr360report.clickonTransactionOnCheckerMenu();
	 * tr360report.clickOnCorporateTransactionApprovalCheckerSubMenu();
	 * tr360report.verifyTransactionApprovalCheckerPage();
	 * 
	 * }
	 * 
	 * @Test(priority = 7) // verify the Transaction Approval Checker Page As Maker
	 * has Added public void verifytheTransactionApprovalCheckerPage() {
	 * tr360report.verifyselectstrGroupIdOnCheckerPage();
	 * tr360report.verifyCorporateIDOnCheckerPage();
	 * tr360report.selectCountryOnCheckerPage();
	 * tr360report.verifyselectSingleRadioButton();
	 * tr360report.selectFileOnTransactionApprovalChecker();
	 * tr360report.clickOnsubmitOnTransactionApprovalCheckerpage();
	 * tr360report.clickOnsubmitButtonOnTransactionApprovalCheckerpage();
	 * }
	 */
	@Test(priority = 3)
	public void report360() throws Exception {
		tr360report.clickOnMISReportMenu();
		tr360report.clickOnTransaction360Report();
		Thread.sleep(5000);
		//tr360report.verifyTransactionReportPage();
		tr360report.toswitchField();
		tr360report.entercotporateRefrenceNumber("AL4043101238");
		tr360report.clickOnSubmitButtonOnTransactionReport();
		
	}
}