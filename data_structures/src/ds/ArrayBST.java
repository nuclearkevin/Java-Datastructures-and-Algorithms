// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
// FUCK THIS SHIT.
package ds;
public class ArrayBST {
    private Node[] tree;
    private int depth, numStored;

    private class Node {
        String nodeData;
        int key;

        public Node (String data, int key) {
            this.nodeData = data;
            this.key = key;
        }
        public String toString() {
            return this.nodeData.toString() + "(" + this.key + ")";
        }
    }
    public ArrayBST(int starterDepth) {
        this.depth = starterDepth;
        this.numStored = 0;
        this.tree = new Node[(int) Math.pow(2, starterDepth)];
    }

    // Method to see if the tree is empty.
    public boolean isEmpty() {
        if (this.numStored > 0) {
            return true;
        } else {
            return false;
        }
    }

    // Helper method to resize the tree array based on depth.
    private void resize(int depth) {
        if (Math.pow(2, depth) >= this.tree.length) {
            // Make a new array which is the next depth level of the tree.
            Node[] tempArray = new Node[(int) Math.pow(2, depth + 1)];

            // Copy over the old tree elements
            for (int i = 0; i < this.tree.length; i++) {
                tempArray[i] = this.tree[i];
            }

            // Overwrite the old tree with the resized array.
            this.tree = tempArray;
            this.depth = depth;
        }
    }

    // Helper method to find the root index.
    private int getRootIndex() {
        return 0;
    }

    // Helper method to find the left child index given the current node index.
    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    // Helper method to find the right child index given the current node idnex.
    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    // Helper method to find the parent index given a child index.
    private int getParent(int index) {
        return (index - 1) / 2;
    }

    // Insert method to add a key-value pair to the array BST.
    public void insert(String data, int key) {
        Node insertNode = new Node(data, key);
        this.resize(0);

        if (this.tree[0] == null) {
            tree[0] = insertNode;
        } else {
            insert(0, 0, insertNode);
        }
    }

    // Recursive inserts into the array BST.
    private void insert(int index, int depth, Node insertNode) {
        this.resize(depth);

        if (insertNode.key < this.tree[index].key) {
            if (this.tree[this.getLeftChildIndex(index)] == null) {
                this.tree[this.getLeftChildIndex(index)] = insertNode;
                this.numStored ++;
            } else {
                insert(this.getLeftChildIndex(index), depth + 1, insertNode);
            }
        } else if (insertNode.key > this.tree[index].key) {
            if (this.tree[this.getRightChildIndex(index)] == null) {
                this.tree[this.getRightChildIndex(index)] = insertNode;
                this.numStored ++;
            } else {
                insert(this.getRightChildIndex(index), depth, insertNode);
            }
        }
    }

    // Array BST toString() for String output.
    public String toString() {
        return treeToString(this.getRootIndex(), 0);
    }

    // Recursively performs a toString() output on each tree "node".
    private String treeToString(int index, int depth) {
        String out = "";
        if (this.tree.length > this.getRightChildIndex(index)) {
            if (this.tree[this.getRightChildIndex(index)] != null) {
                out += treeToString(this.getRightChildIndex(index), depth + 1);
            }
        }
        for (int i = 0; i < depth; i++) {
            out += "\t";
        }
        out += this.tree[index] + "\n";
        if (this.tree.length > this.getLeftChildIndex(index)) {
            if (this.tree[this.getLeftChildIndex(index)] != null) {
                out += treeToString(this.getLeftChildIndex(index), depth + 1);
            }
        }

        return out;
    }
}
