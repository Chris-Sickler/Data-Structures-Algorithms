package treeDriver;
import tree.*;

/**Test the Expression tree classes.
 * 
 * @author (sdb) 
 * @version (Mar 2019)
 */
public class LabExprDriver 
{
  public static void main(String args[])
  {  
      System.out.println ("\n\nTesting problem 2");
      Expr e1 = new Sum (new Constant(3), new Constant(5));       //  3 + 5      
      Expr e2 = new Sum (new Constant(5), new Constant(3));       //  3 + 5 
      e1 = new Quotient (e1, e2);
      System.out.println ("The quotient is " + e1);                 // (3+5) / (5+3)
      System.out.println ("It simplifies to " + e1.simplify());       // 1
      e1 = new Quotient (e2, e2);
      System.out.println (e1 + " simplifies to " + e1.simplify());
      
      e1 = new Difference (new Constant(3), new Constant(5));       //  3 - 5
      e2 = new Difference (new Constant(5), new Constant (3));      //  5 - 3
      if (e1.equals (e2))
        System.err.println ("Not correct: equals in Difference ");
      
   
      Expr zero = new Constant (0);
      Expr one = new Constant (1);
      e1 = new Sum (new Constant (3), zero);        // 3 + 0
      System.out.println (e1 + " simplifies to " + e1.simplify());           // 3
      
      e1 = new Product (new Constant (4), zero);    // 4 * 0
      System.out.println (e1 + " simplifies to " + e1.simplify());            // 0
      
      e1 = new Product (e2, one);                   //  (5-3) * 1
      System.out.println (e1 + " simplifies to " + e1.simplify());            //  (5 - 3)

      /////////// Uncomment the following when ready for problem 3(a)

  	}
// ////////  Uncomment the following when ready for problem 3(b)
//          System.out.println ("\nTesting problem 3(b)");
//               
//           Expr a = new Variable ('a');
//           Expr b = new Variable ('b');
//           ok = false;
// 
// try {     System.out.println (new Sum(a,b).eval()); }
// catch (IllegalArgumentException iae)
//     {     ok = true; }
//      if (!ok)
//             System.err.println ("Cannot eval a variable, unless it has a value");
//      ok = false;
//      
//      e1 = new Sum (new Assign(a, new Constant(5)),
//                             new Assign (b, new Constant (7)));          // e1 = (a=5) + (b=7)                            
// try {     System.out.println (new Sum(a,b).eval()); }
// catch (IllegalArgumentException iae)
//     {     ok = true; }
//        if (!ok)
//             System.err.println ("Cannot eval a variable, unless it has a value");
//     
//        System.out.println ("The value of " + e1 + " is " + e1.eval());
//           
//        System.out.println (a + " is " + a.eval());
//        System.out.println (b + " is " + b.eval());
//           
//        (new Assign (b, new Constant(5))).eval();                              // b = 5, discard the result
//        if (b.equals(a))
//             System.err.println ("Incorrect: a and b are different expressions");
//             
//        (new Assign (b, a)).eval();                                           // b = a;
//        (new Assign (a, new Constant (0))).eval();                            // a = 0;
//        if (b.eval() != 5)
//             System.err.println ("Incorrect: Variables should store values, not expressions");
//             
//        e1 = new Assign(a, new Sum (b, new Constant (0)));
//        System.out.println (e1 + " simplifies to " + e1.simplify());
//  }
  
}