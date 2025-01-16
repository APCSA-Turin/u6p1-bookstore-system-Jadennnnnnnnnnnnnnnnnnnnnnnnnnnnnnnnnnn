package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    // Intializes the currentId attribute; it's static so it can work in the static functions of this class
    private static String currentId = "99";

    // uses an empty constructer, since the variable is already set
    public IdGenerate(){}

    public static String getCurrentId(){
        // returns the currentId
        return currentId;
    }

    public static void reset(){
        // sets the currentId back to 99
        currentId = "99";
    } 


    public static void generateID(){
        // converts currentId into a int
        int x = Integer.parseInt(currentId);
        // increases the int
        x++;
        // converts the int back into a string
        currentId = String.valueOf(x);
    } 
}