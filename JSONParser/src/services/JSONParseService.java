package services;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/** * The JSONParseService reads the json file as parse a json object */
public class JSONParseService {
	
	static public JSONObject parseJSONFromUrl(String pathToJSON) {
		JSONObject jsonObject = null;
		try {
			jsonObject = (JSONObject) new JSONParser().parse(new FileReader(pathToJSON));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (ParseException e) {
			System.out.println("JSON file hase an invalid structure");
		} catch (Exception e) {
			System.out.println("Problem parsing the json file");
		}
		return jsonObject;
	}
	
}
