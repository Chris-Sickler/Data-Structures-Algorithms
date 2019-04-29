package hash;

public class HomeTown {

	private String name;
	private String state;
	private String zip;
	
	public HomeTown(String name, String state, String zip) {
		this.name = name;
		this.state = state;
		this.zip = zip;
	}

	public String getName() {
		return name;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof HomeTown))
			return false;
		HomeTown other = (HomeTown) obj;
		return this.zip.equals(other.getZip());
	}
	
	public int hashCode() {
		return zip.hashCode();
	}
	
	public String toString() {
		return name + ", " + state + " " + zip;
	}
}
