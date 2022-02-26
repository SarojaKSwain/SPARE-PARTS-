package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import baseTest.JSONDataProvider;
import baseTest.TestNgBase;
import supportLibrary.SuiteFile;

public class Eshop_TAX_Mandatory  extends TestNgBase{
	
	@Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void Eshopflow(Object data) {
		 setCategory("Search"); 
		 JSONObject obj = (JSONObject) data;
	//	 String path = obj.get("path").toString();
	//	 String language = obj.get("language").toString();
	//	 String country = obj.get("country").toString();
		 String company = obj.get("company").toString();
		 String firstName = obj.get("firstName").toString();
		  String surName = obj.get("surName").toString();
		  String street = obj.get("street").toString();
		  String houseNo = obj.get("houseNo").toString();
	//	  String postCode = obj.get("postCode").toString();
		  String city = obj.get("city").toString();
		  String email = obj.get("email").toString();
		  String confirmEmail = obj.get("confirmEmail").toString();
		  String phoneNo = obj.get("phoneNo").toString();  
		  String cardNo = obj.get("cardNo").toString();
		  String cardHolderName = obj.get("cardHolderName").toString();
		  String Month = obj.get("Month").toString();
		  String Year = obj.get("Year").toString();
		  String cardCvv = obj.get("cardCvv").toString();
		  getDriverHelper().getPages().firstPage().launchAppSP();
		 // getDriverHelper().getPages().advancedSearch().filterSearch(country);
		  getDriverHelper().getPages().advancedSearch().filterSearch();
		  getDriverHelper().getPages().advancedSearch().selectresult();
	      getDriverHelper().getPages().advancedSearch().addtocart();
	      getDriverHelper().getPages().advancedSearch().minishoppingcarteshop();
	     // getDriverHelper().getPages().shoppingCartPage().quantity();
	      getDriverHelper().getPages().shoppingCartPage().continueto();
	      getDriverHelper().getPages().addressAndReview().billingAddressVAT(company,firstName,surName,street,houseNo,city,email,confirmEmail,phoneNo);
	      getDriverHelper().getPages().addressAndReview().saveAddress();
	      getDriverHelper().getPages().addressAndReview().selectPayment();
	      getDriverHelper().getPages().addressAndReview().tcr();
	      getDriverHelper().getPages().payment().paymentDetails(cardNo, cardHolderName, Month, Year, cardCvv);		 
	 }

	 @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void DremelEshop(Object data) {
		 setCategory("Dremel"); 
		  System.out.println(SuiteFile.getBrand());
		  System.out.println(SuiteFile.getCountry());
		  JSONObject obj = (JSONObject) data;
//		 String url = obj.get("url").toString();
		 String baretool = obj.get("baretool").toString();
		 String company = obj.get("company").toString();
		  String firstName = obj.get("firstName").toString();
		  String surName = obj.get("surName").toString();
		  String street = obj.get("street").toString();
		  String houseNo = obj.get("houseNo").toString();
	//	  String postCode = obj.get("postCode").toString();
		  String city = obj.get("city").toString();
		  String email = obj.get("email").toString();
		  String confirmEmail = obj.get("confirmEmail").toString();
		  String phoneNo = obj.get("phoneNo").toString();  
		  String cardNo = obj.get("cardNo").toString();
		  String cardHolderName = obj.get("cardHolderName").toString();
		  String Month = obj.get("Month").toString();
		  String Year = obj.get("Year").toString();
		  String cardCvv = obj.get("cardCvv").toString();
		  getDriverHelper().getPages().firstPage().launchApp(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().dremeladdtocart();
	      getDriverHelper().getPages().advancedSearch().minishoppingcarteshop();
	      getDriverHelper().getPages().shoppingCartPage().continueto();
	      getDriverHelper().getPages().addressAndReview().billingAddressVAT(company,firstName,surName,street,houseNo,city,email,confirmEmail,phoneNo);
	      getDriverHelper().getPages().addressAndReview().saveAddress();
	      getDriverHelper().getPages().addressAndReview().selectPayment();
	      getDriverHelper().getPages().addressAndReview().tcr();
	      getDriverHelper().getPages().payment().paymentDetails(cardNo, cardHolderName, Month, Year, cardCvv);		 
	 }
	 
	 @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void SkillEshop(Object data) {
		 setCategory("Dremel"); 
		  System.out.println(SuiteFile.getBrand());
		  System.out.println(SuiteFile.getCountry());
		  JSONObject obj = (JSONObject) data;
//		 String url = obj.get("url").toString();
		 String baretool = obj.get("baretool").toString();
		 String company = obj.get("company").toString();
		  String firstName = obj.get("firstName").toString();
		  String surName = obj.get("surName").toString();
		  String street = obj.get("street").toString();
		  String houseNo = obj.get("houseNo").toString();
	//	  String postCode = obj.get("postCode").toString();
		  String city = obj.get("city").toString();
		  String email = obj.get("email").toString();
		  String confirmEmail = obj.get("confirmEmail").toString();
		  String phoneNo = obj.get("phoneNo").toString();  
		  String cardNo = obj.get("cardNo").toString();
		  String cardHolderName = obj.get("cardHolderName").toString();
		  String Month = obj.get("Month").toString();
		  String Year = obj.get("Year").toString();
		  String cardCvv = obj.get("cardCvv").toString();
		  getDriverHelper().getPages().firstPage().launchApp(baretool);
		  getDriverHelper().getPages().advancedSearch().selectvalue();
	      getDriverHelper().getPages().advancedSearch().dremeladdtocart();
	      getDriverHelper().getPages().advancedSearch().minishoppingcarteshop();
	      getDriverHelper().getPages().shoppingCartPage().continueto();
	      getDriverHelper().getPages().addressAndReview().billingAddressVAT(company,firstName,surName,street,houseNo,city,email,confirmEmail,phoneNo);
	      getDriverHelper().getPages().addressAndReview().saveAddress();
	      getDriverHelper().getPages().addressAndReview().selectPayment();
	      getDriverHelper().getPages().addressAndReview().tcr();
	      getDriverHelper().getPages().payment().paymentDetails(cardNo, cardHolderName, Month, Year, cardCvv);		 
	 }

}
