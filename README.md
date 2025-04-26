# Java Algorithms and Data Structures Project

This repository contains a wide range of Java programs demonstrating core computer science concepts, including data structures, sorting algorithms, file processing, recursion, and performance benchmarking. All programs were developed in Fall 2024.

---

## 📂 Contents

### 🔁 Linked Lists

- **`CompleteTestMyLinkedList.java`**  
  Tests a custom singly linked list (`MyLinkedList`) by comparing it to Java’s built-in `LinkedList`.

- **`TwoWayLinkedList.java`**  
  A custom doubly linked list implementing core list operations.

- **`TestTwoWayLinkedList.java`**  
  A test suite comparing `TwoWayLinkedList` to Java’s `LinkedList` class.

---

### 🔠 Hash Maps

- **`TestMyHashMapLinearProbe.java`**  
  Tests a custom hash map with linear probing against Java's `HashMap`.

---

### 🔽 Heaps and Priority Queues

- **`Heap.java`**  
  A binary max-heap implemented with an `ArrayList`.

- **`TestPriorityQueueOperations.java`**  
  Performs union, intersection, and difference operations on two Java `PriorityQueue` instances.

---

### 🧵 List Traversal & Performance

- **`TraverseList.java`**  
  Compares traversal speeds of `ArrayList` and `LinkedList` using `.get(index)` vs. iterators.

---

### 🧮 Math & Algorithms

- **`Exponentiation.java`**  
  Calculates exponents using:
  - `Math.pow`
  - Recursive exponentiation by squaring  
  - Iterative exponentiation by squaring  

- **`SumConsecutiveIntegers.java`**  
  Computes the sum from `m` to `n` using:
  - A loop (O(n))  
  - Closed-form formula (O(1))

---

### 🔢 Sorting

- **`RadixSort.java`**  
  Implements radix sort on randomly generated integers and measures its performance.

- **`SortShowdown.java`**  
  Benchmarks seven sorting algorithms:  
  - Selection  
  - Insertion  
  - Bubble  
  - Merge  
  - Quick  
  - Heap  
  - Radix  
  Color-coded output highlights fastest and slowest methods.

---

### 📁 File I/O & Strings

- **`CountVowels.java`**  
  Prompts the user for a text file and counts vowels (A, E, I, O, U) case-insensitively.

- **`PrintStringReversed.java`**  
  Recursively reverses a user-input string.

---

### 🎨 Recursion & Graphics

- **`SierpinskiTriangle.java`**  
  Uses JavaFX to draw the Sierpinski triangle recursively based on user-specified order.

---

### ⏱️ Utilities

- **`StopWatch.java`**  
  A simple utility to measure elapsed execution time in microseconds.

---

## ▶️ How to Run

1. **Clone the Repo**
   ```bash
   git clone https://github.com/yourusername/java-algorithms-project.git
   cd java-algorithms-project
