import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr[] = {4,6,2,1,7,3,8,0};
        Quicksort q = new Quicksort();
        q.quicksort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}

class Quicksort {
    public static void quicksort(int arr[],int low,int high){
        if(low>=high)
            return;
        
        int start = low;
        int end = high;
        int mid = (start+end)/2;
        int pivot = arr[mid];

        while (start<=end){
            while (arr[start]<pivot){
                start++;
            }
            while(arr[end]>pivot){
                end--;
            }
            if(start<=end){
                int temp = arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
        quicksort(arr,low,end);
        quicksort(arr,start,high);

    }
}