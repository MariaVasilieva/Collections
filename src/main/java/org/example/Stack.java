package org.example;

public class Stack <T>{
    private T[] stack;
    private int top;
    public Stack() {
        stack = (T[]) new Object[10];
        top = -1;
    }
    public Stack(int size){
        stack = (T[]) new Object[size];
        top = -1;
    }
    public void push(T item){
        if(isFull()){
            extendArray();
        }
        stack[++top] = item;
    }
    public T pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        T elementToDelete = stack[top];
        stack[top] = null;
        top--;
        return elementToDelete;
    }
    private boolean isFull(){
        return top == stack.length - 1;
    }
    private boolean isEmpty(){
        return top == -1;
    }
    private void extendArray() {
        T[] newArray = (T[]) new Object[stack.length * 2];
        System.arraycopy(stack, 0, newArray, 0, stack.length);
    }
    public void print(){
        for (int i = top; i >=0 ; i--) {
            System.out.println(stack[i]);
        }
    }
}
