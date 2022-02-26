package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import supportLibrary.CommonFunction;

public class Payment extends CommonFunction{

	public Payment(WebDriver driver) {
		super(driver);
	}
	
	    By CardNo = By.xpath("//input[@id='card.cardNumber']");
	    By CardHolderName = By.xpath("//input[@id='card.cardHolderName']");
	    By CardExpiryMonth = By.xpath("//select[@class='inputField hpp-expiry-month']");
	    By CardExpiryYear = By.xpath("//select[@class='inputField hpp-expiry-year']");	
	    By CardCvv = By.xpath("//input[@id='card.cvcCode']");
	    By Month = By.xpath("//option[text()='03']");
	    By Year = By.xpath("//option[text()='2030']");
	 // By PlaceOrder = By.xpath("//button[contains(@class,'A-Button--Z-Index')][text()='Place order']");
	    By PlaceOrder = By.xpath("//button[contains(@class,'A-Button--Z-Index')]");
     // By OrderConfirm = By.xpath("//p[contains(text(),'We have sent you a confirmation email with all imp')]");
        By OrderConfirm = By.xpath("//div[@class='col-xs-12']//h1[@class='sp-checkout-headline']");
   
     /*
	 * To enter Credit Card Details
	 */
    
	public void paymentDetails(String cardNo,String cardHolderName,String Month,String Year,String cardCvv) {
		try {
			waitForPageLoad();
			enterText(CardNo, "CardNo", cardNo);
			 logHtmlReport(LogStatus.PASS, "Card No entered");
			enterText(CardHolderName, "cardHolderName", cardHolderName);
			 logHtmlReport(LogStatus.PASS, "Card holder name entered");
			 select_value_from_dropdown(CardExpiryMonth, Month);
			 hardDelay(1000);
			 select_value_from_dropdown(CardExpiryYear, Year);
			 hardDelay(1000);
			enterText(CardCvv, "CardCvv", cardCvv);
			logHtmlReport(LogStatus.PASS, "Cvv Entered");
			clickElement(PlaceOrder, "placeorder");
			hardDelay(1000);
			elementIsDisplayed(OrderConfirm, "OrderConfirm");
			hardDelay(2000);
			logHtmlReport(LogStatus.PASS, "Order Placed Successfully");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Payment issue Order not Placed Successfully");
		}
	}
	}