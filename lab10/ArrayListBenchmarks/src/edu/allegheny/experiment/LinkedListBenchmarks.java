package edu.allegheny.experiment;

import java.util.LinkedList;

public class LinkedListBenchmarks {

  private static int initialListSize = 16000000;
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

    System.out.println("LinkedList add benchmark elapsed time = " + (afterLinkedListFrontAdd - beforeLinkedListFrontAdd));
    System.out.println("LinkedList add benchmark average add time = " + (double)(afterLinkedListFrontAdd - beforeLinkedListFrontAdd) / (double)addToFrontNumber);

    //System.out.println("LinkedList contains: " +linkedList);
    System.out.println("\n");
    System.out.println("Beginning remove benchmark");

    long beforeLinkedListFrontRemove = System.currentTimeMillis();
    for (int j = initialListSize + addToFrontNumber -1; j >= 0; j--){
        linkedList.remove();
    }
    long afterLinkedListFrontRemove = System.currentTimeMillis();

    System.out.println("LinkedList remove benchmark elapsed time = " + (afterLinkedListFrontRemove - beforeLinkedListFrontRemove));
    System.out.println("LinkedList remove benchmark average remove time = " + (double)(afterLinkedListFrontRemove - beforeLinkedListFrontRemove) / (double)initialListSize);

    //System.out.println("LinkedList contains: " +linkedList); //used for debugging to show LinkedList is now empty

    System.out.println("\n");
    System.out.println("Beginning fill and empty Benchmark");
    long beforeLinkedListFrontFill = System.currentTimeMillis();
    for(int k = 0; k<initialListSize; k++){
      linkedList.add(k, k);
    }
    long afterLinkedListFrontFill = System.currentTimeMillis();
    //System.out.println("LinkedList contains: " +linkedList); //used for debugging
    //System.out.println("LinkedList fill benchmark elapsed time = " + (afterLinkedListFrontFill - beforeLinkedListFrontFill));
    //System.out.println("LinkedList fill benchmark average add time = " + (double)(afterLinkedListFrontFill - beforeLinkedListFrontFill) / (double)initiallistsize);

    long beforeLinkedListFrontEmpty = System.currentTimeMillis();
    for (int l = initialListSize -1; l >= 0; l--){
        linkedList.remove(l);
    }
    long afterLinkedListFrontEmpty = System.currentTimeMillis();

    System.out.println("LinkedList fill and empty benchmark elapsed time = " + (afterLinkedListFrontEmpty - beforeLinkedListFrontFill));
    System.out.println("LinkedList fill and empty benchmark average add and remove time per element = " + (double)(afterLinkedListFrontEmpty - beforeLinkedListFrontFill) / (double)initialListSize);
    //System.out.println("LinkedList contains: " +linkedList); //used for debugging to show LinkedList is now empty

  }
}
