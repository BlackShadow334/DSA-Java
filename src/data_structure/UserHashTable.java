package data_structure;

import java.util.LinkedList;

public class UserHashTable {
    private static class Entry{
        int key;
        String value;
        Entry(int key, String value){
            this.key = key;
            this.value = value;
        }
    }

    private final LinkedList<Entry>[] entries;
    private int size = 10;

    public UserHashTable(){
           entries = new LinkedList[size];
    }

    public void put (int key, String value){
        int hash = getHashValue(key);
        if (entries[hash] == null)
            entries[hash] = new LinkedList<>();

        var bucket = entries[hash];
        for (var entry: bucket) {
             if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
    }

    public String get(int key){
        int hash = getHashValue(key);
        var bucket = entries[hash];
        if (bucket == null) return null;
        for (var entry: bucket)
            if (entry.key == key)
                return entry.value;
        return null;
    }

    public void remove(int key){
        int hash = getHashValue(key);
        var bucket = entries[hash];
        for (var entry : bucket)
            if (entry.key == key){
                bucket.remove(entry);
                return;
            }
        throw new IllegalStateException();
    }

    private int getHashValue(int key){
        return Math.abs(key % size);
    }
}
