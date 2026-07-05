import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7};
        int k = 3;
        Solution s = new Solution();
        s.rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }
}
//[1, 2, 3, 4, 5, 6, 7]
//[5,6,7,1,2,3,4]
class Solution {
    public void rotate(int[] nums, int k) {
        int l = nums.length-1;
        k = k % nums.length;
        reverse(nums,0,l);
        reverse(nums,0,k-1);
        reverse(nums,k,l);


    }

    public static void reverse(int nums[],int k,int l){
        int i = k;
        int j = l;
        while (i<j){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}