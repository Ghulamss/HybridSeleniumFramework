package com.hybridFramework.PagesOfGroupUserDefinition;

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

public class CreateGroupUser {
	static WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(CreateGroupUser.class);
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
	@FindBy(xpath = "//*[text()='Group User Definition']//parent::a")
	WebElement GroupUserDefinition;
	@FindBy(xpath = "//*[text()='Create Group User']//parent::a")
	WebElement CreateGroupUser;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;

	@FindBy(xpath = "//select[@name='roleType']")
	WebElement selectRoleType;
	@FindBy(xpath = "//select[@name='userType']")
	WebElement selectCompany;
	@FindBy(xpath = "//select[@id='roleId']")
	WebElement selectRole;
	//  (//div[@class='ms-options-wrap']//button)[1]
	@FindBy(xpath = "//select[@id='roleId']//following-sibling::div")
	WebElement clickOnRoleId;
	
	@FindBy(xpath = "//div[@class='ms-options']//ul//li//label")
	List<WebElement> selectRoleIdByList;
	@FindBy(xpath = "//input[@name='bankBranch']")
	WebElement bankBranch;
	@FindBy(xpath = "//select[@id='entityId']//following-sibling::div")
	WebElement clickOnCorporateId;
	@FindBy(xpath = "//div[@class='ms-options']//ul//li//label")
	List<WebElement> selectCorporateID;
	
	@FindBy(xpath = "//input[@name='frmLoginId']")
	WebElement LoginId;
	@FindBy(xpath = "//input[@name='emailId']")
	WebElement emailId;
	@FindBy(xpath = "//input[@name='alternateEmailId']")
	WebElement alternateEmailId;
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;
	@FindBy(xpath = "//input[@name='middleName']")
	WebElement middleName;
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastName;
	@FindBy(xpath = "//input[@name='mobile']")
	WebElement mobileNumber;
	@FindBy(xpath = "//input[@name='employeeId']")
	WebElement employeeId;
	@FindBy(xpath = "//select[@name='uniqueIdentifierType']")
	WebElement selectuniqueIdentifierType;
	@FindBy(xpath = "//input[@name='uniqueIdentifierValue']")
	WebElement uniqueIdentifierValue;
	@FindBy(xpath = "//a[contains(text(),'click here')]")
	WebElement clickhereLink;
	@FindBy(xpath = "//input[@name='uniqueIdfileName']")
	WebElement uniqueIdfileName;
	
	@FindBy(xpath = "//select[@name='isActive']")
	WebElement isActiveCorporateUser;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//b[text()='Logout']")
	WebElement LogoutOnMaker;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
	/***** ********************** Statrted Checker X-path *****/

	@FindBy(xpath = "//*[text()='Group User Definition Checker']")
	WebElement GroupUserDefinitionChecker;
	@FindBy(xpath = "//*[text()='Authorize Create User']//parent::a")
	WebElement AuthorizeCreateUser;
	@FindBy(xpath = "//*[text()='Authorize Create Group User ']//parent::td")
	WebElement verifyAuthorizeCreateGroupUserPage;
	@FindBy(xpath = "//*[text()='Field in ']")
	WebElement FieldareinmandatoryOnChecker;
	@FindBy(xpath = "//select[@name='roleType']")
	WebElement roleTypeOnCheckerPage;
	@FindBy(xpath = "//select[@name='roleId']")
	WebElement roleOnCheckerPage;
	@FindBy(xpath = "//select[@name='frmLoginId']")
	WebElement frmLoginIdOnCheckerPage;
	
	@FindBy(xpath = "//input[@name='emailId']")
	WebElement emailIdOnCheckerPage;
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstNameOnCheckerPage;
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastNameOnCheckerPage;
	@FindBy(xpath = "//input[@name='mobile']")
	WebElement mobileNOOnCheckerPage;
	
	@FindBy(xpath = "//input[@name='accept']")
	WebElement accept;
	@FindBy(xpath = "//input[@name='reject']")
	WebElement reject;
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
	@FindBy(xpath = "//input[@value='View Rejected Users']")
	WebElement ViewRejectedUsersinMaker;
	@FindBy(xpath = "//input[@value='Modify']")
	WebElement ModifyButtoninMaker;
	
	
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchfield;

	@FindBy(xpath = "//select[@name='rejectedCorporateView_length']")
	WebElement rejectedCorporateView_length;
	@FindBy(xpath = "//select[@name='list_length']")
	WebElement logoutInMaker;
	
	@FindBy(xpath = "//input[@name='button']")
	WebElement clickOnSubmitButtonOnEdit;
// Modify Page in Maker
	@FindBy(xpath = "//input[@value='Modify']")
	WebElement ModifyButton;

	@FindBy(xpath = "//*[contains(text(),'Modify Group User')]//parent::td")
	WebElement verifyModifyModifyGroupUserMakerPage;
    @FindBy(xpath = "//select[@name='frmGroupId']")
	WebElement selectfrmGroupIdInModifyPage;
  
    @FindBy(xpath = "//input[@name='logingId']")
	WebElement logingIdInModifyPage;
    @FindBy(name = "Submit")
	WebElement submitbuttonModifyMaker;
	@FindBy(xpath = "//input[@name='Submit']")
	WebElement modifysubmitbutton;
	@FindBy(xpath = "//td[@class='note']")
	WebElement verificationMessageInModifyCountry;
//	(//form[@name='modifyGroupUser']//tr//td//input[@id='button'])[2]
    @FindBy(xpath = "(//form[@name='modifyGroupUser']//tr//td//input[@id='button'])[2]")
	WebElement clickOnSubmitInModifyPage;
	@FindBy(xpath = "//b[text()='Logout']")
	WebElement logoutMaker;

	// View Page in Checker
	//
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewInChecker;

	public CreateGroupUser(WebDriver driver) {
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

// click on Group User Definition Menu
	public void clickOnGroupUserDefinitionMenu() {
		log.info("click on Group User Definition Menu ==>" + GroupUserDefinition.getText());
		GroupUserDefinition.click();
	}

// click on Create Group User SubMenu
	public void clickonCreateGroupUserSubMenu() {
		log.info("click on Create Group User SubMenu ==>>" + CreateGroupUser.getText());
		CreateGroupUser.click();
	}

// to switch the Add Create Group User Maker page.
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
	
	// country 
	String roleType;
	String selcompany;
	String Role;
	static String getTextOfRoleiD;
	static String getbankBranch;
	static String getTextOfCorporateiD;
	static String getLoginId;
	static String getemailId;
	static String getalternateEmailId;
	static String getfirstName;
	static String getmiddleName;
	static String getlastName;
	static String  getmobileNumber;
	static String getemployeeId;
	static String getuniqueIdentifier;
	static String getuniqueIdentifierValue;
	static String getuniqueIdfileName;
	static String uniqueIdentifierType;
	static String getisActiveCorporateUser;
	
	
	
	
	
	String GroupId = "RGEX";
	String CountryCode1 = "BD";
	String MaximumTxnLimit1 ="1";
	static String getmaximumTxnLimit;
	static String getisActiveDailyLimitMaker;
	
	
	
	static List<String> paymentCodeList;
	static String StringValueOfpaymentCode;
	static String GetTextOfPaymentCode;
	static String x;
	static String getisActivePaymentMapping;
	
	
	
	
	public void CorporateIDFromDropDownByUsingStringArray() throws Exception {
		// 1121-109ak , 1302-CCD , ,6786786-Prime Bank Ltd;
		String[] itemsNeeded1 = { "645774675-ppp", "1141-PBNK01" };
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
	public void selectRoleTypeDropDown() {
		 roleType="General User";
		log.info("select Role Type ==>"+roleType);
		 Select role1 = new Select(selectRoleType);
		 role1.selectByVisibleText(roleType);
	}
	public void selectCompanyDropDown() {
		selcompany="Prime Bank";
		log.info("select Company ==>"+selcompany);
		Select company = new Select(selectCompany);
		company.selectByVisibleText(selcompany);
	}
	
	public void selectRoleDropDown() {
		 Role="PRIME_OPS_MAKER";
		log.info("select Role ==>"+Role);
		 Select selrole = new Select(selectRole);
		selrole.selectByVisibleText(Role);
	}
	public void selectRoleDropDownByoptioon() throws Exception {
		clickOnRoleId.click();
		//Thread.sleep(3000);
		log.info("click on Role Id Drop Down");
		int getSizeOfDropDown = selectRoleIdByList.size();
		System.out.println("get Size Of Drop Down ==>"+getSizeOfDropDown);
		for(int i=0; i<getSizeOfDropDown;i++) {
			 getTextOfRoleiD = selectRoleIdByList.get(i).getText();
			System.out.println("get Text Of Role iD ==>"+getTextOfRoleiD);
			if(getTextOfRoleiD.equals("PRIME_OPS_MAKER")){	
				log.info("Text Has Matched with Value");
				selectRoleIdByList.get(i).click();
				break;
				}
			else {
				log.info("Text Has NOT Matched with Value");
			}
			}
		 
	}
	public void enterbankBranch(String bankBranch) {
	   // this.bankBranch.click();
		this.bankBranch.sendKeys(bankBranch);
		getbankBranch = bankBranch.toString();
		System.out.println("get get bank Branch value ==>" + getbankBranch);
	}
	
	public void selectCorporateIdDropDownByoptioon() throws Exception {
		clickOnCorporateId.click();
		Thread.sleep(3000);
		log.info("click on Corporate Id Drop Down");
		int getSizeOfDropDown = selectCorporateID.size();
		System.out.println("get Size Of Drop Down ==>"+getSizeOfDropDown);
		for(int i=0; i<getSizeOfDropDown;i++) {
			 getTextOfCorporateiD = selectCorporateID.get(i).getText();
			System.out.println("get Text Of Corporate iD ==>"+getTextOfCorporateiD);
			if(getTextOfCorporateiD.equals("Al Ansari")){	
				log.info("Text Has Matched with Value");
				selectCorporateID.get(i).click();
				break;
				}
			else {
				log.info("Text Has NOT Matched with Value");
			}
			}
		 
	}
	
   public void enterLoginId(String LoginId) {
	log.info("Enter Login Id ==>"+LoginId);
	this.LoginId.sendKeys(LoginId);
	getLoginId = LoginId.toString();
	System.out.println("get Login Id value ==>" + getLoginId);

}
   public void enteremailId(String emailId) {
		log.info("Enter email Id ==>"+emailId);
		this.emailId.sendKeys(emailId);
		getemailId = emailId.toString();
		System.out.println("get email Id value ==>" + getemailId);

	}		
   public void enteralternateEmailId(String alternateEmailId) {
		log.info("Enter alternate Email Id ==>"+alternateEmailId);
		this.alternateEmailId.sendKeys(alternateEmailId);
		getalternateEmailId = alternateEmailId.toString();
		System.out.println("get alternate Email Id  value ==>" + getalternateEmailId);

	}	
   public void enterfirstName(String firstName) {
		log.info("Enter first Name ==>"+firstName);
		this.firstName.sendKeys(firstName);
		getfirstName = firstName.toString();
		System.out.println("get first Name value ==>" + getfirstName);

	}	
   public void entermiddleName(String middleName) {
		log.info("Enter middle Name ==>"+middleName);
		this.middleName.sendKeys(middleName);
		getmiddleName = middleName.toString();
		System.out.println("get middle Name value ==>" +getmiddleName);

	}	
   public void enterlastName(String lastName) {
		log.info("Enter last Name==>"+lastName);
		this.lastName.sendKeys(lastName);
		getlastName = lastName.toString();
		System.out.println("get last Name value ==>" +getlastName);

	}	
   public void entermobileNumber(String mobileNumber) {
		log.info("Enter mobile Number ==>"+mobileNumber);
		this.mobileNumber.sendKeys(mobileNumber);
		getmobileNumber = mobileNumber.toString();
		System.out.println("get mobile Number value ==>" +getmobileNumber);
}	
   
   public void enteremployeeId(String employeeId) {
		log.info("Enter employee Id ==>"+employeeId);
		this.employeeId.sendKeys(employeeId);
		getemployeeId = employeeId.toString();
		System.out.println("get employee Id value ==>" +getemployeeId);
}
   
   public void selectuniqueIdentifierTypeDropDowns() {
		log.info("select unique Identifier Type ==>");
		 String uniqueIdentifierType ="National ID";
		 Select uniqueIdentifier = new Select(selectuniqueIdentifierType);
		 uniqueIdentifier.selectByVisibleText(uniqueIdentifierType);
		 getuniqueIdentifier = uniqueIdentifierType.toString();
		System.out.println("get unique Identifier value ==>" +getuniqueIdentifier);

	}	
   public void enteruniqueIdentifierValue(String uniqueIdentifierValue) {
		log.info("Enter unique Identifier Value ==>"+uniqueIdentifierValue);
		this.uniqueIdentifierValue.sendKeys(uniqueIdentifierValue);
		getuniqueIdentifierValue = uniqueIdentifierValue.toString();
		System.out.println("get unique Identifier Value value ==>" +getuniqueIdentifierValue);

	}	 
   public void clickhereOnLink() {
	   clickhereLink.click();

	}	 
   public void enteruniqueIdfileName(String uniqueIdfileName) {
		log.info("Enter unique Id file Name Value ==>"+uniqueIdfileName);
		this.uniqueIdfileName.sendKeys(uniqueIdfileName);
		getuniqueIdfileName = uniqueIdfileName.toString();
		System.out.println("get unique Id file Name Value==>" +getuniqueIdfileName);

	}	 
// select is Active Corporate User
	public void selectisActiveCorporateUser() {

		String active = "Yes";
		log.info("select is Active Corporate User ? ==>" );
		Select aa = new Select(isActiveCorporateUser);
		aa.selectByVisibleText(active);
		String getisActive = active.toString();
		System.out.println("get is Active Corporate User ==>" + getisActive);
		String[] spl = getisActive.split("es");
		System.out.println("Split Array Values of Yes ==>" + spl);
		List<String> splitList1 = Arrays.asList(spl);
		getisActiveCorporateUser = String.join("", splitList1);
		System.out.println(
				"get is Active Corporate User after Split (Yes) As Y==>" + getisActiveCorporateUser);

	}

// click on  submit In add Maker page
	public void clickonsubmitInMakerpage() {
		log.info("click on submit In Maker page ==>" );
		submitInMakerpage.click();
	}

// verify Successful Message On Maker Page
	public void verifySuccessfulMessageOnMakerPage() {

		String verifytheSuccessfulMessage = SuccesfullMessage.getText();
		System.out.println("verify the Successful Message===>>>" + verifytheSuccessfulMessage);
		if (verifytheSuccessfulMessage.equals("Record has been added successfully.")) {
			log.info("Record has been added successfully.");

		} else if (verifytheSuccessfulMessage.equals("This user name has already used.")) {
			log.info("This user name has already used.");

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

// click on Group User Definition Checker Menu
	public void clickonGroupUserDefinitionCheckerMenu() {
		log.info(" Get text of Group User Definition Checker Menu ==>" + GroupUserDefinitionChecker.getText());
		GroupUserDefinitionChecker.click();

	}

	// click On Authorize Create User SubMenu
	public void clickOnAuthorizeCreateUserSubMenu() {
		log.info("click On Authorize Create User Sub Menu ==>" + AuthorizeCreateUser.getText());
		AuthorizeCreateUser.click();
	}

	public void verifyAuthorizeCreateGroupUserCheckerPage() throws Exception {
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		log.info("verify Authorize Create Group User Page ==>" + verifyAuthorizeCreateGroupUserPage.getText());
		String CorporateUserChecker = verifyAuthorizeCreateGroupUserPage.getText();

		System.out.println("Get text of verify Authorize Create Group User page ==>" + CorporateUserChecker);
		Assert.assertEquals("AUTHORIZE CREATE GROUP USER", CorporateUserChecker);
	}
		
		public void selectroleTypeOnCheckerPages() {
			log.info("Select Role Type On Checker Page ==>");
			Select roletype= new Select(roleTypeOnCheckerPage);
			roletype.selectByVisibleText(roleType);
		}
		public void selectroleOnCheckerPages() {
			log.info("Select Role On Checker Page ==>");
			Select role1= new Select(roleOnCheckerPage);
			role1.selectByVisibleText(getTextOfRoleiD);
			//Role
			// PRIME_OPS_MAKER
		}
		
		public void selectfrmLoginIdOnCheckerPage() {
		log.info("Select frm Login Id On Checker Page ==>");
		Select frmLoginId= new Select(frmLoginIdOnCheckerPage);
		frmLoginId.selectByVisibleText("49863");
		// getLoginId.toUpperCase()
	}
	
	
	public void verifyfrmLoginIdOnCheckerPage()
	{
		Assert.assertEquals(frmLoginIdOnCheckerPage.getAttribute("value"), getLoginId,"Login Id has Not Matched with Value");
	}	
	public void verifyemailIdOnCheckerPage() {
		
		Assert.assertEquals(emailIdOnCheckerPage.getAttribute("value"), getemailId,"get email Id has Not Matched with Value");

	}
	
	public void clickOnRejectButton() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", reject);
		log.info("click On Reject button ==>");
		reject.click();
	}
public void clickOnAcceptButton() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", accept);
	log.info("click On accept button ==>");
	accept.click();
}
	
	
// click on submit button And verify Succesfull Message on Checker  Page.
	public void clickonsubmitbuttonAndverifySuccesfullMessage() {

//		// Click on Submit button Checker Page. To Select only one Checkbox
//		log.info(" click on Submit button on Checker ==>>" + SubmitbuttononChecker.getText());
//		SubmitbuttononChecker.click();
//		
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		log.info("successful Message in Checker Page ==>" + verifysuccessfulMessageinChecker.getText());
		Assert.assertEquals(successfulMessageinChecker, "Record updated successfully.");

	}
	
	public void clickOnSubmitbuttononChecker() {
		log.info("click On Submit button on Checker ==>");
		SubmitbuttononChecker.click();
	}

	// go to Maker When Checker Has Approved
	public void gotoMakerWhenCheckerHasApproved() throws InterruptedException {
		driver.switchTo().defaultContent();
		log.info("Click on Logout in checker Page" + Logoutinchecker.getText());
		Logoutinchecker.click();

	}

	// View Rejected Users in Maker , After Reject  by the Checker data
	public void ViewRejectedUsersinMakerPage() {
		log.info("click on View Rejected Users in Maker ==>" + ViewRejectedUsersinMaker.getText());
		ViewRejectedUsersinMaker.click();
	}
  public void clickOnModifyButtoninMaker() {
	  log.info("click on Modified Button On Corporate Users Maker ==>");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ModifyButtoninMaker);
	  ModifyButtoninMaker.click();
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



	public void clickOnEditButtonWhenUniqueValueHasMapped() {
		String emailID = "//table[@id='rejectedCorporateView']//tbody//tr//td[1]";
		clickOnEditbuttonOnViewPage(emailID, getemailId);
	}

	public void clickOnEditbuttonOnViewPage(String xpathvalue, String value) {

		List<WebElement> web = driver.findElements(By.xpath(xpathvalue));
		int sizeOfColumn = web.size();
		System.out.println("size Of list ==>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get the Text on checker Page==>>" + name);
			if (name.contains(value)) {
				System.out.println("Get Text has Mtched with Unique value On Checker page ==>" + value);
				driver.findElements(By.xpath(
						"//table[@id='rejectedCorporateView']//tbody//tr//td[9]"))
						.get(i).click();
				log.info("Click On Check box with Unique Value matched ==>" + value);

				break;
			} else {
				System.out.println("Get Text has NOT Mtched with Unique value On View page ==>" + value);
			}
		}

	}
	public void clickOnSubmitButtonOnEditPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", clickOnSubmitButtonOnEdit);
		//.switchTo().defaultContent();
		log.info("click On Submit Button On Edit Page ==>" + clickOnSubmitButtonOnEdit.getText());
		clickOnSubmitButtonOnEdit.click();
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

	public void clickOnLogOutWhenEdited() {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		
		log.info("Click On Log out Button ..");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//b[text()='Logout']")).click();
	}
	public void verifyTheModifiedGroupUserPage() {
		driver.switchTo().defaultContent();

		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// driver.switchTo().frame("iframe");
//		WebElement Fieldsareinmandatory = driver.findElement(By.xpath("//*[text()='Fields in ']"));
//
//		System.out.println(" To Go to Fields are in mandatory Field ==> " + Fieldsareinmandatory.getText());
//
		log.info("Get the Text of Modify page ==>" + verifyModifyModifyGroupUserMakerPage.getText());
		Assert.assertEquals(verifyModifyModifyGroupUserMakerPage.getText(),
				"MODIFY GROUP USER");
	}

	String TextOfGroupId;
	
	// select frm Group Id In Modify Page
	public void selectGroupIdInModifyMakerPage() {
		TextOfGroupId = "RGEX-RG ExHouse";
		Select selectGroup = new Select(selectfrmGroupIdInModifyPage);
		List<WebElement> AllselectGroup = selectGroup.getOptions();
		int noofGroupIdOnDropDown = AllselectGroup.size();
		System.out.println("Get the No of Group Id Drop Down==>>" + noofGroupIdOnDropDown);

		for (int i = 0; i < AllselectGroup.size(); i++) {
			String GetTextOfAllDropDownValues = AllselectGroup.get(i).getText();
			System.out
					.println("List of Get Text From Drop Down Values On Modify page ==>" + GetTextOfAllDropDownValues);

			if (AllselectGroup.get(i).getText().equals(TextOfGroupId)) {
				log.info("List of get Text Has Matched From drop down On Modify Page ==>" + GetTextOfAllDropDownValues);

				selectGroup.selectByVisibleText(TextOfGroupId);
				System.out.println("group Id  Has Selected the From  Drop Down ==>>" + TextOfGroupId);
				break;
			} else {
				System.out.println("Group Id Has Not Selected the FromDrop Down ==>>" + TextOfGroupId);
			}
		}
	}
	public void enterlogingIdInModifyPage(String logingIdInModifyPage) {
		log.info("Enter Login Id On Checker Page ==>");
		this.logingIdInModifyPage.sendKeys(logingIdInModifyPage);
//		Select frmLoginId= new Select(frmLoginIdOnCheckerPage);
//		frmLoginId.selectByVisibleText("49863");
//		// getLoginId.toUpperCase()
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
   public void clickOn2submitButtonOnModifyPage() {
	   log.info("");
	   clickOnSubmitInModifyPage.click();
	   
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
	public void verifyCheckerPageModificationhasDoneByMaker()throws InterruptedException {

		String GroupID = "//table[@id='list']//tbody/tr/td[4]";
		String EntityId = "//table[@id='list']//tbody/tr/td[5]";
		String EntityName = "//table[@id='list']//tbody/tr/td[6]";
		String CountryCode = "//table[@id='list']//tbody/tr/td[7]";
		String MaxmTxnLimit1 = "//table[@id='list']//tbody/tr/td[8]";
		String MaxmTxnLimit = "//table[@id='list']//tbody/tr/td[9]";
		String ISActive = "//table[@id='list']//tbody/tr/td[10]";

		toverifyListOfValuesOnCheckerPageWhenModified(GroupID, GroupId);
		toverifyListOfValuesOnCheckerPageWhenModified(EntityId, splitvaluesofCorporateIDAsEntityID);
		toverifyListOfValuesOnCheckerPageWhenModified(EntityName, splitvaluesofCorporateIDAsEntityType);
		toverifyListOfValuesOnCheckerPageWhenModified(CountryCode, CountryCode1);
		toverifyListOfValuesOnCheckerPageWhenModified(MaxmTxnLimit1, MaximumTxnLimit1);
		toverifyListOfValuesOnCheckerPageWhenModified(MaxmTxnLimit, getmaximumTxnLimit);
		toverifyListOfValuesOnCheckerPageWhenModified(ISActive, getisActiveDailyLimitMaker);
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
	public void verifyViewpageBySearchFieldWhenModify() throws InterruptedException {
		this.searchfield.clear();
		log.info("search By Login Id ==>" + getLoginId);
		this.searchfield.sendKeys(getLoginId);

		this.searchfield.clear();
		log.info("search By email Id ==>" + getemailId);
		this.searchfield.sendKeys(getemailId);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("search By first Name ==>" + getfirstName);
		this.searchfield.sendKeys(getfirstName);
		Thread.sleep(4000);
		this.searchfield.clear();
		driver.navigate().refresh();

		Select entitieslist = new Select(rejectedCorporateView_length);
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

	String CountryCode = "//tbody[@role='alert']//tr//td[2]";
	String EntityId = "//tbody[@role='alert']//tr//td[3]";
	String MaximumTxnlimit = "//tbody[@role='alert']//tr//td[4]";
	String IsActive = "//tbody[@role='alert']//tr//td[5]";
	
	

	verifyViewPageWhenModify(CountryCode, CountryCode1);
	verifyViewPageWhenModify(EntityId, splitvaluesofCorporateIDAsEntityID);
	verifyViewPageWhenModify(MaximumTxnlimit, getmaximumTxnLimit);
	verifyViewPageWhenModify(IsActive, getisActiveDailyLimitMaker);
	

	}

// 
// verifytheViewMakerPagewithTextwiththierrespectiveColumn
	public static void verifyViewPageWhenModify(String xpathvalue, String value) {
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
	WebElement  selectEntityId= driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
	WebElement selectMxmTxnLimit = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
	WebElement IsActive = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
	
	
	
	verifyViewPPageBySelectDropDown(selectCountryCode, CountryCode1);
	verifyViewPPageBySelectDropDown(selectEntityId, splitvaluesofCorporateIDAsEntityID);
	verifyViewPPageBySelectDropDown(selectMxmTxnLimit, getmaximumTxnLimit);
	verifyViewPPageBySelectDropDown(IsActive, getisActiveDailyLimitMaker);
	
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
