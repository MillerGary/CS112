/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package edu.allegheny.doubling;
import java.util.Random;

/**
 * Demonstration of algorithm for finding the maximum element of an array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class ArrayMax {

  /** Returns the maximum value of a nonempty array of numbers. */
  public static int arrayMax(int[] data)
  {
    int length = data.length;
    int currentMax = data[0];     // assume first entry is biggest (for now)
    for (int j=1; j < length; j++)        // consider all other entries
      if (data[j] > currentMax)      // if data[j] is biggest thus far...
        currentMax = data[j];        // record it as the current max
    return currentMax;
  }

  /** This method is responsible for generating an array of a specified size
   * that contains completely random ints inside of it.  This method can be
   * used in each of the methods that actually conduct the experiments
   * method taken from StringExperiment program used in lab6*/
  public static int[] createInput(int n)
  {

    int[] data = new int[n];

    //Random generator = new Random((long)1.0);
    Random generator = new Random();

    for(int i = 0; i < n; i++)
    {

      int next_value = generator.nextInt();
      data[i] = next_value;

    }

    return data;

  }
   /**
   * Tests the ArrayMax algorithm, doubling the
   * size of n each trial, beginning with the given start value. The
   * first command line argument can be used to change the number of
   * trials, and the second to adjust the start value.
   */
    public static void main(String[] args)
    {
        int n = 50000;                           // starting value
        int trials = 10;
        int counter = 1;

        try
        {
            if (args.length > 0)
                trials = Integer.parseInt(args[0]);
            if (args.length > 1)
             n = Integer.parseInt(args[1]);
        }
        catch (NumberFormatException e) { }
        int start = n;  // remember the original starting value

        // runs a doubling experiment for ArrayMax algorithm
        System.out.println("Testing ArrayMax...");
        System.out.println("Begin trial: 1");
        while (counter <= trials)
        {
            int data[] = createInput(n);
            long startTime = System.currentTimeMillis();
            int currentMax = arrayMax(data);
            long endTime = System.currentTimeMillis();
            long elapsed = endTime - startTime;
System.out.println("elapsed time for ArrayMax with size of "+n+": "+elapsed+"ms");
        if (n < 102400000)
        {
            n *= 2; // double the problem size
        }
        else
        {
            counter++;
            System.out.println("\n");
            System.out.println("Begin trial:" +counter);
            n = start;
        }
    }
}
}
