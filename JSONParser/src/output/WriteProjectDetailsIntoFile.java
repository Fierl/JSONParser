package output;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.Project;
import model.Project.IssueType;

/** * The WriteProjectDetailsIntoFile class creates a text file inside the directory*/
public class WriteProjectDetailsIntoFile {
	static public void displayProjectDetails(Project project) {
		try {
			int hour = LocalDateTime.now().getHour();
			int minute = LocalDateTime.now().getMinute();
			int second = LocalDateTime.now().getSecond();
			PrintWriter writer = new PrintWriter("inputJsonDetails" + hour + "_" + minute + "_" + second + ".txt", "UTF-8");
			writer.println("The name of the project: " + project.getName());
			writer.println("The name of the project category: " + project.getProjectCategory().getName());
			ArrayList<IssueType> issueTypes = project.getIssueTypes();
			writer.println("The name(s) of issuetypes:");
			issueTypes.forEach(element -> {
				writer.println("The name of the issuetype: " + element.getName());
			});
			writer.println("The name(s) of issuetypes with subtasks:");
			issueTypes.forEach(element -> {
				if (element.isSubtask()) {
					writer.println("The name of the issuetype, which is a subtask: " + element.getName());
				}
			});
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("File couldn't be created");
		}
	}
}
