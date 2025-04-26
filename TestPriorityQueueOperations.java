// Purpose: 
//		This program  create two PriorityQueues 
//      and performs a set of operations on them.
//  	The set operations are (union, difference, intersection)
//		Afterwards, it prints the result

// Programmer: Carl Nikoi
// Date: Oct 2024

// Import Dependencies
import java.util.*;

public class TestPriorityQueueOperations {

    public static void main(String[] args) {
    	
        // Print Welcome message
        System.out.println("Welcome to the TestPriorityQueueOperations program!");
        System.out.println("This program will create two priority queues");
        System.out.println("and perform set operations union, difference and intersection on them.");
        System.out.println("The results will be printed");
        System.out.println("in priority order (requires special printPriorityOrder as a simple println will not print priority order.");
        System.out.println("Let's get started!\n");

        // Create a priority queue1 with 7 strings
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        queue1.offer("George");
        queue1.offer("Jim");
        queue1.offer("John");
        queue1.offer("Blake");
        queue1.offer("Kevin");
        queue1.offer("Michael");
        queue1.offer("David");

        // Create a priority queue2 with 6 strings
        PriorityQueue<String> queue2 = new PriorityQueue<>();
        queue2.offer("George");
        queue2.offer("Katie");
        queue2.offer("Kevin");
        queue2.offer("Thatcher");
        queue2.offer("Ryan");
        queue2.offer("George");

        // Print queues using println and printPriorityOrder
        System.out.println("Priority queue #1:");
        System.out.println("\tPrinting using println: " + queue1);
        System.out.print("\tPrinting using printPriorityOrder: ");
        printPriorityOrder(new PriorityQueue<>(queue1));

        System.out.println("\nPriority queue #2:");
        System.out.println("\tPrinting using println: " + queue2);
        System.out.print("\tPrinting using printPriorityOrder: ");
        printPriorityOrder(new PriorityQueue<>(queue2));

        // Perform set operations
        System.out.println("\nSet Operations:");

        // Set Union
        PriorityQueue<String> union = new PriorityQueue<>(queue1);
        union.addAll(queue2);
        System.out.print("The Union of the two Priority Queues: ");
        printPriorityOrder(union);

        //Set Difference
        PriorityQueue<String> difference = new PriorityQueue<>(queue1);
        difference.removeAll(queue2);
        System.out.print("The Difference of the two Priority Queues: ");
        printPriorityOrder(difference);

        // Set Intersection
        PriorityQueue<String> intersection = new PriorityQueue<>(queue1);
        intersection.retainAll(queue2);
        System.out.print("The Intersection of the two Priority Queues:  ");
        printPriorityOrder(intersection);

        // Print out final message
        System.out.println("\nWritten by Carl Nikoi, Fall 2024");
        
    } //main

    public static void printPriorityOrder(PriorityQueue<String> queue) {
        if (queue.isEmpty()) {
            System.out.println("[]"); // Print empty brackets when it is empty
            return;
        }

        StringBuilder output = new StringBuilder();
        output.append("["); // Start the list  with a "["

        while (!queue.isEmpty()) {
            output.append(queue.poll());
            if (!queue.isEmpty()) {
                output.append(", "); // Append a comma
            }
        }

        output.append("]"); // Close the list  with a "]"
        System.out.println(output.toString()); // Print the final output
        
    } // printPriorityOrder

    
} // TestPriorityQueueOperations
