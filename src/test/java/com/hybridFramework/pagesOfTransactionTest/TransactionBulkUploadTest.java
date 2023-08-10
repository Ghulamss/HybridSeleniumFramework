package com.hybridFramework.pagesOfTransactionTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.pagesOfTransaction.TransactionBulkUpload;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class TransactionBulkUploadTest extends TestBase {
	TransactionBulkUpload transactionbulkupload;
	public static String getfilePathTxtBox;
	String getuujj;
	private final Logger log = LoggerHelper.getLogger(TransactionBulkUploadTest.class);

	@Test(priority = 1)
	public void testLoginToTransactionBulkUploadMaker() throws InterruptedException {
		log.info(TransactionBulkUploadTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		transactionbulkupload = new TransactionBulkUpload(driver);
		// lastmile8,password@1,lastmile8==password@1
		transactionbulkupload.enterloginid("lastmile8");
		transactionbulkupload.enterpassword("password@1");
		transactionbulkupload.clickonlogin();

	}

	@Test(priority = 2)
	public void testToAddFileOnBulkUploadMaker() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		transactionbulkupload.toverifyhomepage();
		transactionbulkupload.clickonTransactionMakerMenu();
		transactionbulkupload.clickonTransactionBulkUploadMakerSubMenu();
		transactionbulkupload.toswitchFieldsareinmandatory();
		transactionbulkupload.selectCorporateID();
		transactionbulkupload.selectGroupCountry();
		transactionbulkupload.attachTheFile("F:\\AL AHLIA_File\\AL AHLIA_auto_05.xls");
		transactionbulkupload.gerfileName();
		Thread.sleep(5000);
		transactionbulkupload.clickOnUploadfile();
		transactionbulkupload.clickOnLogOutButton();
		// transactionbulkupload. verifySuccessfulMessageOnMakerPage();
	}

	@Test(priority = 3)
	public void testLoginToBulkUploadchecker() throws Exception {
		//
		transactionbulkupload.enterloginid("lastmile7");
		transactionbulkupload.enterpassword("password@2");
		transactionbulkupload.clickonlogin();
		// transactionbulkupload.toverifyhomepage();
		transactionbulkupload.clickonTransactionOnCheckerMenu();
		transactionbulkupload.clickOnTransactionBulkUploadCheckerSubMenu();
		// transactionbulkupload.verifyTransactionFileUploadCheckerPage();

	}

	@Test(priority = 4)
	public void testToverifyBulkUploadCheckerpageWhenAdded() throws Exception {
		transactionbulkupload.toswitchFieldsareinmandatory();
		transactionbulkupload.corporateDropdownBySelectClass();
		// transactionbulkupload.verifyCorporateIDOnCheckerPage();
		transactionbulkupload.selectCountryOnCheckerPage();
		transactionbulkupload.verifyAttachFileOnChecker();
		transactionbulkupload.clickOnUploadfile();
		transactionbulkupload.clickOnLogOutButton();
		// transactionbulkupload.verifySuccesfullMessageOnCheckerPage();
		// transactionbulkupload.clickOnCheckStatusOnCheckerPage();
	}

	// in Transaction Approval Maker page
	@Test(priority = 5)
	public void testToCorporateTransactionApprovalMakerPage() throws Exception {
		Thread.sleep(60000);
		transactionbulkupload.enterloginid("lastmile8");
		transactionbulkupload.enterpassword("password@1");
		transactionbulkupload.clickonlogin();
		transactionbulkupload.clickonTransactionMakerMenu();
		transactionbulkupload.clickonCorporateTransactionApprovalMakerSubMenu();
		transactionbulkupload.toswitchFieldsareinmandatoryOnTransaction();
		transactionbulkupload.selectGoupIDDropDown();
		transactionbulkupload.selectCorporateID();
		transactionbulkupload.selectGroupCountry();
		transactionbulkupload.selectSingleRadioButton();
		Thread.sleep(3000);
		transactionbulkupload.selectFileNameOnMakerPage();
		transactionbulkupload.clickonsubmitInTransactionMakerpage();
		transactionbulkupload.clickOnsubmitButtonOnTransactionApprovalMakerpage();
		transactionbulkupload.clickOnLogOutButton();
	}

	@Test(priority = 6)
	// Login to Transaction Approval Checker Page
	public void testTotransactionApprovalCheckaerPage() throws Exception {
		transactionbulkupload.enterloginid("lastmile7");
		transactionbulkupload.enterpassword("password@2");
		transactionbulkupload.clickonlogin();
		// transactionbulkupload.toverifyhomepage();
		transactionbulkupload.clickonTransactionOnCheckerMenu();
		transactionbulkupload.clickOnCorporateTransactionApprovalCheckerSubMenu();
		transactionbulkupload.verifyTransactionApprovalCheckerPage();

	}

	@Test(priority = 7)
	// verify the Transaction Approval Checker Page As Maker has Added
	public void verifytheTransactionApprovalCheckerPage() {
		transactionbulkupload.verifyselectstrGroupIdOnCheckerPage();
		transactionbulkupload.verifyCorporateIDOnCheckerPage();
		transactionbulkupload.selectCountryOnCheckerPage();
		transactionbulkupload.verifyselectSingleRadioButton();
		transactionbulkupload.selectFileOnTransactionApprovalChecker();
		transactionbulkupload.clickOnsubmitOnTransactionApprovalCheckerpage();
		transactionbulkupload.clickOnsubmitButtonOnTransactionApprovalCheckerpage();
	}
	
}