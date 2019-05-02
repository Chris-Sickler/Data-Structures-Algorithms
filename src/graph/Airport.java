package graph;

/**Airport is a node/location */
public class Airport implements Comparable {
	String name;
	boolean visited = false;
	boolean hub = false;
	
	public Airport(String name) {
		this.name = name;
	}
	
	public Airport(String name, boolean hub) {
		this.name = name;
		this.hub = hub;
	}
	
	public String toString() {
		if(!hub)
			return name;
		else return name + " (hub)";
	}

	public int compareTo(Object obj) {
		Airport other = (Airport) obj;
		
		if(this.hub && !other.hub)
			return 1;
		if(other.hub && !this.hub)
			return -1;
		return 0;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Airport)) 
			return false;
		Airport other = (Airport) obj;
		return name.equals(other.name);
	}
	
	public void setHub() {
		hub = true;
	}
	
	public void removeHub() {
		hub = false;
	}
}
