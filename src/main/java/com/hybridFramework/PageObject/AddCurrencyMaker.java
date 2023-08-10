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
public class AddCurrencyMaker {
	static WebDriver driver;

	private final Logger log = LoggerHelper.getLogger(AddCurrencyMaker.class);
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
	@FindBy(xpath = "//*[text()='Add Currency Maker']")
	WebElement AddCurrencyMaker;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;
	@FindBy(xpath = "//input[@id='currencyCode']")
	WebElement countryCode;

	@FindBy(xpath = "//input[@id='bdCurrencyCode']")
	WebElement bdCurrencyCode;
	@FindBy(xpath = "//input[@id='currency']")
	WebElement currency;
	@FindBy(xpath = "//select[@id='isActive']")
	WebElement isActiveCurrency;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
// Statrted  Checker X-path

	@FindBy(xpath = "//*[text()='Master Definition Checker']")
	WebElement MasterDefinitionChecker;
	@FindBy(xpath = "//*[text()='Add Currency Checker']")
	WebElement AddCurrencyChecker;
	@FindBy(xpath = "//td[text()=' Currency Checker']")
	WebElement verifyCurrencyCheckerPage;
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

	@FindBy(xpath = "//*[text()='Modify Currency Maker']")
	WebElement verifyModifyCurrencyMakerPage;

	@FindBy(xpath = "//select[@name='currencyCode']")
	WebElement selectcurrencyCodeInModifyPage;
	@FindBy(name = "Submit")
	WebElement submitbuttonModifyMaker;
	// form[@name='modifyCountry']//table//tr[15]//td//input[@name='Submit']

	@FindBy(xpath = "//form[@name='modifyCountry']//table//tr[14]//td")
	WebElement modifysubmitbutton;
	@FindBy(xpath = "//td[@class='note']")
	WebElement verificationMessageInModifyCountry;

	@FindBy(xpath = "//b[text()='Logout']")
	WebElement logoutMaker;

	// View Page in Checker
	//
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewInChecker;

	public AddCurrencyMaker(WebDriver driver) {
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

//
	public void clikonmasterdefinitionmakerMenu() {
		log.info("clik on master definition maker Menu==>" + masterdefinitionmaker.getText());
		masterdefinitionmaker.click();
	}

//
	public void clickonAddCurrencyMakerSubMenu() {
		log.info("click on add Currency maker SubMenu===>" + AddCurrencyMaker.getText());
		AddCurrencyMaker.click();
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

	static String getCountryCode;
	static String getBangladeshBankCurrencyCode;
	static String getcurrency;
	static String getIsActiveCurrency;

// enter country Code in Add Currency Maker page
	public void entercountryCode(String countryCode) {
		log.info("Enter country Code==>" + countryCode);
		this.countryCode.sendKeys(countryCode);
		getCountryCode = countryCode.toString();
		System.out.println("get get Country Code value==>>>" + getCountryCode);

	}

// enter bdCurrencyCode in Add Currency Maker page
	public void enterbdCurrencyCode(String bdCurrencyCode) {
		log.info("enter iso CountryCode==>" + bdCurrencyCode);
		this.bdCurrencyCode.sendKeys(bdCurrencyCode);
		getBangladeshBankCurrencyCode = bdCurrencyCode.toString();
		System.out.println("get Bangladesh Bank Currency Code==>>" + getBangladeshBankCurrencyCode);
	}

// enter currency in Currency Maker page
	public void entercurrency(String currency) {
		log.info(" enter currency in Currency Maker page==>" + currency.length());
		int a = currency.length();
		System.out.println(a);
		this.currency.sendKeys(currency);
		getcurrency = currency.toString();
		System.out.println("get currency==>>" + getcurrency);

	}

// select  is Active Currency? in Add Currency Maker page
	public void selectisActiveCurrency() {
		String s = "Yes";
		log.info("select is Active Currency  ?==" + isActiveCurrency);
		Select aa = new Select(isActiveCurrency);
		aa.selectByVisibleText(s);
		String getisActive = s.toString();
		System.out.println("get Is Active Currency ===>>" + getisActive);
		String[] spl = getisActive.split("es");
		System.out.println("Split Array Values of Yes ===>>" + spl);
		List<String> splitList1 = Arrays.asList(spl);
		getIsActiveCurrency = String.join("", splitList1);
		System.out.println("get Is Active Currency after Split (es) As Yes=>>>" + getIsActiveCurrency);
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

	// click On Add Currency Checker SubMenu
	public void clickOnAddCurrencyCheckerSubMenu() {
		log.info("click On Add Currency Checker SubMenu==>" + AddCurrencyChecker.getText());
		AddCurrencyChecker.click();
	}

	// verify Currency Checker Page
	public void verifyCurrencyCheckerPagePages() throws Exception {
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		log.info("verify Currency Checker Page==>" + verifyCurrencyCheckerPage.getText());
		String CurrencyCheckerPage = verifyCurrencyCheckerPage.getText();

		System.out.println("Currency Checker Page is ==>"+CurrencyCheckerPage);
		Assert.assertEquals("CURRENCY CHECKER", CurrencyCheckerPage);
		log.info("Successfully verified the Currency Checker Page...");
	}

	// calling path variables and verifyAddcheckerList in Currency Checker page.
	//
	public void verifyAddcheckerListInCurrencyCheckerpage()throws InterruptedException {
		String CurrencyCode = "//table[@id='list']//tbody/tr/td[4]";
		String BangladeshBankCurrencyCode = "//table[@id='list']//tbody/tr/td[5]";
		String Currency = "//table[@id='list']//tbody/tr/td[6]";
		String IsActive = "//table[@id='list']//tbody/tr/td[7]";
//getCountryCode ,getBangladeshBankCurrencyCode
		StoverifyCheckerlist(CurrencyCode, getcurrency);
		StoverifyCheckerlist(BangladeshBankCurrencyCode, getCountryCode);
		StoverifyCheckerlist(Currency, getBangladeshBankCurrencyCode);
		StoverifyCheckerlist(IsActive, getIsActiveCurrency);

	}

// Calling the Generic Method to verify the List in Currency Checker page.
	private void StoverifyCheckerlist(String xpathvalue, String value) throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text of  Checker list====" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("======Get Text of  Checker list= ======");
				// driver.findElement(By.xpath("//input[@id='selectAll']")).click();

				break;
			} else {

				System.out.println("==== List Not  matched ===");
				// driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();

			}}
}
	public void HandleTheDynamicVluesWithCheckbox()throws Exception {
		List<WebElement> web = driver.findElements(By.xpath("//table[@id='list']//tbody/tr/td[4]"));
		int sizeOfColumn = web.size();
		System.out.println("size Of Column===>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get Name===>>" + name);
			if (name.contains(getCountryCode)) {
				System.out.println("Text has Mtched");
				Thread.sleep(3000);
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				log.info("Click On Check Box With Unique Values Matched ==>"+getCountryCode);
			

			} else {
				System.out.println("Text has  Not Mtched With Unique values =="+getCountryCode);
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

//  to gotoMakerCheckerApprovedCountry
// calling p=7
	public void gotoMakerCheckerApprovedCountry() throws InterruptedException {
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
// 1. when the Verify the Maker View page when Currency has Approved by the Currency Checker
	public void verifyViewpagesBySrachField()throws InterruptedException {
		this.searchfield.clear();
		log.info("Searh By Country Code==>"+getCountryCode);
		this.searchfield.sendKeys(getCountryCode);
		this.searchfield.clear();
		log.info("Search By Bangladesh Bank Currency Code==>"+getBangladeshBankCurrencyCode);
		this.searchfield.sendKeys(getBangladeshBankCurrencyCode);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("Search By currency==>"+getcurrency);
		this.searchfield.sendKeys(getcurrency);
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

		String CurrencyCode = "//tbody[@role='alert']//tr//td[2]";
		String BDCurrencyCode = "//tbody[@role='alert']//tr//td[3]";
		String Currency = "//tbody[@role='alert']//tr//td[4]";
		String ISActive = "//tbody[@role='alert']//tr//td[5]";

		verifyTheViewPageWithGetText(CurrencyCode, getCountryCode.toUpperCase());
		verifyTheViewPageWithGetText(BDCurrencyCode, getBangladeshBankCurrencyCode.toUpperCase());
		verifyTheViewPageWithGetText(Currency, getcurrency.toUpperCase());
		verifyTheViewPageWithGetText(ISActive, getIsActiveCurrency.toUpperCase());

	}

// 
// verify the View Maker Page with Text with thier respective Column
	public static void verifyTheViewPageWithGetText(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text of ====" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("======List matched ======");
				break;
			} else {

				System.out.println("==== List Not  matched ===");
			}
		}

	}

// Select  All Drop down values in Maker view page when the Added Currency has Approved By Checker 
	public void verifyTheViewPageWithSelectGivenValueOnDropDown() {
		WebElement selectCurrencyCode = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectBDCurrencyCode = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectCurrency = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectISActive = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));

		verifyTheViewPageWithSelectDropDown(selectCurrencyCode, getCountryCode.toUpperCase());
		verifyTheViewPageWithSelectDropDown(selectBDCurrencyCode, getBangladeshBankCurrencyCode.toUpperCase());
		verifyTheViewPageWithSelectDropDown(selectCurrency, getcurrency.toUpperCase());
		verifyTheViewPageWithSelectDropDown(selectISActive, getIsActiveCurrency.toUpperCase());

	}

// selectAllvaluesOneByOne
// select one by one of Select in View page of Maker
	public static void verifyTheViewPageWithSelectDropDown(WebElement xpathvalue, String value) {

		Select sel = new Select(xpathvalue);
		List<WebElement> N = sel.getOptions();
		int Nooflist = N.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < N.size(); i++) {
			String listText = N.get(i).getText();
			System.out.println(" Get Text of ====" + listText);
			if (N.get(i).getText().equals(value)) {
				System.out.println("======List matched ======");
				sel.selectByVisibleText(value);
				break;
			} else {

				System.out.println("==== List Not  matched ===");

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

		log.info(" Get the Text of Currency Modify Ppage===>>" + verifyModifyCurrencyMakerPage.getText());
		log.info(" verify the Currency Modify  Maker Ppage");
		Assert.assertEquals(verifyModifyCurrencyMakerPage.getText(), "MODIFY CURRENCY MAKER");

	}

	// select country Code In Modify Maker Page
	//
	public void selectcCurrencyCodeInModifyMakerPage() {
		driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
		Select selectcurrencyCode = new Select(selectcurrencyCodeInModifyPage);
		List<WebElement> AllCurrencyCode = selectcurrencyCode.getOptions();
		int noofCurrencyOnDropDown = AllCurrencyCode.size();
		System.out.println("Get the No of Currency DropDown==>>" + noofCurrencyOnDropDown);

		for (int i = 0; i < AllCurrencyCode.size(); i++) {
			String GetTextOfAllDropDownValues = AllCurrencyCode.get(i).getText();
			System.out.println("Get Text Of All DropDown Values==>" + GetTextOfAllDropDownValues);

			if (AllCurrencyCode.get(i).getText().equals("aa-aa")) {
				log.info(" ====Matched the Given Data=====");

				selectcurrencyCode.selectByVisibleText("aa-aa");
				System.out.println(
						" ==== Currency Matched the From Currency Drop Down In MODIFY CURRENCY MAKER page=====>>");
				break;
			} else {
				System.out.println(
						"==== Currency Not Matched the From Currency Drop Down MODIFY CURRENCY MAKER page=====>>");
			}
		}
	}
	public void selectcountryCodeInModifyMakerPageByUsingSplitAsPerAddingValue() {

		driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());

		String selectcurrency = "//select[@name='currencyCode']//option";

		selectCurrencyDropDownInModifyMakerPageByUsingIndex(selectcurrency, getCountryCode.toUpperCase());

	}

	public static void selectCurrencyDropDownInModifyMakerPageByUsingIndex(String xpathvalue, String value) {
		List<WebElement> currencyList = driver.findElements(By.xpath(xpathvalue));
		int currencySize = currencyList.size();
		System.out.println("Get Currency Size===>>" + currencySize);
		for (int i = 0; i < currencyList.size(); i++) {
			String getTextOfCurrencyDropDown = currencyList.get(i).getText();
			String[] splt = getTextOfCurrencyDropDown.split("-");
			String splivalues = splt[1].trim();
			System.out.println("split values==" + splivalues);

			System.out.println("get Text Of Currency DropDown===>>" + getTextOfCurrencyDropDown);
			if (splivalues.equals(value)) {
				System.out.println("Text has Matched===>>");
				currencyList.get(i).click();
				System.out.println("Text has Selected===>>");
				break;

			} else {
				System.out.println("Text has NOT  Matched===>>");
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
		//Assert.assertEquals(verificationMessageInModifyCountry.getText(), "This Currency name has already used.");

		// verification Message In Modify Country
		String verifythemodify = verificationMessageInModifyCountry.getText();
		System.out.println("Get the verify the Modify Successful Message===>>>" + verifythemodify);
		log.info("Get the verify the Modify Successful Message===>>>" + verifythemodify);
		if (verifythemodify.equals("This Currency name has already used.")) {
			//Thread.sleep(4000);
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

	// verify the Country checker List IF Modification has Done By Maker with
	// Existing Entity
	public void verifyCurrencycheckerListModificationhasDoneByMaker() throws InterruptedException {
		String CurrencyCode = "//table[@id='list']//tbody/tr/td[4]";
		String BangladeshBankCurrencyCode = "//table[@id='list']//tbody/tr/td[5]";
		String Currency = "//table[@id='list']//tbody/tr/td[6]";
		String IsActive = "//table[@id='list']//tbody/tr/td[7]";
// Header Value on Currency has not Mention proper.
		toverifyCheckerPageListValueWithText(CurrencyCode, getcurrency);
		toverifyCheckerPageListValueWithText(BangladeshBankCurrencyCode, getCountryCode);
		toverifyCheckerPageListValueWithText(Currency, getBangladeshBankCurrencyCode);
		toverifyCheckerPageListValueWithText(IsActive, getIsActiveCurrency);


	}

	// Calling the Generic Method to verify the List in Currency Checker page.
	private void toverifyCheckerPageListValueWithText(String xpathvalue, String value) throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text of  Checker list====" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("======Get Text of  Checker list= ======");
				// driver.findElement(By.xpath("//input[@id='selectAll']")).click();

				break;
			} else {

				System.out.println("==== List Not  matched ===");
				// driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();

			}

		}

	}
	public void selectThecheckboxOnCheckerPageWhenModifyMakerDaata() {
		  String CountryCode="//table[@id='list']//tbody/tr/td[4]";
		  selectThecheckboxOnCheckerPageWhenModify(CountryCode,getcurrency.toUpperCase());
	}
	
	public void selectThecheckboxOnCheckerPageWhenModify(String xpathvalue,String value) {

		List<WebElement> web = driver.findElements(By.xpath(xpathvalue));
		int sizeOfColumn = web.size();
		System.out.println("size Of Column===>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get Name===>>" + name);
			if (name.contains(value)) {
				System.out.println("Text has Mtched");
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				
				break;
			} else {
				System.out.println("Text has  Not Mtched");
			}
		}

	}

	
	
	// click on submit button And verify Succesfull Message If Modifythe Country
	public void clickonsubmitbuttonAndverifySuccesfullMessageIfModifytheCountry() {

		// Click on Submit button Checker Page. To Select only one Checkbox
		log.info(" click on Submit button on Checker===>>" + SubmitbuttononChecker.getText());
		SubmitbuttononChecker.click();
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		log.info("successful Message in Checker====" + verifysuccessfulMessageinChecker.getText());
		//Assert.assertEquals(successfulMessageinChecker, "Record updated successfully."," Successful Message has Not Matched");

		if (verifysuccessfulMessageinChecker.getText().equals("Record updated successfully.")) {

		} else if (verifysuccessfulMessageinChecker.getText().equals("")) {

		}

	}

//in view Page , search by different values passing into search box,
//refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
	// 2. when the Modified the Currency then "View" page Maker
	public void verifyViewpagesWhenModifyTheCurrencyAndApprovedDoneByChecker() throws InterruptedException {
		this.searchfield.clear();
		log.info("Searh By Country Code==>"+getCountryCode);
		this.searchfield.sendKeys(getCountryCode);
		this.searchfield.clear();
		log.info("Search By Bangladesh Bank Currency Code==>"+getBangladeshBankCurrencyCode);
		this.searchfield.sendKeys(getBangladeshBankCurrencyCode);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("Search By currency==>"+getcurrency);
		this.searchfield.sendKeys(getcurrency);
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
	public void toVerifyTextInViewPageWithHeaderColumn(){

		String CurrencyCode = "//tbody[@role='alert']//tr//td[2]";
		String BDCurrencyCode = "//tbody[@role='alert']//tr//td[3]";
		String Currency = "//tbody[@role='alert']//tr//td[4]";
		String ISActive = "//tbody[@role='alert']//tr//td[5]";

		verifyTheMakerViewPageWhenModified(CurrencyCode, getCountryCode.toUpperCase());
		verifyTheMakerViewPageWhenModified(BDCurrencyCode, getBangladeshBankCurrencyCode.toUpperCase());
		verifyTheMakerViewPageWhenModified(Currency, getcurrency.toUpperCase());
		verifyTheMakerViewPageWhenModified(ISActive, getIsActiveCurrency.toUpperCase());

	}

// 
// verify the View Maker Page with Text with thier respective Column
	public static void verifyTheMakerViewPageWhenModified(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text of ====" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("======List matched ======");
				break;
			} else {

				System.out.println("==== List Not  matched ===");
			}
		}

	}

// To verify  By  All Select Filter Or To Verify the Modify Data in Maker View Page By Using Drop Down
// select All values One By One
//  5 drop down are available on the 
	public void toVerifytheModifyDataInMakerViewPagByUsingDropDown() {
		WebElement selectCurrencyCode = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectBDCurrencyCode = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectCurrency = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectISActive = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));

		verifySelectDropDonInViewPage(selectCurrencyCode, getCountryCode.toUpperCase());
		verifySelectDropDonInViewPage(selectBDCurrencyCode, getBangladeshBankCurrencyCode.toUpperCase());
		verifySelectDropDonInViewPage(selectCurrency, getcurrency.toUpperCase());
		verifySelectDropDonInViewPage(selectISActive, getIsActiveCurrency.toUpperCase());

	}

//
// select one by one of Select in View page of Maker
// 4 drop down using one by one select the values from drop down
	public static void verifySelectDropDonInViewPage(WebElement xpathvalue, String value) {

		Select sel = new Select(xpathvalue);
		List<WebElement> N = sel.getOptions();
		int Nooflist = N.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < N.size(); i++) {
			String listText = N.get(i).getText();
			System.out.println(" Get Text of ====" + listText);
			if (N.get(i).getText().equals(value)) {
				System.out.println("======List matched ======");
				sel.selectByVisibleText(value);
				break;
			} else {

				System.out.println("==== List Not  matched ===");

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

		log.info(" Get the Text of Currency Modify Ppage===>>" + verifyModifyCurrencyMakerPage.getText());
		log.info(" verify the Currency Modify  Maker Ppage");
		Assert.assertEquals(verifyModifyCurrencyMakerPage.getText(), "MODIFY COUNTRY MAKER");

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

		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);",
		// driver.findElement(By.xpath("//td[text()=' Country Checker']")));

		String Header = driver.findElement(By.xpath("//td[text()=' Currency Checker']")).getText();

		System.out.println(Header);
		Assert.assertEquals("CURRENCY CHECKER", Header);

//	String bb = driver.findElement(By.className("mainmenu")).getText();
//	System.out.println(bb);
		// Scroll UP Method Which is used to Up
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().defaultContent();
//		WebDriverWait wait = new WebDriverWait(driver, 100);
//		WebElement Category_Body = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//td[@class='mainmenu']//following-sibling::b[text()='Logout']")));
//		System.out.println(Category_Body);

		driver.findElement(By.xpath("//b[text()='Logout']")).click();

	}
}
