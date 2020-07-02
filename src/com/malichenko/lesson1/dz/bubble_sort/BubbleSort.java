package com.malichenko.lesson1.dz.bubble_sort;

/**
 * Пузырьковая сортировка
 */
public class BubbleSort {
    private final long[] arr;

    public BubbleSort(long[] arr) {
        this.arr = arr;
    }

    public long getElement(int index) {
        return arr[index];
    }

    public void printArr() {
        for (long a : arr) {
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }

    /**
     * Так как внешний цикл выполняется N раз, внутренний цикл также выполняется N раз,
     * то время выполнения алгоритма равно O(N^2).
     * Или:
     *  - количество сравнений: 4+3+2+1=10, т.е. 5^2 = 10, где 5 размер массива. Что эквивалентно
     * N*(N-1)/2. Применяя правила О, получим: N^2.
     *  - количество перестановок (в худшем случае) также равно N*(N-1)/2. Или N^2.
     *  Следовательно, общее время: N^2 + N^2 = 2N^2. Так как константы не учитываются, то
     *  пузырьковая сортировка выполняется за время N^2.
     */
    public void bubbleSort() {
        for (int i = arr.length-1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    long temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

class BubbleSortApp {
    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort(new long[]{5, 85, 69, -5, 89});
        sort.printArr();
        sort.bubbleSort();
        sort.printArr();
        System.out.println("Минимальный элементв массиве: " + sort.getElement(0));
    }
}
