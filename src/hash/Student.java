package hash;

public class Student {
	
	private String name;
	private String idNum;
	private int credits;
	private HomeTown homeTown;
	
	public Student(String name, String idNum, int credits, HomeTown homeTown) {
		this.name = name;
		this.idNum = idNum;
		this.credits = credits;
		this.homeTown = homeTown;
	}

	public String getName() {
		return name;
	}

	public String getIdNum() {
		return idNum;
	}

	public int getCredits() {
		return credits;
	}

	public HomeTown getHomeTown() {
		return homeTown;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		return (this.name.equals(other.getName()) && this.credits == other.getCredits() 
				&& this.homeTown.equals(other.getHomeTown()));
	}
	
	public int hashCode() {
		int nameCode = name.hashCode();
		int creditCode = Integer.toString(credits).hashCode();
		int homeCode = homeTown.hashCode();
		
		return nameCode + creditCode + homeCode;
	}
	
	
	
	public String toString() {
		return name+"("+ idNum + ") " + credits + " cr " + homeTown.toString() + " ";
	}
	
}
