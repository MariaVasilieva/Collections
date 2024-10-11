package org.example;

public class Main {
    public static void main(String[] args) {
        LinkedQueue <String> queue = new LinkedQueue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        System.out.println("Before:");
        queue.print();
        System.out.println("After:");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }
}