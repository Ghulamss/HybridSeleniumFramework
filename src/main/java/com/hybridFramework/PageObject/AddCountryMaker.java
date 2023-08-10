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
public class AddCountryMaker {
	static WebDriver driver;

	private final Logger log = LoggerHelper.getLogger(AddCountryMaker.class);
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
	@FindBy(xpath = "//*[text()='Add Country Maker']")
	WebElement addcountrymaker;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;
	@FindBy(xpath = "//input[@id='country']")
	WebElement country;

	@FindBy(xpath = "//input[@id='isoCountryCode']")
	WebElement isoCountryCode;
	@FindBy(xpath = "//select[@id='isNegativeCountry']")
	WebElement countryflag;
	@FindBy(xpath = "//select[@id='isActive']")
	WebElement isActiveCountry;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
// Statrted  Checker X-path

	@FindBy(xpath = "//*[text()='Master Definition Checker']")
	WebElement MasterDefinitionChecker;
	@FindBy(xpath = "//*[text()='Add Country Checker']")
	WebElement AddCountryChecker;
	@FindBy(xpath = "//td[text()=' Country Checker']")
	WebElement verifyCountryChecker;
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

	@FindBy(xpath = "//*[text()='Modify Country Maker']")
	WebElement verifyModifyCountryMakerPage;

	@FindBy(xpath = "//select[@name='countryCode']")
	WebElement selectcountryCodeInModifyPage;
	@FindBy(name = "Submit")
	WebElement submitbuttonModifyMaker;
	// form[@name='modifyCountry']//table//tr[15]//td//input[@name='Submit']

	@FindBy(xpath = "//form[@name='modifyCountry']//table//tr[15]//td")
	WebElement modifysubmitbutton;
	@FindBy(xpath = "//td[@class='note']")
	WebElement verificationMessageInModifyCountry;

	@FindBy(xpath = "//b[text()='Logout']")
	WebElement logoutMaker;

	// View Page in Checker
	//  Adding Country Maker on ------------------------------------------------------------------------------
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewInChecker;

	public AddCountryMaker(WebDriver driver) {
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
	public void clickonaddcountrymakerSubMenu() {
		log.info("click on add country maker SubMenu===>" + addcountrymaker.getText());
		addcountrymaker.click();
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

	static String getCountry;
	static String getCountryCode;
	static String getSelectCountryFlag;
	static String getIsActiveSelectCountry;

// enter country in Add Country Maker page
	public void entercountry(String country) {
		log.info("Enter country==>" + country);
		this.country.sendKeys(country);
		getCountry = country.toString();
		System.out.println("get Country value" + getCountry);
	}

// enter isoCountryCode in Add Country Maker page

	public void enterisoCountryCode(String isoCountryCode) {
		log.info("enter iso CountryCode" + isoCountryCode);
		this.isoCountryCode.sendKeys(isoCountryCode);
		getCountryCode = isoCountryCode.toString();
		System.out.println("get Country value" + getCountryCode);
	}

// select  country flag inn Add Country Maker page
	public void selectcountryflag() {
		String s = "Yes";
		log.info(" Add Country Maker page==>" + countryflag);
		Select se = new Select(countryflag);
		se.selectByVisibleText(s);
		// How to convert the Values of
		String getcountryflag = s.toString();
		System.out.println("get country flag===>>" + getcountryflag);
		String[] spl = getcountryflag.split("es");
		System.out.println("Split Array Values===>>" + spl);
		List<String> splitList = Arrays.asList(spl);
		getSelectCountryFlag = String.join("", splitList);
		System.out.println("get Select Country Flag in String Value" + getSelectCountryFlag);

	}

// select  is Active Country ? in Add Country Maker page
	public void selectisActiveCountry() {
		String ss = "Yes";
		log.info("select is Active Country ?==" + isActiveCountry);
		Select aa = new Select(isActiveCountry);
		aa.selectByVisibleText(ss);
		String getisActive = ss.toString();
		System.out.println("get country flag===>>" + getisActive);
		String[] spl = getisActive.split("es");
		System.out.println("Split Array Values===>>" + spl);
		List<String> splitList1 = Arrays.asList(spl);
		getIsActiveSelectCountry = String.join("", splitList1);
		System.out.println("get Select Is Country in String Value" + getIsActiveSelectCountry);

	}

// click on  submit In add Maker page
	public void clickonsubmitInMakerpage() {
		log.info("click on submit In Maker page==>" + submitInMakerpage);
		submitInMakerpage.click();
	}

	public void verifySuccesfullMessageOnAddMakerPage() {

		String verifythemodify = SuccesfullMessage.getText();
		System.out.println("verify the Successful Message===>>>" + verifythemodify);
		log.info("verify the Successful Message===>>>" + verifythemodify);
		if (verifythemodify.equals("Record has been added successfully.")) {
			log.info("==Successfull Message has Matched with  Text==");
		} else if (verifythemodify.equals("This Country Code has already used.")) {
			log.info("This Country Code has already used");
		} else if (verifythemodify.equals("===Not==")) {
			log.info("This is Not Matched");

		} else if (verifythemodify.equals("Record Already Exists")) {
			log.info("Record Already Exists");

		}
	}

	public void ClickOnLogOutButtonOnAddMakerPage() {
		log.info("Click On LogOut Button On Add Maker Page=");
		driver.switchTo().defaultContent();
		logoutMaker.click();
	}

	public void clickonMasterDefinitionChecker() {
		log.info(" Get text Master Definition Checker" + MasterDefinitionChecker.getText());
		log.info("Clcik on MasterDefinitionChecker====");
		MasterDefinitionChecker.click();

	}

	public void clickOnAddCountryCheckerSubMenu() {
		log.info("click On Add Country Checker SubMenu" + AddCountryChecker.getText());
		AddCountryChecker.click();
	}

	public void verifyCountryCheckerPages() throws Exception {
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		log.info("verify Country Checker Page==>>" + verifyCountryChecker.getText());
		String CountryCheckerpage = verifyCountryChecker.getText();

		System.out.println(CountryCheckerpage);
		Assert.assertEquals("COUNTRY CHECKER", CountryCheckerpage);
	}

	// calling path variables and verifyAddcheckerList in Country Checker page.
	public void verifyAddcheckerList() throws InterruptedException {
		String CountryCode = "//table[@id='list']//tbody/tr/td[4]";
		String Country = "//table[@id='list']//tbody/tr/td[5]";
		String IsoCountryCode = "//table[@id='list']//tbody/tr/td[6]";
		String IsNegativeCountry = "//table[@id='list']//tbody/tr/td[7]";
		String CountryIsActive = "//table[@id='list']//tbody/tr/td[8]";
		
		toverifyCheckerlistWhenAddingMaker(CountryCode, getCountryCode);
		toverifyCheckerlistWhenAddingMaker(Country, getCountry);
		toverifyCheckerlistWhenAddingMaker(IsoCountryCode, getCountryCode);
		toverifyCheckerlistWhenAddingMaker(IsNegativeCountry, getSelectCountryFlag);
		toverifyCheckerlistWhenAddingMaker(CountryIsActive, getIsActiveSelectCountry);


	}

// Calling the Generic Method to verify the List in Country Checker page.
	private void toverifyCheckerlistWhenAddingMaker(String xpathvalue, String value) throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text of  Checker list====" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("======Get Text of  Checker list= ======");
             log.info("Text has Matched with the Given value=="+listText);
				break;
			} else {

				System.out.println("==== List Not  matched ===");
				System.out.println("==== Text of List Has Not  matched With ==="+listText);


			}

		}

	}

	public void HandleTheDynamicVluesWithCheckbox() throws Exception {
		// table[@id='list']//tbody/tr/td[4]

		/*
		 * String before_xpath="//table[@id='list']//tbody/tr/td[4"; String
		 * after_xpath="]";
		 * 
		 * for(int i=4; i<=100;i++) { String name =
		 * driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
		 * System.out.println("Get name"+name); if(name.contains("coww")) {
		 * driver.findElement(By.xpath(""));
		 * 
		 * } }
		 */
   // getCountryCode
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
				log.info("Click On Check Box======");
			

			} else {
				System.out.println("Text has  Not Mtched");
			}
		}

	}



	
// click on submit button And 
	public void clickonsubmitbuttonCheckerPage() {
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js1.executeScript("window.scrollBy(0,250)", "");

		// Click on Submit button Checker Page. To Select only one Checkbox
		log.info(" click on Submit button on Checker===>>" + SubmitbuttononChecker.getText());
		 SubmitbuttononChecker.click();
	}
	// verify Succesfull Message on Checker  Page.	
public void	verifySuccesfullMessageOnCheckerPage() {
//		JavascriptExecutor js2 = (JavascriptExecutor) driver;
//		js2.executeScript("window.scrollBy(0,-250)", "");
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		log.info("successful Message in Checker====" + verifysuccessfulMessageinChecker.getText());
		//Assert.assertEquals(successfulMessageinChecker, "Record updated successfully.");
		if(verifysuccessfulMessageinChecker.getText().equals("Record updated successfully.")) {
			log.info("successfuly Message Verified  in Checker Page=");
		}
		else {
			log.info("successfuly Message NOT Verified  in Checker Page="+verifysuccessfulMessageinChecker.getText());
		}

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
	public void verifyViewpageBySerachField() throws InterruptedException {
		Thread.sleep(3000);
		this.searchfield.clear();
		Thread.sleep(3000);
		this.searchfield.sendKeys(getCountry);
		Thread.sleep(4000);
		this.searchfield.clear();
		this.searchfield.sendKeys(getCountryCode);
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

		String countrycode = "//tbody[@role='alert']//tr//td[2]";
		String country = "//tbody[@role='alert']//tr//td[3]";
		String isocountrycode = "//tbody[@role='alert']//tr//td[4]";
		String countryflag = "//tbody[@role='alert']//tr//td[5]";
		String countryActive = "//tbody[@role='alert']//tr//td[6]";
		verifyViewMakerPage(countrycode, getCountryCode.toUpperCase());
		verifyViewMakerPage(country, getCountry.toUpperCase());
		verifyViewMakerPage(isocountrycode, getCountryCode.toUpperCase());
		verifyViewMakerPage(countryflag, getSelectCountryFlag.toUpperCase());
		verifyViewMakerPage(countryActive, getIsActiveSelectCountry.toUpperCase());

	}

// 
// verifytheViewMakerPagewithTextwiththierrespectiveColumn
	public static void verifyViewMakerPage(String xpathvalue, String value) {
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

// Select  All Drop down values in Maker view page when the Added Country has Approved By Checker 
	public void selectAllvaluesOneByOne() {
		WebElement selectcountrycode = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectcountry = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectisocountrycode = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectcountryflag = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement selectcountryActive = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));

		verifyViewMakerPageBySelect(selectcountrycode, getCountryCode.toUpperCase());
		verifyViewMakerPageBySelect(selectcountry, getCountry.toUpperCase());
		verifyViewMakerPageBySelect(selectisocountrycode, getCountryCode.toUpperCase());
		verifyViewMakerPageBySelect(selectcountryflag, getSelectCountryFlag.toUpperCase());
		verifyViewMakerPageBySelect(selectcountryActive, getIsActiveSelectCountry.toUpperCase());

	}

//
// select one by one of Select in View page of Maker
	public static void verifyViewMakerPageBySelect(WebElement xpathvalue, String value) {
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

		log.info(" Get the Text of Modify Ppage===>>" + verifyModifyCountryMakerPage.getText());
		log.info(" verify the Modify  Maker Ppage");
		Assert.assertEquals(verifyModifyCountryMakerPage.getText(), "MODIFY COUNTRY MAKER");

	}

	// select country Code In Modify Maker Page
	//
	public void selectcountryCodeInModifyMakerPage() {
		driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
		Select selectcountryCode = new Select(selectcountryCodeInModifyPage);
		List<WebElement> AllselectcountryCode = selectcountryCode.getOptions();
		int noofCountryOnDropDown = AllselectcountryCode.size();
		System.out.println("Get the No of Country DropDown==>>" + noofCountryOnDropDown);

		for (int i = 0; i < AllselectcountryCode.size(); i++) {
			String GetTextOfAllDropDownValues = AllselectcountryCode.get(i).getText();
			System.out.println("Get Text Of All DropDown Values==>" + GetTextOfAllDropDownValues);

			if (AllselectcountryCode.get(i).getText().equals("022-ABC TEST")) {
				log.info(" ====Matched the Given Data=====");

				selectcountryCode.selectByVisibleText("022-ABC TEST");
				System.out.println(" ==== country Matched the From Country Drop Down=====>>");
				break;
			} else {
				System.out.println("  ==== country Not Matched the From Country Drop Down=====>>");
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

		String selectCountry = "//select[@name='countryCode']//option";

		selectcountryCodeDropDownInModifyMakerPageByUsingIndex(selectCountry, getCountry.toUpperCase());

	}

	public static void selectcountryCodeDropDownInModifyMakerPageByUsingIndex(String xpathvalue, String value) {
		List<WebElement> countryList = driver.findElements(By.xpath(xpathvalue));
		int countryCodeSize = countryList.size();
		System.out.println("Get country Code Size===>>" + countryCodeSize);
		for (int i = 0; i < countryList.size(); i++) {
			String getTextOfContryCodeDropDown = countryList.get(i).getText();
			String[] splt = getTextOfContryCodeDropDown.split("-");
			String splivalues = splt[1].trim();
			System.out.println("split values==" + splivalues);

			System.out.println("get Text Of Contry Code DropDown===>>" + getTextOfContryCodeDropDown);
			if (splivalues.equals(value)) {
				System.out.println("Text has Matched===>>");
				countryList.get(i).click();
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
	public void verificationMessageInModifyCountryPage() {
		log.info("verification Message In Modify Country==>>" + verificationMessageInModifyCountry.getText());
		// Assert.assertEquals(verificationMessageInModifyCountry.getText(), "This
		// country name has already used.");

		// verification Message In Modify Country
		String verifythemodify = verificationMessageInModifyCountry.getText();
		System.out.println("verify the Modify Successful Message===>>>" + verifythemodify);
		log.info("verify the Modify Successful Message===>>>" + verifythemodify);
		if (verifythemodify.equals("This country name has already used.")) {
			log.info("==Successfull Message has Matched with  Text==");
					} 
		else if (verifythemodify.equals("This Country Code has already used.")) {
			log.info("This Country Code has already used");
			
		} else if (verifythemodify.equals("===Not==")) {
			log.info("This is Not Matched");

		}
		else {
			log.info("This is Not Matched");
			
	}
		}

	public void clickOnLogOutButtonOnModifyMakerPage() {
		driver.switchTo().defaultContent();
		log.info("click on logout Button In Modify Maker page===>" + logoutMaker.getText());
		logoutMaker.click();
	}

	// verify the Country checker List IF Modification has Done By Maker with
	// Existing Entity
	public void verifyCountrycheckerListModificationhasDoneByMaker() throws InterruptedException {
		String CountryCode = "//table[@id='list']//tbody/tr/td[4]";
		String Country = "//table[@id='list']//tbody/tr/td[5]";
		String IsoCountryCode = "//table[@id='list']//tbody/tr/td[6]";
		String IsNegativeCountry = "//table[@id='list']//tbody/tr/td[7]";
		String CountryIsActive = "//table[@id='list']//tbody/tr/td[8]";
		StoverifyCheckerlist2(CountryCode, getCountryCode.toUpperCase());
		StoverifyCheckerlist2(Country, getCountry.toUpperCase());
		StoverifyCheckerlist2(IsoCountryCode, getCountryCode.toUpperCase());
		StoverifyCheckerlist2(IsNegativeCountry, getSelectCountryFlag.toUpperCase());
		StoverifyCheckerlist2(CountryIsActive, getIsActiveSelectCountry.toUpperCase());

	}

	// Calling the Generic Method to verify the List in Country Checker page.
	private void StoverifyCheckerlist2(String xpathvalue, String value) throws InterruptedException {

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

	public void selectThecheckboxOnCheckerPageWhenModify() {

		List<WebElement> web = driver.findElements(By.xpath("//table[@id='list']//tbody/tr/td[4]"));
		int sizeOfColumn = web.size();
		System.out.println("size Of Column===>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get Name===>>" + name);
			if (name.contains(getCountryCode.toUpperCase())) {
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
		//Assert.assertEquals(successfulMessageinChecker, "Record updated successfully.");

		if (verifysuccessfulMessageinChecker.getText().equals("Record updated successfully.")) {

		} else if (verifysuccessfulMessageinChecker.getText().equals("")) {

		}
		else {
			log.info(" Successfull Message Not verified===");
		}
	}

//in view Page , search by different values passing into search box,
//refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
	public void verifyViewpagesWhenModifyTheCounterAndApprovedDoneByChecker(String searchfield, String searchfield1,
			String searchfield2) throws InterruptedException {
		this.searchfield.clear();
		this.searchfield.sendKeys(searchfield);
		this.searchfield.clear();
		this.searchfield.sendKeys(searchfield1);
		Thread.sleep(4000);
		this.searchfield.clear();
		this.searchfield.sendKeys(searchfield2);
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

//to Verify Column Text In View Page WithHeaderColumn
//x-path of view page and calling their respective variable  and verify
	public void toVerifyTextInViewPageWithHeaderColumn() {

		String countrycode = "//tbody[@role='alert']//tr//td[2]";
		String country = "//tbody[@role='alert']//tr//td[3]";
		String isocountrycode = "//tbody[@role='alert']//tr//td[4]";
		String countryflag = "//tbody[@role='alert']//tr//td[5]";
		String countryActive = "//tbody[@role='alert']//tr//td[6]";
		verify2(countrycode, "BD");
		verify2(country, "BANGLADESH");
		verify2(isocountrycode, "BDS");
		verify2(countryflag, "N");
		verify2(countryActive, "Y");

	}

//
//verify the View Maker Page with Text with their respective Column
	public static void verify2(String xpathvalue, String value) {
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
		WebElement selectcountrycode = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectcountry = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectisocountrycode = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectcountryflag = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement selectcountryActive = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));

		verify3(selectcountrycode, "BD");
		verify3(selectcountry, "BANGLADESH");
		verify3(selectisocountrycode, "BDS");
		verify3(selectcountryflag, "N");
		verify3(selectcountryActive, "Y");

	}

// Select the values from 5 Drop Down One By one
//select one by one of Select in View page of Maker
	public static void verify3(WebElement aa, String value) {
		Select sel = new Select(aa);
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

		log.info(" Get the Text of Modify Ppage===>>" + verifyModifyCountryMakerPage.getText());
		log.info(" verify the Modify  Maker Ppage");
		Assert.assertEquals(verifyModifyCountryMakerPage.getText(), "MODIFY COUNTRY MAKER");

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

		String Header = driver.findElement(By.xpath("//td[text()=' Country Checker']")).getText();

		System.out.println(Header);
		Assert.assertEquals("COUNTRY CHECKER", Header);

//	String bb = driver.findElement(By.className("mainmenu")).getText();
//	System.out.println(bb);
		// Scroll UP Method Which is used to
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().defaultContent();
//		WebDriverWait wait = new WebDriverWait(driver, 100);
//		WebElement Category_Body = wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//td[@class='mainmenu']//following-sibling::a[text()='Logout']")));
//		System.out.println(Category_Body);

		driver.findElement(By.xpath("//b[text()='Logout']")).click();

	}
}
