package org.example;

public class Client {
    private String name;
    private int age;
    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
