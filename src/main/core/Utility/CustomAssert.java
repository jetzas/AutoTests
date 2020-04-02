package core.Utility;

import core.Reports.ExtentReport_4.*;
import io.qameta.allure.model.*;
import org.testng.*;
import org.testng.internal.*;


public class CustomAssert extends Assert {

	static String format(Object var0, Object var1, String var2) {
		String var3 = "";
		if (null != var2) {
			var3 = var2 + " ";
		}

		return var3 + EclipseInterface.ASSERT_LEFT + var1 + EclipseInterface.ASSERT_MIDDLE + var0 + EclipseInterface.ASSERT_RIGHT;
	}


	public static void fail(String var0, Throwable var1) {
		AssertionError var2 = new AssertionError(var0);
		var2.initCause(var1);
		throw var2;
	}

	public static void fail(String var0) {
		throw new AssertionError(var0);
	}

	public static void fail() {
		fail((String)null);
	}


	private static void failNotEquals(Object var0, Object var1, String var2) {
		fail(format(var0, var1, var2));
	}

	public static void assertTrue(boolean var0, String var1) {
		if (!var0) {
			failNotEquals(var0, Boolean.TRUE, var1);
		}

	}
	public static void assertContains(String arg1,String arg2) {
		try {
			//ExtentTestManager.getInstance().getLoger().fail("Actual: "+arg1+" Expected: "+arg2);
			assertTrue(arg1.contains(arg2));
			core.Reports.AllureReport.AllureUtils.SetStep("Actual: "+arg1+" Expected: "+arg2, Status.PASSED);
			ExtentTestManager.getInstance().getLoger().pass("Actual: "+arg1+" Expected: "+arg2);
		}
		catch (AssertionError ex)
		{
			System.out.println("Actual: "+arg1+" Expected: "+arg2);
			core.Reports.AllureReport.AllureUtils.SetStep("Actual: "+arg1+" Expected: "+arg2, Status.FAILED);
			ExtentTestManager.getInstance().getLoger().error("Actual: "+arg1+" Expected: "+arg2);
			assertTrue(arg1.contains(arg2));
		}
	}
	public static void assertTrue(boolean var0) {

		assertTrue(var0, (String)null);
	}

	public static void assertFalse(boolean var0, String var1) {
		if (var0) {
			failNotEquals(var0, Boolean.FALSE, var1);
		}

	}

	public static void assertFalse(boolean var0) {
		assertFalse(var0, (String)null);
	}

	public static void assertEquals(boolean actual, boolean expected) {
		ExtentTestManager.getInstance().getLoger().error("Actual: " + actual + " Expected: " + expected);
		assertEquals(actual, expected, (String) null);
	}

	public static void assertEquals(String actual, String expected) {

		ExtentTestManager.getInstance().getLoger().error("Actual: " + actual + " Expected: " + expected);
		assertEquals((String) actual, (String) expected, (String) null);
	}

}
