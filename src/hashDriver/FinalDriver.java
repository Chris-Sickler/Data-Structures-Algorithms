package hashDriver;
import hash.*;
import list.Iterator;

public class FinalDriver {

	public static void main(String args[])
    {   
        HashTable <Integer> nums = new HashTable <Integer> (1);
        
        for (int i=0; i<2; i = i + 2)
                nums.put(i);
                 
        System.out.println ("Size of the hash table is " + nums.size());  // should be 10
        Iterator <Integer> itty = nums.iterator();
        
       
        if(itty.has2more())
        	System.out.println("yerrr");
        else
        	System.out.println("fix it");
    }
}