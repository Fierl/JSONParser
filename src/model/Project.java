package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/** * The Project class serves as the model of the project
 * 
 * inherits from AbstractProjectEntity class*/
public class Project extends AbstractProjectEntity{
	
	private String key;
	private String assigneeType;
	private String projectTypeKey;
	private boolean archived;
	private User lead;
	private Roles roles;
	private AvatarUrl avatarUrls;
	private ProjectCategory projectCategory;
	private ArrayList<IssueType> issueTypes;
	private ArrayList<HashMap<String, Object>> components;
	private ArrayList<HashMap<String, Object>> versions;

	public Project(String self, String name, String id, String description, String assigneeType, String projectTypeKey,
			boolean archived, User lead, Roles roles, String key, AvatarUrl avatarUrls, ProjectCategory projectCategory,
			ArrayList<IssueType> issueTypes, ArrayList<HashMap<String, Object>> components, 
			ArrayList<HashMap<String, Object>> versions) {
		super(self, name, id, description);
		this.lead = lead;
		this.key = key;
		this.avatarUrls = avatarUrls;
		this.projectCategory = projectCategory;
		this.projectTypeKey = projectTypeKey;
		this.archived = archived;
		this.components = components;
		this.issueTypes = issueTypes;
		this.assigneeType = assigneeType;
		this.versions = versions;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAssigneeType() {
		return assigneeType;
	}

	public void setAssigneeType(String assigneeType) {
		this.assigneeType = assigneeType;
	}

	public User getLead() {
		return lead;
	}

	public void setLead(User lead) {
		this.lead = lead;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public ArrayList<IssueType> getIssueTypes() {
		return issueTypes;
	}

	public void setIssueTypes(ArrayList<IssueType> issueTypes) {
		this.issueTypes = issueTypes;
	}

	public ArrayList<HashMap<String, Object>> getComponents() {
		return components;
	}

	public void setComponents(ArrayList<HashMap<String, Object>> components) {
		this.components = components;
	}

	public ArrayList<HashMap<String, Object>> getVersions() {
		return versions;
	}

	public void setVersions(ArrayList<HashMap<String, Object>> versions) {
		this.versions = versions;
	}

	public AvatarUrl getAvatarUrls() {
		return avatarUrls;
	}

	public void setAvatarUrls(AvatarUrl avatarUrls) {
		this.avatarUrls = avatarUrls;
	}

	public ProjectCategory getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(ProjectCategory projectCategory) {
		this.projectCategory = projectCategory;
	}

	public String getProjectTypeKey() {
		return projectTypeKey;
	}

	public void setProjectTypeKey(String projectTypeKey) {
		this.projectTypeKey = projectTypeKey;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}


	/** * The IssueType class serves as the model of the issuetype
	 * 
	 * inherits from AbstractProjectEntity class*/
	static public class IssueType extends AbstractProjectEntity{
		private String iconUrl;
		private boolean subtask;
		private long avatarId;

		public IssueType(String self, String name, String id, String description, String iconUrl, boolean subtask, long avatarId) {
			super(self, name, id, description);
			this.iconUrl = iconUrl;
			this.subtask = subtask;
			this.avatarId = avatarId;
			}

		public String getIconUrl() {
			return iconUrl;
		}

		public void setIconUrl(String iconUrl) {
			this.iconUrl = iconUrl;
		}

		public boolean isSubtask() {
			return subtask;
		}

		public void setSubtask(boolean subtask) {
			this.subtask = subtask;
		}

		public long getAvatarId() {
			return avatarId;
		}

		public void setAvatarId(long avatarId) {
			this.avatarId = avatarId;
		}
		
	}
	
	/** * The Roles class serves as the model of the roles*/
	static public class Roles {
	    private String tester;
	    private String developers;
	    private String additionalRights;
	    private String projectWorker;
	    private String engineer;
	    private String administrators;
	    private String isb;
	    private String projectLeader;
	    
		public Roles(String tester, String developers, String additionalRights, 
				String projectWorker, String engineer, String administrators, String isb, String projectLeader) {
			this.tester = tester;
			this.developers = developers;
			this.additionalRights = additionalRights;
		    this.projectWorker = projectWorker;
		    this.engineer = engineer;
		    this.administrators = administrators;
		    this.isb = isb;
		    this.projectLeader = projectLeader;
		}

		public String getTester() {
			return tester;
		}

		public void setTester(String tester) {
			this.tester = tester;
		}

		public String getDevelopers() {
			return developers;
		}

		public void setDevelopers(String developers) {
			this.developers = developers;
		}

		public String getAdditionalRights() {
			return additionalRights;
		}

		public void setAdditionalRights(String additionalRights) {
			this.additionalRights = additionalRights;
		}

		public String getProjectWorker() {
			return projectWorker;
		}

		public void setProjectWorker(String projectWorker) {
			this.projectWorker = projectWorker;
		}

		public String getEngineer() {
			return engineer;
		}

		public void setEngineer(String engineer) {
			this.engineer = engineer;
		}

		public String getAdministrators() {
			return administrators;
		}

		public void setAdministrators(String administrators) {
			this.administrators = administrators;
		}

		public String getIsb() {
			return isb;
		}

		public void setIsb(String isb) {
			this.isb = isb;
		}

		public String getProjectLeader() {
			return projectLeader;
		}

		public void setProjectLeader(String projectLeader) {
			this.projectLeader = projectLeader;
		} 
	  }
	
	/** * The ProjectCategory class serves as the model of the project category
	 * 
	 * inherits from AbstractProjectEntity class*/
	static public class ProjectCategory extends AbstractProjectEntity{

		public ProjectCategory(String self, String name, String id, String description) {
			super(self, name, id, description);
		}
		
	}
}
