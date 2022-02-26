package test;

import org.testng.annotations.Test;


import baseTest.JSONDataProvider;
import baseTest.TestNgBase;

public class ParallelTest extends TestNgBase{
	
	@Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void GooglePage(Object data) {
		getDriverHelper().getPages().SampleTestPage().VerifyGoogle();
	  }
	
	@Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void YoutubePage(Object data) {
		getDriverHelper().getPages().SampleTestPage().VerifyYoutube();
	  }
	
	@Test(dataProvider="testData",dataProviderClass=JSONDataProvider.class)
	  public void TestTwoDriverInst(Object data) {
		getDriverHelper().getPages().SampleTestPage().VerifyGoogle();
//		getDriverHelper2().getPages().SampleTestPage().VerifyGoogle();
	  }
 

}

