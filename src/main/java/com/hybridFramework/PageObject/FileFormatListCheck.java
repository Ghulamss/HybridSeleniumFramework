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
public class FileFormatListCheck {
	static WebDriver driver;

	private final Logger log = LoggerHelper.getLogger(FileFormatListCheck.class);
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
	@FindBy(xpath = "//*[contains(text(),'File Format List Check')]//parent::a")
	WebElement FileFormatListCheck;
	@FindBy(xpath = "//*[text()='Fields in ']")
	WebElement Fieldsareinmandatory;
	@FindBy(xpath = "//select[@name='entityId']")
	WebElement selectCorporateId;

	@FindBy(xpath = "//input[contains(@name,'SrNo0')]")
	WebElement UniqueID;
	@FindBy(xpath = "//input[@name='SrNo1']")
	WebElement CorporateRemittanceReferenceNumber;
	@FindBy(xpath = "//input[@name='SrNo2']")
	WebElement Date;
	@FindBy(xpath = "//input[@name='SrNo3']")
	WebElement RemitterName;
	@FindBy(xpath = "//input[@name='SrNo4']")
	WebElement RemitterIDType;
	@FindBy(xpath = "//input[@name='SrNo5']")
	WebElement RemitterIDNo;
	@FindBy(xpath = "//input[@name='SrNo6']")
	WebElement RemittercustomerAddress1;
	@FindBy(xpath = "//input[@name='SrNo7']")
	WebElement RemittercustomerPINZIPCode;
	@FindBy(xpath = "//input[@name='SrNo8']")
	WebElement RemittersEmailID;
	@FindBy(xpath = "//input[@name='SrNo9']")
	WebElement RemittersContactno;
	@FindBy(xpath = "//input[@name='SrNo10']")
	WebElement RemittersCountry;
	@FindBy(xpath = "//input[@name='SrNo11']")
	WebElement Remittersstate;
	@FindBy(xpath = "//input[@name='SrNo12']")
	WebElement MandateType;
	@FindBy(xpath = "//input[@name='SrNo13']")
	WebElement TransferAmount;
	@FindBy(xpath = "//input[@name='SrNo14']")
	WebElement BeneficiaryName;
	@FindBy(xpath = "//input[@name='SrNo15']")
	WebElement BeneficiaryCountry;
	@FindBy(xpath = "//input[@name='SrNo16']")
	WebElement BeneficiaryState;
	@FindBy(xpath = "//input[@name='SrNo17']")
	WebElement BeneficiarycustomerAddress1;
	@FindBy(xpath = "//input[@name='SrNo18']")
	WebElement BeneficiarycustomerPINOrZIPCode;
	@FindBy(xpath = "//input[@name='SrNo19']")
	WebElement BeneficiarycustomerEmailID;
	@FindBy(xpath = "//input[@name='SrNo20']")
	WebElement Beneficiarycustomermobileno;
	@FindBy(xpath = "//input[@name='SrNo21']")
	WebElement RemittancePurposeCode;
	@FindBy(xpath = "//input[@name='SrNo22']")
	WebElement RemittanceTypeOrPurpose;
	@FindBy(xpath = "//input[@name='SrNo23']")
	WebElement Relationshipwithbeneficiary;
	@FindBy(xpath = "//input[@name='SrNo24']")
	WebElement BankName;
	@FindBy(xpath = "//input[@name='SrNo25']")
	WebElement BankBranch;
	@FindBy(xpath = "//input[@name='SrNo26']")
	WebElement BranchCode;
	@FindBy(xpath = "//input[@name='SrNo27']")
	WebElement RoutingNumber;
	@FindBy(xpath = "//input[@name='SrNo28']")
	WebElement BankAccountnumber;
	@FindBy(xpath = "//input[@name='SrNo29']")
	WebElement BeneBankAddress;
	@FindBy(xpath = "//input[@name='SrNo30']")
	WebElement CashAgentName;
	@FindBy(xpath = "//input[@name='SrNo31']")
	WebElement CashAgentBranch;
	@FindBy(xpath = "//input[@name='SrNo32']")
	WebElement BeneficiaryIDType;
	@FindBy(xpath = "//input[@name='SrNo33']")
	WebElement BeneficiaryIDNo;
	@FindBy(xpath = "//input[@name='SrNo34']")
	WebElement CashPayoutPin;
	@FindBy(xpath = "//input[@name='SrNo35']")
	WebElement WalletName;
	@FindBy(xpath = "//input[@name='SrNo36']")
	WebElement WalletNo;
	@FindBy(xpath = "//input[@name='SrNo37']")
	WebElement DELIMITER;
	@FindBy(xpath = "//input[@name='SrNo38']")
	WebElement RemitterDob;
	@FindBy(xpath = "//input[@name='SrNo39']")
	WebElement BeneDob;
	@FindBy(xpath = "//input[@name='SrNo40']")
	WebElement Currency;
	@FindBy(xpath = "//input[@name='SrNo41']")
	WebElement RemitterPassportNumber;
	@FindBy(xpath = "//input[@name='SrNo42']")
	WebElement PassportExpirydate;
	@FindBy(xpath = "//input[@name='SrNo43']")
	WebElement RemitterOtherID;
	@FindBy(xpath = "//input[@name='SrNo44']")
	WebElement RemitterOtheridExpirydate;
	@FindBy(xpath = "//input[@name='SrNo45']")
	WebElement RemitterOccupation;
	@FindBy(xpath = "//input[@name='SrNo46']")
	WebElement percentConsent;

	@FindBy(xpath = "//select[@name='purposeType']")
	WebElement selectpurposeType;

	@FindBy(xpath = "//select[@id='isActive']")
	WebElement isActiveEntity;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement submitInMakerpage;
	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;
// Statrted  Checker X-path

	@FindBy(xpath = "//*[text()='Master Definition Checker']")
	WebElement MasterDefinitionChecker;
	@FindBy(xpath = "//*[text()='Authoriser Purpose']")
	WebElement AuthoriserPurpose;
	@FindBy(xpath = "//td[contains(text(),' Purpose Checker')]")
	WebElement verifyPurposeCheckerPage;
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

	@FindBy(xpath = "//td[text()='Modify File Format List Check']")
	WebElement verifyModifyFileFormatListCheckPage;

	@FindBy(xpath = "//select[@name='entityId']")
	WebElement selectCorpoarteIdInModifyPage;
	@FindBy(xpath = "//input[@name='button']")
	WebElement submitbuttonModifyMaker;
	// form[@name='modifyCountry']//table//tr[15]//td//input[@name='Submit']

	@FindBy(xpath = "(//form[@name='modifyFormatList']//table//tr[50]//td//input[@name='button'])[1]")
	WebElement modifysubmitbutton;
	@FindBy(xpath = "//td[@class='note']")
	WebElement verificationMessageInModifyPaymentType;

	@FindBy(xpath = "//b[text()='Logout']")
	WebElement logoutMaker;

	// View Page in Checker
	//
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewInChecker;

	public FileFormatListCheck(WebDriver driver) {
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

// click on file Format list checker SubMenu
	public void clickOnFileFormatListCheckSubMenu() {
		log.info("click on File Format List Check SubMenu===>" + FileFormatListCheck.getText());
		FileFormatListCheck.click();
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

	static String splivaluesOfEntityId;
	static String corporateIdnewstring;
	static String getUniqueID;
	static String getCorporateRemittanceReferenceNumber;
	static String getDate;
	static String getRemitterName;
	static String getRemitterIDType;
	static String getRemitterIDNo;
	static String getRemittercustomerAddress1;
	static String getRemittercustomerPINZIPCode;
	static String getRemittersEmailID;
	static String getRemittersContactno;
	static String getRemittersCountry;
	static String getRemittersstate;
	static String getMandateType;
	static String getTransferAmount;
	static String getBeneficiaryName;
	static String getBeneficiaryCountry;
	static String getBeneficiaryState;
	static String getBeneficiarycustomerAddress1;
	static String getBeneficiarycustomerPINOrZIPCode;
	static String getBeneficiarycustomerEmailID;
	static String getBeneficiarycustomermobileno;
	static String getRemittancePurposeCode;
	static String getRemittanceTypeOrPurpose;
	static String getRelationshipwithbeneficiary;
	static String getBankName;
	static String getBankBranch;
	static String getBranchCode;
	static String getRoutingNumber;
	static String getBankAccountnumber;
	static String getBeneBankAddress;
	static String getCashAgentName;
	static String getCashAgentBranch;
	static String getBeneficiaryIDType;
	static String getBeneficiaryIDNo;
	static String getCashPayoutPin;
	static String getWalletName;
	static String getWalletNo;
	static String getDELIMITER;
	static String getRemitterDob;
	static String getBeneDob;
	static String getCurrency;
	static String getRemitterPassportNumber;
	static String getPassportExpirydate;
	static String getRemitterOtherID;
	static String getRemitterOtheridExpirydate;
	static String getRemitterOccupation;
	static String getpercentConsent;

	// select Corporate Id on Add File Format list Check Page
	public void selectCorporateIdOnAddFileFormatListCheckpage() {
		String s1 = "6786786";
		String s2 = "Prime Bank Ltd";
		corporateIdnewstring = s1 + "-" + s2;
		System.out.println("Get Text of Combination of Corporate id and Name ==>" + corporateIdnewstring);

		log.info("select Corporate Id on Add File Format list Check Page....." + selectCorporateId);
		Select selectCorporate = new Select(selectCorporateId);
		List<WebElement> listOfCorporateId = selectCorporate.getOptions();
		int GetNoOfCorpoarteId = listOfCorporateId.size();

		log.info("Get the Size of the Corporate Id On Drop Down... " + GetNoOfCorpoarteId);

		for (int i = 1; i < listOfCorporateId.size(); i++) {

			String GetTextOfCorporateIdFromDropDown = listOfCorporateId.get(i).getText();
			System.out.println("Get Text Of Corporate Id form Drop Down List...." + GetTextOfCorporateIdFromDropDown);
			String[] splt = GetTextOfCorporateIdFromDropDown.split("-");
			splivaluesOfEntityId = splt[0].trim();
			System.out.println("Get Text Of Enity Id from Corpoarte Drop down ==>" + splivaluesOfEntityId);
			if (listOfCorporateId.get(i).getText().equals(corporateIdnewstring)) {
				log.info("Text has Matched with value ==>" + corporateIdnewstring);
				log.info(" Corporate Id  drop down Text has Selected ==>" + corporateIdnewstring);
				selectCorporate.selectByVisibleText(corporateIdnewstring);
				break;
			}

			else {
				System.out.println("Drop Down Text has Matched Not Matched with value ==>" + corporateIdnewstring);
			}
		}

	}

// enter Unique ID in ADD File Format Check   page
	public void enterUniqueID(String UniqueID) {
		log.info("Enter Unoque ID  ===>" + UniqueID);
		this.UniqueID.sendKeys(UniqueID);
		getUniqueID = UniqueID.toString();
		System.out.println("Get Unique ID Value ==>" + getUniqueID);

	}

// enter Corporate Remittance Reference Number in Add Add File Format reference page
	public void enterCorporateRemittanceReferenceNumber(String CorporateRemittanceReferenceNumber) {
		log.info("enter Corporate Remittance Reference Number ...." + CorporateRemittanceReferenceNumber);
		this.CorporateRemittanceReferenceNumber.sendKeys(CorporateRemittanceReferenceNumber);
		getCorporateRemittanceReferenceNumber = CorporateRemittanceReferenceNumber.toString();
		System.out
				.println("Get Corporate Remittance Reference Number Value ==>" + getCorporateRemittanceReferenceNumber);
	}

	// enter Date On Add File Format reference page
	public void enterDateOnRequiredPosition(String Date) {
		log.info("enter Date On required Position ...." + Date);
		this.Date.sendKeys(Date);
		getDate = Date.toString();
		System.out.println("get Date Value ==>" + getDate);

	}

// enter Remitter Name On Add File Format reference page
	public void enterRemitterNameOnRequiredPosition(String RemitterName) {
		log.info("enter Remitter Name On required Position ...." + RemitterName);
		this.RemitterName.sendKeys(RemitterName);
		getRemitterName = RemitterName.toString();
		System.out.println("get Remitter Name Value ==>" + getRemitterName);
	}

	// enter Remitter ID Type On Add File Format reference page
	public void enterRemitterIDTypeOnRequiredPosition(String RemitterIDType) {
		log.info("enter Remitter ID Type On required Position ...." + RemitterIDType);
		this.RemitterIDType.sendKeys(RemitterIDType);
		getRemitterIDType = RemitterIDType.toString();
		System.out.println("get Remitter ID Type Value ==>" + getRemitterIDType);
	}

	// enter Remitter ID No On Add File Format reference page
	public void enterRemitterIDNoOnRequiredPosition(String RemitterIDNo) {
		log.info("enter Remitter ID No ...." + RemitterIDNo);
		this.RemitterIDNo.sendKeys(RemitterIDNo);
		getRemitterIDNo = RemitterIDNo.toString();
		System.out.println("get Remitter ID No Value ==>" + getRemitterIDNo);
	}

	// enter Remitter customer Address1 On Add File Format reference page
	public void enterRemittercustomerAddress1OnRequiredPosition(String RemittercustomerAddress1) {
		log.info("enter Remitter ID No ...." + RemittercustomerAddress1);
		this.RemittercustomerAddress1.sendKeys(RemittercustomerAddress1);
		getRemittercustomerAddress1 = RemittercustomerAddress1.toString();
		System.out.println("get Remitter customer Address1 Value ==>" + getRemittercustomerAddress1);
	}

	// enter Remitter customer PIN ZIP Code On Add File Format reference page
	public void enterRemittercustomerPINZIPCode(String RemittercustomerPINZIPCode) {
		log.info("enter Remitter customer PIN ZIP PCode...." + RemittercustomerPINZIPCode);
		this.RemittercustomerPINZIPCode.sendKeys(RemittercustomerPINZIPCode);
		getRemittercustomerPINZIPCode = RemittercustomerPINZIPCode.toString();
		System.out.println("get Remitter customer PIN ZIP Code Value ==>" + getRemittercustomerPINZIPCode);
	}

//enter Remitters Email ID On Add File Format reference page
	public void enterRemittersEmailID(String RemittersEmailID) {
		log.info("enter Remitters Email ID...." + RemittersEmailID);
		this.RemittersEmailID.sendKeys(RemittersEmailID);
		getRemittersEmailID = RemittersEmailID.toString();
		System.out.println("get Remitters Email ID Value ==>" + getRemittersEmailID);
	}

//enter Remitters Contact no On Add File Format reference page
	public void enterRemittersContactno(String RemittersContactno) {
		log.info("enter Remitters Contact No...." + RemittersContactno);
		this.RemittersContactno.sendKeys(RemittersContactno);
		getRemittersContactno = RemittersContactno.toString();
		System.out.println("get Remitters Contact no Value ==>" + getRemittersContactno);
	}

//enter Remitters Country On Add File Format reference page
	public void enterRemittersCountry(String RemittersCountry) {
		log.info("enter Remitters Country...." + RemittersCountry);
		this.RemittersCountry.sendKeys(RemittersCountry);
		getRemittersCountry = RemittersCountry.toString();
		System.out.println("get Remitters Country Value ==>" + getRemittersCountry);
	}

//enter Remitters Country On Add File Format reference page
	public void enterRemittersstate(String Remittersstate) {
		log.info("enter Remitters state...." + Remittersstate);
		this.Remittersstate.sendKeys(Remittersstate);
		getRemittersstate = Remittersstate.toString();
		System.out.println("get Remitters state Value ==>" + getRemittersstate);
	}

//enter Mandate Type On Add File Format list check page
	public void enterMandateType(String MandateType) {
		log.info("enter Mandate Type...." + MandateType);
		this.MandateType.sendKeys(MandateType);
		getMandateType = MandateType.toString();
		System.out.println("get Mandate Type Value ==>" + getMandateType);
	}

//enter Transfer Amount On Add File Format list check page
	public void enterTransferAmount(String TransferAmount) {
		log.info("enter Transfer Amount..." + TransferAmount);
		this.TransferAmount.sendKeys(TransferAmount);
		getTransferAmount = TransferAmount.toString();
		System.out.println("get Transfer Amount Value ==>" + getTransferAmount);
	}

//enter Transfer Amount On Add File Format list check page
	public void enterBeneficiaryName(String BeneficiaryName) {
		log.info("enter Beneficiary Name..." + BeneficiaryName);
		this.BeneficiaryName.sendKeys(BeneficiaryName);
		getBeneficiaryName = BeneficiaryName.toString();
		System.out.println("get Beneficiary Name Value ==>" + getBeneficiaryName);
	}

//enter Beneficiary Country On Add File Format list check page
	public void enterBeneficiaryCountry(String BeneficiaryCountry) {
		log.info("enter Beneficiary Country..." + BeneficiaryCountry);
		this.BeneficiaryCountry.sendKeys(BeneficiaryCountry);
		getBeneficiaryCountry = BeneficiaryCountry.toString();
		System.out.println("get Beneficiary Country Value ==>" + getBeneficiaryCountry);
	}

//enter Beneficiary State On Add File Format list check page
	public void enterBeneficiaryState(String BeneficiaryState) {
		log.info("enter Beneficiary State..." + BeneficiaryState);
		this.BeneficiaryState.sendKeys(BeneficiaryState);
		getBeneficiaryState = BeneficiaryState.toString();
		System.out.println("get Beneficiary State Value ==>" + getBeneficiaryState);
	}

//enter Beneficiary customer Address1 On Add File Format list check page
	public void enterBeneficiarycustomerAddress1(String BeneficiarycustomerAddress1) {
		log.info("enter Beneficiary customer Address1..." + BeneficiarycustomerAddress1);
		this.BeneficiarycustomerAddress1.sendKeys(BeneficiarycustomerAddress1);
		getBeneficiarycustomerAddress1 = BeneficiarycustomerAddress1.toString();
		System.out.println("get Beneficiary customer Address1 Value ==>" + getBeneficiarycustomerAddress1);
	}

//enter Beneficiary customer PIN Or ZIP Code On Add File Format list check page
	public void enterBeneficiarycustomerPINOrZIPCode(String BeneficiarycustomerPINOrZIPCode) {
		log.info("enter Beneficiary customer PIN Or ZIP Code..." + BeneficiarycustomerPINOrZIPCode);
		this.BeneficiarycustomerPINOrZIPCode.sendKeys(BeneficiarycustomerPINOrZIPCode);
		getBeneficiarycustomerPINOrZIPCode = BeneficiarycustomerPINOrZIPCode.toString();
		System.out.println("get Beneficiary customer PIN Or ZIP Code Value ==>" + getBeneficiarycustomerPINOrZIPCode);
	}

//enter Beneficiary customer Email ID On Add File Format list check page
	public void enterBeneficiarycustomerEmailID(String BeneficiarycustomerEmailID) {
		log.info("enter Beneficiary customer Email ID.." + BeneficiarycustomerEmailID);
		this.BeneficiarycustomerEmailID.sendKeys(BeneficiarycustomerEmailID);
		getBeneficiarycustomerEmailID = BeneficiarycustomerEmailID.toString();
		System.out.println("get Beneficiary customer Email ID Value ==>" + getBeneficiarycustomerEmailID);

	}

// Enter Beneficiary customer mobile no On Add File Format list check page
	public void enterBeneficiarycustomermobileno(String Beneficiarycustomermobileno) {
		log.info("enter Beneficiary customer mobile No.." + Beneficiarycustomermobileno);
		this.Beneficiarycustomermobileno.sendKeys(Beneficiarycustomermobileno);
		getBeneficiarycustomermobileno = Beneficiarycustomermobileno.toString();
		System.out.println("get Beneficiary customer mobile no Value ==>" + getBeneficiarycustomermobileno);
	}

//Enter Remittance Purpose Code On Add File Format list check page
	public void enterRemittancePurposeCode(String RemittancePurposeCode) {
		log.info("enter Remittance PurposeC ode....." + RemittancePurposeCode);
		this.RemittancePurposeCode.sendKeys(RemittancePurposeCode);
		getRemittancePurposeCode = RemittancePurposeCode.toString();
		System.out.println("get Remittance Purpose Code Value ==>" + getRemittancePurposeCode);
	}

	// Enter Remittance Type Or Purpose On Add File Format list check page
	public void enterRemittanceTypeOrPurpose(String RemittanceTypeOrPurpose) {
		log.info("enter Remittance Type OR Purpose....." + RemittanceTypeOrPurpose);
		this.RemittanceTypeOrPurpose.sendKeys(RemittanceTypeOrPurpose);
		getRemittanceTypeOrPurpose = RemittanceTypeOrPurpose.toString();
		System.out.println("get Remittance Type Or Purpose Value ==>" + getRemittanceTypeOrPurpose);
	}

//Enter Relationship with beneficiary On Add File Format list check page
	public void enterRelationshipwithbeneficiary(String Relationshipwithbeneficiary) {
		log.info("enter Relationship with beneficiary...." + Relationshipwithbeneficiary);
		this.Relationshipwithbeneficiary.sendKeys(Relationshipwithbeneficiary);
		getRelationshipwithbeneficiary = Relationshipwithbeneficiary.toString();
		System.out.println("get Relationship with beneficiary Value ==>" + getRelationshipwithbeneficiary);
	}

//Enter Bank Name On Add File Format list check page
	public void enterBankName(String BankName) {
		log.info("enter Bank Name...." + BankName);
		this.BankName.sendKeys(BankName);
		getBankName = BankName.toString();
		System.out.println("get Bank Name Value ==>" + getBankName);
	}

//Enter Bank Branch On Add File Format list check page
	public void enterBankBranch(String BankBranch) {
		log.info("enter Bank Branch...." + BankBranch);
		this.BankBranch.sendKeys(BankBranch);
		getBankBranch = BankBranch.toString();
		System.out.println("get Bank Branch Value ==>" + getBankBranch);
	}

//Enter Branch Code On Add File Format list check page
	public void enterBranchCode(String BranchCode) {
		log.info("enter Banch Code ...." + BranchCode);
		this.BranchCode.sendKeys(BranchCode);
		getBranchCode = BranchCode.toString();
		System.out.println("get Branch Code Value ==>" + getBranchCode);
	}

//Enter Routing Number On Add File Format list check page
	public void enterRoutingNumber(String RoutingNumber) {
		log.info("enter Routing Number...." + RoutingNumber);
		this.RoutingNumber.sendKeys(RoutingNumber);
		getRoutingNumber = RoutingNumber.toString();
		System.out.println("get Routing Number Value ==>" + getRoutingNumber);
	}

//Enter Bank Account number On Add File Format list check page
	public void enterBankAccountnumber(String BankAccountnumber) {
		log.info("enter Bank Account number...." + BankAccountnumber);
		this.BankAccountnumber.sendKeys(BankAccountnumber);
		getBankAccountnumber = BankAccountnumber.toString();
		System.out.println("get Bank Account number Value ==>" + getBankAccountnumber);
	}

//Enter Bene BankAddress On Add File Format list check page
	public void enterBeneBankAddress(String BeneBankAddress) {
		log.info("enter Beneficianry Bank Address...." + BeneBankAddress);
		this.BeneBankAddress.sendKeys(BeneBankAddress);
		getBeneBankAddress = BeneBankAddress.toString();
		System.out.println("get Bene Bank Address Value ==>" + getBeneBankAddress);

	}

//Enter Cash Agent Name On Add File Format list check page
	public void enterCashAgentName(String CashAgentName) {
		log.info("enter Cash Agent Name...." + CashAgentName);
		this.CashAgentName.sendKeys(CashAgentName);
		getCashAgentName = CashAgentName.toString();
		System.out.println("get Cash Agent Name Value ==>" + getCashAgentName);
	}

//Enter Cash Agent Branch On Add File Format list check page
	public void enterCashAgentBranch(String CashAgentBranch) {
		log.info("enter Cash Agent Branch...." + CashAgentBranch);
		this.CashAgentBranch.sendKeys(CashAgentBranch);
		getCashAgentBranch = CashAgentBranch.toString();
		System.out.println("get Cash Agent Branch Value ==>" + getCashAgentBranch);
	}

//Enter Beneficiary ID Type On Add File Format list check page
	public void enterBeneficiaryIDType(String BeneficiaryIDType) {
		log.info("enter Beneficiary ID Type...." + BeneficiaryIDType);
		this.BeneficiaryIDType.sendKeys(BeneficiaryIDType);
		getBeneficiaryIDType = BeneficiaryIDType.toString();
		System.out.println("get Beneficiary ID Type Value ==>" + getBeneficiaryIDType);
	}

//Enter Beneficiary ID No On Add File Format list check page
	public void enterBeneficiaryIDNo(String BeneficiaryIDNo) {
		log.info("enter Beneficiary ID No...." + BeneficiaryIDNo);
		this.BeneficiaryIDNo.sendKeys(BeneficiaryIDNo);
		getBeneficiaryIDNo = BeneficiaryIDNo.toString();
		System.out.println("get Beneficiary ID No Value ==>" + getBeneficiaryIDNo);
	}

//Enter CashPayout Pay in On Add File Format list check page
	public void enterCashPayoutPin(String CashPayoutPin) {
		log.info("enter Cash Payout Pay in...." + CashPayoutPin);
		this.CashPayoutPin.sendKeys(CashPayoutPin);
		getCashPayoutPin = CashPayoutPin.toString();
		System.out.println("get Cash Payout Pin Value ==>" + getCashPayoutPin);
	}

//Enter Wallet Name in On Add File Format list check page
	public void enterWalletName(String WalletName) {
		log.info("enter Wallet Name...." + WalletName);
		this.WalletName.sendKeys(WalletName);
		getWalletName = WalletName.toString();
		System.out.println("get Wallet Name Value ==>" + getWalletName);
	}

//Enter Wallet No in On Add File Format list check page
	public void enterWalletNo(String WalletNo) {
		log.info("enter Wallet No...." + WalletNo);
		this.WalletNo.sendKeys(WalletNo);
		getWalletNo = WalletNo.toString();
		System.out.println("get Wallet No Value ==>" + getWalletNo);
	}

//Enter DELIMITER in On Add File Format list check page
	public void enterDELIMITER(String DELIMITER) {
		log.info("enter DELIMITER...." + DELIMITER);
		this.DELIMITER.sendKeys(DELIMITER);
		getDELIMITER = DELIMITER.toString();
		System.out.println("get DELIMITER Value ==>" + getDELIMITER);
	}

//Enter Remitter Dob in On Add File Format list check page
	public void enterRemitterDob(String RemitterDob) {
		log.info("enter Remitter D.o.b..." + RemitterDob);
		this.RemitterDob.sendKeys(RemitterDob);
		getRemitterDob = RemitterDob.toString();
		System.out.println("get Remitter D.O.B Value ==>" + getRemitterDob);
	}

//Enter Bene Dob in On Add File Format list check page
	public void enterBeneDob(String BeneDob) {
		log.info("enter Beneficiary Date of Birth ...." + BeneDob);
		this.BeneDob.sendKeys(BeneDob);
		getBeneDob = BeneDob.toString();
		System.out.println("get Bene D.O.B Value ==>" + getBeneDob);
	}

//Enter Currency in On Add File Format list check page
	public void enterCurrency(String Currency) {
		log.info("enter Currency...." + Currency);
		this.Currency.sendKeys(Currency);
		getCurrency = Currency.toString();
		System.out.println("get Currency Value ==>" + getCurrency);
	}

//Enter Remitter Passport Number On Add File Format list check page
	public void enterRemitterPassportNumber(String RemitterPassportNumber) {
		log.info("enter Remitter Passport Number...." + RemitterPassportNumber);
		this.RemitterPassportNumber.sendKeys(RemitterPassportNumber);
		getRemitterPassportNumber = RemitterPassportNumber.toString();
		System.out.println("get Remitter Passport Number Value ==>" + getRemitterPassportNumber);
	}

//Enter Passport Expiry date On Add File Format list check page
	public void enterPassportExpirydate(String PassportExpirydate) {
		log.info("enter Passport Expiry date...." + PassportExpirydate);
		this.PassportExpirydate.sendKeys(PassportExpirydate);
		getPassportExpirydate = PassportExpirydate.toString();
		System.out.println("get Passport Expiry date Value ==>" + getPassportExpirydate);
	}

//Enter Remitter Other ID On Add File Format list check page
	public void enterRemitterOtherID(String RemitterOtherID) {
		log.info("enter Remitter Other ID...." + RemitterOtherID);
		this.RemitterOtherID.sendKeys(RemitterOtherID);
		getRemitterOtherID = RemitterOtherID.toString();
		System.out.println("get Remitter Other ID Value ==>" + getRemitterOtherID);
	}

//Enter Remitter Other id Expiry date On Add File Format list check page
	public void enterRemitterOtheridExpirydate(String RemitterOtheridExpirydate) {
		log.info("enter Remitter Other id Expiry date...." + RemitterOtheridExpirydate);
		this.RemitterOtheridExpirydate.sendKeys(RemitterOtheridExpirydate);
		getRemitterOtheridExpirydate = RemitterOtheridExpirydate.toString();
		System.out.println("get Remitter Other id Expiry date Value ==>" + getRemitterOtheridExpirydate);
	}

//Enter Remitter Occupation On Add File Format list check page
	public void enterRemitterOccupation(String RemitterOccupation) {
		log.info("enter Remitter Occupation...." + RemitterOccupation);
		this.RemitterOccupation.sendKeys(RemitterOccupation);
		getRemitterOccupation = RemitterOccupation.toString();
		System.out.println("get Remitter Occupation Value ==>" + getRemitterOccupation);
	}

//Enter percent Consent On Add File Format list check page
	public void enterpercentConsent(String percentConsent) {
		log.info("enter 2 percent Consent...." + percentConsent);
		this.percentConsent.sendKeys(percentConsent);
		getpercentConsent = percentConsent.toString();
		System.out.println("get percent Consent Value ==>" + getpercentConsent);
	}

// click on  submit In add  Payment Type Maker page
	public void clickonsubmitInMakerpage() {
		log.info("click on submit In Maker page==>" + submitInMakerpage);
		submitInMakerpage.click();
	}

	public void handleThePopup() {
		String popUpText = driver.switchTo().alert().getText();
		log.info("Get Text of Pop Up ==>" + popUpText);
		log.info("Click On ok On  Popup ==>");
		driver.switchTo().alert().accept();

	}

//  to verify the Successful Message to the Added the Payment Type  maker Successfully
	public void verifySuccesfullMessage() {

		String verifythemodify = SuccesfullMessage.getText();
		System.out.println("verify the Successful Message===>>>" + verifythemodify);
		log.info("verify the Successful Message===>>>" + verifythemodify);
		if (verifythemodify.equals("Record has been added successfully.")) {
			log.info("Record has been added successfully.");

		} else if (verifythemodify.equals("Record Already Exists")) {
			log.info("This Country Code has already used");

		} else if (verifythemodify.equals("Record Already Exists")) {
			log.info("Record Already Exists");

		}

		else {
			log.info(" ....Verify Message is not Matched....");

		}
	}

	public void clickOnLogOutButtonOnMakerPage() {
		log.info("click On Log Out Button ==>");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//b[text()='Logout']")).click();
	}

// click on Master Definition Checker
	public void clickonMasterDefinitionChecker() {
		log.info(" Get text Master Definition Checker" + MasterDefinitionChecker.getText());
		log.info("Clcik on MasterDefinitionChecker====");
		MasterDefinitionChecker.click();

	}

	// click Authorise Purpose checker SubMenu
	public void clickOnAuthoriserPurposeSubMenu() {
		log.info("click On Authoriser Purpose Checker SubMenu..." + AuthoriserPurpose.getText());
		AuthoriserPurpose.click();
	}

	// verify Purpose Checker Page
	public void verifyPurposeCheckerPages() throws Exception {
		log.info("verify PURPOSE CHECKER Page...");
		Thread.sleep(3000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);

		log.info("verify Purpose Checker Page." + verifyPurposeCheckerPage.getText());
		String purposeCheckerPage = verifyPurposeCheckerPage.getText();

		System.out.println("Get the Text of  purpose Checker Page..." + purposeCheckerPage);
		Assert.assertEquals("PURPOSE CHECKER", purposeCheckerPage);
		log.info(" Suceessfully verified the Purpose Checker Page...");
	}

	// calling path variables and verifyAddcheckerList in purpose Checker page.
	// verify Add purpose maker at checker List In Checker page()
	public void verifyAddcheckerListInCheckerpage() throws InterruptedException {
		String CountryCode = "//table[@id='list']//tbody/tr/td[4]";
		String PurposeCode = "//table[@id='list']//tbody/tr/td[5]";
		String purposeDesc = "//table[@id='list']//tbody/tr/td[6]";
		String PurposeType = "//table[@id='list']//tbody/tr/td[7]";
		String IsActive = "//table[@id='list']//tbody/tr/td[8]";

		StoverifyCheckerlist(CountryCode, "aa");
		StoverifyCheckerlist(PurposeCode, "bb");
		StoverifyCheckerlist(purposeDesc, "cc");
		StoverifyCheckerlist(PurposeType, "Y");
		StoverifyCheckerlist(IsActive, "Y");
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
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().defaultContent();
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 100); WebElement Category_Body
		 * = wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath("//td[@class='mainmenu']//following-sibling::a[text()='Logout']")));
		 * System.out.println(Category_Body);
		 */

		driver.findElement(By.xpath("//b[text()='Logout']")).click();

	}

	// View page in Maker , After Approved by the Checker data
	public void clickOnviewButtoninMakerPage() {
		/*
		 * List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		 * System.out.println(iframeElements);
		 * 
		 * driver.switchTo().frame(0); JavascriptExecutor js1 = (JavascriptExecutor)
		 * driver; js1.executeScript("window.scrollBy(0,-250)", ""); //
		 * driver.switchTo().defaultContent(); // To find the Frame is Available or not
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, 100); WebElement Category_Body
		 * = wait.until(ExpectedConditions.visibilityOfElementLocated((By)
		 * viewinMaker)); System.out.println(Category_Body);
		 */

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
// 1. when the Verify the Maker View page .
	public void verifyViewpageBySearchField() throws Exception {
		this.searchfield.clear();
		log.info("Search By Entity Id ==>" + splivaluesOfEntityId);
		this.searchfield.sendKeys(splivaluesOfEntityId);
		this.searchfield.clear();
		log.info("Search By Unique ID ==>" + getUniqueID);
		this.searchfield.sendKeys(getUniqueID);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("Search By Corporate Remittance Reference Number ==>" + getCorporateRemittanceReferenceNumber);
		this.searchfield.sendKeys(getCorporateRemittanceReferenceNumber);
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
	public void multippleSelectVerifyTextInViewPage() {

		String MappingID = "//tbody[@role='alert']//tr//td[2]";
		String EntityID = "//tbody[@role='alert']//tr//td[3]";
		String UNIQUEID = "//tbody[@role='alert']//tr//td[4]";
		String CORPOPORATEREMITERREFRENENCENUMBER = "//tbody[@role='alert']//tr//td[5]";
		String REMITTERNAME = "//tbody[@role='alert']//tr//td[6]";
		String RemitterIdType = "//tbody[@role='alert']//tr//td[7]";
		String RemitterIdNumber = "//tbody[@role='alert']//tr//td[8]";
		String RemitterCustomerAddress = "//tbody[@role='alert']//tr//td[9]";
		String RemitterCustomerZipCode = "//tbody[@role='alert']//tr//td[10]";
		String RemitterEmailId = "//tbody[@role='alert']//tr//td[11]";
		String RemitterContactNo = "//tbody[@role='alert']//tr//td[12]";
		String RemitterCountry = "//tbody[@role='alert']//tr//td[13]";
		String RemitterState = "//tbody[@role='alert']//tr//td[14]";
		String MandateType = "//tbody[@role='alert']//tr//td[15]";
		String TransferAmount = "//tbody[@role='alert']//tr//td[16]";
		String BenefiecryName = "//tbody[@role='alert']//tr//td[17]";
		String BenefiecryCountry = "//tbody[@role='alert']//tr//td[18]";
		String BenefiecryState = "//tbody[@role='alert']//tr//td[19]";
		String BenefiecryCustomerAddress1 = "//tbody[@role='alert']//tr//td[20]";
		String BenefiecryCustomerZipCode = "//tbody[@role='alert']//tr//td[21]";
		String BenefiecryCustomerEmailId = "//tbody[@role='alert']//tr//td[22]";
		String BenefiecryCustomerMobileNo = "//tbody[@role='alert']//tr//td[23]";
		String RemittancePurposeCode = "//tbody[@role='alert']//tr//td[24]";
		String RemittancePurpose = "//tbody[@role='alert']//tr//td[25]";
		String RelashionshipWithBeneficiary = "//tbody[@role='alert']//tr//td[26]";
		String BankName = "//tbody[@role='alert']//tr//td[27]";
		String BankBranch = "//tbody[@role='alert']//tr//td[28]";
		String BranchCode = "//tbody[@role='alert']//tr//td[29]";
		String RoutingNumber = "//tbody[@role='alert']//tr//td[30]";
		String BankAccountNumber = "//tbody[@role='alert']//tr//td[31]";
		String BeneBankAddress = "//tbody[@role='alert']//tr//td[32]";
		String CashAgentName = "//tbody[@role='alert']//tr//td[33]";
		String CashAgentBranch = "//tbody[@role='alert']//tr//td[34]";
		String BeneficieryIdType = "//tbody[@role='alert']//tr//td[35]";
		String BeneficieryIdNo = "//tbody[@role='alert']//tr//td[36]";
		String CashPayOutPayIn = "//tbody[@role='alert']//tr//td[37]";
		String WallentName = "//tbody[@role='alert']//tr//td[38]";
		String WalletNo = "//tbody[@role='alert']//tr//td[39]";
		String Date = "//tbody[@role='alert']//tr//td[40]";
		String Dellimitter = "//tbody[@role='alert']//tr//td[41]";
		String RemitterDOB = "//tbody[@role='alert']//tr//td[42]";
		String BeneficiaryDOB = "//tbody[@role='alert']//tr//td[43]";
		String DisbCurrency = "//tbody[@role='alert']//tr//td[44]";
		String RemitterPassportNo = "//tbody[@role='alert']//tr//td[45]";
		String RemitterPassportExpieryDate = "//tbody[@role='alert']//tr//td[46]";
		String RemitterOtherId = "//tbody[@role='alert']//tr//td[47]";
		String RemitterOtherIdExpieryDate = "//tbody[@role='alert']//tr//td[48]";
		String RemitterOccupasion = "//tbody[@role='alert']//tr//td[49]";
		String CONSENT = "//tbody[@role='alert']//tr//td[50]";

		verifytheViewpageWithText(MappingID, "2");
		verifytheViewpageWithText(EntityID, splivaluesOfEntityId);
		verifytheViewpageWithText(UNIQUEID, getUniqueID);
		verifytheViewpageWithText(CORPOPORATEREMITERREFRENENCENUMBER, getCorporateRemittanceReferenceNumber);
		verifytheViewpageWithText(REMITTERNAME, getRemitterName);
		verifytheViewpageWithText(RemitterIdType, getRemitterIDType);
		verifytheViewpageWithText(RemitterIdNumber, getRemitterIDNo);
		verifytheViewpageWithText(RemitterCustomerAddress, getRemittercustomerAddress1);
		verifytheViewpageWithText(RemitterCustomerZipCode, getRemittercustomerPINZIPCode);
		verifytheViewpageWithText(RemitterEmailId, getRemittersEmailID);
		verifytheViewpageWithText(RemitterContactNo, getRemittersContactno);
		verifytheViewpageWithText(RemitterCountry, getRemittersCountry);
		verifytheViewpageWithText(RemitterState, getRemittersstate);
		verifytheViewpageWithText(MandateType, getMandateType);
		verifytheViewpageWithText(TransferAmount, getTransferAmount);
		verifytheViewpageWithText(BenefiecryName, getBeneficiaryName);
		verifytheViewpageWithText(BenefiecryCountry, getBeneficiaryCountry);
		verifytheViewpageWithText(BenefiecryState, getBeneficiaryState);
		verifytheViewpageWithText(BenefiecryCustomerAddress1, getBeneficiarycustomerAddress1);
		verifytheViewpageWithText(BenefiecryCustomerZipCode, getBeneficiarycustomerPINOrZIPCode);
		verifytheViewpageWithText(BenefiecryCustomerEmailId, getBeneficiarycustomerEmailID);
		verifytheViewpageWithText(BenefiecryCustomerMobileNo, getBeneficiarycustomermobileno);
		verifytheViewpageWithText(RemittancePurposeCode, getRemittancePurposeCode);
		verifytheViewpageWithText(RemittancePurpose, getRemittanceTypeOrPurpose);
		verifytheViewpageWithText(RelashionshipWithBeneficiary, getRelationshipwithbeneficiary);
		verifytheViewpageWithText(BankName, getBankName);
		verifytheViewpageWithText(BankBranch, getBankBranch);
		verifytheViewpageWithText(BranchCode, getRoutingNumber);
		verifytheViewpageWithText(RoutingNumber, getRoutingNumber);
		verifytheViewpageWithText(BankAccountNumber, getBankAccountnumber);
		verifytheViewpageWithText(BeneBankAddress, getBeneBankAddress);
		verifytheViewpageWithText(CashAgentName, getCashAgentName);
		verifytheViewpageWithText(CashAgentBranch, getCashAgentBranch);
		verifytheViewpageWithText(BeneficieryIdType, getBeneficiaryIDType);
		verifytheViewpageWithText(BeneficieryIdNo, getBeneficiaryIDNo);
		verifytheViewpageWithText(CashPayOutPayIn, getCashPayoutPin);
		verifytheViewpageWithText(WallentName, getWalletName);
		verifytheViewpageWithText(WalletNo, getWalletNo);
		verifytheViewpageWithText(Date, getDate);
		verifytheViewpageWithText(Dellimitter, getDELIMITER);
		verifytheViewpageWithText(RemitterDOB, getRemitterDob);
		verifytheViewpageWithText(BeneficiaryDOB, getBeneDob);
		verifytheViewpageWithText(DisbCurrency, getCurrency);
		verifytheViewpageWithText(RemitterPassportNo, getRemitterPassportNumber);
		verifytheViewpageWithText(RemitterPassportExpieryDate, getPassportExpirydate);
		verifytheViewpageWithText(RemitterOtherId, getRemitterOtherID);
		verifytheViewpageWithText(RemitterOtherIdExpieryDate, getRemitterOtheridExpirydate);
		verifytheViewpageWithText(RemitterOccupasion, getRemitterOccupation);
		verifytheViewpageWithText(CONSENT, getpercentConsent);

	}

// 
// verify the View Maker Page with Text with thier respective Column
	public static void verifytheViewpageWithText(String xpathvalue, String value) {
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list on View  page ==>" + Nooflist);
		for (int i = 0; i < list1.size(); i++) {
			String listText = list1.get(i).getText();
			System.out.println(" Get Text of  List on view Page ==>" + listText);
			if (list1.get(i).getText().equals(value)) {
				System.out.println("Get Text  of List Matched With Value ==>" + value);
				break;
			} else {

				System.out.println("Get Text  of List NOT Matched With Value ==>" + value);
			}
		}

	}

// Select  All Drop down values in Maker view page when the Added Currency has Approved By Checker 
	public void selectAllvaluesOneByOne() {
		// WebElement
		WebElement MAPPINGID = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement ENTITYID = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement UNIQUEID = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement CORPORATEREMITERREFERENCENO2 = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement REMITTERNAME = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));
		WebElement REMITTERIdType = driver.findElement(By.xpath("//tfoot//tr//th[7]//select"));
		WebElement REMITTERIDNO = driver.findElement(By.xpath("//tfoot//tr//th[8]//select"));
		WebElement REMITTERCUTOMERADDRESS = driver.findElement(By.xpath("//tfoot//tr//th[9]//select"));
		WebElement REMITTERCUSTOMERZIPCODE = driver.findElement(By.xpath("//tfoot//tr//th[10]//select"));
		WebElement REMITTEREMAILID = driver.findElement(By.xpath("//tfoot//tr//th[11]//select"));
		WebElement REMITTERCONTACTNO = driver.findElement(By.xpath("//tfoot//tr//th[12]//select"));
		WebElement REMITTERCONTRY = driver.findElement(By.xpath("//tfoot//tr//th[13]//select"));
		WebElement REMITTERSTATE = driver.findElement(By.xpath("//tfoot//tr//th[14]//select"));
		WebElement REMITTERMANDATETYPE = driver.findElement(By.xpath("//tfoot//tr//th[15]//select"));
		WebElement REMITTERTRANSFERAMOUNT = driver.findElement(By.xpath("//tfoot//tr//th[16]//select"));
		WebElement BENEFICIARYNAME = driver.findElement(By.xpath("//tfoot//tr//th[17]//select"));
		WebElement BENEFICIARYCOUNTRY = driver.findElement(By.xpath("//tfoot//tr//th[18]//select"));
		WebElement BENEFICIARYSTATE = driver.findElement(By.xpath("//tfoot//tr//th[19]//select"));
		WebElement BENEFICIARYCUSTOMERADDRESS = driver.findElement(By.xpath("//tfoot//tr//th[20]//select"));
		WebElement BENEFICIARYCUSTOMERZIPCODE = driver.findElement(By.xpath("//tfoot//tr//th[21]//select"));
		WebElement BENEFICIARYCUSTOMEREMAILID = driver.findElement(By.xpath("//tfoot//tr//th[22]//select"));
		WebElement BENEFICIARYCUSTOMERMOBILENO = driver.findElement(By.xpath("//tfoot//tr//th[23]//select"));
		WebElement REMITTANCEPURPOSECODE = driver.findElement(By.xpath("//tfoot//tr//th[24]//select"));
		WebElement REMITTANCEPURPOSE = driver.findElement(By.xpath("//tfoot//tr//th[25]//select"));
		WebElement RELATIONSHIPWITHBENEFICIARY = driver.findElement(By.xpath("//tfoot//tr//th[26]//select"));
		WebElement BANKNAME = driver.findElement(By.xpath("//tfoot//tr//th[27]//select"));
		WebElement BANKBRANCH = driver.findElement(By.xpath("//tfoot//tr//th[28]//select"));
		WebElement BANKBRANCHCODE = driver.findElement(By.xpath("//tfoot//tr//th[29]//select"));
		WebElement ROUTINGNO = driver.findElement(By.xpath("//tfoot//tr//th[30]//select"));
		WebElement BANKACCOUNTNO = driver.findElement(By.xpath("//tfoot//tr//th[31]//select"));
		WebElement BENEFICIARYBANKADDRESS = driver.findElement(By.xpath("//tfoot//tr//th[32]//select"));
		WebElement CASHAGENTNAME = driver.findElement(By.xpath("//tfoot//tr//th[33]//select"));
		WebElement CASHAGENTNBRANCH = driver.findElement(By.xpath("//tfoot//tr//th[34]//select"));
		WebElement BENEFICIARYIDTYPE = driver.findElement(By.xpath("//tfoot//tr//th[35]//select"));
		WebElement BENEFICIARYIDNO = driver.findElement(By.xpath("//tfoot//tr//th[36]//select"));
		WebElement CASHPAYOUTPAYIN = driver.findElement(By.xpath("//tfoot//tr//th[37]//select"));
		WebElement WALLETNAME = driver.findElement(By.xpath("//tfoot//tr//th[38]//select"));
		WebElement WALLETNO = driver.findElement(By.xpath("//tfoot//tr//th[39]//select"));
		WebElement DATE = driver.findElement(By.xpath("//tfoot//tr//th[40]//select"));
		WebElement DELIMITER = driver.findElement(By.xpath("//tfoot//tr//th[41]//select"));
		WebElement REMITERDOB = driver.findElement(By.xpath("//tfoot//tr//th[42]//select"));
		WebElement BENFDOB = driver.findElement(By.xpath("//tfoot//tr//th[43]//select"));
		WebElement DISBCURRENCY = driver.findElement(By.xpath("//tfoot//tr//th[44]//select"));
		WebElement REMITTERPASSPORTNO = driver.findElement(By.xpath("//tfoot//tr//th[45]//select"));
		WebElement REMITTERPASSPORTEXPIRYDATE = driver.findElement(By.xpath("//tfoot//tr//th[46]//select"));
		WebElement REMITTEROTHERID = driver.findElement(By.xpath("//tfoot//tr//th[47]//select"));
		WebElement REMITTEROTHERIDEXPIRYDATE = driver.findElement(By.xpath("//tfoot//tr//th[48]//select"));
		WebElement REMITTEROCCUPATION = driver.findElement(By.xpath("//tfoot//tr//th[49]//select"));
		WebElement CONSENT = driver.findElement(By.xpath("//tfoot//tr//th[50]//select"));

		verifyBytheDropDownlistOneByOne(MAPPINGID, "2");
		verifyBytheDropDownlistOneByOne(ENTITYID, splivaluesOfEntityId);
		verifyBytheDropDownlistOneByOne(UNIQUEID, getUniqueID);
		verifyBytheDropDownlistOneByOne(CORPORATEREMITERREFERENCENO2, getCorporateRemittanceReferenceNumber);
		verifyBytheDropDownlistOneByOne(REMITTERNAME, getRemitterName);
		verifyBytheDropDownlistOneByOne(REMITTERIdType, getRemitterIDType);
		verifyBytheDropDownlistOneByOne(REMITTERIDNO, getRemitterIDNo);
		verifyBytheDropDownlistOneByOne(REMITTERCUTOMERADDRESS, getRemittercustomerAddress1);
		verifyBytheDropDownlistOneByOne(REMITTERCUSTOMERZIPCODE, getRemittercustomerPINZIPCode);
		verifyBytheDropDownlistOneByOne(REMITTEREMAILID, getRemittersEmailID);
		verifyBytheDropDownlistOneByOne(REMITTERCONTACTNO, getRemittersContactno);
		verifyBytheDropDownlistOneByOne(REMITTERCONTRY, getRemittersCountry);
		verifyBytheDropDownlistOneByOne(REMITTERSTATE, getRemittersstate);
		verifyBytheDropDownlistOneByOne(REMITTERMANDATETYPE, getMandateType);
		verifyBytheDropDownlistOneByOne(REMITTERTRANSFERAMOUNT, getTransferAmount);
		verifyBytheDropDownlistOneByOne(BENEFICIARYNAME, getBeneficiaryName);
		verifyBytheDropDownlistOneByOne(BENEFICIARYCOUNTRY, getBeneficiaryCountry);
		verifyBytheDropDownlistOneByOne(BENEFICIARYSTATE, getBeneficiaryState);
		verifyBytheDropDownlistOneByOne(BENEFICIARYCUSTOMERADDRESS, getBeneficiarycustomerAddress1);
		verifyBytheDropDownlistOneByOne(BENEFICIARYCUSTOMERZIPCODE, getBeneficiarycustomerPINOrZIPCode);
		verifyBytheDropDownlistOneByOne(BENEFICIARYCUSTOMEREMAILID, getBeneficiarycustomerEmailID);
		verifyBytheDropDownlistOneByOne(BENEFICIARYCUSTOMERMOBILENO, getBeneficiarycustomermobileno);
		verifyBytheDropDownlistOneByOne(REMITTANCEPURPOSECODE, getRemittancePurposeCode);
		verifyBytheDropDownlistOneByOne(REMITTANCEPURPOSE, getRemittanceTypeOrPurpose);
		verifyBytheDropDownlistOneByOne(RELATIONSHIPWITHBENEFICIARY, getRelationshipwithbeneficiary);
		verifyBytheDropDownlistOneByOne(BANKNAME, getBankName);
		verifyBytheDropDownlistOneByOne(BANKBRANCH, getBankBranch);
		verifyBytheDropDownlistOneByOne(BANKBRANCHCODE, getBranchCode);
		verifyBytheDropDownlistOneByOne(ROUTINGNO, getRoutingNumber);
		verifyBytheDropDownlistOneByOne(BANKACCOUNTNO, getBankAccountnumber);
		verifyBytheDropDownlistOneByOne(BENEFICIARYBANKADDRESS, getBeneBankAddress);
		verifyBytheDropDownlistOneByOne(CASHAGENTNAME, getCashAgentName);
		verifyBytheDropDownlistOneByOne(CASHAGENTNBRANCH, getCashAgentBranch);
		verifyBytheDropDownlistOneByOne(BENEFICIARYIDTYPE, getBeneficiaryIDType);
		verifyBytheDropDownlistOneByOne(BENEFICIARYIDNO, getBeneficiaryIDNo);
		verifyBytheDropDownlistOneByOne(CASHPAYOUTPAYIN, getCashPayoutPin);
		verifyBytheDropDownlistOneByOne(WALLETNAME, getWalletName);
		verifyBytheDropDownlistOneByOne(WALLETNO, getWalletNo);
		verifyBytheDropDownlistOneByOne(DATE, getDate);
		verifyBytheDropDownlistOneByOne(DELIMITER, getDELIMITER);
		verifyBytheDropDownlistOneByOne(REMITERDOB, getRemitterDob);
		verifyBytheDropDownlistOneByOne(BENFDOB, getBeneDob);
		verifyBytheDropDownlistOneByOne(DISBCURRENCY, getCurrency);
		verifyBytheDropDownlistOneByOne(REMITTERPASSPORTNO, getRemitterPassportNumber);
		verifyBytheDropDownlistOneByOne(REMITTERPASSPORTEXPIRYDATE, getPassportExpirydate);
		verifyBytheDropDownlistOneByOne(REMITTEROTHERID, getRemitterOtherID);
		verifyBytheDropDownlistOneByOne(REMITTEROTHERIDEXPIRYDATE, getRemitterOtheridExpirydate);
		verifyBytheDropDownlistOneByOne(REMITTEROCCUPATION, getRemitterOccupation);
		verifyBytheDropDownlistOneByOne(CONSENT, getpercentConsent);

	}

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
//verify Modify File Format List Check Page
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

		log.info(" Get the Text of MODIFY FILE FORMAT LIST CHECK Ppage===>>"
				+ verifyModifyFileFormatListCheckPage.getText());
		log.info(" verify the MODIFY FILE FORMAT LIST CHECK Ppage...");
		Assert.assertEquals(verifyModifyFileFormatListCheckPage.getText(), "MODIFY FILE FORMAT LIST CHECK");
		log.info(" Successfully verified the MODIFY FILE FORMAT LIST CHECK Ppage...");

	}

	// select Corporate Id In Modify Corporate Maker Page
	public void selectCorporateIdInModifyFileFormatListCheckPage() {

		Select selectCorpoarteIdInModify = new Select(selectCorpoarteIdInModifyPage);
		List<WebElement> getAllListofCorporateId = selectCorpoarteIdInModify.getOptions();
		int sizeofCorporateIdOnDropDown = getAllListofCorporateId.size();
		System.out.println("Get the No of Corporate Id On Drop Down==>>" + sizeofCorporateIdOnDropDown);

		for (int i = 0; i < getAllListofCorporateId.size(); i++) {
			String GetTextOfAllDropDownValues = getAllListofCorporateId.get(i).getText();
			System.out.println("Get Text Of All Drop Down Values ==>" + GetTextOfAllDropDownValues);
			String[] splt = GetTextOfAllDropDownValues.split("-");
			String splivalues = splt[0].trim();
			System.out.println("split values OfDrop Down ==>" + splivalues);

			if (splivalues.equals(splivaluesOfEntityId)) {
				log.info("Matched the Drrop Down values on Given Data ==>");
				selectCorpoarteIdInModify.selectByIndex(i);
				System.out.println(
						"Corporate Id Matched the From Corporate Id Drop Down In MODIFY File Format List Check page =>>");
				break;
			} else {

				System.out.println(
						"Corporate Id Not Matched the From Corporate Id Drop Down In MODIFY File Format List Check page ==>>");
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

	// verification Message In Modify Payment Type Page
	public void verificationMessageInModifyPaymentTypePage() throws Exception {
		log.info("Get the Text Of Verification Message In Modify format list check Page==>>"
				+ verificationMessageInModifyPaymentType.getText());
		// Assert.assertEquals(verificationMessageInModifyEntityType.getText(), "Record
		// has been modified successfully.");

		// verification Message In Modify Payment Type Page
		String verifythemodify = verificationMessageInModifyPaymentType.getText();
		System.out.println(
				"Get the Text Of Verification Message In Modify File format list check Page==>>" + verifythemodify);
		if (verifythemodify.equals("Record has been modified successfully.")) {
			Thread.sleep(4000);
			// driver.switchTo().defaultContent();
			// .info("==Successfull Message has Matched with Text==");
			// driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifythemodify.equals("This Mandate Type name has already used.")) {
			/*
			 * log.info("This Country Code has already used");
			 * driver.switchTo().defaultContent();
			 * driver.findElement(By.xpath("//b[text()='Logout']")).click();
			 */
		} else if (verifythemodify.equals("===Not==")) {
			log.info("This is Not Matched");

		} else {
			Thread.sleep(5000);
			/*
			 * driver.switchTo().defaultContent();
			 * log.info("==Successfull Message has Matched with  Text==");
			 * driver.findElement(By.xpath("//b[text()='Logout']")).click();
			 */
		}

	}

	// verify the Payment Type checker List IF Modification has Done By Maker with
	// Existing Entity
	//
	public void verifyListonCheckerpageWhenModificationhasDoneByMaker() throws InterruptedException {
		String CountryCode = "//table[@id='list']//tbody/tr/td[4]";
		String PurposeCode = "//table[@id='list']//tbody/tr/td[5]";
		String purposeDesc = "//table[@id='list']//tbody/tr/td[6]";
		String PurposeType = "//table[@id='list']//tbody/tr/td[7]";
		String IsActive = "//table[@id='list']//tbody/tr/td[8]";

		toverifyCheckerlistWhenModifiedMaker(CountryCode, "BD");
		toverifyCheckerlistWhenModifiedMaker(PurposeCode, "C");
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

//in view Page , search by different values passing into search box,
//refresh Method Should be use when the when Search Text is not Remove and Click on select All  values.
	public void verifyViewpageBySerachFieldWhenModifyTheAddFileFormatListCheck() throws Exception {
		this.searchfield.clear();
		log.info("Search By Entity Id ==>" + splivaluesOfEntityId);
		this.searchfield.sendKeys(splivaluesOfEntityId);
		this.searchfield.clear();
		log.info("Search By Unique ID ==>" + getUniqueID);
		this.searchfield.sendKeys(getUniqueID);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("Search By Corporate Remittance Reference Number ==>" + getCorporateRemittanceReferenceNumber);
		this.searchfield.sendKeys(getCorporateRemittanceReferenceNumber);
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

		String MappingID = "//tbody[@role='alert']//tr//td[2]";
		String EntityID = "//tbody[@role='alert']//tr//td[3]";
		String UNIQUEID = "//tbody[@role='alert']//tr//td[4]";
		String CORPOPORATEREMITERREFRENENCENUMBER = "//tbody[@role='alert']//tr//td[5]";
		String REMITTERNAME = "//tbody[@role='alert']//tr//td[6]";
		String RemitterIdType = "//tbody[@role='alert']//tr//td[7]";
		String RemitterIdNumber = "//tbody[@role='alert']//tr//td[8]";
		String RemitterCustomerAddress = "//tbody[@role='alert']//tr//td[9]";
		String RemitterCustomerZipCode = "//tbody[@role='alert']//tr//td[10]";
		String RemitterEmailId = "//tbody[@role='alert']//tr//td[11]";
		String RemitterContactNo = "//tbody[@role='alert']//tr//td[12]";
		String RemitterCountry = "//tbody[@role='alert']//tr//td[13]";
		String RemitterState = "//tbody[@role='alert']//tr//td[14]";
		String MandateType = "//tbody[@role='alert']//tr//td[15]";
		String TransferAmount = "//tbody[@role='alert']//tr//td[16]";
		String BenefiecryName = "//tbody[@role='alert']//tr//td[17]";
		String BenefiecryCountry = "//tbody[@role='alert']//tr//td[18]";
		String BenefiecryState = "//tbody[@role='alert']//tr//td[19]";
		String BenefiecryCustomerAddress1 = "//tbody[@role='alert']//tr//td[20]";
		String BenefiecryCustomerZipCode = "//tbody[@role='alert']//tr//td[21]";
		String BenefiecryCustomerEmailId = "//tbody[@role='alert']//tr//td[22]";
		String BenefiecryCustomerMobileNo = "//tbody[@role='alert']//tr//td[23]";
		String RemittancePurposeCode = "//tbody[@role='alert']//tr//td[24]";
		String RemittancePurpose = "//tbody[@role='alert']//tr//td[25]";
		String RelashionshipWithBeneficiary = "//tbody[@role='alert']//tr//td[26]";
		String BankName = "//tbody[@role='alert']//tr//td[27]";
		String BankBranch = "//tbody[@role='alert']//tr//td[28]";
		String BranchCode = "//tbody[@role='alert']//tr//td[29]";
		String RoutingNumber = "//tbody[@role='alert']//tr//td[30]";
		String BankAccountNumber = "//tbody[@role='alert']//tr//td[31]";
		String BeneBankAddress = "//tbody[@role='alert']//tr//td[32]";
		String CashAgentName = "//tbody[@role='alert']//tr//td[33]";
		String CashAgentBranch = "//tbody[@role='alert']//tr//td[34]";
		String BeneficieryIdType = "//tbody[@role='alert']//tr//td[35]";
		String BeneficieryIdNo = "//tbody[@role='alert']//tr//td[36]";
		String CashPayOutPayIn = "//tbody[@role='alert']//tr//td[37]";
		String WallentName = "//tbody[@role='alert']//tr//td[38]";
		String WalletNo = "//tbody[@role='alert']//tr//td[39]";
		String Date = "//tbody[@role='alert']//tr//td[40]";
		String Dellimitter = "//tbody[@role='alert']//tr//td[41]";
		String RemitterDOB = "//tbody[@role='alert']//tr//td[42]";
		String BeneficiaryDOB = "//tbody[@role='alert']//tr//td[43]";
		String DisbCurrency = "//tbody[@role='alert']//tr//td[44]";
		String RemitterPassportNo = "//tbody[@role='alert']//tr//td[45]";
		String RemitterPassportExpieryDate = "//tbody[@role='alert']//tr//td[46]";
		String RemitterOtherId = "//tbody[@role='alert']//tr//td[47]";
		String RemitterOtherIdExpieryDate = "//tbody[@role='alert']//tr//td[48]";
		String RemitterOccupasion = "//tbody[@role='alert']//tr//td[49]";
		String CONSENT = "//tbody[@role='alert']//tr//td[50]";

		verifyTheMakerViewPageWhenModified(MappingID, "2");
		verifyTheMakerViewPageWhenModified(EntityID, "6786786");
		verifyTheMakerViewPageWhenModified(UNIQUEID, "5");
		verifyTheMakerViewPageWhenModified(CORPOPORATEREMITERREFRENENCENUMBER, "1");
		verifyTheMakerViewPageWhenModified(REMITTERNAME, "7");
		verifyTheMakerViewPageWhenModified(RemitterIdType, "8");
		verifyTheMakerViewPageWhenModified(RemitterIdNumber, "9");
		verifyTheMakerViewPageWhenModified(RemitterCustomerAddress, "10");
		verifyTheMakerViewPageWhenModified(RemitterCustomerZipCode, "11");
		verifyTheMakerViewPageWhenModified(RemitterEmailId, "12");
		verifyTheMakerViewPageWhenModified(RemitterContactNo, "13");
		verifyTheMakerViewPageWhenModified(RemitterCountry, "14");
		verifyTheMakerViewPageWhenModified(RemitterState, "15");
		verifyTheMakerViewPageWhenModified(MandateType, "16");
		verifyTheMakerViewPageWhenModified(TransferAmount, "17");
		verifyTheMakerViewPageWhenModified(BenefiecryName, "18");
		verifyTheMakerViewPageWhenModified(BenefiecryCountry, "19");
		verifyTheMakerViewPageWhenModified(BenefiecryState, "20");
		verifyTheMakerViewPageWhenModified(BenefiecryCustomerAddress1, "21");
		verifyTheMakerViewPageWhenModified(BenefiecryCustomerZipCode, "22");
		verifyTheMakerViewPageWhenModified(BenefiecryCustomerEmailId, "23");
		verifyTheMakerViewPageWhenModified(BenefiecryCustomerMobileNo, "24");
		verifyTheMakerViewPageWhenModified(RemittancePurposeCode, "25");
		verifyTheMakerViewPageWhenModified(RemittancePurpose, "26");
		verifyTheMakerViewPageWhenModified(RelashionshipWithBeneficiary, "27");
		verifyTheMakerViewPageWhenModified(BankName, "28");
		verifyTheMakerViewPageWhenModified(BankBranch, "29");
		verifyTheMakerViewPageWhenModified(BranchCode, "30");
		verifyTheMakerViewPageWhenModified(RoutingNumber, "31");
		verifyTheMakerViewPageWhenModified(BankAccountNumber, "32");
		verifyTheMakerViewPageWhenModified(BeneBankAddress, "33");
		verifyTheMakerViewPageWhenModified(CashAgentName, "34");
		verifyTheMakerViewPageWhenModified(CashAgentBranch, "35");
		verifyTheMakerViewPageWhenModified(BeneficieryIdType, "36");
		verifyTheMakerViewPageWhenModified(BeneficieryIdNo, "37");
		verifyTheMakerViewPageWhenModified(WallentName, "38");
		verifyTheMakerViewPageWhenModified(CashPayOutPayIn, "2");
		verifyTheMakerViewPageWhenModified(WallentName, "7");
		verifyTheMakerViewPageWhenModified(WalletNo, "7");
		verifyTheMakerViewPageWhenModified(Date, "6");
		verifyTheMakerViewPageWhenModified(Dellimitter, "~");
		verifyTheMakerViewPageWhenModified(RemitterDOB, "38");
		verifyTheMakerViewPageWhenModified(BeneficiaryDOB, "39");
		verifyTheMakerViewPageWhenModified(DisbCurrency, "40");
		verifyTheMakerViewPageWhenModified(RemitterPassportNo, "41");
		verifyTheMakerViewPageWhenModified(RemitterPassportExpieryDate, "42");
		verifyTheMakerViewPageWhenModified(RemitterOtherId, "43");
		verifyTheMakerViewPageWhenModified(RemitterOtherIdExpieryDate, "44");
		verifyTheMakerViewPageWhenModified(RemitterOccupasion, "45");
		verifyTheMakerViewPageWhenModified(CONSENT, "46");

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
		WebElement MAPPINGID = driver.findElement(By.xpath("//tfoot//tr//th[2]//select"));
		WebElement ENTITYID = driver.findElement(By.xpath("//tfoot//tr//th[3]//select"));
		WebElement UNIQUEID = driver.findElement(By.xpath("//tfoot//tr//th[4]//select"));
		WebElement CORPORATEREMITERREFERENCENO2 = driver.findElement(By.xpath("//tfoot//tr//th[5]//select"));
		WebElement REMITTERNAME = driver.findElement(By.xpath("//tfoot//tr//th[6]//select"));
		WebElement REMITTERIdType = driver.findElement(By.xpath("//tfoot//tr//th[7]//select"));
		WebElement REMITTERIDNO = driver.findElement(By.xpath("//tfoot//tr//th[8]//select"));
		WebElement REMITTERCUTOMERADDRESS = driver.findElement(By.xpath("//tfoot//tr//th[9]//select"));
		WebElement REMITTERCUSTOMERZIPCODE = driver.findElement(By.xpath("//tfoot//tr//th[10]//select"));
		WebElement REMITTEREMAILID = driver.findElement(By.xpath("//tfoot//tr//th[11]//select"));
		WebElement REMITTERCONTACTNO = driver.findElement(By.xpath("//tfoot//tr//th[12]//select"));
		WebElement REMITTERCONTRY = driver.findElement(By.xpath("//tfoot//tr//th[13]//select"));
		WebElement REMITTERSTATE = driver.findElement(By.xpath("//tfoot//tr//th[14]//select"));
		WebElement REMITTERMANDATETYPE = driver.findElement(By.xpath("//tfoot//tr//th[15]//select"));
		WebElement REMITTERTRANSFERAMOUNT = driver.findElement(By.xpath("//tfoot//tr//th[16]//select"));
		WebElement BENEFICIARYNAME = driver.findElement(By.xpath("//tfoot//tr//th[17]//select"));
		WebElement BENEFICIARYCOUNTRY = driver.findElement(By.xpath("//tfoot//tr//th[18]//select"));
		WebElement BENEFICIARYSTATE = driver.findElement(By.xpath("//tfoot//tr//th[19]//select"));
		WebElement BENEFICIARYCUSTOMERADDRESS = driver.findElement(By.xpath("//tfoot//tr//th[20]//select"));
		WebElement BENEFICIARYCUSTOMERZIPCODE = driver.findElement(By.xpath("//tfoot//tr//th[21]//select"));
		WebElement BENEFICIARYCUSTOMEREMAILID = driver.findElement(By.xpath("//tfoot//tr//th[22]//select"));
		WebElement BENEFICIARYCUSTOMERMOBILENO = driver.findElement(By.xpath("//tfoot//tr//th[23]//select"));
		WebElement REMITTANCEPURPOSECODE = driver.findElement(By.xpath("//tfoot//tr//th[24]//select"));
		WebElement REMITTANCEPURPOSE = driver.findElement(By.xpath("//tfoot//tr//th[25]//select"));
		WebElement RELATIONSHIPWITHBENEFICIARY = driver.findElement(By.xpath("//tfoot//tr//th[26]//select"));
		WebElement BANKNAME = driver.findElement(By.xpath("//tfoot//tr//th[27]//select"));
		WebElement BANKBRANCH = driver.findElement(By.xpath("//tfoot//tr//th[28]//select"));
		WebElement BANKBRANCHCODE = driver.findElement(By.xpath("//tfoot//tr//th[29]//select"));
		WebElement ROUTINGNO = driver.findElement(By.xpath("//tfoot//tr//th[30]//select"));
		WebElement BANKACCOUNTNO = driver.findElement(By.xpath("//tfoot//tr//th[31]//select"));
		WebElement BENEFICIARYBANKADDRESS = driver.findElement(By.xpath("//tfoot//tr//th[32]//select"));
		WebElement CASHAGENTNAME = driver.findElement(By.xpath("//tfoot//tr//th[33]//select"));
		WebElement CASHAGENTNBRANCH = driver.findElement(By.xpath("//tfoot//tr//th[34]//select"));
		WebElement BENEFICIARYIDTYPE = driver.findElement(By.xpath("//tfoot//tr//th[35]//select"));
		WebElement BENEFICIARYIDNO = driver.findElement(By.xpath("//tfoot//tr//th[36]//select"));
		WebElement CASHPAYOUTPAYIN = driver.findElement(By.xpath("//tfoot//tr//th[37]//select"));
		WebElement WALLETNAME = driver.findElement(By.xpath("//tfoot//tr//th[38]//select"));
		WebElement WALLETNO = driver.findElement(By.xpath("//tfoot//tr//th[39]//select"));
		WebElement DATE = driver.findElement(By.xpath("//tfoot//tr//th[40]//select"));
		WebElement DELIMITER = driver.findElement(By.xpath("//tfoot//tr//th[41]//select"));
		WebElement REMITERDOB = driver.findElement(By.xpath("//tfoot//tr//th[42]//select"));
		WebElement BENFDOB = driver.findElement(By.xpath("//tfoot//tr//th[43]//select"));
		WebElement DISBCURRENCY = driver.findElement(By.xpath("//tfoot//tr//th[44]//select"));
		WebElement REMITTERPASSPORTNO = driver.findElement(By.xpath("//tfoot//tr//th[45]//select"));
		WebElement REMITTERPASSPORTEXPIRYDATE = driver.findElement(By.xpath("//tfoot//tr//th[46]//select"));
		WebElement REMITTEROTHERID = driver.findElement(By.xpath("//tfoot//tr//th[47]//select"));
		WebElement REMITTEROTHERIDEXPIRYDATE = driver.findElement(By.xpath("//tfoot//tr//th[48]//select"));
		WebElement REMITTEROCCUPATION = driver.findElement(By.xpath("//tfoot//tr//th[49]//select"));
		WebElement CONSENT = driver.findElement(By.xpath("//tfoot//tr//th[50]//select"));

		verifySelectDropDonInViewMakerPageWhenModified(MAPPINGID, "2");
		verifySelectDropDonInViewMakerPageWhenModified(ENTITYID, "6786786");
		verifySelectDropDonInViewMakerPageWhenModified(UNIQUEID, "5");
		verifySelectDropDonInViewMakerPageWhenModified(CORPORATEREMITERREFERENCENO2, "1");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTERNAME, "7");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTERIdType, "8");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTERIDNO, "9");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTERCUTOMERADDRESS, "10");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTERCUSTOMERZIPCODE, "11");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTEREMAILID, "12");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTERCONTACTNO, "13");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTERCONTRY, "14");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTERSTATE, "15");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTERMANDATETYPE, "16");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTERTRANSFERAMOUNT, "17");
		verifySelectDropDonInViewMakerPageWhenModified(BENEFICIARYNAME, "18");
		verifySelectDropDonInViewMakerPageWhenModified(BENEFICIARYCOUNTRY, "19");
		verifySelectDropDonInViewMakerPageWhenModified(BENEFICIARYSTATE, "20");
		verifySelectDropDonInViewMakerPageWhenModified(BENEFICIARYCUSTOMERADDRESS, "21");
		verifySelectDropDonInViewMakerPageWhenModified(BENEFICIARYCUSTOMERZIPCODE, "22");
		verifySelectDropDonInViewMakerPageWhenModified(BENEFICIARYCUSTOMEREMAILID, "23");
		verifySelectDropDonInViewMakerPageWhenModified(BENEFICIARYCUSTOMERMOBILENO, "24");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTANCEPURPOSECODE, "25");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTANCEPURPOSE, "26");
		verifySelectDropDonInViewMakerPageWhenModified(RELATIONSHIPWITHBENEFICIARY, "27");
		verifySelectDropDonInViewMakerPageWhenModified(BANKNAME, "28");
		verifySelectDropDonInViewMakerPageWhenModified(BANKBRANCH, "29");
		verifySelectDropDonInViewMakerPageWhenModified(BANKBRANCHCODE, "30");
		verifySelectDropDonInViewMakerPageWhenModified(ROUTINGNO, "31");
		verifySelectDropDonInViewMakerPageWhenModified(BANKACCOUNTNO, "32");
		verifySelectDropDonInViewMakerPageWhenModified(BENEFICIARYBANKADDRESS, "33");
		verifySelectDropDonInViewMakerPageWhenModified(CASHAGENTNAME, "34");
		verifySelectDropDonInViewMakerPageWhenModified(CASHAGENTNBRANCH, "35");
		verifySelectDropDonInViewMakerPageWhenModified(BENEFICIARYIDTYPE, "36");
		verifySelectDropDonInViewMakerPageWhenModified(BENEFICIARYIDNO, "37");
		verifySelectDropDonInViewMakerPageWhenModified(CASHPAYOUTPAYIN, "38");
		verifySelectDropDonInViewMakerPageWhenModified(CASHPAYOUTPAYIN, "2");
		verifySelectDropDonInViewMakerPageWhenModified(WALLETNAME, "3");
		verifySelectDropDonInViewMakerPageWhenModified(WALLETNO, "4");
		verifySelectDropDonInViewMakerPageWhenModified(DATE, "6");
		verifySelectDropDonInViewMakerPageWhenModified(DELIMITER, "~");
		verifySelectDropDonInViewMakerPageWhenModified(REMITERDOB, "38");
		verifySelectDropDonInViewMakerPageWhenModified(BENFDOB, "39");
		verifySelectDropDonInViewMakerPageWhenModified(DISBCURRENCY, "40");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTERPASSPORTNO, "41");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTERPASSPORTEXPIRYDATE, "42");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTEROTHERID, "43");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTEROTHERIDEXPIRYDATE, "44");
		verifySelectDropDonInViewMakerPageWhenModified(REMITTEROCCUPATION, "45");
		verifySelectDropDonInViewMakerPageWhenModified(CONSENT, "46");

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

		log.info(" Get the Text of MODIFY FILE FORMAT LIST CHECK Ppage===>>"
				+ verifyModifyFileFormatListCheckPage.getText());
		log.info(" verify the MODIFY FILE FORMAT LIST CHECK Ppage...");
		Assert.assertEquals(verifyModifyFileFormatListCheckPage.getText(), "MODIFY FILE FORMAT LIST CHECK");
		log.info(" Successfully verified the MODIFY FILE FORMAT LIST CHECK Ppage...");
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
		Assert.assertEquals("PURPOSE CHECKER", Header);


		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		driver.switchTo().defaultContent();
		

		driver.findElement(By.xpath("//b[text()='Logout']")).click();

	}
}
