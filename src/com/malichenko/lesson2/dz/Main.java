package lesson2_1;

public class Main {
    public static final int sizeArr = 10;
    public static final int rangeMin = 0;
    public static final int rangeMax = 20;

    public static void main(String[] args) {
        Array arr = new Array(sizeArr);
        initArr(arr);
        System.out.println("array: " + arr);

//        arr.bubbleSortEven();
//        System.out.println("bubbleSortEven(): " + arr);

        arr.sortCount();
        System.out.println("sortCount: " + arr);

        arr.sortCountWithoutRestrict();
        System.out.println("sortCountWithoutRestrict: " + arr);

        arr.sortCounting();
        System.out.println("sortCount: " + arr);

        arr.sortBubble();
        System.out.println("sortBubble: " + arr);

        arr.sortSelect();
        System.out.println("sortSelect: " + arr);

        arr.sortInsert();
        System.out.println("sortInsert: " + arr);

        arr.binarySearch(67);
        arr.sortCounting();

        arr.deleteVal(5);
        System.out.println("deleteVal(5): " + arr);

        arr.deleteIndex(1);
        System.out.println("deleteIndex(1): " + arr);

        arr.deleteAll();
        System.out.println("deleteAll: " + arr);
    }

    private static int random(int min, int max) {
        max -= min;
        return (int)(Math.random() * ++max) + min;
    }

    public static void initArr(Array arr) {
        for (int i = 0; i < sizeArr; i++) {
            arr.set(i, random(rangeMin, rangeMax));
        }
    }
}
