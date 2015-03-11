package edu.allegheny.sort;

import com.clarkware.Profiler;

import java.util.Random;
import java.io.*;
//set classpath to:
/*export CLASSPATH=/home/m/millerg2/112/cs112S2015-millerg2/lab6/SortingBenchmark/lib/bailey.jar:
 * /home/m/millerg2/112/cs112S2015-millerg2/lab6/SortingBenchmark/lib/profiler.jar:
 * /home/m/millerg2/112/cs112S2015-millerg2/lab6/SortingBenchmark/bin:.*/
//remember to remove spaces between each directory when resetting classpath

public class SortingExperiment
{

  public static int numExperiments = 5; //this value sets the number of times and experiment will be run
  //public static int experimentSize = 1; //sets the smaple size of each individual experiment
  private static boolean verbose = false; //command-line arg


  /** This method calls all of the different experiments and uses the
   * Profiler tool in order to collect profiling information */
  public static void main(String[] args)
  {
    int experimentSize = new Integer(args[1]);
    int size = experimentSize;
    if(args.length >= 1 && args[0].equals("verbose"))
    {

    verbose = true;

    experimentBubbleSort(experimentSize);
    experimentSelectionSort(experimentSize);
    experimentInsertionSort(experimentSize);
    experimentMergeSort(experimentSize);
    experimentQuickSort(experimentSize);
    }

    else if (args.length >= 1)
    {
    try //output single or all 5 algorithm's count total and avg
    {
        //verbose = true; //uncomment for debugging
        String chosen = args[0]; //equals algorithm chosen
        //Integer experimentSize = new Integer(args[2]);
        //Integer numExperiments = new Integer(args[3]);

    switch (chosen)
    {
        case "all": //run all without verbose output
            experimentBubbleSort(experimentSize);
            experimentSelectionSort(experimentSize);
            experimentInsertionSort(experimentSize);
            experimentMergeSort(experimentSize);
            experimentQuickSort(experimentSize);
            break;
        case "bubble": //call for only bubblesort to be ran
            experimentBubbleSort(experimentSize);
            break;
        case "selection": //call for only selectionsort to be ran
            experimentSelectionSort(experimentSize);
            break;
        case "insertion": //call for only insertionsort to be ran
            experimentInsertionSort(experimentSize);
            break;
        case "merge": //call for only mergesort to be ran
            experimentMergeSort(experimentSize);
            break;
        case "quick": //call for only quicksort to be ran
            experimentQuickSort(experimentSize);
            break;
        default:
            System.out.println("Invalid!"); //base case
    }
    }
    catch(RuntimeException chosen) //base case exception
    {
        System.out.println("No such element exists");
    }
    }


    Profiler.print(new PrintWriter(System.out));

  }

  /** This method is responsible for generating an array of a specified size
   * that contains completely random ints inside of it.  This method can be
   * used in each of the methods that actually conduct the experiments */
  public static int[] createInput(int size)
  {

    int[] values = new int[size];

    //Random generator = new Random((long)1.0);
    Random generator = new Random();

    for(int i = 0; i < size; i++)
    {

      int next_value = generator.nextInt(10);
      values[i] = next_value;

    }
    //System.out.println("Debugging");

    return values;

  }

  /** This method is responsible for producing a String representation of our
   * array so that we can easily print out the values.  This is useful when we
   * want to demonstrate that our sorting algorithm worked properly */
  public static String arrayString(int[] values, int size)
  {

    StringBuffer value_buffer = new StringBuffer();
    for(int i = 0; i < size; i++)
    {

      value_buffer.append(values[i]);
      //System.out.println("Debug " +values[i]);

      if(i < size)
      {

        value_buffer.append("\n");

      }

    }

    return value_buffer.toString();

  }

  /** This method conducts an experiment with the BubbleSort sorting algorithm */
  public static void experimentBubbleSort(int size)
  {

    for(int i = 0; i < numExperiments; i++)
    {
      // ask our createInput method for some ints based upon the provided size
      int[] values = createInput(size);

      if( verbose )
        System.out.println("Bubble Sort Initial values: " + arrayString(values,size));

      Profiler.begin("Bubble Sort");
      BubbleSort.bubbleSort(values, size);
      Profiler.end("Bubble Sort");

      if( verbose )
        System.out.println("Bubble Sort Final values: " + arrayString(values,size));

    }

  }

  /** This method conducts an experiment with the SelectionSort sorting algorithm */
  public static void experimentSelectionSort(int size)
  {

    for(int i = 0; i < numExperiments; i++)
    {

      // ask our createInput method for some ints based upon the provided size
      int[] values = createInput(size);

      if( verbose )
        System.out.println("Selection Sort Initial values: " + arrayString(values,size));

      Profiler.begin("Selection Sort");
      SelectionSort.selectionSort(values, size);
      Profiler.end("Selection Sort");

      if( verbose )
        System.out.println("Selection Sort Final values: " + arrayString(values,size));

    }

  }

  /** This method conducts an experiment with the Insertion Sort algorithm */
  public static void experimentInsertionSort(int size)
  {

    for(int i = 0; i < numExperiments; i++)
    {

      // ask our createInput method for some ints based upon the provided size
      int[] values = createInput(size);

      if( verbose )
        System.out.println("Insertion Sort Initial values: " + arrayString(values,size));

      Profiler.begin("Insertion Sort");
      InsertionSort.insertionSort(values, size);
      Profiler.end("Insertion Sort");

      if( verbose )
        System.out.println("Insertion Sort Final values: " + arrayString(values,size));

    }

  }

  /** This method conducts an experiment with the Merge Sort algorithm */
  public static void experimentMergeSort(int size)
  {

    for(int i = 0; i < numExperiments; i++)
    {

      // ask our createInput method for some ints based upon the provided size
      int[] values = createInput(size);

      if( verbose )
        System.out.println("Merge Sort Initial values: " + arrayString(values,size));

      Profiler.begin("Merge Sort");
      MergeSort.mergeSort(values, size);
      Profiler.end("Merge Sort");

      if( verbose )
        System.out.println("Merge Sort Final values: " + arrayString(values,size));

    }

  }

  public static void experimentQuickSort(int size)
  {

    for(int i = 0; i < numExperiments; i++)
    {

      // ask our createInput method for some ints based upon the provided size
      int[] values = createInput(size);

      if( verbose )
        System.out.println("Quick Sort Initial values: " + arrayString(values,size));

      Profiler.begin("Quick Sort");
      //System.out.println("Debugging" +values);
      QuickSort.quickSort(values, size);
      Profiler.end("Quick Sort");

      if( verbose )
        System.out.println("Quick Sort Final values: " + arrayString(values,size));

    }

  }

}
