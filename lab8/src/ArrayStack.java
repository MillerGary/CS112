import java.util.Scanner;
import java.lang.Integer;
//begin#fragment ArrayStack
 /**
  * Implementation of the stack ADT using a fixed-length array.  An
  * exception is thrown if a push operation is attempted when the size
  * of the stack is equal to the length of the array.  This class
  * includes the main methods of the built-in class java.util.Stack.
//end#fragment ArrayStack
  *
  * @author Natasha Gelfand
  * @author Roberto Tamassia
  * @see FullStackException
//begin#fragment ArrayStack
  */
//begin#fragment ArrayStack
public class ArrayStack<E> implements Stack<E> {
//end#fragment ArrayStack
 /**
  *
  *
  * Length of the array used to implement the stack.
  */
//begin#fragment ArrayStack
  protected int capacity; 	// The actual capacity of the stack array
//end#fragment ArrayStack
 /**
  * Default array capacity.
  */
//begin#fragment ArrayStack
  public static final int CAPACITY = 1000;	// default array capacity
//end#fragment ArrayStack
 /**
  * Array used to implement the stack.
  */
//begin#fragment ArrayStack
  private E data[];		// Generic array used to implement the stack
//end#fragment ArrayStack
 /**
  * Index of the top element of the stack in the array.
  */
//begin#fragment ArrayStack
 private int t = -1;	// index for the top of the stack
//end#fragment ArrayStack
 /**
  * Initializes the stack to use an array of default length.
  */
//begin#fragment ArrayStack
  public ArrayStack() {
    this(CAPACITY); // default capacity
  }
//end#fragment ArrayStack
 /**
  * Initializes the stack to use an array of given length.
  * @param cap length of the array.
  */
//begin#fragment ArrayStack
  @SuppressWarnings("unchecked")
public ArrayStack(int capacity) {
    data = (E[]) new Object[capacity]; // compiler may give warning, but this is ok
  }
//end#fragment ArrayStack
 /**
  * Returns the number of elements in the stack.
  * This method runs in O(1) time.
  * @return number of elements in the stack.
  */
//begin#fragment ArrayStack
  public int size() {
    return (t + 1);
  }
//end#fragment ArrayStack
 /**
  * Testes whether the stack is empty.
  * This method runs in O(1) time.
  * @return true if the stack is empty, false otherwise.
  */
//begin#fragment ArrayStack
  public boolean isEmpty() {
    return (t == -1);
  }
//end#fragment ArrayStack
 /**
  * Inserts an element at the top of the stack.
  * This method runs in O(1) time.
  * @return element inserted.
  * @param element element to be inserted.
  * @exception FullStackException if the array storing the elements is full.
  */
//begin#fragment ArrayStack
  public void push(E e) throws IllegalStateException {
    if (size() == data.length)
      throw new IllegalStateException("Stack is full.");
    data[++t] = e;
  }
//end#fragment ArrayStack
 /**
  * Inspects the element assertTrue("Failure message", <`2:condition`>); the top of the stack.
  * This method runs in O(1) time.
  * @return top element in the stack.
  * @exception EmptyStackException if the stack is empty.
  */

//begin#fragment ArrayStack
  public E pop() {
    if (isEmpty()) return null;
    E answer = data[t];
    data[t] = null; // dereference data[t] for garbage collection.
    t--;
    return answer;
  }
//end#fragment ArrayStack

  /**
   * Removes the top element from the stack.
   * This method runs in O(1) time.
   * @return element removed.
   * @exception EmptyStackException if the stack is empty.
   */
//begin#fragment ArrayStack
  public E top() {
    if (isEmpty()) return null;
    return data[t];
  }
//end#fragment ArrayStack

 /**
  * Returns a string representation of the stack as a list of elements,
  * with the top element at the end: [ ... , prev, top ].
  * This method runs in O(n) time, where n is the size of the stack.
  * @return textual representation of the stack.
  */
//begin#fragment ArrayStack2
  public String toString() {
    String s;
    s = "[";
    if (size() > 0) s+= data[0];
    if (size() > 1)
      for (int i = 1; i <= size()-1; i++) {
	s += ", " + data[i];
      }
    return s + "]";
  }



 /**
  * Prints status information about a recent operation and the stack.
  * @param op operation performed
  * @param element element returned by the operation
  * @return information about the operation performed, the element
  * returned by the operation and the content of the stack after
  * the operation.
  */
//begin#fragment ArrayStack2
//  Prints status information about a recent operation and the stack.
  public void status(String op, Object e) {
    System.out.print("------> " + op);   // print this operation
    System.out.println(", returns " + e); // what was returned
    System.out.print("result: size = " + size() + ", isEmpty = " + isEmpty());
    System.out.println(", stack: " +this);       // contents of the stack
  }

  public void display(String op, Object e) {
	  System.out.println("stack: " +this); //print contents of stack
  }
//end#fragment ArrayStack2
//begin#fragment ArrayStack2

  public static void main(String[] args)
	{
		ArrayStack<String> st = new ArrayStack<String>(); //create instance of our stack data strucutre

		Scanner scan = new Scanner(System.in); //inititializes scanner
		int input;

        /*  //uncomment to use a default input for debugging
            //Default input
		    st.push("10");
    		st.push("20");
    		st.push("30");
    		st.push("40");
            st.push("50");
        */
		System.out.println("The stack can be ended with the x command");
		int cont = 0;
		while (cont != -1)
		{
			System.out.println(">>>>>Enter command: integer, +, s, d, x, e, rules");
			String command = scan.next(); //define and scan value for command to be ran
			switch (command) //loop that handles our command system
			{
				case "integer":
					System.out.println("Enter an integer to push on the stack"); //console output
					input = scan.nextInt(); //scans user input for an integer value
					String in = st.makeString(input); //converts int to string so stack will accept it
					st.push(in); //pushes the String of our int to the top of the stack
				break;

				case "+":
					st.push("+"); //pushes a + on the top of the stack
				break;

				case "s":
					st.push("s"); //pushes an s on the top of the stack
				break;

				case "d":
					st.display(command, null); //displays the stack's contents
				break;

				case "x":
					System.out.println("The Stack has been ended"); //console output
					cont = -1; //ends loop and program
				break;

				case "e":
				    switch (st.top())
                    {
					//System.out.println("Hello");
                        case "+":
						st.pop();
                        String var1 = st.pop();
						//String var = makeInt(var1);
						String var2 = st.pop();
						int temp = sumInts(var1, var2);
						//int total1 = var + temp;
                        String total = makeString(temp);
						//System.out.println("debug: " +total);
						st.push(total);
					    break;

                        case "s": //if s is the top of the stack it will be popped and swaps next two values
                        st.pop(); //pops s
                        String var3 = st.pop(); //pops next two values
                        String var4 = st.pop();
                        st.push(var3); //pushes values back in reverse order
                        st.push(var4);
					    break;

                        default:
						st.display(command, null); //invalid command, display stack then reprompts
					}

				break;

				case "rules":
					System.out.println("1. If a '+' is on the top of the stack, then the '+' is popped off the stack, "
							+ "the following two integers are popped and added, "
							+ "and the result is pushed back on the stack\n");
					System.out.println("2. If an 's' is on the top of the stack, then the 's' is popped off the stack"
							+ "and the following two element are swapped on the top of the stack\n");
					System.out.println("3. If an integer is on the top of the stack is empty, "
							+ "then the stack is left unchanged\n");

				break;

				default:
					System.out.println("Inccorect Command!");
				break;
			}

		}
	System.out.println("Goodbye!");
	}
private static boolean elseif(boolean b) {
	if (b == false)
	{
		return false;
	}
    return false;
}
private static String toString(String var) {
	String str = var;
	return str;
}
private static String makeString(int temp) {
	String val = (""+temp);
	return val;
}
private static int sumInts(String a, String b) {
    //throws NumberFormatException;
    int int1 = Integer.parseInt(a);
    int int2 = Integer.parseInt(b);
    int sum = int1 + int2;
    return sum;
}
//public NumberFormatException(String msg) {
  //  String msg = "cannot swap + as type int!";
    //return msg;
//}
}
