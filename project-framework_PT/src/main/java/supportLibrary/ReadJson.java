package supportLibrary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 * @author NIA3COB
 * 
 * To read JSON files and assign it to framework variables
 *
 */
public class ReadJson{
	
	public static JSONObject proxyJson;
	public static JSONObject serverJson;
	public static JSONObject runConfigJson;
	public static JSONObject testMgmtJson;
	public static JSONObject testdataEnvJson;
	public static JSONObject testCaseTestDataJson;
	public static JSONObject testCaseMappingJson;
	public static JSONObject localizationJson;
	public static JSONObject countryJson;
	public static JSONObject brandJson;
	
	
	public static void readJsonFiles() {
		try {
				String dir =System.getProperty("user.dir");
				proxyJson = (JSONObject)new JSONParser().parse(new FileReader(dir+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"config"+File.separator+"proxy.json"));
				serverJson = (JSONObject)new JSONParser().parse(new FileReader(dir+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"config"+File.separator+"server.json"));
				runConfigJson = (JSONObject)new JSONParser().parse(new FileReader(dir+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"config"+File.separator+"runconfig.json"));
				testMgmtJson = (JSONObject)new JSONParser().parse(new FileReader(dir+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"config"+File.separator+"testMgmt.json"));
				testdataEnvJson = (JSONObject)new JSONParser().parse(new FileReader(dir+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"testdata_env.json"));
				testCaseTestDataJson = (JSONObject)new JSONParser().parse(new FileReader(dir+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"testcase_testdata.json"));
				testCaseMappingJson = (JSONObject)new JSONParser().parse(new FileReader(dir+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"testcase_mapping.json"));
			localizationJson = (JSONObject)new JSONParser().parse(new FileReader(dir+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"localization.json"));
		//	localizationJson = (JSONObject)new JSONParser().parse(new BufferedReader(new InputStreamReader(new FileInputStream(dir+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"localization.json"),"UTF8"))); 
				countryJson = (JSONObject)new JSONParser().parse(new FileReader(dir+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"testdata_country.json"));
				brandJson = (JSONObject)new JSONParser().parse(new FileReader(dir+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"brand.json"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static String getproxyData(String root,String key) {
		JSONObject obj = (JSONObject) proxyJson.get(root);
		return obj.get(key).toString();
	}
	
	public static String getRunConfigData(String key) {
		JSONObject obj = (JSONObject) runConfigJson.get("config");
		return obj.get(key).toString();
	}
	public static String getRunConfigData(String root,String key) {
		JSONObject obj = (JSONObject) runConfigJson.get("config");
		JSONObject child = (JSONObject) obj.get(root);
		return child.get(key).toString();
	}
	
	public static String getServerData(String root,String key) {
		JSONObject obj = (JSONObject) serverJson.get(root);
		return obj.get(key).toString();
	}
	
	public static String getTestMgmtData(String root,String key) {
		JSONObject obj = (JSONObject) testMgmtJson.get(root);
		return obj.get(key).toString();
	}
	
	public static String getEnvBaseData(String key) {
		JSONObject obj = (JSONObject) testdataEnvJson.get("testdata_"+RunConfigurations.getEnv());
		return obj.get(key).toString();
	}
	
	public static String getEnvBaseData(String root,String key) {
		JSONObject obj = (JSONObject) testdataEnvJson.get("testdata_"+RunConfigurations.getEnv());
		JSONObject child = (JSONObject) obj.get(root);
		return child.get(key).toString();
	}
	
	public static String getTestCaseID(String key) {
		JSONObject obj = (JSONObject) testCaseMappingJson.get("mapping");
		return obj.get(key).toString();
	}
	
	public static String getAPIBaseURL() {
		return ReadJson.getEnvBaseData("apiHost");
	}
	
	public static String getCountrySpecficData(String root,String key) {
		JSONObject obj = (JSONObject) countryJson.get(root);
		return obj.get(key).toString();
	}
	
	public static String getCountrySpecficData(String root,String child,String key) {
		JSONObject obj = (JSONObject) countryJson.get(root);
		JSONObject childNode = (JSONObject) obj.get(child);
		return childNode.get(key).toString();
	}
	
	public static String getBrandURL(String key) {
		JSONObject obj = (JSONObject) brandJson.get("brand");
		return obj.get(key).toString();
	}
	
	public static String getLocalizedString(String root,String key) {
		JSONObject obj = (JSONObject) localizationJson.get(root);
		return obj.get(key).toString();
	}
}
