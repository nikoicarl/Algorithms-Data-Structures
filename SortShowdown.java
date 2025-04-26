// Purpose: 
//		This program will compare
//		the performance of seven sorting algorithms (Selection, Insertion, 
// 		Bubble, Merge, Quick, Heap, and Radix Sort) using arrays of increasing sizes. 
// 		Displays execution times in a color-coded table for easy comparison
//
// Reference for selection sort algorithm : https://www.programiz.com/dsa/selection-sort
// Reference for colors : https://www.tutorialspoint.com/how-to-print-colored-text-in-java-console
// Programmer: Carl Nikoi
// Date: Nov 2024


// Import Dependencies
import java.util.Arrays;
import java.util.Random;

public class SortShowdown {
    // Constants
    private static final int NUM_TESTS = 10;
    private static final int NUM_SORT_ALGORITHMS = 7;
    private static final int NUM_INTEGERS = 5000;
    private static final int RANDOM_NUM_MAX = 1000000;
    private static final int NUM_DIGITS = 6;

    public static void main(String[] args) {
        // Print welcome message
        System.out.println("Welcome to the SortShowdown program!");
        System.out.println("This program will compare the performance of 7 sorting algorithms to see how they perform.");
        System.out.println("We test each algorithm with different sized arrays filled with random numbers.");
        System.out.println("Finally, the results are printed out (in microseconds) and");
        System.out.println("the fastest times are highlighted in green and the slowest times are highlighted in red.");
        System.out.println("Lets get started!\n");

        // Print table header
        System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                "Array", "Selection", "Insertion", "Bubble", "Merge", "Quick", "Heap", "Radix");
        System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
                "Size", "Sort", "Sort", "Sort", "Sort", "Sort", "Sort", "Sort");

        // Main loop to run tests for different array sizes
        for (int k = 0; k < NUM_TESTS; k++) {
            int size = NUM_INTEGERS * (k + 1);
            int[] originalArray = generateRandomArray(size);
            long[] times = new long[NUM_SORT_ALGORITHMS];

            // Test Selection Sort
            int[] arr1 = Arrays.copyOf(originalArray, originalArray.length);
            times[0] = measureSortingTime(() -> selectionSort(arr1));

            // Test Insertion Sort
            int[] arr2 = Arrays.copyOf(originalArray, originalArray.length);
            times[1] = measureSortingTime(() -> insertionSort(arr2));

            // Test Bubble Sort
            int[] arr3 = Arrays.copyOf(originalArray, originalArray.length);
            times[2] = measureSortingTime(() -> bubbleSort(arr3));

            // Test Merge Sort
            int[] arr4 = Arrays.copyOf(originalArray, originalArray.length);
            times[3] = measureSortingTime(() -> mergeSort(arr4));

            // Test Quick Sort
            int[] arr5 = Arrays.copyOf(originalArray, originalArray.length);
            times[4] = measureSortingTime(() -> quickSort(arr5));

            // Test Heap Sort
            int[] arr6 = Arrays.copyOf(originalArray, originalArray.length);
            times[5] = measureSortingTime(() -> heapSort(arr6));

            // Test Radix Sort
            int[] arr7 = Arrays.copyOf(originalArray, originalArray.length);
            times[6] = measureSortingTime(() -> radixSort(arr7, NUM_DIGITS));

            // Verify if all the arrays are properly sorted 
            boolean allSorted = isSorted(arr1) && isSorted(arr2) && isSorted(arr3) &&
                    isSorted(arr4) && isSorted(arr5) && isSorted(arr6) && isSorted(arr7);
            if (!allSorted) {
                System.out.println("Not all arrays were sorted");
                continue;
            }

            // Find the minimum and maximum times
            long minTime = Arrays.stream(times).min().getAsLong();
            long maxTime = Arrays.stream(times).max().getAsLong();

            // Print results with colors
            System.out.printf("%-10d ", size);
            for (long time : times) {
                if (time == minTime) {
                    System.out.printf("\u001B[32m%-15d\u001B[0m ", time); // Green for fastest
                } else if (time == maxTime) {
                    System.out.printf("\u001B[31m%-15d\u001B[0m ", time); // Red for slowest
                } else {
                    System.out.printf("%-15d ", time); // Default color
                }
            }
            System.out.println();
        }

        System.out.println("\nWritten by Carl Nikoi, Fall 2024");
    }

    // Helper method to verify if an array is sorted
    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    } // isSorted

    // Helper method to generate random array
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(RANDOM_NUM_MAX);
        }
        return arr;
        
    } // generateRandomArray

    // Helper method to measure sorting time using StopWatch 
    private static long measureSortingTime(Runnable sortMethod) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        sortMethod.run();
        stopWatch.stop();
        return stopWatch.getElapsedTime();
    } // measureSortingTime

    // Selection Sort implementation
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    } // selectionSort

    // Insertion Sort implementation
    public static void insertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }
    } // insertionSort

    // Bubble Sort implementation
    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    } // bubbleSort

    // Merge Sort implementation
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // Split the array into two halves
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge the two sorted halves
            merge(firstHalf, secondHalf, list);
        }
    } // mergeSort

    // Helper method for merging two sorted arrays
    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            temp[current3++] = list1[current1++];

        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
        
    } // merge helper method

    // Quick Sort implementation
    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
        
    } // quickSort

    private static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    } // quickSort

    private static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;

        while (high > low) {
            while (low <= high && list[low] <= pivot)
                low++;

            while (low <= high && list[high] > pivot)
                high--;

            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    } // partition

    // Heap Sort implementation
    public static void heapSort(int[] arr) {
        Heap<Integer> heap = new Heap<>();
        // Add all elements to the heap
        for (int num : arr) {
            heap.add(num);
        }

        // Remove elements from the heap in descending order
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = heap.remove();
        }
    } // heapSort

 // Radix Sort implementation
    public static void radixSort(int[] list, int numberOfDigits) {
        if (list == null || list.length < 2) return;
        
        // Find minimum and maximum values
        int min = list[0];
        int max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] < min) min = list[i];
            if (list[i] > max) max = list[i];
        }
        
        // Handle negative numbers by making all numbers positive
        // We'll add back the offset at the end
        int offset = (min < 0) ? -min : 0;
        for (int i = 0; i < list.length; i++) {
            list[i] += offset;
        }
        
        // Pre-allocate arrays for better performance
        int[] output = new int[list.length];
        int[] count = new int[10];  // Decimal system has 10 digits
        
        // Do counting sort for every digit
        int exp = 1;
        int maxValue = max + offset;
        
        while (maxValue / exp > 0) {
            // Clear count array
            Arrays.fill(count, 0);
            
            // Store count of occurrences
            for (int i = 0; i < list.length; i++) {
                count[(list[i] / exp) % 10]++;
            }
            
            // Modify count array to contain actual positions
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            
            // Build the output array
            for (int i = list.length - 1; i >= 0; i--) {
                int digit = (list[i] / exp) % 10;
                output[count[digit] - 1] = list[i];
                count[digit]--;
            }
            
            // Copy output array to input array
            System.arraycopy(output, 0, list, 0, list.length);
            
            exp *= 10;
        }
        
        // Restore the offset to get back original numbers
        if (offset > 0) {
            for (int i = 0; i < list.length; i++) {
                list[i] -= offset;
            }
        }
    } // radixSort
    
    
} // SortShowdown