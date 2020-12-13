// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class UnsortedDoublyLinkedList<E> {
    private Node head, tail;
    private int numStored;

    // Inner class to store list data.
    private class Node {
        E nodeData;
        Node next, previous;

        public Node (E value) {
            this.nodeData = value;
            this.next = null;
            this.previous = null;
        }
        public String toString() {
            return this.nodeData.toString();
        }
    }
    public UnsortedDoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
        this.numStored = 0;
    }

    // Insert a value from the front. Same as an SLL.
    public void walkInsert(E value) {
        Node insertNode = new Node(value);

        if (this.head == null) {
            // Insert at the front for an empty list.
            this.head = insertNode;
            this.tail = insertNode;
            insertNode.next = null;
            insertNode.previous = null;
            this.numStored ++;
        } else {
            // Walk and insert at end.
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            if (current.next == null) {
                current.next = insertNode;
                insertNode.previous = current;
                insertNode.next = null;
                this.tail = insertNode;
                this.numStored ++;
            }
        }
    }

    // Directly insert at the front.
    public void insertFront(E value) {
        Node insertNode = new Node(value);

        if (this.head == null) {
            // Insert at front for an empty list.
            this.head = insertNode;
            this.tail = insertNode;
            insertNode.next = null;
            insertNode.previous = null;
            this.numStored ++;
        } else {
            // Insert at the front BEFORE the current head.
            insertNode.next = head;
            this.head.previous = insertNode;
            this.head = insertNode;
            this.numStored ++;
        }
    }

    // Directly insert at the back.
    public void insertBack(E value) {
        Node insertNode = new Node(value);

        if (this.tail == null) {
            // Insert at the front for an empty list.
            this.head = insertNode;
            this.tail = insertNode;
            insertNode.next = null;
            insertNode.previous = null;
            this.numStored ++;
        } else {
            // Insert at the back.
            insertNode.previous = tail;
            this.tail.next = insertNode;
            this.tail = insertNode;
            this.numStored ++;
        }
    }

    // Search from the front. Same as an SLL.
    public int findFromFront(E value) {
        int location = 0;

        // Walk until value is found.
        Node current = this.head;
        while (current.next != null) {
            if (current.nodeData == value) {
                break;
            }
            location ++;
            current = current.next;
        }
        if (current.next == null && current.nodeData != value) {
            location = -1;
        }
        return location;
    }

    // Search from the back.
    public int findFromBack(E value) {
        int location = this.numStored - 1;

        // Walk until value is found.
        Node current = this.tail;
        while (current.previous != null) {
            if (current.nodeData == value) {
                break;
            }
            location --;
            current = current.previous;
        }
        if (current.previous == null && current.nodeData != value) {
            location = -1;
        }
        return location;
    }

    // Gets current number of nodes.
    public int getSize() {
        return this.numStored;
    }

    // Unsorted DLL toString(). Walks from the front.
    public String toString() {
        // Will need modification!
        Node current = this.head;
        String out = "[ ";

        while (current != null) {
            out = out + " " + current;
            current = current.next;
        }
        return out + " ]";
    }
}
