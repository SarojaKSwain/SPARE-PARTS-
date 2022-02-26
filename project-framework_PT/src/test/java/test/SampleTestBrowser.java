package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import baseTest.JSONDataProvider;
import baseTest.TestNgBase;
import supportLibrary.ReadJson;
import supportLibrary.SuiteFile;

public class SampleTestBrowser extends TestNgBase{
	  
	  @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void SampleTestMethod(Object data) {
		  setCategory("USNo");
		  System.out.println(SuiteFile.getBrand());
		  System.out.println(SuiteFile.getCountry());
		  JSONObject obj = (JSONObject) data;
		  System.out.println(obj.get("searchKey").toString());
		  getDriverHelper().getPages().SampleTestPage().launchApp();
		  getDriverHelper().getPages().SampleTestPage().printSampleXpathDiv();
		  getDriverHelper().getPages().SampleTestPage().printSampleXpathSpan();
		  getDriverHelper().getPages().SampleTestPage2().printSampleXpathDiv();
		  getDriverHelper().getPages().SampleTestPage2().printSampleXpathSpan();
		  getDriverHelper().getPages().SampleTestPage3().printSampleXpathDiv();
		  getDriverHelper().getPages().SampleTestPage3().printSampleXpathSpan();
		  logHtmlReport(LogStatus.INFO, "Test Data: "+ReadJson.getCountrySpecficData(SuiteFile.getCountry(), "zipcode"));
	  }
	  
	  @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void SampleTestMethod2(Object data) {
		  setCategory("USNo");
		  System.out.println(SuiteFile.getBrand());
		  System.out.println(SuiteFile.getCountry());
		  JSONObject obj = (JSONObject) data;
		  System.out.println(obj.get("searchKey").toString());
		  getDriverHelper().getPages().SampleTestPage().launchApp();
		  getDriverHelper().getPages().SampleTestPage().printSampleXpathDiv();
		  getDriverHelper().getPages().SampleTestPage().printSampleXpathSpan();
		  getDriverHelper().getPages().SampleTestPage2().printSampleXpathDiv();
		  getDriverHelper().getPages().SampleTestPage2().printSampleXpathSpan();
		  getDriverHelper().getPages().SampleTestPage3().printSampleXpathDiv();
		  getDriverHelper().getPages().SampleTestPage3().printSampleXpathSpan();
		  logHtmlReport(LogStatus.INFO, "Test Data: "+ReadJson.getCountrySpecficData(SuiteFile.getCountry(), "zipcode"));
	  }
	  
	  @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void SampleTestMethod3(Object data) {
		  setCategory("USNo");
		  System.out.println(SuiteFile.getBrand());
		  System.out.println(SuiteFile.getCountry());
		  JSONObject obj = (JSONObject) data;
		  System.out.println(obj.get("searchKey").toString());
		  getDriverHelper().getPages().SampleTestPage().launchApp();
		  getDriverHelper().getPages().SampleTestPage().printSampleXpathDiv();
		  getDriverHelper().getPages().SampleTestPage().printSampleXpathSpan();
		  getDriverHelper().getPages().SampleTestPage2().printSampleXpathDiv();
		  getDriverHelper().getPages().SampleTestPage2().printSampleXpathSpan();
		  getDriverHelper().getPages().SampleTestPage3().printSampleXpathDiv();
		  getDriverHelper().getPages().SampleTestPage3().printSampleXpathSpan();
		  logHtmlReport(LogStatus.INFO, "Test Data: "+ReadJson.getCountrySpecficData(SuiteFile.getCountry(), "zipcode"));
	  }

}
