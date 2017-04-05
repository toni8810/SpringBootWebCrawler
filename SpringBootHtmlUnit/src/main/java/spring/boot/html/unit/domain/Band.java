package spring.boot.html.unit.domain;

import org.springframework.data.annotation.Id;

public class Band {
	@Id
	private String id;
	private String name;
	
	public Band() {
		
	}
	
	public Band(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Band [id=" + id + ", name=" + name + "]";
	}
	//Override equals and hashcode so that no duplicates will be allowed in the LinkedHashSet
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Band)) return false;
		
		Band band = (Band) o;
		
		return band.name.equals(name);
	}
	@Override
	public int hashCode() {
		int result = 17;
		result = 31 * result + name.hashCode();
		return result;
	}
	
	
}
