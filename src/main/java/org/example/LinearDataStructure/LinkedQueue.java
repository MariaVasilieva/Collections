package org.example.LinearDataStructure;

public class LinkedQueue <T>{
    class Node <T>{
        T data;
        Node<T> next;
        public Node(T data) {
            this.data = data;
        }
    }
    private Node front;
    private Node rear;
    public void enqueue(T data) {
        Node newNode = new Node(data);
        if(front == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    public T dequeue() {
        if(front == null) {
            return null;
        }
        if(front == rear) {
            rear = null;
        }
        T toDelete = (T)front.data;
        front = front.next;
        return toDelete;
    }
    public void print(){
        Node current = front;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
