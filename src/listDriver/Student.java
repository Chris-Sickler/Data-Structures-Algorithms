package listDriver;
import list.*;

public class Student {

	private String name;
	private int id;
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return id;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Student))
			return false;
		
		Student temp = (Student)obj;
		if(temp.getID() == this.getID())
			return true;
		return false;
	}
	
	public String toString() {
		return "(" + name + ", " + id + ")";
	}
}
