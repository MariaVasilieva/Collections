package org.example.HashTable;

public class Node<K,V> {
    Entity<K,V> entity;
    Node<K,V> next;
    Node<K,V> prev;
    Node(Entity<K,V> entity) {
        this.entity = entity;
    }
}
