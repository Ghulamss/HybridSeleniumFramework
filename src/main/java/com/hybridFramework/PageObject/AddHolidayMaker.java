package com.hybridFramework.PageObject;

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
import org.openqa.selenium.interactions.Actions;
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
public class AddHolidayMaker {
	static WebDriver driver;

	private final Logger log = LoggerHelper.getLogger(AddHolidayMaker.class);
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
	@FindBy(xpath = "//*[contains(text(),'Add Holiday Maker')]//parent::a")
	WebElement AddHolidayMakerSubMenu;
	@FindBy(xpath = "//td[text()='Add Holiday Maker']")
	WebElement verifyAddHolidayMaker;
	
	
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;
	@FindBy(xpath = "//select[@name='bankName']")
	WebElement selectbankName;
	@FindBy(xpath = "//span[@id='displayBranchDiv']//select[@name='branchName']")
	WebElement selectbranchName;
	@FindBy(xpath = "//input[@name='occasion']")
	WebElement occasion;
	
	
	@FindBy(xpath = "//select[@id='isActive']")
	WebElement isActiveEntity;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
// Statrted  Checker X-path
	
	@FindBy(xpath = "//*[text()='Master Definition Checker']")
	WebElement MasterDefinitionChecker;
	@FindBy(xpath = "//*[text()='Add Holiday Checker']")
	WebElement AddHolidayChecker;
	@FindBy(xpath = "//td[contains(text(),'Holiday Checker')]")
	WebElement verifyHolidayCheckerPage;
	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> checkbox;
	// //input[@type='checkbox']//parent::th for getting Text of Header of 
	@FindBy(xpath = "//th//input[@type='checkbox']")
	List<WebElement> Headercheckbox;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement SubmitbuttononChecker;
	
	@FindBy(xpath = "//td[@class='note']//parent::tr//preceding-sibling::tr[2]")
	WebElement verifysuccessfulMessageinChecker;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement Logoutinchecker;
	
	// View page in Maker 
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewinMaker;
	@FindBy(xpath = "//input[@type='text']")
	WebElement searchfield;
	
	@FindBy(xpath ="//select[@name='list_length']")
	WebElement selectentitieslist;
	@FindBy(xpath ="//select[@name='list_length']")
	WebElement logoutInMaker;
// Modify Page in Maker
	@FindBy(xpath ="//input[@value='Modify']")
	WebElement ModifyButton;
	
	@FindBy(xpath ="//td[text()='Modify Purpose Maker']")
	WebElement verifyModifyPurposeMakerPage;
	
	@FindBy(xpath ="//select[@name='purposeCode']")
	WebElement selectpurposeCodeInModifyPage;
	@FindBy(name="Submit")
	WebElement submitbuttonModifyMaker;
	//form[@name='modifyCountry']//table//tr[15]//td//input[@name='Submit']
	
	@FindBy(xpath="//form[@name='modifyStatus']//table//tr[2]//td//input[@name='Submit']")
	WebElement modifysubmitbutton;
	@FindBy(xpath="//td[@class='note']")
	WebElement verificationMessageInModifyPaymentType;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutMaker;
	
	
	// View Page in Checker
	// 
	@FindBy(xpath="//input[@id='view']")
	WebElement viewInChecker;
	
	public AddHolidayMaker(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.waitForElement(driver, loginid, 10);
		// waitHelper.waitForElement(driver, loginid, 60);
	}




	// enter username
	public void enterloginid(String loginid) {
		log.info("Enter Login Id in login page=="+loginid.length());
		this.loginid.clear();
		log.info("Enter Login Id in login page==>>"+loginid.length());
		this.loginid.sendKeys(loginid);
		
	}

	// enter password
	public void enterpassword(String password) {
		log.info("Enter password in login page==>>"+password.length());
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

// click on Add Holiday Maker SubMenu
	public void clickonAddHolidayMakerSubMenu() {
		log.info("click on Add Holiday Maker SubMenu===>" + AddHolidayMakerSubMenu.getText());
		AddHolidayMakerSubMenu.click();
	}
	// verify Add Holiday Maker Page
	public void verifyAddHolidayMakerPage() {
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		String verifyAddHoliday = verifyAddHolidayMaker.getText();
		System.out.println("Get the Text of Maker holiday page...."+verifyAddHoliday);
		if (verifyAddHoliday.equals("ADD HOLIDAY MAKER")) {
			System.out.println(" Succesfully verified ADD HOLIDAY MAKER page");
		}
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
	
	
	
	
	
	// select Bank Name On Add Holiday Maker page
	public void selectbankNameOnAddHolidaypage() {
		log.info("select Bank Name on Add Holiday Maker Page....."+selectbankName);
		Select selectBank= new Select(selectbankName);
		List<WebElement> AllselectBank = selectBank.getOptions();
	int 	GetNoOfAllBank=AllselectBank.size();
	
	log.info("Get the Size of the All Bank Name On Drop Down... "+GetNoOfAllBank);
	for(int i=1; i<AllselectBank.size(); i++) {
		String GetTextOfBankNameDropDown = AllselectBank .get(i).getText();
		System.out.println("Get Text Of Bank name DropDown  form Bank Name DropDown List...."+GetTextOfBankNameDropDown);
		if(AllselectBank .get(i).getText().equals("AL-ARAFAH ISLAMI BANK LTD.-015")) {
			log.info("......Text has Matched....");
			
			selectBank.selectByVisibleText("AL-ARAFAH ISLAMI BANK LTD.-015");
			log.info(" ..Bank Name drop down Text has Selected.... ");
			break;
		}
		
		else {
			System.out.println("......Text has Matched Not Matched....");
			log.info(" Bank name drop down Text has not Selected ");
		}
	}
	
	}
	
	
	// select Branch Name On Add Holiday Maker page
		public void selectbranchNameOnAddHolidaypage() {
			log.info("select branch Name on Add Holiday Maker Page....."+selectbranchName);
			Select selectBrancn= new Select(selectbranchName);
			List<WebElement> getAllBranchName = selectBrancn.getOptions();
		int 	getSizeOfBranchName=getAllBranchName.size();
		
		log.info("Get the Size of the Branch Name On Drop Down... "+getSizeOfBranchName);
		for(int i=1; i<getAllBranchName.size(); i++) {
			String GetTextOfBranchNameOnDropDown = getAllBranchName .get(i).getText();
			System.out.println("Get Text Of Branch Name form Bank Name DropDown List...."+GetTextOfBranchNameOnDropDown);
			if(getAllBranchName.get(i).getText().equals("015180199-CHUADANGA")) {
				log.info("......Text has Matched....");
				
				selectBrancn.selectByVisibleText("015180199-CHUADANGA");
				log.info(" ..Bank Branch drop down Text has Selected.... ");
				break;
			}
			
			else {
				System.out.println("......Text has Matched Not Matched....");
				log.info(" Branch Nameme drop down Text has not Selected ");
			}
		}
		
		}
	// different Method to Handle Data picker By using 
		public void  selectHolidayDate() throws Exception {
			 driver.findElement(By.xpath("//input[@name='holidayDate']")).click();
			 log.info(" Click on  Holiday");
			
			String aa=driver.findElement(By.xpath("//div[@class='titleText']//div")) .getText();
			System.out.println(aa);
			while(!driver.findElement(By.xpath("//div[@class='header']//div[@class='titleText']//div"))
		  .getText().contains("Sep 2020")) {
			  //Thread.sleep(5000);
				Actions action = new Actions(driver);
				//moving to the main menu and then sub menu and clicking on it using object of the Actions class
				action.moveToElement(driver.findElement(By.xpath("//div[@class='next']"))).click().build().perform();
		 
		  }
		//td[@role='gridcell']
			  List<WebElement> days = driver.findElements(By.xpath("//*[@role='gridcell']"));
			  int count =days.size();
			  System.out.println("Get the No of days=====>>"+count);
			  for(int i=0; i<days.size();i++) {
				  String getTextOfDate = days.get(i).getText();
				  System.out.println("Get  All Text On days  Calender====>>"+getTextOfDate);
				  if(days.get(i).getText().equals("2")) {
					  
					  days.get(i).click();
					  break;
				  }
				  
			  }
		}
	public void enterOccasion(String occasion) {
		log.info("Enter occasion=="+occasion);
		this.occasion.sendKeys(occasion);
		
	}
	
// select  is Active Holiday ? in Holiday Maker page
	public void selectisActiveHoliday() {
		log.info("select is Active Holiday  ?==" + isActiveEntity);
		Select aa = new Select(isActiveEntity);
		aa.selectByVisibleText("Yes");
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
			log.info("==Successfull Message has Matched with  Text==");
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
		} else if (verifythemodify.equals("Record Already Exists")) {
			log.info("This Country Code has already used");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
		} else if (verifythemodify.equals("Record Already Exists")) {
			log.info("This is Not Matched");

		}
		
		else {
			log.info(" ....Verify Message is not Matched....");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
		}
	}
// click on Master Definition Checker
	public void clickonMasterDefinitionChecker() {
		log.info(" Get text Master Definition Checker"+MasterDefinitionChecker.getText());
		log.info("Clcik on MasterDefinitionChecker====");
		MasterDefinitionChecker.click();
		
	}
	// click Add Holiday Checker SubMenu
	public void clickOnAddHolidayCheckerSubMenu() {
		log.info("click On Add Holiday Checker SubMenu..."+AddHolidayChecker.getText());
		AddHolidayChecker.click();
	}
	// verify Holiday  Checker Page
	public void verifyHolidayCheckerPages() throws Exception {
		log.info("verify Holiday Checker Page...");
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);
        driver.switchTo().frame(0);
		log.info("verify Holiday Checker Page."+verifyHolidayCheckerPage.getText());
		String CheckerPage= verifyHolidayCheckerPage.getText();

		System.out.println("Get the Text of Checker Page..."+CheckerPage);
		Assert.assertEquals("HOLIDAY CHECKER", CheckerPage );
		log.info(" Suceessfully verified the Holiday Checker Page...");
	}
	// calling path variables and verifyAddcheckerList in purpose Checker page.
	// verify Add purpose  maker at checker List In Checker page()
public void verifyAddcheckerListInCheckerpage() throws InterruptedException {
	String CountryCode = "//table[@id='list']//tbody/tr/td[4]";
	String holiDayDate = "//table[@id='list']//tbody/tr/td[5]";
	String occasion	 = "//table[@id='list']//tbody/tr/td[6]";
	String IsActive = "//table[@id='list']//tbody/tr/td[7]";
	String HoliDay = "//table[@id='list']//tbody/tr/td[8]";
	String BankId = "//table[@id='list']//tbody/tr/td[9]";
	String RoutingNo = "//table[@id='list']//tbody/tr/td[10]";
	
	StoverifyCheckerlist(CountryCode, "BD");
	StoverifyCheckerlist(holiDayDate, "2020-05-18");
	StoverifyCheckerlist(occasion, "EFES");
	StoverifyCheckerlist(IsActive, "Y");
	StoverifyCheckerlist(HoliDay, "Monday");
	StoverifyCheckerlist(BankId, "010");
	StoverifyCheckerlist(RoutingNo, "010330799");
	
	
}
// Calling the Generic Method to verify the List in purpose Checker page.
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

		}

	}

}

// checkbox selecting 
   public  void multiplecheckbox() {
	//List<WebElement> checkbox;
	int noofCheckbox = checkbox.size();
  	System.out.println(noofCheckbox);
  	//checkbox.get(10).click();
	for (int i = 0; i < checkbox.size(); i++) {

		boolean selectcheckbox = checkbox.get(i).isSelected();
		System.out.println("checkbox is Not selected::" + selectcheckbox);
		//checkbox.get(10).click();
		if (true) {
			// for Selecting  particular Checkbox "Select"
			// Starts from 0  Even No gives the Select and Odd No  Reject.
			checkbox.get(2).click();
			// This is for Multi Select All 
			//checkbox .get(i).click();
			System.out.println(" Checkbox is selected===");

		} break;
	
	}
	
	
   }
   // Select All And Reject All 
public void selectHeadercheckbox() throws InterruptedException {
	int Headercheck=Headercheckbox.size();
	System.out.println("No of  Header checkbox ===>"+Headercheck);
	for(int i=0; i<Headercheckbox.size();i++) {
		Thread.sleep(3000);
		boolean SelectAll = Headercheckbox.get(i).isSelected();
		
		System.out.println(" Chheck header is selected Or Not==="+SelectAll);
		// if SelectAll==true then it will go to in If loop and select checkbox based on get i
		// if SelectAll==false then it will go to in If loop and select checkbox based on get i
		if ( SelectAll==true) {
			Headercheckbox.get(0).click();
			System.out.println("Select All Checkbox==>"+SelectAll);
			break;
		}
			
			  else { 
				  Headercheckbox.get(1).click();
			  System.out.println("Select Reject Checkbox==>"+SelectAll);
			  
			  }
			 
	}
	

}
// click on submit button And verify Succesfull Message on Checker  Page.
public void clickonsubmitbuttonOnCheckerPage() {
	
	// Click on Submit button Checker Page. To Select only one  Checkbox
			log.info(" click on Submit button on Checker Page===>>"+SubmitbuttononChecker.getText());
			SubmitbuttononChecker.click();
			
			
}
// to verify successful Message in Purpose CHECKER page
public void toverifysuccessfulMessageinCheckerPage() {
	
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		
		System.out.println("Get the Text of Succesfull Message After click on Submit button in Checker page..."+successfulMessageinChecker);
		log.info("successful Message in Checker===="+verifysuccessfulMessageinChecker.getText());
		//Assert.assertEquals(successfulMessageinChecker, "Record updated successfully.");
	if(verifysuccessfulMessageinChecker.getText().equals("Record updated successfully.")) {
		
		log.info(" Successfully  verified the Message in Checker page....");
	}
	else {
		
		log.info(" Not Successfully  verified the Message in Checker page....");
	}

}


//  to go to Maker page when Checker Approved Payment so click on Log out Button.
// calling p=7
  public void  gotoMakerPagewhenCheckerhasApprovedPaymentTypeMaker() throws InterruptedException {
	  driver.switchTo().defaultContent();
	  log.info("Click on Logout in checker Page"+Logoutinchecker.getText());
	  Logoutinchecker.click();

	 }
  //  View page in Maker , After Approved by the Checker data
public void  clickOnviewButtoninMakerPage() {
	log.info("click on view in Maker page==="+viewinMaker.getText());
	viewinMaker.click();
}

public void switchToNewWindow(int windowNumber) {
    Set < String > s = driver.getWindowHandles();   
    Iterator < String > ite = s.iterator();
    int i = 1;
    while (ite.hasNext() && i < 10) {
        String popupHandle = ite.next().toString();
        driver.switchTo().window(popupHandle);
        System.out.println("Window title is : "+driver.getTitle());
        System.out.println("Window Window is : "+driver.getWindowHandles());
        int windowCount = 0;
		if (i == windowCount) break;
        i++;
    
    }
    driver.manage().window().maximize();
    
}
// in view Page , search by different values passing into search box,
// refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
// 1. when the Verify the Maker View page when Currency has Approved by the Currency Checker
public void verifyViewpages(String searchfield,String searchfield1, String searchfield2  ) throws InterruptedException {
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
	
	Select entitieslist= new Select(selectentitieslist);
	Thread.sleep(4000);
	List<WebElement> Noofentitieslist = entitieslist.getOptions();
	int nooflist = Noofentitieslist.size();
	System.out.println("No of entities list====>>"+nooflist);
	entitieslist.selectByVisibleText("All");
	for(int i=0;i<nooflist;i++) {
		String entitiestext = Noofentitieslist .get(i).getText();
		System.out.println("Get entities text===>"+entitiestext);
	}
	 
	
}
// x-path of view page and calling their respective variable  and verify
public void  multippleSelectVerifyTextInViewPage() {
	
	String BankID= "//tbody[@role='alert']//tr//td[2]";
	String RoutingNo = "//tbody[@role='alert']//tr//td[3]";
	String BankName= "//tbody[@role='alert']//tr//td[4]";
	String BrancName = "//tbody[@role='alert']//tr//td[5]";
	String CountryCode = "//tbody[@role='alert']//tr//td[6]";
	String HolidayDate = "//tbody[@role='alert']//tr//td[7]";
	String Occasion = "//tbody[@role='alert']//tr//td[8]";
	String Holiday = "//tbody[@role='alert']//tr//td[9]";
	
	
	
	
	verifytheViewpageWithText(BankID, "010");
	verifytheViewpageWithText(RoutingNo, "010330436");
	verifytheViewpageWithText(BankName, "AGRANI BANK LTD");
	verifytheViewpageWithText(BrancName, "D.U.E.T.");
	verifytheViewpageWithText(CountryCode, "BD");
	verifytheViewpageWithText(HolidayDate, "2020-05-19");
	verifytheViewpageWithText(Occasion, "DHYY");
	verifytheViewpageWithText(Holiday, "Tuesday");
	
}
// 
// verify the View Maker Page with Text with thier respective Column
public static void verifytheViewpageWithText(String xpathvalue, String value) {
	List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
	int Nooflist = list1.size();
	System.out.println(" No of list====" + Nooflist);
	for (int i = 0; i < list1.size(); i++) {
		String listText = list1.get(i).getText();
		System.out.println(" Get Text of ====" + listText);
		if (list1.get(i).getText().equals(value)) {
			System.out.println("======Get Text of List Has Matched ======");
			break;
		} else {

			System.out.println("====Get Text of List Has Not  Matched ===");
		}
	}

}
// Select  All Drop down values in Maker view page when the Added Currency has Approved By Checker 
public void selectAllvaluesOneByOne() {
	// WebElement 
	WebElement selectBankId=driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
	WebElement selectRoutingNo=driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
	WebElement selectBankName=driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
	WebElement selectBranchName=driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
	WebElement selectCountryCode=driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));
	WebElement selectHolidayDate=driver.findElement(By.xpath("//tfoot//tr//th[7]//select"));
	WebElement selectOccasion=driver.findElement(By.xpath("//tfoot//tr//th[8]//select"));
	WebElement selectHoliDay=driver.findElement(By.xpath("//tfoot//tr//th[9]//select"));
	
		
	verifyBytheDropDownlistOneByOne(selectBankId, "010");
	verifyBytheDropDownlistOneByOne(selectRoutingNo, "010330436");
	verifyBytheDropDownlistOneByOne(selectBankName, "AGRANI BANK LTD.");
	verifyBytheDropDownlistOneByOne(selectBranchName, "D.U.E.T.");
	verifyBytheDropDownlistOneByOne(selectCountryCode, "BD");
	verifyBytheDropDownlistOneByOne(selectHolidayDate, "2020-05-19");
	verifyBytheDropDownlistOneByOne(selectOccasion, "DHYY");
	verifyBytheDropDownlistOneByOne(selectHoliDay, "Tuesday");
	
	
	
}
//
// select one by one of Select in View page of Maker
public static void verifyBytheDropDownlistOneByOne(WebElement aa, String value) {
	
	Select sel= new Select(aa);
	List<WebElement> N = sel.getOptions();
	int Nooflist = N.size();
	System.out.println(" No of WebElements On Select Drop Down ====" + Nooflist);
	for (int i = 0; i <  N .size(); i++) {
		String listText =  N .get(i).getText();
		System.out.println(" Get Text From Select Drop Down ====" + listText);
		if ( N .get(i).getText().equals(value)) {
			System.out.println("======List of Values Matched  From Select Drop Down  ======");
			 sel.selectByVisibleText(value);
			break;
		} else {

			System.out.println("==== List Of values Not matched  From Select Drop Down ====");
			
		}
	}

}
// switch one  Child window to parent window
public void  switchToWindowByUsingIterator() throws Exception   {
	
	Dimension d = new Dimension(800,480);
	driver.manage().window().setSize(d);
	driver.getTitle();
	System.out.println("get tittle of the Page===>"+driver.getTitle());
	//System.out.println("get PageSourceof the Page===>"+driver.getPageSource());
	System.out.println("get CurrentUrlof the Page===>"+driver.getCurrentUrl());
	driver.manage().getCookieNamed("name");
	//driver.navigate().refresh();
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
	 
	 String parent_handle= driver.getWindowHandle();
	 System.out.println(parent_handle);
	// driver.findElement(By.name("New Message Window")).click();
	 new WebDriverWait(driver,10).until(ExpectedConditions.numberOfWindowsToBe(2));
	 Set<String> handles = driver.getWindowHandles();
	 System.out.println(handles);
	 for(String handle1:handles)
	     if(!parent_handle.equals(handle1))
	     {
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
		log.info("click on Modify Button==>"+ModifyButton.getText());
		ModifyButton.click();

		log.info(" Get the Text of Modify Purpose Maker Ppage===>>"+verifyModifyPurposeMakerPage.getText());
		log.info(" verify the Modify  Purpose Maker Ppage...");
		Assert.assertEquals(verifyModifyPurposeMakerPage.getText(), "MODIFY PURPOSE MAKER");
		log.info(" Successfully verified the Modify  Purpose  Maker Ppage...");
	
 }
 // select Purpose Code In Modify purpose Maker Page
 public void selectPurposeCodeInModifyPurposeMakerPage() {
	 driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
 Select selectPurposeCode= new Select(selectpurposeCodeInModifyPage);
List<WebElement> AllPurposeCode = selectPurposeCode.getOptions();
int noofPurposeCodedOnDropDown=AllPurposeCode .size();
System.out.println("Get the No of Purpose code On DropDown==>>"+noofPurposeCodedOnDropDown);

for(int i=0; i<AllPurposeCode .size(); i++) {
	String GetTextOfAllDropDownValues = AllPurposeCode.get(i).getText();
	System.out.println("Get Text Of All DropDown Values==>"+GetTextOfAllDropDownValues);
	
	if(AllPurposeCode.get(i).getText().equals("BD-testpu-purposedesc wagev d")) {
		log.info(" ====Matched the Given Data=====");
		
		selectPurposeCode.selectByVisibleText("BD-testpu-purposedesc wagev d");
		System.out.println(" ==== Purpose Code Matched the From Payment Code Drop Down In MODIFY Purpose MAKER page=====>>");
		break;
		}
	else {
	
		System.out.println(" ==== Purpose Code not  Matched the From Purpose Code Drop Down In MODIFY Purpose MAKER page=====>>");
		}}
}
 // submit button on Modify maker page
 public void clickOnsubmitbutton() {
	 log.info("Click on submitbutton"+submitbuttonModifyMaker.getText());
	 submitbuttonModifyMaker.click();
	 
 }
 // click on modify submit button in Modify maker page
 public void clickmodifysubmitbutton() {
	// driver.switchTo().defaultContent();
	 log.info(" click on modify submit button==>"+modifysubmitbutton.getText());
	 modifysubmitbutton.click();
	 }
 // verification Message In Modify Payment Type Page
 public void verificationMessageInModifyPaymentTypePage() throws Exception {
	 log.info("Get the Text Of Verification Message In Modify Payment Type Page==>>"+verificationMessageInModifyPaymentType.getText());
	 //Assert.assertEquals(verificationMessageInModifyEntityType.getText(), "Record has been modified successfully.");
	 
	// verification Message In Modify Payment Type Page
	 String verifythemodify = verificationMessageInModifyPaymentType.getText();
		System.out.println("Get the Text Of Verification Message In Modify Payment Type Page==>>" + verifythemodify);
		if (verifythemodify.equals("Record has been modified successfully.")) {
			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			log.info("==Successfull Message has Matched with  Text==");
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
		} else if (verifythemodify.equals("This Mandate Type name has already used.")) {
			log.info("This Country Code has already used");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
		} else if (verifythemodify.equals("===Not==")) {
			log.info("This is Not Matched");

		}
		else {
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			log.info("==Successfull Message has Matched with  Text==");
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
		}
 
 }
 // verify the Payment Type checker List IF Modification has Done By Maker with Existing Entity
 // 
 public void verifyListonCheckerpageWhenModificationhasDoneByMaker() throws InterruptedException {
	    String CountryCode = "//table[@id='list']//tbody/tr/td[4]";
		String PurposeCode = "//table[@id='list']//tbody/tr/td[5]";
		String purposeDesc	 = "//table[@id='list']//tbody/tr/td[6]";
		String PurposeType = "//table[@id='list']//tbody/tr/td[7]";
		String IsActive = "//table[@id='list']//tbody/tr/td[8]";
		
		
		
		toverifyCheckerlistWhenModifiedMaker(CountryCode, "BD");
		toverifyCheckerlistWhenModifiedMaker(PurposeCode , "C");
		toverifyCheckerlistWhenModifiedMaker(purposeDesc, "E");
		toverifyCheckerlistWhenModifiedMaker(PurposeType, "Wage");
		toverifyCheckerlistWhenModifiedMaker(IsActive, "Y");
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
	// Select and DeSelect the  by using iterator  We can use this Method Also
	// We  can use this Method Carefully.
  public void SelectAndDeSelectMutilpeCheckboxoneByOneInChecker() throws InterruptedException {
	  
		// Select checkbox one by one in AllSelect
		List<WebElement> FirstAllCheckbox = driver.findElements(By.xpath("//table[@id='list']//tbody/tr/td[1]"));
		ListIterator<WebElement> it = FirstAllCheckbox.listIterator();
		while (it.hasNext()) {
			it.next().click();
			Thread.sleep(2000);
			//break;
		}
		
//  Select checkbox one by one in RejectAll
		List<WebElement> SecondAllCheckbox = driver.findElements(By.xpath("//table[@id='list']//tbody/tr/td[2]"));
		ListIterator<WebElement> it2 = SecondAllCheckbox.listIterator();
		while (it2.hasNext()) {
			it2.next().click();
			Thread.sleep(2000);
			//break;

		}

		
	//  Select checkbox of header in SelectAll&RejectAll in Country checker
		//
		Thread.sleep(5000);
		List<WebElement> headerCheckbox = driver.findElements(By.xpath("//th//input[@type='checkbox']"));
		ListIterator<WebElement> it3 = headerCheckbox.listIterator();
		while (it3.hasNext()) {
			it3.next().click();
			Thread.sleep(2000);
			//break;
		}
		 // Deselect the Header of  "RejectAll"
		Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();
	}
  
//checkbox selecting  After ModifytheCountry 
  public  void multiplecheckboxwhenModifytheCountry() {
	//List<WebElement> checkbox;
	int noofCheckbox = checkbox.size();
 	System.out.println(noofCheckbox);
 	//checkbox.get(10).click();
	for (int i = 0; i < checkbox.size(); i++) {

		boolean selectcheckbox = checkbox.get(i).isSelected();
		System.out.println("checkbox is Not selected::" + selectcheckbox);
		//checkbox.get(10).click();
		if (true) {
			// for Selecting  particular Checkbox "Select"
			// Starts from 0  Even No gives the Select and Odd No  Reject.
			//checkbox.get(4).click();
			checkbox.get(2).click();
			// This is for Multi Select All 
			//checkbox .get(i).click();
			System.out.println(" Checkbox is selected===");

		} break;
	
	}
	
	
  }
  // 
  // click on submit button And verify Succesfull Message If Modifythe Country
  public void clickonsubmitbuttonAndverifySuccesfullMessageIfModifytheCountry() {
		
		// Click on Submit button Checker Page. To Select only one  Checkbox
				log.info(" click on Submit button on Checker===>>"+SubmitbuttononChecker.getText());
				SubmitbuttononChecker.click();
			String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
			log.info("successful Message in Checker===="+verifysuccessfulMessageinChecker.getText());
			Assert.assertEquals(successfulMessageinChecker, "Record updated successfully.");
		
			if(verifysuccessfulMessageinChecker.getText().equals("Record updated successfully.")) {
				
				
			
			}
             else if(verifysuccessfulMessageinChecker.getText().equals("")) {
				
			}
  
  }
  
//in view Page , search by different values passing into search box,
//refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
  //2. when the Adding the Holiday then verify "View" page Checker 
public void verifyViewpagesOfCheckeerWhenApprovedDoneByHolidayChecker(String searchfield,String searchfield1, String searchfield2  ) throws InterruptedException {
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
	
	Select entitieslist= new Select(selectentitieslist);
	Thread.sleep(4000);
	List<WebElement> Noofentitieslist = entitieslist.getOptions();
	int nooflist = Noofentitieslist.size();
	System.out.println("No of entities list====>>"+nooflist);
	entitieslist.selectByVisibleText("All");
	for(int i=0;i<nooflist;i++) {
		String entitiestext = Noofentitieslist .get(i).getText();
		System.out.println("Get entities text===>"+entitiestext);
	}
	 
	
}
//to Verify Column Text In View Page WithHeader Column
//x-path of view page and calling their respective variable  and verify
public void  toVerifyByTextInViewCheckerPagewhenAddedMaker() {
	
	String BankID= "//tbody[@role='alert']//tr//td[2]";
	String RoutingNo = "//tbody[@role='alert']//tr//td[3]";
	String BankName= "//tbody[@role='alert']//tr//td[4]";
	String BrancName = "//tbody[@role='alert']//tr//td[5]";
	String CountryCode = "//tbody[@role='alert']//tr//td[6]";
	String HolidayDate = "//tbody[@role='alert']//tr//td[7]";
	String Occasion = "//tbody[@role='alert']//tr//td[8]";
	String Holiday = "//tbody[@role='alert']//tr//td[9]";
	
	
	
	
	verifyTheCheckerViewPageWhenHolidayMakerAdded(BankID, "010");
	verifyTheCheckerViewPageWhenHolidayMakerAdded(RoutingNo, "010330436");
	verifyTheCheckerViewPageWhenHolidayMakerAdded(BankName, "AGRANI BANK LTD");
	verifyTheCheckerViewPageWhenHolidayMakerAdded(BrancName, "D.U.E.T.");
	verifyTheCheckerViewPageWhenHolidayMakerAdded(CountryCode, "BD");
	verifyTheCheckerViewPageWhenHolidayMakerAdded(HolidayDate, "2020-05-19");
	verifyTheCheckerViewPageWhenHolidayMakerAdded(Occasion, "DHYY");
	verifyTheCheckerViewPageWhenHolidayMakerAdded(Holiday, "Tuesday");
	
	
	
}
// 
// verify the View Maker Page with Text with thier respective Column
public static void verifyTheCheckerViewPageWhenHolidayMakerAdded(String xpathvalue, String value) {
	List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
	int Nooflist = list1.size();
	System.out.println(" No of list====" + Nooflist);
	for (int i = 0; i < list1.size(); i++) {
		String listText = list1.get(i).getText();
		System.out.println(" Get Text of ====" + listText);
		if (list1.get(i).getText().equals(value)) {
			System.out.println("======List of Text Values matched ======");
			break;
		} else {

			System.out.println("==== List of Text Values Not  matched ===");
		}
	}

}
// To verify  By  All Select Filter Or To Verify the Modify Data in Maker View Page By Using Drop Down
// select All values One By One
//  5 drop down are available on the 
public void toVerifytheCheckerViewPagWhenAddedMakerHasApprovedByUsingDropDown() {
	// WebElement 
		WebElement selectBankId=driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectRoutingNo=driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectBankName=driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectBranchName=driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement selectCountryCode=driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));
		WebElement selectHolidayDate=driver.findElement(By.xpath("//tfoot//tr//th[7]//select"));
		WebElement selectOccasion=driver.findElement(By.xpath("//tfoot//tr//th[8]//select"));
		WebElement selectHoliDay=driver.findElement(By.xpath("//tfoot//tr//th[9]//select"));
		
			
		verifyBySelectDropDonInViewCheckerPageWhenAddedMaker(selectBankId, "010");
		verifyBySelectDropDonInViewCheckerPageWhenAddedMaker(selectRoutingNo, "010330436");
		verifyBySelectDropDonInViewCheckerPageWhenAddedMaker(selectBankName, "AGRANI BANK LTD.");
		verifyBySelectDropDonInViewCheckerPageWhenAddedMaker(selectBranchName, "D.U.E.T.");
		verifyBySelectDropDonInViewCheckerPageWhenAddedMaker(selectCountryCode, "BD");
		verifyBySelectDropDonInViewCheckerPageWhenAddedMaker(selectHolidayDate, "2020-05-19");
		verifyBySelectDropDonInViewCheckerPageWhenAddedMaker(selectOccasion, "DHYY");
		verifyBySelectDropDonInViewCheckerPageWhenAddedMaker(selectHoliDay, "Tuesday");
}
//
// select one by one of Select in View page of Maker
// 4 drop down using one by one select the values from drop down
public static void verifyBySelectDropDonInViewCheckerPageWhenAddedMaker(WebElement aa, String value) {
	
	Select sel= new Select(aa);
	List<WebElement> N = sel.getOptions();
	int Nooflist = N.size();
	System.out.println(" No of list on ====" + Nooflist);
	for (int i = 0; i <  N .size(); i++) {
		String listText =  N .get(i).getText();
		System.out.println(" Get Text of ====" + listText);
		if ( N .get(i).getText().equals(value)) {
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
	 String parent_handle= driver.getWindowHandle();
	 System.out.println(parent_handle);
	
	// driver.findElement(By.name("New Message Window")).click();
	 new WebDriverWait(driver,10).until(ExpectedConditions.numberOfWindowsToBe(3));
	 Set<String> handles = driver.getWindowHandles();
	 System.out.println(handles);
	 for(String handle1:handles)
	     if(!parent_handle.equals(handle1))
	     {
	         driver.switchTo().window(parent_handle);
	         System.out.println(handle1);
	     }
 Thread.sleep(5000);
	 
	 driver.switchTo().defaultContent();
	 driver.findElement(By.xpath("//a[text()='Logout']")).click();
//		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
//		System.out.println(iframeElements);
//
//		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
		log.info("click on Modify Button==>"+ModifyButton.getText());
		ModifyButton.click();

		log.info(" Get the Text of Modify Entity Type Maker Ppage===>>"+verifyModifyPurposeMakerPage.getText());
		log.info(" verify the Modify  Entity Type Maker Ppage...");
		Assert.assertEquals(verifyModifyPurposeMakerPage.getText(), "MODIFY PAYMENT TYPE MAKER");
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
			//String newwin1 = it1.next();
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
	log.info("click on view Button In Checker Page"+viewInChecker.getText());
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
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement Category_Body = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//td[@class='mainmenu']//following-sibling::a[text()='Logout']")));
		System.out.println(Category_Body);

		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	  
	  
  }
}
