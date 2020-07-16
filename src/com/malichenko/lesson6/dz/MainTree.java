package com.malichenko.lesson6.dz;

import com.malichenko.lesson4.Cat;
import com.malichenko.lesson6.Tree;

import java.util.ArrayList;
import java.util.List;

public class MainTree {
    List<Tree> treeCat = new ArrayList<>();
    static int max = 100;
    static int min = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            newTree();
        }
    }

    public static Tree newTree() {
        Tree tree = new Tree();
        while (tree.getHeight(tree.getRoot()) < 6) {
            String name = String.valueOf((char) (65 + rnd(65, 90)));
            int age = rnd(min, max);
            tree.insert(new Cat(age, name));
        }
        tree.displayTree();
        System.out.println();
        System.out.println(tree.isBalance(tree.getRoot()) ? "Balanced" : "Unbalanced");
        return tree;
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

}
