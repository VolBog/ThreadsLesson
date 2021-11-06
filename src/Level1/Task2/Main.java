package Level1.Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ///створим масив на 10^6 елементів, так як для 100 то буде не цікаво
        long start1 = System.currentTimeMillis();
        int[] array = new int[100000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }
        long start2 = System.currentTimeMillis();
        System.out.println("Ми завовнювали масив " + (start2- start1) + " мілісекунд");
        System.out.println("Рахуєм без потоків");
        start1 = System.currentTimeMillis();
        System.out.println(ArraySum.findSumWithoutUsingThreads(array));
        start2 = System.currentTimeMillis();
        System.out.println("ми рахували масив " + (start2- start1) + " мілісекунд");


        System.out.println("Рахуєм з потоками/  5 потоків");
        start1 = System.currentTimeMillis();
        int sum = 0;
        int threads = 5;
        int pointer = 0;
        List<Thread> threadList = new ArrayList<>();
        List<ArraySum> arraySums = new ArrayList<>();
        for (int i = 0; i < threads; i++) {
            ArraySum arraySum = new ArraySum(array, pointer, pointer + array.length/threads);
            Thread thread = new Thread(arraySum);
            arraySums.add(arraySum);
            threadList.add(thread);
            thread.start();
            pointer += array.length/threads;
        }
        for (int i = 0; i < threads; i++) {
            threadList.get(i).join();
            sum += arraySums.get(i).getSum();
        }
        System.out.println(sum);
        start2 = System.currentTimeMillis();
        System.out.println("ми рахували масив " + (start2- start1) + " мілісекунд");
    }
}
