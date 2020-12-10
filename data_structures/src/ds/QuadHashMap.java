// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class QuadHashMap<E> extends HashMap<E> {
    public QuadHashMap(int capacity) {
        super(capacity);
    }

    public int rehash(int previousHash) {
        return (previousHash * previousHash) % this.capacity;
    }
}