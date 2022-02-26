package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import baseTest.JSONDataProvider;
import baseTest.TestNgBase;

public class Print_Eorder_Validation extends TestNgBase{
	
	@Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void Validation(Object data) {
		 setCategory("Search"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp_HF(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().addtocartFew();
	      getDriverHelper().getPages().advancedSearch().minishoppingcart();
	      getDriverHelper().getPages().shoppingCartPage().quantity();
	 }
	
	@Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void ValidationSkill(Object data) {
		 setCategory("Search"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp_HF(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().addtocartFew();
	      getDriverHelper().getPages().advancedSearch().minishoppingcart();
	      getDriverHelper().getPages().shoppingCartPage().quantity();
	 }
	
	@Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void ValidationDremel(Object data) {
		 setCategory("Search"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp_HF(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().addtocartFew();
	      getDriverHelper().getPages().advancedSearch().minishoppingcart();
	      getDriverHelper().getPages().shoppingCartPage().quantity();
	 }

	
}