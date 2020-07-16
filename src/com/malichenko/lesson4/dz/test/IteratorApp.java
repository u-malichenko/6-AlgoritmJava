package com.malichenko.lesson4.dz.test;

public class IteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertHead("Вася", 3);
        list.insertHead("Мурка", 1);
        list.insertHead("Барсик", 5);
        list.insertTail("София", 4);

        Iterator itr = new Iterator(list);
        itr.insertAfter("Марсель", 2);
        itr.insertBefore("Жуча", 6);
        list.display();
    }
}