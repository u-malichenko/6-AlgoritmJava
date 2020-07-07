package com.malichenko.lesson4.dz;

import com.malichenko.lesson4.Cat;

import java.util.Objects;

public class Node {
    protected Cat c;
    protected Node next;
    protected  Node prev;

    public Node(Cat c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return c.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return c.equals(node.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(c);
    }
}