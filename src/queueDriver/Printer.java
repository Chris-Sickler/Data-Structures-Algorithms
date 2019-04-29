package queueDriver;

import queue.*;

/**
 * A Printer has a speed, in blocks of printing per step, and a queue of Docs to be printed
 * 
 * @author (sdb & Chris Sickler)
 * @version (Oct 2017)
 */
public class Printer
{
    private int speed;      // speed of this printer, blocks per step
    private QueueADT <Doc> docs;    // Queue of documents waiting to be printed
    private String id;      // name of this Printer
    private boolean free;
    private int docSize;

    /**
     * Constructor for objects of class Printer
     */
    public Printer(int speed, String id)
    {
      this.speed = speed;
      this.id = id;
      docs = new Queue<Doc>();
      free = true;
    }

    /** Add a document to this printer's queue 
       Display the document and printer on stdout.
       */
    public void add (Doc doc)
    {    
       docs.add(doc);
        
        //////////// Do not change this println statement ///////////////
        System.out.println(doc + " added to " + this);
    }

    /** Print several blocks, if necessary, determined by this printer's speed.
     * Display a completion message, if necessary.
     *  
     */
    public void print()
    {  
    	if(!(docs.isEmpty())){    	
	    	
	    	if(free) {
	    		docSize = docs.peek().size();
	    		free = false;
	    	}
	    	docSize -= speed;
	    	
	    	
	    	if(docSize <= 0) {
	    		System.out.println("Print task completed on " + id + ": for " + docs.remove());
	    		free = true;
	    	}	
	    		
	    }
    }

    /** @return the number of documents in this Printer's queue */
    public int size()
    {   return docs.size();  }

    public String toString()
    {   return id + ", speed: " + speed + ", docs in queue: " + size();  }
}
