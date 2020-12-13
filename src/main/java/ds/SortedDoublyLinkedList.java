// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class SortedDoublyLinkedList<E> {
    private Node head, tail;
    private int numStored;

    // Inner class to store list data.
    private class Node {
        E nodeData;
        int key;
        Node next;
        Node previous;

        public Node(E data, int key) {
            this.nodeData = data;
            this.key = key;
            this.next = null;
            this.previous = null;
        }
        public String toString() {
            return this.nodeData.toString();
        }
    }
    public SortedDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        numStored = 0;
    }

    // Sorted insert sorting the values according to their keys. Largest to smallest from the front to back.
    public void walkInsert(E value, int key) {
        Node newNode = new Node(value, key);
        boolean insertEnd = true;

        if (this.head == null) {
            // Insert at the front for an empty list.
            this.head = newNode;
            this.tail = newNode;
            insertEnd = false;
        } else if (this.head.key < newNode.key) {
            // Inserts at the beginning if the key of the new node is larger than the key of the existing head node.
            newNode.next = head;
            newNode.previous = null;
            if (head != null) {
                this.head.previous = newNode;
            }
            this.head = newNode;
        } else {
            // Inserts in the list if the first two cases don't occur.
            Node current = head;

            while (current.next != null) {
                if (newNode.key > current.key) {
                    newNode.next = current.next;
                    current.next = newNode;
                    newNode.previous = current;

                    if (newNode.next != null) {
                        newNode.next.previous = newNode;
                    }

                    insertEnd = false;
                    System.out.println(1);
                    break;
                }
                current = current.next;
            }
            if (insertEnd) {
                current.next = newNode;
                newNode.previous = current;
                System.out.println(0);
            }
        }
        numStored ++;
    }
    // Search from the front. Same as an unsorted DLL.
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

    // Search from the back. Same as an unsorted DLL.
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

    // Sorted DLL toString(). Walks from the front.
    public String toString() {
        // Will need modification!
        Node current = head;
        String out = "[";

        while (current != null) {
            out = out + " " + current + "(Key: " + current.key + ")";
            current = current.next;
        }
        return out + " ]";
    }
}