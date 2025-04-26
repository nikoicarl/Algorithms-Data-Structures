// Purpose: 
//		This program tests the implementation of 
//		MyLinkedList and compares its operation to
//		the actual LinkedList.
// Programmer: Warren Edwards
// Date: Oct 2024
//
import java.util.*;

public class CompleteTestMyLinkedList {
	public static void main(String[] args) {
		
		// Print Welcome message
		System.out.println ("Welcome to the TestMyLinkedList program!");
		System.out.println ("This program will test our implementation");
		System.out.println ("of MyLinkedList and see how it compares");
		System.out.println ("to LinkedyList.");
		System.out.println ("Lets get started!\n");
		
		// Create two lists list
		MyLinkedList<String> list = new MyLinkedList<String>();
		LinkedList<String> list2 = new LinkedList<String>();

		// Add elements to the list
		System.out.println("Adding elements to the list....");
		
		// Add it to the end of the list
		list.add("America"); 
		System.out.println("\t(1a) " + list);
		list2.add("America"); 
		System.out.println("\t(1b) " + list2);
		
		// Add it to the beginning of the list
		list.add(0, "Canada"); 
		System.out.println("\t(2a) " + list);
		list2.add(0, "Canada"); 
		System.out.println("\t(2b) " + list2);

		// Add it to the end of the list
		list.add("Russia");
		System.out.println("\t(3a) " + list);
		list2.add("Russia");
		System.out.println("\t(3b) " + list2);

		// Add it to the end of the list
		list.addLast("France"); 
		System.out.println("\t(4a) " + list);
		list2.addLast("France"); 
		System.out.println("\t(4b) " + list2);

		// Add it to the list at index 2
		list.add(2, "Germany"); 
		System.out.println("\t(5a) " + list);
		list2.add(2, "Germany"); 
		System.out.println("\t(5b) " + list2);

		// Add it to the list at index 5
		list.add(5, "Norway"); 
		System.out.println("\t(6a) " + list);
		list2.add(5, "Norway"); 
		System.out.println("\t(6b) " + list2);
		
		// Add it to the list at index 0
		list.addFirst("Poland");
		System.out.println("\t(7a) " + list);
		list2.addFirst("Poland");
		System.out.println("\t(7b) " + list2);
		
		// Add it to the second to last of list
		list.add(list.size()-2, "Canada"); 
		System.out.println("\t(8a) " + list);
		list2.add(list2.size()-2, "Canada"); 
		System.out.println("\t(8b) " + list2);

		// Remove elements from the list
		System.out.println("\nRemoving elements from the list....");
		
		// Remove element at index 0
		System.out.println("Removing " + list.removeFirst()); 
		System.out.println("\t(9a) " + list);
		System.out.println("Removing " + list2.removeFirst()); 
		System.out.println("\t(9b) " + list2);

		// Remove the element at index 2
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
				+ (list.contains("Canada")? "" : "NOT ") + "contain Canada");
		System.out.println("\t(12b) List does " 
					+ (list2.contains("Canada")? "" : "NOT ") + "contain Canada");
		
		System.out.println("\t(13a) List does " 
				+ (list.contains("Norway")? "" : "NOT ") + "contain Norway");
		System.out.println("\t(13b) List does " 
				+ (list2.contains("Norway")? "" : "NOT ") + "contain Norway");
		
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
		System.out.println("\t(16a) Index of Canada is " + list.indexOf("Canada"));
		System.out.println("\t(16b) Index of Canada is " + list2.indexOf("Canada"));
		System.out.println("\t(17a) Index of France is " + list.indexOf("France"));
		System.out.println("\t(17b) Index of France is " + list2.indexOf("France"));
		System.out.println("\t(18a) Index of Norway is " + list.indexOf("Norway"));
		System.out.println("\t(18b) Index of Norway is " + list2.indexOf("Norway"));
		
		// Test lastIndexOf method
		System.out.println("\nTesting lastIndexOf method....");
		System.out.println("\t(19a) Last index of Canada is " + list.lastIndexOf("Canada"));
		System.out.println("\t(19b) Last index of Canada is " + list2.lastIndexOf("Canada"));
		System.out.println("\t(20a) Last index of France is " + list.lastIndexOf("France"));
		System.out.println("\t(20b) Last index of France is " + list2.lastIndexOf("France"));
		System.out.println("\t(21a) Last index of America is " + list.lastIndexOf("America"));
		System.out.println("\t(21b) Last index of America is " + list2.lastIndexOf("America"));
		
		// Test set method
		System.out.println("\nTesting set method....");
		System.out.println("\t(22a) Setting index 1 to USA replacing " 
				+ list.set(1, "USA") + ": " + list);
		System.out.println("\t(22b) Setting index 1 to USA replacing " 
					+ list2.set(1, "USA") + ": " + list2);
		
		// Test set method with index out of bound - since
		// throws an exception, need to wrap around try-catch block
		try {
			System.out.print("\t(23a) Setting index 5 to Norway replacing ");
			System.out.print(list.set(5, "Norway") + ": " + list);
		}
		catch (Exception ex) {
			System.out.println("\n\t" + ex);
		}// catch
		try {
			System.out.print("\t(23b) Setting index 5 to Norway replacing ");
			System.out.print(list2.set(5, "Norway") + ": " + list2);
		}
		catch (Exception ex) {
			System.out.println("\n\t" + ex);
		}// catch
		
		// Print out final message
		System.out.println("\nWritten by Warren Edwards, Fall 2024");
		
	}//main
	
}//CompleteTestMyLinkedList