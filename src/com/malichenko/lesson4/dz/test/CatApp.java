package com.malichenko.lesson4.dz.test;

public class CatApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertHead("Вася", 3);
        list.insertHead("Мурка", 1);
        list.insertHead("Барсик", 5);
        list.insertTail("София", 4);
        list.display();
        System.out.println("Удаление элементов списка");
        list.delete("Барсик");
        list.display();
    }
}