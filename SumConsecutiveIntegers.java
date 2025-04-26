// Purpose: 
//		This program implements two different algorithms
//		for summing all positive integers from m to n where m <= n
// Programmer: Carl Nikoi
// Date: Oct 2024
//

import java.util.Scanner;

public class SumConsecutiveIntegers {
    public static void main(String[] args) {
    	
    	// Display welcome message and program description
    	System.out.println("Welcome to the SumConsecutiveIntegers program!");
        System.out.println("This program prompts the user to enter two ");
        System.out.println("positive integers m and n");
        System.out.println("The program will compute the sum of all the integers");
        System.out.println("from m to n using two different methods and ");
        System.out.println("the results will be reported. The two methods are.\n");
        System.out.println("1.Loop implementation (o (n) performance");
        System.out.println("2. Closed form implementation (o(1) performance.\n");
    	
        Scanner scanner = new Scanner(System.in);
        long m, n;

        // Input Scanner validation to check if a positive integer is entered for m
        do {
            System.out.print("Enter a positive integer m : ");
            while (!scanner.hasNextLong()) {
            	
            	// Output a message should a value other than a positive integer is entered
                System.out.println("Invalid! Enter a positive integer");
                scanner.next();
            }
            m = scanner.nextLong();
            
            // Terminate do while loop should m be less than or equal to (0)
        } while (m <= 0);

        // Input Scanner validation to check if a positive integer is entered for n
        do {
            System.out.print("Enter positive integer n (must be > m): ");
            while (!scanner.hasNextLong()) {
                System.out.println("Invalid! Enter a positive integer.");
                scanner.next();
            }
            n = scanner.nextLong();
        } while (n <= 0 || n < m);
        
        
        // Initialize StopWatch and measure time for loop sum method
        StopWatch timer = new StopWatch();
        timer.start();
        long loopResult = loopSum(m, n);
        timer.stop();
        long loopTime = timer.getElapsedTime();

        // Measure time for closed form sum method
        timer.start();
        long closedFormResult = closedFormSum(m, n);
        timer.stop();
        long closedFormTime = timer.getElapsedTime();

        // Print results for the loop method of summing
        System.out.println("\nUsing loop method of summing: ");
        System.out.println("Sum = : " + loopResult);
        System.out.println("Execution time is " + loopTime + " milliseconds \n");
        
        // Print results for the closed form method of summing
        System.out.println("Using closed form method of summing: ");
        System.out.println("Sum  =  " + closedFormResult);
        System.out.println("Execution time is  " + closedFormTime + " milliseconds");

        // Close the scanner 
        scanner.close();
        
        
        // Print out final message
        System.out.println("\nWritten by Carl Nikoi, Fall 2024");
    }

    // Method to calculate sum using loop
    public static long loopSum(long m, long n) {
        long sum = 0;
        for (long i = m; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // Method to calculate sum using closed form formula
    public static long closedFormSum(long m, long n) {
        return (n * (n + 1) - (m - 1) * m) / 2;
    }
}