package edu.allegheny.gatortweet;

import java.util.Date;

public class Tweet
{

    private Date currentDate; //variable to store the current date

    private String message; //variable to store the text of the tweet

    private static final int MAX_LENGTH = 140; //assures that the tweet is not longer than 140 chars

    public Tweet()
    {
        currentDate = new Date(); //method to set date to current date
    }

    public boolean isValidMessage(String message) // checks is tweet is valid or not
    {
        if (message.length() > 0 && message.length() < MAX_LENGTH)
        {
            return true; //returns true if tweet is of valid length
        }
        else
        {
            return false; //tweet is of invalid length
        }
    }

    public void setMessage(String message)
    {
        this.message = message; //saves message to a temp value
    }

    public String toString()
    {
        return "(" + currentDate.toString() + ", " + message + ")"; //returns new tweet with current date
    }

}
