package Level1;

public class Main {
    public static void main(String[] args) {

        for(int i = 0; i < 100; i++){
            Thread thread = new Thread(new Factorial());
            thread.setName(String.valueOf(i));
            thread.start();
        }
    }
}
