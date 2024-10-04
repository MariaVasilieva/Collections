package org.example;

import java.util.NoSuchElementException;

public class LinkedList <T>{
    private Node<T> head;
    private int size;
    LinkedList(){
        head = null;
        size = 0;
    }
    public void addFirst(T value){
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }
    public void addLast(T value){
        Node<T> newNode = new Node<>(value);
        if(head == null){
            head = newNode;
        }
        else{
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    public void insertAt(int index, T value){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            addFirst(value);
            return;
        }
        if (index == size){
            addLast(value);
            return;
        }
        Node<T> current = head;
        for(int i = 0; i < index-1; i++){
            current = current.next;
        }
        Node<T> newNode = new Node<>(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }
    public T removeFirst(){
        if(head == null){
            throw new NoSuchElementException();
        }
        T value = head.data;
        head = head.next;
        size--;
        return value;
    }
    public T removeAt(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            return removeFirst();
        }
        Node<T> current = head;
        for(int i = 0; i < index-1; i++){
            current = current.next;
        }
        T value = current.data;
        current.next = current.next.next;
        size--;
        return value;
    }
    public String toString(){
        Node<T> current = head;
        String result = "";
        while(current != null){
            result += current.data + " ";
            current = current.next;
        }
        return result;
    }
}
