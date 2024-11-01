package org.example.HashTable;

public class Entity <K,V>{
    private K key;
    private V value;
    public Entity(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
