package com.malichenko.lesson3.dz;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// немного переработанный вариант с https://tproger.ru/translations/stacks-and-queues-for-beginners/
public class Deque2<T> {
    List<T> items = new ArrayList<>(0);

    // Количество элементов в очереди.
    int size = 0;

    // Индекс первого (самого старого) элемента.
    int head = 0;

    // Индекс последнего (самого нового) элемента.
    int tail = -1;

    public void EnqueueFirst(T item) {
        // Проверим, необходимо ли увеличение массива:
        if (items.size() == size) {
            allocateNewArray(1);
        }

        // Так как массив не заполнен и _head больше 0,
        // мы знаем, что есть место в начале массива.
        if (head > 0) {
            head--;
        } else {
            // В противном случае мы должны закольцеваться.
            head = items.size() - 1;
        }
        items.set(head, item);
        size++;
        if (size == 1) {
            // Если мы добавили первый элемент в пустую
            // очередь, он же будет и последним, поэтому
            // нужно обновить и _tail.
            tail = head;
        }
    }

    public void EnqueueLast(T item) {
        // Проверим, необходимо ли увеличение массива:
        if (items.size() == size) {
            allocateNewArray(0);
        }

        // Теперь, когда у нас есть подходящий массив,
        // если _tail в конце массива, нам надо перейти в начало.
        if (tail == items.size() - 1) {
            tail = 0;
        } else {
            tail++;
        }
        items.set(tail, item);
        size++;
        if (size == 1) {
            // Если мы добавили последний элемент в пустую
            // очередь, он же будет и первым, поэтому
            // нужно обновить и _head.
            head = tail;
        }
    }

    public T DequeueFirst() {
        if (size == 0) {
            throw new NoSuchElementException("The deque is empty");
        }

        T value = items.get(head);

        if (head == items.size() - 1) {
            // Если head установлен на последнем индексе, переходим к началу массива.
            head = 0;
        } else {
            // Переходим к следующему элементу.
            head++;
        }
        size--;
        return value;
    }

    public T DequeueLast() {
        if (size == 0) {
            throw new NoSuchElementException("The deque is empty");
        }

        T value = items.get(tail);

        if (tail == 0) {
            // Если tail установлен на начало массива, переходим к концу.
            tail = items.size() - 1;
        } else {
            // Переходим к предыдущему элементу.
            tail--;
        }
        size--;
        return value;
    }

    public T PeekFirst() {
        if (size == 0) {
            throw new NoSuchElementException("The deque is empty");
        }
        return items.get(head);
    }

    public T PeekLast() {
        if (size == 0) {
            throw new NoSuchElementException("The deque is empty");
        }
        return items.get(tail);
    }

    public int Count() {
        return size;

    }

    private void allocateNewArray(int startingIndex) {
        int newLength = (size == 0) ? 4 : size * 2;
        List<T> newArray = new ArrayList<>(newLength);

        if (size > 0) {
            int targetIndex = startingIndex;

            // Копируем содержимое...
            // Если массив не закольцован, просто копируем элементы.
            // В противном случае, копирует от head до конца, а затем от начала массива до tail.

            // Если tail меньше, чем head, переходим в начало.
            if (tail < head) {
                // Копируем _items[head].._items[end] в newArray[0]..newArray[N].
                for (int index = head; index < items.size(); index++) {
                    newArray.set(targetIndex, items.get(index));
                    targetIndex++;
                }

                // Копируем _items[0].._items[tail] в newArray[N+1]..
                for (int index = 0; index <= tail; index++) {
                    newArray.set(targetIndex, items.get(index));
                    targetIndex++;
                }
            } else {
                // Копируем _items[head].._items[tail] в newArray[0]..newArray[N]
                for (int index = head; index <= tail; index++) {
                    newArray.set(targetIndex, items.get(index));
                    targetIndex++;
                }
            }
            head = startingIndex;
            tail = targetIndex - 1;
        } else {
            // Массив пуст.
            head = 0;
            tail = -1;
        }
        items = newArray;
    }
}
