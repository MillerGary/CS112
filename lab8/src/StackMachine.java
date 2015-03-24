import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
public class StackMachine
{
    public static void main(String[] args)
	{
		System.out.println("Enter a value for the stack");
        Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		StackMain theStack = new StackMain(input);
		theStack.push(input);
		while (!theStack.isEmpty())
		{
	         int value = theStack.pop();
	         System.out.print(value);
	         System.out.print(" ");
	    }
	      System.out.println("");
		int cont = 0;
		while (cont != -1)
		{
			System.out.println("Enter command: integer, +, s, d, x, e, rules");
			String command = scan.next();
			switch (command)
			{
				case "integer":
					theStack.push(input);
					System.out.println("Debugging Command integer");
                    //int st =
				break;

				case "+":
					//theStack.push(+);
					System.out.println("Debugging Command +");
                    theStack.push('+');
				break;

				case "s":
					//theStack.s(input);
					System.out.println("Debugging Command s");
				break;

				case "d":
					//int[] display = new int[theStack.StackMain(10)];
                    //display = Arrays.toString(display);
                    theStack.StackMain(input);
                    //System.out.println(" \n" +display);
					System.out.println("Debugging Command d");
				break;

                case "x":w
                         :
					//theStack.x(input);
					System.out.println("Debugging Command x");
				break;

				case "e":
					//theStack.e(input);
					System.out.println("Debugging Command e");
				break;

				case "rules":
					System.out.println("1. If a '+' is on the top of the stack, then the 'x' is popped off the stack, "
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
		System.out.println("type 1 to continue, or type -1 to exit");
		cont = scan.nextInt();
		}
	System.out.println("Goodbye!");
	}
}

