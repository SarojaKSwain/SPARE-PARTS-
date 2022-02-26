package baseTest;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;

import reportingLibrary.ExtentTestManager;
import supportLibrary.ReadJson;

public class JSONDataProvider {
	
	@DataProvider(name = "testData")
	  public static Object[] fetchData(Method method){
		  String testName = method.getName();
		  JSONArray testData = (JSONArray) ReadJson.testCaseTestDataJson.get(testName);
		  List<JSONObject> datalist = new ArrayList<JSONObject>();
		  for(int i=0;i<testData.size();i++) {
			  datalist.add((JSONObject) testData.get(i));
		  }
		  
		  Object[] result =new Object[datalist.size()];
		  
		  for(int i=0;i<datalist.size();i++) {
			  result[i] = datalist.get(i);
		  }
		  
		  ExtentTestManager.setChildTestFlag(testName,result.length);
		  ExtentTestManager.setIteration(testName, 1);
		  return result;
	  }
}
