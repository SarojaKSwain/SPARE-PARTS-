package pages;

import org.openqa.selenium.WebDriver;
import pages.api.SampleAPI;
import pages.app.SampleTestPage;
import pages.app.SampleTestPage2;
import pages.app.SampleTestPage3;
import pages.web.AddressAndReview;
import pages.web.AdvancedSearch;
import pages.web.FirstPage;
import pages.web.Payment;
import pages.web.ShoppingCartPage;



/**
 * @author NIA3COB
 *
 * This class to initialize all page object
 */
public class InitPages {
    public WebDriver driver;
    SampleAPI sampleAPI;
	SampleTestPage sampleTestPage;
	SampleTestPage2 sampleTestPage2;
	SampleTestPage3 sampleTestPage3;
	FirstPage firstPage;
	AdvancedSearch advancedSearch;
	ShoppingCartPage shoppingCartPage;
	AddressAndReview addressAndReview;
	Payment payment;

    public InitPages(WebDriver driver) {
        this.driver = driver;
    }

    public InitPages() {
    }

    public SampleAPI sampleAPI() {
        sampleAPI = (sampleAPI == null) ? new SampleAPI() : sampleAPI;
        return sampleAPI;
    }

	
	public SampleTestPage SampleTestPage() {
        sampleTestPage = (sampleTestPage == null) ? new SampleTestPage(driver)
                                                  : sampleTestPage;
        return sampleTestPage;
    }
	
	public SampleTestPage2 SampleTestPage2() {
        sampleTestPage2 = (sampleTestPage2 == null) ? new SampleTestPage2(driver)
                                                  : sampleTestPage2;
        return sampleTestPage2;
    }
	
	public SampleTestPage3 SampleTestPage3() {
        sampleTestPage3 = (sampleTestPage3 == null) ? new SampleTestPage3(driver)
                                                  : sampleTestPage3;
        return sampleTestPage3;
    }
	
	public FirstPage firstPage() {
		firstPage = (firstPage == null) ? new FirstPage(driver)
                                                  : firstPage;
        return firstPage;
    }
	
	public AdvancedSearch advancedSearch() {
		advancedSearch = (advancedSearch == null) ? new AdvancedSearch(driver)
                                                  : advancedSearch;
        return advancedSearch;
    }
	
	public ShoppingCartPage shoppingCartPage() {
		shoppingCartPage = (shoppingCartPage == null) ? new ShoppingCartPage(driver)
                                                  : shoppingCartPage;
        return shoppingCartPage;
    }
	

	public AddressAndReview addressAndReview() {
		addressAndReview = (addressAndReview == null) ? new AddressAndReview(driver)
                                                  : addressAndReview;
        return addressAndReview;
    }
	
	public Payment payment() {
		payment = (payment == null) ? new Payment(driver)
                                                  : payment;
        return payment;
    }
	
}
