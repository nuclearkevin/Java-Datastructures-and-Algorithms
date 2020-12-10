// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class LinHashMap<E> extends HashMap<E> {
    public LinHashMap(int capacity) {
        super(capacity);
    }

    public int rehash(int previousHash) {
        return (previousHash + 1) % this.capacity;
    }
}