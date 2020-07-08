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
        if(current.next != null) {
            return current.next;
        }else return null;
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
//    @Override
//    public void insertAfter(T c) {
//        if (!listExists()) throw new RuntimeException("iterator is null");
//        Node<T> temp = new Node<>(c);
//        if (!atEnd()) {
//            temp.next = current.next;
//            current.next.prev = temp;
//        } else {
//            tail = temp;
//        }
//        current.next = temp;
//        temp.prev = current;
//    }

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
//    @Override
//    public void insertBefore(T c) {
//        if (!listExists()) throw new RuntimeException("iterator is null");
//        Node<T> temp = new Node<>(c);
//        if (!atBegin()) {
//            temp.prev = current.prev;
//            current.prev.next = temp;
//        } else {
//            head = temp;
//        }
//        current.prev = temp;
//        temp.next = current;
//    }

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
//    @Override
//    public T deleteCurrent() {
//        if (!listExists()) throw new RuntimeException("iterator is null");
//        T temp = current.c;
//        if (atBegin() && atEnd()) {
//            head = null;
//            tail = null;
//            reset(); //current = head;
//        } else if (atBegin()) {
//            head = current.next;
//            head.prev = null;
//            reset(); //current = head;
//        } else if (atEnd()) {
//            tail = current.prev;
//            tail.next = null;
//            current = current.next;
//        } else {
//            current.prev.next = current.next;
//            current.next.prev = current.prev;
//        }
//        return temp;
//    }
}