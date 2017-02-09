//************************************
// Gary Miller
// CMPSC 112 Spring 2015
// Final Project
// Date: April 2015
//
// Purpose: This file implements a scanner to parse a todo.txt file for input
//          A separate class will be written to map input into a hashmap for constant time remote access of data
//************************************

import java.util.Date; // needed for printing today's date
import java.util.Scanner; //needed for reading in input
import java.util.ArrayList; //needed to implement nested ArrayLists
import java.io.*; //used for file input/output


public class todoParser
{
    //----------------------------
    // main method: program execution begins here
    //----------------------------
    public static void main(String[] args)
    {
        // Label output with name and date:
        //System.out.println("Gary Miller\nLab #\n" + new Date() + "\n");

        // Variable dictionary:
        int numwords = 0;
        int a = 0;
        File file = new File("todo.txt");
        ArrayList<String> tasks = new ArrayList<String>();
        Scanner in = new Scanner(file)
        catch (FileNotFoundException ex) {
            System.out.println("File was snot found!");
        }
        while (in.hasNext());
        {
            String currentTask = in.next().toLowerCase(); // ignore case
            if (tasks.contains(currentTask))
                ++a;
            else
                ++numwords;

        // }
        // System.out.println("Number of distinct words: " +numwords);
     // }
// }
// String tasks1 = "add advanced command line handling for the todo.txt system";
        // String tasks2 = "Study file parsing and file input/output";
        // String tasks3 = "Study implementing hash maps";
        // String tasks4 = "integrate all classes and use an ant build system";
        // String tasks5 = "Prepare for group presentation";
        // tasks.add(0, tasks1);
        // tasks.add(1, tasks2);
        // tasks.add(2, tasks3);
        // tasks.add(3, tasks4);
        // tasks.add(4, tasks5);

