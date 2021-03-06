package edu.allegheny.benchmark;

import com.clarkware.Profiler;
import java.io.*;

public class UseFibonacci {

    public static void main(String[] args) {

        System.out.println("Begin experiment with different Fibonacci " +
                "implementations ..."); System.out.println();

        // extract the value that was passed on the command line; this is the
        // nth fibonacci number that we must calculate in the three different
        // fashions
        Integer Num = new Integer(args[0]); int num = Num.intValue();

        // determine which algorithm we are supposed to benchmark
        String chosen = args[1];

        //determine which data type shall be analyzed
        String type = args[2];

        if( chosen.equals("recursive") || chosen.equals("all") ) {

            if (type.equals("int") || type.equals("all")) //only performs int task if type == int
            {                                             //and both int and long if type == all
            // 1. RECURSIVE fibonacci (int)
            Profiler.begin("RecursiveFibonacciInt"); int recursiveFib =
                RecursiveFibonacci.fib(num);
            Profiler.end("RecursiveFibonacciInt");

            System.out.println("(Recursive/int) The " + num + "th Fibonacci " +
                    "number = " + recursiveFib + ".");
            if (type.equals("all")) //also performs long task if type == all
            {
                {
                    // 1. RECURSIVE fibonacci (long)
                    Profiler.begin("RecursiveFibonacciLong"); long recursiveFibLong =
                    RecursiveFibonacci.fibLong(num);
                    Profiler.end("RecursiveFibonacciLong");

                    System.out.println("(Recursive/long) The " + num + "th Fibonacci "
                        + "number = " + recursiveFibLong + ".");
                }
            }
            }
            else if (type.equals("long")) //only performs long task if type == long
            {
            // 1. RECURSIVE fibonacci (long)
            Profiler.begin("RecursiveFibonacciLong"); long recursiveFibLong =
                RecursiveFibonacci.fibLong(num);
            Profiler.end("RecursiveFibonacciLong");

            System.out.println("(Recursive/long) The " + num + "th Fibonacci "
                    + "number = " + recursiveFibLong + ".");
            }
        }

        if( chosen.equals("iterative") || chosen.equals("all") ) {

            if (type.equals("int") || type.equals("all")) //only performs int task if type == int or all
            {
            // 2. ITERATIVE fibonacci (int)
            Profiler.begin("IterativeFibonacciInt"); int iterativeFib =
                IterativeFibonacci.fib(num);
            Profiler.end("IterativeFibonacciInt");

            System.out.println("(Iterative/int) The " + num + "th Fibonacci " +
                    "number = " + iterativeFib + ".");
            if (type.equals("all")) //also performs long task if type == all
            {
                // 2. ITERATIVE fibonacci (long)
                Profiler.begin("IterativeFibonacciLong"); long iterativeFibLong =
                IterativeFibonacci.fibLong(num);
                Profiler.end("IterativeFibonacciLong");

                System.out.println("(Iterative/long) The " + num + "th Fibonacci "
                    + "number = " + iterativeFibLong + ".");
            }
            }
            else if (type.equals("long") || type.equals("all")) //only performs long task if type == long
            {
            // 2. ITERATIVE fibonacci (long)
            Profiler.begin("IterativeFibonacciLong"); long iterativeFibLong =
                IterativeFibonacci.fibLong(num);
            Profiler.end("IterativeFibonacciLong");

            System.out.println("(Iterative/long) The " + num + "th Fibonacci "
                    + "number = " + iterativeFibLong + ".");
            }
        }

        System.out.println(); Profiler.print(new PrintWriter(System.out));

        System.out.println("... End experiment with different Fibonacci " +
                "implementations");

    }

}
