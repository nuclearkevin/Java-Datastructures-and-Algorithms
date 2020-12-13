// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
// Based on my midterm submission for CSCI-2010U, but with generics.
package ds;
public class LinkedQueue<T> {
    private Node front;
    private int numStored;

    // Inner class to store queue data!
    public class Node {
        T nodeData;
        Node next;

        private Node (T nodeData) {
            this.nodeData = nodeData;
            this.next = null;
        }
        public String toString() {
            return this.nodeData.toString();
        }
    }
    public LinkedQueue () {
        this.front = null;
        this.numStored = 0;
    }

    // Method to check if the queue is empty or not.
    public boolean isEmpty () {
        if (this.front == null) {
            return true;
        } else {
            return false;
        }
    }

    // Fetches the data from the front element.
    public String frontElement() {
        return this.front.toString();
    }

    // Queues a new element.
    public void enqueue(T nodeData) {
        Node newNode = new Node(nodeData);

        if (this.front == null) {
            // Insert at the front for an empty list.
            this.front = newNode;
        } else {
            // Walk the queue.
            Node current = this.front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.numStored ++;
    }

    // Dequeues a new element from the front.
    public String dequeue () {
        String outData = this.front.toString();
        this.front = front.next;

        this.numStored --;
        return outData;
    }

    // Get the queue size.
    public int getSize() {
        return this.numStored;
    }

    // Queue toString(), walks from the front of the queue.
    public String toString() {
        // Will need modification!
        String output = "[ ";
        Node current = this.front;

        while (current != null) {
            output += (current.nodeData + " ");
            current = current.next;
        }
        return (output + "]");
    }
}