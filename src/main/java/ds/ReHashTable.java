// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public abstract class ReHashTable<E> implements HashTable<E> {
    protected String[] keys;
    protected Object[] mapData;
    protected int numStored, capacity;

    public ReHashTable (int capacity) {
        this.numStored = 0;
        this.capacity = capacity;
        this.keys = new String[capacity];
        this.mapData = new Object[capacity];
    }

    // Initial hash function.
    protected abstract int hash(String key);

    // Rehash function for dealing with collisions.
    protected abstract int rehash(int previousHash);

    // Put key-value pairs into the hash map.
    public E put(String key, E value) {
        int insertHash = this.hash(key);

        while (this.keys[insertHash] != null && this.mapData[insertHash] != null) {
            if (this.keys[insertHash] == key) {
                E out = (E) this.mapData[insertHash];
                this.mapData[insertHash] = value;
                return out;
            }
            insertHash = this.rehash(insertHash);
        }

        this.keys[insertHash] = key;
        this.mapData[insertHash] = value;
        this.numStored ++;
        return null;
    }

    // Get a value given the key from the hash map.
    public E get(String key) {
        int lookupHash = this.hash(key);

        while (this.keys[lookupHash] != null && this.mapData[lookupHash] != null) {
            if (this.keys[lookupHash] == key) {
                return (E) this.mapData[lookupHash];
            }
            lookupHash = rehash(lookupHash);
        }

        return null;
    }
    // Remove a key-value pair from the hash map.
    public E remove(String key) {
        int lookupHash = this.hash(key);

        while (this.keys[lookupHash] != null && this.mapData[lookupHash] != null) {
            if (this.keys[lookupHash] == key) {
                E data = (E) this.mapData[lookupHash];
                this.mapData[lookupHash] = null;
                this.keys[lookupHash] = null;
                this.numStored --;
                return data;
            }
            lookupHash = rehash(lookupHash);
        }

        return null;
    }

    // Return the number of key-value pairs in the table..
    public int size() {
        return this.numStored;
    }

    // Method to determine if the unordered map is empty or not.
    public boolean isEmpty() {
        if (this.numStored == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Returns a collection of all the entries in the unordered map. 2D array format.
    public Object[][] elementSet() {
        Object[][] out = new Object[2][this.numStored];
        for (int i = 0; i < this.numStored; i++) {
            out[0][i] = this.keys[i];
            out[1][i] = this.mapData[i];
        }
        return out;
    }

    // Returns an array containing all the keys in the unordered map.
    public String[] keySet() {
        return this.keys;
    }

    // Returns an array containing all the values in the unordered map.
    public Object[] values() {
        return (E[]) this.mapData;
    }

    // Hash map toString() for String output.
    public String toString() {
        return "A hashtable with " + this.numStored + " entries.";
    }
}