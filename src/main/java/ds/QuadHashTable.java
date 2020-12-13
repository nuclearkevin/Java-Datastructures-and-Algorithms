// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public class QuadHashTable<E> extends ReHashTable<E> {
    public QuadHashTable(int capacity) {
        super(capacity);
    }

    // Implements a basic hash function.
    protected int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }
        return sum % capacity;
    }

    // Linear rehashing to implement quadratic probing behavior.
    public int rehash(int previousHash) {
        return (previousHash * previousHash) % this.capacity;
    }
}