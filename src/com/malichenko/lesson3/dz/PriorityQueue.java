package com.malichenko.lesson3.dz;

import java.io.IOException;
import java.util.NoSuchElementException;

class PriorityQueue {
    private int capacity;
    private int[] queue;
    private int items;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[this.capacity];
        items = 0;
    }

    public void insert(int value) {
        if (isFull())
            allocateNewArray();
        int i;
        if (items == 0)
            queue[items++] = value;
        else {
            for (i = items - 1; i >= 0; i--) {
                if (value > queue[i])
                    queue[i + 1] = queue[i];
                else
                    break;
            }
            queue[i + 1] = value; // Вставка элемента
            items++;
        }
    }

    public int remove() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return queue[--items];
    }

    public long peek() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return queue[items - 1];
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == capacity);
    }

    public void allocateNewArray(){
            capacity *= 2;
            int[] newQueue = new int[capacity];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
        queue = newQueue;
    }
}

class PriorityQApp {
    public static void main(String[] args) throws IOException {
        PriorityQueue q = new PriorityQueue(5);
        q.insert(30);
        q.insert(50);
        q.insert(10);
        q.insert(40);
        q.insert(20);
        q.insert(120);
        q.insert(220);
        q.insert(0);
        while (!q.isEmpty()) {
            int item = q.remove();
            System.out.print(item + " ");
        }
        System.out.println("");
    }
}
