import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prime {
    public static void main(String[] args) {
        Prime prime= new Prime(100);
        prime.build();
        System.out.println(Arrays.toString(prime.data));
        List<Integer> actual = IntStream.range(2,100).filter(prime::isPrime).boxed().collect(Collectors.toList());
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
        System.out.println(actual);
        System.out.println(expected);
        System.out.println(actual.equals(expected));
    }
    final int size;
    final int sqrt;
    final int [] data;

    public Prime(final int size){
        this.size = size+1;
        this.data = new int[this.size];
        this.sqrt = (int)Math.sqrt(this.size);
        Arrays.fill(this.data,1);
    }

    void build(){
        for (int j = 2; j <=sqrt; j++)
            for(int i=j+j; i<size;i+=j) {
                if (data[i] == 1) {
                    data[i] = 0;
                }
            }
    }
    public boolean isPrime(int num){
        return data[num]==1;
    }
}
