import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int []nums = {0,4,8,3,2,10,1,1,8,12,11,9,7};
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(nums));
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new TreeSet<>();
        for (int num : nums){
            set.add(num);
        }
        int max = 1;
        for (int num : set){
            if (set.contains(num-1)){
                int current = num;
                int maxCount = 1;
                while (set.contains(current)){
                    current++;
                    maxCount++;
                }
                max = Math.max(max,maxCount);
            }
        }
        return max;
    }
}