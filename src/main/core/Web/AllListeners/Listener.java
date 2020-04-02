package core.Web.AllListeners;

import core.Reports.ExtentReport_4.*;
import core.TestRail.*;
import core.TestRail.TestRailMethods.*;
import core.Utility.*;
import core.Web.*;
import core.Web.RetryMethods.*;
import core.Web.UI.InitialDriver.*;
import io.qameta.allure.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.testng.*;
import org.testng.annotations.*;


import static Pages.Data.*;


@Listeners({Listener.class})
public class Listener  extends RetryListenerClass implements ITestListener, ISuiteListener, IInvokedMethodListener{

	@Override
	public void onStart(ISuite arg0) {
		Collection<ITestNGMethod> result= arg0.getExcludedMethods();
		ExtentTestManager.getInstance().initialReport(arg0.getName());

	}


	@Override
	public void onFinish(ISuite arg0) {

		System.out.println("ISuite");
		InitialDriver.getInstance().destroy();
	}
    @Override
    public void onStart(ITestContext arg0) {

	    System.out.println("ITestContext");

	}

    @Override
    public void onFinish(ITestContext arg0) {


	}

	@Override
	public void onTestSuccess(ITestResult arg0) {

		System.out.println("Test Name: "+arg0.getName()+"Test Status: "+arg0.getStatus());
		int TC=new ReadAnnotation().readTC(arg0);
		ExtentTestManager.getInstance().initialReport(arg0.getName()).flush();
		if(TC!=0)
			new Results().addResultForCase(runId,TC,new Results().myData(arg0));
		InitialDriver.getInstance().destroy();


    }

	@Attachment
	public static byte[] getBytes(String pathToImg)  {
		try {

			return Files.readAllBytes(Paths.get(pathToImg));
		}
		catch (IOException ex)
		{
			ex.getMessage();
		}
		return null;
	}

	@Override
	public void onTestFailure(ITestResult arg0) {

		System.out.println("Test Name: "+arg0.getName()+"Test Status: "+arg0.getStatus());
		int TC=new ReadAnnotation().readTC(arg0);
		if(TC!=0)
		{new Results().addResultForCase(runId,TC,new Results().myData(arg0));}
		ExtentTestManager.getInstance().getLoger().fail(arg0.getThrowable().getMessage());
		//ExtentTestManager.getInstance().report.flush();
		HashMap<String,String> allData =new UtilsMethods().screenFullPage(arg0);
		new ExtentScreen().getScreenNewVersion(allData);
		getBytes(allData.get("path"));
		//ExtentTestManager.getInstance().getLoger().fail(arg0.getThrowable());
		ExtentTestManager.getInstance().initialReport(arg0.getName()).flush();
		InitialDriver.getInstance().destroy();

    }
	@Override
	public void onTestStart(ITestResult arg0) {
		ExtentTestManager.getInstance().createTest(arg0.getName());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Test Name: "+arg0.getName()+"Test Status: "+arg0.getStatus());
		int TC=new ReadAnnotation().readTC(arg0);
		if(TC!=0)
		new Results().addResultForCase(runId,TC,new Results().myData(arg0));
		ExtentTestManager.getInstance().getLoger().skip(arg0.getName());
		ExtentTestManager.getInstance().initialReport(arg0.getName()).flush();
		InitialDriver.getInstance().destroy();

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }


}