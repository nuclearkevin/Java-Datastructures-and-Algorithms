// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
public class UnsortedSinglyLinkedList<T> {
    private Node head;
    private int numStored;

    // Inner class to store list data.
    private class Node {
        T nodeData;
        Node next;

        public Node (T value) {
            this.nodeData = value;
            this.next = null;
        }
        public String toString() {
            return this.nodeData.toString();
        }
    }
    public UnsortedSinglyLinkedList()
    {
        this.head = null;
        this.numStored = 0;
    }

    // Insert a value.
    public void walkInsert(T value) {
        Node insertNode = new Node(value);

        if (this.head == null) {
            // Insert at the front for an empty list.
            this.head = insertNode;
            insertNode.next = null;
            this.numStored ++;
        } else {
            // Walk and insert at end.
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            if (current.next == null) {
                current.next = insertNode;
                insertNode.next = null;
                this.numStored ++;
            }
        }
    }

    // Directly insert at the front.
    public void insertFront(T value) {
        Node insertNode = new Node(value);

        if (this.head == null) {
            // Insert at front for an empty list.
            this.head = insertNode;
            insertNode.next = null;
            this.numStored ++;
        } else {
            // Insert at the front BEFORE the current head.
            insertNode.next = head;
            this.head = insertNode;
            this.numStored ++;
        }
    }

    // Finds a value by walking the list from the beginning.
    public int findValue(T value) {
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

    // Get the current number of nodes.
    public int getSize() {
        return this.numStored;
    }

    // Unsorted SLL toString() for output.
    public String toString() {
        // Will need modification!
        Node current = this.head;
        String out = "[";

        while (current != null) {
            out = out + " " + current;
            current = current.next;
        }
        return out + " ]";
    }
}
