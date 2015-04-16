package edu.allegheny.experiment;

import java.util.Vector;

public class VectorBenchmarks {

  private static int initialListSize = 16000000;
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

    System.out.println("Vector add benchmark elapsed time = " + (afterVectorFrontAdd - beforeVectorFrontAdd));
    System.out.println("Vector add benchmark average add time = " + (double)(afterVectorFrontAdd - beforeVectorFrontAdd) / (double)addToFrontNumber);

    System.out.println("\n");
    System.out.println("Beginning Remove Benchmark");

    long beforeVectorFrontRemove = System.currentTimeMillis();
    for (int j = initialListSize + addToFrontNumber -1; j >= 0; j--){
        vector.remove(j);
    }
    long afterVectorFrontRemove = System.currentTimeMillis();

    System.out.println("Vector remove benchmark elapsed time = " + (afterVectorFrontRemove - beforeVectorFrontRemove));
    System.out.println("Vector remove benchmark average remove time = " + (double)(afterVectorFrontRemove - beforeVectorFrontRemove) / (double)initialListSize);
    //System.out.println("Vector contains: " +vector); //used for debugging to show vector is now empty

    System.out.println("\n");
    System.out.println("Beginning fill and empty Benchmark");
    long beforeVectorFrontFill = System.currentTimeMillis();
    for(int k = 0; k<initialListSize; k++){
      vector.add(k, k);
    }
    long afterVectorFrontFill = System.currentTimeMillis();
    //System.out.println("Vector contains: " +vector); //used for debugging
    //System.out.println("Vector fill benchmark elapsed time = " + (afterVectorFrontFill - beforeVectorFrontFill));
    //System.out.println("Vector fill benchmark average add time = " + (double)(afterVectorFrontFill - beforeVectorFrontFill) / (double)initiallistsize);

    long beforeVectorFrontEmpty = System.currentTimeMillis();
    for (int l = initialListSize -1; l >= 0; l--){
        vector.remove(l);
    }
    long afterVectorFrontEmpty = System.currentTimeMillis();

    System.out.println("Vector fill and empty benchmark elapsed time = " + (afterVectorFrontEmpty - beforeVectorFrontFill));
    System.out.println("Vector fill and empty benchmark average add and remove time per element = " + (double)(afterVectorFrontEmpty - beforeVectorFrontFill) / (double)initialListSize);
    //System.out.println("Vector contains: " +vector); //used for debugging to show vector is now empty
  }
}
