
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Бинарный поиск. На входе упорядоченный массив.
 * Если искомый элемент в списке существует, то  этот элемент выводится в консоль.
 * В противном случае, выводится null. Выполняется за время O(logN).
 */
public class BinarySearch {
    long[] arr;
    int lowerBound = 0;
    int upperBound;
    int curIn;

    public BinarySearch(long[] arr) {
        this.arr = arr;
        this.upperBound = arr.length - 1;
    }

    public void binarySearch(long num) {
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (arr[curIn] == num) {
                System.out.printf("Найдено число: a[%d] = %d", curIn, num);
                return;
            }
            if (lowerBound > upperBound) {
                System.out.println("Элемент не найден");
                return;
            }
            if (arr[curIn] > num) {
                upperBound = curIn - 1;
            } else {
                lowerBound = curIn + 1;
            }
        }
    }
}

class BinarySearchApp{
    public static void main(String[] args) throws IOException {
        BinarySearch arr = new BinarySearch(new long[]{7,17,27,37,47,57,67,77,87});

        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число для поиска: ");
        int num = Integer.parseInt(buff.readLine());
        arr.binarySearch(num);
    }
}
