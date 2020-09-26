import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] data = {11, 1, 17, 19, 23, 29,  43, 471, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,6};
        mergeSort.mergeSort(data);
        System.out.println(Arrays.toString(data));
    }
    //[31, 37, 41, 2, 3, 5, 7]7 4
    //[31, 37, 41, 2, 3, 5]6 3
    // //, 11, 13, 17, 19, 23, 29,  43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,6]

    void mergeSort(int[] data){
        if(data.length==1){
            return;
        }
        int middle = data.length/2;
        int [] left = new  int[middle];
        int [] right = new  int[data.length-middle];

        int source = 0;
        for(int index = 0 ;index<left.length;index++){
            left[index] = data[source++];
        }
        for(int index = 0 ;index<right.length;index++){
            right[index] = data[source++];
        }
        mergeSort(left);
        mergeSort(right);
        merge(data,left,right);
    }

    void merge(int[] data, int[] left, int[] right){
        int dataIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while(leftIndex<left.length&&rightIndex<right.length){
            if(left[leftIndex]<=right[rightIndex]){
                data[dataIndex++] = left[leftIndex++];
            }else{
                data[dataIndex++] = right[rightIndex++];
            }
        }
        while(leftIndex<left.length){
            data[dataIndex++] = left[leftIndex++];
        }
        while(rightIndex<right.length){
            data[dataIndex++] = right[rightIndex++];
        }

    }
}
