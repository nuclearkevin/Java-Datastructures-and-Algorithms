// Part of the data structures library written by Kevin Sawatzky as preparation for the final exam for CSCI-2010U.
package ds;
abstract class LinkedChainingHashTable<E> implements HashTable<E> {
    private int numStored, size;

    // ArrayList of SLL's to store table data.
    private UnsortedArrayList<UnorderedLinkedMap<String, E>> tableData;

    public LinkedChainingHashTable (int size) {
        this.size = size;
        this.tableData = new UnsortedArrayList(size);
    }

    abstract int hash(String key);

    public E put(String key, E value) {
        int insertHash = this.hash(key);

        if (this.tableData.get(insertHash) == null) {
            this.tableData.insert(new UnorderedLinkedMap(), insertHash);
            this.tableData.get(insertHash).put(key, value);

            this.numStored ++;
        } else {
            if (this.tableData.get(insertHash).get(key) == null) {
                this.tableData.get(insertHash).put(key, value);
            } else {
                return (E) this.tableData.get(insertHash).replace(key, value);
            }
            this.numStored ++;
        }
        return null;
    }

    public E get(String key) {
        int indexHash = this.hash(key);

        if (this.tableData.get(indexHash) != null) {
            return (E) this.tableData.get(indexHash).get(key);
        } else {
            return null;
        }
    }

    public E remove(String key) {
        int indexHash = this.hash(key);

        if (this.tableData.get(indexHash) != null) {
            if (this.tableData.get(indexHash).get(key) != null) {
                this.numStored --;
                return (E) this.tableData.get(indexHash).remove(key);
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return (this.numStored == 0);
    }

    public int size() {
        return this.size;
    }

    public Object[][] elementSet() {
        Object[][] out = new Object[2][this.numStored];

        int k = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.tableData.get(i) != null) {
                Object[][] listData = this.tableData.get(i).elementSet();
                for (int j = 0; j < this.tableData.get(i).size(); j++) {
                    if (k < this.numStored) {
                        out[0][k] = listData[0][j];
                        out[1][k] = listData[1][j];
                        k++;
                    }
                }
            }
        }
        return out;
    }

    public String[] keySet() {
        String[] out = new String[this.numStored];

        int k = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.tableData.get(i) != null) {
                String[] listData = this.tableData.get(i).keySet();
                for (int j = 0; j < this.tableData.get(i).size(); j++) {
                    if (k < this.numStored) {
                        out[k] = listData[j];
                        out[k] = listData[j];
                        k++;
                    }
                }
            }
        }
        return out;
    }

    public E[] valueSet() {
        Object[] out = new Object[this.numStored];

        int k = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.tableData.get(i) != null) {
                Object[] listData = this.tableData.get(i).values();
                for (int j = 0; j < this.tableData.get(i).size(); j++) {
                    if (k < this.numStored) {
                        out[k] = listData[j];
                        out[k] = listData[j];
                        k++;
                    }
                }
            }
        }
        return (E[]) out;
    }
}
