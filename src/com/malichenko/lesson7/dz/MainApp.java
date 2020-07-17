package com.malichenko.lesson7.dz;

import com.malichenko.lesson7.Graph;

public class MainApp {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("Автово");
        graph.addVertex("Кировский завод");
        graph.addEdge(0,1);
        graph.addVertex("Нарвская");
        graph.addEdge(1,2);
        graph.addVertex("Балтийская");
        graph.addEdge(2,3);
        graph.addVertex("Технологический институт 1"); //4
        graph.addEdge(3,4);
        graph.addVertex("Пушкинская");//5
        graph.addEdge(4,5);
        graph.addVertex("Владимирская");//6
        graph.addEdge(5,6);
        graph.addVertex("Площадь Восстания");//7
        graph.addEdge(6,7);
        graph.addVertex("Чернышевская");
        graph.addEdge(7,8);
        graph.addVertex("Площадь Ленина");
        graph.addEdge(8,9);
        graph.addVertex("Выборгская");//10
        graph.addEdge(9,10);


        graph.addVertex("Фрунзенская");
        graph.addVertex("Технологический институт 2");//12
        graph.addEdge(11,12);
        graph.addVertex("Сенная площадь");//13
        graph.addEdge(12,13);
        graph.addVertex("Невский проспект");//14
        graph.addEdge(13,14);
        graph.addVertex("Горьковская");
        graph.addEdge(14,15);
        graph.addVertex("Петроградская");//16
        graph.addEdge(15,16);

        graph.addVertex("Елизаровская");
        graph.addVertex("Площадь Александра Невского 1");//18
        graph.addEdge(17,18);
        graph.addVertex("Маяковская");//19
        graph.addEdge(18,19);
        graph.addVertex("Гостиный двор");//20
        graph.addEdge(19,20);
        graph.addVertex("Василеостровская");//21
        graph.addEdge(20,21);


        graph.addVertex("Новочеркасская");
        graph.addVertex("Площадь Александра Невского 2");//23
        graph.addEdge(22,23);
        graph.addVertex("Лиговский проспект");
        graph.addEdge(23,24);
        graph.addVertex("Достоевская");//25
        graph.addEdge(24,25);
        graph.addVertex("Спасская");//26
        graph.addEdge(25,26);

        graph.addVertex("Волковская");
        graph.addVertex("Обводный канал");
        graph.addEdge(27,28);
        graph.addVertex("Звенигородская");//29
        graph.addEdge(28,29);
        graph.addVertex("Садовая"); //30
        graph.addEdge(29,30);
        graph.addVertex("Адмиралтейская");
        graph.addEdge(30,31);
        graph.addVertex("Спортивная");
        graph.addEdge(31,32); //32
        graph.addEdge(4,12);
        graph.addEdge(5,29);
        graph.addEdge(6,25);
        graph.addEdge(7,19);
        graph.addEdge(18,23);
        graph.addEdge(14,20);
        graph.addEdge(26,30);
        graph.addEdge(30,13);
        graph.addEdge(13,26);


        graph.minPatch(27,32);

    }



}
