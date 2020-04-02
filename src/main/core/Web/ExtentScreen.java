package core.Web;

import core.Reports.ExtentReport_4.*;
import core.Web.UI.InitialDriver.*;
import core.Web.UI.SeleniumElement.*;
import java.io.*;
import java.util.*;
import org.openqa.selenium.*;

public class ExtentScreen extends Element {

   // private WebDriver driver=InitialDriver.getInstance().getDriver();

    public void getScreenNewVersion(HashMap<String,String> allData)
    {
        try {
            if (driver == null) return;
           // System.out.println(allData.get("path"));
            String myPath=allData.get("path");
           // core.Reports.ExtentReport_4.ExtentTestManager.getInstance().getLoger().addScreencastFromPath(allData.get("path"));
           ExtentTestManager.getInstance().getLoger().addScreenCaptureFromPath(myPath);

        }
        catch (IOException ex)
        {
			System.out.println(ex.getMessage());
        }

    }
}
