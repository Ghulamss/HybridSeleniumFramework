package com.hybridFramework.pagesOfTransaction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.helper.Wait.WaitHelper;

public class CorporateTransactionApprovalMaker {
	static WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(CorporateTransactionApprovalMaker.class);
	WaitHelper waitHelper;

	@FindBy(id = "userId")
	WebElement loginid;

	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "toggle")
	WebElement login;
	@FindBy(xpath = "//*[text()='Prime Last Mile']")
	WebElement mainheader;

	/*************************** Maker X path ****************************/
	@FindBy(xpath = "//*[text()='Transaction']//parent::a")
	WebElement Transaction;
	@FindBy(xpath = "//*[text()='Corporate Transaction Approval Maker']//parent::a")
	WebElement CorporateTransactionApprovalMaker;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;
	@FindBy(xpath = "//select[@name='strGroupId']")
	WebElement selectGoupID;
	@FindBy(xpath = "//select[@name='entityFileName']")
	WebElement selectFileName;

	@FindBy(xpath = "//select[@name='isActive']")
	WebElement isActiveCountry;
	@FindBy(xpath = "//input[@value='btSubmit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//b[text()='Logout']")
	WebElement LogoutOnMaker;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;

	/***** ********************** Statrted Checker X-path *****/

	@FindBy(xpath = "//*[text()='Transaction']//parent::a")
	WebElement TransactionOnChecker;
	@FindBy(xpath = "//*[text()='Corporate Transaction Approval Checker']//parent::a")
	WebElement CorporateTransactionApprovalChecker;
	@FindBy(xpath = "//*[text()='Transaction Approval Checker']")
	WebElement verifyTransactionApprovalChecker;
	@FindBy(xpath = "//select[@name='strGroupId']")
	WebElement selectstrGroupIdOnChecker;
	@FindBy(xpath = "//select[@name='entityId']")
	WebElement corporateIDOnChecker;
	@FindBy(xpath = "//select[@name='entityCountryCode']")
	WebElement selectCountryOnChecker;

	@FindBy(xpath = "//input[@value='Submit']")
	WebElement SubmitbuttononChecker;

	@FindBy(xpath = "//td[@class='note']")
	WebElement verifysuccessfulMessageinChecker;

	@FindBy(xpath = "//input[@name='status']")
	WebElement checkStatusButtonOnChecker;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement Logoutinchecker;

	// View page in Maker
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewinMaker;
	@FindBy(xpath = "//input[@type='text']")
	WebElement searchfield;

	@FindBy(xpath = "//select[@name='list_length']")
	WebElement selectentitieslist;
	@FindBy(xpath = "//select[@name='list_length']")
	WebElement logoutInMaker;

	@FindBy(name = "btSubmit")
	WebElement submitbuttonModifyMaker;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutMaker;

	// View Page in Checker
	//
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewInChecker;

	public CorporateTransactionApprovalMaker(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.waitForElement(driver, loginid, 10);
		// waitHelper.waitForElement(driver, loginid, 60);
	}

// enter username
	public void enterloginid(String loginid) {
		this.loginid.clear();
		this.loginid.sendKeys(loginid);
	}

	// enter password
	public void enterpassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);

	}

// click on login
	public void clickonlogin() {
		login.click();

	}

	public void toverifyhomepage() {
		String haeder = mainheader.getText();
		if (haeder.equals("Prime Last Mile")) {
			System.out.println("Home page Opened" + haeder);

		} else {
			log.info("Home page  Not Opened" + haeder);

		}
	}

// click on Transaction Maker Menu
	public void clickonTransactionMakerMenu() {
		log.info("click on Transaction Maker Menu ==>" + Transaction.getText());
		Transaction.click();
	}

// click on Corporate Transaction Approval Maker SubMenu
	public void clickonCorporateTransactionApprovalMakerSubMenu() {
		log.info("click on Corporate Transaction Approval Maker SubMenu ==>"
				+ CorporateTransactionApprovalMaker.getText());
		CorporateTransactionApprovalMaker.click();
	}

// to switch the Add Country Maker page.
	public void toswitchFieldsareinmandatory() throws Exception {
		Thread.sleep(5000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
		log.info(" To switch the main Enter values " + Fieldsareinmandatory.getText());
	}

	static List<String> groupcountryList;
	static String y;
	static String groupidString;
	static String GetTextOfGroupCountry;
	static String getgroupid;
	static String getcorporateid;

	public void selectGoupIDDropDown() {
		String groupid = "RGEX-RG ExHouse";
		getgroupid = groupid.toString();
		System.out.println("get corporate id Value ==>" + getgroupid);

		Select selecorporateid = new Select(selectGoupID);
		selecorporateid.selectByVisibleText(getgroupid);
		log.info("select corporate id ==>" + getgroupid);

	}

	public void selectCorporateID() {
		String corporateid = "3821 - AL AHLIA MONEY EXCHANGE BUREAU";
		getcorporateid = corporateid.toString();
		System.out.println("get corporate id Value ==>" + getcorporateid);
		log.info("select corporate id ==>" + getcorporateid);
		Select selecorporateid = new Select(driver.findElement(By.xpath("//select[@name='entityId']")));
		selecorporateid.selectByVisibleText(getcorporateid);
	}

	public void selectGroupCountry() throws Exception {

		String[] groupCountry = { "Bangladesh", "yhjgh" };
		// Thread.sleep(3000);
		System.out.println("Get the Text of String [] Array Before ==> " + groupCountry);
		groupcountryList = Arrays.asList(groupCountry);
		groupidString = String.join(",", groupcountryList);
		System.out.println("Get String Value of country code" + groupidString);

		methodofGroupCountry(driver, groupidString);

	}

	public static void methodofGroupCountry(WebDriver driver, String value) throws Exception {
		int j = 0;
		Thread.sleep(5000);
		Select selectGroupCountry = new Select(driver.findElement(By.xpath("//select[@name='entityCountryCode']")));
		List<WebElement> listOfGroupCountry = selectGroupCountry.getOptions();
		int getSizeOfGroupCountry = listOfGroupCountry.size();
		System.out.println("Get Size Of Group Country===>>" + getSizeOfGroupCountry);

		for (int i = 0; i < listOfGroupCountry.size(); i++) {
			GetTextOfGroupCountry = listOfGroupCountry.get(i).getText();
			System.out.println("Get Text Of Group Country ==>" + GetTextOfGroupCountry);

			for (String w : value.trim().split(",")) {
				// System.out.println("Get String values ==>>" + w);
				y = w.toString();
				System.out.println("global variable declearation ==>" + y);
				if (y.equals(GetTextOfGroupCountry)) {
					System.out.println("Text has Matched with String Array and Drop Down Values ==>" + y);

					// System.out.println("Get String values Matched with value and selected ==>>" +
					// w.toString());
					selectGroupCountry.selectByVisibleText(GetTextOfGroupCountry);
					log.info("drop down has selected");

					break;
				}

				else {
					System.out.println("Text has NOT Matched with String Array and Drop Down Values ==>" + y);
				}

			}
		}

	}

	public void selectSingleRadioButton() {
		List<WebElement> noofradiobuttons = driver.findElements(By.xpath("//label[@class='radio']"));
		int noofSize = noofradiobuttons.size();
		System.out.println("no of Size ==>" + noofSize);
		for (int i = 0; i < noofradiobuttons.size(); i++) {
			String getTextOfradioButton = noofradiobuttons.get(i).getText();
			System.out.println("get Text Of radio Button ==>" + getTextOfradioButton);
			if (getTextOfradioButton.equals("Bulk")) {
				noofradiobuttons.get(i).click();
				System.out.println("Radio button has Selected with ==>" + getTextOfradioButton);
			}
		}
	}

	public void selectFileNameOnMakerPage() {
		Select FileName = new Select(selectFileName);
		FileName.selectByIndex(1);
	}

// click on  submit In add Maker page
	public void clickonsubmitInMakerpage() {
		log.info("click on submit In Maker page==>" + submitInMakerpage);
		submitInMakerpage.click();
	}

// verify Successful Message On Maker Page
	public void verifySuccessfulMessageOnMakerPage() {

		String verifytheSuccessfulMessage = SuccesfullMessage.getText();
		System.out.println("verify the Successful Message ==>" + verifytheSuccessfulMessage);
		if (verifytheSuccessfulMessage.equals("File uploaded successfully.")) {
			log.info("File uploaded successfully.");

		} else if (verifytheSuccessfulMessage.equals("Duplicate File found.File cannot be Uploaded.")) {
			log.info("Duplicate File found.File cannot be Uploaded.");

		} else if (verifytheSuccessfulMessage.equals("Record Already Exists")) {
			log.info("Record Already Exists");

		}
	}

	
	public void clickOnLogOutButton() {
		log.info("Click On Log Out Link On Maker page ==>");
		driver.switchTo().defaultContent();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", LogoutOnMaker);
		LogoutOnMaker.click();

	}
	

// click on Transaction On Checker Menu
	public void clickonTransactionOnCheckerMenu() {
		log.info(" Get text of Transaction On Checker Menu ==>" + TransactionOnChecker.getText());
		TransactionOnChecker.click();

	}

	// click On Corporate Transaction Approval Checker SubMenu
	public void clickOnCorporateTransactionApprovalCheckerSubMenu() {
		log.info("click On Corporate Transaction Approval Checker Sub Menu===>>"
				+ CorporateTransactionApprovalChecker.getText());
		CorporateTransactionApprovalChecker.click();
	}

	public void verifyTransactionApprovalCheckerPage() throws Exception {
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		log.info("verify Transaction Approval Checker ==>" + verifyTransactionApprovalChecker.getText());
		String TransactionApprovalChecker = verifyTransactionApprovalChecker.getText();

		System.out.println("Get text of Transaction Approval Checker page ==>" + TransactionApprovalChecker);
		Assert.assertEquals("TRANSACTION APPROVAL CHECKER", TransactionApprovalChecker,
				"Text has Not Matched with Value");
		// TRANSACTION FILE UPLOAD CHECKER

	}

	public void verifyselectstrGroupIdOnCheckerPage() {
		log.info("verify select Group Id On Checker Page ==>");
		Select sGroupIdOnChecker = new Select(selectstrGroupIdOnChecker);
		sGroupIdOnChecker.selectByVisibleText(getgroupid);
		log.info("Corporate ID  Selected Successfully On Checker Page");
	}

	public void verifyCorporateIDOnCheckerPage() {
		Select sel = new Select(corporateIDOnChecker);
		sel.selectByVisibleText(getcorporateid);
		log.info("Corporate ID  Selected Successfully");
	}

	public void selectCountryOnCheckerPage() {
		Select selCorporate = new Select(selectCountryOnChecker);
		selCorporate.selectByVisibleText(y);
		log.info("Country Selected Successfully");
	}

	public void verifyselectSingleRadioButton() {
		List<WebElement> noofradiobuttons = driver.findElements(By.xpath("//label[@class='radio']"));
		int noofSize = noofradiobuttons.size();
		System.out.println("no of Size ==>" + noofSize);
		for (int i = 0; i < noofradiobuttons.size(); i++) {
			String getTextOfradioButton = noofradiobuttons.get(i).getText();
			System.out.println("get Text Of radio Button ==>" + getTextOfradioButton);
			if (getTextOfradioButton.equals("Bulk")) {
				noofradiobuttons.get(i).click();
				System.out.println("Radio button has Selected with ==>" + getTextOfradioButton);
			}
		}
	}

// verify Succesfull Message on Checker  Page.
	public void verifySuccesfullMessageOnCheckerPage() {
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		log.info("successful Message in Checker Page ==>" + verifysuccessfulMessageinChecker.getText());
		Assert.assertEquals(successfulMessageinChecker, "File Uploaded Successfully.");

	}

	public void clickOnCheckStatusOnCheckerPage() {
		log.info("Click On check Status Button On Checker ==>");
		checkStatusButtonOnChecker.click();

	}

//   go to Maker When Checker Approved Country
	public void gotoMakerCheckerApprovedCountry() throws InterruptedException {
		driver.switchTo().defaultContent();
		log.info("Click on Logout in checker Page" + Logoutinchecker.getText());
		Logoutinchecker.click();

	}

	public void clickOnlogoutCheckerButton() throws Throwable {

//	String bb = driver.findElement(By.className("mainmenu")).getText();
//	System.out.println(bb);
		// Scroll UP Method Which is used to
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().defaultContent();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement Category_Body = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//td[@class='mainmenu']//following-sibling::a[text()='Logout']")));
		System.out.println(Category_Body);

		driver.findElement(By.xpath("//a[text()='Logout']")).click();

	}
}
