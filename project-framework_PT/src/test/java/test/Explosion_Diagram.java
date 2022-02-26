package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import baseTest.JSONDataProvider;
import baseTest.TestNgBase;
import supportLibrary.SuiteFile;

public class Explosion_Diagram extends TestNgBase{
	
	 @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void Explosion(Object data) {
		 setCategory("Print"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().Explosion_Diagram();
	      getDriverHelper().getPages().advancedSearch().msc_verify();
	 } 
	 
	 @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void Explosion_Headers(Object data) {
		 setCategory("Print"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().Explosion_Page();
	 } 
	 
	 
	 @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void SkillEshop(Object data) {
		 setCategory("Dremel"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().Explosion_Diagram();
	      getDriverHelper().getPages().advancedSearch().msc_verify();	 
	 }

	 @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void DremelEshop(Object data) {
		 setCategory("Dremel"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().Explosion_Diagram();
	      getDriverHelper().getPages().advancedSearch().msc_verify();
	 }
	 
}