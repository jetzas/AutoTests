package core.Web.UI.InitialDriver;

import java.io.*;
import java.util.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;

import static core.Utility.Base.*;


abstract class Options {

    ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(headlessMode);
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--no-sandbox");
	    //options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--disable-extensions"); // disabling extensions
	    options.addArguments("--disable-gpu"); // applicable to windows os only
	    options.addArguments("--window-size=1920,1080");
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("plugins.always_open_pdf_externally", true);
        prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "src"+ File.separator + "resources" + File.separator + "DownloadedPDF");
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    FirefoxOptions firefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--no-sandbox");
        return options;
    }

    InternetExplorerOptions internetExplorerOptions() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        return options;
    }
}
