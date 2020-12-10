public class ArrayQueue<T> {
    private Object[] queueData;
    private int length, capacity;

    public ArrayQueue () {
        this.length = 0;
        this.capacity = 1;
        this.queueData = new Object[1];
    }

    // Resize the array if inserting another element would exceed the capacity.
    private void resize() {
        if ((this.length + 1) >= this.capacity) {
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
        if (this.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Queues a new element.
    public void enqueue(T value) {
        this.resize();

        this.queueData[this.length] = value;
        this.length ++;
    }

    // Dequeues the front element.
    public T dequeue() {
        T out = (T) this.queueData[0];

        for (int i = 1; i < this.length; i++) {
            this.queueData[i - 1] = this.queueData[i];
        }
        this.length --;
        return out;
    }

    public T frontElement() {
        return (T) this.queueData[0];
    }

    // Getter for the stack size.
    public int getSize() {
        return this.length;
    }

    // Queue toString() for output.
    public String toString() {
        String out = "[";

        for (int i = 0; i < this.length; i++) {
            if (this.queueData[i] == null) {
                break;
            }
            out += " " + this.queueData[i].toString();
        }
        return out + " ]";
    }
}
