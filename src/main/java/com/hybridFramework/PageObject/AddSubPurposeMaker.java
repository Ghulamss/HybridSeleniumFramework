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
public class AddSubPurposeMaker {
	static WebDriver driver;

	private final Logger log = LoggerHelper.getLogger(AddSubPurposeMaker.class);
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
	@FindBy(xpath = "//*[contains(text(),'Add Sub Purpose Maker')]//parent::a")
	WebElement AddSubPurposeMaker;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;
	@FindBy(xpath = "//select[@name='countryCode']")
	WebElement selectcountryCode;

	@FindBy(xpath = "//select[@name='purposeCode']")
	WebElement selectPurposeCode;

	@FindBy(xpath = "//input[@name='subPurposeCode']")
	WebElement subpurposeCode;

	@FindBy(xpath = "//input[@name='Subpurpose']")
	WebElement subpurposeDesc;

	@FindBy(xpath = "//select[@id='isActive']")
	WebElement isActiveSubPurpose;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
// Statrted  Checker X-path

	@FindBy(xpath = "//*[text()='Master Definition Checker']")
	WebElement MasterDefinitionChecker;
	@FindBy(xpath = "//*[text()='Authoriser Sub Purpose']//parent::a")
	WebElement AuthoriserSubPurpose;
	@FindBy(xpath = "//td[contains(text(),' Sub Purpose Checker')]")
	WebElement verifySubPurposeCheckerPage;
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

	@FindBy(xpath = "//td[contains(text(),'Modify Sub Purpose Maker')]")
	WebElement verifyModifySubPurposeMakerPage;

	@FindBy(xpath = "//select[@name='purposeCode']")
	WebElement selectSubpurposeCodeInModifyPage;
	@FindBy(name = "Submit")
	WebElement submitbuttonModifyMaker;
	// form[@name='modifyCountry']//table//tr[15]//td//input[@name='Submit']

	@FindBy(xpath = "//form[@name='modifyStatus']//table//tr[2]//td//input[@name='Submit']")
	WebElement modifysubmitbutton;
	@FindBy(xpath = "//td[@class='note']")
	WebElement verificationMessageInModifyPaymentType;

	@FindBy(xpath = "//b[text()='Logout']")
	WebElement logoutMaker;

	// View Page in Checker
	//
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewInChecker;

	public AddSubPurposeMaker(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.waitForElement(driver, loginid, 10);
		// waitHelper.waitForElement(driver, loginid, 60);
	}

	// enter username
	public void enterloginid(String loginid) {
		log.info("Enter Login Id in login page==" + loginid.length());
		this.loginid.clear();
		log.info("Enter Login Id in login page==>>" + loginid.length());
		this.loginid.sendKeys(loginid);

	}

	// enter password
	public void enterpassword(String password) {
		log.info("Enter password in login page==>>" + password.length());
		this.password.clear();
		this.password.sendKeys(password);

	}

// click on login
	public void clickonlogin() {
		log.info("click on login button in login page....");
		login.click();

	}

// To verify the Home page after logged into Application.
	public void toverifyhomepage() {
		log.info("To verify  Home Page ==>>");
		String haeder = mainheader.getText();
		if (haeder.equals("Prime Last Mile")) {
			System.out.println("Home page Opened" + haeder);

		} else {
			log.info("Home page  Not Opened" + haeder);
			System.out.println("Home page has Not Opened" + haeder);
		}
	}

// click on master definition maker Menu
	public void clikonmasterdefinitionmakerMenu() {
		log.info("clik on master definition maker Menu==>" + masterdefinitionmaker.getText());
		masterdefinitionmaker.click();
	}

// click on Add SubPurpose Maker SubMenu
	public void clickonAddSubPurposeMakerSubMenu() {
		log.info("click on Add Sub Purpose Maker SubMenu===>" + AddSubPurposeMaker.getText());
		AddSubPurposeMaker.click();
	}

// to switch the Add Entity Type Maker page.
	public void toswitchFieldsareinmandatory() throws Exception {
		log.info(" to switch Fields are in mandatory Page where the All the Input fields are Availabe...");
		Thread.sleep(5000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
		log.info(" To switch the main Enter values " + Fieldsareinmandatory.getText());
	}

	static String splitvaluesOfCountryCode;
	static String splitvaluesOfPurposeCode;
	static String getsubpurposeCode;
	static String getsubpurposeDesc;
	static String getIsActiveSubPurpose;

	// select country Code On Add Sub Purpose page
	public void selectcountryCodeOnAddSubPurposepage() {
		String countryCodeOnString = "BD-Bangladesh";
		String[] splt = countryCodeOnString.split("-");
		splitvaluesOfCountryCode = splt[0].trim();
		System.out.println("split values of Country Code ==>" + splitvaluesOfCountryCode);

		Select selectcountry = new Select(selectcountryCode);
		List<WebElement> Allselectcountry = selectcountry.getOptions();
		int GetNoOfAllCountry = Allselectcountry.size();

		log.info("Get the Size of the All Country Code On Drop Down... " + GetNoOfAllCountry);

		for (int i = 1; i < Allselectcountry.size(); i++) {

			String GetTextOfCountryDropDown = Allselectcountry.get(i).getText();

			System.out.println("Get Text Of Country DropDown  form DropDown List...." + GetTextOfCountryDropDown);
			if (Allselectcountry.get(i).getText().equals(countryCodeOnString)) {
				log.info("Text has Matched With value==>" + countryCodeOnString);

				selectcountry.selectByVisibleText(countryCodeOnString);
				log.info("Country drop down Text has Selected with value==>" + countryCodeOnString);
				break;
			}

			else {
				System.out.println("Text has NOT Matched With value==>" + countryCodeOnString);
				log.info("Country drop down Text has NOT Selected with value==>" + countryCodeOnString);
			}
		}

	}

	// select purpose Code On Add SubPurpose page
	public void selectPurposeCodeOnAddSubPurposepage() {
		String purposeCodeOnString = "CDH-EFG";
		String[] splt = purposeCodeOnString.split("-");
		splitvaluesOfPurposeCode = splt[0].trim();
		System.out.println("split values of Purpose Code ==>" + splitvaluesOfPurposeCode);
		Select selectPurposeOnSubPurposwPage = new Select(selectPurposeCode);
		List<WebElement> AllselectPurposeCode = selectPurposeOnSubPurposwPage.getOptions();
		int GetNoOfAllPurposeCode = AllselectPurposeCode.size();

		log.info("Get the Size of the All Purpose Code On Drop Down... " + GetNoOfAllPurposeCode);

		for (int i = 1; i < AllselectPurposeCode.size(); i++) {

			String GetTextOfPurposeDropDown = AllselectPurposeCode.get(i).getText();

			System.out.println("Get Text Of Purpose CCode form DropDown List ==>" + GetTextOfPurposeDropDown);
			if (AllselectPurposeCode.get(i).getText().equals(purposeCodeOnString)) {
				log.info("Text has Matched with value==>" + purposeCodeOnString);

				selectPurposeOnSubPurposwPage.selectByVisibleText(purposeCodeOnString);
				log.info("Purpose code Text has Selected from drop down ==>" + purposeCodeOnString);
				break;
			}

			else {
				log.info("Text has NOT Matched with value==>" + purposeCodeOnString);
				log.info("Purpose code Text has NOT Selected from drop down ==>" + purposeCodeOnString);
			}
		}

	}

// enter purpose Code in ADD Sub PURPOSE MAKER  page
	public void enterSubpurposeCode(String subpurposeCode) {
		log.info("Enter Subpurpose Code ===>" + subpurposeCode);
		this.subpurposeCode.sendKeys(subpurposeCode);
		getsubpurposeCode = subpurposeCode.toString();
		System.out.println("get sub purpose Code value==>>>" + getsubpurposeCode);
	}

// enter purpose Desc in Add Sub purpose Maker page
	public void enterSubpurposeDesc(String subpurposeDesc) {
		log.info("enter Subpurpose Desc ...." + subpurposeDesc);
		this.subpurposeDesc.sendKeys(subpurposeDesc);
		getsubpurposeDesc = subpurposeDesc.toString();
		System.out.println("get subpurpose Desc value==>>>" + getsubpurposeDesc);
	}

// select  is Active Payment ? in Entity Maker page
	public void selectisActiveSubPurpose() {
		String s = "Yes";

		Select aa = new Select(isActiveSubPurpose);
		log.info("select is is Active Sub Purpose Maker ?==>" + s);
		aa.selectByVisibleText(s);
		String getisActive = s.toString();
		System.out.println("get Is Active Sub Purpose Maker ===>>" + getisActive);
		String[] spl = getisActive.split("es");
		System.out.println("Split Array Values of Yes ===>>" + spl);
		List<String> splitList1 = Arrays.asList(spl);
		getIsActiveSubPurpose = String.join("", splitList1);
		System.out.println("get Is Active Sub Purpose after Split (Yes) As Y=>>>" + getIsActiveSubPurpose);

	}

// click on  submit In add  Payment Type Maker page
	public void clickonsubmitInMakerpage() {
		log.info("click on submit In Maker page==>" + submitInMakerpage);
		submitInMakerpage.click();
	}

//  to verify the Successful Message to the Added the Payment Type  maker Successfully
	public void verifySuccesfullMessage() {

		String verifythemodify = SuccesfullMessage.getText();
		System.out.println("verify the Successful Message===>>>" + verifythemodify);
		log.info("verify the Successful Message===>>>" + verifythemodify);
		if (verifythemodify.equals("Record has been added successfully.")) {
			driver.switchTo().defaultContent();
			log.info("Record has been added successfully.");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("Record Already Exists")) {
			log.info("Record Already Exists");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("Record Already Exists")) {
			log.info("Record Already Exists");
			// driver.switchTo().defaultContent();
			// driver.findElement(By.xpath("//b[text()='Logout']")).click();

		}

		else {
			log.info(" ....Verify Message is not Matched....");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		}
	}

// click on Master Definition Checker
	public void clickonMasterDefinitionChecker() {
		log.info(" Get text Master Definition Checker" + MasterDefinitionChecker.getText());
		log.info("Clcik on MasterDefinitionChecker====");
		MasterDefinitionChecker.click();

	}

	// click Authorise Purpose checker SubMenu
	public void clickOnSubAuthoriserPurposeSubMenu() {
		log.info("click On Authoriser Sub Purpose Checker SubMenu..." + AuthoriserSubPurpose.getText());
		AuthoriserSubPurpose.click();
	}

	// verify Purpose Checker Page
	public void verifySubPurposeCheckerPages() throws Exception {
		log.info("verify PURPOSE CHECKER Page...");
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		log.info("verify Sub Purpose Checker Page." + verifySubPurposeCheckerPage.getText());
		String purposeCheckerPage = verifySubPurposeCheckerPage.getText();

		System.out.println("Get the Text of  Sub purpose Checker Page..." + purposeCheckerPage);
		Assert.assertEquals("SUB PURPOSE CHECKER", purposeCheckerPage);
		log.info(" Suceessfully verified the Sub Purpose Checker Page...");
	}

	// calling path variables and verifyAddcheckerList in Sub purpose Checker page.
	// verify Add Sub purpose maker at checker List In Sub Purpose Checker page()
	public void verifyAddcheckerListInCheckerpage() throws InterruptedException {
		String CountryCode = "//table[@id='list']//tbody/tr/td[4]";
		String PurposeCode = "//table[@id='list']//tbody/tr/td[5]";
		String SubpurposeCode = "//table[@id='list']//tbody/tr/td[6]";
		String SubPurposeDescription = "//table[@id='list']//tbody/tr/td[7]";
		String IsActive = "//table[@id='list']//tbody/tr/td[8]";

		toverifyCheckerlist(CountryCode, splitvaluesOfCountryCode);
		toverifyCheckerlist(PurposeCode, splitvaluesOfPurposeCode);
		toverifyCheckerlist(SubpurposeCode, getsubpurposeCode);
		toverifyCheckerlist(SubPurposeDescription, getsubpurposeDesc);
		toverifyCheckerlist(IsActive, getIsActiveSubPurpose);
	}

// Calling the Generic Method to verify the List in purpose Checker page.
	private void toverifyCheckerlist(String xpathvalue, String value) throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text of  Checker Page list==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Get Text of  Checker Page list Matched with value ==>" + value);
				// driver.findElement(By.xpath("//input[@id='selectAll']")).click();

				break;
			} else {

				System.out.println("Get Text List Not  matched with valuee==>" + value);
				// driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();

			}

		}

	}

	public void HandleTheDynamicVluesWithCheckbox() throws Exception {
		// verifying By purposeCode because the Country has multiple matched, So we have
		// have to
		// write purposeCode Column xpath.
		List<WebElement> web = driver.findElements(By.xpath("//table[@id='list']//tbody/tr/td[6]"));
		int sizeOfColumn = web.size();
		System.out.println("size Of Column===>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get Name===>>" + name);
			if (name.contains(getsubpurposeCode)) {
				System.out.println("Text has Mtched with value==>" + name);
				Thread.sleep(3000);
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				log.info("Click On Check Box with Matched Value===>" + getsubpurposeCode);

			} else {
				System.out.println("Text has  Not Mtched with value==>" + getsubpurposeCode);
			}
		}

	}


// click on submit button And verify Succesfull Message on Checker  Page.
	public void clickonsubmitbuttonOnCheckerPage() {

		// Click on Submit button Checker Page. To Select only one Checkbox
		log.info(" click on Submit button on Checker Page===>>" + SubmitbuttononChecker.getText());
		SubmitbuttononChecker.click();

	}

// to verify successful Message in Purpose CHECKER page
	public void toverifysuccessfulMessageinCheckerPage() {

		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();

		System.out.println("Get the Text of Succesfull Message After click on Submit button in Checker page..."
				+ successfulMessageinChecker);
		log.info("successful Message in Checker====" + verifysuccessfulMessageinChecker.getText());
		// Assert.assertEquals(successfulMessageinChecker, "Record updated
		// successfully.");
		if (verifysuccessfulMessageinChecker.getText().equals("Record updated successfully.")) {

			log.info(" Successfully  verified the Message in Checker page....");
		} else {

			log.info(" Not Successfully  verified the Message in Checker page....");
		}

	}

//  to go to Maker page when Checker Approved Payment so click on Log out Button.
// calling p=7
	public void gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker() throws InterruptedException {
		driver.switchTo().defaultContent();
		log.info("Click on Logout in checker Page" + Logoutinchecker.getText());
		Logoutinchecker.click();

	}

	// View page in Maker , After Approved by the Checker data
	public void clickOnviewButtoninMakerPage() {
		log.info("click on view in Maker page===" + viewinMaker.getText());
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
// 1. when the Verify the Maker View page when Currency has Approved by the Currency Checker
	public void verifyViewpageBySearchField() throws InterruptedException {
		this.searchfield.clear();
		log.info("Searh By Country Drop Down ==>" + splitvaluesOfCountryCode);
		this.searchfield.sendKeys(splitvaluesOfCountryCode);
		this.searchfield.clear();
		log.info("Search By purpose Code ==>" + splitvaluesOfPurposeCode);
		this.searchfield.sendKeys(splitvaluesOfPurposeCode);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("Search By Sub purpose Desc==>" + getsubpurposeCode);
		this.searchfield.sendKeys(getsubpurposeCode);
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
	public void multippleSelectVerifyTextInViewPage() {

		String CountryCode = "//tbody[@role='alert']//tr//td[2]";
		String purposeCode = "//tbody[@role='alert']//tr//td[3]";
		String subPurposecode = "//tbody[@role='alert']//tr//td[4]";
		String subPurposeDescription = "//tbody[@role='alert']//tr//td[5]";
		String ISActive = "//tbody[@role='alert']//tr//td[6]";

		verifytheViewpageWithText(CountryCode, splitvaluesOfCountryCode);
		verifytheViewpageWithText(purposeCode, splitvaluesOfPurposeCode);
		verifytheViewpageWithText(subPurposecode, getsubpurposeCode);
		verifytheViewpageWithText(subPurposeDescription, getsubpurposeDesc);
		verifytheViewpageWithText(ISActive, getIsActiveSubPurpose);

	}

// verify the View Maker Page with Text with thier respective Column
	public static void verifytheViewpageWithText(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" Get No of list On Checker Page==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text On Checker Page==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Get Text List Matched with value ==>" + value);
				break;
			} else {

				System.out.println("Get Text List Not  Matched with value ==>" + value);
			}
		}

	}

// Select  All Drop down values in Maker view page when the Added Currency has Approved By Checker 
	public void selectAllvaluesOneByOne() {
		// WebElement
		WebElement selectCountryCode = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectpurposeCode = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectSubPurposeCode = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectSubPurposeDescription = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement selectISActive = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));

		verifyBytheDropDownlistOneByOne(selectCountryCode, splitvaluesOfCountryCode);
		verifyBytheDropDownlistOneByOne(selectpurposeCode, splitvaluesOfPurposeCode);
		verifyBytheDropDownlistOneByOne(selectSubPurposeCode, getsubpurposeCode);
		verifyBytheDropDownlistOneByOne(selectSubPurposeDescription, getsubpurposeDesc);
		verifyBytheDropDownlistOneByOne(selectISActive, getsubpurposeDesc);

	}

//
// select one by one of Select in View page of Maker
	public static void verifyBytheDropDownlistOneByOne(WebElement aa, String value) {

		Select sel = new Select(aa);
		List<WebElement> N = sel.getOptions();
		int Nooflist = N.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < N.size(); i++) {
			String listText = N.get(i).getText();
			System.out.println(" Get Text of Checker Page ==>" + listText);
			if (N.get(i).getText().equals(value)) {
				System.out.println("Get Text has Selected with value ==>" + value);
				sel.selectByVisibleText(value);
				break;
			} else {

				System.out.println("Get Text has Not Selected with value ==>" + value);

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

//switch view page to Maker page and click on Modify button.
//verify Modify Entity Type Maker Page
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

		log.info(" Get the Text of Modify Sub Purpose Maker Ppage===>>" + verifyModifySubPurposeMakerPage.getText());
		log.info(" verify the Modify  Suub Purpose Maker Ppage...");
		Assert.assertEquals(verifyModifySubPurposeMakerPage.getText(), "MODIFY SUB PURPOSE MAKER");
		log.info(" Successfully verified the Modify Sub Purpose  Maker Ppage...");

	}

	// select Purpose Code In Modify Sub purpose Maker Page
	public void selectSubPurposeCodeInModifyPurposeMakerPage() {
		driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
		// Select SubPurpose Code Drop Down
		Select selectPurposeCode = new Select(selectSubpurposeCodeInModifyPage);
		List<WebElement> AllPurposeCode = selectPurposeCode.getOptions();
		int noofPurposeCodedOnDropDown = AllPurposeCode.size();
		System.out.println("Get the No of Sub Purpose code On DropDown==>>" + noofPurposeCodedOnDropDown);

		for (int i = 0; i < AllPurposeCode.size(); i++) {
			String GetTextOfAllDropDownValues = AllPurposeCode.get(i).getText();
			System.out.println("Get Text Of All DropDown Values==>" + GetTextOfAllDropDownValues);

			if (AllPurposeCode.get(i).getText().equals("BD-CDEF-EFGH")) {
				log.info(" ====Matched the Given Data=====");

				selectPurposeCode.selectByVisibleText("BD-CDEF-EFGH");
				System.out.println(
						" ==== Sub Purpose Code Matched the From Subp purpose Code Drop Down In MODIFY Sub Purpose MAKER page=====>>");
				break;
			} else {

				System.out.println(
						" ==== Sub Purpose Code not  Matched the From Sub Purpose Code Drop Down In MODIFY Sub Purpose MAKER page=====>>");
			}
		}
	}

//select SubPurpose Code In Modify page
	public void selectSubPurposeCodeInModifyMakerPageByUsingSplitAsPerAddingValue() {

		driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());

		String selectSubPurposeCode = "//select[@name='purposeCode']//option";

		selectDropDownInModifyMakerPageByUsingIndex(selectSubPurposeCode, getsubpurposeCode);

	}

	public static void selectDropDownInModifyMakerPageByUsingIndex(String xpathvalue, String value) {
		List<WebElement> paymentList = driver.findElements(By.xpath(xpathvalue));
		int mandateSize = paymentList.size();
		System.out.println("Get no of Payment Code Size===>>" + mandateSize);
		for (int i = 0; i < paymentList.size(); i++) {
			String getTextOfmandateCodeDropDown = paymentList.get(i).getText();
			String[] splt = getTextOfmandateCodeDropDown.split("-");
			String splivalues = splt[1].trim();
			System.out.println("split values==" + splivalues);

			System.out.println("get Text Of Payment code Drop Down===>>" + getTextOfmandateCodeDropDown);
			if (splivalues.equals(value)) {
				System.out.println("Text has Matched===>>");
				paymentList.get(i).click();
				System.out.println("Text has Selected with value===>>" + splivalues);
				break;

			} else {
				System.out.println("Text has NOT  Matched with value===>>" + splivalues);
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

	// verification Message In Modify Payment Type Page
	public void verificationMessageInModifyPaymentTypePage() throws Exception {
		log.info("Get the Text Of Verification Message In Modify Payment Type Page==>>"
				+ verificationMessageInModifyPaymentType.getText());
		// Assert.assertEquals(verificationMessageInModifyEntityType.getText(), "Record
		// has been modified successfully.");

		// verification Message In Modify Payment Type Page
		String verifythemodify = verificationMessageInModifyPaymentType.getText();
		System.out.println("Get the Text Of Verification Message In Modify Payment Type Page==>>" + verifythemodify);
		if (verifythemodify.equals("Record has been modified successfully.")) {
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			log.info("==Successfull Message has Matched with  Text==");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("This Mandate Type name has already used.")) {
			log.info("This Country Code has already used");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("===Not==")) {
			log.info("This is Not Matched");

		} else {
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			log.info("==Successfull Message has Matched with  Text==");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		}

	}

	// verify the Sub Purpose checker List IF Modification has Done By Maker with
	// Existing Entity.
	public void verifyListonCheckerpageWhenModificationhasDoneByMaker() throws InterruptedException {
		String CountryCode = "//table[@id='list']//tbody/tr/td[4]";
		String PurposeCode = "//table[@id='list']//tbody/tr/td[5]";
		String SubpurposeCode = "//table[@id='list']//tbody/tr/td[6]";
		String SubPurposeDescription = "//table[@id='list']//tbody/tr/td[7]";
		String IsActive = "//table[@id='list']//tbody/tr/td[8]";

		toverifyCheckerlistWhenModifiedMaker(CountryCode, splitvaluesOfCountryCode);
		toverifyCheckerlistWhenModifiedMaker(PurposeCode, splitvaluesOfPurposeCode);
		toverifyCheckerlistWhenModifiedMaker(SubpurposeCode, getsubpurposeCode);
		toverifyCheckerlistWhenModifiedMaker(SubPurposeDescription, getsubpurposeDesc);
		toverifyCheckerlistWhenModifiedMaker(IsActive, getIsActiveSubPurpose);
	}

	// Calling the Generic Method to verify the List in Entity Type Checker page.
	private void toverifyCheckerlistWhenModifiedMaker(String xpathvalue, String value) throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text of  Checker list==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Get Text of  Checker list Has Matched with value==>" + value);
				// driver.findElement(By.xpath("//input[@id='selectAll']")).click();

				break;
			} else {

				System.out.println("Get Text of  Checker list NOT Matched with value==>" + value);
				// driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();

			}

		}

	}

	public void selectThecheckboxOnCheckerPageWhenModifyMakerDaata() {
		// After Modification Column Value has changed. This is Bug on it.
		String purposeCode = "//table[@id='list']//tbody/tr/td[6]";
		selectThecheckboxOnCheckerPageWhenModify(purposeCode, getsubpurposeCode);
	}

	public void selectThecheckboxOnCheckerPageWhenModify(String xpathvalue, String value) {

		List<WebElement> web = driver.findElements(By.xpath(xpathvalue));
		int sizeOfColumn = web.size();
		System.out.println("size Of list===>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get the Text on checker Page==>>" + name);
			if (name.contains(value)) {
				System.out.println("Get Text has Mtched with value==>" + name);
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				log.info("Click on checkbox with Matched Value==>" + value);

				break;
			} else {
				System.out.println("Get Text has  Not Mtched with values==>" + value);
			}
		}

	}

	
//in view Page , search by different values passing into search box,
//refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
	// 2. when the Modified the Currency then "View" page Maker
	public void verifyViewpagesBySearchFieldWhenModifyTAndApprovedDoneByChecker() throws InterruptedException {
		this.searchfield.clear();
		log.info("Searh By Country Drop Down ==>" + splitvaluesOfCountryCode);
		this.searchfield.sendKeys(splitvaluesOfCountryCode);
		this.searchfield.clear();
		log.info("Search By purpose Code ==>" + splitvaluesOfPurposeCode);
		this.searchfield.sendKeys(splitvaluesOfPurposeCode);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("Search By Sub purpose Desc==>" + getsubpurposeCode);
		this.searchfield.sendKeys(getsubpurposeCode);
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
	public void toVerifyByTextInViewMakerPagewhenModified() {

		String CountryCode = "//tbody[@role='alert']//tr//td[2]";
		String purposeCode = "//tbody[@role='alert']//tr//td[3]";
		String subPurposecode = "//tbody[@role='alert']//tr//td[4]";
		String subPurposeDescription = "//tbody[@role='alert']//tr//td[5]";
		String ISActive = "//tbody[@role='alert']//tr//td[6]";

		verifyTheMakerViewPageWhenModified(CountryCode, splitvaluesOfCountryCode);
		verifyTheMakerViewPageWhenModified(purposeCode, splitvaluesOfPurposeCode);
		verifyTheMakerViewPageWhenModified(subPurposecode, getsubpurposeCode);
		verifyTheMakerViewPageWhenModified(subPurposeDescription, getsubpurposeDesc);
		verifyTheMakerViewPageWhenModified(ISActive, getIsActiveSubPurpose);
	}

// 
// verify the View Maker Page with Text with thier respective Column
	public static void verifyTheMakerViewPageWhenModified(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text of View Page ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Text List On View Page Matched With Value==>" + value);
				break;
			} else {

				System.out.println("Text List On View Page NOT Matched With Value==>" + value);
			}
		}

	}

// To verify  By  All Select Filter Or To Verify the Modify Data in Maker View Page By Using Drop Down
// select All values One By One
//  5 drop down are available on the 
	public void toVerifytheModifyDataInMakerViewPagByUsingDropDown() {
		// WebElement
		WebElement selectCountryCode = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectpurposeCode = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectSubPurposeCode = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectSubPurposeDescription = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement selectISActive = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));

		verifySelectDropDonInViewMakerPageWhenModified(selectCountryCode, splitvaluesOfCountryCode);
		verifySelectDropDonInViewMakerPageWhenModified(selectpurposeCode, splitvaluesOfPurposeCode);
		verifySelectDropDonInViewMakerPageWhenModified(selectSubPurposeCode, getsubpurposeCode);
		verifySelectDropDonInViewMakerPageWhenModified(selectSubPurposeDescription, getsubpurposeDesc);
		verifySelectDropDonInViewMakerPageWhenModified(selectISActive, getIsActiveSubPurpose);
	}

// select one by one of Select in View page of Maker
// 4 drop down using one by one select the values from drop down
	public static void verifySelectDropDonInViewMakerPageWhenModified(WebElement aa, String value) {

		Select sel = new Select(aa);
		List<WebElement> N = sel.getOptions();
		int Nooflist = N.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < N.size(); i++) {
			String listText = N.get(i).getText();
			System.out.println(" Get Text of Select Drop Down values====" + listText);
			if (N.get(i).getText().equals(value)) {
				System.out.println(" Text List matched on Select drop down ==>" + value);
				sel.selectByVisibleText(value);
				System.out.println("Get Text on Drop Down List Matched with value ==>" + value);

				break;
			} else {

				System.out.println("Get Text on Drop Down List Not matched with value ==>" + value);

			}
		}

	}

// This is not Useful because the 
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

		log.info(" Get the Text of Modify Entity Type Maker Ppage===>>" + verifyModifySubPurposeMakerPage.getText());
		log.info(" verify the Modify  Entity Type Maker Ppage...");
		Assert.assertEquals(verifyModifySubPurposeMakerPage.getText(), "MODIFY PAYMENT TYPE MAKER");
		log.info(" Successfully verified the Modify  Entity Type Maker Ppage...");
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


		String Header = driver.findElement(By.xpath("//td[contains(text(),' Purpose Checker')]")).getText();

		System.out.println(Header);
		Assert.assertEquals("SUB PURPOSE CHECKER", Header);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().defaultContent();
		

		driver.findElement(By.xpath("//b[text()='Logout']")).click();

	}
}
