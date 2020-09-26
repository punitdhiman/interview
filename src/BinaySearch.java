import java.util.Arrays;
import java.util.stream.IntStream;

public class BinaySearch {
    int search = 9;
    public static void main(String[] args) {
        int [] data = {2,4,3,6,7,8,12,7,18,20,22,26,28,30,31,33,35,38,44,566,889};
        Arrays.sort(data);
        BinaySearch binaySearch = new BinaySearch();
        for (int v:data) {
            int result = binaySearch.binarySearch(data,0,data.length-1,v);
            System.out.println("finall Result is "+v+" === "+result);
        }
        IntStream.range(15,40).forEach(i-> System.out.println(binaySearch.binarySearch(data,0,data.length-1,i)));
    }

    int binarySearch(int[] data,int left,int right, int value ){
        if(left>right){
            return -1;
        }
        int mid = left+((right-left)/2);

        if(data[mid] == value){
            return mid;
        }
        if(value < data[mid]){
            return binarySearch(data,left,mid-1,value);
        }
        if(value > data[mid]){
            return binarySearch(data,mid+1,right,value);
        }
        return -1;
    }
}
