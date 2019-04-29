package listDriver;

import list.*;

/**
 *  Solution
 * 
 * @author (sdb and Chris Sickler) 
 * @version (Feb 2019)
 */
public class LabStudentIterator
{
    
    static List <Student> roster;
    
    public static void main()
    {   roster = new ArrayList<Student>();
        System.out.println("Working with an ArrayList");
        test();
        System.out.println();
        System.out.println("Working with a LinkedList");
        roster = new LinkedList<Student>();
        test();
        System.out.println();
    }
    
    private static void init()
    {   deleteFirstDup();
        roster.add (new Student ("jim", 2222));
        deleteFirstDup();
        roster.add (new Student ("joseph", 2345));
        roster.add (new Student ("joe", 2345));
        roster.add (new Student ("mary", 3333));
        roster.add (new Student ("maryLou", 3333));
        System.out.println("Before deletions " + roster);
    }
    
    private static void test()
    {   
        init();
        deleteFirstDup();
        if (roster.size() != 4)
            System.err.println ("Deletion is incorrect");
        System.out.println ("Roster is " + roster);
    }
    
    /** Search the roster for the first pair of neighbors which are
     *  equal.  Delete either member of that pair.
     *  @author Chris Sickler
     */
    private static void deleteFirstDup()
    {   ///////////  PUT YOUR CODE HERE ///////////////
       Iterator <Student> it = roster.iterator();
       if(!(roster.isEmpty())) {
       
    	   Student temp1 = it.next();
    	   boolean removed = false;
    	   while(it.hasNext() && !removed) {
    		   Student temp2 = it.next();
    		   if(temp1.equals(temp2)) {
    			   it.remove();
    			   removed = true;
    		   }
    		   else 
    			   temp1 = temp2;
    	   }
       }
        
       
    }

    
    
        
        
}