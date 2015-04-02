package edu.allegheny.solve;

import net.datastructures.*;

public class JosephusSolver {

  /** Solution of the Josephus problem using a queue. */
  public static <E> E Josephus(Queue<E> Q, int k) {
    if (Q.isEmpty()) return null;
    while (Q.size() > 1) {
      //System.out.println("  Queue: " + Q + "  k = " + k);
      for (int i=0; i < k; i++)
        Q.enqueue(Q.dequeue());  // move the front element to the end
      E e = Q.dequeue(); // remove the front element from the collection
      //System.out.println("    " + e + " is out");
      }
    return Q.dequeue();  // the winner
  }

  /** Build a queue from an array of objects */
  public static <E> Queue<E> buildQueue(E a[]) {
    Queue<E> Q = new NodeQueue<E>();
    for (int i=0; i<a.length; i++)
      Q.enqueue(a[i]);
    return Q;
  }

  /** Tester method */
  public static void main(String[] args) {
    Integer number = new Integer(args[0]); //takes a command line arg for num of children
    Integer steps = new Integer(args[1]); //takes a command line arg for num of steps until child is out
    int num = number.intValue(); //converts command line arg to type int
    int step = steps.intValue();
    int index = num + 1; //sets outs string array size to 1 more than the number of chilren
    String[] children = new String[index]; //initializes string array to used to construct the queue
    //System.out.println("The number of children is: " +num); //debugging print line
    for (int i = 0; i <= num; i++) //for loop used to construct the children in the game
    {
        String kid = "kid" +i;
        children[i] = kid;
    }
    long startTime = System.currentTimeMillis();
    System.out.println("The winner is " + Josephus(buildQueue(children), step)); //runs the JosephusSolver
    long endTime = System.currentTimeMillis();
    System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");
  }
}
