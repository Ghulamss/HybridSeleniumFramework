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
public class AddPaymentTypeMaker {
	static WebDriver driver;

	private final Logger log = LoggerHelper.getLogger(AddPaymentTypeMaker.class);
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
	@FindBy(xpath = "//*[contains(text(),'Add Payment Type Make')]//parent::a")
	WebElement AddPaymentTypeMaker;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;
	@FindBy(xpath = "//input[@name='mandateCode']")
	WebElement mandateCode;
	@FindBy(xpath = "//input[@name='mandateId']")
	WebElement filePaymentID;
	
	@FindBy(xpath = "//input[@id='mandateDesc']")
	WebElement paymentDesc;
	@FindBy(xpath = "//input[@id='currency']")
	WebElement currency;
	@FindBy(xpath = "//select[@id='isActive']")
	WebElement isActivePaymentMaker;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
// Statrted  Checker X-path
	
	@FindBy(xpath = "//*[text()='Master Definition Checker']")
	WebElement MasterDefinitionChecker;
	@FindBy(xpath = "//*[text()='Authoriser Payment Type']")
	WebElement AuthoriserPaymentType;
	@FindBy(xpath = "//td[contains(text(),' Payment Type Checker')]")
	WebElement verifyPaymentTypeCheckerPage;
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
	
	@FindBy(xpath ="//select[@name='list_length']")
	WebElement selectentitieslist;
	@FindBy(xpath ="//select[@name='list_length']")
	WebElement logoutInMaker;
// Modify Page in Maker
	@FindBy(xpath ="//input[@value='Modify']")
	WebElement ModifyButton;
	
	@FindBy(xpath ="//td[text()='Modify Payment Type Maker']")
	WebElement verifyModifyPaymentTypeMakerPage;
	
	@FindBy(xpath ="//select[@name='mandateCode']")
	WebElement selectPaymentCodeInModifyPage;
	@FindBy(name="Submit")
	WebElement submitbuttonModifyMaker;
	//form[@name='modifyCountry']//table//tr[15]//td//input[@name='Submit']
	
	@FindBy(xpath="//form[@name='modifyStatus']//table//tr[2]//td//input[@name='Submit']")
	WebElement modifysubmitbutton;
	@FindBy(xpath="//td[@class='note']")
	WebElement verificationMessageInModifyPaymentType;
	
	@FindBy(xpath="//b[text()='Logout']")
	WebElement logoutMaker;
	
	
	// View Page in Checker
	// 
	@FindBy(xpath="//input[@id='view']")
	WebElement viewInChecker;
	
	public AddPaymentTypeMaker(WebDriver driver) {
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

// click on Add Payment Type Maker SubMenu
	public void clickonAddPaymentTypeMakerSubMenu() {
		log.info("click on Add Payment Type Maker SubMenu===>" + AddPaymentTypeMaker.getText());
		AddPaymentTypeMaker.click();
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

	static String getmandateCode;
	static String getfilePaymentID;
	static String getpaymentDesc;
	static String getIsActivePayment;
// enter mandate Code or Payment code in ADD PAYMENT TYPE MAKER page
	public void enterPaymentCode(String mandateCode) {
		log.info("Enter payment Code ===>" + mandateCode);
		this.mandateCode.sendKeys(mandateCode);
		getmandateCode = mandateCode.toString();
		System.out.println("get mandate Code value==>>>" + getmandateCode);

	}
	//enter file Payment ID in Add Payment Type Maker page
	public  void enterfilePaymentID(String filePaymentID) {
		log.info("enter file Payment ID .."+filePaymentID);
		this.filePaymentID.sendKeys(filePaymentID);
		getfilePaymentID = filePaymentID.toString();
		System.out.println("get file Payment ID value==>>>" + getfilePaymentID);
		
	}
// enter payment Desc in Add Payment Type Maker page
	public void enterpaymentDesc(String paymentDesc) {
		log.info("enter payment Desc ...." + paymentDesc);
		this.paymentDesc.sendKeys(paymentDesc);
		getpaymentDesc = paymentDesc.toString();
		System.out.println("get payment Desc value==>>>" + getpaymentDesc);
	}

// select  is Active Payment ? in Payment Maker page
	public void selectisActivePayment() {
		String s = "Yes";
		log.info("select is isActive Payment Maker ?==>" + isActivePaymentMaker);
		Select aa = new Select(isActivePaymentMaker);
		aa.selectByVisibleText(s);
		String getisActive = s.toString();
		System.out.println("get Is Active Payment Maker ===>>" + getisActive);
		String[] spl = getisActive.split("es");
		System.out.println("Split Array Values of Yes ===>>" + spl);
		List<String> splitList1 = Arrays.asList(spl);
		getIsActivePayment = String.join("", splitList1);
		System.out.println("get Is Active Payment after Split (es) As Yes=>>>" + getIsActivePayment);
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
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		}
	}
// click on Master Definition Checker
	public void clickonMasterDefinitionChecker() {
		log.info(" Get text Master Definition Checker"+MasterDefinitionChecker.getText());
		log.info("Clcik on MasterDefinitionChecker====");
		MasterDefinitionChecker.click();
		
	}
	// click OnAuthorrized Payment Type checker SubMenu
	public void clickOnAuthoriserPaymentTypeSubMenu() {
		log.info("click On Authorrized Payment Type Checker SubMenu..."+AuthoriserPaymentType.getText());
		AuthoriserPaymentType.click();
	}
	// verify Payment  Type Checker Page
	public void verifyPaymentTypeCheckerPages() throws Exception {
		log.info("verify PAYMENT TYPE CHECKER Page...");
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		
		log.info("verify Payment Type Checker Page.."+verifyPaymentTypeCheckerPage.getText());
		String paymentCheckerPage= verifyPaymentTypeCheckerPage.getText();

		System.out.println("Get the Text of verify Entity Type Checker Page..."+paymentCheckerPage);
		Assert.assertEquals("PAYMENT TYPE CHECKER", paymentCheckerPage );
		log.info("verified Payment Type Checker Page Suceessfully...");
	}
	// calling path variables and verifyAddcheckerList in Add Payment Type Checker page.
	// 
public void verifyAddcheckerListInPaymentTypeCheckerpage()throws InterruptedException {
	String paymentcode = "//table[@id='list']//tbody/tr/td[4]";
	String paymentId = "//table[@id='list']//tbody/tr/td[5]";
	String paymentDesc = "//table[@id='list']//tbody/tr/td[6]";
	String IsActive = "//table[@id='list']//tbody/tr/td[7]";
	
	toverifyCheckerlist(paymentcode, getmandateCode);
	toverifyCheckerlist(paymentId, getfilePaymentID);
	toverifyCheckerlist(paymentDesc, getpaymentDesc);
	toverifyCheckerlist(IsActive, getIsActivePayment);
	
}
// Calling the Generic Method to verify the List in Currency Checker page.
private void toverifyCheckerlist(String xpathvalue, String value) throws InterruptedException {

	// TODO Auto-generated method stub
	List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
	int Nooflist = list1.size();
	System.out.println(" No of list====" + Nooflist);
	for (int i = 0; i < list1.size(); i++) {
		String listText = list1.get(i).getText();
		System.out.println(" Get Text of  Checker list====>" + listText);
		if (list1.get(i).getText().equals(value)) {
			System.out.println("List has matched  With Value==>"+listText);
			// driver.findElement(By.xpath("//input[@id='selectAll']")).click();

			break;
		} else {

			System.out.println("List Not  matched  With Value==>"+listText);
			// driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();

		}

	}

}
public void HandleTheDynamicVluesWithCheckbox()throws Exception {
	List<WebElement> web = driver.findElements(By.xpath("//table[@id='list']//tbody/tr/td[4]"));
	int sizeOfColumn = web.size();
	System.out.println("size Of Column===>>" + sizeOfColumn);
	for (int i = 0; i < web.size(); i++) {
		String name = web.get(i).getText();
		System.out.println("Get Name===>>" + name);
		if (name.contains(getmandateCode)) {
			System.out.println("Text has Mtched with value==>"+name);
			Thread.sleep(3000);
			driver.findElements(By.xpath(
					"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
					.get(i).click();
			log.info("Click On Check Box======");
		

		} else {
			System.out.println("Text has  Not Mtched with value==>"+name);
		}
	}

}

// click on submit button And verify Succesfull Message on Checker  Page.
public void clickonsubmitbuttonInPaymentTYPECHECKERPage() {
	
	// Click on Submit button Checker Page. To Select only one  Checkbox
			log.info(" click on Submit button on Payment Type Checker Page===>>"+SubmitbuttononChecker.getText());
			SubmitbuttononChecker.click();
			
			
}
// to verify successful Message in Payment TYPE CHECKER page
public void toverifysuccessfulMessageinPaymentTypeCheckerPage() {
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		
		System.out.println("Get the Text of Succesfull Message After click on Submit button In Payment Type Checker page..."+successfulMessageinChecker);
		log.info("successful Message in Checker===="+verifysuccessfulMessageinChecker.getText());
		//Assert.assertEquals(successfulMessageinChecker, "Record updated successfully.");
	if(verifysuccessfulMessageinChecker.getText().equals("Record updated successfully.")) {
		
		log.info(" Successfully  verified the Message in payment Type Checker..  ");
	}
	else {
		
		log.info(" Not Successfully  verified the Message in payment Type Checker..  ");
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
public void verifyViewpageBySearchField() throws InterruptedException {
	this.searchfield.clear();
	log.info("Searh By mandate Code ==>"+getmandateCode);
	this.searchfield.sendKeys(getmandateCode);
	this.searchfield.clear();
	log.info("Search By file Payment ID ==>"+getfilePaymentID);
	this.searchfield.sendKeys(getfilePaymentID);
	Thread.sleep(4000);
	this.searchfield.clear();
	log.info("Search By payment Desc==>"+getpaymentDesc);
	this.searchfield.sendKeys(getpaymentDesc);
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
	
	String PaymentCode= "//tbody[@role='alert']//tr//td[2]";
	String PaymentId = "//tbody[@role='alert']//tr//td[3]";
	String PaymentDescription= "//tbody[@role='alert']//tr//td[4]";
	String ISActive = "//tbody[@role='alert']//tr//td[5]";
	
	verifytheViewpageWithText(PaymentCode, getmandateCode);
	verifytheViewpageWithText(PaymentId, getfilePaymentID);
	verifytheViewpageWithText(PaymentDescription, getpaymentDesc);
	verifytheViewpageWithText(ISActive, getIsActivePayment);
	
}
// verify the View Maker Page with Text with thier respective Column
public static void verifytheViewpageWithText(String xpathvalue, String value) {
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
		}}}
// Select  All Drop down values in Maker view page when the Added Currency has Approved By Checker 
public void selectAllvaluesOneByOneFromDropDown() {
	// WebElement 
	WebElement selectPaymentCode=driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
	WebElement selectPaymentId=driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
	WebElement selectPaymentDescription=driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
	WebElement selectISActive=driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
	
		
	verifyBytheDropDownlistOneByOne(selectPaymentCode, getmandateCode);
	verifyBytheDropDownlistOneByOne(selectPaymentId, getfilePaymentID);
	verifyBytheDropDownlistOneByOne(selectPaymentDescription, getpaymentDesc);
	verifyBytheDropDownlistOneByOne(selectISActive, getIsActivePayment);
	}
// select one by one of Select in View page of Maker
public static void verifyBytheDropDownlistOneByOne(WebElement aa, String value) {
	
	Select sel= new Select(aa);
	List<WebElement> N = sel.getOptions();
	int Nooflist = N.size();
	System.out.println(" No of list====" + Nooflist);
	for (int i = 0; i <  N .size(); i++) {
		String listText =  N .get(i).getText();
		System.out.println(" Get Text of ====" + listText);
		if ( N .get(i).getText().equals(value)) {
			System.out.println("List matched with value==>"+listText);
			 sel.selectByVisibleText(value);
			break;
		} else {

			System.out.println("==== List Not  matched  with==>"+listText);
			
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

		log.info(" Get the Text of Modify Payment Type Maker Ppage===>>"+verifyModifyPaymentTypeMakerPage.getText());
		log.info(" verify the Modify  Entity Type Maker Ppage...");
		Assert.assertEquals(verifyModifyPaymentTypeMakerPage.getText(), "MODIFY PAYMENT TYPE MAKER");
		log.info(" Successfully verified the Modify  Payment Type Maker Ppage...");
	
 }
 // select Payment Code In Modify Payment Type Maker Page
 public void selectPaymentCodeInModifyPaymentTypeMakerPage() {
	 driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
 Select selectPaymentCode= new Select(selectPaymentCodeInModifyPage);
List<WebElement> AllPaymentCode = selectPaymentCode.getOptions();
int noofPaymentCodedOnDropDown=AllPaymentCode .size();
System.out.println("Get the No of Payment code On DropDown==>>"+noofPaymentCodedOnDropDown);

for(int i=0; i<AllPaymentCode .size(); i++) {
	String GetTextOfAllDropDownValues = AllPaymentCode.get(i).getText();
	System.out.println("Get Text Of All DropDown Values==>"+GetTextOfAllDropDownValues);
	
	if(AllPaymentCode.get(i).getText().equals("NEFT - NEFT")) {
		log.info(" ====Matched the Given Data=====");
		
		selectPaymentCode.selectByVisibleText("NEFT - NEFT");
		System.out.println(" ==== Payment Code Matched the From Payment Code Drop Down In MODIFY Payment TYPE MAKER page=====>>");
		break;
		}
	else {
	
		System.out.println(" ==== Payment Code not  Matched the From Payment Code Drop Down In MODIFY Payment TYPE MAKER page=====>>");
		}
	}
}
 // select Payment Code In Modify page
 public void selectPaymentCodeInModifyMakerPageByUsingSplitAsPerAddingValue() {

		driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());

		String selectmandateCode = "//select[@name='mandateCode']//option";
		// here is Bug because mandateCode is not coming on Second value at the split value , should be come on Mandate code after spliting.
        // getfilePaymentID ,getmandateCode
		selectDropDownInModifyMakerPageByUsingIndex(selectmandateCode, getfilePaymentID);

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
				System.out.println("Text has Selected with value===>>"+splivalues);
				break;

			} else {
				System.out.println("Text has NOT  Matched with value===>>"+splivalues);
			}
		}
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
			log.info("click on the Log Out button");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("This Mandate Type name has already used.")) {
			log.info("This Payment Code has already used.==>"+verifythemodify);
			driver.switchTo().defaultContent();
			log.info("click on the Log Out button");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		}
		else {
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			log.info("==Successfull Message has Not Matched with  Text==>"+verifythemodify);
			log.info("click on the Log Out button");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		}
 
 }
 // verify the Payment Type checker List IF Modification has Done By Maker with Existing Entity
 // 
 public void verifyListOfPaymentTypeIncheckerWhenModificationhasDoneByMaker() throws InterruptedException {
	    String paymentcode = "//table[@id='list']//tbody/tr/td[4]";
		String paymentId = "//table[@id='list']//tbody/tr/td[5]";
		String paymentDesc = "//table[@id='list']//tbody/tr/td[6]";
		String IsActive = "//table[@id='list']//tbody/tr/td[7]";
		
		toverifyCheckerlistWhenModifiedMaker(paymentcode, getmandateCode);
		toverifyCheckerlistWhenModifiedMaker(paymentId , getfilePaymentID);
		toverifyCheckerlistWhenModifiedMaker(paymentDesc, getpaymentDesc);
		toverifyCheckerlistWhenModifiedMaker(IsActive, getIsActivePayment);
		
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
				System.out.println("Get Text of  Checker list has Matched with==>"+listText);
				// driver.findElement(By.xpath("//input[@id='selectAll']")).click();

				break;
			} else {

				System.out.println("Get Text of  Checker list has Not  Matched with==>"+listText);
				// driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();

			}

		}

	}
	
	
	public void selectThecheckboxOnCheckerPageWhenModifyMakerDaata() {
		// payment cod  Or Mandate Code are same
		  String paymentCode="//table[@id='list']//tbody/tr/td[4]";
		  selectThecheckboxOnCheckerPageWhenModify(paymentCode,getmandateCode);
	}
	
	public void selectThecheckboxOnCheckerPageWhenModify(String xpathvalue,String value) {

		List<WebElement> web = driver.findElements(By.xpath(xpathvalue));
		int sizeOfColumn = web.size();
		System.out.println("size Of list===>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get the Text on checker Page==>>" + name);
			if (name.contains(value)) {
				System.out.println("Get Text has Mtched with value==>"+name);
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				
				break;
			} else {
				System.out.println("Get Text has  Not Mtched with values==>"+name);
			}
		}

	}

//in view Page , search by different values passing into search box,
//refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
// when the Modified the Currency then "View" page Maker 
public void verifyViewpageBySearchFieldWhenModifyAndApprovedDoneByChecker() throws InterruptedException {
	this.searchfield.clear();
	log.info("Searh By mandate Code ==>"+getmandateCode);
	this.searchfield.sendKeys(getmandateCode);
	this.searchfield.clear();
	log.info("Search By file Payment ID ==>"+getfilePaymentID);
	this.searchfield.sendKeys(getfilePaymentID);
	Thread.sleep(4000);
	this.searchfield.clear();
	log.info("Search By payment Desc==>"+getpaymentDesc);
	this.searchfield.sendKeys(getpaymentDesc);
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
public void  toVerifyTextInViewMakerPagewhenModified(){
	
	String PaymentCode= "//tbody[@role='alert']//tr//td[2]";
	String PaymentId = "//tbody[@role='alert']//tr//td[3]";
	String PaymentDescription= "//tbody[@role='alert']//tr//td[4]";
	String ISActive = "//tbody[@role='alert']//tr//td[5]";
	
	verifyTheMakerViewPageWhenModified(PaymentCode, getmandateCode);
	verifyTheMakerViewPageWhenModified(PaymentId, getfilePaymentID);
	verifyTheMakerViewPageWhenModified(PaymentDescription, getpaymentDesc);
	verifyTheMakerViewPageWhenModified(ISActive, getIsActivePayment);
	
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
	WebElement selectPaymentCode=driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
	WebElement selectPaymentId=driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
	WebElement selectPaymentDescription=driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
	WebElement selectISActive=driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
	
		
	verifySelectDropDonInViewMakerPageWhenModified(selectPaymentCode, getmandateCode);
	verifySelectDropDonInViewMakerPageWhenModified(selectPaymentId, getfilePaymentID);
	verifySelectDropDonInViewMakerPageWhenModified(selectPaymentDescription, getpaymentDesc);
	verifySelectDropDonInViewMakerPageWhenModified(selectISActive, getIsActivePayment);
		
}
// select one by one of Select in View page of Maker
// 4 drop down using one by one select the values from drop down
public static void verifySelectDropDonInViewMakerPageWhenModified(WebElement aa, String value) {
	
	Select sel= new Select(aa);
	List<WebElement> N = sel.getOptions();
	int Nooflist = N.size();
	System.out.println(" No of list====" + Nooflist);
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
	 driver.findElement(By.xpath("//b[text()='Logout']")).click();
//		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
//		System.out.println(iframeElements);
//
//		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
		log.info("click on Modify Button==>"+ModifyButton.getText());
		ModifyButton.click();

		log.info(" Get the Text of Modify Entity Type Maker Ppage===>>"+verifyModifyPaymentTypeMakerPage.getText());
		log.info(" verify the Modify  Entity Type Maker Ppage...");
		Assert.assertEquals(verifyModifyPaymentTypeMakerPage.getText(), "MODIFY PAYMENT TYPE MAKER");
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
		
		 // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//td[text()=' Country Checker']")));
		 
		String Header = driver.findElement(By.xpath("//td[contains(text(),' Payment Type Checker')]")).getText();

		System.out.println(Header);
		Assert.assertEquals("PAYMENT TYPE CHECKER", Header );
		

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().defaultContent();
	
driver.findElement(By.xpath("//b[text()='Logout']")).click();
	
	  
	  
  }
}
