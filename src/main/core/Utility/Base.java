package core.Utility;

import core.Utility.PROPERTIES.*;

public class Base {

	public static boolean headlessMode=Boolean.parseBoolean(new PropertiesRead().getPropValues("headlessMode","GF_autoSettings.properties"));
	public static long TIME_OUT = Long.parseLong(new PropertiesRead().getPropValues("element.wait","GF_autoSettings.properties"));
	public static long DELAY = Long.parseLong(new PropertiesRead().getPropValues("element.poling","GF_autoSettings.properties"));
	public static long EXIST = Long.parseLong(new PropertiesRead().getPropValues("element.exist","GF_autoSettings.properties"));
	public static String DRIVER_NAME =new PropertiesRead().getPropValues("browser.driver","GF_autoSettings.properties");
	public static String DRIVER_VERSION =  new PropertiesRead().getPropValues("driver.version","GF_autoSettings.properties");
	public static String DRIVER_PATH = new PropertiesRead().getPropValues("driver.path","GF_autoSettings.properties");
	public static String DRIVER_PATH_LINUX = new PropertiesRead().getPropValues("driverLinux.path","GF_autoSettings.properties");



}

