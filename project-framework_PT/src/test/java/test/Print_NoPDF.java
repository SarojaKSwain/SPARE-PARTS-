package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import baseTest.JSONDataProvider;
import baseTest.TestNgBase;

public class Print_NoPDF extends TestNgBase{
	
	 @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void Printflows(Object data) {
		 setCategory("Print"); 
		 JSONObject obj = (JSONObject) data;
	//	 String path = obj.get("path").toString();
	//	 String language = obj.get("language").toString();
	//	 String country = obj.get("country").toString();		 
		 getDriverHelper().getPages().firstPage().launchAppSP();
		  getDriverHelper().getPages().advancedSearch().filterSearch();
		  getDriverHelper().getPages().advancedSearch().selectresult();
	      getDriverHelper().getPages().advancedSearch().addtocartFew();
	      getDriverHelper().getPages().advancedSearch().minishoppingcartPrint();
	 } 
	 }