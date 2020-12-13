// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class LinkedStack<E> {
    private Node head;
    private int numStored;

    // Inner class to store stack data.
    private class Node {
        E nodeData;
        Node next;

        public Node (E nodeData) {
            this.nodeData = nodeData;
            this.next = null;
        }
        public String toString() {
            return this.nodeData.toString();
        }
    }
    public LinkedStack () {
        this.head = null;
        this.numStored = 0;
    }

    // Inserts a value to the top of the stack.
    public void push(E value) {
        Node pushedNode = new Node(value);
        if (this.head == null) {
            this.head = pushedNode;
            this.numStored ++;
        } else {
            pushedNode.next = this.head;
            this.head = pushedNode;
            this.numStored ++;
        }
    }

    // Get the top value from the stack.
    public E pop() {
        E outData = this.head.nodeData;
        this.head = this.head.next;
        this.numStored --;
        return outData;
    }

    // View the top element in the stack.
    public E top() {
        return this.head.nodeData;
    }

    // Check to see if the stack is empty.
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    // Getter for the stack size.
    public int size() {
        return this.numStored;
    }

    // Stack toString() for output.
    public String toString() {
        Node current = this.head;
        String out = "[";

        while (current != null) {
            out = out + " " + current;
            current = current.next;
        }
        return out + " ]";
    }
}
