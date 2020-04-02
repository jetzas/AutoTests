package core.Web.UI.InitialDriver;

import core.Web.UI.Events.*;
import io.github.bonigarcia.wdm.*;
import java.io.*;
import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.support.events.*;

import static io.github.bonigarcia.wdm.DriverManagerType.*;


public  class InitialDriver extends Options {

    private static String driverName;
    private static String driverVersion;
    private static String driverPath;
    private static String driverPathLinux;
    static {
           driverName=core.Utility.Base.DRIVER_NAME;
           driverVersion=core.Utility.Base.DRIVER_VERSION;
           driverPath=driverPathM();
           driverPathLinux=driverPathMForLinux();
    }
    private static   String driverPathMForLinux()
    {
        String myProject=System.getProperty("user.dir");
        driverPathLinux=myProject+ File.separator+"src"+File.separator+"resources"+File.separator+core.Utility.Base.DRIVER_PATH_LINUX;
        return driverPathLinux;
    }
    private static   String driverPathM()
    {
        String myProject=System.getProperty("user.dir");
        driverPath=myProject+ File.separator+"src"+File.separator+"resources"+File.separator+core.Utility.Base.DRIVER_PATH;
        return driverPath;
    }

    /*
     * There is pre-initialization of the driver and his way that is it prior to calling object
     */
    private static ThreadLocal<InitialDriver> driverThread = new ThreadLocal<>();
    private WebDriver driver;

    public static InitialDriver getInstance() {
        if (driverThread.get() == null) {
            synchronized (InitialDriver.class) {
                driverThread.set(new InitialDriver());
            }
        }
        return driverThread.get();
    }

    public WebDriver getDriver() {
        if (driver == null)
        {
            driver = initialDriver();
            return driver;
        } else {
            return driver;
        }
    }
    private static  String OS = System.getProperty("os.name").toLowerCase();
    public static boolean isWindows() {

        return (OS.indexOf("win") >= 0);

    }

    public static boolean isMac() {

        return (OS.indexOf("mac") >= 0);

    }

    public static boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );

    }

    public static boolean isSolaris() {

        return (OS.indexOf("sunos") >= 0);

    }

    /*
     * There is setting driver by name
     */
    private synchronized WebDriver initialDriver() {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);
        System.out.println(System.getProperty("os.name"));
        switch (driverName) {
            case "CHROME": {
                if (!driverVersion.equals("0")) {
                    WebDriverManager.chromedriver().version(driverVersion).setup();
                    ChromeDriverManager.getInstance(CHROME).version(driverVersion).setup();
                } else {
                    String driverPathForTests="";

                    if (isUnix())
                    {
                        driverPathForTests=driverPathLinux;
                    }
                    else if (isWindows())
                    {
                        driverPathForTests=driverPath;
                    }
                    new File(driverPathForTests).setExecutable(true);
                    System.setProperty("webdriver.chrome.driver", driverPathForTests);
                }
                driver = new ChromeDriver(chromeOptions());
                break;
            }
            case "FIREFOX": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions());
                break;
            }
            case "IE": {
                driver = new InternetExplorerDriver(internetExplorerOptions());
                break;
            }

            default: {
                driver = new ChromeDriver(chromeOptions());
            }
        }

        eventDriver = new EventFiringWebDriver(driver);
        handler = new EventHandler() {
        };
        log = new EventLoger() {
        };
        driver = eventDriver.register(log);
		driver = eventDriver.register(handler);
        return driver;
    }
    private EventFiringWebDriver eventDriver=null;
    private     EventHandler handler=null;
    private  EventLoger log=null;
    public void destroy() {
        if (driver != null) {
            driver.quit();
            this.driver=null;
            eventDriver=null;
            handler=null;
            log=null;
        }
    }


}
