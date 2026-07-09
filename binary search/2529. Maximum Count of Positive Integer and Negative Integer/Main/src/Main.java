public class Main {
    public static void main(String[] args) {
        int [] nums = {-1,0,3,5,6,8,11,12};
        Solution s = new Solution();
        System.out.println(s.maximumCount(nums));
    }
}

class Solution {
    public int maximumCount(int[] nums) {
        int negCount = binarySearch(nums, 0);
        int posCount = nums.length - binarySearch(nums, 1);
        return Math.max(negCount, posCount);
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = nums.length;

        while (left <= right) {
            int mid = left + ((right-left)/2);
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }
}