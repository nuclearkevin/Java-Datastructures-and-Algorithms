// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
public class SortedSinglyLinkedList<T> {
    private Node head;
    private int numStored;

    // Inner class to store list data.
    private class Node {
        T nodeData;
        int key;
        Node next;

        public Node (T value, int key) {
            this.nodeData = value;
            this.key = key;
            this.next = null;
        }
        public String toString() {
            return this.nodeData.toString();
        }
    }
    public SortedSinglyLinkedList()
    {
        this.head = null;
        this.numStored = 0;
    }

    // Sorted insert sorting the values according to their keys. Largest to smallest from the front to back.
    public void walkInsert(T value, int key) {
        Node newNode = new Node(value, key);
        boolean insertEnd = true;

        if (this.head == null) {
            // Insert at the front for an empty list.
            this.head = newNode;
            newNode.next = null;
            insertEnd = false;
        } else if (this.head.key < newNode.key) {
            // Inserts at the beginning if the key of the new node is larger than the key of the existing head node.
            newNode.next = head;
            this.head = newNode;
        } else {
            // Inserts in the list if the first two cases don't occur.
            Node current = head;

            while (current.next != null) {
                if (newNode.key > current.key) {
                    newNode.next = current.next;
                    current.next = newNode;
                    insertEnd = false;
                    System.out.println(1);
                    break;
                }
                current = current.next;
            }
            if (insertEnd) {
                current.next = newNode;
                System.out.println(0);
            }
        }
        numStored ++;
    }

    // Finds a value by walking the list from the beginning. Same as an unsorted SLL.
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
