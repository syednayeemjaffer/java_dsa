//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int nums[] = {11,13,14,15,17};
        Solution s = new Solution();
        System.out.println(s.findMin(nums));
    }
}

class Solution {
    public int findMin(int[] nums) {
        int low = 0,high=nums.length-1,out = Integer.MAX_VALUE;
        while (low <= high){
            int mid = low +  (high-low) / 2;
            if(nums[low] <= nums[mid]){
                out = Math.min(out,nums[low]);
                low = mid +1;
            }else {
                out = Math.min(out,nums[mid]);
                high = mid -1;            }
        }
        return out;
    }
}