package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import baseTest.JSONDataProvider;
import baseTest.TestNgBase;

public class Print_RU_US extends TestNgBase{
	
	 @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void Printflow(Object data) {
		 setCategory("Print"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().addtocartFew();
	      getDriverHelper().getPages().advancedSearch().minishoppingcartPrint();
	 } 
	 
	 @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void PrintSkill(Object data) {
		 setCategory("Print"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().addtocartFew();
	      getDriverHelper().getPages().advancedSearch().minishoppingcartPrint();
	 }  
	 
	 @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void PrintDremel(Object data) {
		 setCategory("Print"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().addtocartFew();
	      getDriverHelper().getPages().advancedSearch().minishoppingcartPrint();
	 }  
	 
	 }