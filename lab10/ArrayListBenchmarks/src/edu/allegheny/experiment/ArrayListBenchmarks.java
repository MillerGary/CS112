package edu.allegheny.experiment;

import java.util.ArrayList;

public class ArrayListBenchmarks {

  private static int initialListSize = 1000000;
  private static int addToFrontNumber = 1000;

  public static void main(String[] args) {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    for(int i = 0; i<initialListSize; i++) {
      arrayList.add(i);
    }
    System.out.println("ArrayList size = " + arrayList.size());

    long beforeArrayListFrontAdd = System.currentTimeMillis();
    for(int i = 0; i<addToFrontNumber; i++){
      arrayList.add(i, i);
    }
    long afterArrayListFrontAdd = System.currentTimeMillis();

    System.out.println("ArrayList elapsed time = " + (afterArrayListFrontAdd - beforeArrayListFrontAdd));
    System.out.println("ArrayList average add time = " + (double)(afterArrayListFrontAdd - beforeArrayListFrontAdd) / (double)addToFrontNumber);

  }
}
