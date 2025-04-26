// Purpose: 
//		This class implements the MyList interface and 
//		implements are the methods to mimic the LinkedList
//		class from the Java Collections Framework.
//		This class also implements a two-way linked list.
// Programmer: Warren Edwards
// Date: Oct 2024
//

import java.util.*;

public class TwoWayLinkedList<E> implements MyList<E> {
	// Data fields
	private Node<E> head, tail; //Will be null
	private int size = 0; // Number of elements in the list

	// No-arg Constructor
	//		Create an empty list
	public TwoWayLinkedList() {
	}//TwoWayLinkedList

	// Arg Constructor
	//		Create a list from an array of objects
	public TwoWayLinkedList(E[] objects) {
		// Loop, adding all the objects to the MyArrayList
		for (E e : objects)
    		add(e);
	}//TwoWayLinkedList

	// Method getFirst
	//		Return the head element in the list
	public E getFirst() {
		if (size == 0) {
			return null;
		}
		else {
			return head.element;
		}
	}//getFirst
    
	// Method getLast
	//		Return the tail(last) element in the list
	public E getLast() {
		if (size == 0) {
			return null;
		}
		else {
			return tail.element;
		}
	}//getLast

	// Method addFirst
	//		Add an element to the beginning of the list
	public void addFirst(E e) {
		// Create a new node
		Node<E> newNode = new Node<>(e); 
		
		// newNode will point to current head
		newNode.next = head;

		// Update head to point to new node
		head = newNode; 

		// Increase the size of the list
		size++; // Increase list size

		// If tail was null, then list was
		// empty before so head/tail point
		// to the new node
		if (tail == null) 
			tail = head;

		// For a two-way linked list
		// If head and tail are different, need to update 
		// the previous pointer of 2nd element to point to the 
		// new head we just inserted
		if (head != tail)
			head.next.previous = head; 
	}//addFirst

	// Method addLast
	//		Add an element to the end of the list
	public void addLast(E e) {
		// Create a new node
		Node<E> newNode = new Node<>(e); 
		
		// Keep track of current tail 
		// for two-way linked list
		Node<E> temp = tail; 

		// If the list is currently empty, just have
		// head and tail point to this new Node
		if (tail == null) {
			head = tail = newNode; 
		}//if
		
		// Otherwise, the current tail node will
		// point to the new node, and tail will
		// also point to the new node
		else {
			tail.next = newNode; // Link the new with the last node
			tail = newNode; // tail now points to the last node
		}//else

		// Increase the size of the list
		size++;

		// Set previous of new node to point to
		// the node that was last
		tail.previous = temp; 
	}//addLast

	// Method add
	//		Implement abstract method from the MyList interface
	//		Add a new element at the specified index
	//		The index of the head element is 0
	public void add(int index, E e) {
		// if wanting to add at the head, just call
		// addFirst method
		if (index == 0) {
			addFirst(e);
		}
		// Otherwise if index is greater
		// than or equal to current size, then
		// just call addLast method
		else if (index >= size) {
			addLast(e);
		}
		
		// Otherwise, add object in the middle
		else {
			// Create a pointer starting at head
			Node<E> current = head;
			
			// Loop from 1 to index-1, updating
			// current point as we traverse the list
			for (int i = 1; i < index; i++) {
				current = current.next;
			}
			
			// Insert the object after current pointer
			Node<E> temp = current.next;
			current.next = new Node<>(e);
			(current.next).next = temp;
			
			// Increase number of elements
			size++;

			// For a two-way linked list
			temp.previous = current.next;
			current.next.previous = current;
		}//else
	}//add

	// Method removeFirst
	//		Remove the head node and return the object 
	//		that is contained in the removed node
	public E removeFirst() {
		// If empty list, just return null
		if (size == 0) {
			return null;
		}

		// Otherwise, update head to point to 
		// the 2nd element
		else {
			E temp = head.element;
			head = head.next;
			
			// Update size of list
			size--;

			// if there was only one element
			// in the list, update tail to be same
			if (head == null) {
				tail = null;
			}//if
			
			// Otherwise, need to update previous
			// pointer on new head
			else 
				head.previous = null;
			
			// return the object that was at head
			return temp;
		}//else
	}//removeFirst

	// Method removeLast
	//		Remove the tail node and return the object 
	//		that is contained in the removed node
	public E removeLast() {
    	
		// If empty list, just return null
		if (size == 0) {
			return null;
		}
		
		// Otherwise, if only one element 
		// set head and tail to null and
		// return the object
		else if (size == 1) {
			E temp = head.element;
			head = tail = null;
			size = 0;
			return temp;
		}//else
		
		// Otherwise, remove last 
		// element and update tail
		// and new last element
		else {
			Node<E> current = head;

			// MODIFY for ASSIGNMENT #3 to be more efficient
			// Loop to get pointer to 2nd to last
			// element - not very efficient
			for (int i = 0; i < size - 2; i++) {
				current = current.next;
			}

			// Get the last element object
			// and update tail to 2nd last
			// element and decreasing size
			// of list by one
			E temp = tail.element;
			tail = current;
			tail.next = null;
			size--;
			return temp;
		}//else
	}//removeLast

	// Method remove
	//		Implement abstract method from the MyList interface
	// 		Remove the element at the specified position in 
	// 		this list. Return the element that was removed 
	//		from the list. 
	public E remove(int index) {
		// If not a valid index, return null
		if (index < 0 || index >= size) {
			return null;
		}
		
		// If first index, just call removeFirst
		else if (index == 0) {
			return removeFirst();
		}
		
		// If last index, just call removeLast
		else if (index == size - 1) {
			return removeLast();
		}

		// Otherwise, need to remove
		// element in the middle somewhere
		else {
			// Get pointer to previous node
			Node<E> previous = head;
			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}//for

			// Get the current node at index i
			// and point previous to node
			// that the current node is pointing to
			// so now no reference to current node
			Node<E> current = previous.next;
			previous.next = current.next;
			
			// Update previous pointer that the previous
			// node is now point to to point to previous
			current.next.previous = previous;
	
			// Update size and return the object
			// that was removed
			size--;
			return current.element;
		}//else
	}//remove

	// Method toString
	//		Override toString method 
	// 		Print out all the elements between square 
	//		brackets, seperated by commas.
	// 		in this list with the specified element.
	@Override 
	public String toString() {
		// Create a string starting with square bracket
		StringBuilder result = new StringBuilder("[");

		// Loop, adding each element to the string
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			
			// Loop, adding each element to the string
			if (current != null) {
				result.append(", "); 
			}//if
			
			// Otherwise, it was last element
			// so put closing bracket
			else {
				result.append("]"); 
			}//else
		}//for
	
	    return result.toString();
	}//toString

	// Method clear
	//		Override clear from the Collection interface
	//		Remove all elements from the collection
	@Override
	public void clear() {
		size = 0;
		head = tail = null;
	}//clear

	// Method contains
	//		Implement abstract method from the Collection interface
	//		Returns true of the collection contains object e
	//		ADD as part of Assignment #3
	public boolean contains(Object e) {
		System.out.println("\n*** 'contains' Implementation left as an exercise");
    	return true;
	}//contains

	// Method get
	//		Implement abstract method from the MyList interface
	//		Return the element at the specified index
	//		ADD as part of Assignment #3
	public E get(int index) {
		System.out.println("\n*** 'get' Implementation left as an exercise");
		return null;
	}//get

	// Method indexOf
	//		Implement abstract method from the MyList interface
	// 		Return the index of the first matching element
	//		in this list. Return -1 if no match
	//		ADD as part of Assignment #3
	public int indexOf(Object e) {
		System.out.println("\n*** 'indexOf' Implementation left as an exercise");
		return 0;
	}//indexOf

	// Method checkIndex
	//		Check if the index is valid and
	//		throw an exception if it is not
	//		ADD as part of Assignment #3
	private void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", "
					+ "Size: " + size);
	}//checkIndex

	// Method lastIndexOf
	//		Implement abstract method from the MyList interface
	// 		Return the index of the last matching element
	//		in this list. Return -1 if no match
	//		ADD as part of Assignment #3
	public int lastIndexOf(Object e) {
		System.out.println("\n*** 'lastIndexOf' Implementation left as an exercise");
		return 0;
	}//lastIndexOf

	// Method set
	//		Implement abstract method from the MyList interface
	// 		Replace the element at the specified position
	// 		in this list with the specified element.
	//		ADD as part of Assignment #3
	public E set(int index, E e) {
		System.out.println("\n*** 'set' Implementation left as an exercise");
		return null;
	}//set

	// Private inner class ArrayListIterator
	private class LinkedListIterator 
		implements java.util.ListIterator<E> {
		
		// Data fields
		private Node<E> current = head; // Current index 

		public LinkedListIterator() {
		}//LinkedListIterator
      
		public LinkedListIterator(int index) {
			// Check if valid index, throw exception if not
			checkIndex(index);

			for (int nextIndex = 0; nextIndex < index; nextIndex++)
				current = current.next;
		}//LinkedListIterator
      
		public void setLast() {
			current = tail;
		}//setLast
      
		// Method hasNext
		//		Implement abstract method from Iterator interface
		//		Return true if this iterator has more elements to
		//		traverse
		@Override
		public boolean hasNext() {
			return (current != null);
		}//hasNext

		// Method next
		//		Implement abstract method from Iterator interface
		//		Return next element 
		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}//next

		// Method remove
		//		Implement abstract method from Iterator interface
		//		Remove the element returned by the last next() 
		@Override
		public void remove() {
			System.out.println("\n*** 'LinkedListIterator:remove' Implementation left as an exercise");
		}//remove

		@Override
		public void add(E e) {
			System.out.println("\n*** 'LinkedListIterator:add' Implementation left as an exercise");
		}//add

		@Override
		public boolean hasPrevious() {
			return current != head;
		}//hasPrevious

		@Override
		public int nextIndex() {
			System.out.println("\n*** 'LinkedListIterator:nextIndex' Implementation left as an exercise");
			return 0;
		}//nextIndex

		@Override
		public E previous() {
			E e = current.element;
			current = current.previous;
			return e;
		}//previous

		@Override
		public int previousIndex() {
			System.out.println("\n*** 'LinkedListIterator:previousIndex' Implementation left as an exercise");
			return 0;
		}//previousIndex

		@Override
		public void set(E e) {
			current.element = e; 
		}//set
	}//LinkedListIterator

	// Private inner class Node
	private class Node<E> {
		E element;
		Node<E> next;
		Node<E> previous;

		// Arg constructor
		public Node(E o) {
			element = o;
		}
	}//Node

	// Method size
	//		Implement size method from the Collection interface
	//		Return the number of elements in this list
	@Override 
	public int size() {
		return size;
	}//size

	public ListIterator<E> listIterator() {
		return new LinkedListIterator(); 
	}//listIteerator
    
	public ListIterator<E> listIterator(int index) {
		return new LinkedListIterator(index); 
	}//listIterator

	@Override
	public Iterator<E> iterator() {
		return null;
	}//iterator
    
}//TwoWayLinkedList