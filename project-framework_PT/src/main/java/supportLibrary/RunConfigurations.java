package supportLibrary;

/**
 * @author NIA3COB
 * 
 * To read runtime value and assign to framework variables
 *
 */
public class RunConfigurations {
	
	private static String executionMode;
	private static String execIn;
	private static String env;
	private static int waitTime;
	private static boolean hasWebServices;
	
	
	
	public static void setRunConfig() {
		RunConfigurations.executionMode = (System.getProperty("executionMode")==null)?ReadJson.getRunConfigData("executionMode"):System.getProperty("executionMode");
		RunConfigurations.execIn = (System.getProperty("execIn")==null)?ReadJson.getRunConfigData("execIn"):System.getProperty("execIn");
		RunConfigurations.env = (System.getProperty("env")==null)?ReadJson.getRunConfigData("env"):System.getProperty("env");
		RunConfigurations.waitTime = (System.getProperty("waitTimeOut")==null)?Integer.parseInt(ReadJson.getRunConfigData("waitTimeOut")):Integer.parseInt(System.getProperty("waitTimeOut"));
		RunConfigurations.hasWebServices = Boolean.valueOf(ReadJson.getRunConfigData("waitTimeOut"));
	}
	
	public static String getExecIn() {
		return execIn;
	}
	
	public static String getExecutionMode() {
		return executionMode;
	}
	
	public static String getEnv() {
		return env;
	}
	
	public static int getWaitTime() {
		return waitTime;
	}
	
	public static boolean isHasWebServices() {
		return hasWebServices;
	}
	
	public static String getExecutionMachineOS() {
		return "";
	}

}
