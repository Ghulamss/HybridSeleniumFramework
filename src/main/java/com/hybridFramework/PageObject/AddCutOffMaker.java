package com.hybridFramework.PageObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
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
public class AddCutOffMaker {
	static WebDriver driver;

	private final Logger log = LoggerHelper.getLogger(AddCutOffMaker.class);
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
	@FindBy(xpath = "//*[contains(text(),'Add Cut Off Maker')]//parent::a")
	WebElement AddCutOffMaker;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;

	@FindBy(xpath = "//input[@name='effectiveFromDate']")
	WebElement effectiveFromDate;
	@FindBy(xpath = "//select[@name='mandateType']")
	WebElement selectmandateType;

	@FindBy(xpath = "//select[@name='isSameBank']")
	WebElement SelectisSameBank;

	@FindBy(xpath = "//select[@id='isActive']")
	WebElement isActiveCutOffTime;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
	@FindBy(xpath = "//td[contains(text(),'Modify CutOff Time')]")
	WebElement verifyModifyCutOffTime;
	
	// Statrted  Checker X-path

	@FindBy(xpath = "//*[text()='Master Definition Checker']")
	WebElement MasterDefinitionChecker;
	@FindBy(xpath = "//*[text()='Authorise Cut Off Checker']//parent::a")
	WebElement AuthoriseCutOffChecker;
	@FindBy(xpath = "//td[contains(text(),'Cut Off Time Checker')]")
	WebElement verifyCutOffTimeCheckerPage;
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
	@FindBy(xpath = "//input[@value='View / Modify']")
	WebElement viewinMaker;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchfield;

	@FindBy(xpath = "//input[@type='text']")
	WebElement searchfieldOnCheckerView;
	
	@FindBy(xpath = "//select[@name='list_length']")
	WebElement selectentitieslist;
	@FindBy(xpath = "//select[@name='list_length']")
	WebElement logoutInMaker;
// Modify Page in Maker
	@FindBy(xpath = "//input[@value='Modify']")
	WebElement ModifyButton;

	@FindBy(xpath = "//td[contains(text(),'Modify Routing Maker')]")
	WebElement verifyModifRoutingMakerPage;
	@FindBy(xpath = "//input[@name='routingNo']")
	WebElement routingNoOnModifyMakerPage;

	@FindBy(xpath = "//select[@name='purposeCode']")
	WebElement selectSubpurposeCodeInModifyPage;
	@FindBy(name = "Submit")
	WebElement submitbuttonModifyMaker;
	// form[@name='modifyCountry']//table//tr[15]//td//input[@name='Submit']

	@FindBy(xpath = "//form[@name='modifyStatus']//table//tr[2]//td//input[@name='Submit']")
	WebElement modifysubmitbutton;
	@FindBy(xpath = "//td[@class='note']")
	WebElement verificationMessageInModifyPage;

	@FindBy(xpath = "//b[text()='Logout']")
	WebElement logoutMaker;

	// View Page in Checker
	//
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewInChecker;

	public AddCutOffMaker(WebDriver driver) {
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

	public void switchToTab() throws Exception {
		((JavascriptExecutor) driver).executeScript(
				"window.open('https://qaprimelastmile.remit.in/onlinetransfer/secure/home.jsp', '_blank');");

		Set<String> tab_handles = driver.getWindowHandles();
		int number_of_tabs = tab_handles.size();
		int new_tab_index = number_of_tabs - 1;
		driver.switchTo().window(tab_handles.toArray()[new_tab_index].toString());
	}
//		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
//		System.out.println("Tab 2"+tabs2);
//		driver.switchTo().window(tabs2.get(1)); //Tab number

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

// click on Add Cut Off Maker SubMenu
	public void clickonAddCutOffMakerSubMenu() {
		log.info("click on Add Cut Off Maker SubMenu===>" + AddCutOffMaker.getText());
		AddCutOffMaker.click();
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

	//
	public void verifyErrorMessage() {
		List<WebElement> AllErrorMessage = driver.findElements(By.xpath("//div[@class='errortext']//div"));

		for (int i = 0; i < AllErrorMessage.size(); i++) {
			String aa = AllErrorMessage.get(i).getText();
			System.out.println("Get Text Of error Message On Every Field ..." + aa);
		}
	}

	// click on effective From Date
	public void clickOneffectiveFromDate() {
		log.info("click on effective From Date...." + effectiveFromDate);
		effectiveFromDate.click();

	}
	
	public void calenderHandeling() {
		String date = "02-09-2020";
		String dateArr[] = date.split("-"); // {18,September,2017}
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]	
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]
		//table[@class='days']//tr//td
		String beforeXpath = "//table[@class='days']//tr[";
		String afterXpath = "]/td[";
		
		final int totalWeekDays = 7;
		
		//2-1 2-2 2-3 2-4 2-5 2-6 2-7
		//3-2 3-2 3-3 3-4 3-5 3-6 3-7
		boolean flag = false;
		String dayVal = null;
		for(int rowNum=2; rowNum<=7; rowNum++){
			
			for(int colNum = 1; colNum<=totalWeekDays; colNum++){
				try{
			    dayVal =driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
				}catch (NoSuchElementException e){
					System.out.println("Please enter a correct date value");
					flag = false;
					break;
				}
				System.out.println(dayVal);
				if(dayVal.equals(day)){
					driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
					flag = true;
					break;
				}				
			}
			if(flag){
				break;
			}
			
		}
	
		
	}

		
		
		
		
		
	
	
	

// Selecting the Date By using Java Script.
	public void selectCalenderByJS() {

		WebElement date = driver.findElement(By.id("effectiveFromDate"));
		String dateVal = "02-09-2020";

		selectDateByJS(driver, date, dateVal);

	}

	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + dateVal + "');", element);

	}

	public void selectEffectiveTodateByJS() {
		WebElement date = driver.findElement(By.id("effectiveToDate"));
		String dateVal = "02-09-2020";

		selectEffectiveDateByJS(driver, date, dateVal);

	}

	public static void selectEffectiveDateByJS(WebDriver driver, WebElement element, String dateVal) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + dateVal + "');", element);

	}

	public void selectmandateTypeOnMakerPage() {
		log.info("Select the Mandate Type ");
		Select selectmandate = new Select(selectmandateType);
		List<WebElement> listogMandateType = selectmandate.getOptions();
		int getNoOfmandateType = listogMandateType.size();
		System.out.println("Get No of mandate Type ----" + getNoOfmandateType);
		for (int i = 0; i < listogMandateType.size(); i++) {
			String GetTextofMandateType = listogMandateType.get(i).getText();
			System.out.println("Get the Text of the mandate  Type..." + GetTextofMandateType);
			if (GetTextofMandateType.equals("payment03")) {
				System.out.println("Get the Text of the mandate  Type has Matched with given Value..");
				selectmandate.selectByValue("payment03");
				log.info("Given value has Slected on Drop Down..");
				break;
			} else {
				System.out.println("Get the Text  has No.. Matched with given Value..");
				System.out.println("Given value has  Not Slected From Drop Down..");

			}

		}

	}

// select  is Active CutOff time on  Cut off Maker page
	public void isActiveCutOffTimeOnMakerPage() {
		log.info("select is Active Cut Off  ?...." + isActiveCutOffTime);
		Select aa = new Select(isActiveCutOffTime);
		aa.selectByVisibleText("Yes");
	}

	// Selecting the Date By using Java Script.
	public void selectcutoffTimeByJS() {

		WebElement date = driver.findElement(By.id("cutOffTime"));
		String dateVal = "05:31 PM";

		selectTimeByJS(driver, date, dateVal);

	}

	public static void selectTimeByJS(WebDriver driver, WebElement element, String dateVal) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','" + dateVal + "');", element);

	}

// click on  submit In add  Payment Type Maker page
	public void clickonsubmitInMakerpage() {
		log.info("click on submit In Maker page==>" + submitInMakerpage);
		submitInMakerpage.click();
	}
//  to verify the Successful Message to the Added Routing maker Successfully

	public void verifySuccesfullMessage() {

		String verifythemodify = SuccesfullMessage.getText();
		System.out.println("verify the Successful Message===>>>" + verifythemodify);
		log.info("verify the Successful Message===>>>" + verifythemodify);
		if (verifythemodify.equals("Record has been added successfully.")) {
			driver.switchTo().defaultContent();
			log.info("==Successfull Message has Matched with  Text==");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("Record Already Exists")) {
			log.info("This Country Code has already used");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("Record Already Exists")) {
			log.info("This is Not Matched");

		}

		else {
			log.info(" ....Verify Message is not Matched....");
			String verifythemodify1 = SuccesfullMessage.getText();
			System.out.println("verify the Successful Message===>>>" + verifythemodify1);
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

	// click Authorise Cut Off Checker SubMenu
	public void clickOnAuthoriseCutOffCheckerSubMenu() {
		log.info("click On Authorise Cut Off Checker SubMenu..." + AuthoriseCutOffChecker.getText());
		AuthoriseCutOffChecker.click();
	}

	// verify Cut Off Checker Page
	public void verifyCutOffTimeCheckerPages() throws Exception {
		log.info("verify Cut Off Time Checker Page...");
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		log.info("verify Cut Off Time Checker Page...." + verifyCutOffTimeCheckerPage.getText());
		String CutOffCheckerPage = verifyCutOffTimeCheckerPage.getText();

		System.out.println("Get the Text of  Cut Off Checker Page..." + CutOffCheckerPage);
		Assert.assertEquals("CUT OFF TIME CHECKER", CutOffCheckerPage);
		log.info(" Suceessfully verified the Cut off Checker Page...");
	}

	// calling path variables and verifyAddcheckerList in Routing Keyword Checker page
	// verify Add Cut Off maker at checker List In Cut Off Checker
	public void verifyAddcheckerListInCheckerpage() throws InterruptedException {
		String EffectiveFromDate = "//table[@id='list']//tbody/tr/td[4]";
		String EffectiveToDate = "//table[@id='list']//tbody/tr/td[5]";
		String PaymentType = "//table[@id='list']//tbody/tr/td[6]";
		String CutOffTime = "//table[@id='list']//tbody/tr/td[7]";
		String 	IsActive = "//table[@id='list']//tbody/tr/td[8]";
		

		toverifyCheckerlist(EffectiveFromDate, "2020-06-03");
		toverifyCheckerlist(EffectiveToDate, "2020-06-03");
		toverifyCheckerlist(PaymentType, "ew");
		toverifyCheckerlist(CutOffTime , "01:04:00");
		toverifyCheckerlist(IsActive, "Y");
		

	}

// Calling the Generic Method to verify the List in purpose Checker page.
	private void toverifyCheckerlist(String xpathvalue, String value) throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text of  Checker list of pages ====" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("======Get Text of  Checker list Matched = ======");
				System.out.println(" Get Text has Matched with given value");
				// driver.findElement(By.xpath("//input[@id='selectAll']")).click();

				break;
			} else {

				System.out.println("==== Get Text has Not matched with List ===");
				
				// driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();

			}

		}

	}

// checkbox selecting 
	public void multiplecheckbox() {
		// List<WebElement> checkbox;
		int noofCheckbox = checkbox.size();
		System.out.println(noofCheckbox);
		// checkbox.get(10).click();
		for (int i = 0; i < checkbox.size(); i++) {

			boolean selectcheckbox = checkbox.get(i).isSelected();
			System.out.println("checkbox is Not selected::" + selectcheckbox);
			// checkbox.get(10).click();
			if (true) {
				// for Selecting particular Checkbox "Select"
				// Starts from 0 Even No gives the Select and Odd No Reject.
				checkbox.get(2).click();
				// This is for Multi Select All
				// checkbox .get(i).click();
				System.out.println(" Checkbox is selected===");

			}
			break;

		}

	}

	// Select All And Reject All
	public void selectHeadercheckbox() throws InterruptedException {
		int Headercheck = Headercheckbox.size();
		System.out.println("No of  Header checkbox ===>" + Headercheck);
		for (int i = 0; i < Headercheckbox.size(); i++) {
			Thread.sleep(3000);
			boolean SelectAll = Headercheckbox.get(i).isSelected();

			System.out.println(" Chheck header is selected Or Not===" + SelectAll);
			// if SelectAll==true then it will go to in If loop and select checkbox based on
			// get i
			// if SelectAll==false then it will go to in If loop and select checkbox based
			// on get i
			if (SelectAll == true) {
				Headercheckbox.get(0).click();
				System.out.println("Select All Checkbox==>" + SelectAll);
				break;
			}

			else {
				Headercheckbox.get(1).click();
				System.out.println("Select Reject Checkbox==>" + SelectAll);

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
	public void verifyViewpages(String searchfield, String searchfield1, String searchfield2)
			throws InterruptedException {
		this.searchfield.clear();
		this.searchfield.sendKeys(searchfield);
		this.searchfield.clear();
		this.searchfield.sendKeys(searchfield1);
		Thread.sleep(4000);
		this.searchfield.clear();
		this.searchfield.sendKeys(searchfield2);
		Thread.sleep(4000);
		this.searchfield.clear();

		/* This  Element is not available in Cut Off  Modify Maker pag
		 * driver.navigate().refresh(); Select entitieslist = new
		 * Select(selectentitieslist); Thread.sleep(4000); List<WebElement>
		 * Noofentitieslist = entitieslist.getOptions(); int nooflist =
		 * Noofentitieslist.size(); System.out.println("No of entities list====>>" +
		 * nooflist); entitieslist.selectByVisibleText("All"); for (int i = 0; i <
		 * nooflist; i++) { String entitiestext = Noofentitieslist.get(i).getText();
		 * System.out.println("Get entities text===>" + entitiestext);
		 */
		
		
		
		}

	
	
	
	
	

// x-path of view page and calling their respective variable  and verify
// verify the Maker View page By using Text verification 
	public void multippleSelectVerifyTextInViewPage() {
		driver.switchTo().defaultContent();
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);
		driver.switchTo().frame(0);

		String effectivefrom = "//div[@class='input-group date']//input[contains(@name,'effectivefrom')]";
		String effectiveTo = "//div[@class='input-group date']//input[contains(@name,'effectiveto')]";
		//String mandateType = "//select[contains(@name,'mandateType')]";
		String cutOffTime = "//div[@class='input-group date']//input[contains(@name,'cutOffTime')]";
		//String ISActive = "//input[contains(@name,'isActive')]";

		verifytheViewpageWithText(effectivefrom, "20-18-2019");
		verifytheViewpageWithText(effectiveTo, "09-18-2019");
		//verifytheViewpageWithText(mandateType, "NEFT");
		verifytheViewpageWithText(cutOffTime, "4:43 PM");
		//verifytheViewpageWithText(ISActive, "Y");

	}

// 
// verify the View Maker Page with Text with thier respective Column
	public static void verifytheViewpageWithText(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getAttribute("value");
			System.out.println(" Get Text of ====" + listText);
			if (list1.get(i).getAttribute("value").equals(value)) {
				System.out.println("======List matched ======");
				break;
			} else {
				
				/*
				 * List<WebElement> bb = driver.findElements(By.
				 * xpath("//div[@class='dataTables_paginate paging_simple_numbers']//span//b"));
				 * System.out.println("get the size of Pagination"+bb.size()); for(int j=0; j<
				 * bb.size(); j++) { System.out.println("Before Click"); bb.get(j).click();
				 * System.out.println("After Click"); }
				 */
				  System.out.println("==== List Not  matched ==="); 
			}
		}

	}
	//
public void conceptofPaging() throws Exception {
	//div[@id='cutOffDetails_paginate']//span//b
	driver.switchTo().defaultContent();
	List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
	System.out.println(iframeElements);
	driver.switchTo().frame(0);
	//  //input[contains(@name,'effectivefrom')]   for get Attribute 
	
	List<WebElement> namesElements = driver.findElements(By.xpath("//div[@class='input-group date']//input[contains(@name,'effectivefrom')]"));
	
	      ArrayList<String> names = new ArrayList<String>();
	      for(WebElement nameElement :namesElements) {
	    	  names.add(nameElement.getAttribute("value"));
	    	  //System.out.println("Get names"+names);
	      }
	  String nextButtonClassName = driver.findElement(By.id("cutOffDetails_next")).getAttribute("class");
	  
	  while(!nextButtonClassName.contains("disabled")) {
		  driver.findElement(By.id("cutOffDetails_next")).click();
		  namesElements = driver.findElements(By.xpath("//div[@class='input-group date']//input[contains(@name,'effectivefrom')]"));
		  
		  for(WebElement nameElement :namesElements) {
	    	  names.add(nameElement.getAttribute("value"));
	    	  
	      }
		  nextButtonClassName = driver.findElement(By.id("cutOffDetails_next")).getAttribute("class");
	  
	  }
	  
	  for(String name:names) {
		 // if(name.equals("09-16-2019"))
		  System.out.println("Get Text All"+name);
		  
	
	  }
     int totalNames=names.size();
     System.out.println("Total number of Nmaes :"+totalNames);
		/*
		 * driver.switchTo().defaultContent(); List<WebElement> iframeElements1 =
		 * driver.findElements(By.tagName("iframe"));
		 * System.out.println(iframeElements1); driver.switchTo().frame(0);
		 */
		Thread.sleep(5000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
  String displayedCount = driver.findElement(By.id("cutOffDetails_info")).getText().split(" ")[5];
  System.out.println("Total Number of Displayed Names Count :"+displayedCount);
  Assert.assertEquals(displayedCount, String.valueOf(totalNames));
  
  //Thread.sleep(5000);
}
	
	
	
	
// Select  All Drop down values in Maker view page when the Added Currency has Approved By Checker 
	public void selectAllvaluesOneByOne() {
		// WebElement
		WebElement selectBankID = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectBankName = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectBankBranch = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectRoutingNumber = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement selectISActive = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));

		verifyBytheDropDownlistOneByOne(selectBankID, "163");
		verifyBytheDropDownlistOneByOne(selectBankName, "AGRANI BANK LTD.");
		verifyBytheDropDownlistOneByOne(selectBankBranch, "D.U.E.T.");
		verifyBytheDropDownlistOneByOne(selectRoutingNumber, "010330436");
		verifyBytheDropDownlistOneByOne(selectISActive, "Y");

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

		log.info(" Get the Text of Modify Routing Maker Ppage===>>" + verifyModifRoutingMakerPage.getText());
		log.info(" verify the Modify  Routing  Maker Ppage...");
		Assert.assertEquals(verifyModifRoutingMakerPage.getText(), "MODIFY ROUTING MAKER");
		log.info(" Successfully verified the Modify Routing  Maker Ppage...");

	}

	// enter routing No On Modify Maker Page
	public void enterroutingNoOnModifyMakerPage(String routingNoOnModifyMakerPage) {
		driver.switchTo().defaultContent();
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);
		driver.switchTo().frame(0);
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));
		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());

		log.info("Enter the Routing No on Modify routing Maker page..." + routingNoOnModifyMakerPage);
		this.routingNoOnModifyMakerPage.sendKeys(routingNoOnModifyMakerPage);

	}

	// This code is not used in the Modify Routing Page
	// select Purpose Code In Modify purpose Maker Page
	public void selectPurposeCodeInModifyPurposeMakerPage() {
		driver.switchTo().defaultContent();
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);
		driver.switchTo().frame(0);
// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));
		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());

		// Select SubPurpose Code Drop Down
		//
		Select selectPurposeCode = new Select(selectSubpurposeCodeInModifyPage);
		List<WebElement> AllPurposeCode = selectPurposeCode.getOptions();
		int noofPurposeCodedOnDropDown = AllPurposeCode.size();
		System.out.println("Get the No of Sub Purpose code On DropDown==>>" + noofPurposeCodedOnDropDown);

		for (int i = 0; i < AllPurposeCode.size(); i++) {
			String GetTextOfAllDropDownValues = AllPurposeCode.get(i).getText();
			System.out.println("Get Text Of All DropDown Values==>" + GetTextOfAllDropDownValues);

			if (AllPurposeCode.get(i).getText().equals("BD-CDE-EFG")) {
				log.info(" ====Matched the Given Data=====");

				selectPurposeCode.selectByVisibleText("BD-100001-WAGE EARNER");
				System.out.println(
						" ==== Sub Purpose Code Matched the From Subp purpose Code Drop Down In MODIFY Sub Purpose MAKER page=====>>");
				break;
			} else {

				System.out.println(
						" ==== Sub Purpose Code not  Matched the From Sub Purpose Code Drop Down In MODIFY Sub Purpose MAKER page=====>>");
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

	// verification Message In Modify Routing page
	public void successfullverificationMessageInModifyMakerPage() throws Exception {
		log.info("Get the Text Of Successful Verification Message On Modify Page==>>"
				+ verificationMessageInModifyPage.getText());
		// Assert.assertEquals(verificationMessageInModifyEntityType.getText(), "Record
		// has been modified successfully.");

		// verification Message In Modify Payment Type Page
		String verifythemodify = verificationMessageInModifyPage.getText();
		System.out.println("Get the Text Of Successful Verification Message On Modify Page==>>" + verifythemodify);
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

	// verify the Payment Type checker List IF Modification has Done By Maker with
	// Existing Entity
	//
	public void verifyListonCheckerpageWhenModificationhasDoneByMaker() throws InterruptedException {
		String BankID = "//table[@id='list']//tbody/tr/td[4]";
		String RoutingNumber = "//table[@id='list']//tbody/tr/td[5]";
		String BankName = "//table[@id='list']//tbody/tr/td[6]";
		String BankBranch = "//table[@id='list']//tbody/tr/td[7]";
		String District = "//table[@id='list']//tbody/tr/td[8]";
		String Division = "//table[@id='list']//tbody/tr/td[9]";
		String DistrictCode = "//table[@id='list']//tbody/tr/td[10]";
		String BankCode = "//table[@id='list']//tbody/tr/td[11]";
		String BranchCode = "//table[@id='list']//tbody/tr/td[12]";
		String Address = "//table[@id='list']//tbody/tr/td[13]";
		String isActive = "//table[@id='list']//tbody/tr/td[14]";
		String IsSameBank = "//table[@id='list']//tbody/tr/td[15]";

		toverifyCheckerlistWhenModifiedMaker(BankID, "BD");
		toverifyCheckerlistWhenModifiedMaker(RoutingNumber, "1000");
		toverifyCheckerlistWhenModifiedMaker(BankName, "100001");
		toverifyCheckerlistWhenModifiedMaker(BankBranch, "WAGE EARNER");
		toverifyCheckerlistWhenModifiedMaker(District, "Y");
		toverifyCheckerlistWhenModifiedMaker(Division, "Y");
		toverifyCheckerlistWhenModifiedMaker(DistrictCode, "Y");
		toverifyCheckerlistWhenModifiedMaker(BankCode, "Y");
		toverifyCheckerlistWhenModifiedMaker(BranchCode, "Y");
		toverifyCheckerlistWhenModifiedMaker(Address, "Y");
		toverifyCheckerlistWhenModifiedMaker(isActive, "Y");
		toverifyCheckerlistWhenModifiedMaker(IsSameBank, "Y");

	}

	// Calling the Generic Method to verify the List in Entity Type Checker page.
	private void toverifyCheckerlistWhenModifiedMaker(String xpathvalue, String value) throws InterruptedException {

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

	// Select Multiple Check box In different Method()
	// Select and DeSelect the by using iterator We can use this Method Also
	// We can use this Method Carefully.
	public void SelectAndDeSelectMutilpeCheckboxoneByOneInChecker() throws InterruptedException {

		// Select checkbox one by one in AllSelect
		List<WebElement> FirstAllCheckbox = driver.findElements(By.xpath("//table[@id='list']//tbody/tr/td[1]"));
		ListIterator<WebElement> it = FirstAllCheckbox.listIterator();
		while (it.hasNext()) {
			it.next().click();
			Thread.sleep(2000);
			// break;
		}

//  Select checkbox one by one in RejectAll
		List<WebElement> SecondAllCheckbox = driver.findElements(By.xpath("//table[@id='list']//tbody/tr/td[2]"));
		ListIterator<WebElement> it2 = SecondAllCheckbox.listIterator();
		while (it2.hasNext()) {
			it2.next().click();
			Thread.sleep(2000);
			// break;

		}

		// Select checkbox of header in SelectAll&RejectAll in Country checker
		//
		Thread.sleep(5000);
		List<WebElement> headerCheckbox = driver.findElements(By.xpath("//th//input[@type='checkbox']"));
		ListIterator<WebElement> it3 = headerCheckbox.listIterator();
		while (it3.hasNext()) {
			it3.next().click();
			Thread.sleep(2000);
			// break;
		}
		// Deselect the Header of "RejectAll"
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();
	}

//checkbox selecting  After ModifytheCountry 
	public void multiplecheckboxwhenModifytheCountry() {
		// List<WebElement> checkbox;
		int noofCheckbox = checkbox.size();
		System.out.println(noofCheckbox);
		// checkbox.get(10).click();
		for (int i = 0; i < checkbox.size(); i++) {

			boolean selectcheckbox = checkbox.get(i).isSelected();
			System.out.println("checkbox is Not selected::" + selectcheckbox);
			// checkbox.get(10).click();
			if (true) {
				// for Selecting particular Checkbox "Select"
				// Starts from 0 Even No gives the Select and Odd No Reject.
				// checkbox.get(4).click();
				checkbox.get(2).click();
				// This is for Multi Select All
				// checkbox .get(i).click();
				System.out.println(" Checkbox is selected===");

			}
			break;

		}

	}

	//
	// click on submit button And verify Succesfull Message If Modifythe Country
	public void clickonsubmitbuttonAndverifySuccesfullMessageIfModifytheCountry() {

		// Click on Submit button Checker Page. To Select only one Checkbox
		log.info(" click on Submit button on Checker===>>" + SubmitbuttononChecker.getText());
		SubmitbuttononChecker.click();
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		log.info("successful Message in Checker====" + verifysuccessfulMessageinChecker.getText());
		Assert.assertEquals(successfulMessageinChecker, "Record updated successfully.");

		if (verifysuccessfulMessageinChecker.getText().equals("Record updated successfully.")) {

		} else if (verifysuccessfulMessageinChecker.getText().equals("")) {

		}

	}

	public void verifyModifyCutOffTimePages() {
		driver.switchTo().defaultContent();
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);
		driver.switchTo().frame(0);
		String getText = verifyModifyCutOffTime.getText();
		System.out.println(" verify the Modiy page=="+getText);
		if(verifyModifyCutOffTime.getText().equals("MODIFY CUTOFF TIME")) {
			log.info(" Cut off Modify page Succesfully verified");
			
		}
		else {
			log.info(" Cut off Modify page Not verified Succesfully");
		}
	}
	
	
	
//in view Page , search by different values passing into search box,
//refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
	// 2. when the Modified the Currency then "View" page Maker
	public void verifyViewpagesWhenModifyTheCounterAndApprovedDoneByChecker(String searchfieldOnCheckerView, String searchfield1,
			String searchfield2) throws InterruptedException {
		
		driver.switchTo().defaultContent();
		/*
		 * List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		 * System.out.println(iframeElements); driver.switchTo().frame(0);
		 */
		 Thread.sleep(30000);
		this.searchfieldOnCheckerView.clear();
		log.info(" Cleared the Search field....");
		this.searchfieldOnCheckerView.sendKeys(searchfieldOnCheckerView);
		log.info(" Value entered in Search field....");
		this.searchfieldOnCheckerView.clear();
		this.searchfieldOnCheckerView.sendKeys(searchfield1);
		
		this.searchfieldOnCheckerView.clear();
		this.searchfieldOnCheckerView.sendKeys(searchfield2);
		
		this.searchfieldOnCheckerView.clear();

		/*
		 * driver.navigate().refresh();
		 * 
		 * Select entitieslist = new Select(selectentitieslist); Thread.sleep(4000);
		 * List<WebElement> Noofentitieslist = entitieslist.getOptions(); int nooflist =
		 * Noofentitieslist.size(); System.out.println("No of entities list====>>" +
		 * nooflist); entitieslist.selectByVisibleText("All"); for (int i = 0; i <
		 * nooflist; i++) { String entitiestext = Noofentitieslist.get(i).getText();
		 * System.out.println("Get entities text===>" + entitiestext); }
		 */

	}

//to Verify Column Text In View Page WithHeader Column
//x-path of view page and calling their respective variable  and verify
	public void toVerifyByTextInViewMakerPagewhenModified() {

		String fromDate = "//tbody[@role='alert']//tr//td[2]";
		String toDate = "//tbody[@role='alert']//tr//td[3]";
		String mandateType = "//tbody[@role='alert']//tr//td[4]";
		String cutOffTime = "//tbody[@role='alert']//tr//td[5]";
		String effectiveFromDate = "//tbody[@role='alert']//tr//td[6]";
		String effectiveToDate = "//tbody[@role='alert']//tr//td[7]";
		String isActive  = "//tbody[@role='alert']//tr//td[8]";
		String cutOffId = "//tbody[@role='alert']//tr//td[9]";
		
		
		
		verifyTheMakerViewPageWhenModified(fromDate, "01-10-2020");
		verifyTheMakerViewPageWhenModified(toDate, "02-29-2020");
		verifyTheMakerViewPageWhenModified(mandateType, "BKASH");
		verifyTheMakerViewPageWhenModified(cutOffTime, "20:08:00");
		verifyTheMakerViewPageWhenModified(effectiveFromDate, "01-10-2020");
		verifyTheMakerViewPageWhenModified(effectiveToDate, "02-29-2020");
		verifyTheMakerViewPageWhenModified(isActive, "Y");
		verifyTheMakerViewPageWhenModified(cutOffId, "268");
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
		// WebElement
		WebElement fromDate = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement toDate = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement mandateType = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement cutOffTime = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement effectiveFromdate = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));
		WebElement effectiveTodate  = driver.findElement(By.xpath("//tfoot//tr//th[7]//select"));
		WebElement isActive = driver.findElement(By.xpath("//tfoot//tr//th[8]//select"));
		WebElement cutOfID = driver.findElement(By.xpath("//tfoot//tr//th[9]//select"));
		
		
		verifySelectDropDonInViewMakerPageWhenModified(fromDate, "01-31-0002");
		verifySelectDropDonInViewMakerPageWhenModified(toDate, "02-28-2020");
		verifySelectDropDonInViewMakerPageWhenModified(mandateType, "NAV");
		verifySelectDropDonInViewMakerPageWhenModified(cutOffTime, "18:00:00");
		verifySelectDropDonInViewMakerPageWhenModified(effectiveFromdate, "01-31-0002");
		verifySelectDropDonInViewMakerPageWhenModified(effectiveTodate, "02-28-2020");
		verifySelectDropDonInViewMakerPageWhenModified(isActive, "Y");
		verifySelectDropDonInViewMakerPageWhenModified(cutOfID, "270");
		
		
		
	}

//
// select one by one of Select in View page of Maker
// 4 drop down using one by one select the values from drop down
	public static void verifySelectDropDonInViewMakerPageWhenModified(WebElement aa, String value) {

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

		log.info(" Get the Text of Modify Entity Type Maker Ppage===>>" + verifyModifRoutingMakerPage.getText());
		log.info(" verify the Modify  Entity Type Maker Ppage...");
		Assert.assertEquals(verifyModifRoutingMakerPage.getText(), "MODIFY PAYMENT TYPE MAKER");
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
			//String newwin1 = it1.next();
			//String newwin2 = it1.next();
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

		
		// Scroll UP Method Which is used to
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().defaultContent();
		
		
		driver.findElement(By.xpath("//b[text()='Logout']")).click();

	}
}
