// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class LinkedStack<T> {
    private Node head;
    private int length;

    // Inner class to store stack data.
    private class Node {
        T nodeData;
        Node next;

        public Node (T nodeData) {
            this.nodeData = nodeData;
            this.next = null;
        }
        public String toString() {
            return this.nodeData.toString();
        }
    }
    public LinkedStack () {
        this.head = null;
        this.length = 0;
    }

    // Inserts a value to the top of the stack.
    public void push(T value) {
        Node pushedNode = new Node(value);
        if (this.head == null) {
            this.head = pushedNode;
            this.length ++;
        } else {
            pushedNode.next = this.head;
            this.head = pushedNode;
            this.length ++;
        }
    }

    // Get the top value from the stack.
    public T pop() {
        T outData = this.head.nodeData;
        this.head = this.head.next;
        this.length --;
        return outData;
    }

    // View the top element in the stack.
    public T top() {
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
    public int getSize() {
        return this.length;
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
