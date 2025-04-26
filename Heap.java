// Purpose: 
//      The Heap class is used to implement a
//      binary heap. The heap class will use an
//      ArrayList to store objects in the heap.
//      Any object in the heap must implement the
//      Comparable interface so objects can
//      be compared and the heap property maintained.
// Programmer: Warren Edwards
// Date: Oct 2024
//

public class Heap<E extends Comparable<E>> {

    // Implement the heap using an ArrayList
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    // No-arg constructor
    public Heap() {
    }

    // Arg constructor - create a heap 
    // from an array of objects passed in
    public Heap(E[] objects) {
        // Loop through all objects and add them
        // to the heap
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    // Method add
    //      Add a new object into the heap
    public void add(E newObject) {
        // Append the object to the end of the heap
        // and note the index of the last node
        list.add(newObject);
        int currentIndex = list.size() - 1;

        // Loop comparing the newObject to its parent and
        // swapping with parent if it is smaller
        while (currentIndex > 0) {

            // Get index of parent
            int parentIndex = (currentIndex - 1) / 2;

            // Swap if the current object is greater than its parent
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else {
                // Otherwise, the current object is less than or equal to parent,
                // so tree is a heap now, break out of the while loop
                break;
            }

            // Update currentIndex to parentIndex since we swapped with parent
            currentIndex = parentIndex;
        }
    }

    // Method remove
    //      Remove the root from the heap
    public E remove() {

        // If the list is empty, then no objects to remove, return null
        if (list.size() == 0)
            return null;

        // Get the root object (the largest element)
        E removedObject = list.get(0);

        // Move the last element into the root position and remove it from end of heap
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        // Loop comparing new root to its children and swapping with larger child if necessary
        int currentIndex = 0;
        while (currentIndex < list.size()) {

            // Calculate child indices
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // If there is no left child, we are done (tree is a heap)
            if (leftChildIndex >= list.size())
                break;

            // Find maximum between two children (if right child exists)
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if current node is less than largest child
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else {
                break; // Tree is a heap now, exit loop
            }
        }

        return removedObject;
    }

    // Method getSize
    //      Get the number of nodes in the tree 
    public int getSize() {
        return list.size();
    }
}