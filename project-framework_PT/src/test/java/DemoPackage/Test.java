package DemoPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Test {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\SAROJ\\project-framework_PT\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\SAROJ\\Driver Browser\\geckodriver.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\SAROJ\\Browser Driver\\IEDriverServer.exe");
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://stage.boschtoolservice.com/us/en/boschprof/spareparts/search");
		driver.manage().window().maximize();
		driver.close();
		System.out.println("Pass");
	}

}
