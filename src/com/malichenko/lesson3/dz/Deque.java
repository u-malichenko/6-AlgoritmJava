package com.malichenko.lesson3.dz;

import java.io.IOException;
import java.util.NoSuchElementException;

//2. Создать класс для реализации дека.
class Deque {
    private int capacity;
    private int[] queue;
    private int head;
    private int tail;
    private int items;

    public Deque(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        head = 0; // Индекс первого (самого старого) элемента.
        tail = -1; // Индекс последнего (самого нового) элемента.
        items = 0;
    }

    public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == capacity;
    }

    public int size() {
        return items;
    }

    public void insertTail(int value) {
        if (isFull())
            allocateNewArray();
        if (tail == capacity - 1)
            tail = -1;
        queue[++tail] = value;
        items++;
        if (items == 1)
            head = tail;
    }

    public void insertHead(int value) {
        if (isFull())
            allocateNewArray();
        if (head == 0)
            head = capacity;
        queue[--head] = value;
        items++;
        if (items == 1)
            tail = head;
    }

    public int removeTail() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int temp = queue[tail--];
        if (tail == -1) {
            // Если tail установлен на начало массива, переходим к концу.
            tail = queue.length - 1;
        }
        items--;
        return temp;
    }

    public int removeHead() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        int temp = queue[head++];
        head %= capacity; // if (head == capacity) head = 0;
        items--;
        return temp;
    }

    public int peekTail() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return queue[tail];
    }

    public int peekHead() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return queue[head];
    }

    public void allocateNewArray() {
        capacity *= 2;
        int[] newQ = new int[capacity];
        if (tail >= head) {
            System.arraycopy(queue, 0, newQ, 0, queue.length);
        } else {
            System.arraycopy(queue, 0, newQ, 0, tail + 1);
            System.arraycopy(queue, head,
                    newQ, capacity - (queue.length - head),
                    queue.length - head);
        }
        head = capacity - (queue.length - head);
        queue = newQ;
    }
}

class DequeApp {
    public static void main(String[] args) throws IOException {
        Deque q = new Deque(5);
        q.insertTail(1);
        q.insertTail(2);
        q.insertTail(3);
        q.insertTail(4);
        q.insertTail(5);
        q.insertTail(6);
        q.insertTail(7);
        q.insertTail(8);
        q.insertHead(9);
        q.insertHead(10);
        q.insertHead(11);
        q.insertHead(12);
        q.insertHead(13);
        q.insertHead(14);

        while (!q.isEmpty()) {
            int item = q.removeTail();
            System.out.print(item + " ");
        }
        System.out.println("");
    }
}
