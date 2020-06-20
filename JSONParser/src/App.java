import java.util.HashMap;

import javax.swing.JOptionPane;

import model.Project;
import output.WriteProjectDetailsIntoFile;
import services.GenerateProjectService;
import services.JSONParseService;

/** * The app class is the main method and used to run the program*/
public class App {

	public static void main(String[] args) {
		Project p = GenerateProjectService.generateProject(JSONParseService.parseJSONFromUrl("input.json"));
		WriteProjectDetailsIntoFile.displayProjectDetails(p);
	}

}
