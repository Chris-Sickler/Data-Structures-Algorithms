package queueDriver;

import tree.Sum;

/**
 * An Airplane has a flight number, an arrival time, and a fuel level.
 * 
 * @author (sdb) 
 * @version (Apr 2019)
 */
public class Airplane implements Comparable  
{  int flight;
   int arrivalTime;
   int fuelLevel;       // gallons of jet fuel remaining
   
   public Airplane (int arrival, int fuel, int flight)
   {    arrivalTime = arrival;
        fuelLevel = fuel;
        this.flight = flight;
        System.out.println (this + " has arrived at time " + arrival); 
    }
   
   public int compareTo(Object obj) {
	   
		Airplane plane = (Airplane) obj;
	   
	   if(this.fuelLevel > 4 && plane.fuelLevel > 4) { //FIFO logic
		   if(this.arrivalTime < plane.arrivalTime)
			   return 1;
		   return -1;
	   }
	   
	   if(this.fuelLevel < 4 && plane.fuelLevel > 4) 
		   return 1;
	   if(this.fuelLevel < 4 && this.fuelLevel < plane.fuelLevel) 
		   return 1;
	   return -1;  
	
   }
   
   public String toString() {
	   return "flight: " + flight + ", fuel = (" + fuelLevel + ") gallons";
   }
}