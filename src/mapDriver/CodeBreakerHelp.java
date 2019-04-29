package mapDriver;
import sort.*; 
import map.*;
import list.*;
import java.io.*;

/** Use a list of English words to unscramble
 *  the enemies messages.
 *  @author (sdb & Chris Sickler)
 *  @version (Apr 2019)
 */
public class CodeBreakerHelp
{
	HashMap<String, List<String>> map = new HashMap<>();
	List<String> message = new ArrayList();
	
    public static void main(String args[])
    { 
    	CodeBreakerHelp breaker = new CodeBreakerHelp();
    	HashMap<String, List<String>> mainMap = breaker.makeMap();
    	//niaiuanmrisotzrtiiocm fo uealcisonlesm npesoaw tpso nialtrenosotiaertuc
    	List<String> message = new ArrayList();
    		message.add("niaiuanmrisotzrtiiocm");
    		message.add("fo");
    		message.add("uealcisonlesm");
    		message.add("npesoaw");
    		message.add("tpso");
    		message.add("nialtrenosotiaertuc");
    		
    	Iterator<String> it = message.iterator();
    	while(it.hasNext()) {
    		String w = it.next();
    		String s = breaker.sort(w);
    		if(mainMap.containsKey(s)){
    			System.out.println(mainMap.get(s));
    		}
    	}
    	
    }
    
    
   // get a list of English words from a text file
    private List <String> getWords()
    {
    	List <String> strings = new ArrayList <String> ();
    	try
    	{
		    File wordFile = new File ("words.txt");
		    java.util.Scanner scanner = new java.util.Scanner (wordFile);
		    String word;
		    while (scanner.hasNextLine())
		        strings.add (scanner.nextLine());
    	}
    	catch (FileNotFoundException fnfe)
    	{   
    		System.err.println (fnfe);   }
    	return strings;
    	}
    

    /** @return the given string, with letters in alphabetic order
     *  If str is "pots" the result should be "opst"
     */
    private String sort (String str)
    {   List <Character> chars = new ArrayList <Character> ();
	    for (int i=0; i < str.length(); i++)
	        chars.add (str.charAt(i));
	    ///////// Call a sorting algorithm, or sort the list of chars here.
	    Sorter<Character> quick = new QuickSort<Character>();
	    quick.sort(chars);
	    String result = "";
	    Iterator <Character> itty = chars.iterator();
	    while (itty.hasNext())
	        result += itty.next();
	    return result;
    }
    
    private HashMap<String, List<String>> makeMap(){
    
    	List<String> words = this.getWords();
    	Iterator<String> it = words.iterator();
    	
    	
    	while(it.hasNext()) {
    		String w = it.next();
    		String s = this.sort(w);
    		List<String> values = map.get(s);
    		if(values != null) {
    			values.add(w);
    			map.put(s, values);
    		} else {
	    		List<String> list = new ArrayList();
	    		list.add(w);
	    		map.put(s, list);
    		}
    	}
    	
    	return map;
    }
    

}