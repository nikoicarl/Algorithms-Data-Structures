// Purpose: 
//		This program tests our implementation of 
//		myHashMap by adding key/value pairs and
//		testing various methods.  Also we compare
//		its output to HashMap to verify implementation.
// Programmer: Warren Edwards
// Date: Nov 2024
//
import java.util.*;

public class TestMyHashMapLinearProbe {
	
  public static void main(String[] args) {
	  
		// Print Welcome message
		System.out.println ("Welcome to the TestMyHashMapLinearProbe program!");
		System.out.println ("This program will test our implementation");
		System.out.println ("of MyHashMapLinearProbe and see how it compares");
		System.out.println ("to HashMap.");
		System.out.println ("Lets get started!\n");

		// Create a HashMap
		MyMap<String, Integer> map = new MyHashMapLinearProbe<>(8, 0.75f);
		Map<String, Integer> map2 = new HashMap<>(8, 0.75f);
		
		// Add elements to the list
		System.out.println("Adding elements to the list....");
		
		// Add elements to the map
		map.put("Bridget", 30);
		System.out.println("\t(1a) " + map);
		map2.put("Bridget", 30);
		System.out.println("\t(1b) " + map2);
		map.put("Andrew", 31);
		System.out.println("\t(2a) " + map);
		map2.put("Andrew", 31);
		System.out.println("\t(2b) " + map2);
		map.put("Percy", 29);
		System.out.println("\t(3a) " + map);
		map2.put("Percy", 29);
		System.out.println("\t(3b) " + map2);
		map.put("Val", 29);
		System.out.println("\t(4a) " + map);
		map2.put("Val", 29);
		System.out.println("\t(4b) " + map2);
		
		// Print out the key set for this map
		System.out.println("\nGetting the key set...");
		System.out.println("\t(5a) " + map.keySet());
		System.out.println("\t(5b) " + map2.keySet());

		// Print out the value set for this map
		System.out.println("\nGetting the value set...");
		System.out.println("\t(6a) " + map.values());
		System.out.println("\t(6b) " + map2.values());

		// Test get method
		System.out.println("\nChecking get method....");
		System.out.println("\t(7a) The age for " + "Andrew is " +
				map.get("Andrew"));
		System.out.println("\t(7b) The age for " + "Andrew is " +
				map2.get("Andrew"));

		// Test containsKey and containsValue method
		System.out.println("\nChecking contains methods....");
		System.out.println("\t(8a)Is Percy in the map? " + 
				map.containsKey("Percy"));
		System.out.println("\t(8b)Is Percy in the map? " + 
				map2.containsKey("Percy"));		
		System.out.println("\t(9a)Is age 33 in the map? " + 
				map.containsValue(33));
		System.out.println("\t(9b)Is age 33 in the map? " + 
				map2.containsValue(33));

		// Test removing entries
		System.out.println("\nChecking remove method....");
		map.remove("Andrew");
		System.out.println("\t(10a)Entries in map: " + map);
		map2.remove("Andrew");
		System.out.println("\t(10b)Entries in map: " + map2);
		
		// Test adding entries
		System.out.println("\nChecking add method....");
		map.put("Florence", 86);
		System.out.println("\t(11a)Entries in map: " + map);
		map2.put("Florence", 86);
		System.out.println("\t(11b)Entries in map: " + map2);
		map.put("Jack", 17);
		System.out.println("\t(12a)Entries in map: " + map);
		map2.put("Jack", 17);
		System.out.println("\t(12b)Entries in map: " + map2);
		map.put("Warren", 60);
		System.out.println("\t(13a)Entries in map: " + map);
		map2.put("Warren", 60);
		System.out.println("\t(13b)Entries in map: " + map2);
		map.put("Mary", 94);
		System.out.println("\t(14a)Entries in map: " + map);
		map2.put("Mary", 94);
		System.out.println("\t(14b)Entries in map: " + map2);
		map.put("Cade", 23);
		System.out.println("\t(15a)Entries in map: " + map);
		map2.put("Cade", 23);
		System.out.println("\t(15b)Entries in map: " + map2);
		map.put("Raven", 21);
		System.out.println("\t(16a)Entries in map: " + map);
		map2.put("Raven", 21);
		System.out.println("\t(16b)Entries in map: " + map2);
		
		// Test clearing map
		System.out.println("\nChecking clear method....");
		map.clear();
		System.out.println("\t(17a) Entries in map: " + map);
		map2.clear();
		System.out.println("\t(17b) Entries in map: " + map2);
		
		// Print out final message
		System.out.println("\nWritten by Warren Edwards, Fall 2024");
		
	}//main

}//TestMyHashMap