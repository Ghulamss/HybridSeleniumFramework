package com.hybridFramework.PageObject;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hybridFramework.helper.Javascript.JavaScriptHelper;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.hybridFramework.helper.genericHelper.GenericHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

/**
 * 
 * Ghulam Sarwar
 */
public class LoginRG {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginRG.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//input[@id='userName']")
	WebElement username;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement login;

	@FindBy(id = "amount")
	WebElement Amount;

	@FindBy(id = "checkin")
	WebElement Makepayment;

	@FindBy(xpath = "//span[text()='Payment Information']")
	WebElement getpaymentInformation;

	@FindBy(xpath = "//div[@id='verticalTab']/ul[1]/li[11]")
	WebElement clickonRemittance;

	@FindBy(id = "remit")
	WebElement clickondropDown;

	@FindBy(xpath = "//div[@id='verticalTab']/div[1]/div[11]/div/div[4]/a[1]/span")
	WebElement clickonMakepaymenButton;

	@FindBy(xpath = "//a[@class='logo']")
	WebElement verifyRGLogo;
	// *[text()='Login']
	// h3[@class='title']
	@FindBy(xpath = "//h3[@class='title']")
	WebElement verifyRGLoginpage;

	@FindBy(id = "userId")
	WebElement usernameinRGLoginpage;

	@FindBy(id = "password")
	WebElement passwordinRGLoginpage;
	@FindBy(xpath = "//p[@class='cm-text-link']/input")
	WebElement checbox;
	@FindBy(id = "toggle")
	WebElement RGLogin;
	// Verify KYC Pending Error Message
	@FindBy(xpath = "//h2[text()='Transaction Error']")
	WebElement VerifyKYCPending;
	// Verify KYC pending Text
	@FindBy(xpath = "//p[text()='Kyc Pending']")
	WebElement VerifyKYCPendingText;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement clickOncontinuebutton;

	public LoginRG(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver, username, new Config(TestBase.OR).getExplicitWait());
	}

	public void enterusername(String username) {
		log.info("enter user name...");
		this.username.sendKeys(username);
	}

	public void enterpassword(String password) {
		log.info("enter password...");
		this.password.sendKeys(password);

	}

	public void clickonlogin() {
		log.info("Click on login......");
		this.login.click();
	}

	public void enterAmounInCCavenuespage(String Amount) {
		log.info("enter Amoun In CCavenues page .....");
		this.Amount.sendKeys(Amount);
	}

	public void clickonMakepayment() {
		log.info("click on Makepayment  ....");
		this.Makepayment.click();

	}

	public void getTextpaymentInformationPage() {

		log.info("get Text payment Information Page........");
		String getText = getpaymentInformation.getText();
		System.out.println(getText);
		Assert.assertEquals(getText, "Payment Information");
	}

	public void clickonRemittanceOnBillingInformationPage() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("click on Remittance On Billing InformationPage ......");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		clickonRemittance.click();

	}

	public void clickonSelecteBankdropDown() {
		Select drpBank = new Select(clickondropDown);
		// drpBank.selectByVisibleText("Remit Guru");
		log.info("click on dropDown ......");

		drpBank.selectByIndex(1);
		log.info("click on Selected By Index ......");

	}

	public void clickonMakepaymenButtonToSubbmitSelectBank() {
		log.info("click on Makepayment Button To Subbmit Select Bank.....");
		clickonMakepaymenButton.click();
		log.info(" Get Title of page.....");

		String TitlepageofRG = driver.getTitle();
		System.out.println(TitlepageofRG);
	}

	public void verifyRGLogoInRGLoginPage() {
		log.info("veri");
		verifyRGLogo.isDisplayed();

		String Logoname = verifyRGLogo.getText();
		System.out.println(Logoname);
	}

	// Text of RG login Page
	public void verifyRGLoginpageForTesting() {

		String aa = verifyRGLoginpage.getText();
		System.out.println(aa);

	}

	public void enterusernameinRGLoginpage(String usernameinRGLoginpage) {
		log.info("enter username in RG Login page..........");

		this.usernameinRGLoginpage.sendKeys(usernameinRGLoginpage);

	}

	public void enterpasswordinRGLoginpage(String passwordinRGLoginpage) {
		log.info("enter password in RG Login page..........");

		this.passwordinRGLoginpage.sendKeys(passwordinRGLoginpage);

	}

	public void clikOnchecbox() {
		log.info("click on Checkbox........");
		this.checbox.click();

	}

	public void clickOnGLoginButton() {
		log.info("click On RG Login Button........");

		this.RGLogin.click();

	}

	public void toVerifyKYCPending() {
		log.info("to Verify KYC Pending....." + VerifyKYCPending.getText());
		String KYCPending = VerifyKYCPending.getText();
		System.out.println(KYCPending);
		// Assert.assertEquals(KYCPending,"Transaction Error");
		if (KYCPending.contains("Transaction Error")) {
			if (VerifyKYCPendingText.getText().equals("Kyc Pending")) {
				log.info(" If KYC Is Pending.....");
				System.out.println(VerifyKYCPendingText.getText());
				System.out.println("Kyc is Pending");
			} else if (VerifyKYCPendingText.getText().equals("Kyc is not Pending")) {
				System.out.println("Kyc is not Pending ");
			}

		}

		else {

			System.out.println("if 'Transaction Error' is not Matched with verification....");
		}

	}

	public void clickOncontinuebuttonInErrorPage() {
		log.info("click On continue button In ErrorPage or KYC Pending page.......");
		this.clickOncontinuebutton.click();

	}

}