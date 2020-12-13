// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
abstract class ArrayChainingHashTable<E> implements HashTable<E> {
    private int numStored, size;
    // Unsorted array lists to store keys and values.
    // Would have prefered to use regular arrays but Java
    // doesn't like making arrays of generics.
    private UnsortedArrayList<UnsortedArrayList<String>> keys;
    private UnsortedArrayList<UnsortedArrayList<E>> values;

    public ArrayChainingHashTable (int size) {
        this.numStored = 0;
        this.size = size;
        this.keys = new UnsortedArrayList(size);
        this.values = new UnsortedArrayList(size);
    }

    // Abstract hashing function to be declared by the user.
    abstract int hash(String key);

    // Inserts into the hashtable.
    public E put(String key, E value) {
        int insertHash = this.hash(key);

        if (this.keys.get(insertHash) == null && this.values.get(insertHash) == null) {
            this.keys.set(insertHash, new UnsortedArrayList<>());
            this.keys.get(insertHash).insertBack(key);
            this.values.set(insertHash, new UnsortedArrayList<>());
            this.values.get(insertHash).insertBack(value);
            this.numStored ++;
        } else {
            if (this.keys.get(insertHash).indexOf(key) == -1) {
                this.keys.get(insertHash).insertBack(key);
                this.values.get(insertHash).insertBack(value);
                this.numStored ++;
            } else {
                int lookup = this.keys.get(insertHash).indexOf(key);
                E out = this.values.get(insertHash).get(lookup);

                this.values.get(insertHash).set(lookup, value);

                return out;
            }
        }
        return null;
    }

    // Gets a value associated with a key.
    public E get(String key) {
        int lookupHash = this.hash(key);

        if (this.keys.get(lookupHash) != null) {
            int valueLocation = this.keys.get(lookupHash).indexOf(key);
            if (valueLocation != -1) {
                return this.values.get(lookupHash).get(valueLocation);
            }
        }
        return null;
    }

    // Removes a value associated with a key.
    public E remove(String key) {
        int lookupHash = this.hash(key);

        if (this.keys.get(lookupHash) != null) {
            int valueLocation = this.keys.get(lookupHash).indexOf(key);
            if (valueLocation != -1) {
                this.keys.get(lookupHash).remove(valueLocation);
                return this.values.get(lookupHash).remove(valueLocation);
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
        return this.numStored;
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
            if (this.keys.get(i) != null) {
                for (int j = 0; j < this.keys.get(i).getLength(); j++) {
                    if (k < this.numStored && this.keys.get(i).get(j) != null) {
                        out[0][k] = this.keys.get(i).get(j);
                        out[1][k] = this.values.get(i).get(j);
                        k ++;
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
            if (this.keys.get(i) != null) {
                for (int j = 0; j < this.keys.get(i).getLength(); j++) {
                    if (k < this.numStored && this.keys.get(i).get(j) != null) {
                        out[k] = this.keys.get(i).get(j);
                        k ++;
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
            if (this.keys.get(i) != null) {
                for (int j = 0; j < this.keys.get(i).getLength(); j++) {
                    if (k < this.numStored && this.keys.get(i).get(j) != null) {
                        out[k] = this.values.get(i).get(j);
                        k ++;
                    }
                }
            }
        }

        return (E[]) out;
    }
}
