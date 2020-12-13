// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
public interface HashTable<E> {
    E get(String key);
    E put(String key, E value);
    E remove(String key);
    boolean isEmpty();
    int size();
    Object[][] elementSet();
    String[] keySet();
    E[] valueSet();
}
