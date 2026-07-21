//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int arr[] = {4,6,2,1,0,7,3};
        Solution s = new Solution();
        s.insertion(arr);
    }
}

class Solution {
    public void insertion(int arr[]) {
        for (int i = 1;i<arr.length;i++){
            int key = arr[i];
            int j = i-1;

            while (j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=key;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}