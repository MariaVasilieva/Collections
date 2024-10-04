package org.example;

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
