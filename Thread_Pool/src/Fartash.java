import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fartash {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i =  0; i <  100; i++) {
                    System.out.println("thread 1");
                }
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i =  0; i <  100; i++) {
                    System.out.println("thread 2");
                }
            }
        });
        executor.shutdown();

    }
}
