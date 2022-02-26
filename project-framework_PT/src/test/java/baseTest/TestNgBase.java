package baseTest;

import java.lang.reflect.Method;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import reportingLibrary.CreateExtentReport;
import reportingLibrary.ExtentManager;
import reportingLibrary.ExtentTestManager;
import reportingLibrary.Logger;
import supportLibrary.DriverHelper;
import supportLibrary.ReadJson;
import supportLibrary.RunConfigurations;
import supportLibrary.SuiteFile;
import webserviceLibrary.RestHelper;

public class TestNgBase extends Logger {

	private DriverHelper driverHelper;
	private boolean updateJira;

	public boolean isUpdateJira() {
		return updateJira;
	}

	public void setUpdateJira(boolean updateJira) {
		this.updateJira = updateJira;
	}

	private static ThreadLocal<DriverHelper> tlDriver = new ThreadLocal<>();

	@Parameters({ "Brand", "Country","PexecMode", "PexecIn" })
	@BeforeMethod
	public void beforeMethod(Method method, @Optional String Brand,@Optional String Country, @Optional String PexecMode,
			@Optional String PexecIn) {
		Logger.setTestMethod(method.getName());
		log(LogType.INFO, "Starting before test method ::" + method.getName());
		String execIn;
		String exeMode;

		PexecMode = PexecMode == null ? "" : PexecMode;
		PexecIn = PexecIn == null ? "" : PexecIn;

		if (PexecMode.equals("")) {
			exeMode = RunConfigurations.getExecutionMode();
		} else {
			exeMode = PexecMode;
		}
		if (PexecIn.equals("")) {
			execIn = RunConfigurations.getExecIn();
		} else {
			execIn = PexecIn;
		}
		String methodName = method.getName();
		int currentIteration = ExtentTestManager.getIteration(methodName);
		if (currentIteration == 1) {
			setTestCaseNameInReport(methodName, execIn,Brand,Country);
		}
		ExtentTestManager.startChildTest(method.getName() + "_Iteration[" + currentIteration + "]");

		if (!exeMode.equalsIgnoreCase("api")) {
			createDriverBasedOnExecMode(methodName, exeMode, execIn, "");
			SuiteFile.country.set(Country);
			SuiteFile.brand.set(Brand);
		}
		log(LogType.INFO, "Starting before test method ::" + method.getName());
		// To update results in jira
	}

	private void setTestCaseNameInReport(String methodName, String execIn, String Brand,String Country) {
			ExtentTestManager.startTest(methodName + "_" + execIn + "_" + Brand+"_"+Country);
			ExtentTestManager.setCategory(Brand);
			ExtentTestManager.setCategory(Country);
	}

	private void createDriverBasedOnExecMode(String methodName, String exeMode, String execIn, String sysDeviceName) {
		int server1_WDA = 0;
		String server1 = ReadJson.getServerData(exeMode, "device1_server");
		driverHelper = new DriverHelper(exeMode, execIn, sysDeviceName, server1, server1_WDA, methodName, "");
		tlDriver.set(driverHelper);
	}

	@Parameters({ "PexecIn" })
	@AfterMethod
	public void afterMethod(ITestResult result, @Optional String PexecIn) {
		String execIn = null;
		PexecIn = PexecIn == null ? "" : PexecIn;
		try {
			if (PexecIn.equals("")) {
				execIn = RunConfigurations.getExecIn();
			} else {
				execIn = PexecIn;
			}
			log(LogType.INFO, "In after test method ::" + result.getMethod().getMethodName());
			String testName = result.getMethod().getMethodName();
			endReportForTestMethod(testName,result);
		} catch (Exception e) {
			log(LogType.ERROR, "Error in After method",e.getMessage());
		} finally {
			if (!execIn.equalsIgnoreCase("api")) {
				getDriverHelper().getDriver().quit();
			}
			log(LogType.INFO, "Terminate driver session in after test method");
		}
	}
	
	private void endReportForTestMethod(String testName, ITestResult result) {
		int currentIteration = ExtentTestManager.getIteration(testName);
		int totalIteration = ExtentTestManager.getChildTestFlag(testName);
		ExtentTestManager.endChildTest();
		if (currentIteration == totalIteration) {
			ExtentTestManager.endTest();
			ExtentManager.endReport();
			log(LogType.INFO, "No child test to execute, flushing report");
		} else {
			currentIteration = currentIteration + 1;
			ExtentTestManager.setIteration(testName, currentIteration);
			log(LogType.INFO, result.getMethod().getMethodName() + "test method has child test to execute");
		}
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeSuite
	public void beforeSuite() {
		CreateExtentReport.createReport();
		CreateExtentReport.deleteLatestResultFolder();
		log(LogType.INFO, "Initializing JSON file and adding to framework");
		ReadJson.readJsonFiles();
		RestHelper.setRunwithproxy(Boolean.valueOf(ReadJson.getRunConfigData("setProxyForAPI")));
		RestHelper.setProxyDetailsForAPICall(ReadJson.getproxyData("proxyConfig", "name"),
				ReadJson.getproxyData("proxyConfig", "pwd"), ReadJson.getproxyData("proxyConfig", "proxy"),
				Integer.parseInt(ReadJson.getproxyData("proxyConfig", "port")));
		String updateResult = ReadJson.getRunConfigData("updateTestExecutionInJira");
		if (updateResult.equalsIgnoreCase("yes")) {
			setUpdateJira(true);
		} else {
			setUpdateJira(false);
		}
		log(LogType.INFO, "Setting up run configuration");
		RunConfigurations.setRunConfig();
	}
	
	@AfterSuite
	public void afterSuite() {
		CreateExtentReport.copyResultToLatestFolder();
	}

	/*
	 * public synchronized DriverHelper getDriverHelper() { return
	 * driverMap.get((int) (long) (Thread.currentThread().getId())); }
	 */

	/*
	 * public static synchronized DriverHelper getDriverHelper2() { return
	 * tlDriver2.get(); }
	 */

	public static synchronized DriverHelper getDriverHelper() {
		return tlDriver.get();
	}
	
	
}