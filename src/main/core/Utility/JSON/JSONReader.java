package core.Utility.JSON;

import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class JSONReader {

    public JSONObject readJson(String pathToJson) {
        JSONParser parser = new JSONParser();
        String myProject = System.getProperty("user.dir");
//		File file = new File("../module/src/../resources");
        File file = new File(myProject + "/src/resources/");

        String absolutePath = file.getAbsolutePath() + pathToJson;
        try {
            Object obj = parser.parse(new FileReader(absolutePath));
            JSONObject jsonObject = (JSONObject) obj;
            return jsonObject;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
