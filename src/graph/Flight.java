package graph;

/**
 * Each flight has an origin and a destination. This is a direct flight
 * 
 * @author chris sickler
 */
public class Flight {
	Airport origin, destination;
	
	public Flight(Airport o, Airport d) {
		origin = o;
		destination = d;
	}
	
	public String toString() {
		return "(" + origin + " -> " + destination + ")";
	}
}
