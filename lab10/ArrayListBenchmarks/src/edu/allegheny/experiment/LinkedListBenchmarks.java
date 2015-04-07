package edu.allegheny.experiment;

import java.util.LinkedList;

public class LinkedListBenchmarks {

  private static int initialListSize = 1000000;
  private static int addToFrontNumber = 1000;

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<Integer>();

    for(int i = 0; i<initialListSize; i++) {
      linkedList.add(i);
    }
    System.out.println("linkedList size = " + linkedList.size());

    long beforeLinkedListFrontAdd = System.currentTimeMillis();
    for(int i = 0; i<addToFrontNumber; i++){
      linkedList.add(i, i);
    }
    long afterLinkedListFrontAdd = System.currentTimeMillis();

    System.out.println("LinkedList elapsed time = " + (afterLinkedListFrontAdd - beforeLinkedListFrontAdd));
    System.out.println("LinkedList average add time = " + (double)(afterLinkedListFrontAdd - beforeLinkedListFrontAdd) / (double)addToFrontNumber);

  }
}
