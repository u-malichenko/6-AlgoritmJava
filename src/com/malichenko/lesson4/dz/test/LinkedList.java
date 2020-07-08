package com.malichenko.lesson4.dz.test;

class LinkedList {
    private Cat head;
    private Cat tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public Cat getHead() {
        return head;
    }

    public void setHead(Cat head) {
        this.head = head;
    }

    public Cat getTail() {
        return tail;
    }

    public void setTail(Cat tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void insertHead(String name, int age) {
        Cat newCat = new Cat(name, age);
        if (this.isEmpty())
            tail = newCat;
        newCat.next = head;
        head = newCat;
    }

    public void insertTail(String name, int age) {
        Cat newCat = new Cat(name, age);
        if (this.isEmpty()) {
            head = newCat;
        } else {
            tail.next = newCat;
        }
        tail = newCat;
    }

    public Cat deleteHead() {
        Cat temp = head;
        if (head.next == null)
            tail = null;
        head = head.next;
        return temp;
    }

    public Iterator getIterator(LinkedList list) {
        return new Iterator(this);
    }

    public void display() {
        Cat current = head;
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    public Cat find(String name) {
        Cat current = head;
        while (current.name != name) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public Cat delete(String name) {
        Cat current = head;
        Cat previous = head;
        while (current.name != name) {
            if (current.next == null)
                return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head)
            head = head.next;
        else
            previous.next = current.next;
        return current;
    }
}