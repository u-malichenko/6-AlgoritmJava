package com.malichenko.lesson4.dz.test;

public class Iterator {
    private Cat current;
    private Cat previous;
    private LinkedList list;

    public Iterator(LinkedList list) {
        this.list = list;
        this.reset();
    }

    //hasNext();

    public void reset() {
        current = list.getHead();
        previous = null;
    }

    public boolean atEnd() {
        return (current.next == null);
    }

    public void next() {
        previous = current;
        current = current.next;
    }

    public Cat getCurrent() {
        return current;
    }

    public void insertAfter(String name, int age) {
        Cat newLink = new Cat(name, age);
        if (list.isEmpty()) {
            list.setHead(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            next();
        }
    }

    public void insertBefore(String name, int age) {
        Cat newCat = new Cat(name, age);
        if (previous == null) {
            newCat.next = list.getHead();
            list.setHead(newCat);
            reset();
        } else {
            newCat.next = previous.next;
            previous.next = newCat;
            current = newCat;
        }
    }

    public String deleteCurrent() {
        String name = current.name;
        if (previous == null) {
            list.setHead(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }
        return name;
    }
}

