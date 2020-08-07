package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonHelper {

	public static String getJsonObjectValue(String file, String node, String variable) {

		JSONParser json_parser = new JSONParser();

		JSONObject json_root = null;
		try {
			json_root = (JSONObject) json_parser.parse(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject json_node = (JSONObject) json_root.get(node);

		return (String) json_node.get(variable);

	}
}
