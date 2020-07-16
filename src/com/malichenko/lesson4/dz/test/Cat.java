package com.malichenko.lesson4.dz.test;

class Cat {
    public String name;
    public int age;
    public Cat next;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Name: " + this.name + ", age: " + this.age);
    }
}