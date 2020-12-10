// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
// WIP, AVL trees are hard.
public class AVLTree<T> {
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
    public AVLTree () {
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
        this.rebalance(this.root);
    }

    // Recursively inserts into the AVL tree. Also rebalances the tree.
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
        rebalance(location);
    }

    // Utility function to get the balance of a node.
    private int getBalance(Node location) {
        int rightHeight = 0;
        if (location.rightChild != null) {
            rightHeight = this.getHeight(location.rightChild);
        }

        int leftHeight = 0;
        if (location.leftChild != null) {
            leftHeight = this.getHeight(location.leftChild);
        }

        return rightHeight - leftHeight;
    }

    // Utility function to get the height of a node.
    private int getHeight(Node location) {
        int leftHeight = 0;
        if (location.leftChild != null) {
            leftHeight = this.getHeight(location.leftChild) + 1;
        }

        int rightHeight = 0;
        if (location.rightChild != null) {
            rightHeight = this.getHeight(location.rightChild) + 1;
        }

        return (leftHeight > rightHeight) ? leftHeight : rightHeight;
    }

    // Helper function to left rotate.
    private void leftRotate(Node location) {
        Node locParent = location.parent;
        Node locRight = location.rightChild;
        Node locRightLeft;
        // Figure out if location's right child's left child exists.
        if (location.rightChild.leftChild != null) {
            locRightLeft = location.rightChild.leftChild;
            location.rightChild = locRightLeft;
            locRightLeft.parent = location;
        } else {
            locRightLeft = null;
        }
        // Performing the trinodal reassignment.
        locRight.leftChild = location;
        locRight.parent = locParent;
        location.parent = locRight;
        location.rightChild = locRightLeft;
        if (locRight.parent == null) {
            this.root = locRight;
        }
    }

    // Helper function to right rotate.
    private void rightRotate(Node location) {
        Node locParent = location.parent;
        Node locLeft = location.leftChild;
        Node locLeftRight;
        // Figure out if location's left child's right child exists.
        if (location.leftChild.rightChild != null) {
            locLeftRight = location.leftChild.rightChild;
            location.leftChild = locLeftRight;
            locLeftRight.parent = location;
        } else {
            locLeftRight = null;
        }
        // Performing trinodal reassignment.
        locLeft.rightChild = location;
        locLeft.parent = locParent;
        location.parent = locLeft;
        location.leftChild = locLeftRight;
        if (locLeft.parent == null) {
            this.root = locLeft;
        }
    }

    private void rebalance(Node location) {
        // Left rotation.
        if (this.getBalance(location) > 1 && location.rightChild != null) {
            if (this.getBalance(location.rightChild) > 0) {
                this.leftRotate(location);
            }
        }
        // Right rotation.
        if (this.getBalance(location) < -1 && location.leftChild != null) {
            if (this.getBalance(location.leftChild) < 0) {
                this.rightRotate(location);
            }
        }
        // Left-right rotation.
        if (this.getBalance(location) < -1 && location.leftChild != null) {
            if (this.getBalance(location.leftChild) > 0) {
                Node locLeft = location.leftChild;
                Node locLeftRight = location.leftChild.rightChild;
                Node locLeftRightLeft = location.leftChild.rightChild.leftChild;
                // Perform first trinodal reassignment.
                locLeftRight.parent = location;
                location.leftChild = locLeftRight;
                locLeftRight.leftChild = locLeft;
                locLeft.parent = locLeftRight;
                // Assign the left-right-left child if it exists.
                if (locLeftRightLeft != null) {
                    locLeft.rightChild = locLeftRightLeft;
                    locLeftRightLeft.parent = locLeft;
                } else {
                    locLeft.rightChild = locLeftRightLeft;
                }
                // Perform second trinodal reassignment.
                this.rightRotate(location);
            }
        }
        // Right-left rotation.
        if (this.getBalance(location) > 1 && location.rightChild!= null) {
            if (this.getBalance(location.rightChild) < 0) {
                Node locRight = location.rightChild;
                Node locRightLeft = location.rightChild.leftChild;
                Node locRightLeftRight = location.rightChild.leftChild.rightChild;
                // Perform first trinodal reassignment.
                locRightLeft.parent = location;
                location.rightChild = locRightLeft;
                locRightLeft.leftChild = locRight;
                locRight.parent = locRightLeft;
                // Assign the right-left-right child if it exists.
                if (locRightLeftRight != null) {
                    locRight.leftChild = locRightLeftRight;
                    locRightLeftRight.parent = locRight;
                } else {
                    locRight.leftChild = locRightLeftRight;
                }
                // Perform second trinodal reassignment.
                this.leftRotate(location);
            }
        }
    }

    // Initiates the recursive search for a key-value pair.
    public T search(int key) {
        return search(this.root, key);
    }

    // Recursively searches the BST for a key and returns the values associated with it.
    // Also rebalances on the parent of the deleted node.
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
            this.rebalance(locParent);
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