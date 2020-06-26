import java.util.Arrays;

/**
 * Нахождение среднего арифметического массива.
 */
public class ArithmeticMeanArr {
    private final long[] arr;

    public ArithmeticMeanArr(long[] arr) {
        this.arr = arr;
    }

    public void printArr() {
        for (long a : arr) {
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }

    /**
     * Время выполнения алгоритма О(N), так как осуществляется проход массива 1 раз, то есть N
     */
    public long arithmeticMean() {
        long sum = 0;
        for (long p : arr) {
            sum += p;
        }
        return sum/arr.length;
    }

    public long arithmeticMeanSt(){
        long sum = Arrays.stream(arr).sum();
//        return (long) Arrays.stream(arr).average().orElse(Double.NaN); //в одну строчку...
        return sum/arr.length;
    }
}

class ArithmeticMeanApp {
    public static void main(String[] args) {
        ArithmeticMeanArr arr = new ArithmeticMeanArr(new long[]{5, 85, 69, -5, 89, -56, 57});
        arr.printArr();
        System.out.println("Среднее арифметическое массива: " + arr.arithmeticMean());
        System.out.println("Среднее ариф. массива с исп.Stream API: " + arr.arithmeticMeanSt());
    }
}
