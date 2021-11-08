package Level1.Task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiThreadShell {
    List<Thread> threadList = new ArrayList<>();
    List<ShellThread> shellThreads = new ArrayList<>();
    private int numberOfThreads = 2;

    public MultiThreadShell() {
    }

    public MultiThreadShell(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public int[] sortArray(int[] array) throws InterruptedException {
        int pointer = 0;
        for (int i = 0; i < numberOfThreads; i++) {
            ShellThread shellThread;
            if ((i + 1) == numberOfThreads) {
                shellThread = new ShellThread(array, pointer, array.length);
            } else {
                shellThread = new ShellThread(array, pointer, pointer + array.length / numberOfThreads);
            }
            Thread thread = new Thread(shellThread);
            shellThreads.add(shellThread);
            threadList.add(thread);
            thread.start();
            pointer += array.length / numberOfThreads;
        }
        for (int i = 0; i < numberOfThreads; i++) {
            threadList.get(i).join();
        }
        return merge(array);
    }

    public int[] merge(int[] array) {
        int[] result = new int[array.length];
        int[] indexes = new int[numberOfThreads];
        for (int i = 0; i < array.length; i++) {
            int index = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < indexes.length; j++) {
                if (indexes[j] >= array.length / numberOfThreads && j != indexes.length - 1) {
                    continue;
                }
                try {
                    if (array[indexes[j] + j * array.length / numberOfThreads] <= min) {
                        min = array[indexes[j] + j * array.length / numberOfThreads];
                        index = j;
                    }
                } catch (IndexOutOfBoundsException e){
                    continue;
                }
            }
            result[i] = min;
            indexes[index] = indexes[index] + 1;
        }

        return result;
    }


}
