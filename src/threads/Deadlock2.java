package threads;

import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock2 {

    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        Deadlock2 deadlock2 = new Deadlock2();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->deadlock2.m1());
        executorService.submit(()->deadlock2.m2());
        executorService.shutdown();
/*        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Arrays.toString(ManagementFactory.getThreadMXBean().findDeadlockedThreads()));
        }*/
    }
    public void m1(){
        lock1.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock2.lock();
        System.out.println("called m1");
        lock2.unlock();
        lock1.unlock();
        System.out.println("released m1");
    }
    public void m2(){
        lock2.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock1.lock();
        System.out.println("called m2");
        lock1.unlock();
        lock2.unlock();
        System.out.println("released m2");

    }
}
