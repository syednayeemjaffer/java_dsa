import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int arr[] = {0,1,2,2,3,0,4,2};//0,1,3,0,4
        Solution s = new Solution();
        int k = s.removeElement(arr,2);
        System.out.println(Arrays.toString(arr));
        System.out.println(k);
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i=0;i<nums.length;i++){
            if(nums[i] != val){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                j++;
            }
        }
        return  j;
    }
}