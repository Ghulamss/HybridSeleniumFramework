package com.hybridFramework.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
public class LoginPage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WaitHelper waitHelper;

	@FindBy(xpath = "//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signin;

	@FindBy(id = "userId")
	WebElement emailAddress;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "toggle")
	WebElement submitLogin;

	@FindBy(xpath = "//*[@id='center_column']/p")
	WebElement successMsgObject;

	@FindBy(xpath = "//*[@id='email_create']")
	WebElement registration;

	@FindBy(xpath = "//*[@id='SubmitCreate']")
	WebElement createAnAccount;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver, signin, new Config(TestBase.OR).getExplicitWait());
	}

	public void clickOnSignInLink() {
		log.info("clicked on sign in link...");
		//signin.click();
	}

	public void enterEmailAddress(String emailAddress) {
		log.info("entering email address...." + emailAddress);
		this.emailAddress.sendKeys(emailAddress);
	}

	public void enterPassword(String password) {
		log.info("entering password...." + password);
		this.password.sendKeys(password);
	}

	public HomePage clickOnSubmitButton() {
		log.info("clicking on submit button...");
		new JavaScriptHelper(driver).scrollDownVertically();
		submitLogin.click();
		return new HomePage(driver);
	}

	public boolean verifySuccessLoginMsg() {
		return new GenericHelper().isDisplayed(successMsgObject);
	}

	public void enterRegistrationEmail() {
		String email = System.currentTimeMillis() + "@gmail.com";
		log.info("entering registration email.." + email);
		registration.sendKeys(email);
	}

	public RegistrationPage clickOnCreateAnAccount() {
		createAnAccount.click();
		return new RegistrationPage(driver);
	}

	public void loginToApplication(String emailAddress, String password) {
		//clickOnSignInLink();
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickOnSubmitButton();
	}

	/*
	 * @FindBy(id="userId") WebElement loginid;
	 * 
	 * @FindBy(id="password") WebElement password;
	 * 
	 * @FindBy(id="toggle") WebElement loginbutton;
	 * 
	 * 
	 * public LoginPage(WebDriver driver) {
	 * 
	 * PageFactory.initElements(driver, this); waitHelper = new WaitHelper(driver);
	 * waitHelper.waitForElement(driver, loginid,new
	 * Config(TestBase.OR).getExplicitWait());
	 * 
	 * 
	 * }
	 * 
	 * public void entervaluesintoLoginId(String loginid) {
	 * 
	 * log.info("enter values into Login Id........."+loginid);
	 * this.loginid.sendKeys(loginid);
	 * 
	 * 
	 * }
	 * 
	 * public void entervaluesintopasword(String password) {
	 * 
	 * log.info("enter values into pasword......"+password);
	 * this.password.sendKeys(password);
	 * 
	 * }
	 * 
	 * 
	 * public void clickOnLogingButton() {
	 * log.info("click On Loging Button .........");
	 * 
	 * loginbutton.click();
	 * 
	 * }
	 */

}
