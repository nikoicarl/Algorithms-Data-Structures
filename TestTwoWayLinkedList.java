// Purpose: 
//		This program tests the implementation of 
//		TwoWayLinkedList and compares its operation to
//		the actual LinkedList.
// Programmer: Warren Edwards
// Date: Oct 2024
//
import java.util.*;

public class TestTwoWayLinkedList {
  public static void main(String[] args) {
			
		// Print Welcome message
		System.out.println ("Welcome to the TestTwoWayLinkedList program!");
		System.out.println ("This program will test our implementation");
		System.out.println ("of TwoWayLinkedList and see how it compares");
		System.out.println ("to Linked List.");
		System.out.println ("Lets get started!\n");
		
		// Create two lists list
		TwoWayLinkedList<String> list = new TwoWayLinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();

		// Add elements to the list
		System.out.println("Adding elements to the list....");
		
		 // Add it to the end of the list
		list.add("Chicago"); 
		System.out.println("\t(1a) " + list);
		list2.add("Chicago"); 
		System.out.println("\t(1b) " + list2);
		
		// Add it to the beginning of the list
		list.add(0, "Vancouver"); 
		System.out.println("\t(2a) " + list);
		list2.add(0, "Vancouver"); 
		System.out.println("\t(2b) " + list2);

		 // Add it to the end of the list
		list.add("Vancouver"); 
		System.out.println("\t(3a) " + list);
		list2.add("Vancouver"); 
		System.out.println("\t(3b) " + list2);

		 // Add it to the end of the list
		list.addLast("Seattle"); 
		System.out.println("\t(4a) " + list);
		list2.addLast("Seattle"); 
		System.out.println("\t(4b) " + list2);

		// Add it to the list at index 2
		list.add(2, "Montreal"); 
		System.out.println("\t(5a) " + list);
		list2.add(2, "Montreal"); 
		System.out.println("\t(5b) " + list2);

		// Add it to the list at index 5
		list.add(5, "Oslo"); 
		System.out.println("\t(6a) " + list);
		list2.add(5, "Oslo");
		System.out.println("\t(6b) " + list2);
		
		// Add it to the list at index 0
		list.addFirst("New York"); 
		System.out.println("\t(7a) " + list);
		list2.addFirst("New York"); 
		System.out.println("\t(7b) " + list2);
		
		// Add it to the second to last of list
		list.add(list.size()-2, "Montreal"); 
		System.out.println("\t(8a) " + list);
		list2.add(list2.size()-2, "Montreal"); 
		System.out.println("\t(8b) " + list2);

		// Remove elements from the list
		System.out.println("\nRemoving elements from the list....");
		
		// Remove element at index 0
		System.out.println("Removing " + list.removeFirst()); 
		System.out.println("\t(9a) " + list);
		System.out.println("Removing " + list2.removeFirst());
		System.out.println("\t(9b) " + list2);

		// Remove element at index 2
		System.out.println("Removing " + list.remove(2)); 
		System.out.println("\t(10a) " + list);
		System.out.println("Removing " + list2.remove(2)); 
		System.out.println("\t(10b) " + list2);

		// Remove the last element
		System.out.println("Removing " + list.removeLast()); 
		System.out.println("\t(11a) " + list);		
		System.out.println("Removing " + list2.removeLast()); 
		System.out.println("\t(11b) " + list2);
		
		// Test contains method
		System.out.println("\nChecking contains method....");
		System.out.println("\t(12a) List does " 
				+ (list.contains("Vancouver")? "" : "NOT ") + "contain Vancouver");
		System.out.println("\t(12b) List2 does " 
				+ (list2.contains("Vancouver")? "" : "NOT ") + "contain Vancouver");
		
		System.out.println("\t(13a) List does " 
				+ (list.contains("Oslo")? "" : "NOT ") + "contain Oslo");
		System.out.println("\t(13b) List2 does " 
				+ (list2.contains("Oslo")? "" : "NOT ") + "contain Oslo");
		
		// Test get method with index in bound
		System.out.println("\nChecking get method....");
		System.out.println("\t(14a) Element at index 0 is " + list.get(0));
		System.out.println("\t(14b) Element at index 0 is " + list2.get(0));
		
		// Test get method with index out of bound - since
		// throws an exception, need to wrap around try-catch block
		try {
			System.out.print("\t(15a) Element at index 5 is ");
			System.out.println(list.get(5));
		}
		catch (Exception ex) {
			System.out.println("\n\t" + ex);
		}// catch
		try {
			System.out.print("\t(15b) Element at index 5 is ");
			System.out.println(list2.get(5));
		}
		catch (Exception ex) {
			System.out.println("\n\t" + ex);
		}// catch

		// Test indexOf method
		System.out.println("\nTesting indexOf method....");
		System.out.println("\t(16a) Index of Vancouver is " + list.indexOf("Vancouver"));
		System.out.println("\t(16b) Index of Vancouver is " + list2.indexOf("Vancouver"));
		System.out.println("\t(17a) Index of Montreal is " + list.indexOf("Montreal"));
		System.out.println("\t(17b) Index of Montreal is " + list2.indexOf("Montreal"));
		System.out.println("\t(18a) Index of New York is " + list.indexOf("New York"));
		System.out.println("\t(18b) Index of New York is " + list2.indexOf("New York"));
		
		// Test lastIndexOf method
		System.out.println("\nTesting lastIndexOf method....");
		System.out.println("\t(19a) Last index of Vancouver is " + list.lastIndexOf("Vancouver"));
		System.out.println("\t(19b) Last index of Vancouver is " + list2.lastIndexOf("Vancouver"));
		System.out.println("\t(20a) Last index of Montreal is " + list.lastIndexOf("Montreal"));
		System.out.println("\t(20b) Last index of Montreal is " + list2.lastIndexOf("Montreal"));
		System.out.println("\t(21a) Last index of Seattle is " + list.lastIndexOf("Seattle"));
		System.out.println("\t(21b) Last index of Seattle is " + list2.lastIndexOf("Seattle"));
		
		// Test set method
		System.out.println("\nTesting set method....");
		System.out.println("\t(22a) Setting index 1 to Dallas replacing " 
				+ list.set(1, "Dallas") + ": " + list);
		System.out.println("\t(22b) Setting index 1 to Dallas replacing " 
				+ list2.set(1, "Dallas") + ": " + list2);
		
		// Test set method with index out of bound - since
		// throws an exception, need to wrap around try-catch block
		try {
			System.out.print("\t(23a) Setting index 5 to Oslo replacing ");
			System.out.println(list.set(5, "Oslo") + ": " + list);
		}
		catch (Exception ex) {
			System.out.println("\n\t" + ex);
		}// catch
		try {
			System.out.print("\t(23b) Setting index 5 to Oslo replacing ");
			System.out.println(list2.set(5, "Oslo") + ": " + list2);
		}
		catch (Exception ex) {
			System.out.println("\n\t" + ex);
		}// catch
		
		// Print out final message
		System.out.println("\nWritten by Warren Edwards, Fall 2024");
			
	}//main

}//TestTwoWayLinkedList
