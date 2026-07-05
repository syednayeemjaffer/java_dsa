import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int []nums = {0,1,0,3,12};// 1 0 3 4 0
        Solution s = new Solution();// 4 3 0 1 0
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
    public void moveZeroes(int[] nums) {

        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != 0) {

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }
    }
}