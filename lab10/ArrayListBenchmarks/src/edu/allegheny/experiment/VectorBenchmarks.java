package edu.allegheny.experiment;

import java.util.Vector;

public class VectorBenchmarks {

  private static int initialListSize = 1000000;
  private static int addToFrontNumber = 1000;

  public static void main(String[] args) {
    Vector<Integer> vector = new Vector<Integer>();

    for(int i = 0; i<initialListSize; i++) {
      vector.add(i);
    }
    System.out.println("Vector size = " + vector.size());

    long beforeVectorFrontAdd = System.currentTimeMillis();
    for(int i = 0; i<addToFrontNumber; i++){
      vector.add(i, i);
    }
    long afterVectorFrontAdd = System.currentTimeMillis();

    System.out.println("Vector elapsed time = " + (afterVectorFrontAdd - beforeVectorFrontAdd));
    System.out.println("Vector average add time = " + (double)(afterVectorFrontAdd - beforeVectorFrontAdd) / (double)addToFrontNumber);

  }
}
