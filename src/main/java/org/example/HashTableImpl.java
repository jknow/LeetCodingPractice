package org.example;

import java.util.LinkedList;

public class HashTableImpl<K,V> {
    private final LinkedList<Pair<K,V>>[] table;

    public HashTableImpl(int size) {
        this.table = (LinkedList<Pair<K,V>>[]) new LinkedList[size];
        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = new LinkedList<>();
        }
    }

    public void add(K key, V value) {
        int hash = this.hashKey(key);
        Pair<K,V> pair = new Pair<>(key, value);
        this.table[hash].add(pair);
    }

    public V get(K key) {
        int hash = this.hashKey(key);
        if (!this.table[hash].isEmpty()) {
            for (int i = 0; i < this.table[hash].size(); i++) {
                if (this.table[hash].get(i).getKey().equals(key)) {
                    return this.table[hash].get(i).getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int hash = this.hashKey(key);
        if (!this.table[hash].isEmpty()) {
            for (int i = 0; i < this.table[hash].size(); i++) {
                if (this.table[hash].get(i).getKey().equals(key)) {
                    this.table[hash].remove(i);
                    return;
                }
            }
        }
    }

    private int hashKey(K key) {
        return key.hashCode() % this.table.length;
    }
}
