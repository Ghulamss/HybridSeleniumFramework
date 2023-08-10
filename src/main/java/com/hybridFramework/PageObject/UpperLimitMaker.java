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
public class UpperLimitMaker {
	static WebDriver driver;

	private final Logger log = LoggerHelper.getLogger(UpperLimitMaker.class);
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
	@FindBy(xpath = "//*[contains(text(),'Upper Limit Maker')]//parent::a")
	WebElement UpperLimitMakerPage;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;
	@FindBy(xpath = "//input[@id='amount']")
	WebElement BDTamount;

	@FindBy(xpath = "//input[@id='modify']")
	WebElement modifyButton;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
	// Started Checker X-path
	@FindBy(xpath = "//*[text()='Master Definition Checker']")
	WebElement MasterDefinitionChecker;
	@FindBy(xpath = "//*[text()='Upper Limit Checker']//parent::a")
	WebElement UpperLimitChecker;

	@FindBy(xpath = "//td[contains(text(),' Upper Limit Checker')]")
	WebElement verifyUpperLimitCheckerPage;
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

	@FindBy(xpath = "//td[text()='Modify Upper Limit  Maker']")
	WebElement verifyModifyUpperLimitMakerPage;

	@FindBy(xpath = "//select[@name='modifyMandateCode']")
	WebElement selectmodifyMandateCodeInModifyPage;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitbuttonOnModify;
	// form[@name='modifyCountry']//table//tr[15]//td//input[@name='Submit']

	@FindBy(xpath = "//form[@name='modifyPaymentRoute']//table//tr[2]//td//input[@name='Submit']")
	WebElement modifysubmitbutton;
	@FindBy(xpath = "//td[@class='note']")
	WebElement verificationMessageInModifyUpperLimitPage;

	@FindBy(xpath = "//b[text()='Logout']")
	WebElement logoutMaker;

	// View Page in Checker
	//
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewInChecker;

	public UpperLimitMaker(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.waitForElement(driver, loginid, 10);
		// waitHelper.waitForElement(driver, loginid, 60);
	}

	// enter username
	public void enterloginid(String loginid) throws Exception {

		log.info("Enter Login Id in login page==" + loginid.length());
		Thread.sleep(4000);
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

// click on Upper Limit Maker SubMenu
	public void clickonUpperLimitMakerSubMenu() {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,250)", "");
		driver.switchTo().defaultContent();
		log.info("click on Upper Limit Maker SubMenu===>" + UpperLimitMakerPage.getText());
		UpperLimitMakerPage.click();
	}

// to switch the Upper Limit  Type Maker page.
	public void toswitchFieldsareinmandatory() throws Exception {
		log.info(" to switch Fields are in mandatory Page where the All the Input fields are Availabe...");
		Thread.sleep(5000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// System.out.println(" To Go to Fields are in mandatory Field=== " +
		// Fieldsareinmandatory.getText());
		// log.info(" To switch the main Enter values " +
		// Fieldsareinmandatory.getText());
	}

	static String getBDTamount;
	static String getBDTamountOnModify;

	// enter BDT amount
	public void enterBDTamount(String BDTamount) throws Exception {
		log.info("Enter BDT amount ==>>" + BDTamount.length());
		this.BDTamount.sendKeys(BDTamount);
		getBDTamount = BDTamount.toString();
		System.out.println("get BDT amount value ==>" + getBDTamount);

	}

	public void clickOnModifyButton() {
		log.info("Click On Modify button ==>");
		modifyButton.click();

	}

	// click on submit In add Payment Type Maker page
	public void clickonsubmitInMakerpage() {
		log.info("click on submit In Maker page==>" + submitInMakerpage);
		submitInMakerpage.click();
	}

//  to verify the Successful Message to the Added The Upper Limit  Maker Successfully
	public void verifySuccesfullMessage() {

		String verifythemodify = SuccesfullMessage.getText();
		System.out.println("Get the verify Successful Message ==>>" + verifythemodify);
		if (verifythemodify.equals("Record has been added successfully.")) {
			log.info("Record has been added successfully.");
			log.info("Click On Log Out Button..");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();

		} else if (verifythemodify.equals("Record Already Exists")) {
			log.info("Record Already Exists");

			log.info("Click On Log Out Button..");

			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("Duplicats Record")) {
			log.info("Duplicats Record");
			log.info("Click On Log Out Button..");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();

		} else {
			log.info("Verify Message is not Matched with Value ..");
			log.info("Click On Log Out Button..");
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

	// click On Upper Limit Checker SubMenu
	public void clickOnUpperLimitCheckerSubMenu() {
		log.info("click Upper Limit Checker SubMenu..." + UpperLimitChecker.getText());
		UpperLimitChecker.click();
	}

	// verify Upper Limit Checker Page
	public void verifyUpperLimitCheckerPage() throws Exception {
		log.info("verify Upper Limit Checker Page ==>");
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		log.info("verify Upper Limit Checker Page ==>" + verifyUpperLimitCheckerPage.getText());
		String UpperLimitCheckerPage = verifyUpperLimitCheckerPage.getText();

		System.out.println("Get the Text of  Upper Limit Checker Page ==>" + UpperLimitCheckerPage);
		Assert.assertEquals("UPPER LIMIT CHECKER", UpperLimitCheckerPage);
		log.info("verified  Upper Limit Checker Page Suceessfully ==>" + UpperLimitCheckerPage);
	}

	// calling path variables and verify Add checker List in Payment routing Checker
	// page.
	public void verifyAddcheckerListOnUpperLimitCheckerpage() throws Exception {
		String BDTAmountXpath = "//table[@id='list']//tbody/tr/td[4]";
		toverifyCheckerlist(BDTAmountXpath, getBDTamount);

	}

// Calling the Generic Method to verify the List in Currency Checker page.
	private void toverifyCheckerlist(String xpathvalue, String value) throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list On Checker Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text of Checker list ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("list of Get Text of Checker page Has Matched With Value ==>" + value);

				break;
			} else {

				System.out.println("list of Get Text of Checker page Has NOT Matched With Value ==>" + value);

			}

		}

	}

	public void HandleTheDynamicVluesWithCheckbox() throws Exception {
		List<WebElement> web = driver.findElements(By.xpath("//table[@id='list']//tbody/tr/td[4]"));
		int sizeOfColumn = web.size();
		System.out.println("No of size Of unique Values =>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get Text Ofd Unique Column =>>" + name);
			if (name.contains(getBDTamount)) {
				System.out.println("Text has Mtched with unique Clomn Value" + getBDTamount);
				Thread.sleep(3000);
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i - 1).click();
				log.info("Click On Check Box With Unique values ===>" + getBDTamount);

			} else {
				System.out.println("Text has NOT Mtched with unique Clomn Value" + getBDTamount);
			}
		}

	}

	// click on submit button
	public void clickonsubmitbuttOnChackerPage() {

		// Click on Submit button Checker Page. To Select only one Checkbox
		log.info(" click on Submit button on Checker Page===>>" + SubmitbuttononChecker.getText());
		SubmitbuttononChecker.click();

	}

// to verify successful Message in Upper Limit Checker page
	public void toverifysuccessfulMessageOnCheckerPage() {
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();

		System.out.println("Get the Text of Succesfull Message After click on Submit button Checker page ==>"
				+ successfulMessageinChecker);
		log.info("successful Message in Checker ==>" + verifysuccessfulMessageinChecker.getText());
		// Assert.assertEquals(successfulMessageinChecker, "Record updated
		// successfully.");
		if (verifysuccessfulMessageinChecker.getText().equals("Record updated successfully.")) {

			log.info("Successfully  verified the Message in Checker page ==>" + verifysuccessfulMessageinChecker);
		} else {

			log.info("Not Successfully  verified the Message in Checker page ==>" + verifysuccessfulMessageinChecker);
		}

	}

//  to go to Maker page when Checker Approved Upper Limit so click on Log out Button.
	public void gotoMakerPagewhenCheckerhasApproved() throws InterruptedException {
		driver.switchTo().defaultContent();
		log.info("Click on Logout in checker Page" + Logoutinchecker.getText());
		Logoutinchecker.click();

	}

	// View page in Maker , After Approved by the Checker data
	public void clickOnviewButtoninMakerPage() {
		log.info("click on view in Maker page ==>" + viewinMaker.getText());
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
	public void verifyViewpageBySearchField() throws InterruptedException {
		this.searchfield.clear();
		log.info("Search By BDT amount ==>" + getBDTamount);
		this.searchfield.sendKeys(getBDTamount);

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

		String Amount = "//tbody[@role='alert']//tr//td[2]";

		verifytheViewpageWithText(Amount, getBDTamount);

	}

// verify the View Maker Page with Text with thier respective Column
	public static void verifytheViewpageWithText(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list====" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text On View Page ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("List of get Text Has Matched with value ==>" + value);
				break;
			} else {

				System.out.println("List of get Text Has NOT Matched with value ==>" + value);
			}
		}

	}

// Select  All Drop down values in Maker view page when the Added Currency has Approved By Checker 
	public void selectThevaluesFromDropDownOneByOne() {
		// WebElement
		WebElement selectAmount = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectPaymentType = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectGroupId = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));

		verifyBytheDropDownlistOneByOne(selectAmount, getBDTamount);
		verifyBytheDropDownlistOneByOne(selectPaymentType, "CASHPAYOUT");
		verifyBytheDropDownlistOneByOne(selectGroupId, "RGEX");
	}

//
// select one by one of Select in View page of Maker
	public static void verifyBytheDropDownlistOneByOne(WebElement Xpathvalue, String value) {

		Select sel = new Select(Xpathvalue);
		List<WebElement> N = sel.getOptions();
		int Nooflist = N.size();
		System.out.println("No of list on select drop down in view page ==>" + Nooflist);
		for (int i = 0; i < N.size(); i++) {
			String listText = N.get(i).getText();
			System.out.println("Get Text of ====" + listText);
			if (N.get(i).getText().equals(value)) {
				System.out.println("List of Get Text On Drop Down Has Matched with Value ==>" + value);
				sel.selectByVisibleText(value);
				break;
			} else {

				System.out.println("List of Get Text On Drop Down Has NOT Matched with Value ==>" + value);

			}
		}

	}

//switch view page to Maker page and click on Modify button.
//verify Modify Upper Limit Maker Page
	public void switchViewPageToMakerPageAndClickOnModifyButtonAndVerifyModifyMakerPage() {

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
		// WebElement Fieldsareinmandatory =
		// driver.findElement(By.xpath("//*[text()='Fields in ']"));
		// System.out.println(" To Go to Fields are in mandatory Field=== " +
		// Fieldsareinmandatory.getText());

		log.info("click on Modify Button==>" + ModifyButton.getText());
		ModifyButton.click();

		log.info(" Get the Text of Modify Upper Limit Maker Page ==>" + verifyModifyUpperLimitMakerPage.getText());
		Assert.assertEquals(verifyModifyUpperLimitMakerPage.getText(), "MODIFY UPPER LIMIT MAKER");
		log.info("Successfully verified the Modify Upper Limit Maker Page ==>");

	}

	// enter BDT Amount On Modify Upper Limit Maker Page
	public void enterBDTAmoutInModifyUpperLimiMakerMakerPage() {
		driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		log.info("Enter BDT amount On Modify Page ==>>" + getBDTamount.length());
		BDTamount.sendKeys(getBDTamount);
		getBDTamountOnModify = getBDTamount.toString();
		System.out.println("get BDT amount On Modify value ==>" + getBDTamountOnModify);

	}

	// submit button on Modify maker page
	public void clickOnsubmitbutton() {
		log.info("Click on submit button" + submitbuttonOnModify.getText());
		submitbuttonOnModify.click();

	}

	// click on modify submit button in Modify maker page
	public void clickmodifysubmitbutton() {
		// driver.switchTo().defaultContent();
		log.info(" click on modify submit button==>" + modifysubmitbutton.getText());
		modifysubmitbutton.click();
	}

	// verification Message In Modify Upper Limit Page
	public void verificationMessageInModifyUpperLimitPageAndClcickOnLogOut() throws Exception {
		log.info("Get the Text Of Verification Message In Modify Upper Limit Page ==>"
				+ verificationMessageInModifyUpperLimitPage.getText());
		// Assert.assertEquals(verificationMessageInModifyEntityType.getText(), "Record
		// has been modified successfully.");

		// verification Message In Modify Payment Type Page
		String verifythemodify = verificationMessageInModifyUpperLimitPage.getText();
		System.out.println("Get the Text Of Verification Message In Modify Upper Limit Page ==>" + verifythemodify);
		if (verifythemodify.equals("Record has been modified successfully.")) {
			log.info("Record has been modified successfully.");

			Thread.sleep(4000);
			driver.switchTo().defaultContent();
			log.info("Click On Log  Out Button ..");
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("This Mandate Type name has already used.")) {
			log.info("This Country Code has already used");
			log.info("Click On Log  Out Button ..");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else {
			log.info("Get the Text Of Verification Message Has Not matched ==>"
					+ verificationMessageInModifyUpperLimitPage);
			Thread.sleep(5000);
			log.info("Click On Log  Out Button ..");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		}

	}

	// verify the Payment Routing checker List IF Modification has Done By Maker
	// with Existing Entity
	//
	public void verifyListOfUpperLimitIncheckerWhenModificationhasDoneByMaker() throws InterruptedException {
		String Amount = "//table[@id='list']//tbody/tr/td[4]";

		toverifyCheckerlistWhenModifiedMaker(Amount, getBDTamount);

	}

	// Calling the Generic Method to verify the List in Entity Type Checker page.
	private void toverifyCheckerlistWhenModifiedMaker(String xpathvalue, String value) throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list On Checker Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("Get List of Text On Checker Page ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("List Of Get Text Checker Page Has Matched With Value ==>" + value);

				break;
			} else {

				System.out.println("List Of Get Text Checker Page Has NOT Matched With Value ==>" + value);

			}

		}

	}

	public void selectThecheckboxOnCheckerPageWhenModifyMakerDaata() {
		String BDTAmount = "//table[@id='list']//tbody/tr/td[4]";
		selectThecheckboxOnCheckerPageWhenModify(BDTAmount, getBDTamount);
	}

	public void selectThecheckboxOnCheckerPageWhenModify(String xpathvalue, String value) {

		List<WebElement> web = driver.findElements(By.xpath(xpathvalue));
		int sizeOfColumn = web.size();
		System.out.println("size Of Unique Value Column ==>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get Text of Unique Value Colmn ==>" + name);
			if (name.contains(value)) {
				System.out.println("Get Text of Unique Value Colmn Has Matched With Value ==>" + value);
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				log.info("Click on Checkox with Matched Text ==>");

				break;
			} else {
				System.out.println("Get Text of Unique Value Colmn Has NOT Matched With Value ==>" + value);
			}
		}

	}

//in view Page , search by different values passing into search box,
//refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
	// 2. when the Modified the Upper Limit Maker then "View" page Maker
	public void verifyViewpageBySearchFieldWhenModifyAndApprovedDoneByChecker() throws InterruptedException {
		this.searchfield.clear();
		log.info("Search By BDT amount ==>" + getBDTamount);
		this.searchfield.sendKeys(getBDTamount);

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
	public void toVerifyTextInViewMakerPagewhenModified() {

		String BDTAmount = "//tbody[@role='alert']//tr//td[2]";

		verifyTheMakerViewPageWhenModified(BDTAmount, getBDTamount);

	}

// 
// verify the View Maker Page with Text with thier respective Column
	public static void verifyTheMakerViewPageWhenModified(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list On View Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("List Of Get Text of View page To verify Text  ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("List Of Get Text of View page MAtched With Value ==>" + value);
				break;
			} else {

				System.out.println("List Of Get Text of View page Has NOT MAtched With Value ==>" + value);
			}
		}

	}

// To verify  By  All Select Filter Or To Verify the Modify Data in Maker View Page By Using Drop Down
// select All values One By One
//  5 drop down are available on the 
	public void verifySelectDropDonOnViewMakerPageWhenModifiedData() {
		// WebElement
		WebElement selectBDTAmount = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));

		verifySelectDropDonInViewMakerPageWhenModified(selectBDTAmount, getBDTamount);

	}

//
// select one by one of Select in View page of Maker
// 4 drop down using one by one select the values from drop down
	public static void verifySelectDropDonInViewMakerPageWhenModified(WebElement xpathvalue, String value) {

		Select sel = new Select(xpathvalue);
		List<WebElement> N = sel.getOptions();
		int Nooflist = N.size();
		System.out.println("No of list On Drop DOwn Value On View Page ==>" + Nooflist);
		for (int i = 0; i < N.size(); i++) {
			String listText = N.get(i).getText();
			System.out.println("List Of  Get Text On drop down On View Page ==>" + listText);
			if (N.get(i).getText().equals(value)) {
				System.out.println("List of Get Text Oon drop Down Has  Matched with value ==>" + value);
				sel.selectByVisibleText(value);
				break;
			} else {

				System.out.println("List of Get Text Oon drop Down Has NOT Matched with value ==>" + value);

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
		// WebElement Fieldsareinmandatory =
		// driver.findElement(By.xpath("//*[text()='Fields in ']"));

		// System.out.println(" To Go to Fields are in mandatory Field=== " +
		// Fieldsareinmandatory.getText());

		log.info("click on Modify Button==>" + ModifyButton.getText());
		ModifyButton.click();

		log.info(" Get the Text of Modify Upper Limit Maker Page =>>" + verifyModifyUpperLimitMakerPage.getText());
		Assert.assertEquals(verifyModifyUpperLimitMakerPage.getText(), "MODIFY UPPER LIMIT MAKER");
		log.info(" Successfully verified the Modify Upper Limit Maker Page ==>");
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

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");

		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//b[text()='Logout']")).click();

	}
}
