package setDriver;

import set.HashSet;
import set.Set;

public class QuizDriver {

	public static void main (String args[])
    {   // Test  HashSet
        Set<String> setA = new HashSet<String>();
        Set<String> setB = new HashSet<String>();
        
        setA.add("a");
        setA.add("b");
        setA.add("c");
        setA.add("d");
        setA.add("e");
        
        setB.add("a");
        setB.add("b");
        setB.add("c");
        setB.add("d");
        setB.add("e");
        
        System.out.println(setA.isSubset(setB));   
    }
}
