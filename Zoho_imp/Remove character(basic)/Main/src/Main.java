import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {//a e i o u
    public static void main(String[] args) {
        int arr[] = {7, 1, 2, 3, 4, 5, 6};//7, 1, 6, 2, 5, 3, 4
        Solution s = new Solution();
        System.out.println(s.alternateSort(arr));
    }
}
class Solution {
    public static ArrayList<Integer> alternateSort(int[] arr) {
        Arrays.sort(arr);//1 2 3 4 5 6 7
        ArrayList<Integer> result = new ArrayList<>();
        int i=0,j=arr.length-1;
        while (i<j){
            result.add(arr[j--]);
            result.add(arr[i++]);
        }
        if(i == j)
            result.add(arr[i]);

        return result;
    }
}
