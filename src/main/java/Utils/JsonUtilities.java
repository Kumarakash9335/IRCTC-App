package Utils;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;


public class JsonUtilities {
    public static JSONArray getJSONArray(String filePath) {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) jsonParser.parse(new FileReader(filePath));

        } catch (Exception e){
            e.printStackTrace();
        }
        return jsonArray;
    }
}
