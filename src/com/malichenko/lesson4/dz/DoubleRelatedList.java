package com.malichenko.lesson4.dz;

import com.malichenko.lesson4.Cat;

public class DoubleRelatedList {
    private Node head;
    private Node tail;

    public DoubleRelatedList() {
        head = null;
        tail = null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Iterator getIterator() {
        return new Iterator(this);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertHead(Cat c) {
        Node newNode = new Node(c);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    public void insertTail(Cat c) {
        Node newNode = new Node(c);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    public Cat removeHead() {
        if (isEmpty()) return null;
        Cat temp = head.c;
        if (head.next == null) {
            tail = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
        return temp;
    }

    public Cat removeTail() {
        if (isEmpty()) return null;
        Cat temp = tail.c;
        if (tail.prev == null) {
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
        return temp;
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(Cat c) {
        return find(c) == null;
    }

    private Node find(Cat c) {
        if (isEmpty()) return null;
        Node current = head;
        while (!current.c.equals(c)) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }

    public boolean deleteElem(Cat c) {
        if (isEmpty()) return false;
        Node current = head;
        Node previous = head;
        while (!current.c.equals(c)) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = previous;
            tail.next = null;
        } else {
            previous.next = current.next;
            current.next.prev = previous;
        }
        return true;
    }
}
