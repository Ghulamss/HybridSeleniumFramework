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
public class AddPaymentRoutingMaker {
	static WebDriver driver;

	private final Logger log = LoggerHelper.getLogger(AddPaymentRoutingMaker.class);
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
	@FindBy(xpath = "//*[contains(text(),'Add Payment Routing Maker')]//parent::a")
	WebElement AddPaymentRoutingMaker;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;
	@FindBy(xpath = "//select[@id='mandateCodeRouted']")
	WebElement selectmandateCodeRouted;
	
	@FindBy(xpath = "//input[@name='amountFrom']")
	WebElement amountFromTextfield;
	@FindBy(xpath = "//input[@name='amountTo']")
	WebElement amountToTextfield;
	

	@FindBy(xpath = "//select[@id='isActive']")
	WebElement isActiveStatus;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
// Statrted  Checker X-path
	
	@FindBy(xpath = "//*[text()='Master Definition Checker']")
	WebElement MasterDefinitionChecker;
	@FindBy(xpath = "//*[text()='Payment Routing Checker']")
	WebElement PaymentRoutingChecker;
	@FindBy(xpath = "//td[contains(text(),'Payment Routing Checker')]")
	WebElement verifyPaymentRoutingCheckerPage;
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
	
	@FindBy(xpath ="//td[text()='Modify Payment Routing Maker']")
	WebElement verifyModifyPaymentRoutingMakerPage;
	
	@FindBy(xpath ="//select[@name='modifyMandateCode']")
	WebElement selectmodifyMandateCodeInModifyPage;
	@FindBy(name="Submit")
	WebElement submitbuttonModifyMaker;
	//form[@name='modifyCountry']//table//tr[15]//td//input[@name='Submit']
	
	@FindBy(xpath="//form[@name='modifyPaymentRoute']//table//tr[2]//td//input[@name='Submit']")
	WebElement modifysubmitbutton;
	@FindBy(xpath="//td[@class='note']")
	WebElement verificationMessageInModifyPaymentType;
	
	@FindBy(xpath="//b[text()='Logout']")
	WebElement logoutMaker;
	
	
	// View Page in Checker
	// 
	@FindBy(xpath="//input[@id='view']")
	WebElement viewInChecker;
	
	public AddPaymentRoutingMaker(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.waitForElement(driver, loginid, 10);
		// waitHelper.waitForElement(driver, loginid, 60);
	}




	// enter username
	public void enterloginid(String loginid) throws Exception {
		
		log.info("Enter Login Id in login page=="+loginid.length());
		Thread.sleep(4000);
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

// click on Add Payment Routing Maker SubMenu
	public void clickonAddPaymentRoutingMakerSubMenu() {
		log.info("click on Add Payment Routing Maker SubMenu===>" + AddPaymentRoutingMaker.getText());
		AddPaymentRoutingMaker.click();
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
	// Global variable
	static String mandateCode;
	static String getamountFromTextfield;
	static String getamountToTextfield;
	static String getIsActiveStatus;
	
	// select mandate Code Routed on 
	public void selectMandateCOdetoBeRouted() {
		 mandateCode = "CBA";
		log.info("select mandate Code Routed on Payment Routing Maker Page....."+selectmandateCodeRouted);
		Select selectmandateCode= new Select(selectmandateCodeRouted);
		List<WebElement> listOfselectmandateCode = selectmandateCode.getOptions();
	int 	GetNoOfmandateCode=listOfselectmandateCode.size();
	
	log.info("Get the Size of the Mandate Code From Drop Down... "+GetNoOfmandateCode);
	
	for(int i=1; i<listOfselectmandateCode.size();i++) {
		
		String GetTextOfMandateCodeFromDropDown = listOfselectmandateCode .get(i).getText();
		
		System.out.println("Get Text Of Mandate Code  form Drop Down List...."+GetTextOfMandateCodeFromDropDown);
		if(listOfselectmandateCode.get(i).getText().equals(mandateCode)) {
			log.info("......Text has Matched....");
			
			selectmandateCode.selectByVisibleText(mandateCode);
			log.info(" Corporate Id  drop down Text has Selected.... ");
			break;
		}
		
		else {
			System.out.println("......Drop Down Text has Matched Not Matched....");
			log.info(" Mandate Code drop down Text has not Selected ");
		}
	}
	
		
		
		
	}

// enter amount From in Payment Routing Maker page
	public void enteramountFromTextfield(String amountFromTextfield) {
		log.info("Enter amount On Text field ===>" + amountFromTextfield);
		this.amountFromTextfield.sendKeys(amountFromTextfield);
		getamountFromTextfield = amountFromTextfield.toString();
		System.out.println("get amount On Text field value ==>" + getamountFromTextfield);
	}
	//enter amount To On Add Payment Routing  Maker page
	public  void enteramountToTextfield(String amountToTextfield) {
		log.info("enter amount To Text field .."+amountToTextfield);
		this.amountToTextfield.sendKeys(amountToTextfield);
		getamountToTextfield = amountToTextfield.toString();
		System.out.println("get amount To Text field value ==>" + getamountToTextfield);
		
	}

// select  is Active Payment ? in Entity Maker page
	public void selectisisActiveStatus() {
		String s = "Yes";
		log.info("select is Active Currency  ?==" + isActiveStatus);
		Select aa = new Select(isActiveStatus);
		aa.selectByVisibleText(s);
		String getisActive = s.toString();
		System.out.println("get Is Active Status ===>>" + getisActive);
		String[] spl = getisActive.split("es");
		System.out.println("Split Array Values of Yes ===>>" + spl);
		List<String> splitList1 = Arrays.asList(spl);
		getIsActiveStatus = String.join("", splitList1);
		System.out.println("get Is Active Status after Split (es) As Yes=>>>" + getIsActiveStatus);
	
		
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
	// click On  Payment Routing Checker SubMenu
	public void clickOnPaymentRoutingCheckerSubMenu() {
		log.info("click On Payment Routing Checker SubMenu..."+PaymentRoutingChecker.getText());
		PaymentRoutingChecker.click();
	}
	// verify Payment  Type Checker Page
	public void verifyPaymentRoutingCheckerPages() throws Exception {
		log.info("verify  Payment Routing Checker Page...");
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		
		log.info("verify  Payment Routing Checker Page.."+verifyPaymentRoutingCheckerPage.getText());
		String paymentRoutingPage= verifyPaymentRoutingCheckerPage.getText();

		System.out.println("Get the Text of  Payment Routing Checker Page..."+paymentRoutingPage);
		Assert.assertEquals("PAYMENT ROUTING CHECKER", paymentRoutingPage );
		log.info("verified  Payment Routing Checker Page Suceessfully...");
	}
	// calling path variables and verify Add checker List in Payment routing  Checker page.
	// 
public void verifyAddcheckerListInPaymentRoutingCheckerpage() throws InterruptedException {
	String PaymentCodeRouted = "//table[@id='list']//tbody/tr/td[4]";
	String AmountFrom = "//table[@id='list']//tbody/tr/td[5]";
	String AmountTo = "//table[@id='list']//tbody/tr/td[6]";
	String IsActive = "//table[@id='list']//tbody/tr/td[7]";
	
	toverifyCheckerlist(PaymentCodeRouted, mandateCode);
     toverifyCheckerlist(AmountFrom, getamountFromTextfield);
	toverifyCheckerlist(AmountTo, getamountToTextfield);
	toverifyCheckerlist(IsActive, getIsActiveStatus);
	
}
// Calling the Generic Method to verify the List in Currency Checker page.
private void toverifyCheckerlist(String xpathvalue, String value) throws InterruptedException {

	// TODO Auto-generated method stub
	List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
	int Nooflist = list1.size();
	System.out.println(" No of list On Checker Page ==>" + Nooflist);
	for (int i = 0; i < list1.size(); i++) {
		String listText = list1.get(i).getText();
		System.out.println(" Get Text of Checker Page list ==>" + listText);
		if (list1.get(i).getText().equals(value)) {
			System.out.println("Get Text of  Checker list Has Matched with value ==>"+value);
			// driver.findElement(By.xpath("//input[@id='selectAll']")).click();

			break;
		} else {

			System.out.println("Get Text of  Checker list Has NOT Matched with value ==>"+value);
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
		if (name.contains(mandateCode)) {
			System.out.println("Text has Mtched");
			Thread.sleep(3000);
			driver.findElements(By.xpath(
					"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
					.get(i).click();
			log.info("Click On Check Box ==>");
		

		} else {
			System.out.println("Text has  Not Mtched ");
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
public void clickonsubmitbuttonInPaymentTYPECHECKERPage() {
	
	// Click on Submit button Checker Page. To Select only one  Checkbox
			log.info(" click on Submit button on Checker Page===>>"+SubmitbuttononChecker.getText());
			SubmitbuttononChecker.click();
			
			
}
// to verify successful Message in Payment Routing CHECKER page
public void toverifysuccessfulMessageinPaymentRoutingCheckerPage() {
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		
		System.out.println("Get the Text of Succesfull Message After click on Submit button In Payment Routing Checker page..."+successfulMessageinChecker);
		log.info("successful Message in Checker===="+verifysuccessfulMessageinChecker.getText());
		//Assert.assertEquals(successfulMessageinChecker, "Record updated successfully.");
	if(verifysuccessfulMessageinChecker.getText().equals("Record updated successfully.")) {
		
		log.info(" Successfully  verified the Message in Payment Routing Checker page..  ");
	}
	else {
		
		log.info(" Not Successfully  verified the Message in Payment Routing Checker page..  ");
	}

}


//  to go to Maker page when Checker Approved Payment Routing so click on Log out Button.
// calling p=7
  public void  gotoMakerPagewhenCheckerhasApprovedPaymenRoutingeMaker() throws InterruptedException {
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
public void verifyViewpageBySerachField() throws InterruptedException {
	this.searchfield.clear();
	log.info("Search By mandateCode ==>"+mandateCode);
	this.searchfield.sendKeys(mandateCode);
	log.info("Search By amount From ==>"+getamountFromTextfield);
	this.searchfield.clear();
	this.searchfield.sendKeys(getamountFromTextfield);
	Thread.sleep(4000);
	this.searchfield.clear();
	log.info("Search By amount TO ==>"+getamountToTextfield);
	this.searchfield.sendKeys(getamountToTextfield);
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
public void  verifytheViewpageWithTextInViewPage(){
	
	String PaymentType= "//tbody[@role='alert']//tr//td[2]";
	String AmountFrom = "//tbody[@role='alert']//tr//td[3]";
	String AmountTo= "//tbody[@role='alert']//tr//td[4]";
	String ISActive = "//tbody[@role='alert']//tr//td[5]";
	
	verifytheViewpageWithText(PaymentType, mandateCode);
	verifytheViewpageWithText(AmountFrom, getamountFromTextfield);
	verifytheViewpageWithText(AmountTo, getamountToTextfield);
	verifytheViewpageWithText(ISActive, getIsActiveStatus);
	
}
// 
// verify the View Maker Page with Text with thier respective Column
public static void verifytheViewpageWithText(String xpathvalue, String value) {
	List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
	int Nooflist = list1.size();
	System.out.println("No of list on View page ==>" + Nooflist);
	for (int i = 0; i < list1.size(); i++) {
		String listText = list1.get(i).getText();
		System.out.println("Get Text of List On View Page ==>" + listText);
		if (list1.get(i).getText().equals(value)) {
			System.out.println("Get Text of List Has Matched With Value ==>"+value);
			break;
		} else {

			System.out.println("Get Text of List Has NOT Matched With Value ==>"+value);
		}
	}

}
// Select  All Drop down values in Maker view page when the Added Payment Routing has Approved By Checker 
public void verifyBytheDropDownlistValuesOneByOneOnViewPage() {
	// WebElement 
	WebElement selectPaymentType=driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
	WebElement selectAmountFrom=driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
	WebElement selectAmountTo=driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
	WebElement selectISActive=driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
	
		
	verifyBytheDropDownlistOneByOne(selectPaymentType, mandateCode);
	verifyBytheDropDownlistOneByOne(selectAmountFrom, getamountFromTextfield);
	verifyBytheDropDownlistOneByOne(selectAmountTo, getamountToTextfield);
	verifyBytheDropDownlistOneByOne(selectISActive, getIsActiveStatus);
	
	
}
//
// select one by one of Select in View page of Maker
public static void verifyBytheDropDownlistOneByOne(WebElement xpathvalue, String value) {
	
	Select sel= new Select(xpathvalue);
	List<WebElement> N = sel.getOptions();
	int Nooflist = N.size();
	System.out.println("No of list of Drop down values ==>" + Nooflist);
	for (int i = 0; i <  N .size(); i++) {
		String listText =  N .get(i).getText();
		System.out.println("Get Text From drop down values ==>" + listText);
		if ( N .get(i).getText().equals(value)) {
			System.out.println("Drop Down Text List Has Matched with Value  ==>"+value);
			 sel.selectByVisibleText(value);
			break;
		} else {

			System.out.println("Drop Down Text List Has NOT Matched with Value  ==>"+value);
			
		}
	}

}
//switch view page to Maker page and click on Modify button.
//verify Modify Payment Routing Maker Page
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

		log.info(" Get the Text of Modify Payment Routing Maker Ppage===>>"+verifyModifyPaymentRoutingMakerPage.getText());
		log.info(" verify the Modify Routing Maker Ppage...");
		Assert.assertEquals(verifyModifyPaymentRoutingMakerPage.getText(), "MODIFY PAYMENT ROUTING MAKER");
		log.info(" Successfully verified the Modify Payment Routing Maker Ppage...");
	
 }
 // select Payment Code In Modify Payment Routing Type Maker Page
 public void selectMandateCodeInModifyPaymentRoutingMakerPage() {
	 driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
 Select selectMandateCode= new Select(selectmodifyMandateCodeInModifyPage);
List<WebElement> listOfMandateCodeCode = selectMandateCode.getOptions();
int noofMandateCodedOnDropDown=listOfMandateCodeCode .size();
System.out.println("Get the No of Mandate code On Drop Down==>>"+noofMandateCodedOnDropDown);

for(int i=0; i<listOfMandateCodeCode .size(); i++) {
	String GetTextOfAllDropDownValues = listOfMandateCodeCode.get(i).getText();
	System.out.println("Get Text Of All DropDown Values==>"+GetTextOfAllDropDownValues);
	
	if(listOfMandateCodeCode.get(i).getText().equals(mandateCode)) {
		log.info("Drop Down Text has Matched  with Value ==>"+mandateCode);
		selectMandateCode.selectByIndex(i);
		System.out.println("Mandate Code Matched the From Mandate Code Drop Down In MODIFY Payment Routing MAKER page=>>");
		break;
		}
	else {
	
		System.out.println("Mandate Code NOT Matched the From Mandate Code Drop Down In MODIFY Payment Routing MAKER page==>");
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
 // verification Message In Modify Payment Routing Type Page
 public void verificationMessageInModifyPaymentRoutingTypePage() throws Exception {
	 log.info("Get the Text Of Verification Message In Modify Payment Type Page==>>"+verificationMessageInModifyPaymentType.getText());
	 //Assert.assertEquals(verificationMessageInModifyEntityType.getText(), "Record has been modified successfully.");
	 
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

		}
		else {
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			log.info("==Successfull Message has Matched with  Text==");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		}
 
 }
 // verify the Payment Routing checker List IF Modification has Done By Maker with Existing Corporate Id.
 public void verifyListOfPaymentRoutingIncheckerWhenModificationhasDoneByMaker()throws InterruptedException {
	    String PaymentCodeRouted= "//table[@id='list']//tbody/tr/td[4]";
		String AmountFrom = "//table[@id='list']//tbody/tr/td[5]";
		String AmountTo = "//table[@id='list']//tbody/tr/td[6]";
		String IsActive = "//table[@id='list']//tbody/tr/td[7]";
		
		toverifyCheckerlistWhenModifiedMaker(PaymentCodeRouted, mandateCode);
		toverifyCheckerlistWhenModifiedMaker(AmountFrom , getamountFromTextfield);
		toverifyCheckerlistWhenModifiedMaker(AmountTo, getamountToTextfield);
		toverifyCheckerlistWhenModifiedMaker(IsActive, getIsActiveStatus);
		
	}
	// Calling the Generic Method to verify the List in Entity Type Checker page.
	private void toverifyCheckerlistWhenModifiedMaker(String xpathvalue, String value) throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list On Checker Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("Get Text of list On Checker Page ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Get Text of List Checker Page Has Matched with Value ==>"+value);
				// driver.findElement(By.xpath("//input[@id='selectAll']")).click();

				break;
			} else {

				System.out.println("Get Text of List Checker Page Has Matched with Value ==>"+value);
				// driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();

			}

		}

	}

	public void selectThecheckboxOnCheckerPageWhenModifyMakerDaata() {
		  String xpathmandateCode="//table[@id='list']//tbody/tr/td[4]";
		  selectThecheckboxOnCheckerPageWhenModify(xpathmandateCode,mandateCode);
	}
	
	public void selectThecheckboxOnCheckerPageWhenModify(String xpathvalue,String value) {

		List<WebElement> web = driver.findElements(By.xpath(xpathvalue));
		int sizeOfColumn = web.size();
		System.out.println("size Of Column===>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get Text of Unique Column ==>" + name);
			if (name.contains(value)) {
				System.out.println("Text has Mtched With Value On Checker page ==>"+value);
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				log.info("Click on Unique  Matched Value"+value);
				
				break;
			} else {
				System.out.println("Text has  Not Mtched with Value On Checker Page ==>"+value);
			}
		}

	}



	

	//checkbox selecting  After ModifytheCountry 
  public  void multiplecheckboxwhenModifythePaymentRouting() {
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
   
//in view Page , search by different values passing into search box,
//refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
  //2. when the Modified the Payment Routing then "View" page Maker 
public void verifyViewpageBySearchFieldWhenModifyThePaymentRoutingAndApprovedDoneByChecker() throws InterruptedException {
	this.searchfield.clear();
	log.info("Search By mandateCode ==>"+mandateCode);
	this.searchfield.sendKeys(mandateCode);
	log.info("Search By amount From ==>"+getamountFromTextfield);
	this.searchfield.clear();
	this.searchfield.sendKeys(getamountFromTextfield);
	Thread.sleep(4000);
	this.searchfield.clear();
	log.info("Search By amount TO ==>"+getamountToTextfield);
	this.searchfield.sendKeys(getamountToTextfield);
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
	
	String PaymentType= "//tbody[@role='alert']//tr//td[2]";
	String AmountFrom = "//tbody[@role='alert']//tr//td[3]";
	String AmountTo= "//tbody[@role='alert']//tr//td[4]";
	String ISActive = "//tbody[@role='alert']//tr//td[5]";
	
	verifyTheMakerViewPageWhenModified(PaymentType, mandateCode);
	verifyTheMakerViewPageWhenModified(AmountFrom, getamountFromTextfield);
	verifyTheMakerViewPageWhenModified(AmountTo, getamountToTextfield);
	verifyTheMakerViewPageWhenModified(ISActive, getIsActiveStatus);
}
// verify the View Maker Page with Text with thier respective Column
public static void verifyTheMakerViewPageWhenModified(String xpathvalue, String value) {
	List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
	int Nooflist = list1.size();
	System.out.println("No of list On View Page when Modified ==>" + Nooflist);
	for (int i = 0; i < list1.size(); i++) {
		String listText = list1.get(i).getText();
		System.out.println("Get Text List of View Page When Modifiefd ==>" + listText);
		if (list1.get(i).getText().equals(value)) {
			System.out.println("Get Text List Has  Matched With Value On View Page When Modified ==>"+value);
			break;
		} else {

			System.out.println("Get Text List Has NOT Matched With Value On View Page When Modified ==>"+value);
		}
	}

}
// To verify  By  All Select Filter Or To Verify the Modify Data in Maker View Page By Using Drop Down
// select All values One By One
public void toVerifytheModifyDataInMakerViewPagByUsingDropDown(){
	// WebElement 
		WebElement selectPaymentType=driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectAmountFrom=driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectAmountTo=driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectISActive=driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		
			
		verifySelectDropDonInViewMakerPageWhenModified(selectPaymentType, mandateCode);
		verifySelectDropDonInViewMakerPageWhenModified(selectAmountFrom, getamountFromTextfield);
		verifySelectDropDonInViewMakerPageWhenModified(selectAmountTo, getamountToTextfield);
		verifySelectDropDonInViewMakerPageWhenModified(selectISActive, getIsActiveStatus);
		
}
// select one by one of Select in View page of Maker
// 4 drop down using one by one select the values from drop down
public static void verifySelectDropDonInViewMakerPageWhenModified(WebElement xpathvalue, String value) {
	
	Select sel= new Select(xpathvalue);
	List<WebElement> N = sel.getOptions();
	int Nooflist = N.size();
	System.out.println("No of list On drop down On View Page ==>" + Nooflist);
	for (int i = 0; i <  N .size(); i++) {
		String listText =  N .get(i).getText();
		System.out.println("Get Text of drop down On View Page ==>" + listText);
		if ( N .get(i).getText().equals(value)) {
			System.out.println("Get Text of drop down Has Matched With value On View Page ==>"+value);
			 sel.selectByVisibleText(value);
			break;
		} else {

			System.out.println("Get Text of drop down Has NOT Matched With value On View Page ==>"+value);
			
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

		log.info(" Get the Text of Modify Payment Routing  Maker Ppage===>>"+verifyModifyPaymentRoutingMakerPage.getText());
		log.info(" verify the Modify  Payment Routing Maker Ppage...");
		Assert.assertEquals(verifyModifyPaymentRoutingMakerPage.getText(), "MODIFY PAYMENT ROUTING MAKER");
		log.info(" Successfully verified the Modify Payment Routing Maker Ppage...");
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
	 
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().defaultContent();
	
	
driver.findElement(By.xpath("//b[text()='Logout']")).click();
	
	  
	  
  }
}
