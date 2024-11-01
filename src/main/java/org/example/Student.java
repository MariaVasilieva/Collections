package org.example;

public class Student implements Cloneable {
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student clone() {
        return new Student(name, age);
    }

    public void setAge(int age) {
        this.age = age;
    }
}
