import java.util.*;

public class Main {
    public static void main(String[] args) {
        int nums[] = {3,2,4};int target = 6;
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(nums,target)));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map= new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            int extra = target -nums[i] ;
            if(map.containsKey(extra)){
                return new int[]{map.get(extra),i};
            }
            map.put(nums[i],i);
        }
        return new int[] {};
    }
}