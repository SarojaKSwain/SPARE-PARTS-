package supportLibrary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import reusableLibrary.CommonFunctionBase;

/**
 * @author NIA3COB
 * 
 *         Class contains reusable functions to interact with browser/mobile
 *         interface.
 *
 */
public class CommonFunction extends CommonFunctionBase {

	public CommonFunction(WebDriver driver) {
		super(driver);
	}

	/**
	 * To enter text in the text box
	 * 
	 * @param obj
	 * @param objName
	 * @param key
	 */
	protected void enterText(By obj, String objName, String key) {
		try {
			waitForElement(obj, objName);
			WebElement element = getWebElement(obj, objName);
			element.click();
			element.clear();
			element.sendKeys(key);
			log(LogType.INFO, key + " is entered in element " + objName);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while entering text -" + key + " in element: " + objName, e.getMessage());
		}
	}

	/**
	 * To click on the element
	 * 
	 * @param obj
	 * @param objName
	 */
	protected void clickElement(By obj, String objName) {
		try {
			waitForElement(obj, objName);
			getWebElement(obj, objName).click();
			log(LogType.INFO, "click on element " + objName);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while clicking element: " + objName + " Exception: " + e.getMessage());
		}
	}

	/**
	 * To click on the element
	 * 
	 * @param obj
	 * @param objName
	 */
	protected void clickElement(WebElement element, String objName) {
		try {
			waitForElement(element, objName);
			element.click();
			log(LogType.INFO, "click on element " + objName);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while clicking element: " + objName + " Exception: " + e.getMessage());
		}
	}

	/**
	 * To verify element is displayed on the screen
	 * 
	 * @param obj
	 * @param objName
	 */
	protected void elementIsDisplayed(By obj, String objName) {
		try {			
			boolean flag = getWebElement(obj, objName).isDisplayed();
			if (!flag) {
				log(LogType.ERROR, objName + " element is not displayed");
			} else {
				log(LogType.INFO, objName + " element is displayed");
			}
		} catch (Exception e) {
			log(LogType.ERROR, objName + " element is not displayed" + " Exception: " + e.getMessage());
		}
	}

	/**
	 * To get the text from the element
	 * 
	 * @param obj
	 * @param objName
	 * @return
	 */
	protected String getText(By obj, String objName) {
		String text = "";

		try {
			text = getWebElement(obj, objName).getText();
			log(LogType.INFO, text + " is present in element " + objName);
		} catch (Exception e) {
			log(LogType.ERROR, objName + " element is not displayed" + " Exception: " + e.getMessage());
		}

		return text;
	}

	protected void hardDelay(int millisec) {
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * To wait for an element untill the specified time
	 * 
	 * @param obj
	 * @param objName
	 */
	protected void waitForElement(By obj, String objName) {
		boolean flag = false;
		int waitTime = 0;

		try {
			do {
				try {
					if (getWebElement(obj, objName).isDisplayed()) {
						flag = true;
						log(LogType.INFO, objName + " Element is displayed");

						break;
					} else {
						hardDelay(5000);
						waitTime = waitTime + 5;
						log(LogType.INFO, "wait for Object " + objName + ". Time:" + waitTime + " seconds");
					}
				} catch (Exception e) {
					hardDelay(5000);
					waitTime = waitTime + 5;
					log(LogType.INFO, "wait for Object " + objName + ". Time:" + waitTime + " seconds");
				}
			} while (waitTime < RunConfigurations.getWaitTime());
		} catch (Exception e) {
			log(LogType.ERROR, objName + " Element is not displayed after " + RunConfigurations.getWaitTime()
					+ " Seconds" + " Exception: " + e.getMessage());
		}

		if (!flag) {
			log(LogType.INFO,
					objName + " Element is not displayed after " + RunConfigurations.getWaitTime() + " Seconds");
		}
	}

	/**
	 * To wait for an element untill the specified time
	 * 
	 * @param obj
	 * @param objName
	 */
	protected void waitForElement(WebElement element, String objName) {
		boolean flag = false;
		int waitTime = 0;

		try {
			do {
				try {
					if (element.isDisplayed()) {
						flag = true;
						log(LogType.INFO, objName + " Element is displayed");

						break;
					} else {
						hardDelay(5000);
						waitTime = waitTime + 5;
						log(LogType.INFO, "wait for Object " + objName + " .Time:" + waitTime + " seconds");
					}
				} catch (Exception e) {
					hardDelay(5000);
					waitTime = waitTime + 5;
					log(LogType.INFO, "wait for Object " + objName + " .Time:" + waitTime + " seconds");
				}
			} while (waitTime < RunConfigurations.getWaitTime());
		} catch (Exception e) {
			log(LogType.ERROR, objName + " Element is not displayed after " + RunConfigurations.getWaitTime()
					+ " Seconds" + " Exception: " + e.getMessage());
		}

		if (!flag) {
			log(LogType.INFO,
					objName + " Element is not displayed after " + RunConfigurations.getWaitTime() + " Seconds");
		}
	}

	/**
	 * To launch the url in mobile app browser
	 * 
	 * @param url
	 */
	protected void navigateToURL(String url) {
		try {
			getDriver().navigate().to(url);
			if (!ReadJson.getRunConfigData("execIn").contains("browser"))
				getDriver().manage().window().maximize();
			log(LogType.INFO, "Navigate to url " + url);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while navigating to URL");
		}
	}

	/**
	 * To scroll and move to the location where the particular text is displayed
	 * 
	 * @param text
	 */
	protected void scrollToTextAndroid(String text) {
		try {
			((AndroidDriver<?>) getDriver()).findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ text + "\").instance(0))");
			log(LogType.INFO, "Scroll to the element with text " + text);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while scrolling to the text:" + text + " " + e.getMessage());

			// Assert.fail("Exception while scrolling to the text:"+text+"
			// "+e.getMessage());
		}
	}

	/**
	 * To select value in the dropdown. This function is for native app
	 * 
	 * @param obj
	 *            - DropDown object
	 * @param objName
	 *            - Name
	 * @param value
	 *            - Value that needs to be selected in dropdown
	 */
	protected void clickAndSelectValue(By obj, String objName, String value) {
		try {
			waitForElement(obj, objName);
			getWebElement(obj, objName).click();
			log(LogType.INFO, value + "value is Selected in " + objName);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while performing click and select value:" + value + "in element" + objName
					+ " Exception: " + e.getMessage());
		}
	}

	/**
	 * To verify element is present on the page and return boolean
	 * 
	 * @param obj
	 * @param elementName
	 * @return
	 */
	protected boolean elementIsPresent(By obj, String elementName) {
		int size = 0;

		try {
			waitForElement(obj, elementName, 2);
			size = getDriver().findElements(obj).size();
			log(LogType.INFO, "Element size " + size);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while locating element" + elementName + " Exception: " + e.getMessage());
		}

		return (size > 0) ? true : false;
	}

	/**
	 * To get attribute value
	 * 
	 * @param obj
	 * @param name
	 * @param attibute
	 * @return
	 */
	protected String getAttribute(By obj, String name, String attribute) {
		String attValue = "";

		try {
			waitForElement(obj, name);
			attValue = getWebElement(obj, name).getAttribute(attribute);
			log(LogType.INFO, attValue + " is present in attribute " + attribute + " of element " + name);
		} catch (Exception e) {
			log(LogType.ERROR,
					"Exception in getAttribute function on element " + name + " Exception: " + e.getMessage());
		}

		return attValue;
	}

	/**
	 * To wait for an element untill the specified time
	 * 
	 * @param obj
	 * @param objName
	 */
	protected void waitForElement(By obj, String objName, int seconds) {
		boolean flag = false;
		int wait = 0;

		try {
			do {
				try {
					if (getWebElement(obj, objName).isDisplayed()) {
						flag = true;

						break;
					} else {
						hardDelay(10000);
						wait = wait + 10;
						log(LogType.INFO, "wait for Object " + objName + " - " + wait + " seconds");
					}
				} catch (Exception e) {
					hardDelay(10000);
					wait = wait + 10;
					log(LogType.INFO, "wait for Object " + objName + " - " + wait + " seconds");
				}
			} while (wait < seconds);
		} catch (Exception e) {
			log(LogType.ERROR, objName + " Element is not displayed after " + RunConfigurations.getWaitTime()
					+ " Seconds" + " Exception: " + e.getMessage());
		}

		if (!flag) {
			log(LogType.INFO,
					objName + " Element is not displayed after " + RunConfigurations.getWaitTime() + " Seconds");
		}
	}

	/**
	 * To validate element is enabled
	 * 
	 * @param obj
	 * @param elementName
	 */
	protected void elementIsEnabled(By obj, String elementName) {
		try {
			if (getWebElement(obj, elementName).isEnabled()) {
				log(LogType.INFO, elementName + " element is enabled");
			} else {
				log(LogType.ERROR, elementName + " element is disabled");
			}
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while verifying object property. Element: " + elementName + " Exception: "
					+ e.getMessage());
		}
	}

	/**
	 * To validate element is disabled
	 * 
	 * @param obj
	 * @param elementName
	 */
	protected void elementIsDisabled(By obj, String elementName) {
		try {
			if (getWebElement(obj, elementName).isEnabled()) {
				log(LogType.ERROR, elementName + " element is enabled");
			} else {
				log(LogType.INFO, elementName + " element is disabled");
			}
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while verifying object property. Element: " + elementName + " Exception: "
					+ e.getMessage());
		}
	}

	/**
	 * To tab from the given element
	 * 
	 * @param obj
	 * @param elementName
	 */
	protected void tabElement(By obj, String elementName) {
		try {
			getWebElement(obj, elementName).sendKeys(Keys.TAB);
			log(LogType.INFO, "Tab from element " + elementName);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while tab on Element: " + elementName + " Exception: " + e.getMessage());
		}
	}

	protected List<WebElement> getListOfElements(By obj, String objName) {
		List<WebElement> element = null;
		try {
			waitForElement(obj, objName);
			element = getDriver().findElements(obj);
			log(LogType.INFO, "click on element " + objName);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while clicking element: " + objName + " Exception: " + e.getMessage());
		}
		return element;
	}

	/**
	 * To get the text from the element
	 * 
	 * @param obj
	 * @param objName
	 * @return
	 */
	protected String getText(WebElement element, String objName) {
		String text = "";

		try {
			text = element.getText();
			log(LogType.INFO, text + " is present in element " + objName);
		} catch (Exception e) {
			log(LogType.ERROR, objName + " element is not displayed" + " Exception: " + e.getMessage());
		}

		return text;
	}

	/**
	 * To wait until the object disappeared from the page
	 *
	 * @throws Exception
	 */
	protected void waitUntillObjectDisappear(By obj, String objectName) {
		int count = 0;
		while (count <= 180) {
			try {
				count = count + 1;
				if ((getDriver().findElements(obj).size()) > 0) {
					hardDelay(1000);
					log(LogType.INFO, objectName + " is present");
				} else {
					log(LogType.INFO, objectName + " is not displayed. Exist from loop");
					break;
				}
			} catch (Exception e) {
				break;
			}
		}
	}

	/**
	 * Scroll to particular element
	 * 
	 * @param element
	 */
	protected void scrollToElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			Map<String, Object> params = new HashMap<>();
			params.put("element", element);
			params.put("toVisible", true);
			js.executeScript("mobile: scroll", params);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while scroll to element. Obj:" + element.toString());
		}
	}

	/**
	 * Scroll to particular element with By parameter
	 * 
	 * @param obj
	 */
	protected void scrollToElement(By obj) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			WebElement element = getWebElement(obj);
			Map<String, Object> params = new HashMap<>();
			params.put("element", element);
			params.put("toVisible", true);
			js.executeScript("mobile: scroll", params);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while scroll to element. Obj:" + obj.toString());
		}
	}

	/**
	 * To swipe left on the element
	 * 
	 * @param obj
	 * @param objName
	 */
	protected void swipeLeftOnElement(By obj, String objName) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			WebElement element = getWebElement(obj, objName);
			Map<String, Object> params = new HashMap<>();
			params.put("direction", "left");
			params.put("element", element);
			js.executeScript("mobile: swipe", params);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while swipe left on the element." + objName);
		}
	}

	/**
	 * To swipe right on the element
	 * 
	 * @param obj
	 * @param objName
	 */
	protected void swipeRightOnElement(By obj, String objName) {
		try {

			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			WebElement element = getWebElement(obj, objName);
			Map<String, Object> params = new HashMap<>();
			params.put("direction", "right");
			params.put("element", element);
			js.executeScript("mobile: swipe", params);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while swipe left on the element." + objName);
		}
	}

	/**
	 * To verify element is displayed on the screen
	 * 
	 * @param obj
	 * @param objName
	 */
	protected void elementIsNotDisplayed(By obj, String objName) {
		try {
			int size = getDriver().findElements(obj).size();

			if (size > 0) {
				log(LogType.ERROR, objName + " element is displayed, Expected- Element should not display");
			} else {
				log(LogType.INFO, objName + " element is not displayed");
			}
		} catch (Exception e) {
			log(LogType.ERROR, objName + " element is displayed" + " Exception: " + e.getMessage());
		}
	}

	protected void waitForPageLoad() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) getDriver();

			// Initially bellow given if condition will check ready state of page.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				System.out.println("Page Is loaded.");
				return;
			}

			// This loop will rotate for 25 times to check If page Is ready after every 1
			// second.
			// You can replace your value with 25 If you wants to Increase or decrease wait
			// time.
			for (int i = 0; i < 25; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				// To check page ready state.
				if (js.executeScript("return document.readyState").toString().equals("complete")) {
					break;
				}
			}
		} catch (Exception e) {

		}
	}

	protected void mouseHoverOnElement(WebElement ele, String elementName) {
		try {
			Actions builder = new Actions(getDriver());
			builder.moveToElement(ele).build().perform();
			log(LogType.INFO, "Hover on element " + elementName);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception on hover element " + elementName + " " + e.getMessage());
		}
	}

	protected void moveToElement(By obj, String elementName) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
					getWebElement(obj, elementName));
			log(LogType.INFO, "Move to element " + elementName);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while move to element " + elementName + " " + e.getMessage());
		}
	}

	protected void clickElementWithJS(By obj, String elementName) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", getWebElement(obj, elementName));
			log(LogType.INFO, "Clicked on element with JS" + elementName);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while clicking on element with JS" + elementName + " " + e.getMessage());
		}
	}

	protected void clickElementWithJS(WebElement element, String elementName) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
			log(LogType.INFO, "Clicked on element with JS" + elementName);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while clicking on element with JS" + elementName + " " + e.getMessage());
		}
	}

	protected void moveToElement(WebElement element, String elementName) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			log(LogType.INFO, "Move to element " + elementName);
		} catch (Exception e) {
			log(LogType.ERROR, "Exception while move to element " + elementName + " " + e.getMessage());
		}
	}

	protected void scrollUp() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollTo(250, 0)");
			log(LogType.INFO, "Scroll up");
		} catch (Exception e) {
			// log(LogType.ERROR, "Exception while move to element "+elementName+"
			// "+e.getMessage());
		}
	}



		public void scrollToElement(By locator, String elementName) {

				String eleText = null;
				try {
					eleText = elementName;
					WebElement element = getDriver().findElement(locator);
					JavascriptExecutor jse = (JavascriptExecutor) getDriver();
					jse.executeScript("arguments[0].scrollIntoView();", element);
					log(LogType.INFO, "Clicked on the WebElement :" + eleText,
							"Successfully clicked on the WebElement " + eleText);
				} catch (Exception e) {
					log(LogType.ERROR, "Clicked on the WebElement :" + eleText,
							"ERROR occured while Clicking the WebElement : " + e.getMessage());
					//Assert.assertFalse(true);
				}
			} 
	
	/**
	 * To launch Select Value from dropdown
	 * 
	 */
	
	public void select_value_from_dropdown(By locator, String enforcementvalue) {
		try {
			Select value = new Select(getDriver().findElement(locator));
			value.selectByVisibleText(enforcementvalue);
			log(LogType.INFO, "Select the required enforcement value",
					String.format("Clicked on element : %s", enforcementvalue));
		} catch (Exception e) {
			System.out.println("Unable to select the enforcement value " + e.getMessage());
			log(LogType.ERROR,
					"Unable to select the enforcement value"
							+ Thread.currentThread().getStackTrace()[1].getMethodName(),
					"Error occurred :" + e.getMessage());
			e.printStackTrace(System.out);
		}
	}
	
	
	
	public String getLocalizedLocatorString(String locator, String text) {
		return String.format(locator, ReadJson.getLocalizedString(SuiteFile.getCountry(), text));
	}
	
	public String getCountrySpecificData(String key) {
		return ReadJson.getCountrySpecficData(SuiteFile.getCountry(), key);
	}

}
