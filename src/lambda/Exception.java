package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Exception {
    public static void main(String[] args) {
        List<String> data = List.of("ABC","2");
        //unhandled(data);

        ArrayList<Integer> longList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            longList.add(i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->{
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("removing");
            longList.remove(18);
        });
        executorService.submit(()->{
            longList.stream().forEach(i->{
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            });
        });
        executorService.shutdown();
    }

    static void unhandled(List<String> data){
        data.stream().map(handled(Integer::parseInt)).forEach(System.out::println);
    }

    static Function<String,Integer>  handled(Function<String,Integer> unhandled){
        return d->{
            try{
                return unhandled.apply(d);
            }catch(Throwable ex){
               // ex.printStackTrace();
                return 0;
            }
        };
    }
}
