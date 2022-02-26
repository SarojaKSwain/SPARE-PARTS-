 package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import supportLibrary.CommonFunction;
import supportLibrary.ReadJson;
import supportLibrary.SuiteFile;

public class FirstPage extends CommonFunction{

	
	public FirstPage(WebDriver driver) {
		super(driver);
	}
	
//	By Input = By.xpath("//input[@placeholder='Enter the tool type number, tool name or spare part number']");
	By Input = By.xpath("//input[@placeholder]");
	By SearchButton = By.xpath("//span[@class='A-Button-label']");
//	By CloseConsent = By.xpath("//button[@class='BoschPrivacySettingsV2__close']");
	By CloseConsent = By.xpath("//button[@class='BoschPrivacySettingsV2__button BoschPrivacySettingsV2__button--primary BoschPrivacySettingsV2__button--acceptAll']");
//	By Search = By.xpath("//span[@class='A-Button-label' and text()='Search']");
	By Search = By.xpath("//span[@class='A-Button-label']");
	By CountryDD = By.xpath("//div[@class='A-FormField A-FormField-Select' and div[text()='Country ID']]/div[@class='dropdown']/button");
	By Result = By.xpath("//span[@class='as-results-cout-text']");
	String countryID = "//a[text()='%s']";
	By Contact_us = By.xpath("//div[@class='O-Header__meta']//a[@class='M-Navigation__link M-Navigation-Meta__link'][contains(text(),'Contact Us')]");
	By Customer_Service = By.xpath("//div[@class='M-FooterNavigation__blockInstance__name']");
	By Imprint = By.xpath("//span[contains(text(),'Imprint')]");
	By Data_privacy = By.xpath("//span[contains(text(),'Data privacy')]");
	By TC = By.xpath("//span[contains(text(),'Terms and Conditions')]");
	By Privacy_Settings = By.xpath("//span[contains(text(),'Privacy settings')]");
	By payment_icons = By.xpath("//div[@class='payment-icons']");
	By Order_returns = By.xpath("//a[contains(text(),'Order & returns')]");
	By FAQ = By.xpath("//a[contains(text(),'FAQs')]");
	By Footer_Contact = By.xpath("//a[@class='M-FooterNavigation__links'][contains(text(),'Contact Us')]");
	By Youtube_SK = By.xpath("//span[@class='icon-youtube']");
	By Instagram_SK = By.xpath("//span[@class='icon-instagram']");
	By Pinterest_SK = By.xpath("//span[@class='icon-pinterest']");
	
	/**
	 * To launch application and click on Advance Search
	 */
	public void launchApplicationSP(String path) {
		try {
			String url = ReadJson.getEnvBaseData("url")+path;
			navigateToURL(url);
			waitForPageLoad();
			logHtmlReport(LogStatus.PASS, "Application Launched Successfully");
			clickElement(CloseConsent, "CloseConsent");
			logHtmlReport(LogStatus.PASS, "Consent Closed");
			hardDelay(1000);
			elementIsDisplayed(SearchButton, "Input");
			logHtmlReport(LogStatus.PASS, "Input Field found");
			logHtmlReport(LogStatus.PASS, "Application Opened Successfully and verified "+url);
		 }catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Exception while launching application URL");
		}
	}
		
		/**
		 * To launch application, enter Baretool Number and click on Search 
		 */
		public void launchAppwithBaretool(String url, String baretool) {
			try {
				navigateToURL(url);
				waitForPageLoad();
				logHtmlReport(LogStatus.PASS, "Application Launched Successfully");
				clickElement(CloseConsent, "CloseConsent");
				logHtmlReport(LogStatus.PASS, "Consent Closed");
				hardDelay(1000);
				//elementIsDisplayed(Input, "Input");
				elementIsDisplayed(SearchButton, "Input");
				enterText(Input, "input", baretool);
				clickElement(Search, "search");
				logHtmlReport(LogStatus.PASS, "Input Field found");
				logHtmlReport(LogStatus.PASS, "Application Opened Successfully and Baretool number found"+url);
			}catch(Exception e) {
				logHtmlReport(LogStatus.FAIL, "Exception while launching application URL");
			}
	}
		
		/**
		 * To launch application new framework, enter Baretool Number and click on Search 
		 */

		public void launchApp(String baretool) {
			try {
			String url = ReadJson.getEnvBaseData("url")+ReadJson.getCountrySpecficData(SuiteFile.getCountry(),"path")+ReadJson.getBrandURL(SuiteFile.getBrand());
			logHtmlReport(LogStatus.INFO, "URL "+url);
			navigateToURL(url);
			clickElement(CloseConsent, "CloseConsent");
			logHtmlReport(LogStatus.PASS, "Consent Closed");
			hardDelay(1000);
			elementIsDisplayed(SearchButton, "Input");
		//	elementIsDisplayed(Input, "Input");
			enterText(Input, "input", baretool);
			clickElement(Search, "search");
			logHtmlReport(LogStatus.PASS, "Input Field found");
			logHtmlReport(LogStatus.PASS, "Application Opened Successfully and Baretool number found"+url);
		}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Exception while launching application URL");
		}
}

		/**
		 * To launch application with new framework changes and click on Advance Search
		 */
		public void launchAppSP() {
			try {
				String url = ReadJson.getEnvBaseData("url")+ReadJson.getCountrySpecficData(SuiteFile.getCountry(),"path")+ReadJson.getBrandURL(SuiteFile.getBrand());
				logHtmlReport(LogStatus.INFO, "URL "+url);
				navigateToURL(url);
				hardDelay(1000);
				clickElement(CloseConsent, "CloseConsent");
				logHtmlReport(LogStatus.PASS, "Consent Closed");
				hardDelay(2000);
				elementIsDisplayed(SearchButton, "Input");
				logHtmlReport(LogStatus.PASS, "Input Field found");
				logHtmlReport(LogStatus.PASS, "Application Opened Successfully and verified "+url);
			 }catch(Exception e) {
				logHtmlReport(LogStatus.FAIL, "Exception while launching application URL");
			}
		}
		
		
		/**
		 * To check header and footer, then launch eshop application with Baretool Number and click on Search 
		 */

		public void launchApp_HFeshop(String baretool) {
			try {
			String url = ReadJson.getEnvBaseData("url")+ReadJson.getCountrySpecficData(SuiteFile.getCountry(),"path")+ReadJson.getBrandURL(SuiteFile.getBrand());
			logHtmlReport(LogStatus.INFO, "URL "+url);
			navigateToURL(url);
			clickElement(CloseConsent, "CloseConsent");
			logHtmlReport(LogStatus.PASS, "Consent Closed");
			hardDelay(1000);
			waitForPageLoad();
			elementIsDisplayed(SearchButton, "Input");
		//	elementIsDisplayed(Input, "Input");
			elementIsDisplayed(Contact_us, "contact_us");
			elementIsDisplayed(Customer_Service, "customer_Service");
			elementIsDisplayed(Imprint, "imprint");
			elementIsDisplayed(Data_privacy, "data_privacy");
			elementIsDisplayed(TC, "tc");
			elementIsDisplayed(Privacy_Settings, "privacy_Settings");
			elementIsDisplayed(payment_icons, "Payment_icons");
			elementIsDisplayed(Order_returns, "order_returns");
			elementIsDisplayed(FAQ, "faq");
			elementIsDisplayed(Footer_Contact, "Footer_Contact");
			enterText(Input, "input", baretool);
			clickElement(Search, "search");
			logHtmlReport(LogStatus.PASS, "Input Field found");
			logHtmlReport(LogStatus.PASS, "Application Opened Successfully and Baretool number found"+url);
		}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Exception while launching application URL");
		}
}
	
		
		/**
		 * To check header and footer, then launch Eorder,print application with Baretool Number and click on Search 
		 */

		public void launchApp_HF(String baretool) {
			try {
			String url = ReadJson.getEnvBaseData("url")+ReadJson.getCountrySpecficData(SuiteFile.getCountry(),"path")+ReadJson.getBrandURL(SuiteFile.getBrand());
			logHtmlReport(LogStatus.INFO, "URL "+url);
			navigateToURL(url);
			clickElement(CloseConsent, "CloseConsent");
			logHtmlReport(LogStatus.PASS, "Consent Closed");
			hardDelay(1000);
			waitForPageLoad();
			elementIsDisplayed(SearchButton, "Input");
			elementIsDisplayed(Contact_us, "contact_us");
			elementIsDisplayed(Customer_Service, "customer_Service");
			elementIsDisplayed(Imprint, "imprint");
			elementIsDisplayed(Data_privacy, "data_privacy");
			elementIsDisplayed(Privacy_Settings, "privacy_Settings");			
			elementIsDisplayed(Footer_Contact, "Footer_Contact");
			enterText(Input, "input", baretool);
			clickElement(Search, "search");
			logHtmlReport(LogStatus.PASS, "Input Field found");
			logHtmlReport(LogStatus.PASS, "Application Opened Successfully and Baretool number found"+url);
		}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Exception while launching application URL");
		}
}	
		
		
		/**
		 * To check skill brand navigation
		 */

		public void launchskill() {
			try {
				String url = ReadJson.getEnvBaseData("url")+ReadJson.getCountrySpecficData(SuiteFile.getCountry(),"path")+ReadJson.getBrandURL(SuiteFile.getBrand());
				logHtmlReport(LogStatus.INFO, "URL "+url);
				navigateToURL(url);
				waitForPageLoad();
				getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
				elementIsDisplayed(Youtube_SK, "youtube_SK");
				elementIsDisplayed(Instagram_SK, "Instagram_SK");
				elementIsDisplayed(Pinterest_SK, "Pinterest_SK");
				logHtmlReport(LogStatus.PASS, "Skill Brand Link Navigation successful" );
			}catch(Exception e) {
				logHtmlReport(LogStatus.FAIL, "Exception while launching application URL");
			}
	}	
}

