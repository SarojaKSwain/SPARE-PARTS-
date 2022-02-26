package supportLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;

public class SuiteFile extends suiteFile.Reader{

	public static ThreadLocal<String> country = new ThreadLocal<>();
	public static ThreadLocal<String> brand = new ThreadLocal<>();
	public SuiteFile(String sfilePath) {
		super(sfilePath);
	}
	
	public void getTests(XmlSuite suite) {
    	Connection connection = null;
        try {
        	connection = getConnectionObject();
            Recordset recordset = getRecordSet(connection);
            createTest(recordset,suite);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	closeConnection(connection);
        }
    }
	
	private void createTest(Recordset recordset,XmlSuite suite) {
        try {
        	System.out.println("inside createtest");
        	List<XmlTest> tests = new ArrayList<XmlTest>();
            while (recordset.next()) {
            	XmlTest test = new XmlTest(suite);
                String testName = recordset.getField("MethodName")+"_Test";
                String className = recordset.getField("ClassName");
                String methodName = recordset.getField("MethodName");
                String execIn = recordset.getField("ExecutionIn");
                String execMode = recordset.getField("ExecMode");
                String brand = recordset.getField("Brand");
                String country = recordset.getField("Country");
                if(!execMode.equals("")) {
                	test.addParameter("PexecMode", execMode);	
                }
               	test.addParameter("Brand", brand);
               	test.addParameter("Country", country);
                if(!execIn.equals("")) {
                	test.addParameter("PexecIn", execIn);
                }
                test.setName(testName);
                List<XmlClass> classes = new ArrayList<XmlClass>();
                XmlClass _class = new XmlClass(className);
                _class.setIncludedMethods(new ArrayList<XmlInclude>(Arrays.asList(new XmlInclude(methodName))));
                classes.add(_class);
                test.setClasses(classes);
                tests.add(test);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            recordset.close();
        }
    }
	
	public static synchronized String getCountry() {
		return country.get();
	}
	
	public static synchronized String getBrand() {
		return brand.get();
	}

}
