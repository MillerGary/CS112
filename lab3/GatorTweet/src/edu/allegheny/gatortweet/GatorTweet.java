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
        String message;
        Tweet Tweets = new Tweet();
        // Variable dictionary:
        ArrayList<Tweet> valid = new ArrayList<Tweet>();
        ArrayList<String> invalid = new ArrayList<String>();

        File file = new File("tweets/Tweets.txt");
        Scanner scan = new Scanner(file);

        //iterate through Tweets.txt
        while(scan.hasNextLine())
        {
            message = scan.nextLine();
            if (Tweets.isValidMessage(message) == true)
            {
                Tweets.setMessage(message);
                Tweet validTweet = new Tweet();
                valid.add(Tweets);
            }
            else
            {
                //Tweets.setMessage(message);
                invalid.add(message);
            }
        }
        System.out.println("Valid Tweets: " +valid);
        System.out.println("Invalid Tweets: " +invalid);
    }
}


