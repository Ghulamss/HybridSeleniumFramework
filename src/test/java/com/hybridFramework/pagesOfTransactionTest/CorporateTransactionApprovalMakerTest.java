package com.hybridFramework.pagesOfTransactionTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.pagesOfTransaction.CorporateTransactionApprovalMaker;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class CorporateTransactionApprovalMakerTest extends TestBase {
	CorporateTransactionApprovalMaker transactionapproval;

	private final Logger log = LoggerHelper.getLogger(CorporateTransactionApprovalMakerTest.class);

	@Test(priority = 1)
	public void testLoginToApplication() throws InterruptedException {
		log.info(CorporateTransactionApprovalMakerTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		transactionapproval = new CorporateTransactionApprovalMaker(driver);
		// lastmile8,password@1,lastmile8==password@1
		transactionapproval.enterloginid("lastmile8");
		transactionapproval.enterpassword("password@1");
		transactionapproval.clickonlogin();

	}

	@Test(priority = 2)
	public void testLoginToApplication2() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		transactionapproval.toverifyhomepage();
		transactionapproval.clickonTransactionMakerMenu();
		transactionapproval.clickonCorporateTransactionApprovalMakerSubMenu();
		transactionapproval.toswitchFieldsareinmandatory();
		transactionapproval.selectGoupIDDropDown();
		transactionapproval.selectCorporateID();
		transactionapproval.selectGroupCountry();
		transactionapproval.selectSingleRadioButton();
		Thread.sleep(3000);
		transactionapproval.selectFileNameOnMakerPage();
		transactionapproval.clickonsubmitInMakerpage();
		//transactionapproval.clickOnLogOutButton();
	}

	@Test(priority = 3)
	public void chekerlogin() throws Exception {
		//
		transactionapproval.enterloginid("test_checker2");
		transactionapproval.enterpassword("password@1");
		transactionapproval.clickonlogin();
		// transactionapproval.toverifyhomepage();
		transactionapproval.clickonTransactionOnCheckerMenu();
		transactionapproval.clickOnCorporateTransactionApprovalCheckerSubMenu();
		transactionapproval.verifyTransactionApprovalCheckerPage();

	}

	@Test(priority = 4)
	public void verifyCheckerpageWhenAdded() throws Exception {
		// transactionapproval.toswitchFieldsareinmandatory();
		// Thread.sleep(5000);
		transactionapproval.verifyselectstrGroupIdOnCheckerPage();
		transactionapproval.verifyCorporateIDOnCheckerPage();
		transactionapproval.selectCountryOnCheckerPage();
		transactionapproval.verifyselectSingleRadioButton();

	}

	// in Checker page
	@Test(priority = 5)
	public void verifySuccesfullMessagePage() {

		// transactionapproval.verifySuccesfullMessageOnCheckerPage();
		// transactionapproval.clickOnCheckStatusOnCheckerPage();

	}

}
