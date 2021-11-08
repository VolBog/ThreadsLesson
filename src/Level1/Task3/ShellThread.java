package Level1.Task3;

import java.util.Arrays;

public class ShellThread implements Runnable {
    private int[] array;
    private int start;
    private int stop;

    public ShellThread(int[] array, int start, int stop) {
        this.array = array;
        this.start = start;
        this.stop = stop;
    }

    public void arraySort() {
        int n = stop - start;
        System.out.println(n);
        for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int i = start; i < stop; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= interval && array[j - interval] >
                        temp; j -= interval)
                    array[j] = array[j - interval];
                array[j] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void run() {
        arraySort();
    }
}