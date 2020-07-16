package com.malichenko.lesson2.dz;

import java.util.Map;
import java.util.TreeMap;

public class Array {
    private int[] arr;
    private int size;
    private boolean isSorted;

    private Array() {
        this.isSorted = false;
    }

    public Array(int capacity) {
        this();
        arr = new int[capacity];
        this.size = 0;
    }

    //Инициализация массива пустыми элементами
    public Array(int capacity, int size) {
        this(capacity);
        this.size = size;
    }

    public Array(int... args) {
        this();
        this.size = args.length;
        this.arr = args;
    }

    public int get(int index) {
        if (index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        return arr[index];
    }

    public void set(int index, int value) {
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index] = value;
        size++;
    }

    public void increment(int index) {
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index);
        arr[index]++;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int[] getArr() {
        return arr;
    }

    public boolean getIfNotNull(int index){
        return arr[index] > 0;
    }

    private void increaseCapacity(int value) {
        int[] temp = arr;
        arr = new int[value + 1];
        System.arraycopy(temp, 0, arr, 0, size);
        size = arr.length;
    }

    public void append(int value) {
        if (size <= value) {
            increaseCapacity(value);
        }
    }

    public int deleteLast() {
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException(-1);
        return arr[--size];
    }

    // homework
    // insert(index, value); это то же, что и set(int index, int value)

    /**
     * Сдвиг элементов массива
     */
    public void shiftArr(int index) {
        for (int i = index; i < size-1; i++) {
            arr[i] = arr[i+1];
        }
        size--;
    }

    /**
     * Удаление элемента массива по значению
     */
    public int deleteVal(int val) {
        int index;
        if ((index = find(val)) == -1) return -1;
        shiftArr(index);
        return val;
     }

    /**
     * Удаление элемента массива по индексу
     */
    public int deleteIndex(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        shiftArr(index);
        return index;
    }

    public void deleteAll() {
        size = 0;
    }

    public int find(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value)
                return i;
        }
        return -1;
    }

    public boolean hasValue(int value) {
        if (!isSorted)
            throw new RuntimeException("try the 'find' method");

        int l = 0;
        int r = size;
        int m;
        while (l < r) {
            m = (l + r) >> 1; // (l + r) / 2
            if (value == arr[m])
                return true;
            else if (value < arr[m])
                r = m;
            else
                l = m + 1;
        }
        return false;
    }

    private void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortBubble() {
        int i, j = 0;
        for (i = 0; i < size; i++) {
            for (j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(j, j + 1);
            }
        }
        isSorted = true;
        System.out.println("Bubble: " + i + " " + j);
    }

    /**
     * Улучшение пузырьковой сортировки.
     * Сравниваем вначале четные, затем нечетные. Если перестановки не было, выходим
     */
    public void bubbleSortEven() {
        int i, j = 0;
        boolean shift;
        for (i = 0; i < size; i++) {
            shift = false;
            for (j = 0;  j < size - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(j, j + 1);
                    shift = true;
                }
            }
            for (j = 1;  j < size - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(j, j + 1);
                    shift = true;
                }
            }
            if (!shift) return;
        }
    }

    public void sortSelect() {
        int flag, rem = 0;
        for (flag = 0; flag < size; flag++) {
            int cMin = flag;
            for (rem = flag + 1; rem < size; rem++) if (arr[rem] < arr[cMin]) cMin = rem;
            swap(flag, cMin);
        }
        isSorted = true;
        System.out.println("Select: " + flag + " " + rem);
    }

    public void sortInsert() {
        int out, in = 0;
        for (out = 0; out < size; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] >= temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            arr[in] = temp;
        }
        isSorted = true;
        System.out.println("Insert: " + out + " " + in);
    }

    /**
     * Сортировка подсчетом. Диапазон значений массива: 0 до Main.rangeMax+1.
     * В этих пределах работает генератор случайных чисел.
     * Время выполнения зависит от максимального значения массива:
     * О(max(arr)), т.к. О(N+max(arr)) => O(max(arr))
     * т.е. будет быстро выполняться, если максимальные значения элементов массива
     * небольшие и много повторяющихся
     */
    public void sortCounting() {
        int[] arrSort = new int[Main.rangeMax+1]; //значения от 0 до Main.rangeMax+1

        for (int i = 0; i < size; i++) {
             arrSort[arr[i]]++;
        }
        int num = 0;
        for (int i = 0; i < arrSort.length; i++) {
            for (int j = 0; j < arrSort[i]; j++) {
                arr[num] = i;
                num++;
            }
        }
    }

    /**
     * Сортировка подсчетом. Диапазон значений массива не ограничен.
     * Размер промежуточного массива увеличивается по мере необходимости.
     * Для этого воспользовалась методами из класса Array.java
     */
    public void sortCountWithoutRestrict() {
        int i, j;

        Array arrSort = new Array(101, 10);
        for (i = 0; i < size; i++) {
            arrSort.append(arr[i]);
            arrSort.increment(arr[i]);
        }
        //***************************
        //Вот тут можно было бы через Array.stream преобразовать этот массив в Map<Integer, Integer>,
        //чтобы избавиться от нулей!
//        long sum = Arrays.stream(arr).filter(s->getIfNotNull(s)).count();
//        map = Arrays.stream(arr).filter(s->getIfNotNull(s)).collect(Collectors.mapping(s->));
        //тогда бы кол-во операций свелось опять к кол-ву элементов в массиве!
        //*****************************
        int num = 0;
        for (j = 0; j < arrSort.getSize(); j++) {
            for (int k = 0; k < arrSort.getArr()[j]; k++) {
                arr[num++] = j;
            }
        }
        System.out.println("sortCountWithoutRestrict: " + i + " " + j);
    }

    /**
     * Тут я (к сожалению, без Stream), все запихнула в Map.
     * Время выполнения: О(N);
     */
    public void sortCount() {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < size; i++) {
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            } else {
                int val = map.get(arr[i]);
                map.put(arr[i], val++);
            }
        }

        int num = 0;
        for (Map.Entry<Integer, Integer> p : map.entrySet()) {
            int v = p.getValue();
            while(v-- > 0) arr[num++] = p.getKey();
        }
    }

    /**
     * Время доступа к элементам Map O(1)
     */
    public void arrToMap(Array arr, Map<Integer, Integer> map) {
        for (int i = 0; i < arr.size; i++) {
            if (arr.get(i) != 0) {
                map.put(i, arr.get(i));
            }
        }
    }

    public void binarySearch(int num) {
        int lowerBound = 0;
        int upperBound = size - 1;
        int curIn;
        int count = 0;

        if (!isSorted) {
            System.out.println("Массив не отсортирован!");
            return;
        }
        while (true) {
            count++;
            curIn = (lowerBound + upperBound) / 2;
            if (arr[curIn] == num) {
                System.out.printf("Двоичный поиск. Найдено число: a[%d] = %d", curIn, num);
                System.out.println(" Count: " + count);
                return;
            }
            if (lowerBound > upperBound) {
                System.out.println("Двоичный поиск. Элемент не найден");
                System.out.println(", Count: " + count);
                return;
            }
            if (arr[curIn] > num) {
                upperBound = curIn - 1;
            } else {
                lowerBound = curIn + 1;
            }
        }
    }

    @Override
    public String toString() {
        if (arr == null) return "null";
        int iMax = size - 1;
        if (iMax == -1) return "[]";

        StringBuilder b = new StringBuilder();
        b.append("size: ").append(size).append(", ");
        b.append("isSort: ").append(isSorted).append("\t");
        b.append('[');
        int i = 0;
        while (true) {
            b.append(arr[i]);
            if (i == iMax || i == 20) return b.append(']').toString();
            b.append(", ");
            i++;
        }
    }
}
