// Program: Print String Reversed
// Purpose: This Program Prompts a user to input a string and reverses it for the output
// Programmer: Carl Nikoi
// Date: Sept 2024

import java.util.Scanner;

public class PrintStringReversed {

    public static void main(String[] args) {
        // Print Welcome message
        System.out.println("Welcome to the Print Reverse program!");
        System.out.println("This program prompts the user to enter a string");
        System.out.println("and the program prints out the string reversed. Let's get started!");

        // Create scanner object to get keyboard input
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String userString = input.nextLine();

        // Display the reversed string
        System.out.print("The reversal of " + userString + " is : ");
        reverseDisplay(userString);

        // Print out final message
        System.out.println("\n\nWritten by Carl Nikoi, Fall 2024");

        // Close the scanner
        input.close();
    }

    // Reverse Display Method
    public static void reverseDisplay(String userString) {
        reverseDisplay(userString, userString.length() - 1);
    }

    
    // Recursive Display Method
    public static void reverseDisplay(String userString, int high) {
        if (high >= 0) {
        	
        	//Outputs the string
            System.out.print(userString.charAt(high));
            reverseDisplay(userString, high - 1);
        }
    }
}