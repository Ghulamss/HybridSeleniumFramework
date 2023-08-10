package com.hybridFramework.pagesOfTransactionTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.pagesOfTransaction.TransactionFileStatus;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class TransactionFileStatusTest extends TestBase {
	TransactionFileStatus filestatus;

	private final Logger log = LoggerHelper.getLogger(TransactionFileStatusTest.class);

	@Test(priority = 1)
	public void testLoginToApplication() throws InterruptedException {
		log.info(TransactionFileStatusTest.class.getName() + " started");
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		filestatus = new TransactionFileStatus(driver);
		// lastmile8,password@1,lastmile8==password@1
		filestatus.enterloginid("lastmile8");
		filestatus.enterpassword("password@1");
		filestatus.clickonlogin();

	}

	@Test(priority = 2)
	public void testLoginToApplication2() throws Exception {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.switchTo().defaultContent();
		filestatus.toverifyhomepage();
		filestatus.clickonTransactionMakerMenu();
		filestatus.clickonCorporateTransactionFileStatusSubMenu();
		filestatus.toswitchFieldsareinmandatory();
	    filestatus.selectCorporateID();
	    filestatus. selectDateFrom();
	    filestatus.selectDateTo();
		filestatus.clickonsubmitInMakerpage();
		filestatus.verifyAddcheckerListInCheckerpage();
		
		//filestatus.clickOnLogOutButton();
	}

	@Test(priority = 3)
	public void chekerlogin() throws Exception {
		//
		filestatus.enterloginid("test_checker2");
		filestatus.enterpassword("password@1");
		filestatus.clickonlogin();
		// filestatus.toverifyhomepage();
		filestatus.clickonTransactionOnCheckerMenu();
		filestatus.clickOnCorporateTransactionApprovalCheckerSubMenu();
		filestatus.verifyTransactionApprovalCheckerPage();

	}

	@Test(priority = 4)
	public void verifyCheckerpageWhenAdded() throws Exception {
		// filestatus.toswitchFieldsareinmandatory();
		// Thread.sleep(5000);
		filestatus.verifyselectstrGroupIdOnCheckerPage();
		filestatus.verifyCorporateIDOnCheckerPage();
		filestatus.selectCountryOnCheckerPage();
		filestatus.verifyselectSingleRadioButton();

	}

	// in Checker page
	@Test(priority = 5)
	public void verifySuccesfullMessagePage() {

		// filestatus.verifySuccesfullMessageOnCheckerPage();
		// filestatus.clickOnCheckStatusOnCheckerPage();

	}

}
