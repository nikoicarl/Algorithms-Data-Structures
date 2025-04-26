// Purpose: 
//		This program will sort a simple integer array
//		using the radix sort algorithm.
//		Afterwards, it prints the result
// Reference : https://www.geeksforgeeks.org/radix-sort/
// Programmer: Carl Nikoi
// Date: Nov 2024

// Import Dependencies
import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
	
	//elements to print before and after sorting
    private static final int NUM_ELEMENTS_TO_PRINT = 50; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the RadixSort program!");
        System.out.println("This program will sort a simple integer array using the radix sort algorithm.");
        System.out.println("Let's get started!\n");

        //User input for number of integers and digits
        System.out.print("Please enter the number of integers to sort : ");
        int numIntegers = scanner.nextInt();

        System.out.print("Please enter the maximum number of digits : ");
        int numDigits = scanner.nextInt();

        // Generate an array of random integers
        System.out.println("\nGenerating an array of " + numIntegers + " integers...done.");
        
        // Test radix sort with user  values
        testRadixSort(numIntegers, numDigits);

        // Final Message
        System.out.println("\nWritten by Carl Nikoi, Fall 2024");

        // Close scanner
        scanner.close();
        
    } // main

    // Test radix sort with a specified number of integers and digits.
    private static void testRadixSort(int numIntegers, int numDigits) {
        System.out.println("\nHere are the first " + NUM_ELEMENTS_TO_PRINT + " elements BEFORE sorting:");

        // Generate an array of random integers
        int[] list = generateRandomArray(numIntegers);

        // Print first few elements before sorting
        printArraySample(list);

        // Measure sorting time using StopWatch
        StopWatch timer = new StopWatch();
        timer.start();
        
        // Sorting with radix sort
        radixSort(list, numDigits);  
        
        timer.stop();

        // Print first few elements after sorting
        System.out.println("\nHere are the first " + NUM_ELEMENTS_TO_PRINT + " elements AFTER sorting:");
        printArraySample(list);

        // Report sorting time in microseconds and seconds
        System.out.println("\nRadix sort took " + timer.getElapsedTime() + " microseconds to execute");
        System.out.println("Radix sort took " + (timer.getElapsedTime() / 1_000_000.0) + " seconds to execute");
        
    } // testRadixSort

    //Generate an array of random integers.
    private static int[] generateRandomArray(int size) {
        int[] list = new int[size];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int)(Math.random() * size);
        }
        return list;
     }//generateRandomArray

   // Print Array
    private static void printArraySample(int[] array) {
       for (int i = 0; i < Math.min(NUM_ELEMENTS_TO_PRINT, array.length); i++) {
           if (i % 10 == 0 && i > 0) System.out.println(); // Print in rows 
           System.out.printf("%5d ", array[i]);
       }
       System.out.println();
       
    } // printArraySample

   // Radix Sort Algorithm
    public static void radixSort(int[] list, int numberOfDigits) {
       // Find maximum number to determine number of digits
       int max = Arrays.stream(list).max().getAsInt();  
       int exp = 1;  // Exponent representing digit position

       while (max / exp > 0) {
           countingSortByDigit(list, exp);
           exp *= 10;
       }
       
    } // radixSort

    // Counting Based on exponent of digit
    private static void countingSortByDigit(int[] list, int exp) {
       // Output array
       int[] output = new int[list.length];  
       // Count array for digits
       int[] count = new int[10];            

       // Count each digit in current position
       for (int i = 0; i < list.length; i++) {
           count[(list[i] / exp) % 10]++;
       }

       // Update count
       for (int i = 1; i < count.length; i++) {
           count[i] += count[i - 1];
       }

       // Finalize Output Array
       for (int i = list.length - 1; i >= 0; i--) {
           output[count[(list[i] / exp) % 10] - 1] = list[i];
           count[(list[i] / exp) % 10]--;
       }

       // Copy sorted numbers back into original list
       System.arraycopy(output, 0, list, 0, list.length);
       
    } // countingSortByDigit
    
} // RadixSort

