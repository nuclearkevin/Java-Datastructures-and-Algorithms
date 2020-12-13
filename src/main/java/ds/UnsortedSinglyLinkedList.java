// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class UnsortedSinglyLinkedList<E> {
    private Node head;
    private int numStored;

    // Inner class to store list data.
    private class Node {
        E nodeData;
        Node next;

        public Node (E value) {
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
    public void walkInsert(E value) {
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
    public void insertFront(E value) {
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
    public int findValue(E value) {
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

    // Finds a value and deletes it.
    public E delete(E toDelete) {
        // Walk until the value is found.
        Node current = this.head;
        Node previous = null;
        while (current.next != null) {
            if (current.nodeData == toDelete) {
                E out = current.nodeData;
                previous.next = current.next;
                return out;
            }
            previous = current;
            current = current.next;
        }
        // If the value wasn't found, return null.
        return null;
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
