			package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import supportLibrary.CommonFunction;

public class AddressAndReview extends CommonFunction{

	public AddressAndReview(WebDriver driver) {
		super(driver);
	
	}
	                    
	By Save = By.xpath("//button[@id='save-button']");
    By Company = By.id("company-field");
    By FirstName = By.id("firstName-field");
    By SurName = By.id("lastName-field");
    By Street = By.id("streetName-field");
    By HouseNo = By.id("houseNumber-field");
    By PostCode = By.id("zipCode-field");
    By VATField = By.id("VAT-field");
    By ItalyVATField = By.id("taxCode-field");
    By City = By.id("city-field");
    By Email = By.id("email-field");
    By ConfirmEmail = By.id("confirmEmail-field");
    By PhoneNo = By.id("phoneNumber-field");
    By PaymentMethod = By.xpath("//div[@class='bosch-payment-method-block']");
    By OrderConfirm = By.xpath("//div[@class='col-xs-12']//h1[@class='sp-checkout-headline']");
  //  By TC = By.xpath("//span[contains(text(),'Yes, I have read and accept the')]");
  //  By Regulation = By.xpath("//span[contains(text(),'I confirm that any components purchased will be in')]");
 //   By TC = By.xpath("//label[@for='cbTermsConditions']");
    By TC = By.xpath("//div[contains(@class,'col-xs-12 sp-summary-legal')]//label[@for='cbTermsConditions']//span[@class='A-FormField__icon']"); 
    By Regulation = By.xpath("//label[@for='cbInstallation']"); 
    By Condition_IT = By.xpath("//label[@for='additionalConsent']//span[@class='A-FormField__icon']");
    By SendOrder = By.xpath("//input[@id='save-button']"); 
    By Paymentpage = By.xpath("//div[@id='displayAmount']");
    By Radio_eorder = By.xpath("//label[@for='rbIntroduction-1']//span[@class='A-FormField__icon']");
    By Checkbox_eorder = By.xpath("//label[@id='cbItemsAvailabilityLabel']//span[contains(@class,'A-FormField__icon')]");
    By Checkbox_eorder_PL = By.xpath("//label[@id='cbeOrderTermsAndConditionsCheckboxLabel']//span[@class='A-FormField__icon']");
    By Checkbox_Serbia = By.xpath("//span[@class='A-FormField__labelText__bscCheckbox']");
    By Submit_eorder = By.xpath("//div[@id='checkout-buttons']//input[@id='save-button']");
    By Eorder_confirm = By.xpath("//div[@class='col-xs-12']//h1[@class='sp-checkout-headline']");
    By SavePdf = By.xpath("//input[@id='save-pdf-button']");
    
	/*
	 * To enter billing address detail
	 */
    
	public void billingAddress(String company,String firstName,String surName,String street,String houseNo,
			String city,String email,String confirmEmail,String phoneNo) {
		try {
			waitForPageLoad();
			enterText(Company, "company", company);
			enterText(FirstName, "firstName", firstName);
			enterText(SurName, "surName", surName);
			enterText(Street, "street", street);
			enterText(HouseNo, "houseNo", houseNo);
			enterText(PostCode, "postCode", getCountrySpecificData("PostalCode"));
			//enterText(VATField, "vatField", getCountrySpecificData("VAT"));
			//enterText(PostCode, "postCode", postCode);
			enterText(City, "city", city);
			enterText(Email, "email", email);
			enterText(ConfirmEmail, "confirmEmail", confirmEmail);
			enterText(PhoneNo, "phoneNo", phoneNo);
			logHtmlReport(LogStatus.PASS, "Address Details entered Successfully");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Address Details not entered Successfully");
		}
	}
	
	/*
	 * To enter billing address detail with tax (excpet for Italy)
	 */
    
	public void billingAddressVAT(String company,String firstName,String surName,String street,String houseNo,
			String city,String email,String confirmEmail,String phoneNo) {
		try {
			waitForPageLoad();
			enterText(Company, "company", company);
			enterText(FirstName, "firstName", firstName);
			enterText(SurName, "surName", surName);
			enterText(Street, "street", street);
			enterText(HouseNo, "houseNo", houseNo);
			enterText(PostCode, "postCode", getCountrySpecificData("PostalCode"));
			enterText(VATField, "vatField", getCountrySpecificData("VAT"));
			//enterText(PostCode, "postCode", postCode);
			enterText(City, "city", city);
			enterText(Email, "email", email);
			enterText(ConfirmEmail, "confirmEmail", confirmEmail);
			enterText(PhoneNo, "phoneNo", phoneNo);
			logHtmlReport(LogStatus.PASS, "Address Details entered Successfully");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Address Details not entered Successfully");
		}
	}
	
	/*
	 * To enter billing address detail with tax field for Italy
	 */
    
	public void billingAddressItaly(String firstName,String surName,String street,String houseNo,
			String city,String email,String confirmEmail,String phoneNo) {
		try {
			waitForPageLoad();
		//	enterText(Company, "company", company);
			enterText(FirstName, "firstName", firstName);
			enterText(SurName, "surName", surName);
			enterText(Street, "street", street);
			enterText(HouseNo, "houseNo", houseNo);
			enterText(PostCode, "postCode", getCountrySpecificData("PostalCode"));
			enterText(ItalyVATField, "vatField", getCountrySpecificData("VAT"));
			//enterText(PostCode, "postCode", postCode);
			enterText(City, "city", city);
			enterText(Email, "email", email);
			enterText(ConfirmEmail, "confirmEmail", confirmEmail);
			enterText(PhoneNo, "phoneNo", phoneNo);
			logHtmlReport(LogStatus.PASS, "Address Details entered Successfully");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Address Details not entered Successfully");
		}
	}
	
	/*
	 * To click on Save and continue button
	 */
	public void saveAddress() {
		try {
			clickElement(Save, "save");
			hardDelay(1000);
			logHtmlReport(LogStatus.PASS, "Clicked on Save in Address Page");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Clicked on Save in Address Page Failed");
		}
	}
	
	
	/*
	 * To accept checkbox and then click on Save and continue button for serbia
	 */
	public void saveAddressRS() {
		try {
			clickElement(Checkbox_Serbia, "checkbox_Serbia");
			logHtmlReport(LogStatus.PASS, "Checkbox Clicked");
			clickElement(Save, "save");
			hardDelay(1000);
			logHtmlReport(LogStatus.PASS, "Clicked on Save in Address Page");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Clicked on Save in Address Page Failed");
		}
	}
	
	/*
	 * To click on Save and continue button
	 */
	public void savePdf() {
		try {
			clickElement(SavePdf, "SavePdf");
			hardDelay(1000);
			logHtmlReport(LogStatus.PASS, "Clicked on Save Pdf button");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Clicked on Save pdf button Failed");
		}
	}	
	
	/*
	 * To select Payment method and  click on Save and continue button
	 */
	public void selectPayment() {
		try {
			waitForPageLoad();
			elementIsDisplayed(PaymentMethod, "paymentMethod");
			logHtmlReport(LogStatus.PASS, "Payment Method displayed");
			clickElement(Save, "save");
			hardDelay(2000);
			logHtmlReport(LogStatus.PASS, "Clicked on Save in Payment Method Page");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Clicked on Save in Payment Method Page failed");
		}
	}
		/*
		 * To select Accept T&C,Regulation checkbox and click on Send Order
		 */
		public void tcr() {
			try {
				hardDelay(3000);
				clickElement(TC, "tc");
				logHtmlReport(LogStatus.PASS, "T&C accepted");
				clickElement(Regulation, "Regulation");
				logHtmlReport(LogStatus.PASS, "Regulations accpeted");
				hardDelay(2000);
				clickElement(SendOrder, "sendOrder Clicked");
				elementIsDisplayed(Paymentpage, "paymentpage");
				logHtmlReport(LogStatus.PASS, "Paymentpage Displayed");
				}catch(Exception e) {
				logHtmlReport(LogStatus.FAIL, "Paymentpage not Displayed");
			}	
		
	}
		
		/*
		 * To select Accept T&C,Regulation checkbox and click on Place Order for CZ and SK eshop (COD)
		 */
		public void tcr_CZ_SK() {
			try {
				hardDelay(3000);
				clickElement(TC, "tc");
				logHtmlReport(LogStatus.PASS, "T&C accepted");
				clickElement(Regulation, "Regulation");
				logHtmlReport(LogStatus.PASS, "Regulations accpeted");
				hardDelay(2000);
				clickElement(SendOrder, "sendOrder Clicked");
				elementIsDisplayed(OrderConfirm, "OrderConfirm");
				hardDelay(2000);
				logHtmlReport(LogStatus.PASS, "Order Placed Successfully");
				}catch(Exception e) {
				logHtmlReport(LogStatus.FAIL, "Order Not placed successfully");
			}	
		
	}

		/*
		 * To select Accept T&C,Regulation,Conditions checkbox for Italy eshop and click on Send Order
		 */
		public void tcr_Italy() {
			try {
				hardDelay(3000);
				clickElement(TC, "tc");
				logHtmlReport(LogStatus.PASS, "T&C accepted");
				clickElement(Regulation, "Regulation");
				logHtmlReport(LogStatus.PASS, "Regulations accpeted");
				clickElement(Condition_IT, "condition_IT ");
				logHtmlReport(LogStatus.PASS, "Conditions accpeted");
				hardDelay(2000);
				clickElement(SendOrder, "sendOrder Clicked");
				elementIsDisplayed(Paymentpage, "paymentpage");
				logHtmlReport(LogStatus.PASS, "Paymentpage Displayed");
				}catch(Exception e) {
				logHtmlReport(LogStatus.FAIL, "Paymentpage not Displayed");
			}	
		
	}
		
		/*
		 * To select Accept radio button and checkbox for eorder countries and click on submit
		 */
		public void tcr_eorder() {
			try {
				hardDelay(2000);
				clickElement(Radio_eorder, "radio_eorder");
				logHtmlReport(LogStatus.PASS, "Radio Button Clicked");
				clickElement(Checkbox_eorder, "checkbox_eorder");
				logHtmlReport(LogStatus.PASS, "Checkbox Clicked");
				hardDelay(2000);
				clickElement(Submit_eorder, "Submit Order Clicked");
				elementIsDisplayed(Eorder_confirm, "Eorder_confirm");
				logHtmlReport(LogStatus.PASS, "Eorder_confirm Displayed");
				}catch(Exception e) {
				logHtmlReport(LogStatus.FAIL, "Eorder_confirm not Displayed");
			}	
		
	}

	
		/*
		 * To select Accept radio button and checkbox for eorder Poland and click on submit
		 */
		
		public void tcr_eorder_PL() {
			try {
				hardDelay(2000);
				clickElement(Radio_eorder, "radio_eorder");
				logHtmlReport(LogStatus.PASS, "Radio Button Clicked");
				clickElement(Checkbox_eorder, "checkbox_eorder");
				logHtmlReport(LogStatus.PASS, "Checkbox Clicked");
				clickElement(Checkbox_eorder_PL, "checkbox_eorde_pl");
				logHtmlReport(LogStatus.PASS, "Checkbox Clicked");
				hardDelay(2000);
				clickElement(Submit_eorder, "Submit Order Clicked");
				elementIsDisplayed(Eorder_confirm, "Eorder_confirm");
				logHtmlReport(LogStatus.PASS, "Eorder_confirm Displayed");
				}catch(Exception e) {
				logHtmlReport(LogStatus.FAIL, "Eorder_confirm not Displayed");
			}	
		
	}
		
	
}
