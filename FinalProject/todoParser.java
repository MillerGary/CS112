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
        File file = new File("/inputs/todo.txt");
        ArrayList<String> tasks = new ArrayList<String>();
        Scanner in = new Scanner(file);
        try {
        while (in.hasNextLine());
        {
            String currentTask = in.next(); // ignore case
            tasks.add(currentTask);

        }
        //throws FileNotFoundException;
        }
        catch (FileNotFoundException ex) {
            System.out.println("File was not found!");
        }
        System.out.println("Current Taks: " +tasks);
    }
}


