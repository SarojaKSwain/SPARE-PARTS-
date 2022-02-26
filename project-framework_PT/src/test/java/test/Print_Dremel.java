package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import baseTest.JSONDataProvider;
import baseTest.TestNgBase;

public class Print_Dremel extends TestNgBase{
	
	 @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void PrintDremel(Object data) {
		 setCategory("Print"); 
		 JSONObject obj = (JSONObject) data;
		 String baretool = obj.get("baretool").toString();		 
		  getDriverHelper().getPages().firstPage().launchApp(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().addtocartFew();
	      getDriverHelper().getPages().advancedSearch().minishoppingcartPrint();
	    //  getDriverHelper().getPages().advancedSearch().minishoppingcart();
	    //  getDriverHelper().getPages().shoppingCartPage().continueto();
	    //  getDriverHelper().getPages().addressAndReview().saveAddress();
	   //   getDriverHelper().getPages().addressAndReview().savePdf();
	 } 
	 }