package com.malichenko.lesson4.dz;

import com.malichenko.lesson4.Cat;

public class Iterator {
    private Node current;
    private Node previous;
    private DoubleRelatedList list;

    public Iterator(DoubleRelatedList list) {
        this.list = list;
        reset();
    }

    public Node getCurrent() {
        return current;
    }

    public Node getPrevious() {
        return previous;
    }

    public void reset() {
        current = list.getHead();
        previous = null;
    }

    public boolean atEnd() {
        return (current.next == null);
    }

    public Node next() {
        previous = current;
        current = current.next;
        return previous;
    }

    public Node hasNext() {
        return current.next;
    }

    public void insertAfter(Cat c) {
        Node newNode = new Node(c);
        if (list.isEmpty()) {
            list.setHead(newNode);
            list.setTail(newNode);
            reset();
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next = newNode;
            next();
        }
    }

    public void insertBefore(Cat c) {
        Node newNode = new Node(c);
        if (list.isEmpty()) {
            list.setHead(newNode);
            list.setTail(newNode);
            reset();
        } else if (previous == null) {
            newNode.next = current;
            current.prev = newNode;
            list.setHead(newNode);
            reset();
        } else {
            newNode.next = previous.next;
            previous.next = newNode;
            next();
        }
    }

    public Node deleteCurrent() {
        Node node = current;
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
        return node;
    }
}