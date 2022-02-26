package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import baseTest.JSONDataProvider;
import baseTest.TestNgBase;

public class Eshop_Validation extends TestNgBase{
	
	@Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void Validation(Object data) {
		 setCategory("Search"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp_HFeshop(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().addtocart();
	      getDriverHelper().getPages().advancedSearch().minishoppingcarteshop();
	      getDriverHelper().getPages().shoppingCartPage().quantity();
	 }
	
	@Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void ValidationSkill(Object data) {
		 setCategory("Search"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp_HFeshop(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().dremeladdtocart();
	      getDriverHelper().getPages().advancedSearch().minishoppingcarteshop();
	      getDriverHelper().getPages().shoppingCartPage().quantity();
	 }
	
	@Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void ValidationDremel(Object data) {
		 setCategory("Search"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp_HFeshop(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().dremeladdtocart();
	      getDriverHelper().getPages().advancedSearch().minishoppingcarteshop();
	      getDriverHelper().getPages().shoppingCartPage().quantity();
	 }

	
}