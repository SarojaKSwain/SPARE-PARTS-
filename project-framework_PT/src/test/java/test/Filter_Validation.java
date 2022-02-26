package test;

import org.testng.annotations.Test;

import baseTest.JSONDataProvider;
import baseTest.TestNgBase;

public class Filter_Validation  extends TestNgBase{
	
	@Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void Filter_Voltage(Object data) {
		  getDriverHelper().getPages().firstPage().launchAppSP();
		  getDriverHelper().getPages().advancedSearch().filterSearch_voltage();
		  getDriverHelper().getPages().advancedSearch().selectresult();
	 }
	
	@Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void Filter_Products(Object data) {
		  getDriverHelper().getPages().firstPage().launchAppSP();
		  getDriverHelper().getPages().advancedSearch().filterSearch_products();
		  getDriverHelper().getPages().advancedSearch().selectresult();
	 }
	

}
