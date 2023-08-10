package com.hybridFramework.loginPage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.LoginRG;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

/**
 * 
 * Ghulam Sarwar
 */
public class LoginRGTest extends TestBase{
	private final Logger log = LoggerHelper.getLogger(LoginRGTest.class);
	
	
	
	@Test(priority=1)
	public void testLoginToApplication(){
		
		  log.info(LoginRGTest.class.getName()+" started"); 
		  Config config = new
		 Config(OR); driver.get(config.getWebsite());
		 
		
		LoginRG CCAvenuepage = new LoginRG(driver);
		driver.manage().window().maximize();
		CCAvenuepage. enterusername("mcpg@123");
		 
		CCAvenuepage.enterpassword("pass@1239");
		CCAvenuepage.clickonlogin();
		CCAvenuepage.enterAmounInCCavenuespage("70000");
		CCAvenuepage.clickonMakepayment();
		CCAvenuepage.getTextpaymentInformationPage();
		CCAvenuepage.clickonRemittanceOnBillingInformationPage();
		CCAvenuepage.clickonSelecteBankdropDown();
		CCAvenuepage.clickonMakepaymenButtonToSubbmitSelectBank();
		
		// Here Started Remit Guru page
		
		CCAvenuepage.verifyRGLoginpageForTesting();
		CCAvenuepage.enterusernameinRGLoginpage("ghulam202020@gmail.com");
		 CCAvenuepage.enterpasswordinRGLoginpage("password@5");
		 CCAvenuepage.clikOnchecbox();
		 CCAvenuepage.clickOnGLoginButton();
		 CCAvenuepage.toVerifyKYCPending();
		 //CCAvenuepage.clickOncontinuebuttonInErrorPage();
		 
	}
	
	
	@Test (priority=3)		
    public void peformSeachAndClick1stLink() {
		
		System.out.println("678");
		//CCAvenuepage.clikOnchecbox();
	}


}
	
	
	
