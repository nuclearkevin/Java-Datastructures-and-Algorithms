// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class BinarySearchTree<T> {
    private Node root;

    // Inner class to store tree data.
    private class Node {
        Node leftChild, rightChild, parent;
        T nodeData;
        int key;

        private Node(T data, int key) {
            this.leftChild = null;
            this.rightChild = null;
            this.parent = null;
            this.nodeData = data;
            this.key = key;
        }

        public String toString() {
            return this.nodeData.toString() + "(" + this.key + ")";
        }
    }
    public BinarySearchTree () {
        this.root = null;
    }

    // Initiates the insert given a key-value pair.
    public void insert(T value, int key) {
        Node newNode = new Node(value, key);

        if (this.root == null) {
            this.root = newNode;
        } else {
            this.insert(this.root, newNode);
        }
    }

    // Recursively inserts into the BST.
    private void insert(Node location, Node toInsert) {
        if (location.key > toInsert.key) {
            if (location.leftChild == null) {
                location.leftChild = toInsert;
                toInsert.parent = location;
            } else {
                this.insert(location.leftChild, toInsert);
            }
        } else if (location.key < toInsert.key) {
            if (location.rightChild == null) {
                location.rightChild = toInsert;
                toInsert.parent = location;
            } else {
                this.insert(location.rightChild, toInsert);
            }
        }
    }

    // Initiates the recursive search for a key-value pair.
    public T search(int key) {
        return search(this.root, key);
    }

    // Recursively searches the BST for a key and returns the values associated with it.
    private T search(Node location, int key) {
        if (location.key == key) {
            return location.nodeData;
        } else {
            if (location.key > key && location.leftChild != null) {
                return search(location.leftChild, key);
            } else if (location.key < key && location.rightChild != null){
                return search(location.rightChild, key);
            } else {
                return null;
            }
        }
    }

    // Initiates a deletion in the BST.
    public void delete(int key) {
        delete(this.root, key);
    }

    // Recursively searches the BST for a key and deletes the node containing it.
    private void delete(Node location, int key) {
        if (location.key == key) {
            Node locLeft = location.leftChild;
            Node locRight = location.rightChild;
            Node locParent = location.parent;
            if (location == locParent.leftChild) {
                locParent.leftChild = locLeft;
                if (locLeft != null) {
                    locLeft.parent = locParent;
                }
            } else {
                locParent.rightChild = locRight;
                if (locRight != null) {
                    locRight.parent = locParent;
                }
            }
            location = null;
        } else {
            if (location.key > key && location.leftChild != null) {
                delete(location.leftChild, key);
            } else if (location.key < key && location.rightChild != null) {
                delete(location.rightChild, key);
            }
        }
    }

    // Initiates toString() output of the tree.
    public String toString() {
        return nodeToString(this.root, 0);
    }

    // Recursively performs a toString() output of each tree node.
    private String nodeToString(Node node, int depth) {
        String out = "";
        if (node.rightChild != null) {
            out += nodeToString(node.rightChild, depth + 1);
        }
        for (int i = 0; i < depth; i++) {
            out += "\t";
        }
        out += node.toString() + "\n";
        if (node.leftChild != null) {
            out += nodeToString(node.leftChild, depth + 1);
        }
        return out;
    }
}
