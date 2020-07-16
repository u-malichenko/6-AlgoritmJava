package com.malichenko.lesson4;

import com.malichenko.lesson4.dz.DoubleRelatedList;
import com.malichenko.lesson4.dz.Iterator;

public class Main {
    public static void main(String[] args) {
        DoubleRelatedList rl = new DoubleRelatedList();
        Cat cat2 = new Cat(2, "cat2");
        Cat cat5 = new Cat(5, "cat5");
        Cat cat7 = new Cat (7,"Cat7");
        Cat cat8 = new Cat (8,"Cat8");

        rl.insertHead(new Cat(1, "cat1"));
        rl.insertHead(cat2);
        rl.insertHead(new Cat(3, "cat3"));
        rl.insertTail(new Cat(4, "cat4"));
        rl.insertTail(cat5);
        rl.insertTail(new Cat(6, "cat6"));

        System.out.println(rl);
//        System.out.println(rl.removeHead());
//        System.out.println(rl.removeTail());
//        System.out.println(rl);
//        System.out.println(rl.deleteElem(cat5));
//        System.out.println(rl);
//        System.out.println(rl.deleteElem(cat2));
//        System.out.println(rl);

        Iterator it = new Iterator(rl);

        System.out.println(it.next().toString());
        System.out.println(it.next().toString());
        System.out.println(it.getCurrent().toString());

        it.insertAfter(cat7);
        System.out.println(rl);
        System.out.println(it.getCurrent().toString());

        it.insertBefore(cat8);
        System.out.println(rl);
        System.out.println(it.getCurrent().toString());

    }
    //reset();
    //next();
    //getCurrent();
    //hasNext();
    //atEnd();
    //insertAfter();
    //*insertBefore();
    //deleteCurrent();

}
