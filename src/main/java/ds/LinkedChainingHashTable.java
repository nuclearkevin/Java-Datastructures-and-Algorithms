// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
abstract class LinkedChainingHashTable<E> implements HashTable<E> {
    private int numStored, size;
    // Unordered linked map to store key-value pairs.
    private UnsortedArrayList<UnorderedLinkedMap<String, E>> tableData;

    public LinkedChainingHashTable (int size) {
        this.size = size;
        this.tableData = new UnsortedArrayList<>(size);
    }

    // Abstract hashing function to be declared by the user.
    abstract int hash(String key);

    // Inserts into the hashtable.
    public E put(String key, E value) {
        int insertHash = this.hash(key);

        if (this.tableData.get(insertHash) == null) {
            this.tableData.insert(new UnorderedLinkedMap<>(), insertHash);
            this.tableData.get(insertHash).put(key, value);

            this.numStored ++;
        } else {
            if (this.tableData.get(insertHash).get(key) == null) {
                this.tableData.get(insertHash).put(key, value);
            } else {
                return this.tableData.get(insertHash).replace(key, value);
            }
            this.numStored ++;
        }
        return null;
    }

    // Gets a value associated with a key.
    public E get(String key) {
        int indexHash = this.hash(key);

        if (this.tableData.get(indexHash) != null) {
            return this.tableData.get(indexHash).get(key);
        } else {
            return null;
        }
    }

    // Removes a value associated with a key.
    public E remove(String key) {
        int indexHash = this.hash(key);

        if (this.tableData.get(indexHash) != null) {
            if (this.tableData.get(indexHash).get(key) != null) {
                this.numStored --;
                return this.tableData.get(indexHash).remove(key);
            }
        }
        return null;
    }

    // Check to see if the table is empty.
    public boolean isEmpty() {
        return (this.numStored == 0);
    }

    // Get the number of elements in the table.
    public int size() {
        return this.size;
    }

    // Get the capacity of the hash part of the table.
    public int capacity() {
        return this.size;
    }

    // Returns a collection of key-value pairs in 2D array form.
    public Object[][] elementSet() {
        Object[][] out = new Object[2][this.numStored];

        int k = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.tableData.get(i) != null) {
                Object[][] listData = this.tableData.get(i).elementSet();
                for (int j = 0; j < this.tableData.get(i).size(); j++) {
                    if (k < this.numStored) {
                        out[0][k] = listData[0][j];
                        out[1][k] = listData[1][j];
                        k++;
                    }
                }
            }
        }
        return out;
    }

    // Returns an array of keys.
    public String[] keySet() {
        String[] out = new String[this.numStored];

        int k = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.tableData.get(i) != null) {
                String[] listData = this.tableData.get(i).keySet();
                for (int j = 0; j < this.tableData.get(i).size(); j++) {
                    if (k < this.numStored) {
                        out[k] = listData[j];
                        out[k] = listData[j];
                        k++;
                    }
                }
            }
        }
        return out;
    }

    // Returns an array of values.
    public E[] valueSet() {
        Object[] out = new Object[this.numStored];

        int k = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.tableData.get(i) != null) {
                Object[] listData = this.tableData.get(i).values();
                for (int j = 0; j < this.tableData.get(i).size(); j++) {
                    if (k < this.numStored) {
                        out[k] = listData[j];
                        out[k] = listData[j];
                        k++;
                    }
                }
            }
        }
        return (E[]) out;
    }
}
