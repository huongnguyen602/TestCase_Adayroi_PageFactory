package Demo.TestCase_Adayroi_PageFactory.Utiity;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlSuite;

public class ReporterCustomize implements IReporter {

	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String arg2) {
		// TODO Auto-generated method stub
		for (ISuite iSuite : arg1) {
			Map<String, ISuiteResult> results = iSuite.getResults();
			Set<String> keys = results.keySet();
			for (String key : keys) {
				ITestContext context = results.get(key).getTestContext();
				System.out.println("Suite name->" + context.getName() + "\n ::Report output Directory->"
						+ context.getOutputDirectory() + "::Suite Name->" + context.getSuite().getName()
						+ "\n ::Start Date Time for execution->" + context.getStartDate()
						+ "\n ::End Date Time for execution->" + context.getEndDate());
				IResultMap resultMap = context.getFailedTests();
				Collection<ITestNGMethod> failedMethods = resultMap.getAllMethods();
				System.out.println("-----FAILED TEST CASE-----");
				for (ITestNGMethod iTestNGMothod : failedMethods) {
					System.out.println("TESTCASE NAME->" + iTestNGMothod.getMethodName() + "\nDescription->"
							+ iTestNGMothod.getDescription() + "\nPriority->" + iTestNGMothod.getPriority() + "\nDate->"
							+ new Date(iTestNGMothod.getDate()));
				}
			}
		}
	}
}
