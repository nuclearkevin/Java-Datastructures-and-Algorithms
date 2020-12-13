// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class UnorderedArrayMap<T, E> {
    private Object[] keys;
    private Object[] mapData;
    private int numStored, capacity;

    public UnorderedArrayMap () {
        this.capacity = 1;
        this.numStored = 0;
        this.keys = new Object[1];
        this.mapData = new Object[1];
    }

    // Resize the array if inserting another element would exceed the capacity.
    private void resize() {
        if ((this.numStored + 1) >= this.capacity) {
            int newCap = this.capacity * 2;
            // Make new arrays double the capacity of the previous key-data arrays.
            Object[] tempKeys = new Object[newCap];
            Object[] tempData = new Object[newCap];

            // Copy over elements to the new array.
            for (int i = 0; i < this.capacity; i++) {
                tempKeys[i] = this.keys[i];
                tempData[i] = this.mapData[i];
            }

            // Overwrite the old array with the temporary array.
            this.keys = tempKeys;
            this.mapData = tempData;
            this.capacity = newCap;
        }
    }

    // Put key-value pairs into the unordered map.
    public E put(T key, E value) {
        this.resize();
        int insertIndex = this.numStored;
        E out;

        for (int i = 0; i < this.numStored; i++) {
            if (this.keys[i] == key) {
                insertIndex = i;
                break;
            }
        }
        if (insertIndex == this.numStored) {
            out = null;
            this.numStored ++;
        } else {
            out = (E) this.mapData[insertIndex];
        }
        this.keys[insertIndex] = key;
        this.mapData[insertIndex] = value;

        return out;
    }

    // Get a value given the key from the unordered map.
    public E get(T key) {
        for (int i = 0; i < this.numStored; i++) {
            if (this.keys[i] == key) {
                return (E) this.mapData[i];
            }
        }
        return null;
    }

    // Remove a key-value pair from the unordered map.
    public E remove(T key) {
        for (int i = 0; i < this.numStored; i++) {
            if (this.keys[i] == key) {
                E out = (E) this.mapData[i];
                for (int j = i; j < this.numStored - 1; j++) {
                    this.keys[j] = this.keys[j + 1];
                    this.mapData[j] = this.mapData[j + 1];
                }
                this.numStored --;
                return out;
            }
        }
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
        for (int i = 0; i < this.numStored; i++) {
            out[0][i] = this.keys[i];
            out[1][i] = this.mapData[i];
        }
        return out;
    }

    // Returns an array containing all the keys in the unordered map.
    public T[] keySet() {
        return (T[]) this.keys;
    }

    // Returns an array containing all the values in the unordered map.
    public E[] values() {
        return (E[]) this.mapData;
    }

    // Unordered map toString() for output.
    public String toString() {
        String out = "[";

        for (int i = 0; i < this.numStored; i++) {
            out += " (" + this.keys[i].toString() + "," + this.mapData[i].toString() + ")";
        }
        return out + " ]";
    }
}