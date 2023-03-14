import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] x = new int[1000000];
        for(int i=0;i<x.length;i++) {
            x[i] = i;
        }

        long start = System.nanoTime();
        int index = linearSearch(900000,x);
        long end = System.nanoTime();
        System.out.println("linear  = "+(end-start)+", index: "+index);
        start = System.nanoTime();
       // index = binarySearch(900000,x);
        index = Arrays.binarySearch(x, 900000);
        end = System.nanoTime();
        System.out.println("binary  = "+(end-start)+", index: "+index);
    }

    public static int linearSearch(int value, int[] array) {
        for(int i=0;i< array.length;i++) {
            if(value == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int value, int[] array) {
        int low = 0;
        int high = array.length;

        while (low <= high) {
            int mid = (low + high)/2;
            long midVal = array[mid];
            if (midVal < value)
                low = mid + 1;
            else if (midVal > value)
                high = mid;
            else
                return mid;
        }
        return -1;
    }
}