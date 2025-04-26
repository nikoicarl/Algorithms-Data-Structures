// Purpose: 
// The purpose of this program is to test the traversal speed
// using the ArrayList and LinkedList class
// Programmer: Carl Ashie Nikoi
// Date: Sept 2024

// Import ArrayList , LinkedList and Iterator
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class TraverseList {
    private static final int NUM_INTEGERS = 2000000;

    public static void main(String[] args) {
    	System.out.println("Welcome to the TraverseList program!");
        System.out.println("The purpose of this program is to test ");
        System.out.println("the traversal speed using the ArrayList and the LinkedList classes.");
        System.out.println("Two large lists of " + NUM_INTEGERS + " integers (one in an ArrayList and ");
        System.out.println("one in a LinkedList) is generated ");
        System.out.println("and the time to traverse these two lists using two different methods is measured.");
        System.out.println("The two different traversal methods will be:");
        System.out.println("1. Using the 'get(index)' method");
        System.out.println("2. Using the iterator object for each list\n");
        
        
        // Create an ArrayList and add integers sequentially
        ArrayList<Integer> arrayList = new ArrayList<>();
        
		// Create a LinkedList of objects, based on the arrayList collect
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Populate Array and Linked Lists
        for (int i = 0; i < NUM_INTEGERS; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Test LinkedList with get(index)
        System.out.println("First we will test traversal using the get(index) method....");
        
        
        // Initialize Stop Watch
        StopWatch timer = new StopWatch();
        timer.start();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        
        // Stop Timer
        timer.stop();
        
        // Print time in milliseconds and seconds
        System.out.printf("For LinkedList:\nThe traverse time using get(index) in milliseconds is %d milliseconds.\n", timer.getElapsedTime());
        System.out.printf("The traverse time using get(index) in seconds is %.1f seconds.\n\n", timer.getElapsedTime() / 1000.0);

        // Test ArrayList with get(index)
        timer.start();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
        timer.stop();
        
        // Print time in milliseconds and seconds
        System.out.printf("For ArrayList:\nThe traverse time using get(index) in milliseconds is %d milliseconds.\n", timer.getElapsedTime());
        System.out.printf("The traverse time using get(index) in seconds is %.3f seconds.\n\n", timer.getElapsedTime() / 1000.0);

        // Test LinkedList with Iterator
        System.out.println("Next we will test traversal using an iterator....");
        
        timer.start();
        Iterator<Integer> linkedIterator = linkedList.iterator();
        while (linkedIterator.hasNext()) {
            linkedIterator.next();
        }
        
        //Stop Timer
        timer.stop();
        
        // Print time in milliseconds and seconds
        System.out.printf("For LinkedList:\nThe traverse time using iterator in milliseconds is %d milliseconds.\n", timer.getElapsedTime());
        System.out.printf("The traverse time using iterator in seconds is %.3f seconds.\n\n", timer.getElapsedTime() / 1000.0);

        // Test ArrayList with Iterator
        timer.start();
        
        Iterator<Integer> arrayIterator = arrayList.iterator();
        while (arrayIterator.hasNext()) {
            arrayIterator.next();
        }
        
        //Stop Timer
        timer.stop();
        
        // Print time in milliseconds and seconds
        System.out.printf("For ArrayList:\nThe traverse time using iterator in milliseconds is %d milliseconds.\n", timer.getElapsedTime());
        System.out.printf("The traverse time using iterator in seconds is %.3f seconds.\n\n", timer.getElapsedTime() / 1000.0);

        // Print out final message
        System.out.println("Written by Carl Nikoi, Fall 2024");
        
        
    } // main
} // TraverseList Class