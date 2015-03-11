package edu.allegheny.gatortweet;
import java.util.Date; // needed for printing today's date
import java.util.Scanner; //needed to use the scanner
import java.util.*;
import java.io.*;
//************************************
// Gary Miller
// CMPSC 112 Spring 2015
// Lab 3
// Date: 01 29 2015
//
// Purpose: Main class for  gatortweet
//************************************

public class GatorTweet
{
    //----------------------------
    // main method: program execution begins here
    //----------------------------
    public static void main(String[] args) throws IOException
    {
        Tweet Tweets = new Tweet();
        // Variable dictionary:
        ArrayList<Tweet> valid = new ArrayList<Tweet>();
        ArrayList<String> invalid = new ArrayList<String>();

        //File file = new File("Words.txt");
        File file = new File("Tweets.txt");
        Scanner scan = new Scanner(file);

        //iterate through Tweets.txt
        while(scan.hasNext())
        {
            String message = scan.nextLine();
            Tweets.isValidMessage(message);
            Tweets.setMessage(message);
        }
        System.out.println(valid);
        System.out.println(invalid);
        System.out.println("Finished!");
    }
}


