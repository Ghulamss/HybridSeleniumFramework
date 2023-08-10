package com.hybridFramework.pagesOfTransaction;

import java.awt.Component;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.commons.io.FilenameUtils;
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

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.helper.Wait.WaitHelper;
 
public class TransactionBulkUpload {
	static WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(TransactionBulkUpload.class);
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
	@FindBy(xpath = "//*[text()='Transaction']//parent::a")
	WebElement Transaction;
	@FindBy(xpath = "//*[text()='Transaction Bulk Upload Maker']//parent::a")
	WebElement TransactionBulkUploadMaker;
	@FindBy(xpath = "//*[text()='Field in ']")
	WebElement Fieldsareinmandatory;
	@FindBy(xpath = "//input[@name='filePathTxtBox']")
	WebElement filePathTxtBox;
	@FindBy(xpath = "//input[@value='Upload']")
	WebElement UploadFile;
	
	@FindBy(xpath = "//*[contains(text(),'Browse')]")
	WebElement attachFile;
	@FindBy(xpath = "//input[@name='filePathTxtBox']")
	WebElement choosefilePathTxtBox;
	
	@FindBy(xpath = "//*[text()='Corporate Transaction Approval Maker']//parent::a")
	WebElement CorporateTransactionApprovalMaker;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement FieldsareinmandatoryOnTransaction;
	@FindBy(xpath = "//select[@name='strGroupId']")
	WebElement selectGoupIDOnTransaction;
	
	@FindBy(xpath = "//select[@name='entityFileName']")
	WebElement selectFileNameOntransaction;

	@FindBy(xpath = "//input[@id='btSubmit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//b[text()='Logout']")
	WebElement LogoutOnMaker;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
	
/***** ********************** Statrted  Checker X-path *****/

	@FindBy(xpath = "//*[text()='Transaction']//parent::a")
	WebElement TransactionOnChecker;
	@FindBy(xpath = "//*[text()='Transaction Bulk Upload Checker']//parent::a")
	WebElement TransactionBulkUploadChecker;
	@FindBy(xpath = "//*[text()='Transaction File Upload Checker']")
	WebElement verifyTransactionFileUploadChecker;
	@FindBy(xpath = "//select[@name='entityId']")
	WebElement corporateIDOnChecker;
	@FindBy(xpath = "//select[@name='entityCountryCode']")
	WebElement selectCountryOnChecker;
	@FindBy(xpath = "//input[@name='filePathTxtBox']")
	WebElement filePathTxtBoxOnChecker;
	// //input[@type='checkbox']//parent::th for getting Text of Header of
	@FindBy(xpath = "//th//input[@type='checkbox']")
	List<WebElement> Headercheckbox;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement SubmitbuttononChecker;

	@FindBy(xpath = "//td[@class='note']")
	WebElement verifysuccessfulMessageinChecker;
	
	@FindBy(xpath = "//input[@name='status']")
	WebElement checkStatusButtonOnChecker;
	@FindBy(xpath = "//b[text()='Logout']")
	WebElement Logoutinchecker;
/*  Transaction Approvaal Checker x path */
	// View page in Maker
	@FindBy(xpath = "//*[text()='Corporate Transaction Approval Checker']//parent::a")
	WebElement CorporateTransactionApprovalChecker;
	@FindBy(xpath = "//*[text()='Transaction Approval Checker']")
	WebElement verifyTransactionApprovalChecker;
	@FindBy(xpath = "//select[@name='strGroupId']")
	WebElement selectstrGroupIdOnChecker;
	@FindBy(xpath = "//select[@name='entityId']")
	WebElement corporateIDOnTransactionChecker;
	
	@FindBy(xpath = "//input[@id='btSubmit']")
	WebElement submitOnTransactionApprovalMakerpage;
	@FindBy(xpath = "//form[@name='txnNameVerifyMaker']//input[@id='button']")
	WebElement submitButtonOnTransactionApprovalMakerpage;
	@FindBy(xpath = "//input[@id='btSubmit']")
	WebElement submitOnTransactionApprovalCheckerpage;
	@FindBy(xpath = "//form[@name='txnNameVerifyChecker']//input[@id='button']")
	WebElement submitButtonOnTransactionApprovalCheckerpage;
	
	
	
	private String TransactionFileStatus;

	public TransactionBulkUpload(WebDriver driver) {
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

// click on Transaction Maker Menu
	public void clickonTransactionMakerMenu() {
		log.info("click on Transaction Maker Menu ==>" + Transaction.getText());
		Transaction.click();
	}

// click on Transaction Bulk Upload Maker SubMenu
	public void clickonTransactionBulkUploadMakerSubMenu() {
		log.info("click on Transaction Bulk Upload Maker SubMenu ==>>" + TransactionBulkUploadMaker.getText());
		TransactionBulkUploadMaker.click();
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
	static String getcorporateid;
	static String getfilePathTxtBox;
		
	public void selectCorporateID() {
		  String corporateid="3821 - AL AHLIA MONEY EXCHANGE BUREAU";
		 getcorporateid= corporateid.toString();
		 System.out.println("get corporate id Value ==>"+getcorporateid);
		log.info("select corporate id ==>"+getcorporateid);
		Select selecorporateid = new Select(driver.findElement(By.xpath("//select[@name='entityId']")));
		selecorporateid.selectByVisibleText(getcorporateid);
	}
	
	
	
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
		Select selectGroupCountry = new Select(driver.findElement(By.xpath("//select[@name='entityCountryCode']")));
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
	
//	public void cluckOndd() {
//		driver.findElement(By.xpath("(//div[@class='filter-option'])[1]")).click();
//	}
//public void corporateDropdown() {
//	log.info("corporate Dropdown =>");
//	Select sele = new Select(driver.findElement(By.xpath("//select[@name='entityId']")));
//	sele.selectByVisibleText("3821 - AL AHLIA MONEY EXCHANGE BUREAU");
//}
	
	public void attachTheFile(String filePathTxtBox) {
		//driver.findElement(By.xpath("//input[@accept='.txt,.xls,.xlsx']")).sendKeys("F:\\LoginTest1ForCheckingdatadriven.xlsx");
		this.choosefilePathTxtBox.sendKeys(filePathTxtBox);
		getfilePathTxtBox=filePathTxtBox.toString();
		System.out.println("Get file Path Txt Box ==>"+getfilePathTxtBox);
	}
	
	public String  clickOnUploadfile() {
		log.info("click On Upload ==>");
		UploadFile.click();
		return TransactionFileStatus;
		}
		
// click on submit In add Maker page
	public void clickonsubmitInMakerpage() {
		log.info("click on submit In Maker page ==>" + submitInMakerpage);
		submitInMakerpage.click();
	}

// verify Successful Message On Maker Page
	public void verifySuccessfulMessageOnMakerPage() {

		String verifytheSuccessfulMessage = SuccesfullMessage.getText();
		System.out.println("verify the Successful Message ==>" + verifytheSuccessfulMessage);
				if (verifytheSuccessfulMessage.equals("File uploaded successfully.")) {
			log.info("File uploaded successfully.");
			
		} else if (verifytheSuccessfulMessage.equals("Duplicate File found.File cannot be Uploaded.")) {
			log.info("Duplicate File found.File cannot be Uploaded.");
			
		}  else if (verifytheSuccessfulMessage.equals("Record Already Exists")) {
			log.info("Record Already Exists");
			

		}
	}
	
	public void clickOnLogOutButton() {
		log.info("Click On Log Out Link On Maker page ==>");
		driver.switchTo().defaultContent();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", LogoutOnMaker);
		LogoutOnMaker.click();
		
	}

// click on Transaction On Checker Menu
	public void clickonTransactionOnCheckerMenu() {
		log.info(" Get text of Transaction On Checker Menu ==>" + TransactionOnChecker.getText());
		TransactionOnChecker.click();

	}

	// click On Transaction Bulk Upload Checker SubMenu
	public void clickOnTransactionBulkUploadCheckerSubMenu() {
		log.info("click On Transaction Bulk Upload Checker Sub Menu===>>" + TransactionBulkUploadChecker.getText());
		TransactionBulkUploadChecker.click();
	}

	public void verifyTransactionFileUploadCheckerPage() throws Exception {
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		log.info("verify Transaction File Upload Checker ==>" + verifyTransactionFileUploadChecker.getText());
		String TransactionFileUploadChecker = verifyTransactionFileUploadChecker.getText();

		System.out.println("Get text of verify Transaction FileUpload Checker page ==>" + TransactionFileUploadChecker);
		Assert.assertEquals("TRANSACTION FILE UPLOAD CHECKER", TransactionFileUploadChecker,"Text has Not Matched with Value");
	// TRANSACTION FILE UPLOAD CHECKER
	
	}

	public void verifyCorporateIDOnCheckerPage() {
		Select sel = new Select(corporateIDOnChecker);
	sel.selectByVisibleText(getcorporateid);
	log.info("Corporate ID  Selected Successfully");
		}
	
	public void corporateDropdownBySelectClass() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//(//div[@class='dropdown bootstrap-select select-169x20'])[1]//select
		//select[@name='entityId']//option
		// // 3821 - AL AHLIA MONEY EXCHANGE BUREAU
		// 3821-AL AHLIA MONEY EXCHANGE BUREAU
		log.info("corporate Dropdown =>");
		
		Select sele = new Select(driver.findElement(By.xpath("//select[@name='entityId']")));
		List<WebElement> getOptionsOfCorporateID = sele.getOptions();
		int getSizeOfCorporateID = getOptionsOfCorporateID.size();
		System.out.println("get Size Of Corporate ID ==>"+getSizeOfCorporateID);
		for(int i=0; i<getSizeOfCorporateID;i++)
		{
			String GetTextOfCorporateId = getOptionsOfCorporateID.get(i).getText();
			System.out.println("Get Text Of Corporate Id ==>"+GetTextOfCorporateId);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			if(GetTextOfCorporateId.contains("3821-AL AHLIA MONEY EXCHANGE BUREAU")){
				log.info("Text Has Matched with value ");
				//sele.selectByVisibleText("3821 - AL AHLIA MONEY EXCHANGE BUREAU");
				sele.selectByIndex(i);
				log.info("Text Has Selected with value ");

		}
	 	
	}}
	
	public void selectCountryOnCheckerPage() {
		Select selCorporate= new Select(selectCountryOnChecker);
		selCorporate.selectByVisibleText(y);
		log.info("Country Selected Successfully");
		}
public void verifyAttachFileOnChecker() {
	log.info("Enter Attach File On Checker Page ==>"+getfilePathTxtBox);
	filePathTxtBoxOnChecker.sendKeys(getfilePathTxtBox);
}
	
// verify Succesfull Message on Checker  Page.
// File Uploaded Successfully.
	public void verifySuccesfullMessageOnTransactionCheckerPage() {
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		log.info("successful Message in Checker Page ==>" + verifysuccessfulMessageinChecker.getText());
		//Assert.assertEquals(successfulMessageinChecker, "Duplicate file found. File cannot be uploaded.");

	}
	public void clickOnCheckStatusOnTransactionCheckerPage(){
		log.info("Click On check Status Button On Checker ==>");
		checkStatusButtonOnChecker.click();
		
		
	}
	
	// click on Corporate Transaction Approval Maker SubMenu
		public void clickonCorporateTransactionApprovalMakerSubMenu() {
			log.info("click on Corporate Transaction Approval Maker SubMenu ==>"
					+ CorporateTransactionApprovalMaker.getText());
			CorporateTransactionApprovalMaker.click();
		}

	// to switch Fields are in mandatory On Transaction Approval Maker
		public void toswitchFieldsareinmandatoryOnTransaction() throws Exception {
			Thread.sleep(5000);
			List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
			System.out.println(iframeElements);

			driver.switchTo().frame(0);
			System.out.println(" To Go to Fields are in mandatory Field=== " + FieldsareinmandatoryOnTransaction.getText());
			log.info(" To switch the main Enter values " + FieldsareinmandatoryOnTransaction.getText());
		}

//		static List<String> groupcountryList;
//		static String y;
//		static String groupidString;
//		static String GetTextOfGroupCountry;
		static String getgroupid;
//		static String getcorporateid;

		public void selectGoupIDDropDown() {
			String groupid = "RGEX-RG ExHouse";
			getgroupid = groupid.toString();
			System.out.println("get corporate id Value ==>" + getgroupid);

			Select selecorporateid = new Select(selectGoupIDOnTransaction);
			selecorporateid.selectByVisibleText(getgroupid);
			log.info("select corporate id ==>" + getgroupid);

		}

		public void selectCorporateIDOnTransaction() {
			String corporateid = "3821 - AL AHLIA MONEY EXCHANGE BUREAU";
			getcorporateid = corporateid.toString();
			System.out.println("get corporate id Value ==>" + getcorporateid);
			log.info("select corporate id ==>" + getcorporateid);
			Select selecorporateid = new Select(driver.findElement(By.xpath("//select[@name='entityId']")));
			selecorporateid.selectByVisibleText(getcorporateid);
		}

		public void selectGroupCountryOnTransaction() throws Exception {

			String[] groupCountry = { "Bangladesh", "yhjgh" };
			// Thread.sleep(3000);
			System.out.println("Get the Text of String [] Array Before ==> " + groupCountry);
			groupcountryList = Arrays.asList(groupCountry);
			groupidString = String.join(",", groupcountryList);
			System.out.println("Get String Value of country code" + groupidString);

			methodofGroupCountryOnTransaction(driver, groupidString);

		}

		public static void methodofGroupCountryOnTransaction(WebDriver driver, String value) throws Exception {
			int j = 0;
			Thread.sleep(5000);
			Select selectGroupCountry = new Select(driver.findElement(By.xpath("//select[@name='entityCountryCode']")));
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

		public void selectSingleRadioButton() {
			List<WebElement> noofradiobuttons = driver.findElements(By.xpath("//label[@class='radio']"));
			int noofSize = noofradiobuttons.size();
			System.out.println("no of Size ==>" + noofSize);
			for (int i = 0; i < noofradiobuttons.size(); i++) {
				String getTextOfradioButton = noofradiobuttons.get(i).getText();
				System.out.println("get Text Of radio Button ==>" + getTextOfradioButton);
				if (getTextOfradioButton.equals("Bulk")) {
					noofradiobuttons.get(i).click();
					System.out.println("Radio button has Selected with ==>" + getTextOfradioButton);
				}
			}
		}
 
	public Path fileName;
  
	public void gerfileName() {
		{

			// create object of Path
			Path path = Paths.get(getfilePathTxtBox);

			// call getFileName() and get FileName path object
			 fileName = path.getFileName();

			// print FileName
			System.out.println("FileName: " + fileName.toString());
		}
	}
	public void checkTheFileFilter() {
		Component file = null;
		String filename = file.getName();
		if(!FilenameUtils.isExtension(filename,"xls")){
		  JOptionPane.showMessageDialog(null, "Choose an excel file!");
		}
	}	
	
	
		public void selectFileNameOnMakerPage() {
			Select FileName = new Select(selectFileNameOntransaction);
			FileName.selectByVisibleText(fileName.toString());
		}
		

	// click on  submit In add Maker page
		public void clickonsubmitInTransactionMakerpage() {
			log.info("submit On Transaction Approval Maker page ==>" + submitOnTransactionApprovalMakerpage);
			submitOnTransactionApprovalMakerpage.click();
		}
		
		// click on  submit In add Maker page
				public void clickOnsubmitButtonOnTransactionApprovalMakerpage() {
					log.info("submit Button On Transaction Approval Maker page ==>" + submitButtonOnTransactionApprovalMakerpage);
					submitButtonOnTransactionApprovalMakerpage.click();
				}
	// verify Successful Message On Maker Page
		public void verifySuccessfulMessageOnTransactionMakerPage() {

			String verifytheSuccessfulMessage = SuccesfullMessage.getText();
			System.out.println("verify the Successful Message ==>" + verifytheSuccessfulMessage);
			if (verifytheSuccessfulMessage.equals("File uploaded successfully.")) {
				log.info("File uploaded successfully.");

			} else if (verifytheSuccessfulMessage.equals("Duplicate File found.File cannot be Uploaded.")) {
				log.info("Duplicate File found.File cannot be Uploaded.");

			} else if (verifytheSuccessfulMessage.equals("Record Already Exists")) {
				log.info("Record Already Exists");

			}
		}

		
		public void clickOnLogOutButtonOnTransactionMaker() {
			log.info("Click On Log Out Link On Maker page ==>");
			driver.switchTo().defaultContent();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", LogoutOnMaker);
			LogoutOnMaker.click();

		}
		
	// click On Corporate Transaction Approval Checker SubMenu
		public void clickOnCorporateTransactionApprovalCheckerSubMenu() {
			log.info("click On Corporate Transaction Approval Checker Sub Menu===>>"
					+ CorporateTransactionApprovalChecker.getText());
			CorporateTransactionApprovalChecker.click();
		}

		public void verifyTransactionApprovalCheckerPage() throws Exception {
			Thread.sleep(3000);
			List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
			System.out.println(iframeElements);

			driver.switchTo().frame(0);

			log.info("verify Transaction Approval Checker ==>" + verifyTransactionApprovalChecker.getText());
			String TransactionApprovalChecker = verifyTransactionApprovalChecker.getText();

			System.out.println("Get text of Transaction Approval Checker page ==>" + TransactionApprovalChecker);
			Assert.assertEquals("TRANSACTION APPROVAL CHECKER", TransactionApprovalChecker,
					"Text has Not Matched with Value");
			// TRANSACTION FILE UPLOAD CHECKER

		}

		public void verifyselectstrGroupIdOnCheckerPage() {
			log.info("verify select Group Id On Checker Page ==>");
			Select sGroupIdOnChecker = new Select(selectstrGroupIdOnChecker);
			sGroupIdOnChecker.selectByVisibleText(getgroupid);
			log.info("Corporate ID  Selected Successfully On Checker Page");
		}

		public void verifyCorporateIDOnTransactionCheckerPage() {
			Select sel = new Select(corporateIDOnChecker);
			sel.selectByVisibleText(getcorporateid);
			log.info("Corporate ID  Selected Successfully");
		}

		public void selectCountryOnTransactionCheckerPage() {
			Select selCorporate = new Select(selectCountryOnChecker);
			selCorporate.selectByVisibleText(y);
			log.info("Country Selected Successfully");
		}

		public void verifyselectSingleRadioButton() {
			List<WebElement> noofradiobuttons = driver.findElements(By.xpath("//label[@class='radio']"));
			int noofSize = noofradiobuttons.size();
			System.out.println("no of Size ==>" + noofSize);
			for (int i = 0; i < noofradiobuttons.size(); i++) {
				String getTextOfradioButton = noofradiobuttons.get(i).getText();
				System.out.println("get Text Of radio Button ==>" + getTextOfradioButton);
				if (getTextOfradioButton.equals("Bulk")) {
					noofradiobuttons.get(i).click();
					System.out.println("Radio button has Selected with ==>" + getTextOfradioButton);
				}
			}
		}
		
		public void selectFileOnTransactionApprovalChecker() {
			Select FileName = new Select(selectFileNameOntransaction);
			FileName.selectByVisibleText(fileName.toString());
		}
		
		
		public void clickOnsubmitOnTransactionApprovalCheckerpage() {
			log.info(" Click On submit Transaction Approval Checker page ==>");
			submitOnTransactionApprovalCheckerpage.click();
		}
		public void clickOnsubmitButtonOnTransactionApprovalCheckerpage() {
			log.info("submit Button On Transaction Approval Checker page ==>");
			submitButtonOnTransactionApprovalCheckerpage.click();
		}
		
	// verify Succesfull Message on Checker  Page.
		public void verifySuccesfullMessageOnCheckerPage() {
			String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
			log.info("successful Message in Checker Page ==>" + verifysuccessfulMessageinChecker.getText());
			Assert.assertEquals(successfulMessageinChecker, "File Uploaded Successfully.");

		}

		public void clickOnCheckStatusOnCheckerPage() {
			log.info("Click On check Status Button On Checker ==>");
			checkStatusButtonOnChecker.click();

		}

	//   go to Maker When Checker Approved Country
		public void gotoMakerCheckerApprovedCountry() throws InterruptedException {
			driver.switchTo().defaultContent();
			log.info("Click on Logout in checker Page" + Logoutinchecker.getText());
			Logoutinchecker.click();

		}

		public void clickOnlogoutCheckerButton() throws Throwable {
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,-250)", "");
			driver.switchTo().defaultContent();
			

			driver.findElement(By.xpath("//b[text()='Logout']")).click();

		}
	}
