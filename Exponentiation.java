// Purpose: 
// This program implements two different algorithms for 
// calculating exponentiation using exponentiation by squaring:
// 1. A recursive algorithm
// 2. An iterative algorithm
// Programmer: Carl Nikoi
// Date: Oct 2024

// Import scanner for input
import java.util.Scanner;

public class Exponentiation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long base, exponent;

        // Introduction and explanation of the program
        System.out.println("Welcome to the Exponentiation program!");
        System.out.println("This program calculates raising a base to the power of an exponent.");
        System.out.println("You will be prompted to enter a base and an exponent, and the program will");
        System.out.println("calculate the result using the following methods:");
        System.out.println("1. Using Math.pow – the gold standard");
        System.out.println("2. Using recursivePow – recursive implementation");
        System.out.println("3. Using iterativePow – iterative implementation");
        System.out.println("Let's get started!\n");

        // Input validation for base
        do {
            System.out.print("Enter a positive integer for the base (a): ");
            while (!scanner.hasNextLong()) {
                // Display error message
                System.out.println("Invalid input! Please enter a positive integer.");
                scanner.next();
            }
            base = scanner.nextLong();
        } while (base <= 0);

        // Input validation for exponent
        do {
            System.out.print("Enter a positive integer for the exponent (n): ");
            while (!scanner.hasNextLong()) {
                // Display error message
                System.out.println("Invalid input! Please enter a positive integer.");
                scanner.next();
            }
            exponent = scanner.nextLong();
        } while (exponent < 0); // Allowing exponent to be 0 for correct mathematical behavior

        // Testing and timing the algorithms
        StopWatch timer = new StopWatch();

        // Using Math.pow
        timer.start();
        double mathPowResult = Math.pow(base, exponent);
        timer.stop();
        long mathPowTime = timer.getElapsedTime();

        // Using recursive method
        timer.start();
        double recursiveResult = recursivePow(base, exponent);
        timer.stop();
        long recursiveTime = timer.getElapsedTime();

        // Using iterative method
        timer.start();
        double iterativeResult = iterativePow(base, exponent);
        timer.stop();
        long iterativeTime = timer.getElapsedTime();

        // Displaying results
        System.out.println("\nUsing Math.pow() method from the Math class:");
        System.out.println(base + "^" + exponent + "= " + mathPowResult);
        System.out.println("Execution time is " + mathPowTime + " milliseconds\n");

        System.out.println("Using recursivePow:");
        System.out.println(base + "^" + exponent + "= " + recursiveResult);
        System.out.println("Execution time is " + recursiveTime + " milliseconds\n");

        System.out.println("Using iterativePow:");
        System.out.println(base + "^" + exponent + "= " + iterativeResult);
        System.out.println("Execution time is " + iterativeTime + " milliseconds\n");

        // Print final results
        System.out.println("\nWritten by Carl Nikoi, Fall 2024");
        
        // Close the scanner 
        scanner.close();
        
    } // main

    // Recursive method to calculate power using exponentiation by squaring
    public static double recursivePow(long base, long exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent % 2 == 0) {
            double temp = recursivePow(base, exponent / 2);
            return temp * temp;
        } else {
            return base * recursivePow(base, exponent - 1);
        }
    } // recursivePow

    // Iterative method to calculate power using exponentiation by squaring
    public static double iterativePow(long base, long exponent) {
        double result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= base;
            }
            base *= base;
            exponent /= 2;
        }
        return result;
    } // iterativePow
} // Exponentiation
