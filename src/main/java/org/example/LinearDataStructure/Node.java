package org.example.LinearDataStructure;

public class Node <T>{
    T data;
    Node<T> next;
    //Node<T> prev;
    Node(T data) {
        this.data = data;
        this.next = null;
    }
}