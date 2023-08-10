package com.hybridFramework.PagesOfCorporateDefinitionMaker;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.helper.Wait.WaitHelper;

public class CorporatePoolAccountDetailsMaker {
	static WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(CorporatePoolAccountDetailsMaker.class);
	WaitHelper waitHelper;

	@FindBy(id = "userId")
	WebElement loginid;

	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "toggle")
	WebElement login;
	@FindBy(xpath = "//*[text()='Prime Last Mile']")
	WebElement mainheader;

	/*************************** Maker X path ****************************/
	@FindBy(xpath = "//*[text()='Corporate Definition Maker']//parent::a")
	WebElement CorporateDefinitionMaker;
	@FindBy(xpath = "//*[text()='Corporate Pool Account Details Maker']//parent::a")
	WebElement CorporatePoolAccountDetailsMaker;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;

	@FindBy(xpath = "//input[@name='poolAccHolderName']")
	WebElement poolAccHolderName;
	@FindBy(xpath = "//input[@name='poolAccNumber']")
	WebElement debitaccountnumber;
	@FindBy(xpath = "//select[@name='disbCurrency']")
	WebElement selectCurrency;
	@FindBy(xpath = "//select[@name='poolAccType']")
	WebElement debitAccountType;
	@FindBy(xpath = "//input[@name='poolBankRouting']")
	WebElement debitcorresspondentbankroutingno;
	@FindBy(xpath = "//input[@name='poolAccBankBranch']")
	WebElement debitcorresspondentbankBranch;
	@FindBy(xpath = "//input[@name='commissionAccNumber']")
	WebElement commissionAccNumber;

	@FindBy(xpath = "//select[@name='isActive']")
	WebElement isActivePoolAccountDetails;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//b[text()='Logout']")
	WebElement LogoutOnMaker;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
	/***** ********************** Statrted Checker X-path *****/

	@FindBy(xpath = "//*[text()='Corporate Definition Checker']")
	WebElement CorporateDefinitionChecker;
	@FindBy(xpath = "//*[text()='Authoriser Corporate Pool Account Details']//parent::a")
	WebElement AuthoriserCorporatePoolAccountDetails;
	@FindBy(xpath = "//td[contains(text(),'Corporate Account Details Checker')]")
	WebElement verifyCorporateAccountDetailsChecker;
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

	@FindBy(xpath = "//*[text()='Modify Corporate Account Details Maker']")
	WebElement verifyModifyCorporateAccountDetailsMakerPage;

	@FindBy(xpath = "//select[@name='countryCode']")
	WebElement selectCountryCodeInModifyPage;
	// Entity Type Id Or Corporate Id
	@FindBy(xpath = "//select[@name='entityId']")
	WebElement selectentityTypeIdInModifyPage;
	@FindBy(xpath = "//select[@name='currency']")
	WebElement selectcurrencyInModifyPage;

	@FindBy(name = "Submit")
	WebElement submitbuttonModifyMaker;
	@FindBy(xpath = "//form[@name='modifyCorporateAccountDetail']//table//tr[49]//input[@name='Submit']")
	WebElement modifysubmitbutton;
	@FindBy(xpath = "//td[@class='note']")
	WebElement verificationMessageInModifyCountry;

	@FindBy(xpath = "//b[text()='Logout']")
	WebElement logoutMaker;

	// View Page in Checker
	//
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewInChecker;

	public CorporatePoolAccountDetailsMaker(WebDriver driver) {
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

// click on Corporate Definition Maker Menu
	public void clickonCorporateDefinitionMakerMenu() {
		log.info("click on Corporate Definition Maker Menu ==>" + CorporateDefinitionMaker.getText());
		CorporateDefinitionMaker.click();
	}

// click on Corporate Pool Account Details Maker SubMenu
	public void clickonCorporatePoolAccountDetailsMakerSubMenu() {
		log.info("click on Corporate Pool Account Details Maker SubMenu ==>>"
				+ CorporatePoolAccountDetailsMaker.getText());
		CorporatePoolAccountDetailsMaker.click();
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

	static List<String> groupcountryList;
	static String y;
	static String groupidString;
	static String GetTextOfGroupCountry;
	// Means Entity Type Id
	static String splitvaluesofCorporateIDAsEntityID;
	static String splitvaluesofCorporateIDAsEntityType;
	String GroupId = "RGEX";
	String CountryCode1 = "BD";
	static String getpoolAccHolderName;
	static String getdebitaccountnumber;
	static String getCurrency;
	static String getAccountType;
	static String getdebitcorresspondentbankroutingno;
	static String getdebitcorresspondentbankBranch;
	static String getcommissionAccNumber;
	static String getisActivePoolAccountDetails;

	public void selectGroupCountry() throws Exception {

		String[] groupCountry = { "Bangladesh", "yhjgh" };
		// Thread.sleep(3000);
		System.out.println("Get the Text of String [] Array Before ==> " + groupCountry);
		groupcountryList = Arrays.asList(groupCountry);
		groupidString = String.join(",", groupcountryList);
		System.out.println("Get String Value of country code" + groupidString);

		methodofGroupCountry(driver, groupidString);

	}

	public static void methodofGroupCountry(WebDriver driver, String value) throws Exception {
		int j = 0;
		Thread.sleep(5000);
		Select selectGroupCountry = new Select(driver.findElement(By.xpath("//select[@name='countryCode']")));
		List<WebElement> listOfGroupCountry = selectGroupCountry.getOptions();
		int getSizeOfGroupCountry = listOfGroupCountry.size();
		System.out.println("Get Size Of Group Country===>>" + getSizeOfGroupCountry);

		for (int i = 0; i < listOfGroupCountry.size(); i++) {
			GetTextOfGroupCountry = listOfGroupCountry.get(i).getText();
			System.out.println("Get Text Of Group Country ==>" + GetTextOfGroupCountry);

			for (String w : value.trim().split(",")) {
				// System.out.println("Get String values ==>>" + w);
				y = w.toString();
				System.out.println("global variable declearation ==>" + y);
				if (y.equals(GetTextOfGroupCountry)) {
					System.out.println("Text has Matched with String Array and Drop Down Values ==>" + y);

					// System.out.println("Get String values Matched with value and selected ==>>" +
					// w.toString());
					selectGroupCountry.selectByVisibleText(GetTextOfGroupCountry);
					log.info("drop down has selected");

					break;
				}

				else {
					System.out.println("Text has NOT Matched with String Array and Drop Down Values ==>" + y);
				}

			}
		}

	}

	public void CorporateIDFromDropDownByUsingStringArray() throws Exception {
		// 1121-109ak , 1302-CCD , ,6786786-Prime Bank Ltd ,567866-prime
		String[] itemsNeeded1 = { "1162-QA_PRIME", "1141-PBNK01" };
		// Thread.sleep(5000);
		addItems1(driver, itemsNeeded1);
	}

	public static void addItems1(WebDriver driver, String[] itemsNeeded1) throws Exception {
		int j = 0;
		// Thread.sleep(5000);
		Select sel = new Select(driver.findElement(By.xpath("//select[@name='entityId']")));
		List<WebElement> products1 = sel.getOptions();
		int aa = products1.size();
		System.out.println("Get No of Size of Drop Down ==>" + aa);

		for (int i = 1; i <= products1.size(); i++)

		{

			String formattedName = products1.get(i).getText();

			System.out.println("Get formattedName" + formattedName);

			String[] splt = formattedName.split("-");
			splitvaluesofCorporateIDAsEntityID = splt[0].trim();
			System.out.println("split values of Corporate Id Drop Down Values As Entity Id ==>"
					+ splitvaluesofCorporateIDAsEntityID);

			String[] entityType = formattedName.split("-");
			splitvaluesofCorporateIDAsEntityType = entityType[1].trim();
			System.out
					.println("split values of Corporate Id As Entity Type ==>" + splitvaluesofCorporateIDAsEntityType);

			List<String> itemsNeededList1 = Arrays.asList(itemsNeeded1);
			System.out.println("Get the Text in Array List" + itemsNeededList1);

			if (itemsNeededList1.contains(formattedName))

			{
				System.out.println("Text has Matched with drop down values ==>");

				j++;
				Thread.sleep(5000);
				// sel.selectByVisibleText(formattedName);
				sel.selectByIndex(i);
				if (j == itemsNeeded1.length)

				{

					break;

				} else {

					System.out.println("Text has NOT Matched with drop down values");
				}
				break;
			}

		}

	}

	public void enterpoolAccHolderName(String poolAccHolderName) {
		log.info(" enter agreement Label ===>" + poolAccHolderName);
		this.poolAccHolderName.sendKeys(poolAccHolderName);
		getpoolAccHolderName = poolAccHolderName.toString();
		System.out.println("get pool Account Holder Name value ==>" + getpoolAccHolderName);

	}

	public void enterdebitaccountnumber(String debitaccountnumber) {
		log.info("enter alert Mail ==>" + debitaccountnumber);
		this.debitaccountnumber.sendKeys(debitaccountnumber);
		getdebitaccountnumber = debitaccountnumber.toString();
		System.out.println("get debit account number value ==>" + getdebitaccountnumber);

	}

	public void selectCurrencyDropDown() {
		String Currency = "BDT";
		getCurrency = Currency.toString();
		System.out.println("get Currency Value ==> " + getCurrency);
		Select selCurrency = new Select(selectCurrency);
		selCurrency.selectByVisibleText(Currency);
	}

	public void selectdebitAccountTypeDropDown() {
		String AccountType = "Vostro";
		getAccountType = AccountType.toString();
		System.out.println("get Currency Value ==> " + getAccountType);
		Select selCurrency = new Select(debitAccountType);
		selCurrency.selectByVisibleText(AccountType);
	}

	// get debit corresspondent bank routing number means Bank IFC Code
	public void enterdebitcorresspondentbankroutingno(String debitcorresspondentbankroutingno) {
		log.info("enter debit corresspondent bank routing Number ==>" + debitcorresspondentbankroutingno);
		this.debitcorresspondentbankroutingno.sendKeys(debitcorresspondentbankroutingno);
		getdebitcorresspondentbankroutingno = debitcorresspondentbankroutingno.toString();
		System.out.println("get debit corresspondent bank routing no Value ==>" + getdebitcorresspondentbankroutingno);

	}

	public void enterdebitcorresspondentbankBranch(String debitcorresspondentbankBranch) {
		log.info("enter debit corresspondent bank Branch  ==>" + debitcorresspondentbankBranch);
		this.debitcorresspondentbankBranch.sendKeys(debitcorresspondentbankBranch);
		getdebitcorresspondentbankBranch = debitcorresspondentbankBranch.toString();
		System.out.println("get debit corresspondent bank Branch Value ==>" + getdebitcorresspondentbankBranch);

	}

	public void entercommissionAccNumber(String commissionAccNumber) {
		log.info("enter commission Account Number ==>" + commissionAccNumber);
		this.commissionAccNumber.sendKeys(commissionAccNumber);
		getcommissionAccNumber = commissionAccNumber.toString();
		System.out.println("get commission Account Number Value ==>" + getcommissionAccNumber);

	}

// select  is Active Country ? in Entity License Country Maker
	public void selectisActiveEntityLicenseCountry() {

		String s = "Active";
		String active = "Yes";
		log.info("select is Active Pool Account Details ? ==>" + isActivePoolAccountDetails);
		Select aa = new Select(isActivePoolAccountDetails);
		aa.selectByVisibleText(s);
		String getisActive = active.toString();
		System.out.println("get Is Active Pool Account Details ===>>" + getisActive);
		String[] spl = getisActive.split("es");
		System.out.println("Split Array Values of Yes ===>>" + spl);
		List<String> splitList1 = Arrays.asList(spl);
		getisActivePoolAccountDetails = String.join("", splitList1);
		System.out.println(
				"get Is Active Pool Account Details after Split (Yes) As Y==>" + getisActivePoolAccountDetails);

	}

// click on  submit In add Maker page
	public void clickonsubmitInMakerpage() {
		log.info("click on submit In Maker page==>" + submitInMakerpage);
		submitInMakerpage.click();
	}

// verify Successful Message On Maker Page
	public void verifySuccessfulMessageOnMakerPage() {

		String verifytheSuccessfulMessage = SuccesfullMessage.getText();
		System.out.println("verify the Successful Message===>>>" + verifytheSuccessfulMessage);
		if (verifytheSuccessfulMessage.equals("Country alreday defined for this Corporate.")) {
			log.info("Country alreday defined for this Corporate.");

		} else if (verifytheSuccessfulMessage.equals("This account number has been mapped to another corporate.")) {
			log.info("This account number has been mapped to another corporate.");

		} else if (verifytheSuccessfulMessage.equals("Record Already Exists")) {
			log.info("Record Already Exists");

		}
	}

	public void clickOnLogOutButton() {
		log.info("Click On Log Out Link On Maker page ==>");
		driver.switchTo().defaultContent();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", LogoutOnMaker);
		LogoutOnMaker.click();

	}

// click on Corporate Definition Checker Menu
	public void clickonCorporateDefinitionCheckerMenu() {
		log.info(" Get text of Group Master Definition Checker Menu ==>" + CorporateDefinitionChecker.getText());
		CorporateDefinitionChecker.click();

	}

	// click On Authoriser Corporate Pool Account Details SubMenu
	public void clickOnAuthoriserCorporatePoolAccountDetailsSubMenu() {
		log.info("click On Authoriser Corporate Pool Account Details Sub Menu ==>"
				+ AuthoriserCorporatePoolAccountDetails.getText());
		AuthoriserCorporatePoolAccountDetails.click();
	}

	public void verifyCorporateAccountDetailsCheckerPage() throws Exception {
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		log.info("verify Corporate Account Details Checker ==>" + verifyCorporateAccountDetailsChecker.getText());
		String CorporateAccountDetailsChecker = verifyCorporateAccountDetailsChecker.getText();

		System.out.println("Get text of Corporate Account Details Checker page ==>" + CorporateAccountDetailsChecker);
		Assert.assertEquals("CORPORATE ACCOUNT DETAILS CHECKER", CorporateAccountDetailsChecker);
	}

	public void verifyChekerPageByTextWhenAddedMaker() throws Exception {

		String GroupID = "//table[@id='list']//tbody/tr/td[4]";
		String EntityId = "//table[@id='list']//tbody/tr/td[5]";
		String DebitAccountHolderName = "//table[@id='list']//tbody/tr/td[6]";
		String DebitAccountNumber = "//table[@id='list']//tbody/tr/td[7]";
		String DisbursementCurrency = "//table[@id='list']//tbody/tr/td[8]";
		String DebitAccountType = "//table[@id='list']//tbody/tr/td[9]";
		String DebitBankIFSC = "//table[@id='list']//tbody/tr/td[10]";
		String DebitBankBranch = "//table[@id='list']//tbody/tr/td[11]";
		String CommissionAccountNumber = "//table[@id='list']//tbody/tr/td[12]";
		String CountryCode = "//table[@id='list']//tbody/tr/td[13]";
		String IsActive = "//table[@id='list']//tbody/tr/td[14]";

		toverifyCheckerlistByUsingArrayList(GroupID, GroupId);
		toverifyCheckerlistByUsingArrayList(EntityId, splitvaluesofCorporateIDAsEntityID);
		toverifyCheckerlistByUsingArrayList(DebitAccountHolderName, getpoolAccHolderName);
		toverifyCheckerlistByUsingArrayList(DebitAccountNumber, getdebitaccountnumber);
		toverifyCheckerlistByUsingArrayList(DisbursementCurrency, getCurrency);
		toverifyCheckerlistByUsingArrayList(DebitAccountType, getAccountType);
		toverifyCheckerlistByUsingArrayList(DebitBankIFSC, getdebitcorresspondentbankroutingno);
		toverifyCheckerlistByUsingArrayList(DebitBankBranch, getdebitcorresspondentbankBranch);
		toverifyCheckerlistByUsingArrayList(CommissionAccountNumber, getcommissionAccNumber);
		toverifyCheckerlistByUsingArrayList(CountryCode, CountryCode1);
		toverifyCheckerlistByUsingArrayList(IsActive, getisActivePoolAccountDetails);

	}

//Calling the Generic Method to verify the List in Country Checker page.
	private void toverifyCheckerlistByUsingArrayList(String xpathvalue, String value) throws InterruptedException {
		int j = 0;
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println(" No of list on checker Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("Get Text of  Checker Page ==>" + listText);

			if (value.contains(list1.get(i).getText())) {
				System.out.println("Get Text of  Checker list Has Matched with value ==>" + value);

			} else {

				System.out.println("Get Text of  Checker list Has NOt Matched with value ==>" + value);

			}

		}

	}

	public void HandleTheDynamicVluesWithCheckboxWhenAdded() throws Exception {
		List<WebElement> web = driver.findElements(By.xpath("//table[@id='list']//tbody/tr/td[5]"));
		int sizeOfColumn = web.size();
		System.out.println("size Of Column ==>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get Text of unique values ==>" + name);
			if (name.equals(splitvaluesofCorporateIDAsEntityID)) {
				System.out.println("Get Text has Mtched with Unique values ==>" + splitvaluesofCorporateIDAsEntityID);
				Thread.sleep(3000);
				driver.findElements(By.xpath(
						// //table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				log.info("Click On Check Box with Unique values ==>" + splitvaluesofCorporateIDAsEntityID);

			} else {
				System.out
						.println("Get Text has NOT Mtched with Unique values ==>" + splitvaluesofCorporateIDAsEntityID);
			}
		}

	}

// click on submit button And verify Succesfull Message on Checker  Page.
	public void clickonsubmitbuttonAndverifySuccesfullMessage() {

		// Click on Submit button Checker Page. To Select only one Checkbox
		log.info(" click on Submit button on Checker ==>>" + SubmitbuttononChecker.getText());
		SubmitbuttononChecker.click();
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		log.info("successful Message in Checker Page ==>" + verifysuccessfulMessageinChecker.getText());
		Assert.assertEquals(successfulMessageinChecker, "Record updated successfully.");

	}

	// go to Maker When Checker Has Approved
	public void gotoMakerWhenCheckerHasApproved() throws InterruptedException {
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
	public void verifyViewpageBySearchField() throws InterruptedException {
		this.searchfield.clear();
		log.info("search By Entity ID ==>" + splitvaluesofCorporateIDAsEntityID);
		this.searchfield.sendKeys(splitvaluesofCorporateIDAsEntityID);

		this.searchfield.clear();
		log.info("search By pool Account Holder Name ==>" + getpoolAccHolderName);
		this.searchfield.sendKeys(getpoolAccHolderName);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("search By debit account number ==>" + getdebitaccountnumber);
		this.searchfield.sendKeys(getdebitaccountnumber);
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
	public void VerifyViewPageByGetText() {
		String Groupid = "//tbody[@role='alert']//tr//td[2]";
		String EntityId = "//tbody[@role='alert']//tr//td[3]";
		String CountryCode = "//tbody[@role='alert']//tr//td[4]";
		String PoolAccountHolderName = "//tbody[@role='alert']//tr//td[5]";
		String PoolAccountHolderNumber = "//tbody[@role='alert']//tr//td[6]";
		String DisbCurrency = "//tbody[@role='alert']//tr//td[7]";
		String PoolAccountType = "//tbody[@role='alert']//tr//td[8]";
		String PoolBankRouting = "//tbody[@role='alert']//tr//td[9]";
		String ReceiverAccountNumberORcommisionAccNo = "//tbody[@role='alert']//tr//td[10]";
		String IsActive = "//tbody[@role='alert']//tr//td[11]";

		verifyTextOnViewPage(Groupid, GroupId);
		verifyTextOnViewPage(EntityId, splitvaluesofCorporateIDAsEntityID);
		verifyTextOnViewPage(CountryCode, CountryCode1);
		verifyTextOnViewPage(PoolAccountHolderName, getpoolAccHolderName);
		verifyTextOnViewPage(PoolAccountHolderNumber, getdebitaccountnumber);
		verifyTextOnViewPage(DisbCurrency, getCurrency);
		verifyTextOnViewPage(PoolAccountType, getAccountType);
		verifyTextOnViewPage(PoolBankRouting, getdebitcorresspondentbankroutingno);
		verifyTextOnViewPage(ReceiverAccountNumberORcommisionAccNo, getcommissionAccNumber);
		verifyTextOnViewPage(IsActive, getisActivePoolAccountDetails);
	}

// verify the View Maker Page with Text with thier respective Column
	public static void verifyTextOnViewPage(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list on View Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("List of Get Text On View Page ==>" + listText);
			if (value.contains(listText)) {
				System.out.println("List of Get text has Matched with value On View Page ==>" + value);
				break;
			} else {

				System.out.println("List of Get text has NOT Matched with value On View Page ==>" + value);
			}
		}

	}

// Select  All Drop down values in Maker view page when the Added Corporate Pool Account has Approved By Checker 
	public void selectAllDropDownvaluesOneByOneOnViewPage() {

		WebElement selectGroupId = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectEntityId = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectCountryCode = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectPoolAccountHolderName = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement selectPoolAccountNumber = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));
		WebElement selectCurrency = driver.findElement(By.xpath("//tfoot//tr//th[7]//select"));
		WebElement selectPoolaccountType = driver.findElement(By.xpath("//tfoot//tr//th[8]//select"));
		WebElement selectPoolBankRouting = driver.findElement(By.xpath("//tfoot//tr//th[9]//select"));
		WebElement selectReceiverAccountNumber = driver.findElement(By.xpath("//tfoot//tr//th[10]//select"));
		WebElement selectIsActive = driver.findElement(By.xpath("//tfoot//tr//th[11]//select"));

		verifyBySelectDropDown(selectGroupId, GroupId);
		verifyBySelectDropDown(selectEntityId, splitvaluesofCorporateIDAsEntityID);
		verifyBySelectDropDown(selectCountryCode, CountryCode1);
		verifyBySelectDropDown(selectPoolAccountHolderName, getpoolAccHolderName);
		verifyBySelectDropDown(selectPoolAccountNumber, getdebitaccountnumber);
		verifyBySelectDropDown(selectCurrency, getCurrency);
		verifyBySelectDropDown(selectPoolaccountType, getAccountType);
		verifyBySelectDropDown(selectPoolBankRouting, getdebitcorresspondentbankroutingno);
		verifyBySelectDropDown(selectReceiverAccountNumber, getcommissionAccNumber);
		verifyBySelectDropDown(selectIsActive, getisActivePoolAccountDetails);

	}

//
// select one by one of Select in View page of Maker
	public static void verifyBySelectDropDown(WebElement xpathvalue, String value) {
		Select sel = new Select(xpathvalue);
		List<WebElement> N = sel.getOptions();
		int Nooflist = N.size();
		System.out.println("No of list of drop down View Page ==>" + Nooflist);
		for (int i = 0; i < N.size(); i++) {
			String listText = N.get(i).getText();
			System.out.println("List Of Get Text On drop down View Page ==>" + listText);
			if (value.contains(listText)) {
				System.out.println("List of Get Text From Drop Down Has Matched with Value ==>" + value);
				sel.selectByVisibleText(value);
				break;
			} else {

				System.out.println("List of Get Text From Drop Down Has NOT Matched with Value ==>" + value);

			}
		}

	}

	public void switchtheWindowFromViewPageToModifyPageWhenViewPageHasVerifired() {

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

	}

	public void verifyTheModifiedPage() {
		driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());
		log.info("click on Modify Button ==>" + ModifyButton.getText());
		ModifyButton.click();

		log.info(" Get the Text of Modify Ppage===>>" + verifyModifyCorporateAccountDetailsMakerPage.getText());
		Assert.assertEquals(verifyModifyCorporateAccountDetailsMakerPage.getText(),
				"MODIFY CORPORATE ACCOUNT DETAILS MAKER");
	}

	// select country Code In Modify Maker Page
	//
	public void selectcountryCodeInModifyMakerPage() {

		Select selectcountryCode = new Select(selectCountryCodeInModifyPage);
		List<WebElement> AllselectcountryCode = selectcountryCode.getOptions();
		int noofCountryOnDropDown = AllselectcountryCode.size();
		System.out.println("Get the No of Country DropDown==>>" + noofCountryOnDropDown);

		for (int i = 0; i < AllselectcountryCode.size(); i++) {
			String GetTextOfAllDropDownValues = AllselectcountryCode.get(i).getText();
			System.out
					.println("List of Get Text From Drop Down Values On Modify page ==>" + GetTextOfAllDropDownValues);

			if (AllselectcountryCode.get(i).getText().equals(GetTextOfGroupCountry)) {
				log.info("List of get Text Has Matched From drop down On Modify Page ==>" + GetTextOfAllDropDownValues);

				selectcountryCode.selectByVisibleText(GetTextOfGroupCountry);
				System.out.println(
						"country Code Has Selected the From Group Country Code Drop Down ==>>" + GetTextOfGroupCountry);
				break;
			} else {
				System.out.println("country Code Has Not Selected the From Group Country Code Drop Down ==>>"
						+ GetTextOfGroupCountry);
			}
		}
	}

	public void selectCOrporateIDDropDownOnModifyPage() {
		driver.switchTo().defaultContent();
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);
		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field=== " + Fieldsareinmandatory.getText());

		Select selectentityTypeIdInModify = new Select(selectentityTypeIdInModifyPage);
		List<WebElement> AllselectentityTypeIdInModify = selectentityTypeIdInModify.getOptions();
		int noofEntityTypeIdOnDropDown = AllselectentityTypeIdInModify.size();

		System.out.println("Get the No Of Entity Type Id On Drop Down==>>" + noofEntityTypeIdOnDropDown);

		for (int i = 0; i < AllselectentityTypeIdInModify.size(); i++) {
			String GetTextOfAllDropDownValues = AllselectentityTypeIdInModify.get(i).getText();
			System.out.println("Get Text Of All DropDown Values==>" + GetTextOfAllDropDownValues);
			String[] splt = GetTextOfAllDropDownValues.split("-");
			String splivaluesCorporateTypedropdown = splt[0].trim();
			System.out.println("spli  values Corporate Type drop down ==>" + splivaluesCorporateTypedropdown);

			if (splivaluesCorporateTypedropdown.equals(splitvaluesofCorporateIDAsEntityID)) {
				log.info("drop down Value Has Matched with Eentity Type id ==>" + splitvaluesofCorporateIDAsEntityID);
				// GetTextOfAllDropDownValues OR selectByindex
				selectentityTypeIdInModify.selectByVisibleText(GetTextOfAllDropDownValues);
				System.out.println(
						"selected entity Type Id In Modify Page Drop Down ==>>" + splitvaluesofCorporateIDAsEntityID);
				break;
			} else {
				System.out.println("Not selected entity Type Id In Modify Page Drop Down ==>>"
						+ splitvaluesofCorporateIDAsEntityID);
			}
		}

	}

	public void selectcurrencyDropDownInModifyPage() {
		log.info("select currency Drop Down In Modify Page ==>");
		Select currencyInModify = new Select(selectcurrencyInModifyPage);
		currencyInModify.selectByVisibleText(getCurrency);
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

	// verification Message In Modify Maker Page
	public void verificationMessageInModifyMakerPage() {
		log.info("verification Message In Maker Page==>>" + verificationMessageInModifyCountry.getText());
		// Assert.assertEquals(verificationMessageInModifyCountry.getText(), "This
		// country name has already used.");

		String verifythemodify = verificationMessageInModifyCountry.getText();
		log.info("verify the Modify Successful Message ==>" + verifythemodify);
		if (verifythemodify.equals("This country name has already used.")) {
			log.info("Successfull Message has Matched with  Text ==>");
			log.info("Click On Log out Link On Modify Page ==>" + verifythemodify);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("This Country Code has already used.")) {
			log.info("This Country Code has already used");
			log.info("Click On Log out Link On Modify Page ==>" + verifythemodify);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("Record has been modified successfully.")) {
			log.info("Record has been modified successfully.");
			log.info("Click On Log out Link On Modify Page ==>" + verifythemodify);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();

		} else {
			log.info("Successsful Message has not Matched with value ==>" + verifythemodify);
			log.info("Click On Log out Link On Modify Page ==>" + verifythemodify);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		}

	}

	// to verify List Of Values On Checker Page When Modified Entity License
	// Corporate Country
	public void verifyCheckerPageModificationhasDoneByMaker() throws InterruptedException {

		String GroupID = "//table[@id='list']//tbody/tr/td[4]";
		String EntityId = "//table[@id='list']//tbody/tr/td[5]";
		String DebitAccountHolderName = "//table[@id='list']//tbody/tr/td[6]";
		String DebitAccountNumber = "//table[@id='list']//tbody/tr/td[7]";
		String DisbursementCurrency = "//table[@id='list']//tbody/tr/td[8]";
		String DebitAccountType = "//table[@id='list']//tbody/tr/td[9]";
		String DebitBankIFSC = "//table[@id='list']//tbody/tr/td[10]";
		String DebitBankBranch = "//table[@id='list']//tbody/tr/td[11]";
		String CommissionAccountNumber = "//table[@id='list']//tbody/tr/td[12]";
		String CountryCode = "//table[@id='list']//tbody/tr/td[13]";
		String IsActive = "//table[@id='list']//tbody/tr/td[14]";

		toverifyListOfValuesOnCheckerPageWhenModified(GroupID, GroupId);
		toverifyListOfValuesOnCheckerPageWhenModified(EntityId, splitvaluesofCorporateIDAsEntityID);
		toverifyListOfValuesOnCheckerPageWhenModified(DebitAccountHolderName, getpoolAccHolderName);
		toverifyListOfValuesOnCheckerPageWhenModified(DebitAccountNumber, getdebitaccountnumber);
		toverifyListOfValuesOnCheckerPageWhenModified(DisbursementCurrency, getCurrency);
		toverifyListOfValuesOnCheckerPageWhenModified(DebitAccountType, getAccountType);
		toverifyListOfValuesOnCheckerPageWhenModified(DebitBankIFSC, getdebitcorresspondentbankroutingno);
		toverifyListOfValuesOnCheckerPageWhenModified(DebitBankBranch, getdebitcorresspondentbankBranch);
		toverifyListOfValuesOnCheckerPageWhenModified(CommissionAccountNumber, getcommissionAccNumber);
		toverifyListOfValuesOnCheckerPageWhenModified(CountryCode, CountryCode1);
		toverifyListOfValuesOnCheckerPageWhenModified(IsActive, getisActivePoolAccountDetails);

	}

	// Calling the Generic Method to verify the List in Checker page.
	private void toverifyListOfValuesOnCheckerPageWhenModified(String xpathvalue, String value)
			throws InterruptedException {

		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list On Checker Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("List of  Get Text From  Checker Page ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Get Text of  Checker Page Has Matched with value ==>" + value);

				break;
			} else {

				System.out.println("Get Text of Checker Page Has NOt Matched with value ==>" + value);

			}

		}

	}

	public void selectThecheckboxOnCheckerPageWhenModifyMakerDaata() {
		// After Modification Column Value has changed. This is Bug on it.
		String entityTypeID = "//table[@id='list']//tbody/tr/td[5]";
		selectThecheckboxOnCheckerPageWhenModify(entityTypeID, splitvaluesofCorporateIDAsEntityID);
	}

	public void selectThecheckboxOnCheckerPageWhenModify(String xpathvalue, String value) {

		List<WebElement> web = driver.findElements(By.xpath(xpathvalue));
		int sizeOfColumn = web.size();
		System.out.println("size Of list ==>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get the Text on checker Page==>>" + name);
			if (name.contains(value)) {
				System.out.println("Get Text has Mtched with Unique value On Checker page ==>" + value);
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				log.info("Click On Check box with Unique Value matched ==>" + value);

				break;
			} else {
				System.out.println("Get Text has NOT Mtched with Unique value On Checker page ==>" + value);
			}
		}

	}

	// click on submit button And verify Succesfull Message If Modify
	public void clickonsubmitbuttonAndverifySuccesfullMessageIfModify() {

		// Click on Submit button Checker Page. To Select only one Checkbox
		log.info(" click on Submit button on Checker===>>" + SubmitbuttononChecker.getText());
		SubmitbuttononChecker.click();
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		log.info("successful Message in Checker====" + verifysuccessfulMessageinChecker.getText());
		Assert.assertEquals(successfulMessageinChecker, "Record updated successfully.");

		if (verifysuccessfulMessageinChecker.getText().equals("Record updated successfully.")) {
			log.info("Record updated successfully. On checker page");
		} else {
			log.info("Record updated successfully. Not verify on checker page");
		}
	}

//in view Page , search by different values passing into search box,
//refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
	public void verifyViewpageBySearchFieldWhenModifyThecorporatePoolAccountDetails() throws InterruptedException {
		String[] search = { getpoolAccHolderName, getdebitaccountnumber, splitvaluesofCorporateIDAsEntityID, getdebitcorresspondentbankroutingno };
		String searchList = Arrays.toString(search);
		searchList = searchList.substring(1, searchList.length() - 1);
		System.out.println("Get Text of length===>>" + searchList);
		String aa = searchList.trim();
		System.out.println(" Get Trim Text ==>" + aa);

		for (String w : searchList.trim().split(",")) {
			System.out.println("Get String values = ==>" + w);
			for (int j = 0; j < search.length; j++) {
				WebElement bb = driver.findElement(By.xpath("//input[@type='text']"));
				bb.clear();
				log.info("Clear the search field ==>" + w);

				log.info("Enter the value on search field ==>" + w);
				bb.sendKeys(w);

			}
		}

		driver.navigate().refresh();

		Select entitieslist = new Select(selectentitieslist);
		Thread.sleep(4000);
		List<WebElement> Noofentitieslist = entitieslist.getOptions();
		int nooflist = Noofentitieslist.size();
		System.out.println("No of entities list ==>>" + nooflist);
		entitieslist.selectByVisibleText("All");
		for (int i = 0; i < nooflist; i++) {
			String entitiestext = Noofentitieslist.get(i).getText();
			System.out.println("Get entities text ==>" + entitiestext);
		}

	}

//to Verify Column Text In View Page WithHeaderColumn
//x-path of view page and calling their respective variable  and verify
	public void toVerifyByGetTextInViewPageWhenModify() {

		String Groupid = "//tbody[@role='alert']//tr//td[2]";
		String EntityId = "//tbody[@role='alert']//tr//td[3]";
		String CountryCode = "//tbody[@role='alert']//tr//td[4]";
		String PoolAccountHolderName = "//tbody[@role='alert']//tr//td[5]";
		String PoolAccountHolderNumber = "//tbody[@role='alert']//tr//td[6]";
		String DisbCurrency = "//tbody[@role='alert']//tr//td[7]";
		String PoolAccountType = "//tbody[@role='alert']//tr//td[8]";
		String PoolBankRouting = "//tbody[@role='alert']//tr//td[9]";
		String ReceiverAccountNumberORcommisionAccNo = "//tbody[@role='alert']//tr//td[10]";
		String IsActive = "//tbody[@role='alert']//tr//td[11]";

		verifyViewPage(Groupid, GroupId);
		verifyViewPage(EntityId, splitvaluesofCorporateIDAsEntityID);
		verifyViewPage(CountryCode, CountryCode1);
		verifyViewPage(PoolAccountHolderName, getpoolAccHolderName);
		verifyViewPage(PoolAccountHolderNumber, getdebitaccountnumber);
		verifyViewPage(DisbCurrency, getCurrency);
		verifyViewPage(PoolAccountType, getAccountType);
		verifyViewPage(PoolBankRouting, getdebitcorresspondentbankroutingno);
		verifyViewPage(ReceiverAccountNumberORcommisionAccNo, getcommissionAccNumber);
		verifyViewPage(IsActive, getisActivePoolAccountDetails);

	}

// 
// verifytheViewMakerPagewithTextwiththierrespectiveColumn
	public static void verifyViewPage(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list On View Page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("List of Get Text From  View Page  ==>" + listText);
			if (value.contains(listText)) {
				System.out.println("List of Get Text On View Paage Has Matched With value ==>" + value);
				break;
			} else {

				System.out.println("List of Get Text On View Paage Has NOT Matched With value ==>" + value);
			}
		}

	}

// To verify  By  All Select Filter Or To Verify the Modify Data in Maker View Page By Using Drop Down
// select All values One By One
//  5 drop down are available on the 
	public void toVerifytheModifyDataInMakerViewPagByUsingDropDown() {

		WebElement selectGroupId = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectEntityId = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectCountryCode = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectPoolAccountHolderName = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement selectPoolAccountNumber = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));
		WebElement selectCurrency = driver.findElement(By.xpath("//tfoot//tr//th[7]//select"));
		WebElement selectPoolaccountType = driver.findElement(By.xpath("//tfoot//tr//th[8]//select"));
		WebElement selectPoolBankRouting = driver.findElement(By.xpath("//tfoot//tr//th[9]//select"));
		WebElement selectReceiverAccountNumber = driver.findElement(By.xpath("//tfoot//tr//th[10]//select"));
		WebElement selectIsActive = driver.findElement(By.xpath("//tfoot//tr//th[11]//select"));

		verifyBySelectDropDown(selectGroupId, GroupId);
		verifyBySelectDropDown(selectEntityId, splitvaluesofCorporateIDAsEntityID);
		verifyBySelectDropDown(selectCountryCode, CountryCode1);
		verifyBySelectDropDown(selectPoolAccountHolderName, getpoolAccHolderName);
		verifyBySelectDropDown(selectPoolAccountNumber, getdebitaccountnumber);
		verifyBySelectDropDown(selectCurrency, getCurrency);
		verifyBySelectDropDown(selectPoolaccountType, getAccountType);
		verifyBySelectDropDown(selectPoolBankRouting, getdebitcorresspondentbankroutingno);
		verifyBySelectDropDown(selectReceiverAccountNumber, getcommissionAccNumber);
		verifyBySelectDropDown(selectIsActive, getisActivePoolAccountDetails);

	}

//
// select one by one of Select in View page of Maker
	public static void verifyViewPPageBySelectDropDown(WebElement xpathvalues, String value) {
		Select sel = new Select(xpathvalues);
		List<WebElement> N = sel.getOptions();
		int Nooflist = N.size();
		System.out.println("No of list On drop down On View page  ==>" + Nooflist);
		for (int i = 0; i < N.size(); i++) {
			String listText = N.get(i).getText();
			System.out.println("List of Get Text from Drop down values On View Page ==>" + listText);
			if (value.contains(listText)) {
				System.out.println("List of Get Text from Drop down On View Page Has Matched With Value ==>" + value);
				sel.selectByVisibleText(value);
				break;
			} else {

				System.out
						.println("List of Get Text from Drop down On View Page Has NOT Matched With Value ==>" + value);

			}
		}
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
