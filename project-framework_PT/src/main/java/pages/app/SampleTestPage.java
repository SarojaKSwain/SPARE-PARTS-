package pages.app;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;

import supportLibrary.CommonFunction;
import supportLibrary.ReadJson;
import supportLibrary.SuiteFile;

public class SampleTestPage extends CommonFunction {

	public SampleTestPage(WebDriver driver) {
		super(driver);
	}

	public static By caseConstruction = By.xpath("//div[contains(@class,'brand-list')]//div[2]//img");
	public static By signInButton = By.xpath("//button[@id='loginBtn']");
	public static By UserName = By.xpath("//input[contains(@id,'Usernam')]");
	public static By PassWord = By.xpath("//input[contains(@id,'Pass')]");
	public static By myFleet = By.xpath("//span[text()='My Fleet']/../i");
	public static By searchMachineField = By.xpath("//input[contains(@placeholder,'Search Machine')]");
	public static By machineName = By.xpath("//a[contains(@class,'machine-name')]//span[1]");
	public static By lockbuttontext = By.xpath("//div[contains(@class,'subnav machine')]/ul//button/span");
	public static By lockbutton = By
			.xpath("//i[contains(@class,'material-icons')]/following-sibling::span[contains(text(),'Machine')]");
	public static By alertsButton = By
			.xpath("//div[contains(@class,'subnav machine')]//span[contains(text(),'Alerts')]");

	public void loginIntoITRAMS(String Url, String userName, String passWord)

	{
		try {
			getDriver().manage().window().maximize();
			getDriver().get(Url);
			waitForPageLoad();
			waitForElement(caseConstruction, "caseConstruction", 15);
			clickElement(caseConstruction, "caseConstruction");
			waitForPageLoad();
			waitForElement(signInButton, "SignButton", 15);
			waitForElement(UserName, "UserName");
			enterText(UserName, "UserName", userName);
			enterText(PassWord, "Password", passWord);
			clickElement(signInButton, "Login Button");
			waitForPageLoad();
			// waitForElement(caseEagleEye, "caseEagleEye", 15);
			logHtmlReport(LogStatus.PASS, "Login successfully with username: " + userName);

		}

		catch (Exception e) {
			logHtmlReport(LogStatus.FAIL, "Exception while login", e);

		}

	}

	public void navigateToMyFleetPageAndSearch(String MachineName) {
		try {
			waitForElement(myFleet, "caseEagleEye", 15);
			clickElement(myFleet, "caseEagleEye");
			hardDelay(2000);
			waitForElement(searchMachineField, "SearchField", 15);
			enterText(searchMachineField, "SearchField", MachineName);
			getDriver().findElement(searchMachineField).sendKeys(Keys.ENTER);
			hardDelay(2000);
			waitForElement(machineName, "machineName", 15);
			logHtmlReport(LogStatus.PASS,
					"Navigated to my fleet page and machine is searched successfully: " + MachineName);
		}

		catch (Exception e) {
			logHtmlReport(LogStatus.FAIL, "Exception while navigating to fleet page and searching machine", e);

		}

	}

	public void lockMachine() {
		try {
			String lockButtonText = getText(lockbuttontext, "lockButton");
			if (lockButtonText.contains("Unlock")) {

				waitForElement(lockbutton, "LockButton", 05);
				clickElement(lockbutton, "LockButton");
				hardDelay(5000);
				waitForElement(By.xpath("//button[contains(@class,'btn btn-success')]"), "YesButton");
				clickElement(By.xpath("//button[contains(@class,'btn btn-success')]"), "YesButton");
			}
			hardDelay(5000);
			waitForElement(lockbutton, "LockButton", 05);
			clickElement(lockbutton, "LockButton");
			Thread.sleep(5000);
			waitForElement(By.xpath("//button[contains(@class,'btn btn-success')]"), "YesButton");
			clickElement(By.xpath("//button[contains(@class,'btn btn-success')]"), "YesButton");
			logHtmlReport(LogStatus.PASS, "Able to lock the machine successfully: " + "");
		} catch (Exception e) {
			logHtmlReport(LogStatus.FAIL, "Exception while locking the machine", e);
		}
	}

	public void verifyTheAlert() {
		try {
			hardDelay(5000);
			waitForElement(alertsButton, "alertsButton", 05);
			clickElement(alertsButton, "alertsButton");
			hardDelay(5000);

		} catch (Exception e) {

		}

	}

	public void verifyAddition(String val) {
		try {
			logHtmlReport(LogStatus.PASS, "Application launched succesfully");
			clickElement(By.id("digit_2"), "Two");
			logHtmlReport(LogStatus.PASS, "Click on Button 2");
			clickElement(By.id("op_add"), "Add");
			logHtmlReport(LogStatus.PASS, "Click on Button +");
			clickElement(By.id("digit_2"), "Two");
			logHtmlReport(LogStatus.PASS, "Click on Button 2");
			clickElement(By.id("eq"), "Equal");
			logHtmlReport(LogStatus.PASS, "Click on Button =");
			waitForElement(By.id("result_final"), "result", 60);
			String s = getText(By.id("result_final"), "result");
			if (s.contentEquals(val)) {
				logHtmlReport(LogStatus.PASS, "Test Case Passed");
			} else {
				logHtmlReport(LogStatus.FAIL, "Test Case Failed");
			}
		} catch (Exception e) {
			logHtmlReport(LogStatus.FAIL, e.toString());

		}
	}

	public void verifySubtraction(String val) {
		try {
			logHtmlReport(LogStatus.PASS, "Application launched succesfully");
			clickElement(By.id("digit_2"), "Two");
			logHtmlReport(LogStatus.PASS, "Click on Button 2");
			clickElement(By.id("op_sub"), "Sub");
			logHtmlReport(LogStatus.PASS, "Click on Button -");
			clickElement(By.id("digit_2"), "Two");
			logHtmlReport(LogStatus.PASS, "Click on Button 2");
			clickElement(By.id("eq"), "Equal");
			logHtmlReport(LogStatus.PASS, "Click on Button =");
			waitForElement(By.id("result_final"), "result", 60);
			String s = getText(By.id("result_final"), "result");
			if (s.contentEquals(val)) {
				logHtmlReport(LogStatus.PASS, "Test Case Passed");
			} else {
				logHtmlReport(LogStatus.FAIL, "Test Case Failed");
			}
		} catch (Exception e) {
			logHtmlReport(LogStatus.FAIL, e.toString());

		}
	}

	public void verifyMultiplication(String val) {
		try {
			logHtmlReport(LogStatus.PASS, "Application launched succesfully");
			clickElement(By.id("digit_2"), "Two");
			logHtmlReport(LogStatus.PASS, "Click on Button 2");
			clickElement(By.id("op_mul"), "mul");
			logHtmlReport(LogStatus.PASS, "Click on Button *");
			clickElement(By.id("digit_2"), "Two");
			logHtmlReport(LogStatus.PASS, "Click on Button 2");
			clickElement(By.id("eq"), "Equal");
			logHtmlReport(LogStatus.PASS, "Click on Button =");
			waitForElement(By.id("result_final"), "result", 60);
			String s = getText(By.id("result_final"), "result");
			if (s.contentEquals(val)) {
				logHtmlReport(LogStatus.PASS, "Test Case Passed");
			} else {
				logHtmlReport(LogStatus.FAIL, "Test Case Failed");
			}
		} catch (Exception e) {
			logHtmlReport(LogStatus.FAIL, e.toString());

		}
	}

	public void verifyDivision(String val) {
		try {
			logHtmlReport(LogStatus.PASS, "Application launched succesfully");
			clickElement(By.id("digit_2"), "Two");
			logHtmlReport(LogStatus.PASS, "Click on Button 2");
			clickElement(By.id("op_div"), "Div");
			logHtmlReport(LogStatus.PASS, "Click on Button /");
			clickElement(By.id("digit_2"), "Two");
			logHtmlReport(LogStatus.PASS, "Click on Button 2");
			clickElement(By.id("eq"), "Equal");
			logHtmlReport(LogStatus.PASS, "Click on Button =");
			waitForElement(By.id("result_final"), "result", 60);
			String s = getText(By.id("result_final"), "result");
			if (s.contentEquals(val)) {
				logHtmlReport(LogStatus.PASS, "Test Case Passed");
			} else {
				logHtmlReport(LogStatus.FAIL, "Test Case Failed");
			}
		} catch (Exception e) {
			logHtmlReport(LogStatus.FAIL, e.toString());

		}
	}

	public void VerifyGoogle() {
		try {
			getDriver().manage().window().maximize();
			getDriver().navigate().to("https://www.google.com");
			logHtmlReport(LogStatus.PASS, "Google Home Page opened");
			clickElement(By.xpath("(//input[contains(@aria-label,'Feeling Lucky')])[2]"), "Lucky Button");
			logHtmlReport(LogStatus.PASS, "click on button lucky");
			waitForPageLoad();
			logHtmlReport(LogStatus.PASS, "page loaded");
		} catch (Exception e) {
			logHtmlReport(LogStatus.FAIL, e.toString());

		}
	}

	public void VerifyYoutube() {
		try {
			getDriver().manage().window().maximize();
			getDriver().navigate().to("https://www.youtube.com");
			logHtmlReport(LogStatus.PASS, "youtube Page opened");
			clickElement(By.xpath("(//button//yt-icon[@id='guide-icon'])[1]"), "Trending Button");
			logHtmlReport(LogStatus.PASS, "click on Guide Button");
			hardDelay(3000);
			logHtmlReport(LogStatus.PASS, "Menu loaded");
		} catch (Exception e) {
			logHtmlReport(LogStatus.FAIL, e.toString());

		}
	}
	
	public void launchApp() {
		String url = ReadJson.getEnvBaseData("url")+ReadJson.getCountrySpecficData(SuiteFile.getCountry(),"path")+ReadJson.getBrandURL(SuiteFile.getBrand());
		logHtmlReport(LogStatus.INFO, "URL "+url);
	}
	
	String xpa1 = "//div[text()=%s]";
	public void printSampleXpathDiv() {
		logHtmlReport(LogStatus.INFO,"****SampleTestPage****"+getLocalizedLocatorString(xpa1,"COUNTRY"));
	}
	
	String xpa2 = "//span[text()=%s]";
	public void printSampleXpathSpan() {
		logHtmlReport(LogStatus.INFO,"****SampleTestPage****"+getLocalizedLocatorString(xpa2, "COUNTRY"));
	}
	
	public void test() {
		//commonfield
		if(SuiteFile.getCountry().equals("DE")) {
			//country fields - DE
			test_de();
		}else if(SuiteFile.getCountry().equals("LV")) {
			//country fields - LV
			test_lv();
		}else {
			log(LogType.ERROR, "Country is not matching");
		}
	}
	
	public void test_de() {
		
	}
	
public void test_lv() {
		
	}

}
