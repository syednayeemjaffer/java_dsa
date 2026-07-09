public class Main {//a e i o u
    public static void main(String[] args) {
        int nums[] = {-1,0,3,5,9,12,20,40};// 5 8 12
        int target = 40;
        Solution s = new Solution();
        System.out.println(s.search(nums,target));
    }
}
class Solution {

    static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high-low) / 2);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                low = mid +1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

}