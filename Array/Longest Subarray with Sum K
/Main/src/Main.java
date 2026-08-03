import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 7, 1, -10};int k = 15;
        Solution s = new Solution();
        System.out.println(s.longestSubarray(arr,k));
    }
}
class Solution {
    public int longestSubarray(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix = 0;
        int max = 0;
        for (int i = 0;i<arr.length;i++){
            prefix += arr[i];
            if (prefix == k){
                max = i+1;
            }
            if (map.containsKey(prefix-k)){
                max = Math.max(max,i-map.get(prefix-k));
            }
            if(!map.containsKey(prefix)){
                map.put(prefix,i);
            }
        }
        return max;
    }
}