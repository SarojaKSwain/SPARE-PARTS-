package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;


import supportLibrary.CommonFunction;




public class ShoppingCartPage extends CommonFunction{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	By Increase = By.xpath("//form[@id='updateCartForm0']//*[local-name()='svg'][@class='A-Icon A-Icon--sp-arrow-up sp-increase-quantity js-update-entry-quantity-input']");
	By Decrease = By.xpath("//form[@id='updateCartForm0']//*[local-name()='svg'][@class='A-Icon A-Icon--sp-arrow-down sp-decrease-quantity js-update-entry-quantity-input']");
	By Remove = By.xpath("//li[@id='actionEntry_0']//a[@class='A-Link__link A-Link__link--remove A-Link__link--inline']");
	By ClickonPage = By.xpath("//span[contains(text(),'Your cart')]");
	By ContinueButton = By.xpath("//button[@id='cart-total-proceed-btn']");
   	By CheckoutText = By.xpath("//h1[@class='sp-checkout-headline']']");
   	By Save = By.xpath("//button[@id='save-button']");

	
	/*
	 * To increase and decrease quantity 
	 */
	 
	public void quantity() {
		try {
			hardDelay(2000);
			waitForPageLoad();
			clickElement(Increase, "increase");
			logHtmlReport(LogStatus.PASS, "Quantity Increased");
			hardDelay(15000);
			waitForPageLoad();
			clickElement(Decrease, "decrease");
			logHtmlReport(LogStatus.PASS, "Quantity Decrease");
			hardDelay(15000);
			waitForPageLoad();
			clickElement(Remove, "Remove");
			logHtmlReport(LogStatus.PASS, "Quantity Modification Successful with Deletion");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Quantity Modification Failed");
		}
	}
	
   	
		/*
		 * To click on continue Button in shopping cart page
		 */
		
		public void continueto() {
			try {
				waitForPageLoad();
				hardDelay(25000);
				clickElement(ContinueButton, "continueButton");
				logHtmlReport(LogStatus.PASS, "Clicked on Continue");
				waitForPageLoad();
				hardDelay(1000);
				elementIsDisplayed(Save, "save");
				logHtmlReport(LogStatus.PASS, "Navigated to Address Page");
				}catch(Exception e) {
				logHtmlReport(LogStatus.FAIL, "Navigation to failed to Address Page");
			}
	}
	}

