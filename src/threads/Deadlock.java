package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Deadlock {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->deadlock());
        executorService.submit(()->deadlock1());
    }

    public static void deadlock(){
        while(true)
        synchronized (Integer.class){
            System.out.println("locked Integer");
            synchronized (String.class) {
                System.out.println("locked String");
                synchronized (String.class) {
                    System.out.println("locked Integer Again");
                }
            }
        }
    }
    public static void deadlock1(){
        while(true)
            synchronized (String.class){
                System.out.println("locked Integer");
                synchronized (Integer.class) {
                    System.out.println("locked String");
                    synchronized (String.class) {
                        System.out.println("locked Integer Again");
                    }
                }
            }
    }
}

//class Account
