package supportLibrary;

import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import webserviceLibrary.RestHelper;

/**
 * @author NIA3COB
 * 
 * Class contains functions to parse API response and retrieve the value
 *
 */
public class APIResponseParser extends RestHelper{
	
	public APIResponseParser() {
		
	}

	protected List<String> getListOfNodes(Response res,String expression){
		List<String> nodeList = null; 
		try{
			JsonPath path = res.jsonPath();
			nodeList = path.get(expression);
			log(LogType.INFO, "Parsing response with expression :"+expression);
		}catch(Exception e){
			log(LogType.ERROR, "Exception while evaluating expression from Json response. Method: getListOfElement. Expression: "+expression);
		}
		return nodeList;
	}
	
	protected String getNodeAsString(Response res,String expression){
		String node = null; 
		try{
			JsonPath path = new JsonPath(res.asString());;
			node = path.get(expression);
			log(LogType.INFO, "Parsing response with expression :"+expression);
		}catch(Exception e){
			log(LogType.ERROR, "Exception while evaluating expression from Json response. Method: getElementAsString. Expression: "+expression);
		}
		return node;
	}
	
	protected float getNodeAsFloat(Response res,String expression){
		float node = 0;
		try{
			JsonPath path = res.jsonPath();
			node = path.get(expression);
			log(LogType.INFO, "Parsing response with expression :"+expression);
		}catch(Exception e){
			log(LogType.ERROR, "Exception while evaluating expression from Json response. Method: getNodeAsFloat. Expression: "+expression);
		}
		return node;
	}
	
	protected float getNodeAsFloat(String res,String expression){
		float node = 0;
		try{
			JsonPath path = JsonPath.given(res);
			node = path.get(expression);
			log(LogType.INFO, "Parsing response with expression :"+expression);
		}catch(Exception e){
			log(LogType.ERROR, "Exception while evaluating expression from Json response. Method: getNodeAsFloat. Expression: "+expression);
		}
		return node;
	}
	
	protected double getNodeAsDouble(String res,String expression){
		double node = 0;
		try{
			JsonPath path = JsonPath.given(res);
			node = path.get(expression);
			log(LogType.INFO, "Parsing response with expression :"+expression);
		}catch(Exception e){
			log(LogType.ERROR, "Exception while evaluating expression from Json response. Method: getNodeAsDouble. Expression: "+expression);
		}
		return node;
	}
	
	protected int getNodeAsInt(Response res,String expression){
		int node = 0;
		try{
			JsonPath path = res.jsonPath();
			node = path.get(expression);
			log(LogType.INFO, "Parsing response with expression :"+expression);
		}catch(Exception e){
			log(LogType.ERROR, "Exception while evaluating expression from Json response. Method: getNodeAsFloat. Expression: "+expression);
		}
		return node;
	}
	
	protected String getNodeAsString(String resBody,String expression){
		String node = null; 
		try{
			JsonPath path = JsonPath.given(resBody);
			node = path.get(expression);
			log(LogType.INFO, "Parsing response with expression :"+expression);
		}catch(Exception e){
			log(LogType.ERROR, "Exception while evaluating expression from Json response. Method: getNodeAsString. Expression: "+expression);
		}
		return node;
	}
	
	protected List<String> getListOfNode(String resBody,String expression){
		List<String> nodeList = null; 
		try{
			JsonPath path = JsonPath.given(resBody);
			nodeList = path.get(expression);
			log(LogType.INFO, "Parsing response with expression :"+expression);
		}catch(Exception e){
			log(LogType.ERROR, "Exception while evaluating expression from Json response. Method: getListOfElement. Expression: "+expression);
		}
		return nodeList;
	}
	
	/*protected Double getNodeAsFloatWithJayway(Response res,String expression){
		Double node = null;
		try{
			
			ReadContext rx = com.jayway.jsonpath.JsonPath.parse(res.getBody().asString());
			node =rx.read(expression);
			log(LogType.INFO, "Parsing response with expression :"+expression);
		}catch(Exception e){
			log(LogType.ERROR, "Exception while evaluating expression from Json response. Method: getElementAsDouble. Expression: "+expression);
		}return node;
	}*/
	

}
