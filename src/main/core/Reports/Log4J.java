package core.Reports;

import java.util.*;
import org.apache.log4j.*;

public class Log4J {


    public static Logger logger(Class mYclass) {
        Properties properties = new Properties();
        PropertyConfigurator.configure(properties);
        return Logger.getLogger(mYclass);
    }
}
