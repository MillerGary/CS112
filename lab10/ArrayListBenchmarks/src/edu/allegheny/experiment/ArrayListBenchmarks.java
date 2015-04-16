package edu.allegheny.experiment;

import java.util.ArrayList;

public class ArrayListBenchmarks {

  private static int initialListSize = 16000000;
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

    System.out.println("ArrayList add benchmark elapsed time = " + (afterArrayListFrontAdd - beforeArrayListFrontAdd));
    System.out.println("ArrayList add benchmark average add time = " + (double)(afterArrayListFrontAdd - beforeArrayListFrontAdd) / (double)addToFrontNumber);


    System.out.println("\n");
    System.out.println("Beginning Remove Benchmark");

    long beforeArrayListFrontRemove = System.currentTimeMillis();
    for (int j = initialListSize + addToFrontNumber - 1; j >= 0; j--){
        arrayList.remove(j);
        //System.out.println("index is at: " +j); //used for debugging
    }
    long afterArrayListFrontRemove = System.currentTimeMillis();

    System.out.println("ArrayList remove benchmark elapsed time = " + (afterArrayListFrontRemove - beforeArrayListFrontRemove));
    System.out.println("ArrayList remove benchmark average remove time = " + (double)(afterArrayListFrontRemove - beforeArrayListFrontRemove) / (double)initialListSize);
    //System.out.println("ArrayList contains: " +arrayList); //used for debugging to show arrayList is now empty

    System.out.println("\n");
    System.out.println("Beginning fill and empty Benchmark");
    long beforeArrayListFrontFill = System.currentTimeMillis();
    for(int k = 0; k<initialListSize; k++){
      arrayList.add(k, k);
    }
    long afterArrayListFrontFill = System.currentTimeMillis();

    //System.out.println("Arraylist add benchmark elapsed time = " + (afterArrayListFrontFill - beforeArrayListFrontFill));
    //System.out.println("Arraylist add benchmark average add time = " + (double)(afterArrayListFrontFill - beforeArrayListFrontFill) / (double)initiallistsize);

    long beforeArrayListFrontEmpty = System.currentTimeMillis();
    for (int l = initialListSize -1; l >= 0; l--){
        arrayList.remove(l);
    }
    long afterArrayListFrontEmpty = System.currentTimeMillis();

    System.out.println("ArrayList fill and remove benchmark elapsed time = " + (afterArrayListFrontEmpty - beforeArrayListFrontFill));
    System.out.println("ArrayList fill and remove benchmark average add and remove time per element = " + (double)(afterArrayListFrontEmpty - beforeArrayListFrontFill) / (double)initialListSize);
    //System.out.println("Arraylist contains: " +arrayList); //used for debugging to show vector is now empty
  }
}
