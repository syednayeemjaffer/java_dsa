//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }
}

class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {

        if (left >= right)
            return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);

        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}

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
