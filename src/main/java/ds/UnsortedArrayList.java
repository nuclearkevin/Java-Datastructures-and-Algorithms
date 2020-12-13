// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class UnsortedArrayList<E> {
    private int capacity, numStored;
    private Object[] arrayData;

    // Create an ArrayList of capacity 1.
    public UnsortedArrayList () {
        this.numStored = 0;
        this.capacity = 1;
        arrayData = new Object[1];
    }
    // Create an ArrayList of capacity initialCap.
    public UnsortedArrayList (int initialCap) {
        this.numStored = 0;
        this.capacity = initialCap;
        arrayData =  new Object[initialCap];
    }
    // Create an ArrayList using an existing array.
    public UnsortedArrayList (E values[]) {
        this.numStored = values.length;
        this.capacity = values.length;
        arrayData = values;
    }

    // Resize the array if inserting another element would exceed the capacity.
    private void resize() {
        if ((this.numStored + 1) >= this.capacity) {
            // Make a new array double the capacity of the previous.
            Object[] tempArray = new Object[this.arrayData.length * 2];

            // Copy over elements to the new array.
            for (int i = 0; i < this.arrayData.length; i++) {
                tempArray[i] = this.arrayData[i];
            }

            // Overwrite the old array with the temporary array.
            this.arrayData = tempArray;
            this.capacity = this.arrayData.length;
        }
    }

    // Add an element to the array.
    public void insert(E value, int index) {
        // Resize
        this.resize();

        // Insert if index isn't out of range.
        if (index >= 0 && index < this.capacity) {
            this.arrayData[index] = value;
            numStored ++;
        }
    }

    // Insert an element at the front of the array.
    public void insertFront(E value) {
        // Resize.
        this.resize();

        // Shuffle all elements forward by one.
        for (int i = this.numStored - 1; i >= 0; i--) {
            this.arrayData[i + 1] = this.arrayData[i];
        }

        // Insert an element at the beginning.
        numStored ++;
        this.arrayData[0] = value;
    }

    // Insert an element at the back of the array.
    public void insertBack(E value) {
        // Resize.
        this.resize();

        // Insert at the end.
        this.arrayData[this.numStored] = value;
        numStored ++;
    }

    // Returns a value at the given index.
    public E get(int index) {
        return (E) this.arrayData[index];
    }

    // Sets the value at a given index.
    public void set(int index, E value) {
        this.arrayData[index] = value;
    }

    // Returns the index location of an element. Returns -1 if not found.
    public int indexOf(E value) {
        for (int i = 0; i < this.numStored; i++) {
            if (this.arrayData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        E out = (E) this.arrayData[index];

        this.arrayData[index] = null;

        // Shuffle all the elements back by one.
        for (int i = index; i < this.arrayData.length; i ++) {
            this.arrayData[i] = this.arrayData[i + 1];
        }
        return out;
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

        for (int i = 0; i < this.numStored; i++) {
            out = out + " " + arrayData[i];
        }
        return out + " ]";
    }
}
