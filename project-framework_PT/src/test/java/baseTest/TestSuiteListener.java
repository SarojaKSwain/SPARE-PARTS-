package baseTest;

import java.io.File;
import java.util.List;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import supportLibrary.SuiteFile;

public class TestSuiteListener implements IAlterSuiteListener {

	@Override
	  public void alter(List<XmlSuite> suites) {
	    XmlSuite suite = suites.get(0);
	    String localFilePath =System.getProperty("user.dir")+File.separator+"tests.xlsx";
	    String filePath = (System.getProperty("runFile")==null)?localFilePath:System.getProperty("runFile");
	    SuiteFile reader = new SuiteFile(filePath);
	    reader.getTests(suite);
	  }


}
