package com.malichenko.lesson1.dz.selection_sort;

/**
 * Сортировка методом выбора.
 */
public class SelectionSort {
    private final long[] arr;

    public SelectionSort(long[] arr) {
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
    * В отличие от пузырьковой сортировки, перестановка элементов выполняется один раз за проход.
     * Но учитывая правила О(), получим время выполнения такое-же, как и у пузырьковой сортировки:
     * N^2.
     */
    public void selectionSort() {
        int i, j, min;
        for (i = 0; i < arr.length-1; i++) {
            min = i;
            for (j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            long temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}

class SelectionSortApp {
    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort(new long[]{5, 85, 69, -5, 89, -56, 57});
        sort.printArr();
        sort.selectionSort();
        sort.printArr();
        System.out.println("Минимальный элементв массиве: " + sort.getElement(0));
    }
}
