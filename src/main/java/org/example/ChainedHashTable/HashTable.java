package org.example.ChainedHashTable;

public class HashTable <K,V>{
    private Node<K,V>[] table;
    private int size;
    public HashTable(){
        table = new Node[10];
        size = 10;
    }
    private int hashFunc(K key){
        return (int)key%size;
    }
    public void put(K key, V value) throws Exception {
        int index = hashFunc(key);
        if(table[index] == null){
            table[index] = new Node<>(new Entity<>(key, value));
        }
        else{
            Node<K,V> cur = table[index];
            while(cur.next != null){
                if(cur.entity.getKey().equals(key)){
                    throw new Exception("Key already exist");
                }
                cur = cur.next;
            }
            if(cur.entity.getKey().equals(key)){
                throw new Exception("Key already exist");
            }
            Node<K,V> newNode = new Node<>(new Entity<>(key, value));
            cur.next = newNode;
            newNode.prev = cur;
        }
    }
    public V get(K key) {
        int index = hashFunc(key);
        Node<K,V> cur = table[index];
        while(cur != null) {
                if(cur.entity.getKey().equals(key)) {
                    return cur.entity.getValue();
                }
                cur = cur.next;
        }
        return null;
    }
    public V remove(K key) {
        int index = hashFunc(key);
        Node<K,V> cur = table[index];
        while(cur != null) {
            if(cur.entity.getKey().equals(key)) {
                if(cur.prev == null) {
                    table[index] = cur.next;
                    cur.next.prev = null;
                } else if (cur.next == null) {
                    cur.prev.next = null;
                } else {
                    //видалення елемента
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }

            }
            cur = cur.next;
        }
        return null;
    }


}
