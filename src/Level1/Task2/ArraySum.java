package Level1.Task2;

public class ArraySum implements Runnable{
    private int[] array;
    private int start;
    private int stop;
    private int sum;

    public ArraySum() {
    }

    public ArraySum(int[] array, int start, int stop) {
        this.array = array;
        this.start = start;
        this.stop = stop;
    }

    public static int findSumWithoutUsingThreads(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    public int findSumWithTheads(){
        int sum = 0;
        for (int i = start; i < stop; i++) {
            sum += array[i];
        }
        return sum;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public void run() {
        this.sum = findSumWithTheads();
    }
}
