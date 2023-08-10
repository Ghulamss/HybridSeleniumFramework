package com.hybridFramework.GroupMasterDefinitionMaker;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.helper.Wait.WaitHelper;

// AddCompanyMaker also know as Add Purpose Maker 
public class EntityPurposeMakerMapping {
	static WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(EntityPurposeMakerMapping.class);
	WaitHelper waitHelper;

	@FindBy(id = "userId")
	WebElement loginid;

	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "toggle")
	WebElement login;
	@FindBy(xpath = "//*[text()='Prime Last Mile']")
	WebElement mainheader;
	@FindBy(xpath = "//*[text()='Group Master Definition Maker']")
	WebElement GroupMasterDefinitionMaker;
	@FindBy(xpath = "//*[text()='Entity Purpose Mapping Maker']//parent::a")
	WebElement EntityPurposeMappingMaker;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;

	@FindBy(xpath = "//select[@id='isActive']")
	WebElement isActiveGroupCountryPaymentTypeMaker;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
// Statrted  Checker X-path

	@FindBy(xpath = "//*[text()='Group Master Definition Checker']")
	WebElement GroupMasterDefinitionChecker;
	@FindBy(xpath = "//*[text()='Authoriser Entity Purpose Mapping']//parent::a")
	WebElement AuthoriserEntityPurposeMapping;
	@FindBy(xpath = "//td[contains(text(),'Group Country Entity Type Purpose Checker')]")
	WebElement verifyGroupCountryEntityTypePurposeChecker;
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

	@FindBy(xpath = "//*[text()='Modify Group Country Entity Type Purpose Maker']")
	WebElement verifyModifyGroupCountryEntityTypePurposeMakerPage;

	@FindBy(xpath = "//select[@name='grpCountryCode']")
	WebElement selectgrpCountryCodeInModifyPage;

	@FindBy(xpath = "//select[@name='entityTypeId']")
	WebElement selectentityTypeIdInModifyPage;

	@FindBy(xpath = "//select[@name='purposeCode']")
	WebElement selectpurposeCodeInModifyPage;

	@FindBy(name = "Submit")
	WebElement submitbuttonModifyMaker;
	// form[@name='modifyCountry']//table//tr[15]//td//input[@name='Submit']

	@FindBy(xpath = "//form[@name='modifyGroupCountryEntityTypePurposeMaker']//table//tr[9]//td//input[@name='Submit']")
	WebElement modifysubmitbutton;
	@FindBy(xpath = "//td[@class='note']")
	WebElement verificationMessageInModifyCountry;

	@FindBy(xpath = "//b[text()='Logout']")
	WebElement logoutMaker;

	// View Page in Checker
	//
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewInChecker;

	public EntityPurposeMakerMapping(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.waitForElement(driver, loginid, 10);
		// waitHelper.waitForElement(driver, loginid, 60);
	}

// enter username
	public void enterloginid(String loginid) {
		log.info("Enter User Login Id ==>" + loginid);
		this.loginid.clear();
		this.loginid.sendKeys(loginid);
	}

	// enter password
	public void enterpassword(String password) {
		log.info("Enter password ==>" + password);
		this.password.clear();
		this.password.sendKeys(password);

	}

// click on login
	public void clickonlogin() {
		log.info("Click On Login Button ==>");
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

// clik on Group Master Definition Maker Menu
	public void clickonGroupMasterDefinitionMakerMenu() {
		log.info("clik on Group Master Definition Maker Menu==>" + GroupMasterDefinitionMaker.getText());
		GroupMasterDefinitionMaker.click();
	}

// click on Entity Purpose Mapping Maker SubMenu
	public void clickonEntityPurposeMappingMakerSubMenu() {
		log.info("click on Entity Purpose Mapping Maker SubMenu ==>" + EntityPurposeMappingMaker.getText());
		EntityPurposeMappingMaker.click();
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
	static String groupCountry;
	static String groupidString;
	static String GetTextOfGroupCountry;
	// Means Entity Type Id And Entity Description
	static String splitvaluesofgetEntityTypeIdValues;
	static String splitvaluesofEntityTypeDescriValues;
	// Means Purpose Type Id And purpose Description
	static String splitvaluesofPurposeCodeValues;
	static String splitvaluesofPurposeDescriValues;
	String GroupId = "RGEX";
	String CountryCode1 = "BD";
	static String getisActiveGroupCountryPaymentTypeMaker;

	public void selectGroupCountryDropDown() throws Exception {

		String[] groupCountry = { "Bangladesh", "yhjgh" };
		// Thread.sleep(3000);
		System.out.println("Get the Text of String [] Array Before ==>" + groupCountry);
		groupcountryList = Arrays.asList(groupCountry);
		groupidString = String.join(",", groupcountryList);
		System.out.println("Get String Value of country code" + groupidString);

		methodofGroupCountry(driver, groupidString);

	}

	public static void methodofGroupCountry(WebDriver driver, String value) throws Exception {
		int j = 0;
		Thread.sleep(5000);
		Select selectGroupCountry = new Select(driver.findElement(By.xpath("//select[@name='grpCountryCode']")));
		List<WebElement> listOfGroupCountry = selectGroupCountry.getOptions();
		int getSizeOfGroupCountry = listOfGroupCountry.size();
		System.out.println("Get Size Of Group Country ==>" + getSizeOfGroupCountry);

		for (int i = 0; i < listOfGroupCountry.size(); i++) {
			GetTextOfGroupCountry = listOfGroupCountry.get(i).getText();
			System.out.println("Get Text Of Group Country ==>" + GetTextOfGroupCountry);

			for (String w : value.trim().split(",")) {
				// System.out.println("Get String values ==>>" + w);
				groupCountry = w.toString();
				System.out.println("global variable declearation ==>" + groupCountry);
				if (groupCountry.equals(GetTextOfGroupCountry)) {
					System.out.println("Text has Matched with String Array and Drop Down Values ==>" + groupCountry);

					// System.out.println("Get String values Matched with value and selected ==>>" +
					// w.toString());
					selectGroupCountry.selectByVisibleText(GetTextOfGroupCountry);
					log.info("drop down has selected with value ==>" + groupCountry);

					break;
				}

				else {
					System.out
							.println("Text has NOT Matched with String Array and Drop Down Values ==>" + groupCountry);
				}

			}
		}

	}

	public void selectEntityTypeIdFromDropDownByUsingStringArray() throws Exception {
		// 1121-109ak ,
		String[] entityTypeDropDownNeeded = { "1324-CCCA", "CB-EB" };
		// Thread.sleep(5000);
		addItems1(driver, entityTypeDropDownNeeded);
	}

	public static void addItems1(WebDriver driver, String[] entityTypeDropDownNeeded) throws Exception {
		int j = 0;
		// Thread.sleep(5000);
		Select selEntityTypeId = new Select(driver.findElement(By.xpath("//select[@id='entityTypeId']")));
		List<WebElement> EntityTypeIdDropDown = selEntityTypeId.getOptions();
		int sizeOfEntityTypeId = EntityTypeIdDropDown.size();
		System.out.println("Get No of Size of Entity Type Id Drop Down ==>" + sizeOfEntityTypeId);

		for (int i = 1; i <= EntityTypeIdDropDown.size(); i++)

		{

			String GetTextOfEntityTypeIdDropDown = EntityTypeIdDropDown.get(i).getText();
			System.out.println("List of Get Text From Entity Type Id Drop Down ==>" + GetTextOfEntityTypeIdDropDown);

			String[] getEntityTypeId = GetTextOfEntityTypeIdDropDown.split("-");
			splitvaluesofgetEntityTypeIdValues = getEntityTypeId[0].trim();
			System.out.println(
					"split values of Entity Type Id From Drop Down Values ==>" + splitvaluesofgetEntityTypeIdValues);

			String[] paymentDes = GetTextOfEntityTypeIdDropDown.split("-");

			splitvaluesofEntityTypeDescriValues = paymentDes[1].trim();
			System.out.println("split values of Entity Type  Description From Drop Down Values ==>"
					+ splitvaluesofEntityTypeDescriValues);

			List<String> entityTypeDropDownNeededList = Arrays.asList(entityTypeDropDownNeeded);
			System.out.println(
					"Get the Text Of payment Code Drop Down List in Array List" + entityTypeDropDownNeededList);

			if (entityTypeDropDownNeededList.contains(GetTextOfEntityTypeIdDropDown))

			{
				System.out.println("Text has Matched with drop down values ==>" + GetTextOfEntityTypeIdDropDown);

				j++;
				Thread.sleep(5000);
				// sel.selectByVisibleText(formattedName);
				selEntityTypeId.selectByIndex(i);
				if (j == entityTypeDropDownNeeded.length)

				{

					break;

				} else {

					System.out
							.println("Text has NOT Matched with drop down values ==>" + GetTextOfEntityTypeIdDropDown);
				}
				break;
			}

		}

	}

	public void selectPurposeCodeFromDropDownByUsingStringArray() throws Exception {
       // CDH-EFG,CD-EF,
		String[] purposeCodeDropDownNeeded = { "CDL-EFL", "C-E" };

		addPurposeCode(driver, purposeCodeDropDownNeeded);
	}

	public static void addPurposeCode(WebDriver driver, String[] purposeCodeDropDownNeeded) throws Exception {
		int j = 0;
		// Thread.sleep(5000);
		Select selPurposeCode = new Select(driver.findElement(By.xpath("//select[@id='purposeCode']")));
		List<WebElement> purposeCodedDropDownElements = selPurposeCode.getOptions();
		int sizeOfPurposeCode = purposeCodedDropDownElements.size();
		System.out.println("Get No of Size of Purpose Code Drop Down ==>" + sizeOfPurposeCode);

		for (int i = 1; i <= purposeCodedDropDownElements.size(); i++)

		{

			String GetTextOfPurposeCodedDropDown = purposeCodedDropDownElements.get(i).getText();

			System.out.println("List of Get Text From Purpose Code Drop Down ==>" + GetTextOfPurposeCodedDropDown);

			String[] getpaymentCode = GetTextOfPurposeCodedDropDown.split("-");
			splitvaluesofPurposeCodeValues = getpaymentCode[0].trim();
			System.out
					.println("split values of Purpose Code From Drop Down Values ==>" + splitvaluesofPurposeCodeValues);

			String[] paymentDes = GetTextOfPurposeCodedDropDown.split("-");
			splitvaluesofPurposeDescriValues = paymentDes[1].trim();
			System.out.println(
					"split values of Purpose Description From Drop Down Values ==>" + splitvaluesofPurposeDescriValues);

			List<String> paymentCodeDropDownNeededList = Arrays.asList(purposeCodeDropDownNeeded);
			System.out.println(
					"Get the Text Of payment Code Drop Down List in Array List" + paymentCodeDropDownNeededList);

			if (paymentCodeDropDownNeededList.contains(GetTextOfPurposeCodedDropDown))

			{
				System.out.println("Text has Matched with drop down values ==>" + GetTextOfPurposeCodedDropDown);

				j++;
				Thread.sleep(5000);
				// sel.selectByVisibleText(formattedName);
				selPurposeCode.selectByIndex(i);
				if (j == purposeCodeDropDownNeeded.length)

				{

					break;

				} else {

					System.out
							.println("Text has NOT Matched with drop down values ==>" + GetTextOfPurposeCodedDropDown);
				}
				break;
			}

		}

	}

// select  is Active Group Country Entity Type Purpose Maker page
	public void selectisActiveGroupCountryEntityTypePurposeMaker() {

		String s = "Yes";
		log.info("select is Active Group Country Entity Type Purpose Maker ?==" + isActiveGroupCountryPaymentTypeMaker);
		Select aa = new Select(isActiveGroupCountryPaymentTypeMaker);
		aa.selectByVisibleText(s);
		String getisActive = s.toString();
		System.out.println("is Active Group Country Entity Type Purpose Maker ==>>" + getisActive);
		String[] spl = getisActive.split("es");
		System.out.println("Split Array Values of Yes ===>>" + spl);
		List<String> splitList1 = Arrays.asList(spl);
		getisActiveGroupCountryPaymentTypeMaker = String.join("", splitList1);
		System.out.println("get is Active Group Country Entity Type Purpose Maker after Split (Yes) As Y==>"
				+ getisActiveGroupCountryPaymentTypeMaker);

	}

// click on  submit In add Maker page
	public void clickonsubmitInMakerpage() {
		log.info("click on submit In Maker page==>" + submitInMakerpage);
		submitInMakerpage.click();
	}

// verify Successful Message On Maker Page
	public void verifySuccessfulMessageOnMakerPage() {

		String verifytheSuccessfulMessage = SuccesfullMessage.getText();
		System.out.println("Get Text Of verify the Successful Message ==>" + verifytheSuccessfulMessage);

		if (verifytheSuccessfulMessage.equals("Record has been added successfully.")) {
			log.info("Record has been added successfully.");
			log.info("Click On Log Out Button ");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifytheSuccessfulMessage.equals("This Country Code has already used.")) {
			log.info("This Country Code has already used.");
			log.info("Click On Log Out Button ");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifytheSuccessfulMessage.equals("This Mandate Type maaping has already used.")) {
			log.info("This Mandate Type maaping has already used.");
			log.info("Click on Log Out Button ==>");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();

		} else if (verifytheSuccessfulMessage.equals("Record Already Exists")) {
			log.info("Record Already Exists");
			log.info("Click On Log Out Button ");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
//E,Record Already Exists

		} else if (verifytheSuccessfulMessage.equals("E,Record Already Exists")) {
			log.info("E,Record Already Exists..");
			log.info("Click on Log Out Button ==>");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();

		} else {
			log.info("verified Successful Message Has Not Matched with value ==>" + verifytheSuccessfulMessage);
			log.info("Click on Log Out Button ==>");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();

		}
	}

// click on Group Master Definition Checker Menu
	public void clickonGroupMasterDefinitionCheckerMenu() {
		log.info(" Get text of Group Master Definition Checker Menu===>>" + GroupMasterDefinitionChecker.getText());
		log.info("Clcik on Group Master Definition Checker Menu====>>");
		GroupMasterDefinitionChecker.click();

	}

	// click On Authoriser Entity Purpose Mapping SubMenu
	public void clickOnAuthoriserEntityPurposeMappingSubMenu() {
		log.info("click On Authoriser Entity Purpose Mapping SubMenu ==>>" + AuthoriserEntityPurposeMapping.getText());
		AuthoriserEntityPurposeMapping.click();
	}

	// verify Group Country Entity Type Purpose Checker Page
	public void verifyGroupCountryEntityTypePurposeCheckerPage() throws Exception {
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		String GroupCountryEntityTypePurposeChecker = verifyGroupCountryEntityTypePurposeChecker.getText();

		System.out.println("Get text of verify Group Country Entity Type Purpose Checker page ==>>"
				+ GroupCountryEntityTypePurposeChecker);

		Assert.assertEquals("GROUP COUNTRY ENTITY TYPE PURPOSE CHECKER", GroupCountryEntityTypePurposeChecker);
	}

	// calling path variables and verifyAddcheckerList in Group Country Entity Type
	// Checker page.
	// using by string Array to convert into string by to string,substring,
	// trim(),split(),contains()
	public void verifyAddcheckerListByUsingArraysToStringandSubStringToString() throws InterruptedException {
		String[] strArray = { "RGEX", "hhj" };
		String newString = Arrays.toString(strArray);
		System.out.println("Get Text of Convert Arrays ToString===>>" + newString);
		newString = newString.substring(1, newString.length() - 1);
		System.out.println("New String: " + newString);

		// String[] aa = newString.trim().split(",");
		for (String w : newString.trim().split(",")) {
			System.out.println("w==" + w);
		}

		String GroupID = "//table[@id='list']//tbody/tr/td[4]";
		String CountryCode = "//table[@id='list']//tbody/tr/td[5]";
		String EntityTypeID = "//table[@id='list']//tbody/tr/td[6]";
		String IsActive = "//table[@id='list']//tbody/tr/td[7]";

		StoverifyCheckerlist(GroupID, newString);
		// StoverifyCheckerlist(CountryCode, "aaaa");
		// StoverifyCheckerlist(EntityTypeID, "bbb");
		// StoverifyCheckerlist(IsActive, "Y");

	}

// Calling the Generic Method to verify the List in Country Checker page.
	private void StoverifyCheckerlist(String xpathvalue, String value) throws InterruptedException {
		int j = 0;
		// TODO Auto-generated method stub
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("list Get Text of  Checker Page ==>" + listText);
			if (value.contains(listText)) {
				System.out.println("Get Text of  Checker list Has Matched ==>");
				j++;
				// driver.findElement(By.xpath("//input[@id='selectAll']")).click();
				if (j == value.length())

				{

					break;

				}

				break;
			} else {

				System.out.println("List Not  matched ==>");
				// driver.findElement(By.xpath("//input[@id='selectAllInValid']")).click();

			}

		}

	}

	public void verifyListOfGetTextOnAddcheckerPage() throws Exception {

		String GroupID = "//table[@id='list']//tbody/tr/td[4]";
		String CountryCode = "//table[@id='list']//tbody/tr/td[5]";
		String EntityTypeId = "//table[@id='list']//tbody/tr/td[6]";
		String EntityTypeDesc = "//table[@id='list']//tbody/tr/td[7]";
		String PurposeCode = "//table[@id='list']//tbody/tr/td[8]";
		String PurposDesc = "//table[@id='list']//tbody/tr/td[9]";
		String IsActive = "//table[@id='list']//tbody/tr/td[10]";

		toverifyCheckerlistByUsingArrayList(GroupID, GroupId);
		toverifyCheckerlistByUsingArrayList(CountryCode, CountryCode1);
		toverifyCheckerlistByUsingArrayList(EntityTypeId, splitvaluesofgetEntityTypeIdValues);
		toverifyCheckerlistByUsingArrayList(EntityTypeDesc, splitvaluesofEntityTypeDescriValues);
		toverifyCheckerlistByUsingArrayList(PurposeCode, splitvaluesofPurposeCodeValues);
		toverifyCheckerlistByUsingArrayList(PurposDesc, splitvaluesofPurposeDescriValues);
		toverifyCheckerlistByUsingArrayList(IsActive, getisActiveGroupCountryPaymentTypeMaker);

	}

//Calling the Generic Method to verify the List in Country Checker page.
	private void toverifyCheckerlistByUsingArrayList(String xpathvalue, String value) throws InterruptedException {
		int j = 0;
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list On Checker apge ===>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println("Get List of Text From checker Page ==>" + listText);

			if (value.contains(list1.get(i).getText())) {
				System.out.println("Get Text of  Checker list Has Matched with value =>>" + value);

			} else {

				System.out.println("Get Text of  Checker list Has NOt Matched with value =>>" + value);

			}

		}

	}

	public void HandleTheDynamicVluesWithCheckbox() throws Exception {
		List<WebElement> web = driver.findElements(By.xpath("//table[@id='list']//tbody/tr/td[6]"));
		int sizeOfColumn = web.size();
		System.out.println("size Of Column ==>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get Text of unique values ==>" + name);
			if (name.equals(splitvaluesofgetEntityTypeIdValues)) {
				System.out.println("Get Text has Mtched with Unique values ==>" + splitvaluesofgetEntityTypeIdValues);
				Thread.sleep(3000);
				// //table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']
				driver.findElements(By.xpath(
						"//table[@id='list']//tbody/tr/td[4]//parent::td//preceding-sibling::td[3]//input[@type='checkbox']"))
						.get(i).click();
				log.info("Click On Check Box with Unique values ==>" + splitvaluesofgetEntityTypeIdValues);

			} else {
				System.out
						.println("Get Text has NOT Mtched with Unique values ==>" + splitvaluesofgetEntityTypeIdValues);
			}
		}

	}

// click on submit button And verify Succesfull Message on Checker  Page.
	public void clickonsubmitbuttonAndverifySuccesfullMessage() {

		// Click on Submit button Checker Page. To Select only one Checkbox
		log.info(" click on Submit button on Checker ==>" + SubmitbuttononChecker.getText());
		SubmitbuttononChecker.click();
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		log.info("successful Message in Checker Page ==>" + verifysuccessfulMessageinChecker.getText());
		Assert.assertEquals(successfulMessageinChecker, "Record updated successfully.");

	}

//   go to Maker Checker Approved 

	public void gotoMakerCheckerHasApproved() throws InterruptedException {
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
		log.info("search By Group Id ==>" + GroupId);
		this.searchfield.sendKeys(GroupId);

		this.searchfield.clear();
		log.info("search By Country Code ==>" + CountryCode1);
		this.searchfield.sendKeys(CountryCode1);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("search By Entity Type Id ==>" + splitvaluesofgetEntityTypeIdValues);
		this.searchfield.sendKeys(splitvaluesofgetEntityTypeIdValues);
		this.searchfield.clear();
		log.info("search By Purpose Code ==>" + splitvaluesofPurposeCodeValues);
		this.searchfield.sendKeys(splitvaluesofPurposeCodeValues);

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
		String CountryCode = "//tbody[@role='alert']//tr//td[2]";
		String corporateTypeId = "//tbody[@role='alert']//tr//td[3]";
		String puposeCode = "//tbody[@role='alert']//tr//td[4]";
		String puposeDescripti = "//tbody[@role='alert']//tr//td[5]";
		String IsActive = "//tbody[@role='alert']//tr//td[6]";

		verifyTextOnViewPage(CountryCode, CountryCode1);
		verifyTextOnViewPage(corporateTypeId, splitvaluesofgetEntityTypeIdValues);
		verifyTextOnViewPage(puposeCode, splitvaluesofPurposeCodeValues);
		verifyTextOnViewPage(puposeDescripti, splitvaluesofPurposeDescriValues);
		verifyTextOnViewPage(IsActive, getisActiveGroupCountryPaymentTypeMaker);

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

// Select  All Drop down values in Maker view page when the Added  has Approved By Checker 
	public void selectDropDownAllvaluesOneByOne() {

		WebElement selectCountryCode = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectCorporateTypeId = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectPurposeCode = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectPurposeDesc = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement selectIsActive = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));

		verifyBySelectDropDown(selectCountryCode, CountryCode1);
		verifyBySelectDropDown(selectCorporateTypeId, splitvaluesofgetEntityTypeIdValues);
		verifyBySelectDropDown(selectPurposeCode, splitvaluesofPurposeCodeValues);
		verifyBySelectDropDown(selectPurposeDesc, splitvaluesofPurposeDescriValues);
		verifyBySelectDropDown(selectIsActive, getisActiveGroupCountryPaymentTypeMaker);

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
		log.info("click on Modify Button==>" + ModifyButton.getText());
		ModifyButton.click();

		log.info("Get the Text of Modify Ppage ==>" + verifyModifyGroupCountryEntityTypePurposeMakerPage.getText());
		log.info("Successfully verified Modify Group Country Entity Type Purpose Maker Page ==>");
		Assert.assertEquals(verifyModifyGroupCountryEntityTypePurposeMakerPage.getText(),
				"MODIFY GROUP COUNTRY ENTITY TYPE PURPOSE MAKER");
	}

	// select Group Country Entity Type Purpose Code In Modify Maker Page
	public void selectcountryCodeInModifyMakerPage() {
		driver.switchTo().defaultContent();
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);
		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));

		System.out.println(" To Go to Fields are in mandatory Field ==>" + Fieldsareinmandatory.getText());

		Select selectcountryCode = new Select(selectgrpCountryCodeInModifyPage);

		List<WebElement> AllselectcountryCode = selectcountryCode.getOptions();
		int noofCountryOnDropDown = AllselectcountryCode.size();
		System.out.println("Get the No of Country Drop Down ==>" + noofCountryOnDropDown);

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

	public void selectPEntityTypeTypeDropDownOnModifyPage() {

		Select selectEntityTypeIdInModify = new Select(selectentityTypeIdInModifyPage);
		List<WebElement> EntityTypeIdInModify = selectEntityTypeIdInModify.getOptions();
		int noofEntityTypeIdOnDropDown = EntityTypeIdInModify.size();

		System.out.println("Get the No Of Entity Type Id On Drop Down==>>" + noofEntityTypeIdOnDropDown);

		for (int i = 0; i < EntityTypeIdInModify.size(); i++) {
			String GetTextOfAllDropDownValues = EntityTypeIdInModify.get(i).getText();
			System.out.println("Get Text Of All Drop Down Values==>" + GetTextOfAllDropDownValues);
			String[] splt = GetTextOfAllDropDownValues.split("-");
			String splivaluesOfEntityTypeIddropdown = splt[0].trim();
			System.out.println("spli  value Entity Type Id drop down ==>" + splivaluesOfEntityTypeIddropdown);

			if (splivaluesOfEntityTypeIddropdown.equals(splitvaluesofgetEntityTypeIdValues)) {
				log.info("drop down Value Has Matched with Entity Type id ==>" + splitvaluesofgetEntityTypeIdValues);
				// GetTextOfAllDropDownValues OR selectByindex
				selectEntityTypeIdInModify.selectByVisibleText(GetTextOfAllDropDownValues);
				System.out.println(
						"selected Entity Type Id In Modify Page Drop Down ==>>" + splitvaluesofgetEntityTypeIdValues);
				break;
			} else {
				System.out.println("Not selected Entity Type Id In Modify Page Drop Down ==>>"
						+ splitvaluesofgetEntityTypeIdValues);
			}
		}

	}

	public void selectPurposeCodeDropDownOnModifyPage() {

		Select selectPurposeCodeInModify = new Select(selectpurposeCodeInModifyPage);
		List<WebElement> PurposeCodeInModify = selectPurposeCodeInModify.getOptions();
		int noofPurposeCodeInModify = PurposeCodeInModify.size();

		System.out.println("Get the No Of Purpose Code On Drop Down==>>" + noofPurposeCodeInModify);

		for (int i = 1; i <= PurposeCodeInModify.size(); i++) {
			String GetTextOfPurposeCodeInModify = PurposeCodeInModify.get(i).getText();
			System.out.println("Get Text Of All Drop Down Values ==>" + GetTextOfPurposeCodeInModify);
			String[] splt = GetTextOfPurposeCodeInModify.split("-");
			String splitvaluesOfPurposeCodedropdown = splt[0].trim();
			System.out.println("split  value Purpose Code drop down ==>" + splitvaluesOfPurposeCodedropdown);

			if (splitvaluesOfPurposeCodedropdown.equals(splitvaluesofPurposeCodeValues)) {
				log.info("drop down Value Has Matched with Purpose Code ==>" + splitvaluesofPurposeCodeValues);
				// GetTextOfAllDropDownValues OR selectByindex
				selectPurposeCodeInModify.selectByVisibleText(GetTextOfPurposeCodeInModify);
				System.out.println(
						"selected Purpose Code In Modify Page Drop Down ==>>" + splitvaluesofPurposeCodeValues);
				break;
			} else {
				System.out.println(
						"Not selected Purpose Code In Modify Page Drop Down ==>>" + splitvaluesofPurposeCodeValues);
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

	// verification Message In Modify Group Country Payment Type Maker Page
	public void verificationMessageInModifyGroupCountryPaymentTypeMakerPage() {
		log.info("verification Message In Modify Group Country Entity Type Maker Page==>>"
				+ verificationMessageInModifyCountry.getText());
		// Assert.assertEquals(verificationMessageInModifyCountry.getText(), "This
		// country name has already used.");

		// verification Message In Modify Country
		String verifythemodify = verificationMessageInModifyCountry.getText();
		System.out.println("verify the Modify Successful Message===>>>" + verifythemodify);
		log.info("verify the Modify Successful Message===>>>" + verifythemodify);
		if (verifythemodify.equals("This country name has already used.")) {
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
			log.info("Successsful Message has not Matched..");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		}

	}

	// to verify List Of Values On Checker Page When Modified
	//
	public void verifyGroupCountryEntityTypePurposeCheckerPageModificationhasDoneByMaker() throws InterruptedException {

		String GroupID = "//table[@id='list']//tbody/tr/td[4]";
		String CountryCode = "//table[@id='list']//tbody/tr/td[5]";
		String EntityTypeId = "//table[@id='list']//tbody/tr/td[6]";
		String EntityTypeDesc = "//table[@id='list']//tbody/tr/td[7]";
		String PurposeCode = "//table[@id='list']//tbody/tr/td[8]";
		String PurposDesc = "//table[@id='list']//tbody/tr/td[9]";
		String IsActive = "//table[@id='list']//tbody/tr/td[10]";

		toverifyListOfValuesOnCheckerPageWhenModified(GroupID, GroupId);
		toverifyListOfValuesOnCheckerPageWhenModified(CountryCode, CountryCode1);
		toverifyListOfValuesOnCheckerPageWhenModified(EntityTypeId, splitvaluesofgetEntityTypeIdValues);
		toverifyListOfValuesOnCheckerPageWhenModified(EntityTypeDesc, splitvaluesofEntityTypeDescriValues);
		toverifyListOfValuesOnCheckerPageWhenModified(PurposeCode, splitvaluesofPurposeCodeValues);
		toverifyListOfValuesOnCheckerPageWhenModified(PurposDesc, splitvaluesofPurposeDescriValues);
		toverifyListOfValuesOnCheckerPageWhenModified(IsActive, getisActiveGroupCountryPaymentTypeMaker);

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

				System.out.println("Get Text of  Checker Page Has NOt Matched with value ==>" + value);

			}

		}

	}

	public void selectThecheckboxOnCheckerPageWhenModifyMakerDaata() {
		// After Modification Column Value has changed. This is Bug on it.
		String EntityTypeID = "//table[@id='list']//tbody/tr/td[6]";
		selectThecheckboxOnCheckerPageWhenModify(EntityTypeID, splitvaluesofgetEntityTypeIdValues);
	}

	public static void selectThecheckboxOnCheckerPageWhenModify(String xpathvalue, String value) {

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

	// click on submit button And verify Succesfull Message If Modify Group Country
	// Payment Type
	public void clickonsubmitbuttonAndverifySuccesfullMessageIfModify() {

		// Click on Submit button Checker Page. To Select only one Checkbox
		log.info("click on Submit button on Checker ==>>" + SubmitbuttononChecker.getText());
		SubmitbuttononChecker.click();
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		log.info("successful Message in Checker====" + verifysuccessfulMessageinChecker.getText());
		Assert.assertEquals(successfulMessageinChecker, "Record updated successfully.");

		if (verifysuccessfulMessageinChecker.getText().equals("Record updated successfully.")) {
			log.info("Record updated successfully.");
		} else {
			log.info("Record Has Not updated successfully.");
		}

	}

//in view Page , search by different values passing into search box,
//refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
	public void verifyViewpageBySearchFieldWhenModifyTheEntityTypeMapping() throws InterruptedException {
		String[] search = { GetTextOfGroupCountry, splitvaluesofgetEntityTypeIdValues, splitvaluesofPurposeCodeValues,
				getisActiveGroupCountryPaymentTypeMaker };
		String searchList = Arrays.toString(search);
		searchList = searchList.substring(1, searchList.length() - 1);
		System.out.println("Get Text of length ==>>" + searchList);
		String aa = searchList.trim();
		System.out.println("Get Trim Text ==>>" + aa);

		for (String w : searchList.trim().split(",")) {
			System.out.println("Get String values===>>" + w);
			for (int j = 0; j < search.length; j++) {
				WebElement bb = driver.findElement(By.xpath("//input[@type='text']"));
				bb.clear();
				log.info("Clear the search field ==>");

				log.info("Enter the value on search field ==>");
				bb.sendKeys(w);

			}
		}

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
	public void toVerifyGetTextInViewPageWhenModify() {

		String CountryCode = "//tbody[@role='alert']//tr//td[2]";
		String corporateTypeId = "//tbody[@role='alert']//tr//td[3]";
		String puposeCode = "//tbody[@role='alert']//tr//td[4]";
		String puposeDescripti = "//tbody[@role='alert']//tr//td[5]";
		String IsActive = "//tbody[@role='alert']//tr//td[6]";

		verifyViewPageByText(CountryCode, CountryCode1);
		verifyViewPageByText(corporateTypeId, splitvaluesofgetEntityTypeIdValues);
		verifyViewPageByText(puposeCode, splitvaluesofPurposeCodeValues);
		verifyViewPageByText(puposeDescripti, splitvaluesofPurposeDescriValues);
		verifyViewPageByText(IsActive, getisActiveGroupCountryPaymentTypeMaker);

	}

// verify the View Maker Page with Text with thier respective Column
	public static void verifyViewPageByText(String xpathvalue, String value) {
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

		WebElement selectCountryCode = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement selectCorporateTypeId = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement selectPurposeCode = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement selectPurposeDesc = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement selectIsActive = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));

		verifyViewPPageBySelectDropDown(selectCountryCode, CountryCode1);
		verifyViewPPageBySelectDropDown(selectCorporateTypeId, splitvaluesofgetEntityTypeIdValues);
		verifyViewPPageBySelectDropDown(selectPurposeCode, splitvaluesofPurposeCodeValues);
		verifyViewPPageBySelectDropDown(selectPurposeDesc, splitvaluesofPurposeDescriValues);
		verifyViewPPageBySelectDropDown(selectIsActive, getisActiveGroupCountryPaymentTypeMaker);

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
