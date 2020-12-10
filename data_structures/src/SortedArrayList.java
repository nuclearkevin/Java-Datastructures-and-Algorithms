// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
public class SortedArrayList<T> {
    private int capacity, numStored;
    Object[] arrayData;
    int[] keys;

    // Create an ArrayList of capacity 1.
    public SortedArrayList () {
        this.numStored = 0;
        this.capacity = 1;
        this.arrayData = new Object[1];
        this.keys = new int[1];
    }
    // Create an ArrayList of capacity initialCap.
    public SortedArrayList (int initialCap) {
        this.numStored = 0;
        this.capacity = initialCap;
        this.arrayData = new Object[initialCap];
        this.keys = new int[initialCap];
    }
    // Create an ArrayList using an existing array of values and keys.
    public SortedArrayList (T values[], int keys[]) {
        if (keys.length >= values.length) {
            this.numStored = values.length;
            this.capacity = values.length;
            arrayData = new Object[values.length];
            this.keys = new int[values.length];
        } else {
            this.numStored = keys.length;
            this.capacity = keys.length;
            arrayData = new Object[keys.length];
            this.keys = new int[keys.length];
        }
    }

    // Resize the array if inserting another element would exceed the capacity.
    private void resize() {
        if ((this.numStored + 1) >= this.capacity) {
            // Make a new array double the capacity of the previous.
            Object[] tempArray = new Object[this.arrayData.length * 2];
            int[] tempKeysArray = new int[this.keys.length * 2];

            // Copy over elements to the new array.
            for (int i = 0; i < this.arrayData.length; i++) {
                tempArray[i] = this.arrayData[i];
                tempKeysArray[i] = this.keys[i];
            }

            // Overwrite the old array with the temporary array.
            this.arrayData = tempArray;
            this.keys = tempKeysArray;
            this.capacity = this.arrayData.length;
        }
    }

    // Sorted insert sorting the values according to their keys. Largest to smallest from the front to back.
    // Current copying is very inefficient.
    public void insert(T value, int key) {
        // Resize
        this.resize();
        this.numStored ++;

        int insertIndex = 0;
        boolean insertEnd = true;

        // Ordered insert.
        for (int i = 0; i < this.arrayData.length; i++) {
            if (this.arrayData[i] == null) {
                break;
            } else if (this.keys[i] < key) {
                insertEnd = false;
                break;
            }
            insertIndex = i;
        }
        if (insertEnd == false) {
            Object[] temp = new Object[this.arrayData.length];
            int[] tempKeys = new int[this.keys.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = this.arrayData[i];
                tempKeys[i] = this.keys[i];
            }

            this.arrayData[insertIndex] = value;
            this.keys[insertIndex] = key;

            for (int i = insertIndex; i < (this.arrayData.length - insertIndex - 1); i++) {
                if (this.arrayData[i] == null) {
                    break;
                }
                this.arrayData[i + 1] = temp[i];
                this.keys[i + 1] = tempKeys[i];
            }
        } else {
            this.arrayData[insertIndex] = value;
            this.keys[insertIndex] = key;
        }
    }

    // Getter for size.
    public int getLength() {
        return this.numStored;
    }

    // Getter for capacity.
    public int getCapacity() {
        return this.capacity;
    }

    // ArrayList toString(). Front to back.
    public String toString() {
        // Will need modification!
        String out = "[";

        for (int i = 0; i < this.arrayData.length; i++) {
            if (this.arrayData[i] == null) {
                break;
            } else {
                out = out + " " + this.arrayData[i].toString() + "(" + this.keys[i] + ")";
            }
        }
        System.out.println(this.numStored);
        return out + " ]";
    }
}

