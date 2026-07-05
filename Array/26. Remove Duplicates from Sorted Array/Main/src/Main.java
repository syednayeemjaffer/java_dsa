import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {0,1,2,2,3};
        Solution s = new Solution();
        int k = s.removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[k-1]){
                nums[k]=nums[i];
                k++;
            }
        }

        return k;
    }
}