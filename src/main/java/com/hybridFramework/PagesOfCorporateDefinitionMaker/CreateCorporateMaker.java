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

// AddCompanyMaker also know as Add Purpose Maker 
public class CreateCorporateMaker {
	static WebDriver driver;

	private final static Logger log = LoggerHelper.getLogger(CreateCorporateMaker.class);
	WaitHelper waitHelper;

	@FindBy(id = "userId")
	WebElement loginid;

	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "toggle")
	WebElement login;
	@FindBy(xpath = "//*[text()='Prime Last Mile']")
	WebElement mainheader;
	// ******************** Maker X path*****************************
	@FindBy(xpath = "//font[contains(text(),'Corporate Definition Maker')]")
	WebElement corporatedefinitionmakerlink;

	@FindBy(xpath = "//font[contains(text(),'Create Corporate Maker')]//parent::a")
	WebElement createcorporatemakerlink;

	@FindBy(xpath = "//td[@class='pagetitle']")
	WebElement pagetitle;

	@FindBy(xpath = "//input[@id='grpCountryCode']")
	WebElement corporateidinput;

	@FindBy(xpath = "//select[@id='grpCountryCode']")
	static WebElement countrydropdown;

	@FindBy(xpath = "//select[@id='corporateTypeId']")
	static WebElement corporateTypeIddropdown;

	@FindBy(xpath = "//input[@name='corporateId']")
	WebElement corporateCRN;

	@FindBy(xpath = "//input[@name='corporateName']")
	WebElement corporateName;

	@FindBy(xpath = "//input[@name='corporateDesc']")
	WebElement corporateDesc;

	@FindBy(xpath = "//input[@id='website']")
	WebElement website;

	@FindBy(xpath = "//select[@id='cmsCustomer']")
	WebElement selectcmsCustomer;

	@FindBy(xpath = "//input[@id='corpCode']")
	WebElement corpCode;

	@FindBy(xpath = "//input[@id='clientCode']")
	WebElement clientCode;

	@FindBy(xpath = "//input[@id='industry']")
	WebElement industry;

	@FindBy(xpath = "//input[@id='exh_house']")
	WebElement exh_houseORBankName;

	@FindBy(xpath = "//input[@id='bd_bankappref']")
	WebElement bangladeshbankapprovalreference;

	@FindBy(xpath = "//input[@id='secDeplien']")
	WebElement securitydepositunder;

	@FindBy(xpath = "//input[@id='bankrefexp']")
	WebElement bankguaranteerefrencewithexpiry;

	@FindBy(xpath = "//select[@id='minBalNRT']")
	WebElement minBalanceNRT;

	@FindBy(xpath = "//input[@id='compaddzipcode']")
	WebElement companyaddresszipcode;

	@FindBy(xpath = "//select[@id='group']")
	WebElement selectgroup;

	@FindBy(xpath = "//input[@name='lineOfBusiness']")
	WebElement lineOfBusiness;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement officialEmail;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement address1;

	@FindBy(xpath = "//input[@id='address2']")
	WebElement address2;

	@FindBy(xpath = "//input[@id='address3']")
	WebElement address3;

	@FindBy(xpath = "//input[@id='city']")
	WebElement city;

	@FindBy(xpath = "//input[@id='state']")
	WebElement state;

	@FindBy(xpath = "//tr[1]//td[4]//a[1]")
	WebElement selectdate;

	@FindBy(xpath = "//input[@id='zip']")
	WebElement zipcode;

	@FindBy(xpath = "//select[@id='countryCode']")
	WebElement selectcountryCode;

	@FindBy(xpath = "//input[@id='debitNarration']")
	WebElement debitNarration;
	 /* *****  xpath for Contact details ******************* */
	@FindBy(xpath = "//a[@id='contactDetailsNew']")
	WebElement contactDetailsNew;
     
	@FindBy(xpath = "//input[@id='contactPersons']")
	WebElement contactPersons;

	@FindBy(xpath = "//input[@id='designation']")
	WebElement designation;
	@FindBy(xpath = "//input[@id='telNo']")
	WebElement telNo;
	@FindBy(xpath = "//input[@id='mobNo']")
	WebElement mobNo; 
	@FindBy(xpath = "//input[@id='emailId']")
	WebElement emailId; 
	 /* *****  xpath for Processing details ******************* */
	@FindBy(xpath = "//a[@id='processingDetailsNew']")
	WebElement processingDetailsNewtab;
	
	@FindBy(xpath = "//select[@id='uploadType']")
	WebElement selectuploadType; 
	@FindBy(xpath = "//select[@id='ownPurposeCode']")
	WebElement ownPurposeCode;
	@FindBy(xpath = "//select[@id='IPAddressCheck']")
	WebElement IPAddressCheck;
	@FindBy(xpath = "//select[@id='stpNstp']")
	WebElement stpNstp;
	@FindBy(xpath = "//select[@id='authoriserType']")
	WebElement authoriserType;
	@FindBy(xpath = "//select[@id='isRipple']")
	WebElement isRipple;
	@FindBy(xpath = "//input[@id='countCorporate']")
	WebElement countCorporate;
	@FindBy(xpath = "//select[@id='firstLineHeader']")
	WebElement firstLineHeader;
	@FindBy(xpath = "//input[@id='rowCountCorporate']")
	WebElement rowCountCorporate;
	@FindBy(xpath = "//select[@id='singleColExcel']")
	WebElement singleColExcel;
	//input[@id='sepSingleColExcel']
	@FindBy(xpath = "//input[@id='sepSingleColExcel']")
	WebElement seperateSingleColExcel;
	@FindBy(xpath = "//select[@id='fileTypes']")
	WebElement fileTypes;
	@FindBy(xpath = "//input[@id='sepTxtFormat']")
	WebElement seperateTxtFormat;
	@FindBy(xpath = "//input[@id='footerStartColumn']")
	WebElement footerStartColumn;
	@FindBy(xpath = "//input[@id='footerIdentificationText']")
	WebElement footerIdentificationText;
	@FindBy(xpath = "//input[@id='remarks']")
	WebElement remarks;
	/* ****************** Upload Documents ***********/
	@FindBy(xpath = "//a[@id='uploadDocumentsNew']")
	WebElement uploadDocumentsNew;
	@FindBy(xpath = "//input[@id='uniqueIdfileName1']")
	WebElement agreementFileName;
	@FindBy(xpath = "//input[@id='uniqueIdfileName2']")
	WebElement guaranteeFileName;
	@FindBy(xpath = "//input[@id='uniqueIdfileName3']")
	WebElement licenseFileName;
	
	@FindBy(xpath = "//input[@value='Submit']")
   WebElement submitfrommakerpage;

	@FindBy(xpath = "//input[@id='view']")
	WebElement viewbutton;

	@FindBy(xpath = "//input[@value='Modify']")
	WebElement modifybutton;

	@FindBy(xpath = "//td[@class='note']")
	WebElement SuccesfullMessage;

	WebElement Fieldsareinmandatory;

	@FindBy(xpath = "//select[@id='isActive']")
	WebElement isActiveCountry;
	@FindBy(xpath = "//div[@id='uploadDocuments']//input[@id='button']")
	WebElement uploadDocumentssubmitInMakerpage;
	@FindBy(xpath = "//div[@id='processingDetails']//input[@id='button']")
	WebElement processingDetailssubmitInMakerpage;
	
//	@FindBy(xpath = "//td[@class='note']")
//	WebElement SuccesfullMessage;

	// ************************************ Statrted Checker X-path
	// *******************************************

	@FindBy(xpath = "//*[text()='Corporate Definition Checker']")
	WebElement CorporateDefinitionChecker;
	@FindBy(xpath = "//*[text()='Authoriser Create Corporate']//parent::a")
	WebElement AuthoriserCreateCorporate;
	@FindBy(xpath = "//td[contains(text(),' Group Country Entity Type Checker')]")
	WebElement verifyGroupCountryEntityType;
	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> checkbox;
	// //input[@type='checkbox']//parent::th for getting Text of Header of
	@FindBy(xpath = "//th//input[@type='checkbox']")
	List<WebElement> Headercheckbox;
	@FindBy(xpath = "//input[@value='Submit']")
	WebElement SubmitbuttononChecker;

	@FindBy(xpath = "//table[@id='mainformtable']//tr[2]//td")
	WebElement verifysuccessfulMessageinChecker;

	@FindBy(xpath = "//b[text()='Logout']")
	WebElement Logoutinchecker;

	// View page in Maker
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewinMaker;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchfield;

	@FindBy(xpath = "//select[@name='groupCorporateUsersView_length']")
	WebElement selectentitieslist;
	@FindBy(xpath = "//select[@name='list_length']")
	WebElement logoutInMaker;
// Modify Page in Maker
	@FindBy(xpath = "//input[@value='Modify']")
	WebElement ModifyButton;

	@FindBy(xpath = "//*[text()='MODIFY GROUP COUNTRY ENTITY TYPE MAKER']")
	WebElement verifyMODIFYGROUPCOUNTRYENTITYTYPEMAKERPage;

	@FindBy(xpath = "//select[@name='grpCountryCode']")
	WebElement selectgrpCountryCodeInModifyPage;

	@FindBy(xpath = "//select[@name='entityTypeId']")
	WebElement selectentityTypeIdInModifyPage;

	@FindBy(xpath = "//div[@id='corporateDetails']//input[@name='btnSubmit']")
	WebElement submitbuttOncorporateDetails;
	// form[@name='modifyCountry']//table//tr[15]//td//input[@name='Submit']

	@FindBy(xpath = "//form[@name='modifyGroupCountryEntityType']//table//tr[10]//td//input[@name='Submit']")
	WebElement modifysubmitbutton;
	@FindBy(xpath = "//td[@class='note']")
	WebElement verificationMessageInModifyCountry;

	@FindBy(xpath = "//b[text()='Logout']")
	WebElement logoutMaker;

	// View Page in Checker
	//
	@FindBy(xpath = "//input[@id='view']")
	WebElement viewInChecker;

	public CreateCorporateMaker(WebDriver driver) {
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

// click on corporate definition maker Menu
	public void clickoncorporatedefinitionmakerMenu() {
		log.info("click on corporate definition maker Menu==>" + corporatedefinitionmakerlink.getText());
		corporatedefinitionmakerlink.click();
	}

// click on create corporate maker SubMenu
	public void clickoncreatecorporatemakerSubMenu() {
		log.info("click on create corporate maker SubMenu===>" + createcorporatemakerlink.getText());
		createcorporatemakerlink.click();
	}

	public String verifyPageTitle() {
		String title = pagetitle.getText();
		log.info("The Page Title is ==>> " + title);
		return title;
	}



// to switch the Add Country Maker page.
	public void toswitchFieldsareinmandatory() throws Exception {
		//Thread.sleep(5000);
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeElements);

		driver.switchTo().frame(0);
		// System.out.println(" To Go to Fields are in mandatory Field=== " +
		// Fieldsareinmandatory.getText());
		// log.info(" To switch the main Enter values " +
		// Fieldsareinmandatory.getText());
	}

	static List<String> groupcountryList;
	static String y;
	static String groupidString;
	static String GetTextOfGroupCountry;
	// Means Entity Type Id
	static String splitvaluesofCorporateDropDownValues;
	static String splitvaluesofCorporateDropDownValuesEntityType;
	String GroupId = "RGEX";
	String CountryCode1 = "BD";
	static String getIsActiveCountry;
	String entitDescription = "";

	public void selectCountrydropdown() throws Exception {

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
		Select selectGroupCountry = new Select(countrydropdown);
		List<WebElement> listOfGroupCountry = selectGroupCountry.getOptions();
		int getSizeOfGroupCountry = listOfGroupCountry.size();
		System.out.println("Get Size Of Group Country ==>>" + getSizeOfGroupCountry);

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

	public void verifyingCorporateTypeIDFromDropDownByUsingStringArray() throws Exception {
		// 1121-109ak , 1302-CCD ,1161-PblAl1
		String[] itemsNeeded1 = { "1324-CCCAA", "1141-PBNK01" };
		// Thread.sleep(5000);
		addItems1(driver, itemsNeeded1);
	}

	public static void addItems1(WebDriver driver, String[] itemsNeeded1) throws Exception {
		int j = 0;
		// Thread.sleep(5000);
		Select sel = new Select(corporateTypeIddropdown);
		List<WebElement> products1 = sel.getOptions();
		int aa = products1.size();
		System.out.println("Get No of Size of Drop Down====>" + aa);

		for (int i = 1; i <= products1.size(); i++)

		{

			String formattedName = products1.get(i).getText();

			System.out.println("Get formattedName" + formattedName);

			String[] splt = formattedName.split("-");
			splitvaluesofCorporateDropDownValues = splt[0].trim();
			System.out.println(
					"split values of Corporate Id Drop Down Values ==>" + splitvaluesofCorporateDropDownValues);

//			String[] entityType = formattedName.split("-");
//			splitvaluesofCorporateDropDownValuesEntityType = entityType[1].trim();
//			System.out.println(
//					"split values of Corporate Id Drop Down Values ==>" + splitvaluesofCorporateDropDownValuesEntityType);
			
			List<String> itemsNeededList1 = Arrays.asList(itemsNeeded1);
			System.out.println("Get the Text in Array List" + itemsNeededList1);

			if (itemsNeededList1.contains(formattedName))

			{
				System.out.println("Text has Matched with drop down values");

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

	static String getcorporateCRN;
	static String getcorporateName;
	static String getcorporateDesc;
	static String getwebsite;
	static String getcorpCode;
	static String getclientCode;
	static String getindustry;
	static String getexh_houseORBankName;
	static String getbangladeshbankapprovalreference;
	static String getsecuritydepositunder;
	static String getbankguaranteerefrencewithexpiry;
	static String getminBalanceNRT;
	static String  getcompanyaddresszipcode;
	static String getlineOfBusiness;
	static String getofficialEmail;
	static String  getaddress1;
	static String getaddress2;
	static String getaddress3;
	static String getcity;
	static String getstate;
	static String getzipcode;
	static String  getdebitNarration;
	static String getcontactPersons;
	static String getdesignation;
	static String gettelNo;
	static String getmobNo;
	static String getemailId;
	static String getcountCorporate;
	static String getrowCountCorporate;
	static String getseperateSingleColExcel;
	static String getseperateTxtFormat;
	static String getfooterStartColumn;
	static String getfooterIdentificationText;
	static String getremarks;
	static String getagreementFileName;
	static String getguaranteeFileName;
	static String getlicenseFileName;
	
public void entercorporateCRN(String corporateCRN) {
	log.info("enter corporate CRN ==>" + corporateCRN);
	this.corporateCRN.sendKeys(corporateCRN);
	getcorporateCRN = corporateCRN.toString();
	System.out.println("get Country value" + getcorporateCRN);
	
}
	public void entercorporateName(String corporateName) {
		log.info("enter corporate Name ==>" + corporateName);
		this.corporateName.sendKeys(corporateName);
		getcorporateName = corporateName.toString();
		System.out.println("get corporate Name value" + getcorporateName);
		
	}
	// corporateDesc
	public void entercorporateDesc(String corporateDesc) {
		log.info("enter corporate Desc ==>" + corporateDesc);
		this.corporateDesc.sendKeys(corporateDesc);
		getcorporateDesc = corporateDesc.toString();
		System.out.println("get corporate Desc ==>" + getcorporateDesc);
		
	}
	public void enterwebsite(String website) {
		log.info("enter website ==>" + website);
		this.website.sendKeys(website);
		getwebsite = website.toString();
		System.out.println("get website ==>" + getwebsite);
		
	}
	public void selectcmsCustomerDropDown() {
		log.info("select cms Customer ==>" );
		 Select cmsCustomer =  new Select(selectcmsCustomer);
		 cmsCustomer.selectByVisibleText("Yes");
	}
	public void entercorpCode(String corpCode) {
		log.info("enter corpCode ==>" );
		this.corpCode.sendKeys(corpCode);
		getcorpCode = corpCode.toString();
		System.out.println("get corp Code ==>" + getcorpCode);
	}
	public void enterclientCode(String clientCode) {
		log.info("enter client Code ==>" );
		this.clientCode.sendKeys(clientCode);
		getclientCode = clientCode.toString();
		System.out.println("get client Code ==>" + getclientCode);
	}
	public void enterindustry(String industry) {
		log.info("enter industry ==>" );
		this.industry.sendKeys(industry);
		getindustry = industry.toString();
		System.out.println("get industry ==>" + getindustry);
	}

	public void enterexh_houseORBankName(String exh_houseORBankName) {
		log.info("enter exh_house OR Bank Name ==>" );
		this.exh_houseORBankName.sendKeys(exh_houseORBankName);
		getexh_houseORBankName = exh_houseORBankName.toString();
		System.out.println("get exh_house OR Bank Name ==>" + getexh_houseORBankName);
	}
	public void enterbangladeshbankapprovalreference(String bangladeshbankapprovalreference) {
		log.info("enter bangladesh bank approval reference ==>"+bangladeshbankapprovalreference );
		this.bangladeshbankapprovalreference.sendKeys(bangladeshbankapprovalreference);
		getbangladeshbankapprovalreference = bangladeshbankapprovalreference.toString();
		System.out.println("get bangladesh bank approval reference ==>" + getbangladeshbankapprovalreference);
	}
	public void  selectApprovalDate() throws Exception {
		 driver.findElement(By.xpath("//input[@name='approvalDate']")).click();
		 log.info(" Click on  Approval Date ==>");
		
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
		  System.out.println("Get the No of days ==>"+count);
		  for(int i=0; i<days.size();i++) {
			  String getTextOfDate = days.get(i).getText();
			  System.out.println("Get All Text On days  Calender ==>"+getTextOfDate);
			  if(days.get(i).getText().equals("2")) {
				  
				  days.get(i).click();
				  break;
			  }
			  
		  }
	}
	
	
	public void entersecuritydepositunder(String securitydepositunder) {
		log.info("enter security deposit under ==>"+securitydepositunder );
		this.securitydepositunder.sendKeys(securitydepositunder);
		getsecuritydepositunder = securitydepositunder.toString();
		System.out.println("get security deposit under ==>" + getsecuritydepositunder);
	}
	public void enterbankguaranteerefrencewithexpiry(String bankguaranteerefrencewithexpiry) {
		log.info("enter bank guarantee refrence with expiry ==>"+bankguaranteerefrencewithexpiry );
		this.bankguaranteerefrencewithexpiry.sendKeys(bankguaranteerefrencewithexpiry);
		getbankguaranteerefrencewithexpiry = bankguaranteerefrencewithexpiry.toString();
		System.out.println("get bank guarantee refrence with expiry ==>" + getbankguaranteerefrencewithexpiry);
	}
	public void enterminBalanceNRT(String minBalanceNRT) {
		log.info("enter min Balance NRT ==>"+minBalanceNRT );
		this.minBalanceNRT.sendKeys(minBalanceNRT);
		getminBalanceNRT = minBalanceNRT.toString();
		System.out.println("get min Balance NRT ==>" + getminBalanceNRT);
	}
	public void entercompanyaddresszipcode(String companyaddresszipcode) {
		log.info("enter company address zip code ==>"+companyaddresszipcode );
		this.companyaddresszipcode.sendKeys(companyaddresszipcode);
		getcompanyaddresszipcode = companyaddresszipcode.toString();
		System.out.println("get company address zip code ==>" + getcompanyaddresszipcode);
	}
	// checking for drop down values.
	public void selectgroupDropDown() {
		log.info("select group ==>"+selectgroup );
		Select selectgroupdd = new Select(selectgroup);
		selectgroupdd.selectByVisibleText("CB");
	}
	public void enterlineOfBusiness(String lineOfBusiness) {
		log.info("enter line Of Business ==>"+lineOfBusiness );
		this.lineOfBusiness.sendKeys(lineOfBusiness);
		getlineOfBusiness = lineOfBusiness.toString();
		System.out.println("get line Of Business ==>" + getlineOfBusiness);
	}
	public void enterofficialEmail(String officialEmail) {
		log.info("enter official Email ==>"+officialEmail );
		this.officialEmail.sendKeys(officialEmail);
		getofficialEmail = officialEmail.toString();
		System.out.println("get official Email ==>" + getofficialEmail);
	}
	
	public void enteraddress1(String address1) {
		log.info("enter address1 ==>"+address1 );
		this.address1.sendKeys(address1);
		getaddress1 = address1.toString();
		System.out.println("get address1 ==>" + getaddress1);
	}
	public void enteraddress2(String address2) {
		log.info("enter address2 ==>"+address2 );
		this.address2.sendKeys(address2);
		getaddress2 = address2.toString();
		System.out.println("get address2 ==>" + getaddress2);
	}
	public void enteraddress3(String address3) {
		log.info("enter address3 ==>"+address3 );
		this.address3.sendKeys(address3);
		getaddress3 = address3.toString();
		System.out.println("get address3 ==>" + getaddress3);
	}
	public void entercity(String city) {
		log.info("enter city ==>"+city );
		this.city.sendKeys(city);
		getcity = city.toString();
		System.out.println("get city ==>" + getcity);
	}
	public void enterstate(String state) {
		log.info("enter state ==>"+state );
		this.state.sendKeys(state);
		getstate = state.toString();
		System.out.println("get state ==>" + getstate);
	}
	public void enterzipcode(String zipcode) {
		log.info("enter zip code ==>"+zipcode );
		this.zipcode.sendKeys(zipcode);
		getzipcode = zipcode.toString();
		System.out.println("get zip code ==>" + getzipcode);
		
	}
	public void selectcountryCodeDropDown() {
		log.info("select country Code ==>" );
		 Select countrycode =  new Select(selectcountryCode);
		 countrycode.selectByVisibleText("BANGLADESH");
	}
	public void enterdebitNarration(String debitNarration) {
		log.info("enter debit Narration ==>"+debitNarration );
		this.debitNarration.sendKeys(debitNarration);
		getdebitNarration = debitNarration.toString();
		System.out.println("get debit Narration ==>" + getdebitNarration);
		
	}
	// contactDetailsNew
	public void clickcontactDetailsNew() {
		log.info("Click On contact Details New ==>"+contactDetailsNew );
		contactDetailsNew.click();
		
	}
	// contactDetailsNew
		public void entercontactPersons(String contactPersons) {
			log.info("enter contact Persons ==>"+contactPersons );
			this.contactPersons.sendKeys(contactPersons);
			getcontactPersons = contactPersons.toString();
			System.out.println("get contact Persons ==>" + getcontactPersons);
		}
		
		public void enterdesignation(String designation) {
			log.info("enter designation ==>"+designation );
			this.designation.sendKeys(designation);
			getdesignation = designation.toString();
			System.out.println("get designation ==>" + getdesignation);
		}
		//telNo
		
		public void entertelNo(String telNo) {
			log.info("enter designation ==>"+telNo );
			this.telNo.sendKeys(telNo);
			gettelNo = telNo.toString();
			System.out.println("get telephone No ==>" + gettelNo);
		}
		public void entermobNo(String mobNo) {
			log.info("enter mobile No ==>"+mobNo );
			this.mobNo.sendKeys(mobNo);
			getmobNo = mobNo.toString();
			System.out.println("get mobile  No ==>" + getmobNo);
		}
		public void enteremailId(String emailId) {
			log.info("enter email Id ==>"+emailId );
			this.emailId.sendKeys(emailId);
			getemailId = emailId.toString();
			System.out.println("get email Id ==>" + getemailId);
		}
		// processingDetailsNewtab
		public void clickOnprocessingDetailsNewtab() {
			log.info("enter email Id ==>" );
			processingDetailsNewtab.click();
		}
		public void selectuploadTypeDropDown() {
			log.info("select upload Type ==>" );
			Select uploadType = new Select(selectuploadType);
			uploadType.selectByVisibleText("H2H");
		}
		public void selectownPurposeCode() {
			log.info("select own Purpose Code ==>" );
			Select selownPurposeCode = new Select(ownPurposeCode);
			selownPurposeCode.selectByVisibleText("No");
			
		}
		public void selectIPAddressCheck() {
			log.info("select IP Address Check ==>" );
			Select selIPAddressCheck = new Select(IPAddressCheck);
			selIPAddressCheck.selectByVisibleText("No");
			
		}
		public void selectSTP() {
			log.info("select stp & Nstp ==>" );
			Select selownstpNstp = new Select(stpNstp);
			selownstpNstp.selectByVisibleText("No");
			
		}
		public void selectauthoriserType() {
			log.info("select authoriser Type ==>" );
			Select selauthoriserType = new Select(authoriserType);
			selauthoriserType.selectByVisibleText("Branch User");
			
		}
		
		public void selectisRipple() {
			log.info("select is Ripple ? ==>" );
			Select selisRipple = new Select(isRipple);
			selisRipple.selectByVisibleText("No");
			
		}
		// enter count Corporate
		public void entercountCorporate(String countCorporate) {
			log.info("enter count Corporate ==>"+countCorporate );
			this.countCorporate.sendKeys(countCorporate);
			getcountCorporate = countCorporate.toString();
			System.out.println("get count Corporate ==>" + getcountCorporate);
		}
		public void selectfirstLineHeader() {
			log.info("select first Line Header ==>");
			Select selfirstLineHeader = new Select(firstLineHeader);
			selfirstLineHeader.selectByVisibleText("No");

		}
	// enter row Count Corporate
	public void enterrowCountCorporate(String rowCountCorporate) {
		log.info("enter Start row Count For Corporate ==>" + rowCountCorporate);
		this.rowCountCorporate.sendKeys(rowCountCorporate);
		getrowCountCorporate = rowCountCorporate.toString();
		System.out.println("get row Count Corporate ==>" + getrowCountCorporate);
	}


	    // Select single Col Excel
			public void selectsingleColExcel() {
				log.info("select first Line Header ==>" );
				Select selsingleColExcel = new Select(singleColExcel);
				selsingleColExcel.selectByVisibleText("No");
				
			}
	public void enterseperateSingleColExcel(String seperateSingleColExcel) {
		log.info("enter seperator Single Col Excel ==>" + seperateSingleColExcel);
		this.seperateSingleColExcel.sendKeys(seperateSingleColExcel);
		getseperateSingleColExcel = seperateSingleColExcel.toString();
		System.out.println("get seperator Single Col Excel ==>" + getseperateSingleColExcel);
	}
	public void selectfileTypes() {
		log.info("Slect file Types ==>" );
		Select selfileTypes = new Select(fileTypes);
		selfileTypes.selectByVisibleText("Text");
			}
	public void enterseperateTxtFormat(String seperateTxtFormat) {
		log.info("enter seperate Txt Format ==>" + seperateTxtFormat);
		this.seperateTxtFormat.sendKeys(seperateTxtFormat);
		getseperateTxtFormat = seperateTxtFormat.toString();
		System.out.println("get seperate Txt Format ==>" + getseperateTxtFormat);
	}
	public void enterfooterStartColumn(String footerStartColumn) {
		log.info("enter seperate Txt Format ==>" + footerStartColumn);
		this.footerStartColumn.sendKeys(footerStartColumn);
		getfooterStartColumn = footerStartColumn.toString();
		System.out.println("get footer Start Column ==>" + getfooterStartColumn);
	}
	
	public void enterfooterIdentificationText(String footerIdentificationText) {
		log.info("enter footer Identification Text ==>" + footerIdentificationText);
		this.footerIdentificationText.sendKeys(footerIdentificationText);
		getfooterIdentificationText = footerIdentificationText.toString();
		System.out.println("get footer Start Column ==>" + getfooterIdentificationText);
	}

	
	public void enterremarks(String remarks) {
		log.info("enter remarks ==>" + remarks);
		this.remarks.sendKeys(remarks);
		getremarks = remarks.toString();
		System.out.println("get remarks==>" + getremarks);
	}
public void clickOnuploadDocumentsNewTab() {
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,-250)", "");
	
	log.info("Click On upload Documents New ==>");
	uploadDocumentsNew.click();
}	
	


public void enteragreementFileName(String agreementFileName) {
	log.info("enter agreement File Name ==>" + agreementFileName);
	this.agreementFileName.sendKeys(agreementFileName);
	getagreementFileName = agreementFileName.toString();
	System.out.println("get agreement File Name==>" + getagreementFileName);
}
public void enterguaranteeFileName(String guaranteeFileName) {
	log.info("enter guarantee File Name ==>" + guaranteeFileName);
	this.guaranteeFileName.sendKeys(guaranteeFileName);
	getguaranteeFileName = guaranteeFileName.toString();
	System.out.println("get guarantee File Name ==>" + getguaranteeFileName);
}
public void enterlicenseFileName(String licenseFileName) {
	log.info("enter license File Name ==>" + licenseFileName);
	this.licenseFileName.sendKeys(licenseFileName);
	getlicenseFileName = licenseFileName.toString();
	System.out.println("get license File Name ==>" + getlicenseFileName);
}


// select  is Active Country ? in Add Country Maker page
	public void selectisActiveCountry() {

		String s = "Yes";
		log.info("select is Active Country ?==" + isActiveCountry);
		Select aa = new Select(isActiveCountry);
		aa.selectByVisibleText(s);
		String getisActive = s.toString();
		System.out.println("get Is Active Bank ===>>" + getisActive);
		String[] spl = getisActive.split("es");
		System.out.println("Split Array Values of Yes ===>>" + spl);
		List<String> splitList1 = Arrays.asList(spl);
		getIsActiveCountry = String.join("", splitList1);
		System.out.println("get Is Active Country after Split (Yes) As Y==>" + getIsActiveCountry);

	}

// click on  upload Documents submit In Maker page
	public void clickonuploadDocumentssubmiButtontInMakerpage() {
		log.info("click on upload Documents submit Button In Maker page ==>");
		uploadDocumentssubmitInMakerpage.click();
		
	}
	public void clickOnprocessingDetailssubmitInMakerpage() {
		log.info("click on processing Details submit In Maker page ==>");
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//		js1.executeScript("window.scrollBy(0,250)", "");
		processingDetailssubmitInMakerpage.click();
	}
// verify Successful Message On Maker Page
	public void verifySuccessfulMessageOnMakerPage() {

		String verifytheSuccessfulMessage = SuccesfullMessage.getText();
		System.out.println("verify the Successful Message  ==>>" + verifytheSuccessfulMessage);
		if (verifytheSuccessfulMessage.equals("Record has been added successfully.")) {
			log.info("Record has been added successfully.");
			log.info("Click on Log Out Button: ");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifytheSuccessfulMessage.equals("This record has already used.")) {
			log.info("This record has already used.");
			log.info("Click on Log Out Button: ");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();
		} else if (verifytheSuccessfulMessage.equals("===Not==")) {
			log.info("This is Not Matched");

		} else if (verifytheSuccessfulMessage.equals("Record Already Exists")) {
			log.info("Record Already Exists");
			log.info("Click on Log Out Button: ");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//b[text()='Logout']")).click();

		}
	}

// click on Corporate Definition Checker Menu
	public void clickonCorporateDefinitionCheckerMenu(){
		log.info(" Get text of Corporate Definition Checker Menu ==>" + CorporateDefinitionChecker.getText());
	        CorporateDefinitionChecker.click();

	}

	// click On Authoriser Create Corporate SubMenu
	public void clickOnAuthoriserCreateCorporateSubMenu() {
		log.info("click On Authoriser Create Corporate SubMenu ==>" + AuthoriserCreateCorporate.getText());
		AuthoriserCreateCorporate.click();
	}

public void verifyChekerPageByText() throws Exception { 
        String corporateCRN="//table[@id='list']//tbody/tr/td[3]";
		String corporateName = "//table[@id='list']//tbody/tr/td[4]";
		String corporateDesc = "//table[@id='list']//tbody/tr/td[5]";
		String officialEmail = "//table[@id='list']//tbody/tr/td[6]";
		String Address1 = "//table[@id='list']//tbody/tr/td[7]";
		String Address2 = "//table[@id='list']//tbody/tr/td[8]";
		String Address3 = "//table[@id='list']//tbody/tr/td[9]";
		String City = "//table[@id='list']//tbody/tr/td[10]";
		String State = "//table[@id='list']//tbody/tr/td[11]";
		String Country = "//table[@id='list']//tbody/tr/td[12]";
		String Zip = "//table[@id='list']//tbody/tr/td[13]";
		String AMLCheckFlag = "//table[@id='list']//tbody/tr/td[14]";
		String OwnPurposeCode = "//table[@id='list']//tbody/tr/td[15]";
		String IPAddressCheck = "//table[@id='list']//tbody/tr/td[16]";
		String IPAddress= "//table[@id='list']//tbody/tr/td[17]";
		String Remarks = "//table[@id='list']//tbody/tr/td[18]";
		String UploadType = "//table[@id='list']//tbody/tr/td[19]";
		String WebSite = "//table[@id='list']//tbody/tr/td[20]";
		String CMSCustomer = "//table[@id='list']//tbody/tr/td[21]";
		String CorpCode = "//table[@id='list']//tbody/tr/td[22]";
		String ClientCode = "//table[@id='list']//tbody/tr/td[23]";
		String Industry = "//table[@id='list']//tbody/tr/td[24]";
		String Group = "//table[@id='list']//tbody/tr/td[25]";
		String LineOfBusiness = "//table[@id='list']//tbody/tr/td[26]";
		String FileFormat = "//table[@id='list']//tbody/tr/td[27]";
		String RejectReason = "//table[@id='list']//tbody/tr/td[28]";
		String MultiContactDetails = "//table[@id='list']//tbody/tr/td[29]";
		String DebitNaration = "//table[@id='list']//tbody/tr/td[30]";
		String RipplePartnerName = "//table[@id='list']//tbody/tr/td[31]";
		String CountForcorporate = "//table[@id='list']//tbody/tr/td[32]";
		String FirstLineHeader = "//table[@id='list']//tbody/tr/td[33]";
		String StartRowCountForcorporate = "//table[@id='list']//tbody/tr/td[34]";
		String SingleColumnExcel = "//table[@id='list']//tbody/tr/td[35]";
		String SeperatorForSingleCoulmnExcel = "//table[@id='list']//tbody/tr/td[36]";
		String FileType = "//table[@id='list']//tbody/tr/td[37]";
		String SeperatorForTextFormat = "//table[@id='list']//tbody/tr/td[38]";
		String FooterStartColumn = "//table[@id='list']//tbody/tr/td[39]";
		String FooterIdentificationText = "//table[@id='list']//tbody/tr/td[40]";
		
		
		toverifyCheckerlistByUsingArrayList(corporateCRN, getcorporateCRN);
		toverifyCheckerlistByUsingArrayList(corporateName, getcorporateName);
		toverifyCheckerlistByUsingArrayList(corporateDesc, getcorporateDesc);
		toverifyCheckerlistByUsingArrayList(officialEmail, getofficialEmail);
		toverifyCheckerlistByUsingArrayList(Address1, getaddress1);
		toverifyCheckerlistByUsingArrayList(Address2, getaddress2);
		toverifyCheckerlistByUsingArrayList(Address3, getaddress3);
		toverifyCheckerlistByUsingArrayList(City, getcity);
		toverifyCheckerlistByUsingArrayList(State,getstate);
		// country value is not not
		toverifyCheckerlistByUsingArrayList(Country, CountryCode1);
		toverifyCheckerlistByUsingArrayList(Zip, getzipcode);
		toverifyCheckerlistByUsingArrayList(AMLCheckFlag, "N");
		toverifyCheckerlistByUsingArrayList(OwnPurposeCode, "N");
		toverifyCheckerlistByUsingArrayList(IPAddressCheck, "N");
		toverifyCheckerlistByUsingArrayList(IPAddress, "");
		toverifyCheckerlistByUsingArrayList(Remarks, getremarks);
		toverifyCheckerlistByUsingArrayList(UploadType, "H2H");
		toverifyCheckerlistByUsingArrayList(WebSite, getwebsite);
		toverifyCheckerlistByUsingArrayList(CMSCustomer, "Y");
		toverifyCheckerlistByUsingArrayList(CorpCode,getcorpCode);
		toverifyCheckerlistByUsingArrayList(ClientCode, getclientCode);
		toverifyCheckerlistByUsingArrayList(Industry, getindustry);
		//Group Make As Global Variable
		toverifyCheckerlistByUsingArrayList(Group, "CB");
		toverifyCheckerlistByUsingArrayList(LineOfBusiness, getlineOfBusiness);
		toverifyCheckerlistByUsingArrayList(FileFormat, "");
		toverifyCheckerlistByUsingArrayList(RejectReason, "");
		toverifyCheckerlistByUsingArrayList(MultiContactDetails, "");
		toverifyCheckerlistByUsingArrayList(DebitNaration, getdebitNarration);
		toverifyCheckerlistByUsingArrayList(RipplePartnerName, "");
		toverifyCheckerlistByUsingArrayList(CountForcorporate, getcountCorporate);
		toverifyCheckerlistByUsingArrayList(FirstLineHeader, "false");
		toverifyCheckerlistByUsingArrayList(StartRowCountForcorporate, getrowCountCorporate);
		toverifyCheckerlistByUsingArrayList(SingleColumnExcel, "false");
		toverifyCheckerlistByUsingArrayList(SeperatorForSingleCoulmnExcel, getseperateSingleColExcel);
		toverifyCheckerlistByUsingArrayList(FileType, "TEXT");
		toverifyCheckerlistByUsingArrayList(SeperatorForTextFormat, "");
		toverifyCheckerlistByUsingArrayList(FooterStartColumn, getfooterStartColumn);
		toverifyCheckerlistByUsingArrayList(FooterIdentificationText, getfooterIdentificationText);
		
		

	}

//Calling the Generic Method to verify the List in Country Checker page.
	private void toverifyCheckerlistByUsingArrayList(String xpathvalue, String value) throws InterruptedException {
		int j = 0;
		List<WebElement> list1 = driver.findElements(By.xpath(xpathvalue));
		int Nooflist = list1.size();
		System.out.println("No of list on checker Page ==>" + Nooflist);
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

	public void HandleTheDynamicVluesWithCheckbox() {
		String corporateCRN = "//table[@id='list']//tbody/tr/td[3]";
		selectThecheckboxOnCheckerPageWhenModify(corporateCRN, getcorporateCRN);
	}

	public void selectThecheckboxOnCheckerPageWhenAdded(String xpathvalue, String value) {

		List<WebElement> web = driver.findElements(By.xpath(xpathvalue));
		int sizeOfColumn = web.size();
		System.out.println("list Of  Of Check box with Unique Value Matched ==>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get the Text on checker Page ==>" + name);
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

// click on submit button And verify Succesfull Message on Checker  Page.
	public void clickonsubmitbuttonAndverifySuccesfullMessage() {

		// Click on Submit button Checker Page. To Select only one Checkbox
		log.info(" click on Submit button on Checker ==>>" + SubmitbuttononChecker.getText());
		SubmitbuttononChecker.click();
		String successfulMessageinChecker = verifysuccessfulMessageinChecker.getText();
		log.info("successful Message in Checker Page ==>" + verifysuccessfulMessageinChecker.getText());
		Assert.assertEquals(successfulMessageinChecker, "Record has been added successfully.");

	}

//   go to Maker Checker Approved Country

	public void gotoMakerWhenCheckerApproved() throws InterruptedException {
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
		log.info("search By corporate CRN==>" + getcorporateCRN);
		this.searchfield.sendKeys(getcorporateCRN);

		this.searchfield.clear();
		log.info("search By corporate Name==>" + getcorporateName);
		this.searchfield.sendKeys(getcorporateName);
		Thread.sleep(4000);
		this.searchfield.clear();
		log.info("search By client Code ==>" + getclientCode);
		this.searchfield.sendKeys(getclientCode);
		Thread.sleep(4000);
		this.searchfield.clear();

		driver.navigate().refresh();

		Select entitieslist = new Select(selectentitieslist);
		Thread.sleep(4000);
		List<WebElement> Noofentitieslist = entitieslist.getOptions();
		int nooflist = Noofentitieslist.size();
		System.out.println("No of entities list====>>" + nooflist);
		entitieslist.selectByVisibleText("100");
		for (int i = 0; i < nooflist; i++) {
			String entitiestext = Noofentitieslist.get(i).getText();
			System.out.println("Get entities text===>" + entitiestext);
		}

	}

	
// x-path of view page and calling their respective variable  and verify
	public void VerifyViewPageByGetText() {


		String CorporateId = "//table[@id='groupCorporateUsersView']//tbody//tr//td[1]";
		String CountryCRN = "//table[@id='groupCorporateUsersView']//tbody//tr//td[2]";
		String CorporateName = "//table[@id='groupCorporateUsersView']//tbody//tr//td[3]";
		String CorporateDesc = "//table[@id='groupCorporateUsersView']//tbody//tr//td[4]";
		String Website = "//table[@id='groupCorporateUsersView']//tbody//tr//td[5]";
		String CMSCustomer = "//table[@id='groupCorporateUsersView']//tbody//tr//td[6]";
		String CorpCode = "//table[@id='groupCorporateUsersView']//tbody//tr//td[7]";
		String ClientCode = "//table[@id='groupCorporateUsersView']//tbody//tr//td[8]";
		String Industry = "//table[@id='groupCorporateUsersView']//tbody//tr//td[9]";
		String Group = "//table[@id='groupCorporateUsersView']//tbody//tr//td[10]";
		String LineOfBusiness = "//table[@id='groupCorporateUsersView']//tbody//tr//td[11]";
		String OfficialEmail = "//table[@id='groupCorporateUsersView']//tbody//tr//td[12]";
		String Address1 = "//table[@id='groupCorporateUsersView']//tbody//tr//td[13]";
		String Address2 = "//table[@id='groupCorporateUsersView']//tbody//tr//td[14]";
		String City = "//table[@id='groupCorporateUsersView']//tbody//tr//td[15]";
		String State = "//table[@id='groupCorporateUsersView']//tbody//tr//td[16]";
		String Country = "//table[@id='groupCorporateUsersView']//tbody//tr//td[17]";
		String ContactPerson = "//table[@id='groupCorporateUsersView']//tbody//tr//td[18]";
		String Designation = "//table[@id='groupCorporateUsersView']//tbody//tr//td[19]";
		String TelephoneOffice = "//table[@id='groupCorporateUsersView']//tbody//tr//td[20]";
		String Mobile = "//table[@id='groupCorporateUsersView']//tbody//tr//td[21]";
		String Email = "//table[@id='groupCorporateUsersView']//tbody//tr//td[22]";
		String FileType = "//table[@id='groupCorporateUsersView']//tbody//tr//td[23]";
		String AMLFlagCheck = "//table[@id='groupCorporateUsersView']//tbody//tr//td[24]";
		String OwnPurposeCode = "//table[@id='groupCorporateUsersView']//tbody//tr//td[25]";
		
		String IPAddressCheck = "//table[@id='groupCorporateUsersView']//tbody//tr//td[26]";
		String IPAddress = "//table[@id='groupCorporateUsersView']//tbody//tr//td[27]";
		String STPFlag = "//table[@id='groupCorporateUsersView']//tbody//tr//td[28]";
		String AuthorizeUserType = "//table[@id='groupCorporateUsersView']//tbody//tr//td[29]";
		String Remarks = "//table[@id='groupCorporateUsersView']//tbody//tr//td[30]";
		String BoardResolution = "//table[@id='groupCorporateUsersView']//tbody//tr//td[31]";
		String PaymentMode = "//table[@id='groupCorporateUsersView']//tbody//tr//td[32]";
		String CMSPayment = "//table[@id='groupCorporateUsersView']//tbody//tr//td[33]";
		String AuthorityLetter = "//table[@id='groupCorporateUsersView']//tbody//tr//td[34]";
		String Edit = "//table[@id='groupCorporateUsersView']//tbody//tr//td[35]";
				
		

		verifyTextOnViewPage(CorporateId, "1121");
		verifyTextOnViewPage(CountryCRN, getcorporateCRN);
		verifyTextOnViewPage(CorporateName, getcorporateName);
        verifyTextOnViewPage(CorporateDesc, getcorporateDesc);
		verifyTextOnViewPage(Website,getwebsite );
		verifyTextOnViewPage(CMSCustomer, "Y");
		verifyTextOnViewPage(CorpCode, getcorpCode);
		verifyTextOnViewPage(ClientCode, getclientCode);
		verifyTextOnViewPage(Industry, getindustry);
		verifyTextOnViewPage(Group, "CB");
		verifyTextOnViewPage(LineOfBusiness, getlineOfBusiness);
		verifyTextOnViewPage(OfficialEmail, getofficialEmail);
		verifyTextOnViewPage(Address1, getaddress1);
		verifyTextOnViewPage(Address2, getaddress2);
		
		verifyTextOnViewPage(City, getcity);
		verifyTextOnViewPage(State, getstate);
		verifyTextOnViewPage(Country, CountryCode1);
		verifyTextOnViewPage(ContactPerson, getcontactPersons);
		verifyTextOnViewPage(Designation, getdesignation);
		verifyTextOnViewPage(TelephoneOffice, gettelNo);
		verifyTextOnViewPage(Mobile,getmobNo );
		verifyTextOnViewPage(Email, getemailId);
		verifyTextOnViewPage(FileType, "H2H");
		verifyTextOnViewPage(AMLFlagCheck, "N");
		verifyTextOnViewPage(OwnPurposeCode,"N" );
		verifyTextOnViewPage(IPAddressCheck,"N" );
		verifyTextOnViewPage(IPAddress, "null");
		verifyTextOnViewPage(STPFlag, "N");
		verifyTextOnViewPage(AuthorizeUserType, "");
		
		verifyTextOnViewPage(Remarks, getremarks);
		verifyTextOnViewPage(BoardResolution, "");
		verifyTextOnViewPage(PaymentMode, "");
		verifyTextOnViewPage(CMSPayment, "");
		verifyTextOnViewPage(AuthorityLetter,"" );
		//verifyTextOnViewPage(Edit, "");
		
		
		
		
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
	
	public void clickOnEditButtonWhenUniqueValueHasMapped() {
				String corporateName = "//table[@id='groupCorporateUsersView']//tbody//tr//td[2]";
				clickOnEditbuttonOnViewPage(corporateName, "5756756");
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
								"//table[@id='groupCorporateUsersView']//tbody//tr//td[35]"))
								.get(i).click();
						log.info("Click On Check box with Unique Value matched ==>" + value);

						break;
					} else {
						System.out.println("Get Text has NOT Mtched with Unique value On Checker page ==>" + value);
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

	
	
	
	// submit button on Modify maker page
	public void clickOnsubmitbutton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", submitbuttOncorporateDetails);
		//.switchTo().defaultContent();
		log.info("Click on submit button ==>" + submitbuttOncorporateDetails.getText());
		submitbuttOncorporateDetails.click();

	}

	

	// verification Message In Edit Create Corporate Maker Page
	public void verificationMessageInEditCreateCorporateMakerPage() {
		log.info("verification Message In MODIFY CORPORATE CONFIRMATION Maker Page ==>>"
				+ verificationMessageInModifyCountry.getText());
		// Assert.assertEquals(verificationMessageInModifyCountry.getText(), "This
		// country name has already used.");

		// verification Message In Edit Create Corporate Maker Page
		String verifythemodify = verificationMessageInModifyCountry.getText();
		System.out.println("verify Successful Message On Edit Page ==>" + verifythemodify);
		if (verifythemodify.equals("This country name has already used.")) {
			
			log.info("This country name has already used.");

		} else if (verifythemodify.equals("This Country Code has already used.")) {
			log.info("This Country Code has already used");

		} else if (verifythemodify.equals("Record has been modified successfully.")) {
			log.info("Record has been modified successfully.");

		} else {
			log.info("Successsful Message has not Matched..");

		}

	}
	
	public void clickOnLogOutBuutonOnMakerPage() {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-250)", "");
		
		log.info("Click On Log out Button ..");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//b[text()='Logout']")).click();
	}

	// to verify List Of Values On Checker Page When Modified Entity Mapping
	//
	public void verifyCreateCorporateCheckerPageModificationhasDoneByMaker()throws InterruptedException {

		 String corporateCRN="//table[@id='list']//tbody/tr/td[3]";
			String corporateName = "//table[@id='list']//tbody/tr/td[4]";
			String corporateDesc = "//table[@id='list']//tbody/tr/td[5]";
			String officialEmail = "//table[@id='list']//tbody/tr/td[6]";
			String Address1 = "//table[@id='list']//tbody/tr/td[7]";
			String Address2 = "//table[@id='list']//tbody/tr/td[8]";
			String Address3 = "//table[@id='list']//tbody/tr/td[9]";
			String City = "//table[@id='list']//tbody/tr/td[10]";
			String State = "//table[@id='list']//tbody/tr/td[11]";
			String Country = "//table[@id='list']//tbody/tr/td[12]";
			String Zip = "//table[@id='list']//tbody/tr/td[13]";
			String AMLCheckFlag = "//table[@id='list']//tbody/tr/td[14]";
			String OwnPurposeCode = "//table[@id='list']//tbody/tr/td[15]";
			String IPAddressCheck = "//table[@id='list']//tbody/tr/td[16]";
			String IPAddress= "//table[@id='list']//tbody/tr/td[17]";
			String Remarks = "//table[@id='list']//tbody/tr/td[18]";
			String UploadType = "//table[@id='list']//tbody/tr/td[19]";
			String WebSite = "//table[@id='list']//tbody/tr/td[20]";
			String CMSCustomer = "//table[@id='list']//tbody/tr/td[21]";
			String CorpCode = "//table[@id='list']//tbody/tr/td[22]";
			String ClientCode = "//table[@id='list']//tbody/tr/td[23]";
			String Industry = "//table[@id='list']//tbody/tr/td[24]";
			String Group = "//table[@id='list']//tbody/tr/td[25]";
			String LineOfBusiness = "//table[@id='list']//tbody/tr/td[26]";
			String FileFormat = "//table[@id='list']//tbody/tr/td[27]";
			String RejectReason = "//table[@id='list']//tbody/tr/td[28]";
			String MultiContactDetails = "//table[@id='list']//tbody/tr/td[29]";
			String DebitNaration = "//table[@id='list']//tbody/tr/td[30]";
			String RipplePartnerName = "//table[@id='list']//tbody/tr/td[31]";
			String CountForcorporate = "//table[@id='list']//tbody/tr/td[32]";
			String FirstLineHeader = "//table[@id='list']//tbody/tr/td[33]";
			String StartRowCountForcorporate = "//table[@id='list']//tbody/tr/td[34]";
			String SingleColumnExcel = "//table[@id='list']//tbody/tr/td[35]";
			String SeperatorForSingleCoulmnExcel = "//table[@id='list']//tbody/tr/td[36]";
			String FileType = "//table[@id='list']//tbody/tr/td[37]";
			String SeperatorForTextFormat = "//table[@id='list']//tbody/tr/td[38]";
			String FooterStartColumn = "//table[@id='list']//tbody/tr/td[39]";
			String FooterIdentificationText = "//table[@id='list']//tbody/tr/td[40]";
			
			
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(corporateCRN, getcorporateCRN);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(corporateName, getcorporateName);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(corporateDesc, getcorporateDesc);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(officialEmail, getofficialEmail);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(Address1, getaddress1);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(Address2, getaddress2);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(Address3, getaddress3);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(City, getcity);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(State,getstate);
			// country value is not not
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(Country, CountryCode1);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(Zip, getzipcode);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(AMLCheckFlag, "N");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(OwnPurposeCode, "N");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(IPAddressCheck, "N");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(IPAddress, "");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(Remarks, getremarks);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(UploadType, "H2H");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(WebSite, getwebsite);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(CMSCustomer, "Y");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(CorpCode,getcorpCode);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(ClientCode, getclientCode);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(Industry, getindustry);
			//Group Make As Global Variable
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(Group, "CB");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(LineOfBusiness, getlineOfBusiness);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(FileFormat, "");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(RejectReason, "");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(MultiContactDetails, "");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(DebitNaration, getdebitNarration);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(RipplePartnerName, "");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(CountForcorporate, getcountCorporate);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(FirstLineHeader, "false");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(StartRowCountForcorporate, getrowCountCorporate);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(SingleColumnExcel, "false");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(SeperatorForSingleCoulmnExcel, getseperateSingleColExcel);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(FileType, "TEXT");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(SeperatorForTextFormat, "");
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(FooterStartColumn, getfooterStartColumn);
			toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(FooterIdentificationText, getfooterIdentificationText);
			
			

	}

	// Calling the Generic Method to verify the List in Checker page.
	private void toverifyListOfValuesOnCheckerPageWhenEditTheCorporate(String xpathvalue, String value)
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
		String corporateCRN = "//table[@id='list']//tbody/tr/td[3]";
		selectThecheckboxOnCheckerPageWhenModify(corporateCRN, getcorporateCRN);
	}

	public void selectThecheckboxOnCheckerPageWhenModify(String xpathvalue, String value) {

		List<WebElement> web = driver.findElements(By.xpath(xpathvalue));
		int sizeOfColumn = web.size();
		System.out.println("list Of  Of Check box with Unique Value Matched ==>>" + sizeOfColumn);
		for (int i = 0; i < web.size(); i++) {
			String name = web.get(i).getText();
			System.out.println("Get the Text on checker Page ==>" + name);
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
		
		log.info("successful Message in Checker====" + verifysuccessfulMessageinChecker.getText());
		//Assert.assertEquals(successfulMessageinChecker, "Record has been Updated successfully.");

		if (verifysuccessfulMessageinChecker.getText().equals("Record has been added successfully.")) {
			log.info("Record updated successfully. On checker page");
		} else {
			log.info("Record updated successfully. Not verify on checker page");
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
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 100); WebElement Category_Body
		 * = wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath("//td[@class='mainmenu']//following-sibling::a[text()='Logout']")));
		 * System.out.println(Category_Body);
		 */

		driver.findElement(By.xpath("//b[text()='Logout']")).click();

	}
}
