// Purpose: 
// This program will prompt the user to enter a 
// Java file and the program will count the number of vowels in the file.

// Programmer: Carl Nikoi
// Date: Oct 2024

//  Import Java Dependencies
import java.util.*;
import java.io.*;

public class CountVowels {
    public static void main(String[] args) {
    	
        // Print Welcome message
        System.out.println("Welcome to the CountVowels program!");
        System.out.println("This program will prompt the user to enter a file name");
        System.out.println("and then count the number of vowels in the file.");
        System.out.println("Let's get started!\n");

        // TreeMap to hold vowels as key and count as value
        TreeMap<Character, Integer> vowelCount = new TreeMap<>();
        vowelCount.put('A', 0);
        vowelCount.put('E', 0);
        vowelCount.put('I', 0);
        vowelCount.put('O', 0);
        vowelCount.put('U', 0);

        // Scanner object and prompt the user to enter a file name
        Scanner input = new Scanner(System.in);
        File file;

        //Do While Loop checking if  the file exists or not
        do {
            System.out.print("Enter a text file name: ");
            String filename = input.nextLine();
            file = new File(filename);
            
            if (!file.exists()) {
                System.out.println("File " + filename + " does not exist. Please try again.");
            }
        } while (!file.exists());

        try {
            Scanner fileScanner = new Scanner(file);
            
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().toUpperCase();
                for (char c : line.toCharArray()) {
                    if (vowelCount.containsKey(c)) {
                        vowelCount.put(c, vowelCount.get(c) + 1);
                    }
                }
            }
            
            fileScanner.close();

            // Display results
            System.out.println("\nVowel counts in the file:");
            vowelCount.forEach((k, v) -> System.out.println(k + ": " + v));

            
         //Exception to catch errors
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        // Print out final message
        System.out.println("\nWritten by Carl Nikoi, Fall 2024");
        
        input.close();
        
        
    } // Main
} // CountVowels