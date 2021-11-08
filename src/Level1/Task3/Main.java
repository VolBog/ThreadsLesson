package Level1.Task3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Input array length n=");
        n = sc.nextInt();

        int[] array = new int[n];
        Random Rand = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = Rand.nextInt(n);
        }
        System.out.println(Arrays.toString(array));
        System.out.println();
        long start1 = System.currentTimeMillis();
       // ArraySort.arraySort(array);

        long end1 = System.currentTimeMillis();
        System.out.println("Це зайняло: " + (end1 - start1) + " мілісекунд");
     //   System.out.println(Arrays.toString(array));
        MultiThreadShell multiThreadShell = new MultiThreadShell();
        try {
            multiThreadShell.sortArray(array);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(array));
    }
}
