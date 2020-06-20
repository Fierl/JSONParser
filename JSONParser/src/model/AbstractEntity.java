package model;

/** * The AbstractEntity class is an abstract class, 
 * which contains the basic information for all entities*/
public class AbstractEntity {
	private String self;
	private String name;
	
	public AbstractEntity(String self, String name) {
		this.self = self;
		this.name = name;
	}

	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
