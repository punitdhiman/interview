package lambda;

import java.util.List;
import java.util.function.Function;

public class Exception {
    public static void main(String[] args) {
        List<String> data = List.of("ABC","2");
        unhandled(data);
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
