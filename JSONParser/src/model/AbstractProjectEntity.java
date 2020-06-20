package model;

/** * The AbstractProjectEntity class is an abstract class, 
 * which contains the basic information project based entities
 * 
 * inherits from the AbstractEntity class*/
public class AbstractProjectEntity extends AbstractEntity{
	private String id;
	private String description;
	
	public AbstractProjectEntity(String self, String name,String id, String description) {
		super(self, name);
		this.id = id;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
