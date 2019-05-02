package queueDriver;

/**
 * A Doc has a size, in blocks, to be printed.
 * 
 * @author (Chris Sickler) 
 * @version (04/30/19)
 */
public class Doc implements Comparable
{
    private int size;      // size of this Doc, in blocks

    /**
     * Constructor for objects of class Printer
     */
    public Doc(int size)
    {
        this.size = size;
    }
    
    public int size()
    {   return size;  }
   
    public int compareTo(Object obj) {
    	Doc other = (Doc) obj;
    	
    	if(this.size < other.size)
    		return 1;
    	return -1;
    	
    }
    
    public String toString() {
    	return "Doc of size " + size;
    }
    
}
