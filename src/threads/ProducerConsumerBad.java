package threads;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ProducerConsumerBad {
    Stack<Integer> data = new Stack<>();
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ProducerConsumerBad producerConsumer = new ProducerConsumerBad();
        executorService.submit(()->IntStream.range(1,10000).forEach(i->producerConsumer.consume()));
        executorService.submit(()->IntStream.range(1,10000).forEach(i->producerConsumer.produce(i)));
        executorService.shutdown();
    }

    void produce(int value){
        System.out.printf("Pushed %s\n",value);
        data.push(value);
    }
    void consume(){
        try {
            Integer value = data.pop();
            System.out.printf("Popped %s\n",value);

        }catch (RuntimeException e){
            System.out.printf("Exception in Popped \n");
        }
    }
}
