package org.example;

public class ArrayList<T> {
    private T[] array;
    private int lastIndex;

    public ArrayList() {
        array = (T[]) new Object[10];
        lastIndex = 0;
    }
    public void add(T element) {
        if(lastIndex == array.length) {
            extendArray();
        }
        array[lastIndex++] = element;
    }
    public void add(int index, T element) {
        if(index > lastIndex || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if(lastIndex == array.length) {
            extendArray();
        }
        for(int i = lastIndex - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        lastIndex++;
    }
    public T remove(int index) {
        if(index >= lastIndex || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T element = array[index];
        for(int i = index + 1; i < lastIndex; i++) {
            array[i - 1] = array[i];
        }
        lastIndex--;
        return element;
    }
    private void extendArray() {
        T[] newArray = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
    }
    public void print() {
        for(int i = 0; i < lastIndex; i++) {
            System.out.println(array[i]);
        }
    }
}
