import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
public class StackMain
{
	private int maxSize;
	   private int[] stackArray;
	   private int top;
	   public StackMain(int s)
	   {
	      maxSize = s;
	      stackArray = new int[maxSize];
	      top = -1;
       }
	   public void integer(int j)
	   {
		   stackArray[++top] = j;
	   }
	   public void plus(int j)
	   {
		   stackArray[++top] = j;
	   }
	   public void s(int j)
	   {
		   stackArray[++top] = j;
	   }
	   public void push(int j)
	   {
	      stackArray[++top] = j;
	   }
	   public int pop()
	   {
	      return stackArray[top--];
	   }
	   public int peek()
	   {
	      return stackArray[top];
	   }
	   public boolean isEmpty()
	   {
	      return (top == -1);
	   }
	   public boolean isFull()
	   {
	      return (top == maxSize - 1);
	   }
       public int[] d()
        {
            return stackArray;
        }
}
