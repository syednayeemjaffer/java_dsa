public class Main {
    public static void main(String[] args) {
        int [][] grid = {{3,-1,-3,-3,-3},{2,-2,-3,-3,-3},{1,-2,-3,-3,-3},{0,-3,-3,-3,-3}};
        Solution s = new Solution();
        System.out.println(s.countNegatives(grid));
    }
}

class Solution {
    public int countNegatives(int[][] grid) {
        int out = 0;
        for (int i = 0;i<grid.length;i++){
            int pos = binary(grid[3],0);
            out += grid[i].length - pos;
        }
        return out;
    }
    public int binary(int [] nums,int target){
        int low = 0,high = nums.length - 1,result = 0;
        if(nums[nums.length-1] >= 0){
            return nums.length;
        }
        if(nums[0] < 0){
            return 0;
        }
        while (low<=high){
            int mid = low + ((high-low)/2);
            if(nums[mid] > target){
                low = mid + 1;
            }else {
                result = mid;
                high = mid - 1;
            }
        }
        return result;
    }
}