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
public class AddRoutingMaker {
	static WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(AddRoutingMaker.class);
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
	@FindBy(xpath = "//*[contains(text(),'Add Routing Maker')]//parent::a")
	WebElement AddRoutingMaker;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;
	@FindBy(xpath = "//select[@name='bankId']")
	WebElement selectBankID;
	@FindBy(xpath = "//input[@name='routingNo']")
	WebElement routingNo;

	@FindBy(xpath = "//input[@name='bankName']")
	WebElement BankName;
	@FindBy(xpath = "//input[@name='bankBranch']")
	WebElement BankBranch;
	@FindBy(xpath = "//input[@name='district']")
	WebElement Bankdistrict;

	@FindBy(xpath = "//input[@name='division']")
	WebElement Bankdivision;
	@FindBy(xpath = "//input[@name='Dist_code']")
	WebElement BankDist_code;
	@FindBy(xpath = "//input[@name='Bank_code']")
	WebElement Bank_code;

	@FindBy(xpath = "//input[@name='Branch_code']")
	WebElement Branch_code;
	@FindBy(xpath = "//input[@name='address']")
	WebElement Branch_address;
	@FindBy(xpath = "//select[@name='isSameBank']")
	WebElement SelectisSameBank;

	@FindBy(xpath = "//select[@id='isActive']")
	WebElement isActiveRouting;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
// Statrted  Checker X-path

	@FindBy(xpath = "//*[text()='Master Definition Checker']")
	WebElement MasterDefinitionChecker;
	@FindBy(xpath = "//*[text()='Add Routing Checker']//parent::a")
	WebElement AddRoutingChecker;
	@FindBy(xpath = "//td[contains(text(),'Routing Checker')]")
	WebElement verifyRoutingCheckerPage;
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

	public AddRoutingMaker(WebDriver driver) {
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
	public void clickonAddRoutingMakerSubMenu() {
		log.info("click on Add Routing Maker SubMenu===>" + AddRoutingMaker.getText());
		AddRoutingMaker.click();
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

	static String splivaluesOfBankIDValues;
	static String bankIdnewstring;
	static String getroutingNo;
	static String getBankName;
	static String getBankBranch;
	static String getBankdistrict;
	static String getBankdivision;
	static String getBankDist_code;
	static String getBank_code;
	static String getBranch_code;
	static String getBranch_address;
	static String getIsActiveRouting;
	static String getIsSameBankOrDifferent;

	// select Bank ID On Add Routing Maker page
	public void selectBankIDOnAddRoutingMakerpage() {
		String s1 = "CTBC BANK CO LTD";
		String s2 = "CTCB";
		bankIdnewstring = s1 + "-" + s2;
		System.out.println("Get Text of Combination of Bank and Bank Id ==>" + bankIdnewstring);

		Select selectBankIDDropDown = new Select(selectBankID);
		List<WebElement> listofselectBankID = selectBankIDDropDown.getOptions();
		int GetNoOfAllBankId = listofselectBankID.size();

		log.info("Get the Size of the All Bank ID On Drop Down ==>" + GetNoOfAllBankId);

		for (int i = 1; i < listofselectBankID.size(); i++) {

			String GetTextOfBankIDDropDown = listofselectBankID.get(i).getText();
			System.out.println("Get Text Of Bank ID  form Drop Down List ==>" + GetTextOfBankIDDropDown);

			String[] splt = GetTextOfBankIDDropDown.split("-");
			splivaluesOfBankIDValues = splt[1].trim();
			System.out.println("Get the Bank Id values after SPlit (-)==>" + splivaluesOfBankIDValues);

			if (listofselectBankID.get(i).getText().equals(bankIdnewstring)) {
				log.info("Text has Matched with value ==>" + bankIdnewstring);

				selectBankIDDropDown.selectByVisibleText(bankIdnewstring);
				log.info("Bank ID drop down Text has Selected with value ==>" + bankIdnewstring);
				break;
			}

			else {

				log.info("Bank id drop down Text has not Selected with value==>" + bankIdnewstring);
			}
		}

	}

// enter routing No in Add Routing MAKER  page
	public void enterroutingNo(String routingNo) {
		log.info("Enter routing No ===>" + routingNo);
		this.routingNo.sendKeys(routingNo);
		getroutingNo = routingNo.toString();
		System.out.println("get routing No value ==>" + getroutingNo);
	}

// enter Bank Name in AddRouting Maker page
	public void enterBankName(String BankName) {
		log.info("enter Bank Name ==>" + BankName);
		this.BankName.sendKeys(BankName);
		getBankName = BankName.toString();
		System.out.println("get Bank Name value ==>" + getBankName);
	}

	// Enter bank Branch
	public void enterBankBranch(String BankBranch) {
		log.info("Enter Bank Branch ==>" + BankBranch.length());
		this.BankBranch.sendKeys(BankBranch);
		getBankBranch = BankBranch.toString();
		System.out.println("get Bank Branch value ==>" + getBankBranch);
	}

	// Enter Bank District
	public void enterBankdistrict(String Bankdistrict) {
		log.info("Enter Bank District ==>");
		this.Bankdistrict.sendKeys(Bankdistrict);
		getBankdistrict = Bankdistrict.toString();
		System.out.println("get Bank district value ==>" + getBankdistrict);
	}

	// Enter Bank Division.
	public void enterBankdivision(String Bankdivision) {
		log.info("Enter Bank Division ==>" + Bankdivision.length());
		this.Bankdivision.sendKeys("Bankdivision");
		getBankdivision = Bankdivision.toString();
		System.out.println("get Bank division value ==>" + getBankdivision);

	}

	public void enterBankDist_code(String BankDist_code) {
		log.info("Enter Bank Dist_code.....");
		this.BankDist_code.sendKeys(BankDist_code);
		getBankDist_code = BankDist_code.toString();
		System.out.println("get Bank Dist_code value ==>" + getBankDist_code);
	}

	// Enter Bank_code
	public void enterBank_code(String Bank_code) {
		log.info("Enter Bank_code....");
		this.Bank_code.sendKeys(Bank_code);
		getBank_code = Bank_code.toString();
		System.out.println("get Bank_code value ==>" + getBank_code);
	}

	// "Enter Branch_code
	public void enterBranch_code(String Branch_code) {
		log.info("Enter Branch_code...");
		this.Branch_code.sendKeys(Branch_code);
		getBranch_code = Branch_code.toString();
		System.out.println("get Branch_code value ==>" + getBranch_code);

	}

	// Enter Branch_address on Routing Maker page
	public void enterBranch_address(String Branch_address) {
		log.info("Enter Branch_address..." + Branch_address.length());
		this.Branch_address.sendKeys(Branch_address);
		getBranch_address = Branch_address.toString();
		System.out.println("get Branch_address value ==>" + getBranch_address);
	}

// select  is Active Routing ? in Routing Maker page
	public void selectisActiveRouting() {

		String s = "Yes";
		log.info("select is Active Routing  ?==" + isActiveRouting);
		Select aa = new Select(isActiveRouting);
		aa.selectByVisibleText(s);
		String getisActive = s.toString();
		System.out.println("get Is Active Routing ===>>" + getisActive);
		String[] spl = getisActive.split("es");
		System.out.println("Split Array Values of Yes ===>>" + spl);
		List<String> splitList1 = Arrays.asList(spl);
		getIsActiveRouting = String.join("", splitList1);
		System.out.println("get Is Active Routing after Split (Yes) As Y ==>" + getIsActiveRouting);
	}

// Select is Same Bank on Add routing maker page
	public void SelectisSameBankORDifferent() {
		String s1 = "Yes";
		String s2 = "No";
		log.info("Slect the Is Same bank or Different ...");
		Select SelectisSameBankName = new Select(SelectisSameBank);
		List<WebElement> listofIsSameBankName = SelectisSameBankName.getOptions();
		int NoofISBank = listofIsSameBankName.size();
		System.out.println("Get the Toatal no of Is Same Bak ==>" + NoofISBank);

		for (int i = 0; i < listofIsSameBankName.size(); i++) {
			String GetTextOfAllISSameBankName = listofIsSameBankName.get(i).getText();
			System.out.println("Get Text Of All IS Same Bank Name...." + GetTextOfAllISSameBankName);
			if (listofIsSameBankName.get(i).getText().equals(s1)) {
				log.info("Text has Matched with Select Drop Down ==>");
				SelectisSameBankName.selectByVisibleText(s1);
				log.info("Bank IS Selected the Matched value From  Drop Down ==>");
				String strIsSameBank = s1.toString();
				System.out.println("get Is Same Bank or different bank ==>>" + strIsSameBank);
				String[] spl = strIsSameBank.split("es");
				System.out.println("Split Array Values of Yes ===>>" + spl);
				List<String> splitList1 = Arrays.asList(spl);
				getIsSameBankOrDifferent = String.join("", splitList1);
				System.out.println(
						"get Is Same Bank Or Different after Split (es) As Yes=>>>" + getIsSameBankOrDifferent);

				break;
			}

			else {

				log.info(" Bank IS Not Selected the Matched value From  Drop Down ==>");
				// SelectisSameBankName.selectByVisibleText("No");

			}
		}
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

	// click Add Routing Checker SubMenu
	public void clickOnAddRoutingCheckerSubMenu() {
		log.info("click On Add Routing Checker SubMenu..." + AddRoutingChecker.getText());
		AddRoutingChecker.click();
	}

	// verify Routing Checker Page
	public void verifyRoutingCheckerPages() throws Exception {
		log.info("verify Routing Checker Page...");
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		log.info("verify Routing Checker Page...." + verifyRoutingCheckerPage.getText());
		String RoutingCheckerPage = verifyRoutingCheckerPage.getText();

		System.out.println("Get the Text of  Routing Checker Page..." + RoutingCheckerPage);
		Assert.assertEquals("ROUTING CHECKER", RoutingCheckerPage);
		log.info(" Suceessfully verified the Routing Checker Page...");
	}

	// calling path variables and verifyAddcheckerList in Sub purpose Checker page.
	// verify Add Sub purpose maker at checker List In Routing Checker page()
	public void verifyAddcheckerListInCheckerpage() throws InterruptedException {
		String RoutingNumber = "//table[@id='list']//tbody/tr/td[4]";
		String BankName = "//table[@id='list']//tbody/tr/td[5]";
		String BankBranch = "//table[@id='list']//tbody/tr/td[6]";
		String District = "//table[@id='list']//tbody/tr/td[7]";
		String Division = "//table[@id='list']//tbody/tr/td[8]";
		String DistrictCode = "//table[@id='list']//tbody/tr/td[9]";
		String BankCode = "//table[@id='list']//tbody/tr/td[10]";
		String BranchCode = "//table[@id='list']//tbody/tr/td[11]";
		String Address = "//table[@id='list']//tbody/tr/td[12]";
		String isActive = "//table[@id='list']//tbody/tr/td[13]";
		String CreatredBy = "//table[@id='list']//tbody/tr/td[14]";
		String BankID = "//table[@id='list']//tbody/tr/td[15]";
		String IsSameBank = "//table[@id='list']//tbody/tr/td[16]";

		toverifyCheckerPageTextlist(RoutingNumber, getroutingNo);
		toverifyCheckerPageTextlist(BankName, getBankName);
		toverifyCheckerPageTextlist(BankBranch, getBankBranch);
		toverifyCheckerPageTextlist(District, getBankdistrict);
		toverifyCheckerPageTextlist(Division, getBankdivision);
		toverifyCheckerPageTextlist(DistrictCode, getBankDist_code);
		toverifyCheckerPageTextlist(BankCode, getBank_code);
		toverifyCheckerPageTextlist(BranchCode, getBranch_code);
		toverifyCheckerPageTextlist(Address, getBranch_address);
		toverifyCheckerPageTextlist(CreatredBy, "LASTMILE2");
		toverifyCheckerPageTextlist(isActive, getIsActiveRouting);
		toverifyCheckerPageTextlist(BankID, splivaluesOfBankIDValues);
		toverifyCheckerPageTextlist(IsSameBank, getIsSameBankOrDifferent);

	}

// Calling the Generic Method to verify the List in purpose Checker page.
	private void toverifyCheckerPageTextlist(String xpathvalue, String value) throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list On Checker Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("List Of Get Text  On Checker Page ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Get Text of  Checker Page list has Matched with value ==>" + value);
				// driver.findElement(By.xpath("//input[@id='selectAll']")).click();

				break;
			} else {

				System.out.println("Get Test of List on Checker  Page Has  Not  matched with Value ==>" + value);
				// driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();

			}

		}

	}

	public void selectThecheckboxOnCheckerPageWhenAddMakerDaata() {
		String routingNo = "//table[@id='list']//tbody/tr/td[4]";
		selectThecheckboxOnCheckerPageWhenAdded(routingNo, getroutingNo);
	}

	public void selectThecheckboxOnCheckerPageWhenAdded(String xpathvalue, String value) {

		List<WebElement> web = driver.findElements(By.xpath(xpathvalue));
		int sizeOfColumn = web.size();
		System.out.println("size Of Unique value Column ==>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get Name of Unique Column =>>" + name);
			if (name.contains(value)) {
				System.out.println("Get Text has Mtched with Unique value ==>" + getroutingNo);
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				log.info("click on the Matched value checkbox ");

				break;
			} else {
				System.out.println("Text has  Not Mtched with Unique value");
			}
		}

	}


// click on submit button And verify Successful Message on Checker  Page.
	public void clickonsubmitbuttonOnCheckerPage() {

		// Click on Submit button Checker Page.
		log.info("click on Submit button on Checker Page ==>" + SubmitbuttononChecker.getText());
		SubmitbuttononChecker.click();

	}

// to verify successful Message in Routing Checker page
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
	public void verifyViewpageBySearchField() throws Exception {
		this.searchfield.clear();
		log.info("Searh By Bank Name ==>" + getBankName);
		this.searchfield.sendKeys(getBankName);
		this.searchfield.clear();
		log.info("Search By Bank Branch ==>" + getBankBranch);
		this.searchfield.sendKeys(getBankBranch);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("Search By routing No ==>" + getroutingNo);
		this.searchfield.sendKeys(getroutingNo);
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
// verify the Maker View page By using Text verification 
	public void multippleSelectVerifyTextInViewPage() {

		String BankID = "//tbody[@role='alert']//tr//td[2]";
		String BankName = "//tbody[@role='alert']//tr//td[3]";
		String BankBranch = "//tbody[@role='alert']//tr//td[4]";
		String RoutingNumber = "//tbody[@role='alert']//tr//td[5]";
		String ISActive = "//tbody[@role='alert']//tr//td[6]";

		// verifytheViewpageWithText(BankID, "");
		verifytheViewpageWithText(BankName, getBankName.toUpperCase());
		verifytheViewpageWithText(BankBranch, getBankBranch.toUpperCase());
		verifytheViewpageWithText(RoutingNumber, getroutingNo);
		verifytheViewpageWithText(ISActive, getIsActiveRouting.toUpperCase());

	}

// 
// verify the View Maker Page with Text with thier respective Column
	public static void verifytheViewpageWithText(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list On View Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("Get List of Text On View Page ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Get Text List On View Page Has Matched with value ==>" + value);
				break;
			} else {

				System.out.println("Get Text List On View Page Has NOT Matched with value ==>" + value);
			}
		}

	}

// Select  All Drop down values in Maker view page when the Added Routing has Approved By Checker 
	public void selectDropDownOnViewPagevaluesOneByOneDropDown() {
		// WebElement
		WebElement selectBankID = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectBankName = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectBankBranch = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectRoutingNumber = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement selectISActive = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));

		verifyBytheDropDownlistOneByOne(selectBankID, "");
		verifyBytheDropDownlistOneByOne(selectBankName, getBankName.toUpperCase());
		verifyBytheDropDownlistOneByOne(selectBankBranch, getBankBranch.toUpperCase());
		verifyBytheDropDownlistOneByOne(selectRoutingNumber, getroutingNo);
		verifyBytheDropDownlistOneByOne(selectISActive, getIsActiveRouting.toUpperCase());

	}

//
// select one by one of Select in View page of Maker
	public static void verifyBytheDropDownlistOneByOne(WebElement aa, String value) {

		Select sel = new Select(aa);
		List<WebElement> N = sel.getOptions();
		int Nooflist = N.size();
		System.out.println("No of list On drop down ==>" + Nooflist);
		for (int i = 0; i < N.size(); i++) {
			String listText = N.get(i).getText();
			System.out.println(" Get List of Text from Drop Down on View page ==>" + listText);
			if (N.get(i).getText().equals(value)) {
				System.out.println("List of Text from Drop Down Matched with Value on View page ==>" + value);
				System.out.println("Drop Down Has Selected with Value on View page ==>" + value);
				sel.selectByVisibleText(value);

				break;
			} else {

				System.out.println("List of Text from Drop Down Has NOT Matched with Value on View page ==>" + value);

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
	public void enterroutingNoOnModifyMakerPage() {
		driver.switchTo().defaultContent();
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);
		driver.switchTo().frame(0);
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));
		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());

		log.info("Enter the Routing No on Modify routing Maker page..." + routingNoOnModifyMakerPage);
		this.routingNoOnModifyMakerPage.sendKeys(getroutingNo);

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
			log.info("Record has been modified successfully.");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("This Mandate Type name has already used.")) {
			log.info("This Mandate Type name has already used.");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals(" ")) {
			log.info("This is Not Matched");

		} else {
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			log.info("Successfull Message has Matched with  Text ==>");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		}

	}

	// verify the Payment Type checker List IF Modification has Done By Maker with
	// Existing Entity
	//
	public void verifyListonCheckerpageWhenModificationhasDoneByMaker() throws InterruptedException {
		String RoutingNumber = "//table[@id='list']//tbody/tr/td[4]";
		String BankName = "//table[@id='list']//tbody/tr/td[5]";
		String BankBranch = "//table[@id='list']//tbody/tr/td[6]";
		String District = "//table[@id='list']//tbody/tr/td[7]";
		String Division = "//table[@id='list']//tbody/tr/td[8]";
		String DistrictCode = "//table[@id='list']//tbody/tr/td[9]";
		String BankCode = "//table[@id='list']//tbody/tr/td[10]";
		String BranchCode = "//table[@id='list']//tbody/tr/td[11]";
		String Address = "//table[@id='list']//tbody/tr/td[12]";
		String isActive = "//table[@id='list']//tbody/tr/td[13]";
		String CreatredBy = "//table[@id='list']//tbody/tr/td[14]";
		String BankID = "//table[@id='list']//tbody/tr/td[15]";
		String IsSameBank = "//table[@id='list']//tbody/tr/td[16]";

		toverifyCheckerlistWhenModifiedMaker(RoutingNumber, getroutingNo);
		toverifyCheckerlistWhenModifiedMaker(BankName, getBankName);
		toverifyCheckerlistWhenModifiedMaker(BankBranch, getBankBranch);
		toverifyCheckerlistWhenModifiedMaker(District, getBankdistrict);
		toverifyCheckerlistWhenModifiedMaker(Division, getBankdivision);
		toverifyCheckerlistWhenModifiedMaker(DistrictCode, getBankDist_code);
		toverifyCheckerlistWhenModifiedMaker(BankCode, getBank_code);
		toverifyCheckerlistWhenModifiedMaker(BranchCode, getBranch_code);
		toverifyCheckerlistWhenModifiedMaker(Address, getBranch_address);
		toverifyCheckerlistWhenModifiedMaker(CreatredBy, "LASTMILE2");
		toverifyCheckerlistWhenModifiedMaker(isActive, getIsActiveRouting);
		toverifyCheckerlistWhenModifiedMaker(BankID, splivaluesOfBankIDValues);
		toverifyCheckerlistWhenModifiedMaker(IsSameBank, getIsSameBankOrDifferent);
	}

	// Calling the Generic Method to verify the List in Routing Type Checker page.
	private void toverifyCheckerlistWhenModifiedMaker(String xpathvalue, String value) throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list On Checker Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("List Of Get Text On Checker Page ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Get Text of  Checker Page list has Matched with value ==>" + value);
				// driver.findElement(By.xpath("//input[@id='selectAll']")).click();

				break;
			} else {

				System.out.println("Get Text of  Checker Page list has NOT Matched with value ==>" + value);
				// driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();

			}

		}
	}

	// select The check box On Checker Page When Modify The Maker Data
	public void selectThecheckboxOnCheckerPageWhenModifyTheMakerData() {
		String routingNo = "//table[@id='list']//tbody/tr/td[4]";
		selectThecheckboxOnCheckerPageWhenAdded(routingNo, getroutingNo);
	}

	public void selectThecheckboxOnCheckerPageWhenModify(String xpathvalue, String value) {

		List<WebElement> web = driver.findElements(By.xpath(xpathvalue));
		int sizeOfColumn = web.size();
		System.out.println("size Of Unique value Column ==>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get Name of Unique Column  When Modify =>>" + name);
			if (name.contains(value)) {
				System.out.println("Get Text has Mtched with Unique value When Modify ==>" + value);
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				log.info("click on the Matched value checkbox ");

				break;
			} else {
				System.out.println("Text has  Not Mtched with Unique value" + value);
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

//in view Page , search by different values passing into search box,
//refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
	// 2. when the Modified the Routing then "View" page Maker
	public void verifyViewpagesBySearchFieldWhenModifyAndApprovedDoneByChecker() throws Exception {
		this.searchfield.clear();
		log.info("Searh By Bank Name ==>" + getBankName);
		this.searchfield.sendKeys(getBankName);
		this.searchfield.clear();
		log.info("Search By Bank Branch ==>" + getBankBranch);
		this.searchfield.sendKeys(getBankBranch);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("Search By routing No ==>" + getroutingNo);
		this.searchfield.sendKeys(getroutingNo);
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

		String BankID = "//tbody[@role='alert']//tr//td[2]";
		String BankName = "//tbody[@role='alert']//tr//td[3]";
		String BankBranch = "//tbody[@role='alert']//tr//td[4]";
		String RoutingNumber = "//tbody[@role='alert']//tr//td[5]";
		String ISActive = "//tbody[@role='alert']//tr//td[6]";

		// verifytheViewpageWithText(BankID, "");
		verifyTheMakerViewPageWhenModified(BankName, getBankName.toUpperCase());
		verifyTheMakerViewPageWhenModified(BankBranch, getBankBranch.toUpperCase());
		verifyTheMakerViewPageWhenModified(RoutingNumber, getroutingNo);
		verifyTheMakerViewPageWhenModified(ISActive, getIsActiveRouting.toUpperCase());

	}

// 
// verify the View Maker Page with Text with thier respective Column
	public static void verifyTheMakerViewPageWhenModified(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list On View Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("Get List of Text On View Page ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Get Text List On View Page Has Matched with value ==>" + value);
				break;
			} else {

				System.out.println("Get Text List On View Page Has NOT Matched with value ==>" + value);
			}
		}

	}

// To verify  By  All Select Filter Or To Verify the Modify Data in Maker View Page By Using Drop Down
// select All values One By One
//  5 drop down are available on the 
	public void toVerifytheModifyDataInMakerViewPagByUsingDropDown() {
		// WebElement
		WebElement selectBankID = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectBankName = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectBankBranch = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectRoutingNumber = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement selectISActive = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));

		// verifyBytheDropDownlistOneByOne(selectBankID, "");
		verifySelectDropDonInViewMakerPageWhenModified(selectBankName, getBankName.toUpperCase());
		verifySelectDropDonInViewMakerPageWhenModified(selectBankBranch, getBankBranch.toUpperCase());
		verifySelectDropDonInViewMakerPageWhenModified(selectRoutingNumber, getroutingNo);
		verifySelectDropDonInViewMakerPageWhenModified(selectISActive, getIsActiveRouting.toUpperCase());
	}

//
// select one by one of Select in View page of Maker
// 4 drop down using one by one select the values from drop down
	public static void verifySelectDropDonInViewMakerPageWhenModified(WebElement aa, String value) {

		Select sel = new Select(aa);
		List<WebElement> N = sel.getOptions();
		int Nooflist = N.size();
		System.out.println("No of list On drop down ==>" + Nooflist);
		for (int i = 0; i < N.size(); i++) {
			String listText = N.get(i).getText();
			System.out.println(" Get List of Text from Drop Down on View page ==>" + listText);
			if (N.get(i).getText().equals(value)) {
				System.out.println("List of Text from Drop Down Matched with Value on View page ==>" + value);
				log.info("Drop Down Has Selected with Value on View page ==>" + value);
				sel.selectByVisibleText(value);

				break;
			} else {

				System.out.println("List of Text from Drop Down Matched with Value on View page ==>" + value);

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

		String Header = driver.findElement(By.xpath("//td[contains(text(),' Purpose Checker')]")).getText();

		System.out.println(Header);
		Assert.assertEquals("SUB PURPOSE CHECKER", Header);


		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().defaultContent();
		
		

		driver.findElement(By.xpath("//b[text()='Logout']")).click();

	}
}
