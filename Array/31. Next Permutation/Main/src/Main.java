import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[]nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        Solution s = new Solution();
        s.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        // Step 1: Find pivot
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        // Step 2: No next permutation
        if (pivot == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // Step 3: Find successor from the RIGHT
        int succ = 0;
        for (int i = nums.length - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                succ = i;
                break;
            }
        }
        // Step 4: Swap
        int temp = nums[pivot];
        nums[pivot] = nums[succ];
        nums[succ] = temp;
        // Step 5: Reverse suffix
        reverse(nums, pivot + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}