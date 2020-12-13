// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class ArrayQueue<E> {
    private Object[] queueData;
    private int numStored, capacity;

    public ArrayQueue () {
        this.numStored = 0;
        this.capacity = 1;
        this.queueData = new Object[1];
    }

    // Resize the array if inserting another element would exceed the capacity.
    private void resize() {
        if ((this.numStored + 1) >= this.capacity) {
            // Make a new array double the capacity of the previous.
            Object[] tempArray = new Object[this.queueData.length * 2];

            // Copy over elements to the new array.
            for (int i = 0; i < this.queueData.length; i++) {
                tempArray[i] = this.queueData[i];
            }

            // Overwrite the old array with the temporary array.
            this.queueData = tempArray;
            this.capacity = this.queueData.length;
        }
    }

    // Method to check if the queue is empty or not.
    public boolean isEmpty () {
        return (this.numStored == 0);
    }

    // Queues a new element.
    public void enqueue(E value) {
        this.resize();

        this.queueData[this.numStored] = value;
        this.numStored ++;
    }

    // Dequeues the front element.
    public E dequeue() {
        E out = (E) this.queueData[0];

        for (int i = 1; i < this.numStored; i++) {
            this.queueData[i - 1] = this.queueData[i];
        }
        this.numStored --;
        return out;
    }

    public E frontElement() {
        return (E) this.queueData[0];
    }

    // Getter for the stack size.
    public int getSize() {
        return this.numStored;
    }

    // Queue toString() for output.
    public String toString() {
        String out = "[";

        for (int i = 0; i < this.numStored; i++) {
            if (this.queueData[i] == null) {
                break;
            }
            out += " " + this.queueData[i].toString();
        }
        return out + " ]";
    }
}
