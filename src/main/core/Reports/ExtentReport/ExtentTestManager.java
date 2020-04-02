package core.Reports.ExtentReport;

import com.relevantcodes.extentreports.*;
import java.util.*;

public class ExtentTestManager {


    private static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    //static ExtentReports extent = ExtentManager.getReporter();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest(String testName) {
        ExtentManager.getReporter(testName).endTest(extentTestMap.get((int) (long) (Thread.currentThread().getId())));
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = ExtentManager.getReporter(testName).startTest(testName, desc);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
}