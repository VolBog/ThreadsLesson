package Level1.Task3;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadShell {
    List<Thread> threadList = new ArrayList<>();
    List<ShellThread> shellThreads = new ArrayList<>();
    private int numberOfThreads = 2;

    public void sortArray(int[] array) throws InterruptedException {
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
    }


}
