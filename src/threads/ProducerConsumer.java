package threads;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ProducerConsumer {
    Stack<Integer> data = new Stack<>();
    int value = 1;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ProducerConsumer producerConsumer = new ProducerConsumer();
        executorService.submit(()->producerConsumer.consume());
        executorService.submit(()->producerConsumer.produce());
        executorService.shutdown();
    }

    synchronized void produce(){
        while(true) {
            try {
                while(!data.empty()) {
                    wait();
                }
                TimeUnit.SECONDS.sleep(1);
                System.out.printf("Pushed %s\n", value);
                data.push(value++);
                notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    synchronized void consume(){
        while(true) {
            try {
                while(data.empty()) {
                    wait();
                }
                TimeUnit.SECONDS.sleep(1);
                Integer value = data.pop();
                System.out.printf("Popped %s\n", value);
                notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
