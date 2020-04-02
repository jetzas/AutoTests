package core.Utility.PROPERTIES;

import java.io.*;
import java.util.*;


public class PropertiesRead {


	public  String getPropValues(String name, String propertiesFileName)  {
		String result="";
		String myProject=System.getProperty("user.dir");
		try {
			InputStream  input = new FileInputStream(myProject+File.separator+"src"+File.separator+"resources"+File.separator+propertiesFileName);
			Properties prop = new Properties();
			prop.load(input);
			result=prop.getProperty(name);
		}
		catch (IOException e)
		{
			System.out.println("Exception: " + e.getMessage());
		}
		return result;
	}
}
