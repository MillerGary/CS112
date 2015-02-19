package edu.allegheny.gatortweet;
import twitter4j.*;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
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
        char c;
        int command = 0; //initalize a value to conditional logic control
        Tweet Tweets = new Tweet(); //declares instance of the Tweet class
        // Variable dictionary:
        ArrayList<Tweet> valid = new ArrayList<Tweet>(); //initalize ArrayList for vaild
        ArrayList<String> invalid = new ArrayList<String>(); //and invalid tweets

        File file = new File("tweets/Tweets.txt"); //sets up and reads draft file
        Scanner scan = new Scanner(file); //scans drafts

        //iterate through Tweets.txt
        while(scan.hasNextLine())
        {
            message = scan.nextLine();
            if (Tweets.isValidMessage(message) == true) //if tweet is valid length it is saved as a draft in tweets.txt
            {
                Tweets.setMessage(message);
                Tweet validTweet = new Tweet();
                valid.add(Tweets);
            }
            else //if tweets is > 140 char it is kept as a String and place in invalid
            {
                //Tweets.setMessage(message);
                invalid.add(message);
            }
        }
        while (command != -2) //-2 is used as an exit command, defines value for other commands
        {
        System.out.println("Enter '-2' to quit");
        System.out.println("Please enter '1' to view stored valid and invalid tweets");
        System.out.println("Please enter '2' to draft a new status");
        System.out.println("Please enter '3' to view your timeline");
        System.out.println("Please enter '4' to generate a random tweet");
        Scanner input = new Scanner (System.in); //initalize a scanner
        command = input.nextInt(); //reads user input for command

        if(command==1) //prints out drafts stored in ArrayList invaild and invalid tweets from ArrayList invalid
        {
            System.out.println("Valid Tweets: " +valid);
            System.out.println("Invalid Tweets: " +invalid);
        }
        else if (command==2) //method to take user input and post as a tweet
        {
        try {
            System.out.println("Please enter new status");
            String status = input.next(); //takes in user input

             ConfigurationBuilder cb = new ConfigurationBuilder();
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = TwitterFactory.getSingleton();
            Status newStatus = twitter.updateStatus(status);
            System.out.println("Successfully updated the status to [" + newStatus.getText() + "].");
            System.exit(0);
        }

            catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        } /*catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Failed to read the system input.");
            System.exit(-1);
        }*/
        }
        else if (command==3) //method to retrieve and print timeline to console
        {
        try {
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)

                .setOAuthConsumerKey("rPtRCCRqdDyoxHS3E2UARA")
                .setOAuthConsumerSecret("hhDnR4NETStvN4F84km2xuBy3eXJ8l2FnjdL23YPs");
            // gets Twitter instance with default credentials
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();
           //Twitter twitter = new TwitterFactory().getInstance();
            User user = twitter.verifyCredentials();
            List<Status> statuses = twitter.getHomeTimeline();
            //System.out.println("Showing @" + user.getScreenName() + "'s home timeline.");
            for (Status status : statuses) {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }
        }
        else if (command==4) //generates a random int and puts it into a tweet
        {
            //method to generate a string of random chars up to 20 char in length
            try{
            Random rand = new Random(); //used to generate random int
            int num = rand.nextInt(141); //initalize a variable between 0 and 140
            String str = "I'm thinking of a number, which is " +num; //text of new tweet
            //Method used to post new tweets
            ConfigurationBuilder cb = new ConfigurationBuilder();
            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = TwitterFactory.getSingleton();
            Status newStatus = twitter.updateStatus(str);
            System.out.println("Successfully updated the status to [" + newStatus.getText() + "].");
            System.exit(0);
            }
            catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        }/*catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Failed to read the system input.");
            System.exit(-1);
        }*/
}}}}
