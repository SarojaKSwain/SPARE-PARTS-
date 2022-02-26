 package pages.web;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import supportLibrary.CommonFunction;

public class AdvancedSearch extends CommonFunction{ 
	
	
	public AdvancedSearch(WebDriver driver) {
		super(driver);
	}
	
//	By AdvancedSearch = By.xpath("//span[contains(text(),'Advanced search')]");
	By AdvancedSearch = By.xpath("//div[@class='row']/div[@class='col-xs-10 col-xs-offset-1 linkWhite']/div/a-brand-link-dynamic/div[@class='A-Link-brand']/div[@class='A-Link A-Link--primary']/a[@class='A-Link__link A-Link__link--primary']/a-icon-dynamic[1]//*[local-name()='svg']");
//	By CountryDD = By.xpath("//div[@class='A-FormField A-FormField-Select' and div[text()='Country ID']]/div[@class='dropdown']/button");
	String CountryDD = "//div[@class='A-FormField A-FormField-Select' and div[text()='%s']]/div[@class='dropdown']/button";
	String CountryDD_RO = "//div[@class='A-FormField A-FormField-Select' and div[contains(text(),'%s']]/div[@class='dropdown']/button";
	By Search = By.xpath("//span[@class='A-Button-label']");
	By Result = By.xpath("//span[@class='as-results-cout-text']");
	String countryID = "//a[text()='%s']";
//	By FilterResult = By.xpath("//tr[1]//td[5]//a-brand-icon-dynamic[1]//span[1]//*[local-name()='svg']");
	By FilterResult = By.xpath("//tr[1]//td[5]//a-brand-icon-dynamic//span//*[local-name()='svg']");
   	By SingleFilter = By.xpath("//td[@class='M-Table__cell arrow']//span[@class='A-Icon-brand']//*[local-name()='svg']");
    By ProductInformation = By.xpath("//span[@data-translate='Product details']"); 	
 //  	By ProductInformation = By.xpath("//span[@data-translate='Spare parts in the shopping cart']");
	//String Addtocart = "(//div[@class='A-Button--brand_wrapper heading-line-button']/button[@class='A-Button A-Button--brand A-Button--primary A-Button--regular']//span[@class='A-Button-label' and text()='Add to cart'])[%s]";
	String Addtocart = "(//div[@class='A-Button--brand_wrapper heading-line-button']/button[@class='A-Button A-Button--brand A-Button--primary A-Button--regular']//span[@class='A-Button-label' and @data-translate='Add to cart'])";
//	String DremelAddtocart = "(//div[@class='A-Button--brand_wrapper heading-line-button']/button[@class='A-Button A-Button--brand A-Button--primary A-Button--regular']//span[@class='A-Button-label' and text()='Add to cart'])";
	String DremelAddtocart = "(//div[@class='A-Button--brand_wrapper heading-line-button']/button[@class='A-Button A-Button--brand A-Button--primary A-Button--regular']//span[@class='A-Button-label' and @data-translate='Add to cart'])";
	By Minishoppingcart = By.xpath("//a[@class='M-ProfileAccess__toggleLink']");
	By ClickonPage = By.xpath("//span[contains(text(),'Your cart')]");
	By ContinueButton = By.xpath("//button[@id='cart-total-proceed-btn']");
	By PrintPdf = By.xpath("//button[contains(@class,'A-Button--regular A-Button--Print')]");
	By Voltage = By.xpath("//div[@class='A-FormField A-FormField-Select' and div[text()='Voltage']]/div[@class='dropdown']/button");
	By Voltage_Value = By.xpath("//a[text()='240.00']");
	By Products = By.xpath("//div[@class='A-FormField A-FormField-Select' and div[text()='Product groups']]/div[@class='dropdown']/button");
	By Products_Value = By.xpath("//a[text()='015 - All-purpose saws']");
	By ExplosionID1 = By.xpath("//div[@class='image-click-overlay']//div[@id='26']");
	By ExplosionID2 = By.xpath("//div[@class='image-click-overlay']//div[@id='20']");
	By ExplosionID3 = By.xpath("//div[@class='image-click-overlay']//div[@id='19']");
	By IncartID1 = By.xpath("//div[@class='part_1']//div//m-as-accordion-explosion-parts//div[@class='M-Accordion__item M-Accordion-Text__item asAccordion']//div[@class='M-Accordion__itemToggle']//div[@class='col-xs-5 col-sm-6 col-md-10 no-padding-right no-padding-left-xs']//div//span[@class='A-Button-label'][contains(text(),'In Cart')]");
	By IncartID2 = By.xpath("//div[@class='part_2']//div//m-as-accordion-explosion-parts//div[@class='M-Accordion__item M-Accordion-Text__item asAccordion']//div[@class='M-Accordion__itemToggle']//div[@class='col-xs-5 col-sm-6 col-md-10 no-padding-right no-padding-left-xs']//div//span[@class='A-Button-label'][contains(text(),'In Cart')]");
	By IncartID3 = By.xpath("//div[@class='part_3']//div//m-as-accordion-explosion-parts//div[@class='M-Accordion__item M-Accordion-Text__item asAccordion']//div[@class='M-Accordion__itemToggle']//div[@class='col-xs-5 col-sm-6 col-md-10 no-padding-right no-padding-left-xs']//div//span[@class='A-Button-label'][contains(text(),'In Cart')]");
	By ShoppingPage = By.xpath("//div[@class='col-xs-12']//h1[@class='u-Text--centered']");
	 By Lubrication = By.xpath("//span[@data-translate='Lubrication instructions']"); 	
	 By Print = By.xpath("//span[@data-translate='Print illustration']");	
	 By Lubrication_Close = By.xpath("//div[@id='ngdialog1']//span[@class='A-Modal__close']//*[local-name()='svg']");
	 By Product_close = By.xpath("//div[@id='ngdialog2']//span[@class='A-Modal__close']//*[local-name()='svg']");
	By PDF_Lubrication = By.xpath("//span[@class='A-FormField__labelText'][contains(text(),'Lubrication instructions')]");
	By PDF_Product = By.xpath("//span[@class='A-FormField__labelText'][contains(text(),'Product information')]");
	By PDF_Exp = By.xpath("//span[@class='A-FormField__labelText'][contains(text(),'Explosion drawing')]");
	By Print_Sel_Button = By.xpath("//span[@data-translate='Print selected products']");
	
	
	/*
	 * To click on Advanced search and Search data in filter
	 */
	
	public void filterSearch() {
		try {
			clickElement(AdvancedSearch, "AdvancedSearch");
			logHtmlReport(LogStatus.PASS, "Clicked on AdvancedSearch");
			// clickElement(CountryDD, "CountryDD");
			hardDelay(1000);
			clickElement(By.xpath(getLocalizedLocatorString(CountryDD, "Country ID")), "Country ID");			
			// clickElement(By.xpath(String.format(CountryDD, language)), "objName");
			 hardDelay(2000);
			 logHtmlReport(LogStatus.PASS, "Country ID clicked");
			// clickElement(By.xpath(String.format(countryID, country)), "objName");
			 clickElement(By.xpath(String.format(countryID, getCountrySpecificData("Country Value ID"))), "Country Value");
			 hardDelay(1000);
			 logHtmlReport(LogStatus.PASS, "Value success");
			clickElement(Search, "Search");
			logHtmlReport(LogStatus.PASS, "Clicked on Search");
			elementIsDisplayed(Result, "Result");
			hardDelay(2000);
			logHtmlReport(LogStatus.PASS, "Results Displayed");
			logHtmlReport(LogStatus.PASS, "Search Successful for ");
		}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Search not successful");
		}
	} 
	
	
	/*
	 * To click on Advanced search and Search data using Voltage filter
	 */
	
	public void filterSearch_voltage() {
		try {
			clickElement(AdvancedSearch, "AdvancedSearch");
			logHtmlReport(LogStatus.PASS, "Clicked on AdvancedSearch");
			// clickElement(CountryDD, "CountryDD");
			hardDelay(1000);
			clickElement(Voltage, "Search");
			logHtmlReport(LogStatus.PASS, "Clicked on Voltage");
			clickElement(Voltage_Value, "Search");
			logHtmlReport(LogStatus.PASS, "Clicked on VoltageValue");
			 hardDelay(1000);
			 logHtmlReport(LogStatus.PASS, "Value success");
			clickElement(Search, "Search");
			logHtmlReport(LogStatus.PASS, "Clicked on Search");
			elementIsDisplayed(Result, "Result");
			hardDelay(2000);
			logHtmlReport(LogStatus.PASS, "Results Displayed");
			logHtmlReport(LogStatus.PASS, "Search Successful for ");
		}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Search not successful");
		}
	}
	
	
	/*
	 * To click on Advanced search and Search data using Products filter
	 */
	
	public void filterSearch_products() {
		try {
			clickElement(AdvancedSearch, "AdvancedSearch");
			logHtmlReport(LogStatus.PASS, "Clicked on AdvancedSearch");
			// clickElement(CountryDD, "CountryDD");
			hardDelay(1000);
			clickElement(Voltage, "Search");
			logHtmlReport(LogStatus.PASS, "Clicked on Voltage");
			clickElement(Voltage_Value, "Search");
			logHtmlReport(LogStatus.PASS, "Clicked on VoltageValue");
			 hardDelay(1000);
			 logHtmlReport(LogStatus.PASS, "Value success");
			clickElement(Search, "Search");
			logHtmlReport(LogStatus.PASS, "Clicked on Search");
			elementIsDisplayed(Result, "Result");
			hardDelay(2000);
			logHtmlReport(LogStatus.PASS, "Results Displayed");
			logHtmlReport(LogStatus.PASS, "Search Successful");
		}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Search not successful");
		}
	}
	
	
	/*
	 * To click on First row of the result from Multiple result 
	 */
	public void selectresult() {
		try {
			clickElement(FilterResult, "FilterResult");
			logHtmlReport(LogStatus.PASS, "Selected First Row");
			hardDelay(6000);
			waitForPageLoad();
			elementIsDisplayed(ProductInformation, "ProductInformation");
			logHtmlReport(LogStatus.PASS, "ProductInformation Available");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "ProductInformation not Available");
		}
		}
	
	/*
	 * To click on First row when searched with baretool no
	 */
	public void selectvalue() {
		try {
			clickElement(SingleFilter, "SingleFilter");
			logHtmlReport(LogStatus.PASS, "Result Selected");
			hardDelay(6000);
			elementIsDisplayed(ProductInformation, "ProductInformation");
			logHtmlReport(LogStatus.PASS, "ProductInformation Available");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Search not successful");
		}
		}
	
	/*
	 * To click on explosion diagram and check if it is added to cart
	 */
	public void Explosion_Diagram() {
		try {
			waitForPageLoad();
			hardDelay(2000);
			clickElement(ExplosionID1, "explosionID1");
			hardDelay(1000);
			clickElement(ExplosionID2, "explosionID2");
			hardDelay(1000);
			clickElement(ExplosionID3, "explosionID3");
			hardDelay(1000);
			logHtmlReport(LogStatus.PASS, "Values clicked on Explosion Diagram");
			hardDelay(2000);
			elementIsDisplayed(IncartID1, "incartID1");
			hardDelay(1000);
			elementIsDisplayed(IncartID2, "incartID2");
			hardDelay(1000);
			elementIsDisplayed(IncartID3, "incartID3");
			hardDelay(1000);
			logHtmlReport(LogStatus.PASS, "Values clicked in Explosion diagram are available in UI below");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Values clicked in Explosion diagram are not available in UI below");
		}
		}
	
	/*
	 * To click on contents in explosion diagram page
	 */
	public void Explosion_Page() {
		try {
			waitForPageLoad();
			hardDelay(2000);
			clickElement(Lubrication, "lubrication");
			hardDelay(1000);
			clickElement(Lubrication_Close, "lubrication_Close");
			hardDelay(2000);
			clickElement(ProductInformation, "ProductInformation");	
			hardDelay(1000);
			clickElement(Product_close, "product_close");
			hardDelay(2000);
			clickElement(Print, "print");
			hardDelay(1000);
			clickElement(PDF_Lubrication, "pdf_Lubrication");
			clickElement(PDF_Product, "pdf_Product");
			clickElement(PDF_Exp, "pdf_Exp");
			hardDelay(1000);	
			clickElement(Print_Sel_Button, "Print_Selected_Button");
			hardDelay(2000);
			waitForPageLoad();	
			ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
	    	getDriver().switchTo().window(tabs.get(1));
			String link = getDriver().getCurrentUrl();
			System.out.println("url " + link );
			if(link.contains("/printPdf/"))
			{
			System.out.println("PDf available");
			}
			else
			{
			System.out.println("PDf not available");
			}
		//	getDriver().getTitle().equals("GBM 10 - 0 601 135 064");
		//	getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.PAGE_DOWN);
		//	getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "" + Keys.SHIFT + "" + Keys.TAB);
		//	String actualTitle = getDriver().getTitle();
		//    System.out.println("ActualTitle is " + actualTitle );
			logHtmlReport(LogStatus.PASS, "All elements Present");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Pop Up Window opening issue");
		}
		}
	
	/*
	 * To click on minishopping cart icon and check Shopping cart text (for validation test cases)
	 */
	public void msc_verify() {
		try {
			clickElement(Minishoppingcart, "minishoppingcart");
			logHtmlReport(LogStatus.PASS, "Clicked on Minishopping cart");
			waitForPageLoad();
			hardDelay(4000);
			elementIsDisplayed(ShoppingPage, "shoppingPage");
			logHtmlReport(LogStatus.PASS, "Navgigated to shopping cart page");
		}catch(Exception e) {
		logHtmlReport(LogStatus.FAIL, "Navgigation to shopping cart page failed");
	}
		}
	
	/*
	 * To click on Add to cart for other brands for eorder
	 */
	
	public void addtocart() {
		try {
		for(int i=1; i<=10;i++)
			{
			hardDelay(1000);
			clickElement(By.xpath(String.format(Addtocart,i)), "addtocart");
			hardDelay(1000);
			}		
			hardDelay(6000);
			logHtmlReport(LogStatus.PASS, "Add to cart Successful");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Add to cart not successful");
		}
		}
	
	/*
	 * To click on Add to cart (first 10 rows)
	 */
	
	public void dremeladdtocart() {
		try {
		for(int i=1; i<=10;i++)
			{
			hardDelay(1000);
			clickElement(By.xpath(String.format(DremelAddtocart,i)), "dremeladdtocart");
			hardDelay(1000);
			}		
			hardDelay(6000);
			logHtmlReport(LogStatus.PASS, "Add to cart Successful");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Add to cart not successful");
		}
		}
	
	
	/*
	 * To click on Add to cart for eorder and Print countries(first 5 rows)
	 */
	
	public void addtocartFew() {
		try {
		for(int i=1; i<=5;i++)
			{
			hardDelay(1000);
			clickElement(By.xpath(String.format(DremelAddtocart,i)), "dremeladdtocart");
			//hardDelay(3000);
			}		
			hardDelay(6000);
			logHtmlReport(LogStatus.PASS, "Add to cart Successful");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Add to cart not successful");
		}
		}
	
	
	/*
	 * To click on mini shopping cart icon for eshop having SAP simulation
	 */
	public void minishoppingcarteshop() {
		try {
			clickElement(Minishoppingcart, "minishoppingcart");
			logHtmlReport(LogStatus.PASS, "Clicked on Minishopping cart");
			waitForPageLoad();
			hardDelay(4000);
			waitForPageLoad();
			elementIsDisplayed(ContinueButton, "continueButton");
			logHtmlReport(LogStatus.PASS, "Continue option Available");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Continue option Not Available");
		}
	}	
	
	/*
	 * To click on mini shopping cart icon Print(with Save PDF) and eorder without SAP simulation
	 */
	public void minishoppingcart() {
		try {
			clickElement(Minishoppingcart, "minishoppingcart");
			logHtmlReport(LogStatus.PASS, "Clicked on Minishopping cart");
			waitForPageLoad();
			hardDelay(4000);
			waitForPageLoad();
			elementIsDisplayed(ContinueButton, "continueButton");
			logHtmlReport(LogStatus.PASS, "Continue option Available");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Continue option Not Available");
		}
	}	
	
	/*
	 * To click on mini shopping cart icon for Print (without Save PDF)
	 */
	public void minishoppingcartPrint() {
		try {
			clickElement(Minishoppingcart, "minishoppingcart");
			logHtmlReport(LogStatus.PASS, "Clicked on Minishopping cart");
			waitForPageLoad();
			hardDelay(4000);
			waitForPageLoad();
			elementIsDisplayed(PrintPdf, "PrintPdf");
			logHtmlReport(LogStatus.PASS, "PrintPdf option Available");
			}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "PrintPdf option Not Available");
		}
	}
	
	
	}

