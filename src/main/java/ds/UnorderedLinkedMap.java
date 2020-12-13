// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class UnorderedLinkedMap<T, E> {
    private Node head;
    private int numStored;

    private class Node {
        String key;
        E nodeData;
        Node next;

        public Node (String key, E nodeData) {
            this.key = key;
            this.nodeData = nodeData;
            this.next = null;
        }
    }
    public UnorderedLinkedMap () {
        this.head = null;
        this.numStored = 0;
    }

    // Walks the list and inserts a key-value pair at the end.
    public void put(String key, E value) {
        Node insertNode = new Node(key, value);
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
            current.next = insertNode;
            insertNode.next = null;
            this.numStored ++;
        }
    }

    // Searches the list (head to tail) to find a value given its key.
    public E get(String key) {
        // Walk until key is found.
        Node current = this.head;
        while (current.next != null) {
            // Return the key's associated data.
            if (current.key == key) {
                return current.nodeData;
            }
            current = current.next;
        }
        // If the value wasn't found, return null.
        return null;
    }

    // Deletes an entry based on its key.
    public E remove(String key) {
        // Walk until the key is found.
        Node current = this.head;
        Node previous = null;
        while (current.next != null) {
            // If the key is found, reassign node pointers
            // so the JVM garbage collector removes the current node.
            // Returns the deleted value.
            if (current.key == key) {
                E out = current.nodeData;
                previous.next = current.next;

                this.numStored --;
                return out;
            }
            previous = current;
            current = current.next;
        }
        // If the key wasn't found, return null.
        return null;
    }

    // Replaces an entry at its key.
    public E replace(String key, E newValue) {
        // Walk until the key is found.
        Node current = this.head;
        Node previous = null;
        while (current.next != null) {
            // If the key is found, swap the node data to the new data.
            if (current.key == key) {
                E out = current.nodeData;
                current.nodeData = newValue;
                return out;
            }
        }
        // If the key wasn't found, return null.
        return null;
    }

    // Return the number of key-value pairs in the unordered map.
    public int size() {
        return this.numStored;
    }

    // Method to determine if the unordered map is empty or not.
    public boolean isEmpty() {
        return (this.numStored == 0);
    }

    // Returns a collection of all the entries in the unordered map. 2D array format.
    public Object[][] elementSet() {
        Object[][] out = new Object[2][this.numStored];

        int i = 0;
        Node current = this.head;
        while (current.next != null && i < this.numStored) {
            out[0][i] = current.key;
            out[1][i] = current.nodeData;

            current = current.next;
            i++;
        }
        return out;
    }

    // Returns an array containing all the keys in the unordered map.
    public T[] keySet() {
        Object[] out = new Object[this.numStored];

        int i = 0;
        Node current = this.head;
        while (current.next != null && i < this.numStored) {
            out[i] = current.key;
            current = current.next;
        }
        return (T[]) out;
    }

    // Returns an array containing all the values in the unordered map.
    public E[] values() {
        Object[] out = new Object[this.numStored];

        int i = 0;
        Node current = this.head;
        while (current.next != null && i < this.numStored) {
            out[i] = current.nodeData;
            current = current.next;
        }
        return (E[]) out;
    }
}