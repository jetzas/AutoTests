package core.TestRail.api;

import core.Utility.PROPERTIES.*;
import java.io.*;
import java.util.*;
import org.json.*;


public class CryptoToken extends ApiMethods {
//Boolean.parseBoolean(new PropertiesRead().getPropValues("headlessMode","GF_autoSettings.properties"));
	private final String user = "bmstesting@gf.lt";
	private final String pass = "belekoks1";
	private final String url = "https://genfin.testrail.io/index.php?/api/v2";

	private static String getAuthorization(String user, String password) {
		try {
			return new String(Base64.getEncoder().encode((user + ":" + password).getBytes("UTF-8")));
		}
		catch (UnsupportedEncodingException e) {

			//System.out.println(e.getMessage());
		}
		return "";
	}

	public JSONObject getHeader(String myUrl) {
		JSONObject header = new JSONObject();
		header.put("url_name", url + myUrl);
		header.put("header", "Authorization");
		header.put("headerValue", "Basic " + getAuthorization(user, pass));
		return header;
	}


}
