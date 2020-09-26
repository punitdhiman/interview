package threads;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ProducerConsumerBQ {

    BlockingQueue<Integer> dataQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        ProducerConsumerBQ producerConsumer = new ProducerConsumerBQ();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()-> IntStream.range(0,10000).forEach(i->producerConsumer.produce(i)));
        executorService.submit(()-> IntStream.range(0,10000).forEach(i->producerConsumer.consume()));
        executorService.shutdown();
    }

    void produce(int value){
        try {
            dataQueue.put(value);
            System.out.printf("Produced %s\n",value);
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void consume(){
        Integer value = null;
        try {
            value = dataQueue.take();
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Consumed %s\n",value);

    }

}