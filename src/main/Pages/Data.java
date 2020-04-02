package Pages;

import core.Utility.PROPERTIES.*;
import java.util.*;
import org.apache.commons.lang3.*;
import org.testng.annotations.*;


public class Data {

	public static  int runId = runId();
	public static  List<String> testCasesIds = testCasesIds();

	private static int runId()
	{

		String value=System.getProperty("runid");
		if(value==null)
			return 3;
		System.out.println("Run ID: "+value);
		return Integer.parseInt(value);
	}
	private static List<String> testCasesIds()
	{
		String value=System.getProperty("testCaseIds");
		if(value==null)
			return Arrays.asList("0");
		String [] stringArray=value.split("_");
		if(stringArray[0].equals("_")||stringArray[0].length()==0)
		{
		stringArray= ArrayUtils.remove(stringArray, 0);
		}
		System.out.println(Arrays.asList(stringArray));
		return  Arrays.asList(stringArray);
	}

	private static String myUrl()
	{
		String value=System.getProperty("envAdmin");
		if(value==null)
			return new PropertiesRead().getPropValues("urlTstPartneriaiGfLt", "data.properties");
		if(value.equals("STG")) {
			return new PropertiesRead().getPropValues("urlStgPartneriaiGfLt", "data.properties");
		}
		else {
			return new PropertiesRead().getPropValues("urlTstPartneriaiGfLt", "data.properties");
		}
	}

	private static String myUrlAdmin()
	{
		String value= System.getProperty("envAdmin");
		System.out.println(value);
		if(value==null)
			return new PropertiesRead().getPropValues("urlGFTstMain", "data.properties");
		if(value.equals("STG")) {
			return new PropertiesRead().getPropValues("urlGFStgMain", "data.properties");
		}
		else {
			return new PropertiesRead().getPropValues("urlGFTstMain", "data.properties");
		}
	}

	private static String myUrlManoGf()
	{
		String value= System.getProperty("envAdmin");
		System.out.println(value);
		if(value==null)
			return new PropertiesRead().getPropValues("urlTstManogfLt", "data.properties");
		if(value.equals("STG")) {
			return new PropertiesRead().getPropValues("urlStgManogfLt", "data.properties");
		}
		else {
			return new PropertiesRead().getPropValues("urlTstManogfLt", "data.properties");
		}
	}
}
