import java.lang.reflect.Array;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int arr [] = {4,3,2,5};
        MergeSort.mergesort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}

class MergeSort {
    public static void mergesort(int[]arr,int left,int rigth){
        if(rigth-left == 1){
            return;
        }
        int mid = (left+rigth)/2;
        mergesort(arr,left,mid);
        mergesort(arr,mid,rigth);

        sort(arr,left,mid,rigth);
    }

    private static void sort(int []arr,int left,int mid,int right){
        int join[] = new int[right-left];
        int i = left , j = mid , k =0;

        while (i<mid && j<right){
            if(arr[i]<arr[j]){
                join[k++]=arr[i++];
            }else {
                join[k++]=arr[j++];
            }
        }

        while (i<mid){
            join[k++]=arr[i++];
        }
        while (j<right){
            join[k++]=arr[j++];
        }

        for (k = 0;k<join.length;k++){
            arr[left+k] = join[k];
        }
    }
}
//class MergeSort {
//    public static int[] mergesort(int []arr){
//        if(arr.length == 1){
//            return arr ;
//        }
//        int mid = arr.length / 2;
//
//        int left[] = mergesort(Arrays.copyOfRange(arr,0,mid));
//        int right[] = mergesort(Arrays.copyOfRange(arr,mid,arr.length));
//
//        return sort(left,right);
//    }//3 4
//    // 2 5
//    private static int[] sort(int left[],int rigth[]){
//        int join[] = new int[left.length + rigth.length];
//        int i = 0,j=0,k=0;
//        while (i<left.length && j<rigth.length){
//            if (left[i]<rigth[j]){
//                join[k++]=left[i++];
//            }else {
//                join[k++]=rigth[j++];
//            }
//        }
//        while (i<left.length)
//            join[k++]=left[i++];
//
//        while (j<rigth.length)
//            join[k++]=rigth[j++];
//
//        return join;
//
//    }
//}

//mergeSort(0,4)
//L=0 R=4 M=2
//Array: [4 2 3 5 1]
//
//        (0,4,M=2)
//        [4 2 3 5 1]
//        /           \
//        (0,2,M=1)       (3,4,M=3)
//        [4 2 3]          [5 1]
//        /     \          /    \
//        (0,1,M=0)  (2,2)   (3,3)   (4,4)
//        [4 2]      [3]      5       1
//        /   \
//        (0,0) (1,1)
//        4      2
//
//        ------------------ DIVIDE COMPLETE ------------------
//
//Merge (0,0) + (1,1)
//        4 + 2
//        ↓
//        2 4
//
//Merge (0,1) + (2,2)
//        2 4 + 3
//        ↓
//        2 3 4
//
//Merge (3,3) + (4,4)
//        5 + 1
//        ↓
//        1 5
//
//Merge (0,2) + (3,4)
//        2 3 4 + 1 5
//        ↓
//        1 2 3 4 5
//
//
//mergeSort(0,4)
//
//mergeSort(0,2)
//
//mergeSort(0,1)
//
//mergeSort(0,0)
//            return
//
//mergeSort(1,1)
//            return
//
//merge(0,0,1)   ← FIRST MERGE
//
//mergeSort(2,2)
//        return
//
//merge(0,1,2)       ← SECOND MERGE
//
//mergeSort(3,4)
//
//mergeSort(3,3)
//        return
//
//mergeSort(4,4)
//        return
//
//merge(3,3,4)       ← THIRD MERGE
//
//merge(0,2,4)           ← FINAL MERGE
