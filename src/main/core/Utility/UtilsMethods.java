package core.Utility;

import core.Web.UI.InitialDriver.*;
import java.awt.image.*;
import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.util.*;
import javax.imageio.*;
import net.bytebuddy.utility.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.*;
import org.openqa.selenium.*;
import org.testng.*;
import ru.yandex.qatools.ashot.*;
import ru.yandex.qatools.ashot.shooting.*;
import core.Web.UI.SeleniumElement.*;

import static java.lang.Math.*;

public class UtilsMethods extends Element {

    private static final Random rnd = new Random(System.nanoTime());
   // private WebDriver driverLocal= InitialDriver.getInstance().getDriver();


    public static final String REPORT_FORMAT = "yyyyMMdd";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIMESTAMP_FORMAT = "dd.MM.yyyy HH:mm:ss";
    public static final String TIMESTAMP_MILLIS_FORMAT = "dd.MM.yyyy HH:mm:ss.SSS";


    public HashMap<String,String> screenFullPage(ITestResult arg)
    {
        HashMap<String,String> myReport=new  HashMap<>();
        try {
            final Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
            final BufferedImage image = screenshot.getImage();
            String myProject=System.getProperty("user.dir");
            String path=myProject+File.separator+"test-output"+File.separator+"Screenshots";
            File file = new File(path);
            if(!file.exists())
                {
                  file.mkdir();
                }
            SimpleDateFormat format = new SimpleDateFormat("HH_mm_dd-MM-yyyy");
            String dateString = format.format( new Date());
            ImageIO.write(image, "PNG", new File(path+File.separator+
                    arg.getName()+"_"+dateString+".png"));
            myReport.put("Base64", new String(Base64.encodeBase64(screenshot.toString().getBytes()), "UTF-8"));
            myReport.put("path", path+File.separator+arg.getName()+"_"+dateString+".png");
            //myReport.put("ShotPath", arg.getName()+"_"+dateString+".png");
        }
        catch (IOException ex)
        {
            System.out.println("Error Report: "+ex.getMessage());
        }
        return myReport;
    }

    public  String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyy_MM_dd-hh-mm-ss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    public static String genrateRandomName(int length)
    {
        String randomName="TEST "+ new RandomString().make(length);
        return  randomName;
    }
    public String uniqueNumbers(int size) {

        StringBuilder sb = new StringBuilder(size);

        while (sb.length() < size) {
            long l = abs(rnd.nextLong());
            sb.append(Long.toString(l));
        }

        String s = sb.toString();
        return s.substring(0, size);
    }
    public int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String currentDate() {
        Date now = Calendar.getInstance().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        return format(c.getTime(), DATE_FORMAT);
    }


    public static String currentDatePlusDay(int day) {
        Date now = Calendar.getInstance().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.DAY_OF_MONTH, +day);
        return format(c.getTime(), DATE_FORMAT);
    }


    public static String currentDateMinusDay(int day) {
        Date now = Calendar.getInstance().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.DAY_OF_MONTH, -day);
        return format(c.getTime(), DATE_FORMAT);
    }

    public static String datePlusNDays(String dateStr, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime(parseDate(dateStr, DATE_FORMAT));
        c.add(Calendar.DAY_OF_MONTH, n);
        return format(c.getTime(), DATE_FORMAT);
    }

    public static String dateMinusNDays(String date, int n) {
        Calendar c = Calendar.getInstance();
        c.setTime((parseDate(date, DATE_FORMAT)));
        c.add(Calendar.DAY_OF_MONTH, -1 * n);
        return format(c.getTime(), DATE_FORMAT);
    }



    public static Date parseDate(String date, String format) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);

        try {
            return sdf.parse(date);
        }
        catch (ParseException e) {
            return null;
        }
    }

    public static String format(Date date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }


    public static void renameFileUseJavaNewIO(String srcFilePath, String destFilePath)
    {
        try
        {
            if(srcFilePath!=null && srcFilePath.trim().length()>0 && destFilePath!=null && destFilePath.trim().length()>0)
            {
                /* Create the source Path instance. */
                Path srcPathObj = Paths.get(srcFilePath).toAbsolutePath();

                /* Create the target Path instance. */
                Path destPathObj = Paths.get(destFilePath+ "\\allure-results").toAbsolutePath();

                /* Rename source to target, replace it if target exist. */
                Path targetPathObj = Files.move(srcPathObj, destPathObj, StandardCopyOption.COPY_ATTRIBUTES);

                System.out.println("Use java new io to moveFiles success from " + srcFilePath + " to " + destFilePath);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}