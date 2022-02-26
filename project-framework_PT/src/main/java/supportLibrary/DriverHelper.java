package supportLibrary;

import org.openqa.selenium.WebDriver;
import driverLibrary.DriverFactory;
import pages.InitPages;
import reportingLibrary.Logger;

/**
 * @author NIA3COB
 * 
 * This class is to initiate and assign driver object to the framework
 *
 */
public class DriverHelper extends Logger{
	
	private WebDriver driver;
	private String testMethodName;
	
	/*PcloudyConnector connector;

	public PcloudyConnector getConnector() {
		return connector;
	}

	public void setConnector(PcloudyConnector connector) {
		this.connector = connector;
	}*/

	public String getTestMethodName() {
		return testMethodName;
	}

	private void setTestMethodName(String testMethodName) {
		this.testMethodName = testMethodName;
	}

	public WebDriver getDriver(){
		return driver;
	}

	private void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public InitPages getPages() {
		return pages;
	}

	private void setPages(InitPages pages) {
		this.pages = pages;
	}

	private InitPages pages;
	
	public DriverHelper(String execMode,String execIn,String deviceName,String URL, int port, String methodName,String desktopAppPath ){
		log(LogType.INFO, "**** Initializing drivers ****"+execIn+" "+deviceName);
		DriverFactory drive = new DriverFactory();
		this.setDriver(drive.newDriver(null,execMode,execIn,URL,desktopAppPath));
		this.setTestMethodName(methodName);
		this.setPages(new InitPages(this.getDriver()));
		log(LogType.INFO, "**** driver instance in Initializing drivers ****");
	}

}
