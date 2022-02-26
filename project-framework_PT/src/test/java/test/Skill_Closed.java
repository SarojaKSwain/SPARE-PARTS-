package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import baseTest.JSONDataProvider;
import baseTest.TestNgBase;
import supportLibrary.SuiteFile;

public class Skill_Closed extends TestNgBase{
	
	 @Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void SkillNavigation(Object data) {
		 setCategory("Dremel"); 
		 JSONObject obj = (JSONObject) data;
		  getDriverHelper().getPages().firstPage().launchskill();
	 }

}
