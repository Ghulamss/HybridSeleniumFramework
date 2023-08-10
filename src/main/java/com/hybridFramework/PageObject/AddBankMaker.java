package com.hybridFramework.PageObject;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

// AddCompanyMaker also know as Add Purpose Maker 
public class AddBankMaker {
	static WebDriver driver;

	private final Logger log = LoggerHelper.getLogger(AddBankMaker.class);
	WaitHelper waitHelper;

	@FindBy(id = "userId")
	WebElement loginid;

	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "toggle")
	WebElement login;
	@FindBy(xpath = "//*[text()='Prime Last Mile']")
	WebElement mainheader;
	@FindBy(xpath = "//*[text()='Master Definition Maker']")
	WebElement masterdefinitionmaker;
	@FindBy(xpath = "//*[text()='Add Bank Maker']//parent::a")
	WebElement AddBankMaker;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;
	@FindBy(xpath = "//input[@id='bankId']")
	WebElement BankId;

	@FindBy(xpath = "//input[@id='bankName']")
	WebElement BankName;
	@FindBy(xpath = "//input[@id='email']")
	WebElement Email;
	@FindBy(xpath = "//select[@id='isIMPSFlag']")
	WebElement isActiveIMPSFlag;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
// Statrted  Checker X-path

	@FindBy(xpath = "//*[text()='Master Definition Checker']")
	WebElement MasterDefinitionChecker;
	@FindBy(xpath = "//*[text()='Add Bank Checker']//parent::a")
	WebElement AddBankChecker;
	@FindBy(xpath = "//td[contains(text(),' Bank Checker')]")
	WebElement verifyBankCheckerPage;
	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> checkbox;
	// //input[@type='checkbox']//parent::th for getting Text of Header of
	@FindBy(xpath = "//th//input[@type='checkbox']")
	List<WebElement> Headercheckbox;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement SubmitbuttononChecker;

	@FindBy(xpath = "//td[@class='note']//parent::tr//preceding-sibling::tr[2]")
	WebElement verifysuccessfulMessageinChecker;

	@FindBy(xpath = "//b[text()='Logout']")
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
// Modify Page in Maker
	@FindBy(xpath = "//input[@value='Modify']")
	WebElement ModifyButton;

	@FindBy(xpath = "//*[text()='Modify Bank Maker']")
	WebElement verifyModifyBankMakerPage;

	@FindBy(xpath = "//select[@name='bankId']")
	WebElement selectBankIdInModifyPage;
	@FindBy(name = "Submit")
	WebElement submitbuttonModifyMaker;
	// form[@name='modifyCountry']//table//tr[15]//td//input[@name='Submit']

	@FindBy(xpath = "//form[@name='modifyBank']//table//tr[12]//td//input[@name='Submit']")
	WebElement modifysubmitbutton;
	@FindBy(xpath = "//td[@class='note']")
	WebElement verificationMessageInModifyCountry;

	@FindBy(xpath = "//b[text()='Logout']")
	WebElement logoutMaker;

	// View Page in Checker
	//
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewInChecker;

	public AddBankMaker(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.waitForElement(driver, loginid, 10);
		// waitHelper.waitForElement(driver, loginid, 60);
	}

	// enter username
	public void enterloginid(String loginid) {
		log.info("enter login id..");
		this.loginid.clear();
		this.loginid.sendKeys(loginid);
	}

	// enter password
	public void enterpassword(String password) {
		log.info("enter password=>");
		this.password.clear();
		this.password.sendKeys(password);

	}

// click on login
	public void clickonlogin() {
		log.info("Click On Login button..");
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

//
	public void clikonmasterdefinitionmakerMenu() {
		log.info("clik on master definition maker Menu==>" + masterdefinitionmaker.getText());
		masterdefinitionmaker.click();
	}

//  Add Bank Maker
	public void clickonAddBankMakerSubMenu() {
		log.info("click on Add Bank Maker SubMenu===>" + AddBankMaker.getText());
		AddBankMaker.click();
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

	static String getBankId;
	static String getBankName;
	static String getEmail;
	static String getIsActiveBank;

// enter Bank Id in Add Bank Maker page
	public void enterBankId(String BankId) {
		log.info("Enter Bank Id==>" + BankId);
		this.BankId.sendKeys(BankId);
		getBankId = BankId.toString();
		System.out.println("get Bank Id value==>" + getBankId);

	}

// enter Bank Name in Add Bank Maker page
	public void enterBankName(String BankName) {
		log.info("enter Bank Name==>" + BankName);
		this.BankName.sendKeys(BankName);
		getBankName = BankName.toString();
		System.out.println("get Bank Name Value==>" + getBankName);
	}

// enter Email in Bank Maker page
	public void enterEmail(String Email) {
		log.info("enter Email ==>");
		int a = Email.length();
		System.out.println(a);
		this.Email.sendKeys(Email);
		getEmail = Email.toString();
		System.out.println("get Email Value==>>" + getEmail);

	}

// select  is Active Currency? in Add Currency Maker page
	public void selectisActiveBank() {
		String s = "Yes";
		log.info("select is Active Bank  ?==" + isActiveIMPSFlag);
		Select aa = new Select(isActiveIMPSFlag);
		aa.selectByVisibleText(s);
		String getisActive = s.toString();
		System.out.println("get Is Active Bank ===>>" + getisActive);
		String[] spl = getisActive.split("es");
		System.out.println("Split Array Values of Yes ===>>" + spl);
		List<String> splitList1 = Arrays.asList(spl);
		getIsActiveBank = String.join("", splitList1);
		System.out.println("get Is Active Bank after Split (Yes) As Y==>" + getIsActiveBank);
	}

// click on  submit In add  Currency Maker page
	public void clickonsubmitInMakerpage() {
		log.info("click on submit In Maker page==>" + submitInMakerpage);
		submitInMakerpage.click();
	}

//  to verify the Successful Message to the Added the  Currency maker Successfully
	public void verifySuccesfullMessage() {

		String verifythemodify = SuccesfullMessage.getText();
		System.out.println("verify the Successful Message===>>>" + verifythemodify);
		log.info("verify the Successful Message===>>>" + verifythemodify);
		if (verifythemodify.equals("Record has been added successfully.")) {
			driver.switchTo().defaultContent();
			log.info("Click On Log Out Button...");

			log.info("==Successfull Message has Matched with  Text==");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("This Country Code has already used.")) {
			log.info("This Country Code has already used");
			driver.switchTo().defaultContent();
			log.info("Click On Log Out Button...");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("Record Already Exists")) {
			log.info("Record Already Exists");
			driver.switchTo().defaultContent();
			log.info("Click On Log Out Button...");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();

		} else {
			log.info(" Verification Text Message has Not Matched");
			driver.switchTo().defaultContent();
			log.info("Click On Log Out Button...");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();

		}
	}

// click on Master Definition Checker
	public void clickonMasterDefinitionChecker() {
		log.info(" Get text Master Definition Checker==>" + MasterDefinitionChecker.getText());
		log.info("Clcik on MasterDefinitionChecker==>");
		MasterDefinitionChecker.click();

	}

	// click On Add Bank Checker SubMenu
	public void clickOnAddBankCheckerSubMenu() {
		log.info("click On Add Bank Checker SubMenu==>" + AddBankChecker.getText());
		AddBankChecker.click();
	}

	// verify Bank Checker Page
	public void verifyBankCheckerPage() throws Exception {
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		log.info("Get Text of Bank Checker Page==>" + verifyBankCheckerPage.getText());
		String bankCheckerPage = verifyBankCheckerPage.getText();

		System.out.println("Get Text Bank Checker Page is ==>" + bankCheckerPage);
		Assert.assertEquals("BANK CHECKER", bankCheckerPage);
		log.info("Successfully verified the Bank Checker Page.");
	}

	// calling path variables and verifyAddcheckerList in Bank Checker page.
	public void verifyAddcheckerListOnBankCheckerpage() throws InterruptedException {
		String bankId = "//table[@id='list']//tbody/tr/td[4]";
		String bankName = "//table[@id='list']//tbody/tr/td[5]";
		String email = "//table[@id='list']//tbody/tr/td[6]";
		String IsActiveBank = "//table[@id='list']//tbody/tr/td[7]";

		toverifyCheckerlist(bankId, getBankId);
		toverifyCheckerlist(bankName, getBankName);
		toverifyCheckerlist(email, getEmail);
		toverifyCheckerlist(IsActiveBank, getIsActiveBank);

	}

// Calling the Generic Method to verify the List in Currency Checker page.
	private void toverifyCheckerlist(String xpathvalue, String value) throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list On Checker page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text of  Checker list on Checker page==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Get Text of  Checker list Matched with value ==>" + value);
				// driver.findElement(By.xpath("//input[@id='selectAll']")).click();

				break;
			} else {

				System.out.println("Get Text of  Checker list NOT Matched with value ==>" + value);
				// driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();

			}
		}
	}

	public void HandleTheDynamicVluesWithCheckbox() throws Exception {
		List<WebElement> web = driver.findElements(By.xpath("//table[@id='list']//tbody/tr/td[4]"));
		int sizeOfColumn = web.size();
		System.out.println("size Of Column===>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get Text of Column To select Checkbox==>>" + name);
			if (name.contains(getBankId)) {
				System.out.println("Get Text has Mtched With value" + getBankId);
				Thread.sleep(3000);
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				log.info("Click On Check Box ");

			} else {
				System.out.println("Text has  Not Mtched with value" + getBankId);
			}
		}

	}


// click on submit button And verify Succesfull Message on Checker  Page.
	public void clickonsubmitbuttonAndverifySuccesfullMessage() {

		// Click on Submit button Checker Page. To Select only one Checkbox
		log.info(" click on Submit button on Checker===>>" + SubmitbuttononChecker.getText());
		SubmitbuttononChecker.click();
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		log.info("successful Message in Checker====" + verifysuccessfulMessageinChecker.getText());
		Assert.assertEquals(successfulMessageinChecker, "Record updated successfully.");

	}

//  to gotoMakerCheckerApprovedBank
// calling p=7
	public void gotoMakerPageWhenCheckerApproved() throws InterruptedException {
		driver.switchTo().defaultContent();
		log.info("Click on Logout in checker Page" + Logoutinchecker.getText());
		Logoutinchecker.click();

	}

	// View page in Maker , After Approved by the Checker data
	public void viewinMakerPage() {
		log.info("click on view in Maker===" + viewinMaker.getText());
		viewinMaker.click();
	}

	public void switchToNewWindow(int windowNumber) {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite = s.iterator();
		int i = 1;
		while (ite.hasNext() && i < 10) {
			String popupHandle = ite.next().toString();
			driver.switchTo().window(popupHandle);
			System.out.println("Window title is : " + driver.getTitle());
			System.out.println("Window Window is : " + driver.getWindowHandles());
			int windowCount = 0;
			if (i == windowCount)
				break;
			i++;

		}
		driver.manage().window().maximize();

	}

// in view Page , search by different values passing into search box,
// refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
// 1. when the Verify the Maker View page when Bank has Approved by the Bank Checker
	public void verifyViewpagesBySrachField() throws InterruptedException {
		this.searchfield.clear();
		log.info("Searh By Bank Id==>" + getBankId);
		this.searchfield.sendKeys(getBankId);
		this.searchfield.clear();
		log.info("Search By Bank Name =>" + getBankName);
		this.searchfield.sendKeys(getBankName);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("Search By currency==>" + getEmail);
		this.searchfield.sendKeys(getEmail);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("Search By Is Active Bank ==>" + getIsActiveBank);
		this.searchfield.sendKeys(getIsActiveBank);
		Thread.sleep(4000);
		this.searchfield.clear();

		driver.navigate().refresh();

		Select entitieslist = new Select(selectentitieslist);
		Thread.sleep(4000);
		List<WebElement> Noofentitieslist = entitieslist.getOptions();
		int nooflist = Noofentitieslist.size();
		System.out.println("No of entities list====>>" + nooflist);
		entitieslist.selectByVisibleText("All");
		for (int i = 0; i < nooflist; i++) {
			String entitiestext = Noofentitieslist.get(i).getText();
			System.out.println("Get entities text===>" + entitiestext);
		}

	}

// x-path of view page and calling their respective variable  and verify
	public void VerifyViewPageByTextField() {

		String BankId = "//tbody[@role='alert']//tr//td[2]";
		String BankName = "//tbody[@role='alert']//tr//td[3]";
		String Email = "//tbody[@role='alert']//tr//td[4]";
		String ISActiveBank = "//tbody[@role='alert']//tr//td[5]";

		verifyTheViewPageWithGetText(BankId, getBankId);
		verifyTheViewPageWithGetText(BankName, getBankName);
		verifyTheViewPageWithGetText(Email, getEmail);
		verifyTheViewPageWithGetText(ISActiveBank, getIsActiveBank);

	}

// verify the View Maker Page with Text with thier respective Column
	public static void verifyTheViewPageWithGetText(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list On View Page==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text of  Respective Column On View Page ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Column Get Text List Has Matched With Value ==>" + value);
				break;
			} else {

				System.out.println("Column Get Text List Has NOT Matched With Value ==>" + value);
			}
		}

	}

// Select  All Drop down values in Maker view page when the Added Currency has Approved By Checker 
	public void verifyTheViewPageWithSelectGivenValueOnDropDown() {
		WebElement selectBankId = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectBankName = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectEmail = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectISActive = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));

		verifyTheViewPageWithSelectDropDown(selectBankId, getBankId);
		verifyTheViewPageWithSelectDropDown(selectBankName, getBankName);
		verifyTheViewPageWithSelectDropDown(selectEmail, getEmail);
		verifyTheViewPageWithSelectDropDown(selectISActive, getIsActiveBank);

	}

// selectAllvaluesOneByOne
// select one by one of Select in View page of Maker
	public static void verifyTheViewPageWithSelectDropDown(WebElement xpathvalue, String value) {

		Select sel = new Select(xpathvalue);
		List<WebElement> N = sel.getOptions();
		int Nooflist = N.size();
		System.out.println("No of list On Select Drop down In View Page ==>" + Nooflist);
		for (int i = 0; i < N.size(); i++) {
			String listText = N.get(i).getText();
			System.out.println(" Get Text of Selct Drop down In View Page ==>" + listText);
			if (N.get(i).getText().equals(value)) {
				System.out.println(
						"List of Get Text of Select Drop down Has Matched with Value In View Page ==>" + value);
				sel.selectByVisibleText(value);
				break;
			} else {

				System.out.println(
						"List of Get Text of Select Drop down Has Matched with Value In View Page ==>" + value);

			}
		}

	}

// switch one  Child window to parent window
	public void switchToWindowByUsingIterator() throws Exception {

		Dimension d = new Dimension(800, 480);
		driver.manage().window().setSize(d);
		driver.getTitle();
		System.out.println("get tittle of the Page===>" + driver.getTitle());
		// System.out.println("get PageSourceof the Page===>"+driver.getPageSource());
		System.out.println("get CurrentUrlof the Page===>" + driver.getCurrentUrl());
		driver.manage().getCookieNamed("name");
		// driver.navigate().refresh();
		Thread.sleep(10000);
		Set<String> handles1 = driver.getWindowHandles();
		Iterator<String> it1 = handles1.iterator();
		// iterate through your windows
		while (it1.hasNext()) {
			String parent = it1.next();
			String newwin = it1.next();
			String newwin1 = it1.next();
			driver.switchTo().window(parent);
			driver.manage().window().maximize();
			driver.switchTo().defaultContent();

//		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
//		System.out.println(iframeElements);
//
//		driver.switchTo().frame(0);
			// driver.switchTo().frame("iframe");
			WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

			System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());

			String modifybutton = driver.findElement(By.xpath("//input[@value='Modify']")).getText();
			System.out.println("Get Text of modify button===>>" + modifybutton);
			driver.findElement(By.xpath("//input[@value='Modify']")).click();

		}
	}

//  Switch the  Make View page to 
	public void switch2() {

		String parent_handle = driver.getWindowHandle();
		System.out.println(parent_handle);
		// driver.findElement(By.name("New Message Window")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		for (String handle1 : handles)
			if (!parent_handle.equals(handle1)) {
				driver.switchTo().window(handle1);
				System.out.println(handle1);
			}

		driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
		log.info("click on Modify Button==>" + ModifyButton.getText());
		ModifyButton.click();

		log.info(" Get the Text of Bank Modify Ppage===>>" + verifyModifyBankMakerPage.getText());
		Assert.assertEquals(verifyModifyBankMakerPage.getText(), "MODIFY BANK MAKER");
		log.info(" verified the Modify Bank Maker Ppage");


	}

	// select Bank Id In Modify Maker Page
	public void selectcBankIdInModifyMakerPage() {
		driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
		Select selectBankId = new Select(selectBankIdInModifyPage);
		List<WebElement> AllBankId = selectBankId.getOptions();
		int noofBankIdOnDropDown = AllBankId.size();
		System.out.println("Get the No of Bank Id Drop Down==>" + noofBankIdOnDropDown);

		for (int i = 0; i < AllBankId.size(); i++) {
			String GetTextOfAllDropDownValues = AllBankId.get(i).getText();
			System.out.println("Get Text Of All Drop Down Values==>" + GetTextOfAllDropDownValues);

			if (AllBankId.get(i).getText().equals("aa-aa")) {
				log.info(" ====Matched the Given Data=====");

				selectBankId.selectByVisibleText("aa-aa");
				System.out.println("Bank Id Matched the From Bank Id Drop Down In MODIFY Bank MAKER page ==>>");
				break;
			} else {
				System.out.println("Bank Id Not Matched the From Bank Id Drop Down MODIFY Bank MAKER page=====>>");
			}
		}
	}

	public void selectBankIdInModifyMakerPageByUsingSplitAsPerAddingValue() {

		driver.switchTo().defaultContent();
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);
		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));
		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());

		String selectBankId = "//select[@name='bankId']//option";

		selectBankIdDropDownInModifyMakerPageByUsingIndex(selectBankId, getBankName);

	}

	public static void selectBankIdDropDownInModifyMakerPageByUsingIndex(String xpathvalue, String value) {
		List<WebElement> bankIdList = driver.findElements(By.xpath(xpathvalue));
		int bankIdSize = bankIdList.size();
		System.out.println("Get Size of Bank Id ==>" + bankIdSize);
		for (int i = 0; i < bankIdList.size(); i++) {
			String getTextOfBankIdDropDown = bankIdList.get(i).getText();
			String[] splt = getTextOfBankIdDropDown.split("-");
			String splivalues = splt[0].trim();
			System.out.println("split values==" + splivalues);

			System.out.println("get Text Of Bank Id Drop Down===>>" + getTextOfBankIdDropDown);
			if (splivalues.equals(value)) {
				System.out.println("Get Text of Drop down Values has Matched ==>" + value);
				bankIdList.get(i).click();
				System.out.println("Get Text has Selected And Matched With value ==>" + value);
				break;

			} else {
				System.out.println("Get Text of Drop down Values has NOT Matched ==>" + value);
			}
		}
	}

	// submit button on Modify maker page
	public void clickOnsubmitbutton() {
		log.info("Click on submitbutton" + submitbuttonModifyMaker.getText());
		submitbuttonModifyMaker.click();

	}

	// click on modify submit button in Modify maker page
	public void clickmodifysubmitbutton() {
		// driver.switchTo().defaultContent();
		log.info(" click on modify submit button==>" + modifysubmitbutton.getText());
		modifysubmitbutton.click();
	}

	// verification Message In Modify Country
	public void verificationMessageInModifyCurrencyPage() throws Exception {
		log.info("verification Message In Modify Currency==>>" + verificationMessageInModifyCountry.getText());
		// Assert.assertEquals(verificationMessageInModifyCountry.getText(), "This
		// Currency name has already used.");

		// verification Message In Modify Country
		String verifythemodify = verificationMessageInModifyCountry.getText();
		System.out.println("Get the verify the Modify Successful Message===>>>" + verifythemodify);
		log.info("Get the verify the Modify Successful Message===>>>" + verifythemodify);
		if (verifythemodify.equals("This Currency name has already used.")) {
			// Thread.sleep(4000);
			driver.switchTo().defaultContent();
			log.info("==Successfull Message has Matched with  Text==");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("This Country Code has already used.")) {
			log.info("This Country Code has already used");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("===Not==")) {
			log.info("This is Not Matched");

		} else if (verifythemodify.equals("Record has been modified successfully.")) {
			log.info("Record has been modified successfully.");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();

		} else {
			// Thread.sleep(5000);
			driver.switchTo().defaultContent();
			log.info("==Successfull Message has Not Matched with  Text==");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		}

	}

	// verify the Bank checker List IF Modification has Done By Maker with
	// Existing Entity
	public void verifyCurrencycheckerListModificationhasDoneByMaker() throws InterruptedException {
		String bankId = "//table[@id='list']//tbody/tr/td[4]";
		String bankName = "//table[@id='list']//tbody/tr/td[5]";
		String email = "//table[@id='list']//tbody/tr/td[6]";
		String IsActiveBank = "//table[@id='list']//tbody/tr/td[7]";

		toverifyCheckerPageListValueWithText(bankId, getBankId);
		toverifyCheckerPageListValueWithText(bankName, getBankName);
		toverifyCheckerPageListValueWithText(email, getEmail);
		toverifyCheckerPageListValueWithText(IsActiveBank, getIsActiveBank);
	}

	// Calling the Generic Method to verify the List in Currency Checker page.
	private void toverifyCheckerPageListValueWithText(String xpathvalue, String value) throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list on Checker Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("Get Text of  Checker list ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Get Text of  Checker list Matched with value ==>" + value);
				// driver.findElement(By.xpath("//input[@id='selectAll']")).click();

				break;
			} else {

				System.out.println("Get Text of  Checker list NOT Matched with value ==>" + value);
				// driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();

			}

		}

	}

	public void selectThecheckboxOnCheckerPageWhenModifyMakerDaata() {
		String BankId = "//table[@id='list']//tbody/tr/td[4]";

		selectThecheckboxOnCheckerPageWhenModify(BankId, getBankId);
	}

	public void selectThecheckboxOnCheckerPageWhenModify(String xpathvalue, String value) {

		List<WebElement> web = driver.findElements(By.xpath(xpathvalue));
		int sizeOfColumn = web.size();
		System.out.println("Size Of Common Column Values ==>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get Text Of Unique Values To select Checkbox ==>" + name);
			if (name.contains(value)) {
				System.out.println("Get Text has Mtched with value==>" + value);
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				log.info("Click on Checkbox with Matched Values" + value);

				break;
			} else {
				System.out.println("Get Text has NOT Mtched with value ==>" + value);
			}
		}

	}

		// click on submit button And verify Succesfull Message If Modifythe Bank Maker
	public void clickonsubmitbuttonAndverifySuccesfullMessageIfModifyBankMaker() {

		// Click on Submit button Checker Page. To Select only one Checkbox
		log.info(" click on Submit button on Checker===>>" + SubmitbuttononChecker.getText());
		SubmitbuttononChecker.click();
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		log.info("successful Message in Checker====" + verifysuccessfulMessageinChecker.getText());
		// Assert.assertEquals(successfulMessageinChecker, "Record updated
		// successfully."," Successful Message has Not Matched");

		if (verifysuccessfulMessageinChecker.getText().equals("Record updated successfully.")) {

		} else if (verifysuccessfulMessageinChecker.getText().equals("")) {

		}

	}

//in view Page , search by different values passing into search box,
//refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
	// 2. when the Modified the Currency then "View" page Maker
	public void verifyViewpagesBySearchFieldWhenModifyAndApprovedDoneByChecker() throws InterruptedException {
		this.searchfield.clear();
		log.info("Searh By Bank Id==>" + getBankId);
		this.searchfield.sendKeys(getBankId);
		this.searchfield.clear();
		log.info("Search By Bank Name =>" + getBankName);
		this.searchfield.sendKeys(getBankName);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("Search By currency==>" + getEmail);
		this.searchfield.sendKeys(getEmail);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("Search By Is Active Bank ==>" + getIsActiveBank);
		this.searchfield.sendKeys(getIsActiveBank);
		Thread.sleep(4000);
		this.searchfield.clear();

		driver.navigate().refresh();

		Select entitieslist = new Select(selectentitieslist);
		Thread.sleep(4000);
		List<WebElement> Noofentitieslist = entitieslist.getOptions();
		int nooflist = Noofentitieslist.size();
		System.out.println("No of entities list====>>" + nooflist);
		entitieslist.selectByVisibleText("All");
		for (int i = 0; i < nooflist; i++) {
			String entitiestext = Noofentitieslist.get(i).getText();
			System.out.println("Get entities text===>" + entitiestext);
		}

	}

//to Verify Column Text In View Page WithHeader Column
//x-path of view page and calling their respective variable  and verify
	public void toVerifyTextInViewPageWithHeaderColumn() {

		String BankId = "//tbody[@role='alert']//tr//td[2]";
		String BankName = "//tbody[@role='alert']//tr//td[3]";
		String Email = "//tbody[@role='alert']//tr//td[4]";
		String ISActive = "//tbody[@role='alert']//tr//td[5]";

		verifyTheMakerViewPageWhenModified(BankId, getBankId);
		verifyTheMakerViewPageWhenModified(BankName, getBankName);
		verifyTheMakerViewPageWhenModified(BankId, getEmail);
		verifyTheMakerViewPageWhenModified(ISActive, getIsActiveBank);

	}

// 
// verify the View Maker Page with Text with thier respective Column
	public static void verifyTheMakerViewPageWhenModified(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list on Checker View Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("Get Text of Chaker View Page==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Get Text List has Matched with value ==>" + value);
				break;
			} else {

				System.out.println("Get Text List has NOT Matched with value ==>" + value);
			}
		}

	}

// To verify  By  All Select Filter Or To Verify the Modify Data in Maker View Page By Using Drop Down
// select All values One By One
//  5 drop down are available on the 
	public void toVerifytheModifyDataInMakerViewPagByUsingDropDown() {
		WebElement selectBankId = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectBankName = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectEmail = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectISActive = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));

		verifySelectDropDonInViewPage(selectBankId, getBankId);
		verifySelectDropDonInViewPage(selectBankName, getBankName);
		verifySelectDropDonInViewPage(selectEmail, getEmail);
		verifySelectDropDonInViewPage(selectISActive, getIsActiveBank);

	}

//
// select one by one of Select in View page of Maker
// 4 drop down using one by one select the values from drop down
	public static void verifySelectDropDonInViewPage(WebElement xpathvalue, String value) {

		Select sel = new Select(xpathvalue);
		List<WebElement> N = sel.getOptions();
		int Nooflist = N.size();
		System.out.println(" No of list of drop down ==>" + Nooflist);
		for (int i = 0; i < N.size(); i++) {
			String listText = N.get(i).getText();
			System.out.println("Get Text of Select Drop Down On View Page ==>" + listText);
			if (N.get(i).getText().equals(value)) {
				System.out.println("Get Text of drop down List Has Matched with value==>"+value);
				sel.selectByVisibleText(value);
				break;
			} else {

				System.out.println("Get Text of drop down List Has NOT Matched with value==>"+value);

			}
		}

	}

	public void switch3() throws InterruptedException {
		Thread.sleep(5000);
		String parent_handle = driver.getWindowHandle();
		System.out.println(parent_handle);

		// driver.findElement(By.name("New Message Window")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.numberOfWindowsToBe(3));
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		for (String handle1 : handles)
			if (!parent_handle.equals(handle1)) {
				driver.switchTo().window(parent_handle);
				System.out.println(handle1);
			}
		Thread.sleep(5000);

		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//b[text()='Logout']")).click();
//		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
//		System.out.println(iframeElements);
//
//		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
		log.info("click on Modify Button==>" + ModifyButton.getText());
		ModifyButton.click();

		log.info(" Get the Text of Modify Bank Maker Ppage===>>" + verifyModifyBankMakerPage.getText());
		log.info(" verify the Modify Bank Maker Ppage");
		Assert.assertEquals(verifyModifyBankMakerPage.getText(), "MODIFY Bank MAKER");

	}

//  Switch The Window From  3 Child(After Modified Data ) to Parent Child.
	public void SwitchTheWindowFrom3ChildToParent() throws Exception {

		Thread.sleep(5000);
		Set<String> handles1 = driver.getWindowHandles();
		Iterator<String> it1 = handles1.iterator();
		// iterate through your windows
		while (it1.hasNext()) {
			String parent = it1.next();
			String newwin = it1.next();
			String newwin1 = it1.next();
			driver.switchTo().window(parent);
			driver.manage().window().maximize();

		}
	}

// click On logout Maker Button
	public void clickOnlogoutMakerButton() throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		log.info("click on logout Button In Maker page===>" + logoutMaker.getText());
		logoutMaker.click();
	}

	public void clickOnviewInChecker() {
		log.info("click on view Button In Checker Page" + viewInChecker.getText());
		viewInChecker.click();
	}

//Switch The Window From  3 Child(After Modified Data ) to Parent Child.
	public void SwitchTheWindowFrom4ChildToParent() throws Exception {

		Thread.sleep(5000);
		Set<String> handles1 = driver.getWindowHandles();
		Iterator<String> it1 = handles1.iterator();
		// iterate through your windows
		while (it1.hasNext()) {
			String parent = it1.next();
			String newwin = it1.next();
			String newwin1 = it1.next();
			String newwin2 = it1.next();
			driver.switchTo().window(parent);
			driver.manage().window().maximize();

		}
	}

// 
	public void clickOnlogoutCheckerButton() throws Throwable {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().defaultContent();
		// To find the Frame is Available or not
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		

		String Header = driver.findElement(By.xpath("//td[text()=' Bank Checker']")).getText();

		System.out.println(Header);
		Assert.assertEquals("BANK CHECKER", Header);


		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().defaultContent();
		

		driver.findElement(By.xpath("//b[text()='Logout']")).click();

	}
}
