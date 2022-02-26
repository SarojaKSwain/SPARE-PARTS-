package pages.api;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import supportLibrary.APIResponseParser;
import supportLibrary.ReadJson;

public class SampleAPI extends APIResponseParser{
	
	public Response getFieldDataResponse(String asset) {
		Response res = null;
		try {
			res = performAPICall(ReadJson.getAPIBaseURL()+String.format(APIConstants.masterData,asset),"",RequestType.GET,"Field data");
			logHtmlReport(LogStatus.PASS, "Response code of Field Data API "+res.getStatusCode());
		}catch(Exception e) {
			logHtmlReport(LogStatus.ERROR, "Error while retriving data from Field Data API");
		}
		return res;
	}
	
	public Map<Integer,String> getFieldData(Response res) {
		Map<Integer,String> fieldMap = new HashMap<Integer,String>();
		try {
			List<String> boMList = getListOfNodes(res, "$");
			for(int i=0;i<boMList.size();i++) {
				fieldMap.put(i, new Gson().toJson(boMList.get((i)), Map.class));
			}
			logHtmlReport(LogStatus.PASS, "Field data response is parsed");
		}catch(Exception e) {
			logHtmlReport(LogStatus.FAIL, "Exception while parsing Field data response",e);
		}
		return fieldMap; 
	}
}
