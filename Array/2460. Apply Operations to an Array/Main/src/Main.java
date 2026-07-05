import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,2,1,1,0};
        Solution s = new Solution();
        int arr[] = s.applyOperations(nums);
        System.out.println(Arrays.toString(arr));
    }
}

class Solution {
    public int[] applyOperations(int[] nums) {//0,1
        int k =0;
        int arr[] = new int[nums.length];
        Arrays.fill(arr,0);
        for (int i = 0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }
        }
        for (int i = 0;i<nums.length;i++){
            if(nums[i]!=0){
                arr[k++]=nums[i];
            }
        }
        return arr;
    }
}