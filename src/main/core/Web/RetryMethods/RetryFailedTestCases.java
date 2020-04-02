package core.Web.RetryMethods;

import java.util.*;
import org.slf4j.*;
import org.testng.*;


public class RetryFailedTestCases implements IRetryAnalyzer {

	private static final int RETRIES = 2;

	private static Map<String, Integer> retries = Collections.synchronizedMap(new HashMap<>());

	public boolean retry(ITestResult result) {
		if (result.getStatus() != ITestResult.FAILURE) {
			return false;
		}
		String key = result.getTestContext().getName() + "/" + result.getMethod().getMethodName();
		retries.putIfAbsent(key, 0);
		int curRetries = retries.get(key);
		if (curRetries < RETRIES) {
			retries.put(key, curRetries + 1);
			return true;
		}
		return false;

	}

}