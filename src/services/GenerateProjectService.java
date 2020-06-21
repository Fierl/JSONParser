package services;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.AvatarUrl;
import model.Project;
import model.User;
import model.Project.IssueType;
import model.Project.ProjectCategory;
import model.Project.Roles;

/** * The GenerateProjectService class contains methods to create project object, as well as the sub-objects*/
public class GenerateProjectService {

	static public Project generateProject(JSONObject projectJson) {	
		Project project = null;
		try {
		String self = (String) projectJson.get("self");
		String id = (String) projectJson.get("id");
		String key =  (String) projectJson.get("key");
		String assigneeType =  (String) projectJson.get("assigneeType");
		String description = (String) projectJson.get("description");
		String name = (String) projectJson.get("name");
		String projectTypeKey = (String) projectJson.get("projectTypeKey");
		ArrayList<HashMap<String, Object>> versions = generateHashMap((JSONArray) projectJson.get("versions"));
		ArrayList<HashMap<String, Object>> components = generateHashMap((JSONArray) projectJson.get("components"));
		boolean archived= false;
		if (projectJson.get("archived") != null) {
			archived = (boolean) projectJson.get("archived");
		}
		
		AvatarUrl avatarUrls = generateAvatarUrl((JSONObject) projectJson.get("avatarUrls"));
		ProjectCategory projectCategory = generateProjectCategory((JSONObject) projectJson.get("projectCategory"));
		Roles roles  = generateRoles((JSONObject) projectJson.get("roles"));
		User lead = generateUser((JSONObject) projectJson.get("lead"));
		ArrayList<IssueType> issueTypes = generateIssueTypeArray((JSONArray) projectJson.get("issueTypes"));
		project = new Project(self, name, id, description, assigneeType, projectTypeKey, archived, 
				lead, roles, key, avatarUrls, projectCategory,issueTypes, components, versions);
		} catch (ClassCastException e) {
			System.out.println("Wrong type of value(s) " + e.getLocalizedMessage());
		}
		return project;
	}
	
	static public ArrayList<HashMap<String, Object>> generateHashMap(JSONArray jsonArray) {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		if (jsonArray != null) {
			jsonArray.forEach((element) -> {
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				JSONObject jsonObject = (JSONObject) element;
				Iterable<String> keySet = jsonObject.keySet();
				keySet.forEach((ele) -> {
					String key = (String) ele;
					hashMap.put(key, jsonObject.get(key));
				});
				list.add(hashMap);
	    	});
			}
		return list;
	}
	
	static public AvatarUrl generateAvatarUrl(JSONObject avatarUrlJson) {
		AvatarUrl avatarUrl;
		if (avatarUrlJson != null) {
			String _16x16 = (String) avatarUrlJson.get("16x16");
			String _24x24 = (String) avatarUrlJson.get("24x24");
			String _32x32 = (String) avatarUrlJson.get("32x32");
			String _48x48 = (String) avatarUrlJson.get("48x48");
			avatarUrl  = new AvatarUrl(_16x16, _24x24, _32x32, _48x48);
		} else {
			avatarUrl  = new AvatarUrl("", "", "", "");
		}
		return avatarUrl;
	}
	
	static public User generateUser(JSONObject userJson) {
		User user;
		if (userJson != null) {
			String self = (String) userJson.get("self");
			String name = (String) userJson.get("name");
			String key = (String) userJson.get("key");
			AvatarUrl userAvatarUrl = generateAvatarUrl((JSONObject) userJson.get("avatarUrls"));
			String displayName = (String) userJson.get("displayName");
			boolean active = (boolean) userJson.get("active");
			user = new User(self, name, key, userAvatarUrl, displayName, active);
		} else {
			user = new User("", "", "", new AvatarUrl("", "", "", ""), "", false);
		}
		return user;
	}
	
	static public Roles generateRoles(JSONObject rolesJson) {
		Roles roles ;
		if (rolesJson != null) {
			String tester = (String) rolesJson.get("Tester");
	    	String developers = (String) rolesJson.get("Developers");
	    	String additionalRights = (String) rolesJson.get("Erweiterte Rechte");
	    	String projectWorker = (String) rolesJson.get("Projektbearbeiter");
	    	String engineer = (String) rolesJson.get("Entwickler");
	    	String administrators = (String) rolesJson.get("Administrators");
	    	String isb = (String) rolesJson.get("ISB");
	    	String projectLeader = (String) rolesJson.get("Projektleiter");
	    	roles = new Roles (tester, developers, additionalRights, projectWorker, 
	    		engineer, administrators, isb, projectLeader);
		} else {
			roles = new Roles ("", "", "", "", "", "", "", "");
		}
		return roles;
	}
	
	static public ArrayList<IssueType> generateIssueTypeArray(JSONArray issueTypeJsonArray) {
		ArrayList<IssueType> issueTypes = new ArrayList<IssueType>();
		if (issueTypeJsonArray != null) {
			issueTypeJsonArray.forEach((element) -> {
				JSONObject issueTypeJson = (JSONObject) element;
				String self = (String) issueTypeJson.get("self");
				String id = (String) issueTypeJson.get("id");
				String name = (String) issueTypeJson.get("name");
				String description = (String) issueTypeJson.get("description");
				String iconUrl = (String) issueTypeJson.get("iconUrl");
				boolean subtask = (boolean) issueTypeJson.get("subtask");
				long avatarId = -1;
				if (issueTypeJson.get("avatarId") != null) {
					avatarId = (long) issueTypeJson.get("avatarId");
				}
	    		IssueType issueType = new IssueType(self, name, id, description, iconUrl, subtask, avatarId);
	    		issueTypes.add(issueType);
	    	});
		}
		return issueTypes;
	}
	
	static public ProjectCategory generateProjectCategory(JSONObject projectCategoryJson) {
		ProjectCategory projectCategory;
		if (projectCategoryJson != null) {
			String self = (String) projectCategoryJson.get("self");
			String id = (String) projectCategoryJson.get("id");
			String name = (String) projectCategoryJson.get("name");
			String description = (String) projectCategoryJson.get("description");
			projectCategory = new ProjectCategory(self, name, id, description);
		} else {
			projectCategory = new ProjectCategory("", "", "", "");
		}
		return projectCategory;
	}
}
