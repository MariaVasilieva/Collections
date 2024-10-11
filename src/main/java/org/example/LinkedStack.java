package org.example;

public class LinkedStack <T>{
    class Node <T>{
        T data;
        Node<T> prev;
        Node(T data){
            this.data = data;
        }
    }
    private Node<T> top;
    public void push(T data){
        Node<T> newNode = new Node<>(data);
        newNode.prev = top;
        top = newNode;
    }
    public T pop(){
        if(top == null){
            System.out.println("Stack is empty");
            return null;
        }
        T data = top.data;
        top = top.prev;
        return data;
    }
    public T peek(){
        if(top == null){
            return null;
        }
        return top.data;
    }
    public void print(){
        Node<T> current = top;
        while(current != null){
            System.out.println(current.data);
            current = current.prev;
        }
    }
}
