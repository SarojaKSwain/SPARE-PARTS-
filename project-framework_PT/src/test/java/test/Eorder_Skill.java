package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import baseTest.JSONDataProvider;
import baseTest.TestNgBase;

public class Eorder_Skill extends TestNgBase{
	
	@Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void EorderSkillflow(Object data) {
		 setCategory("Search"); 
		 JSONObject obj = (JSONObject) data;
	//	 String path = obj.get("path").toString();
	//	 String language = obj.get("language").toString();
	//	 String country = obj.get("country").toString();
		 String baretool = obj.get("baretool").toString();
		 String company = obj.get("company").toString();
		 String firstName = obj.get("firstName").toString();
		  String surName = obj.get("surName").toString();
		  String street = obj.get("street").toString();
		  String houseNo = obj.get("houseNo").toString();
		  String city = obj.get("city").toString();
		  String email = obj.get("email").toString();
		  String confirmEmail = obj.get("confirmEmail").toString();
		  String phoneNo = obj.get("phoneNo").toString();  
		  getDriverHelper().getPages().firstPage().launchApp(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().addtocartFew();
	      getDriverHelper().getPages().advancedSearch().minishoppingcart();
	      getDriverHelper().getPages().shoppingCartPage().continueto();
	      getDriverHelper().getPages().addressAndReview().saveAddress();
	      getDriverHelper().getPages().addressAndReview().billingAddress(company,firstName,surName,street,houseNo,city,email,confirmEmail,phoneNo);
	      getDriverHelper().getPages().addressAndReview().saveAddress();
	      getDriverHelper().getPages().addressAndReview().tcr_eorder();
		 
	 }

}
